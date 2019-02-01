var pattern = /^[a-zA-z]{1}[a-zA-Z0-9]\w{4,22}$/;
var user_valid_mark;
var pass_valid_mark;

// initialize variables on window onload.
window.onload = function () {
    user_valid_mark = document.getElementById("username-mark");
    user_valid_mark.innerHTML = "&#x2716;";

    pass_valid_mark = document.getElementById("password-mark");
    pass_valid_mark.innerHTML = "&#x2716;";

    // run functions once in case input is already there.
    validateUsername();
    validatePassword();

}

/**
 * changes a span with id username to an x or check mark if the
 * username is valid or not. 
 */
function validateUsername() {
    var username = document.getElementById("username").value;

    if (username.match(pattern)) {
        user_valid_mark.innerHTML = "&#x2714;";
    } else {
        user_valid_mark.innerHTML = "&#x2716;";
    }
}
/**
 * changes a span with id password to an x or a check mark if the 
 * password is valid or not.
 */
function validatePassword() {
    var password = document.getElementById("password").value;

    if (password.match(pattern)) {
        pass_valid_mark.innerHTML = "&#x2714;";
    } else {
        pass_valid_mark.innerHTML = "&#x2716;";
    }

}