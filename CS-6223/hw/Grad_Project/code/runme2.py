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
The Laplace Mechanism Function

Perturbs a data value by the Laplace Distribution given an epsilon e and function f. Lap(f/e)

"""
def laplace(data, f, e):
    data += f(data) # get the data value after it goes through the function f 
    data += np.random.laplace(0, 1.0/e) # then add a Laplace Random variable controlled by epsilon
    return data


def count_query(data, f, e):
    return laplace(data, f, e)

def laplace_noise(row, col,e):
    noise = np.random.laplace(0, e, [row, col])
    # print(noise + "\n" + len(noise))
    return noise



def clean_up():
    # read csv file
    dataframe = pd.read_csv("data/adult.data")

    # assign columns for the DataFrame
    dataframe.columns = [
        "Age", "Workclass", "Fnlwgt", "Education", "Education-Number",
        "Marital-status", "Occupation", "Relationship", "Race", "Gender",
        "Capital-Gain", "Capital-Loss", "Hoursperweek", "Native-Country", "Class"
    ]

    # drop data columns with continous variables
    dataframe.drop(["Age", "Fnlwgt", "Education-Number", "Capital-Gain", "Capital-Loss", "Hoursperweek"], axis=1, inplace=True,)

    return dataframe

    # print(dataframe)


dataframe = clean_up()

num_rows = dataframe.shape[0]
num_cols = dataframe.shape[1]

noise = laplace_noise(num_rows, num_cols, 0.1)

# print(dataframe)