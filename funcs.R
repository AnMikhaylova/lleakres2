#install.packages("data.table")
#install.packages("dplyr")
#install.packages("readr")
#install.packages("ggplot2")
library(dplyr)
library(readr)
library(ggplot2)
library(data.table)

#--------------------------------------------------------
readChan <- function(chPath, metaPath){
  ch <-fread(chPath)
  meta <- read_delim(metaPath,  delim = ";", col_names = FALSE, trim_ws = TRUE, show_col_types = FALSE)
  colnames(ch)<-meta[[2]]
  return(ch)
}
#---------------------------------------------------------

newDF <- function(df, vals, params, flag){
  #flag = p - профиль
  #flag = d - динамика
  params <- c (params, c("x","t"))
  new <- switch (flag,
                 "d" = select(df, params) %>% filter(x %in% vals),
                 "p" = select(df, params) %>% filter(t %in% vals)
  )
  return(new)
}
#--------------------------------------------------

drawPlot <- function(df, meta, path_name, vals, params, flag){
  chName <- basename(path_name)
  downloadPath <- dirname(path_name)
  downloadPath <- paste0(dirname(path_name), .Platform$file.sep, "pics")
  dir.create(downloadPath)
  name <- paste0(chName, "_", flag, "_") 
  subTitle <- paste("канал", chName)
  for (elem in vals){
    d <- switch(flag, "d" = {
      label <- paste("Динамика в точке", elem, "м")
      filter(df, x == elem)
    }, 
    "p" = {
      label <- paste("Профиль в момент времени", elem, "с")
      filter(df, t == elem)
    })
    
    for(param in params){
      name <-paste0(name, elem, "_", param,".png")
      unit <- as.character(filter(meta,  meta[2] == param)[4])
      if (!is.na(unit)){
        yLabel <- paste(param,", ", unit)
      }
      else
        yLabel <- param
      
      
      g <- switch(flag, 
                  "d" = ggplot(data = d) + geom_line(mapping = aes_string(x = "t", y = param)) 
                  + labs(title = label, subtitle = subTitle, x = "t, с", y = yLabel)
                  + theme_bw() +  theme(plot.subtitle = element_text(margin = margin(b = 10))), 
                  "p" = ggplot(data = d) + geom_line(mapping = aes_string(x = "x", y = param)) 
                  + labs(title = label, subtitle = subTitle, x = "x, м", y = yLabel)
                  + theme_bw() +  theme(plot.subtitle = element_text(margin = margin(b = 10))))
      
      ggsave(filename=name, plot=g, path = downloadPath)
      name <- paste0(chName, "_", flag, "_") 
    }
  }
}
#-------------------------------------------------------

mainFunc <- function(chan, meta, selVals, selParams, flag){
  DF <- readChan(chan, meta)
  meta <- read_delim(meta, delim = ";", escape_double = FALSE, col_names = FALSE, trim_ws = TRUE)  
  testDF <- newDF(DF, selVals, selParams, flag)
  #size <- length(strsplit(chan, "[\\\/]")[[1]])
  #name <- strsplit(chan, "[\\\/]")[[1]][size]
  drawPlot(testDF, meta, chan, selVals, selParams, flag)
}

