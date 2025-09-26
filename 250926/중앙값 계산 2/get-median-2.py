n = int(input())
arr = list(map(int, input().split()))

for i in range(n):
    if (i + 1) % 2 != 0:
        idx = i + 1
        new_arr = sorted(arr[:idx])
        print(new_arr[idx // 2], end = ' ')