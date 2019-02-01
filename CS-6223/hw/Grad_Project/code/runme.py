"""

runme.py

Runner file to use the mechanism to protect values in a dataset.

Made by Wasfi Momen.

"""

"""
REQUIREMENTS:
    - Extract attribute value of each individual out as ground truth (clean the data and get original database D)
    - Inject noise (any type of noise you want, not limited to differential noise) to this dataset D to make D'
    - Preserve privacy-utility tradeoff

"""

import numpy as np
import pandas as pd

np.random.seed(6223) # so we can make random values consistent

"""
laplace_noise() creates a matrix of Laplacian noise given the number of rows and columns of the 
dataset to be perturbed. Can edit epsilon value e to adjust.
"""
def laplace_noise(row, col, e):
    noise = np.random.laplace(0, e, [row, col])
    # print(noise)
    # print(len(noise))
    return noise


"""
clean_up() handles the dataprocessing to extract the dataset D. For use with Laplacian noise,
we must drop con
"""
def clean_up():
    # read csv file
    dataframe = pd.read_csv("data/adult.data", delimiter=',', skipinitialspace=True,)

    # assign columns for the DataFrame
    dataframe.columns = [
        "Age", "Workclass", "Fnlwgt", "Education", "Education-Number",
        "Marital-status", "Occupation", "Relationship", "Race", "Gender",
        "Capital-Gain", "Capital-Loss", "Hoursperweek", "Native-Country", "Class"
    ]

    # drop data columns with continous variables, they have very few unique values unlike the other columns
    # not dropping them and perturbing them results in the program crashing.
    dataframe.drop(["Age", "Fnlwgt", "Education-Number", "Capital-Gain", "Capital-Loss", "Hoursperweek"], axis=1, inplace=True)

    # map our protected value to either -1 or 1
    # this provides the two extreme truth values that Laplacian noise will disturb
    dataframe.Class = dataframe.Class.map(({ "<=50K": -1, ">50K": 1 }))

    # turn all categorical values to dummies. Some distance based on categorical or other way might've been better.
    dataframe = pd.get_dummies(dataframe, columns=["Workclass", "Education", 
        "Marital-status", "Occupation", "Relationship", "Race", "Gender", "Native-Country"])
    
    return dataframe



dataframe = clean_up()

print("Dataset D:\n")
print(dataframe)


num_rows = dataframe.shape[0]
num_cols = dataframe.shape[1]

# !!!!MODIFY EPISILON HERE!!! if you wish by changing .1 to whatever value
# create a laplace_noise matrix with the same size as the dataframe
# noise = laplace_noise(num_rows, num_cols, np.log(3))
noise = laplace_noise(num_rows, num_cols, .1)


# add the dataframe and noise together. This is the resulting output dataset
dataframe = dataframe + noise

dataframe.to_csv("LP_output.csv", index=False)

print("Perturbed Dataset D':\n")
print(dataframe)
