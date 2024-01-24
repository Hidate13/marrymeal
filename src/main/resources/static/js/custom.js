function sayHello() {
	alert("Hello from JavaScript");
}




function orderConf(event) {
	event.preventDefault();

	let link = document.getElementById("order-link").getAttribute("href");;
	let order = document.getElementById("meal-name").innerText;
	let confText = "Are you sure to order " + order + "?";

	if (confirm(confText)) {
		document.getElementById("notif").innerHTML = "Order Succes";
		window.location.href = link;
		alert("Your order is successful!");
	} else {
		document.getElementById("notif").innerHTML = "Order Canceled";
		alert("Your order is canceled!");
	}
	return false;
}

function riderConf(event, action) {
	event.preventDefault();

	let link = event.currentTarget.getAttribute('href');
	let order = document.getElementById("meal-name").innerText;
	let member = document.getElementById("member-name").innerText;
	let confText = action === 'approve' ? 'Are you sure to deliver ' + order + ' with member is name ' + member : 'Are you sure to Cancel?';

	if (confirm(confText)) {
		window.location.href = link;
		alert("Task has taken");
	} else {
		alert("Task has canceled");
	}
	return false;
}


function approvalMeal(event, action, deliveryId) {
	event.preventDefault();

	let url;
	let confirmIsFrozenText = 'do you agree to send frozen food?';
	let confirmText = action === 'approve' ? 'Are you sure to Approve?' : 'Are you sure to Cancel?';
	let isFrozen = confirm(confirmIsFrozenText) ? 'yes' : 'no'; // Confirm isFrozen status

	//start
	if (!isFrozen || isFrozen === 'null') {
		isFrozen = 'no';
	}
	alert(isFrozen);

	url = `approvalMeal?id=${encodeURIComponent(deliveryId)}&isFrozen=${isFrozen}`;
	if (confirm(confirmText)) {
		window.location.href = url;
		alert('The order is ' + (action === 'approve' ? 'Approved' : 'Canceled'));
	} else {
		alert('The order change is Failed!');
	}

}


function validateUsername() {
	var usernameInput  = document.getElementById('username');
    var usernameError = document.getElementById('usernameError');
    var username = usernameInput.value;

	// Validate username
	if (username.trim() === '')	 {
		alert('Please enter a username.');
		return false;
	}

	// Check if the username matches the desired regex pattern
	var usernameRegex = /^[a-zA-Z0-9_-]{3,16}$/; //  pattern: alphanumeric, underscores, and hyphens, 3-16 characters
	if (!usernameRegex.test(username)) {
		usernameError.textContent = 'Please use alphanumeric characters, underscores, and hyphens (3-16 characters).';
		usernameInput.value = ''; // Clear the input field
		return false;
	}
	
	// Additional character validation
        var illegalCharsRegex = /["'`]/;
        if (illegalCharsRegex.test(username)) {
            usernameError.textContent = 'Username cannot contain double quotes, single quotes, or backticks.';
            usernameInput.value = ''; // Clear the input field
            return false;
        }
	
	// Clear any previous error messages
    usernameError.textContent = '';

	return true;
}


function validatePassword() {
        var passwordInput = document.getElementById('password');
        var passwordError = document.getElementById('passwordError');
        var password = passwordInput.value;

        // Validate password
        if (password.trim() === '') {
            passwordError.textContent = 'Please enter a password.';
            return false;
        }
        
        // Password length validation
        if (password.length < 8 || password.length > 20) {
            passwordError.textContent = 'Password must be between 8 and 20 characters.';
            return false;
        }

        // Password complexity validation
        var passwordRegex = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
        if (!passwordRegex.test(password)) {
            passwordError.textContent = 'Password must contain at least one special character and one numeric character.';
            passwordInput.value = ''; // Clear the input field
            return false;
        }

        // Clear any previous error messages
        passwordError.textContent = '';

        // If validation passes, enable the submit button
        document.getElementById('regBtn').removeAttribute('disabled');
        
        
        return true;
    }