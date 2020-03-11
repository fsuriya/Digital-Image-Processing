# def lastZero(x):
#     for i in range(len(x)):
#         if(x[i] == 0):
#             return i
#     return -1

# def editlastZero(x):
#     point = -1
#     for i in range(len(x)):
#         if(x[i] == 0):
#             point = i
#     if point != -1:
#         return point
#     else:
#         return -1

# x = [[],[0],[1,2,0,3,0]]
# for i in range(len(x)):
#     print("Case : "+str(i+1))
#     print(lastZero(x[i]))
#     print(editlastZero(x[i]))

from scipy.stats import norm

print(norm.cdf(2.75, loc=2,scale=0.5))