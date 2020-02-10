def read_pgm(filename, converted_img, col, row):
    f = open(filename, encoding="ISO-8859-1")
    img = ""
    list_img = []
    # matirx_img = []
    for i, line in enumerate(f):
        if i == 2:
            col = int(line[0:3])
            row = int(line[4:])
        if i >= 4:
            img = img+line
    f.close()
    for i in range(len(img)):
        list_img.append((ord(img[i])))
    return list_img, col, row