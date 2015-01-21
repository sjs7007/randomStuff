#http://stackoverflow.com/questions/1047318/easiest-way-to-persist-a-data-structure-to-a-file-in-python
#save data in file and read later
import pickle
d = 'print "hello world!"'
afile = open(r'/home/shinchan/temp/test1.py', 'wb')
pickle.dump(d, afile)
afile.close()

#reload object from file
file2 = open(r'/home/shinchan/temp/test1.py', 'rb')
new_d = pickle.load(file2)
file2.close()

#print dictionary object loaded from file
print new_d


