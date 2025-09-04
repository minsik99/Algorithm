s = input().strip()

zero_groups = len([x for x in s.split('1') if x])
one_groups = len([x for x in s.split('0') if x])
    
print(min(zero_groups, one_groups))