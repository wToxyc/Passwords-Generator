const prompt = require('prompt-sync')({ sigint: true });
const fs = require('fs');
const colors = require('colors');

process.title = 'Password Generator';

const characters = [

    'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z',
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'

]

function generatePasswords(passwordLength, numberOfPasswords) {

    let passwords = [];

    for (let i = 0; i < numberOfPasswords; i++) {

        let password = '';

        for (let ii = 0; ii < passwordLength; ii++) {

            const randomIndex = Math.floor(Math.random() * characters.length);
            const randomCharacter = characters[randomIndex];

            password += randomCharacter;

        }

        passwords.push(password);

    }

    return passwords;

}

function savePasswords(passwords) {

    for (const password of passwords) {

        fs.appendFileSync(__dirname + '/passwords.txt', `${password}\n`);

    }

}

while (true) {

    let passwordLength = prompt('Enter the password\'s length: '.reset);

    if (isNaN(passwordLength)) {

        console.log('Invalid number!'.red);
        continue;

    }

    passwordLength = Number(passwordLength);

    if (!Number.isInteger(passwordLength)) {

        console.log('Invalid number!'.red);
        continue;

    }

    let numberOfPasswords = prompt('Enter the number of passwords length: ');

    if (isNaN(numberOfPasswords)) {

        console.log('Invalid number!'.red);
        continue;

    }

    numberOfPasswords = Number(numberOfPasswords);

    if (!Number.isInteger(numberOfPasswords)) {

        console.log('Invalid number!'.red);
        continue;

    }

    const passwords = generatePasswords(passwordLength, numberOfPasswords);
    savePasswords(passwords);

    console.log('Successful!'.green);

    break;

}