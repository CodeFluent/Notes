require("ggplot2")
require("lattice")

cars <- read.csv("04cars.csv")

dealer <- cars$Dealer_cost
msrp <- cars$MSRP

# Basic Plots
plot(dealer, msrp, main = "Correlation between dealer price and msrp", xlab = "dealer price (in dollars)", ylab = "msrp (in dollars)")

dotchart(cars$Horsepower, labels = unique(cars$Vehicle_Name), cex = .2, main = "Horsepower for Different Cars", xlab = "Horsepower")

# ggplot2
qplot(Horsepower, 
      data = cars, 
      geom = "density", 
      fill= Horsepower, 
      alpha =I(.5), 
      main = "Distribution of number of cylinders and horsepower", 
      xlab = "Number_of_cylinders", 
      ylab = "Horsepower" )

qplot(cars$City_miles_per_gallon, 
      cars$Wheel_Base_.inches., 
      data = cars, 
      facets = cars$All.Wheel_Drive ~ cars$Rear.Wheel_Drive,
      main = "Plot Matrix separating different drive types (0 for All Wheel and 1 for Rear Wheel)",
      xlab = "Miles per gallon",
      ylab = "Wheel Base (in inches)")

# Lattice

densityplot(~msrp, main = "Density Plot by MSRP", xlab = "MSRP", ylab = "Density")

barchart(cars$Width_.inches.~cars$Length_.inches., main = "Relationship of Car Length and Width", xlab = "car length", ylab = "car width")
