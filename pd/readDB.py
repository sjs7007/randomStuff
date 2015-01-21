import csv 
allUsers=[]
for i in range (2,32):
	temp=[]
	with open('BookDB.csv', 'rb') as f:
    		reader = csv.reader(f)
    		for col in reader:
        		temp.append(col[i])
    	allUsers.append(temp)
	print allUsers[i-2]

