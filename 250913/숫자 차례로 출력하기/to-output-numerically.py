n = int(input())

def printAsc(n):
    if (n == 0):
        return 
    printAsc(n - 1)
    print(n, end = ' ')

def printDesc(n):
    if (n == 0):
        return
    print(n, end = ' ')
    printDesc(n - 1)

printAsc(n)
print()
printDesc(n)