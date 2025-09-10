import sys

max_value = 0

numbers = list(map(int, input().split(' ')))

for number in numbers:
    if max_value < number:
        max_value = number

print(max_value)