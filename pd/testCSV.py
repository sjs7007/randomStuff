#Code to store a column in a list
import csv
with open('BookDB.csv', 'rb') as f:
    reader = csv.reader(f)
    for col in reader:
        print col[3] ,
 
