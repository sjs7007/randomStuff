def checkProg(x,y,z):
    if((2*y)==(x+z)):
	    print 'AP',((2*z)-y)
    else:
        print 'GP',(z*(z/y))

while(True):
     x,y,z=map(int,raw_input().split())
     if(x==0 and y==0 and z==0):
         break
     else:
         checkProg(x,y,z)

