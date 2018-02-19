window.onload = function () {


    var button = document.getElementById("button");
    button.addEventListener("click", createTable);

    var turn;

    function createTable() {
        var board = document.getElementById("matrix").value;
        var table = document.getElementById("table");

        var row;
        var cell;

        for (var i = 0; i < board; i++) {
            row = table.insertRow(0);
            for (var j = 0; j < board; j++) {
                cell = row.insertCell(0);
            }
        }


    }
}