n = int(input())
moves = [tuple(input().split()) for _ in range(n)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

move_dirs = {'W': (-1, 0), 'S': (0, -1), 'N': (0, 1), 'E': (1, 0)}

x = y = 0

for i in range(n):
    dx, dy = move_dirs[dir[i]]
    x += dx * dist[i]
    y += dy * dist[i]

print(x, y)