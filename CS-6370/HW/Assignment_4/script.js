window.onload = function () {


    var button = document.getElementById("button");
    button.addEventListener("click", createTable);

    function createTable() {
        // alert("WTf");
        var num_rows = document.getElementById("rows").value;
        var num_col = document.getElementById("col").value;
        var table = document.getElementById("table");

        var row;
        var cell;

        var array = [];

        for (var i = 0; i < num_rows; i++) {
            row = table.insertRow(0);
            for (var j = 0; j < num_col; j++) {
                cell = row.insertCell(j);
                cell.innerHTML = "row " + i + ", col " + j;
            }
            // array.push(row); // ignore, just pushes html elements to an array.
        }

        // sucessfully caught all html table rows
        // need to output in reverse order
        // console.log(array);


    }
}