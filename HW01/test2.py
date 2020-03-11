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


# def check_grid(mattrix_img, col, row):
#     dot = []
#     for i in range(row):
#         for j in range(col):
#             black = 100
#             if i > 0 and i < row-1 and j > 0 and j < col-1 :
#                 if (mattrix_img[i][j] != 255) and (mattrix_img[i-1][j] < black) and (mattrix_img[i+1][j] < black) and (mattrix_img[i][j-1] < black) and (mattrix_img[i][j+1] < black):
#                     dot.append([i,j])
#             if(((i == 0) and (j == 0)) or ((i == 255) and (j == 255)) or ((i == 0) and ((j+1)%16 == 0)) or ((j == 0) and (i+1)%16 == 0) or ((i == 255) and ((j+1)%16 == 0)) or ((j == 255) and (i+1)%16 == 0)):
#                 dot.append([i,j])
#     return dot

# def check_distgrid(mattrix_img, col, row):
#     dot = []
#     for i in range(row):
#         for j in range(col):
#             # if(((i == 0) and (j == 0)) or ((i == 255) and (j == 255)) or ((i == 0) and ((j+1)%16 == 0)) or ((j == 0) and (i+1)%16 == 0) or ((i == 255) and ((j+1)%16 == 0)) or ((j == 255) and (i+1)%16 == 0)):
#             #     dot.append([i,j])
#             if i > 0 and i < row-1 and j > 0 and j < col-1 :
#                 # if(mattrix_img[i][j] != 255):
#                 #     if():
#                 #         dot.append([i,j])
#                 if ((i)%16 == 0) and ((j+1)%16 == 0) and sentong(mattrix_img, i, j):
#                     dot.append([i,j])
#                     #print(str(i)+","+str(j))

#     return dot

def cutting_point(mattrix_img, col, row):
    startX = mark_startX(mattrix_img, col, row)
    startY = mark_startY(mattrix_img, col, row)
    cut_point_temp = []
    cut_point = []
    lineX = []
    lineY = []
    for i in range(len(startX)):
        lineX.append(senX(mattrix_img, col, row, startX[i]))
    for i in range(len(startY)):
        lineY.append(senY(mattrix_img, col, row, startY[i]))
    for a in range(len(lineX)):
        for b in range(len(lineY)):
            for ain in range(len(lineX[a])):
                for bin in range(len(lineY[b])):
                    if lineX[a][ain] == lineY[b][bin]:
                        cut_point_temp.append(lineX[a][ain])
    for x in range(len(cut_point_temp)):
        chack_dup_m = cut_point_temp[x][0] - 3
        chack_dup_p = cut_point_temp[x][0] + 3
    return cut_point
#find point start line X 
def mark_startX(mattrix_img, col, row):
    startX = []
    for i in range(row):
        if mattrix_img[0][i] != 255:
            startX.append([0,i])
    return startX

#find point start line Y
def mark_startY(mattrix_img, col, row):
    startY = []
    for i in range(row):
        if mattrix_img[i][0] != 255:
            startY.append([i,0])
    return startY

#line in X axis (-----)
#input senX(mattrix_img, col, row, startX) return lineX
def senX(mattrix_img, col, row, startX): 
    lineX = []
    j = startX[1]
    lineX.append(startX)
    for a in range(1,col):
        if(mattrix_img[a][j-1] < mattrix_img[a][j]) and (mattrix_img[a][j-1] < mattrix_img[a][j+1]):
            j = j - 1
            lineX.append([a,j])
        elif(mattrix_img[a][j] <= mattrix_img[a][j-1]) and (mattrix_img[a][j] <= mattrix_img[a][j+1]):
            lineX.append([a,j])
        elif(mattrix_img[a][j+1] < mattrix_img[a][j-1]) and (mattrix_img[a][j+1] < mattrix_img[a][j]):
            j = j + 1
            lineX.append([a,j])
    return lineX

#line in Y axis (|)
#input senY(mattrix_img, col, row, startY) return lineY
def senY(mattrix_img, col, row, startY):
    lineY = []
    i = startY[0]
    lineY.append(lineY)
    for a in range(1,row):
        if(mattrix_img[i-1][a] < mattrix_img[i][a]) and (mattrix_img[i-1][a] < mattrix_img[i+1][a]):
            i = i - 1
            lineY.append([i,a])
        elif(mattrix_img[i][a] <= mattrix_img[i-1][a]) and (mattrix_img[i][a] <= mattrix_img[i+1][a]):
            lineY.append([i,a])
        elif(mattrix_img[i+1][a] < mattrix_img[i-1][a]) and (mattrix_img[i+1][a] < mattrix_img[i][a]):
            i = i + 1
            lineY.append([i,a])
    return lineY

print(len(cutting_point(mattrix_img, col, row)))
print(cutting_point(mattrix_img, col, row))