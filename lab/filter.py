#small = ddopen('small','r')
#big = open('big','r')
#output = open('new6','w')

import sys
import time

filename = []
for arg in sys.argv:
	filename.append(arg)

verbose = True
count =0
Lsmall = []
with open('small','r') as small:
	for line in small:
		l = line.strip()
		l = l.split(' ')
		Lsmall.append(l[0])

if verbose is True:
	print "Finish small list constructing, sample:", Lsmall[0], 'length: ', len(Lsmall)

	
Lbig = []
print 'filename[1]:',filename[0]
with open(filename[1],'r') as big:
	for line in big:
		if verbose is True:
			print line
		lrow = line.strip()
		lrow = lrow.split('   ')
		Lbig.append( ( lrow[0] , lrow[1] ) )

if verbose is True:
	print 'Finish big list constructing, sample: ', Lbig[0], 'length: ', len(Lbig)
	

with open(filename[2],'w') as res:
	for b in Lbig:
		for s in Lsmall:
			if len(s)<=len(b[0]):
				if verbose is True:
					print 'first:',b[0].lower(), ' second:', s.lower()
				if b[0].lower().find(s.lower())!=-1:
					if verbose is True:
						print 'first does not contain second'
					res.write(b[0]+'   '+b[1]+'\n')
					count += 1
					if verbose is True:
						print count
					break



