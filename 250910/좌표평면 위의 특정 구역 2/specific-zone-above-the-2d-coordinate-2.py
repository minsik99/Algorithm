n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

max_x = max(x)
max_y = max(y)

x.remove(max_x)
y.remove(max_y)

dist_x = max(x) - min(x)
dist_y = max(y) - min(y)

ans = dist_x * dist_y

print(ans)