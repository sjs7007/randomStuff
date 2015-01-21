# program portion to calculate probability that active user is of same personality types as some other user
import math #for exponent 
import csv #for reading csb database

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
#print allUsers


def equation1(x,y): #x=actual rating,y=true rating
	x_y = x - y
	partPersonality = math.exp(-(x_y)*(x_y)/12.5) # 12.5 = 2 sigma^2 where sigma = free parameter
	return partPersonality

nUsers = 30 #number of users
nReviews = 25 #number of reviews
currentUser = ['ActiveUser','3','1','null','5','5','3','5','3','5','3','null','null','5','3','1','5','null','null','null','3','null','null','null','1','3'] #make an list like allUsers ka ind. list with null for each unrated one
probabilityList = [] #probability that current user is similar to ith user

for i in range (0,nUsers):
	probabilityList.append(1)
	for j in range (1,nReviews+1): #NOTE : Start from 1 because 1st coloumn has userNumber
		temp = currentUser[j]# current user's rating for jth movie
		# if temp=null,probability list[i]=0 for that
		if (temp!="null"):
			x=float(temp)
			y = float(allUsers[i][j]) #rating of ith user for jth movie
			probabilityList[i] = probabilityList[i] * equation1(x,y)
		
	if(temp!='null'):
		probabilityList[i] = probabilityList[i] * 1.0 /nUsers
	else:
		probabilityList[i] = 0

print "Just printed PL"
print probabilityList

#booknumber=int(raw_input("Enter book number for which you want predicted rating"))
for x in range(1,26):
	if currentUser[x]=="null":
	 	booknumber=x
	 	probabilityDistResult=[]
		for i in range (0,5):
			probabilityDistResult.append(0)
			for j in range (0,nUsers):
				x = i+1 # i+1 for rating 1,2,3,4,5 
				y = float(allUsers[j][booknumber]) #assume 3rd movie's rating we are finding out for now
				probabilityDistResult[i] = probabilityDistResult[i] + equation1(x,y) * probabilityList[j]

		temp = probabilityDistResult[0]
		finalRating = 1
		for i in range (1,5):
			if (probabilityDistResult[i]>=temp):
				temp = probabilityDistResult[i]
				finalRating = i+1

		print "Final rating for book number" , booknumber
		print finalRating
#print("Final Rating : $d" %finalRating)

