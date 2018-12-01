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

random.seed(6223) # so we can make random values consistent

"""
The Randomized Response Mechanism. Will perturb data values with probability p and q.

Same setup as Assignment 2, we flip a coin and if it's tails (prob_p) we give the data value d. 
However, if it's heads (prob_q), then we flip another coin and give answer "1" for heads and 
"0" for tails. This means we have values 0 <= d <= 1.

"""
def RR(p, q, data):
    if (random() < p):
        return data
    elif (random() < q):
        return 1
    else:
        return 0



def clean_up():
    # read csv file
    dataframe = pd.read_csv("data/adult.data")

    # assign columns for the DataFrame
    dataframe.columns = [
        "Age", "Workclass", "Fnlwgt", "Education", "Education-Number",
        "Marital-status", "Occupation", "Relationship", "Race", "Gender",
        "Capital-Gain", "Capital-Loss", "Hoursperweek", "Native-Country", "Class"
    ]

    return dataframe

    # print(dataframe)


df = clean_up()
print(df)