def createHistogram(converted_img):
    gray_level = []
    frequency = []
    histogram = {}
    for i in range(len(converted_img)):
        if converted_img[i] not in gray_level:
            gray_level.append(converted_img[i])
    gray_level.sort()
    for i in range(len(gray_level)):
        frequency.append(converted_img.count(gray_level[i]))
    histogram = dict(zip(gray_level, frequency))
    return histogram

#find color in new image from pixel in old image
def Bilinear(old_image, pixelXP, pixelYP):
    # point
    x = int(pixelXP//1)
    xplus = int((pixelXP+1)//1)
    
    y = int(pixelYP//1)
    yplus = int((pixelYP+1)//1)

    xScale = pixelXP - x
    yscale = pixelYP - y
    # read color from old image
    a = old_image[xplus][y] - old_image[x][y]
    b = old_image[x][yplus] - old_image[x][y]
    c = old_image[xplus][yplus] + old_image[x][y] - old_image[x][yplus] - old_image[xplus][y]
    d = old_image[x][y]
    #caculate
    color = (a * xScale) + (b * yscale) + (c * xScale *yscale) + d

    color = int(round(color))
    return color

Bilinear([[2,1],[3,4]],0.5,0.5)