args <- commandArgs(trailingOnly = TRUE)
source('funcs.R', encoding = "UTF8")

selVals <- strsplit(args[4],", ")[[1]]
selParams <- strsplit(args[5],", ")[[1]]

mainFunc(args[2], args[3], as.numeric(selVals), selParams, args[6])
