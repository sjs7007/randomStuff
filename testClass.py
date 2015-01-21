class Complex:
	def __init__(self,real,imag):
		self.r=real
		self.i=imag
	
	def testFunc(self):
		print("Real part is %f"%self.r)
		print("Imaginary part is %f"%self.i)

x=Complex(2,3)
print x.r
print x.i

x.testFunc()

#creating array of class objects
complexList=[]
complexList.append(Complex(2,3))
complexList.append(Complex(5,6))

complexList[0].testFunc()
complexList[1].testFunc()
