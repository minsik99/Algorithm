n = int(input())

answer = []

while True:
    if n < 2:
        answer.append(n)
        break
    answer.append(n % 2)
    n //= 2

for a in answer[::-1]:
    print(a, end = '')