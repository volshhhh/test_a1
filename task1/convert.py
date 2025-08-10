def number_to_binary(num):
    binary_str = ""
    for i in range(32):
        mask = 1 << (31 - i)
        if num & mask:
            binary_str += "1"
        else:
            binary_str += "0"
    return binary_str

def binary_to_number(binary_str):
    result = 0
    for i in range(32):
        if binary_str[i] == "1":
            shift = 31 - i
            result |= 1 << shift
    return result

def ipv4_to_string(ipv4_number):
    octets = []
    for i in range(4):
        shift = 24 - 8 * i
        octet = (ipv4_number >> shift) & 0xFF
        octets.append(str(octet))
    return ".".join(octets)

def main():
    try:
        user_input = input("Введите 32-битное число: ")
        ipv4_number = int(user_input)
        
        ip_address = ipv4_to_string(ipv4_number)
        print(f"IPv4 адрес: {ip_address}")
        
    except ValueError:
        print("Ошибка: Пожалуйста, введите корректное целое число.")

if __name__ == "__main__":
    main()