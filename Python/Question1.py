#N, M = map(int, input().split())
#rows = [input() for _ in range(N)]
#K = int(input())
#for row in sorted(rows, key=lambda row: int(row.split()[K])):
#    print(row)


#import math
#import os
#import random
#import re
#import sys

#    n,m = map(int, input().split())
#    arr=[]
#    for _ in range(n):
#        arr.append(input())
#    k = int(input())

#    for row in sorted(arr, key=lambda row: int(row.split()[k])):
#        print(row)

import math
import os
import random
import re
import sys


# Complete the time_delta function below.
#def time_delta(t1, t2):
 #   return t1 - t2


#f __name__ == '__main__':
#    fptr = open(os.environ['OUTPUT_PATH'], 'w')

  #  t = int(input())

   # for t_itr in range(t):
 #       t1 = input()

#        t2 = input()

 #       delta = time_delta(t1, t2)

  #      fptr.write(delta + '\n')

   # fptr.close()
order = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1357902468'
print(*sorted(input(), key=order.index), sep='')