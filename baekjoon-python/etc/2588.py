a = int(input())
b = int(input())

s3 = a * (b%10)
s4 = a * (b%100 - b%10)//10
s5 = a * (b//100)
s6 = s3 + s4*10 + s5*100

print(s3)
print(s4)
print(s5)
print(s6)