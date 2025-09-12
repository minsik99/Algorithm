n = int(input())

def printHelloWorld(n):
    if (n == 0):
        return
    print('HelloWorld')
    printHelloWorld(n - 1)

printHelloWorld(n)