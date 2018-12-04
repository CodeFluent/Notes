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
from numpy.random import random

np.random.seed(6223) # so we can make random values consistent

"""
The Randomized Response Mechanism. Will perturb data values with probability p and q.

Same setup as Assignment 2, we flip a coin and if it's tails (prob_p) we give the data value d. 
However, if it's heads (prob_q), then we flip another coin and give answer "1" for heads (prob_q) and 
"0" for tails (prob_p). This means we have values 0 <= d <= 1.

p and q must equal 1

"""
def RR(p, q, data):
    if (p + q == 1):
        if (random() < p):
            return data
        elif (random() < q): # got heads, flip another coin
            return 1
        else:
            return 0 # got tails instead for the second flip
    else:
        print("Error! Please pick a p and q value that sum to 1.")


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


# create a randomized response matrix with the same size as the dataframe
noise = RR(.3, .7, dataframe)
print(noise)

# add the dataframe and noise together. This is the resulting output dataset
dataframe = dataframe + noise

dataframe.to_csv("RR_output.csv", index=False)

# print(dataframe)
