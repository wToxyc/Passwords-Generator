import os, random, colorama

os.system("title Password Generator")

characters = [
    "A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
]

def generatePassword(password_length, number_of_passwords):

    passwords = []

    for i in range(number_of_passwords):

        password = ""

        for i in range(password_length):

            random_character = random.choice(characters)

            password += random_character
        
        passwords.append(password)

    return passwords

def savePasswords(passwords):

    with open("passwords.txt", "a+") as passwords_file:

        for password in passwords:

            passwords_file.write(f"{password}\n")

while True:

    password_length = input(colorama.Fore.RESET + "Enter the password's length: ")

    if not password_length.isdigit():
        print(colorama.Fore.RED + "Invalid number!")
        continue

    password_length = int(password_length)

    number_of_passwords = input("Enter the number of passwords: ")

    if not number_of_passwords.isdigit():
        print(colorama.Fore.RED + "Invalid number!")
        continue

    number_of_passwords = int(number_of_passwords)

    passwords = generatePassword(password_length, number_of_passwords)
    savePasswords(passwords)

    print(colorama.Fore.GREEN + "Successful!")
    break

os.system("pause>nul")