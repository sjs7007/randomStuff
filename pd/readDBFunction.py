import csv

def readDB(allUsers,fileName): 
	for i in range (2,32):
		temp=[]
		with open(fileName, 'rb') as f:
	    		reader = csv.reader(f)
	    		for col in reader:
	        		temp.append(col[i])
	    	allUsers.append(temp)
		#print allUsers[i-2]

allUsers=[]
readDB(allUsers,'BookDB.csv')
for i in allUsers:
	print i
