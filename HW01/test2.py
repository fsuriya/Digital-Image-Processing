from readpgm import read_pgm

filename = "./cameraman.pgm"
converted_img = []
mattrix_img = []
col = 0
row = 0

converted_img, col, row = read_pgm(filename, converted_img, col, row)

print(row)