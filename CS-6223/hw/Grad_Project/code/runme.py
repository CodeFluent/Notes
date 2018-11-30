"""

runme.py

A project to use the UCI machine learning dataset and add privacy to the values.

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


dataframe = pd.read_csv("data/adult.data", header=None)

dataframe.columns = [
    "Age", "Workclass", "Fnlwgt", "Education", "Education-Number",
    "Marital-status", "Occupation", "Relationship", "Race", "Gender",
    "Capital-Gain", "Capital-Loss", "Hoursperweek", "Native-Country", "Class"
]

# input_csv = pd.read_csv("data/adult.data", header=None)

# dataframe = pd.DataFrame(input_csv, columns= [
#     "Age", "Workclass", "Fnlwgt", "Education", "Education-Number",
#     "Marital-status", "Occupation", "Relationship", "Race", "Gender",
#     "Capital-Gain", "Capital-Loss", "Hoursperweek", "Native-Country", "Class"
# ])

print(dataframe)


