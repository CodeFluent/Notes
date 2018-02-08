// initialize variables on window onload.
window.onload = function () {
    document.getElementById("text").innerHTML = "Not valid.";
    validateCheckBoxes();
    validateRadio();

}

function validateCheckBoxes() {
    var boxes = document.getElementsByName("check");
    var numChecked = 0;

    for (var box of boxes) {
        if (box.checked === true) {
            numChecked++;
        }
    }
    if (numChecked !== 0 && numChecked <= 2) {
        document.getElementById("text").innerHTML = "CheckBoxes valid."
    }

}

function validateRadio() {
    var radios = document.getElementsByName("radio1");
    var numClicked = 0;

    for (var radio of radios) {
        if (radio.checked === true) {
            numClicked++;
        }
    }

    if (numClicked == 1) {
        document.getElementById("text").innerHTML += " Radios valid."

    }
}



function buttonClicked() {
    document.getElementById("text").innerHTML = "Not valid.";

    validateCheckBoxes();
    validateRadio();
}