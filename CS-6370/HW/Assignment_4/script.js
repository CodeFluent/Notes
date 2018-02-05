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

        for (var i = 0; i < num_rows; i++) {
            row = table.insertRow(0);
            for (var j = 0; j < num_col; j++) {
                cell = row.insertCell(j);
                cell.innerHTML = "row " + i + ", col " + j;
            }
        }


        // var row1 = table.insertRow(0);
        // var cell1 = row1.insertCell(0);
        // var cell2 = row1.insertCell(1);
        // var cell3 = row1.insertCell(2);

        // cell1.innerHTML = "NEW CELL1";
        // cell2.innerHTML = "NEW CELL2";
        // cell3.innerHTML = "NEW CELL2";


    }
}