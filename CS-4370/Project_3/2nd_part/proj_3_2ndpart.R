require(ggplot2)
require(lattice)

toilet <- read.csv("latest-csv-export.csv")


# Basic plots

hist(toilet$Postcode, main = "Toilets per Postcode in Austrailia", xlab = "PostCode")
plot(toilet$Longitude, toilet$Latitude, main = "Latitude and Longitude Scatterplot of Toilets", xlab = "Longitude", ylab = "Latitude")

# ggPlot2
qplot(toilet$State, 
      data = toilet, 
      geom = "auto", 
      main = "Number of Toilets Per State", 
      xlab = "State", 
      ylab = "Number of Toilets" )

qplot(toilet$Postcode, 
      toilet$DrinkingWater, 
      data = toilet, 
      facets = toilet$ToiletType~toilet$AccessLimited, 
      main = "Toilet Type with Access to Drinking Water", 
      xlab = "PostCode", 
      ylab = "Drinking Water")

# lattice

densityplot(~toilet$Postcode, main = "Distribution of toilets over PostCode", xlab = "Postcode")
bwplot(toilet$Postcode~toilet$State, main = "Range of PostCodes per State", xlab = "State", ylab = "PostCode")
