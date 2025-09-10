import sys

n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

ans = sys.maxsize

for i in range(n):
    max_x = max_y = 0
    min_x = min_y = 40001
    for j in range(n):
        if j == i:
            continue
        x, y = points[j]
        min_x = min(min_x, x)
        max_x = max(max_x, x)
        min_y = min(min_y, y)
        max_y = max(max_y, y)
    ans = min(ans, (max_x - min_x) * (max_y - min_y))

print(ans)