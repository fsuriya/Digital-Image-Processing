from readpgm import read_pgm, list_to_2D_list, copy
from etc_function import createHistogram
# from momentFunction import pqmoment, pqN, pqHu
# from etc_function import createHistogram
filename = "./image/distgrid.pgm"
converted_img = []
mattrix_img = []
col = 0
row = 0

converted_img, col, row = read_pgm(filename, col, row)
mattrix_img = list_to_2D_list(converted_img, mattrix_img, col, row)


def check_grid(mattrix_img, col, row):
    dot = []
    for i in range(row):
        for j in range(col):
            black = 100
            if i > 0 and i < row-1 and j > 0 and j < col-1 :
                if (mattrix_img[i][j] != 255) and (mattrix_img[i-1][j] < black) and (mattrix_img[i+1][j] < black) and (mattrix_img[i][j-1] < black) and (mattrix_img[i][j+1] < black):
                    dot.append([i,j])
            if(((i == 0) and (j == 0)) or ((i == 255) and (j == 255)) or ((i == 0) and ((j+1)%16 == 0)) or ((j == 0) and (i+1)%16 == 0) or ((i == 255) and ((j+1)%16 == 0)) or ((j == 255) and (i+1)%16 == 0)):
                dot.append([i,j])
    return dot

def check_distgrid(mattrix_img, col, row):
    dot = []
    for i in range(row):
        for j in range(col):
            # if(((i == 0) and (j == 0)) or ((i == 255) and (j == 255)) or ((i == 0) and ((j+1)%16 == 0)) or ((j == 0) and (i+1)%16 == 0) or ((i == 255) and ((j+1)%16 == 0)) or ((j == 255) and (i+1)%16 == 0)):
            #     dot.append([i,j])
            if i > 0 and i < row-1 and j > 0 and j < col-1 :
                # if(mattrix_img[i][j] != 255):
                #     if():
                #         dot.append([i,j])
                if ((i)%16 == 0) and ((j+1)%16 == 0) and sentong(mattrix_img, i, j):
                    dot.append([i,j])
                    #print(str(i)+","+str(j))

    return dot

def sentong(mattrix_img, i, j):
    black = 240
    up = True
    down = True
    Left = True
    Right = True
    for a in range(1,13):
        if mattrix_img[i+a][j] > black:
            up = False
        if mattrix_img[i-a][j] > black:
            down = False
        if mattrix_img[i][j+a] > black:
            Right = False
        if mattrix_img[i][j-a] > black:
            Left = False
    ans = up or down or Left or Right
    #print(ans)
    return ans


#print(len(check_distgrid(mattrix_img, col, row)))     #17 * 17 = 289
print(check_distgrid(mattrix_img, col, row))
#print(mattrix_img[176][240])
# print(len(converted_img))