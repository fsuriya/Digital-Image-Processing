from readpgm import read_pgm, list_to_2D_list, copy
from writepgm import writepgm

filename = "./image/grid.pgm"
converted_img = []
mattrix_img = []
col = 0
row = 0


converted_img, col, row = read_pgm(filename, col, row)
image = list_to_2D_list(converted_img, mattrix_img, col, row)
image_new = [[0] * col] * row
test =[]
for i in range(row):
    test_inloop =[]
    for j in range(col):
        test_inloop.append(255)
    test.append(test_inloop)
print(test)


writepgm("new_lenna.pgm", test, col, row)