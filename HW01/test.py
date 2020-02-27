from readpgm import read_pgm, list_to_2D_list, copy
from etc_function import createHistogram
# from momentFunction import pqmoment, pqN, pqHu
# from etc_function import createHistogram
filename = "./image/test.pgm"
converted_img = []
mattrix_img = []
col = 0
row = 0

converted_img, col, row = read_pgm(filename, col, row)
mattrix_img = list_to_2D_list(converted_img, mattrix_img, col, row)

print(mattrix_img)

