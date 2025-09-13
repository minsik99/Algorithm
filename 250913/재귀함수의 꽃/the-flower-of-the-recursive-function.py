N = int(input())

def printNum(n):
    if (n == 0):
        return
    print(n, end = ' ')
    printNum(n - 1)
    print(n, end = ' ')

printNum(N)