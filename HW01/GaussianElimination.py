########## Exaple input #############
# 32w + 31x + 992y + z = 32
# 48w + 31x + 1488y + z = 48
# 32w + 47x + 1504y + z = 32
# 48w + 31x + 1488y + z = 51

# A = [[32, 31, 992, 1, 32],
#        [48, 31, 1488, 1, 48],
#        [32, 47, 1504, 1, 32],
#        [48, 31, 1488, 1, 51]
#       ]

# x = gauss(A)
# gauss(A) return List Answer [1.0, 0.0, -0.0, 0]
#####################################
def pprint(A):
    n = len(A)
    for i in range(0, n):
        line = ""
        for j in range(0, n+1):
            line += str(A[i][j]) + "\t"
            if j == n-1:
                line += "| "
        print(line)
    print("")

def gauss(A):
    n = len(A)

    for i in range(0, n):
        # Search for maximum in this column
        maxEl = abs(A[i][i])
        maxRow = i
        for k in range(i+1, n):
            if abs(A[k][i]) > maxEl:
                maxEl = abs(A[k][i])
                maxRow = k

        # Swap maximum row with current row (column by column)
        for k in range(i, n+1):
            tmp = A[maxRow][k]
            A[maxRow][k] = A[i][k]
            A[i][k] = tmp

        # Make all rows below this one 0 in current column
        for k in range(i+1, n):
            c = -A[k][i]/A[i][i]
            for j in range(i, n+1):
                if i == j:
                    A[k][j] = 0
                else:
                    A[k][j] += c * A[i][j]

    # Solve equation Ax=b for an upper triangular matrix A
    x = [0 for i in range(n)]
    for i in range(n-1, -1, -1):
        if A[i][i] == 0 :
            x[i] = 0
        else:
            x[i] = A[i][n]/A[i][i]
        for k in range(i-1, -1, -1):
            A[k][n] -= A[k][i] * x[i]
    return x