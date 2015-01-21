import math #for exponent 

def equation1(x,y): #x=actual rating,y=true rating
	x_y = x - y
	partPersonality = math.exp(-(x_y)*(x_y)/12.5) # 12.5 = 2 sigma^2 where sigma = free parameter
	return partPersonality

print equation1(2,2)
