# program portion to calculate probability that active user is of same personality types as some other user
import math #for exponent 
import csv #for reading csb database
#all below for xml
import urllib2
from xml.dom import minidom
import sys

def readDB(allUsers,fileName): 
	for i in range (2,32):
		temp=[]
		with open(fileName, 'rb') as f:
	    		reader = csv.reader(f)
	    		for col in reader:
	        		temp.append(col[i])
	    	allUsers.append(temp)
		#print allUsers[i-2]


def bookData(ISBN):
	#ISBN="0441172717"
	APIKey="G0YLe4KJic94J0Bi0zeBQ" #Enter your own key here
	url="https://www.goodreads.com/book/isbn?isbn="+ISBN+"&key="+APIKey

	#PageSource=urllib2.urlopen("https://www.goodreads.com/book/isbn?isbn=0441172717&key=X").read()
	PageSource=urllib2.urlopen(url).read()
	text_file = open("Output.xml", "w")
	text_file.write("%s" %PageSource)
	text_file.close()

	#now read from xml file and display output

	output=""
	xmldoc = minidom.parse('Output.xml')
	itemlist = xmldoc.getElementsByTagName('original_title') 
	print "Title :-"
	print itemlist[0].childNodes[0].nodeValue
	print "-------------"
	output=output+itemlist[0].childNodes[0].nodeValue+"\n"

	xmldoc = minidom.parse('Output.xml')
	itemlist = xmldoc.getElementsByTagName('name') 
	print "Author :-"
	print itemlist[0].childNodes[0].nodeValue
	print "-------------"
	output=output+itemlist[0].childNodes[0].nodeValue+"\n"

	xmldoc = minidom.parse('Output.xml')
	itemlist = xmldoc.getElementsByTagName('description') 
	print "Description :-"
	print itemlist[0].childNodes[0].nodeValue
	print "-------------"
	output=output+itemlist[0].childNodes[0].nodeValue+"\n"

	itemlist = xmldoc.getElementsByTagName('average_rating') 
	print "Average Rating on GoodReads :-"
	print itemlist[0].childNodes[0].nodeValue
	print "-------------"
	output=output+itemlist[0].childNodes[0].nodeValue+"\n"

	text_file = open("output.txt", "w")
	text_file.write("%s" %output)
	text_file.close()



allUsers=[]
readDB(allUsers,'BookDB.csv')
#print allUsers

Booklists=['BookName','Asylum','Fire and blood','Twisted sisters','Moth and Spark','Dangerous Illusions','The Black-Eyed Blonde','The ghost runner','Dead silent','Before we met','I forgot to remember','Sixth extinction','Wild Things','Alienated','Annhilation','Flight of the silvers','Influx','Tuesdays with Morrie','The alchemist','The fountainhead','Jonathan Livingston Seagull','Mahashweta','Illusions','One','The sound of letting go','Sherlock Holmes and the Vampires of London']
ISBN=['ISBN','1599907844','545537460','451239652','670015709','1940521645','805098143','1620403404','1408327562','1620402750','1451685815','805092994','451415191','1423170288y','374104093','399164987','525953183','751529818','61122416','0451191153y','743278909','8126417463','99427869','330311735','0670015539y','1616552662']
def equation1(x,y): #x=actual rating,y=true rating
	x_y = x - y
	partPersonality = math.exp(-(x_y)*(x_y)/12.5) # 12.5 = 2 sigma^2 where sigma = free parameter
	return partPersonality
answer='Y' #for while loop to rate multiple books
nUsers = 30 #number of users
nReviews = 25 #number of reviews
Final=['FinalRatings','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null']#list of final predicted ratings for active user
currentUser=['ActiveUser','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null']
probabilityList = [] #probability that current user is similar to ith user
while(answer=='Y'):
	print("To proceed further kindly rate the books you've read on a scale of 1-5\n1.Asylum\n2.Fire and blood\n3.Twisted sisters\n4.Moth and Spark\n5.Dangerous Illusions\n6.The Black-Eyed Blonde\n7.the ghost runner\n8.Dead silent\n9.Before we met\n10.I forgot to remember\n11.Sixth extinction\n12.Wild Things\n13.Alienated\n14.Annhilation\n15.Flight of the silvers\n16.Influx\n17.Tuesdays with Morrie\n18.The alchemist\n19.The fountainhead\n20.Jonathan Livingston Seagull\n21.Mahashweta\n22.Illusions\n23.One\n24.The sound of letting go\n25.Sherlock Holmes and the Vampires of London")
	num=int(raw_input("Enter a book number"))
	print "Enter your rating for book" , num
	rating=int(raw_input(""))
	currentUser[num]=rating
	Final[num]=rating
	answer=raw_input("want to rate another book? press Y/N")



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

#print "Just printed PL"
#print probabilityList

#booknumber=int(raw_input("Enter book number for which you want predicted rating"))
for x in range(1,24):
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

		#print "Final rating for book", booknumber, Booklists[booknumber],"with ISBN", ISBN[booknumber]
		Final[booknumber]=finalRating
		#print finalRating
#print("Final Rating : $d" %finalRating)
print "We recommend the following books :"
for x in range(1,24):
	if int(Final[x])>=4:
		bookData(ISBN[x])

