
for i in range(256):
    if (i == 0) or (i%16 == 0) or (i == 255):
        print("["+str(i)+",255]," , end ='')