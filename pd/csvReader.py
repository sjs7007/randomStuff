import codecs
f = codecs.open("testdata.csv",'r','ascii')
i=0
location_id=[]
sample_date=[]
for line in f:
	fields = line.split(',')
	location_id.append(fields[0].strip('"'))
	sample_date.append(fields[1].strip('"'))

print location_id
print sample_date
