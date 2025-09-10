import sys

max = -sys.maxsize

numbers = list(map(int, input().split(' ')))

for number in numbers:
    if max < number:
        max = number

print(max)