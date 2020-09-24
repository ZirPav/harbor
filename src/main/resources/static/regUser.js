document.getElementById('registrationForm').addEventListener('submit', regUser);

function regUser(e){
    e.preventDefault();

    let nickName = document.getElementById('nickNameNewUser').value;
    let firstName = document.getElementById('firstNameNewUser').value;
    let lastName = document.getElementById('lastNameNewUser').value;
    let email = document.getElementById('emailNewUser').value;
    let password = document.getElementById('passwordNewUser').value;
    let confirmPassword = document.getElementById('passwordConfirmNewUser').value;


    fetch('http://localhost:8080/regUser', {
        method: 'POST',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            nickName: nickName,
            firstName: firstName,
            lastName: lastName,
            email: email,
            password: password,
            confirmPassword:confirmPassword
        })
    })
        .finally(() => {
            /*document.getElementById('returnFromReg').click();*/
        })
}