#N, M = map(int, input().split())
#rows = [input() for _ in range(N)]
#K = int(input())
#for row in sorted(rows, key=lambda row: int(row.split()[K])):
#    print(row)


import math
import os
import random
import re
import sys



if __name__ == '__main__':
    n,m = map(int, input().split())
    arr=[]
    for _ in range(n):
        arr.append(input())
    k = int(input())

    for row in sorted(arr, key=lambda row: int(row.split()[k])):
        print(row)
