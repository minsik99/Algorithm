n = int(input())
moves = [tuple(map(int, input().split())) for _ in range(n)]
a, b, c = zip(*moves)
a, b, c = list(a), list(b), list(c)

ans = 0

for t in range(3):
    cnt = 0
    rock = t + 1
    for a, b, c in moves:
        if rock == a:
            rock = b
        elif rock == b:
            rock = a
        if rock == c:
            cnt += 1
    ans = max(ans, cnt)

print(ans)