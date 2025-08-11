def compute(n):
    ans = 1.0
    curr = n - 1
    mult = n
    
    while curr > 0:
        if mult > 1e7:
            break
        ans += 1.0 / mult
        mult *= curr
        curr -= 1
    return round(ans, 6)

def main():
    # Вывод compute(i) для i от 2 до 20 в файл output.txt
    with open('output.txt', 'w') as f:
        for i in range(2, 21):
            f.write(f"{compute(i)}\n")

if __name__ == "__main__":
    main()