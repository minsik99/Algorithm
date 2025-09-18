dirs = input()

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

x, y = 0, 0
d = 0

for cmd in dirs:
    if cmd == 'L':
        d = (d + 3) % 4
    elif cmd == 'R':
        d = (d + 1) % 4
    elif cmd == 'F':
        x += dx[d]
        y += dy[d]

print(x, y)