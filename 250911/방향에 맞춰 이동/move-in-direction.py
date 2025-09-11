n = int(input())
moves = [tuple(input().split()) for _ in range(n)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

dx, dy = [-1, 0, 0, 1], [0, -1, 1, 0]

ans_x = ans_y = 0

for i in range(n):
    if dir[i] == 'W':
        for _ in range(dist[i]):
            ans_x += dx[0]
            ans_y += dy[0]
    elif dir[i] == 'S':
        for _ in range(dist[i]):
            ans_x += dx[1]
            ans_y += dy[1]
    elif dir[i] == 'N':
        for _ in range(dist[i]):
            ans_x += dx[2]
            ans_y += dy[2]
    elif dir[i] == 'E':
        for _ in range(dist[i]):
            ans_x += dx[3]
            ans_y += dy[3]

print(ans_x, ans_y)