import sys

n = int(input())
A = list(map(int, input().split()))

# 완전 탐색
# n만큼 순회하며 각 집에서 모였을 때의 이동 거리 중 최소를 구함
min_val = sys.maxsize

for i in range(n):
    distance = 0
    for j in range(n):
        distance += A[j] * abs((j - i))
    if min_val > distance:
        min_val = distance

print(min_val)