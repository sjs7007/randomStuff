# program portion to calculate probability that active user is of same personality types as some other user
import math #for exponent 

def equation1(x,y): #x=actual rating,y=true rating
	x_y = x - y
	partPersonality = math.exp(-(x_y)*(x_y)/12.5) # 12.5 = 2 sigma^2 where sigma = free parameter
	return partPersonality

nUsers = #number of users
nReviews = #number of reviews
probabilityList = []

for i in range (0,nUSers):
	for j in range (0,nReviews):
		x = #actual
		y = # true
		probabilityList[i] = probabilityList[i] * equation1(x,y)
	
	probabilityList[i] = probabilityList[i] * 1 / nUsers;


