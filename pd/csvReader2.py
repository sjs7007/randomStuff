import codecs
f = codecs.open("book.csv",'r','ascii')
i=0
users=[["null" for i in range(10)] for j in range(10)]

for line in f:
	fields = line.split(',')
#location_id.append(fields[0])
#	sample_date.append(fields[1])
	print line

#print location_id
#print sample_date
