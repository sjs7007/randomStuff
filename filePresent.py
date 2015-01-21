#check if file is present

import os

os.system("touch a")
if os.access("./a",os.F_OK):
	print "a is here"
else:
	print "a is not present"

if os.access('./b',os.F_OK):
	print "b is here"
else:
	print "b is not here"
