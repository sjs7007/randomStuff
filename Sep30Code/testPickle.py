#http://stackoverflow.com/questions/1047318/easiest-way-to-persist-a-data-structure-to-a-file-in-python
#save data in file and read later
import pickle
d = { "abc" : [1, 2, 3], "qwerty" : [4,5,6] }
afile = open(r'/home/shinchan/temp/test1.pkl', 'wb')
pickle.dump(d, afile)
afile.close()

#reload object from file
file2 = open(r'/home/shinchan/temp/test1.pkl', 'rb')
new_d = pickle.load(file2)
file2.close()

#print dictionary object loaded from file
print new_d

#now try to pickle and depickle an array
e=[1,2,3,4,5]
#bfile=open(r'/home/shinchan/temp/test2.pkl','wb')
bfile=open(r'test2.pkl','wb')
pickle.dump(e,bfile)
bfile.close()

file2=open(r'/home/shinchan/temp/test2.pkl','rb')
new_d=pickle.load(file2)
file2.close()
print new_d[3]
 
