args <- commandArgs(trailingOnly = TRUE)
source('funcs.R', encoding = "UTF8")


selParams <- strsplit(args[4],", ")[[1]]
vals <- fread (paste0(dirname(args[2]), .Platform$file.sep, "selvals.txt"))
selVals <- as.double(vals[1,])
print(args[2])
print(args[3])
print(selVals)
print(selParams)
print(args[5])
mainFunc(args[2], args[3], selVals, selParams, args[5])
