// TODO:
//     - Expand Table confirm to remake table and start new game.
//     - Start, Stop, Reset buttons
//     - Score TextArea
//     - Time elapsed   (opt)
//     - Moves till tie (opt)

window.onload = function () {

    var PLAYER_X = "X";
    var PLAYER_O = "O";

    var button = document.getElementById("matrix-button");
    button.addEventListener("click", createTable);
    var table;
    var board;
    var board_size;
    var tie_size;
    var moves_done = 0;



    var turn = PLAYER_X; // intialize to player x. it's biased but whatever. Random might help.
    var score = { "Player X": 0, "Player O": 0 };


    // this is the setup method. Takes input from the user to make the table.
    // the table is always a square matrix for tic tac toe.
    // Board size is set here to track the tie state.
    function createTable() {


        board = document.getElementById("matrix").value;
        table = document.getElementById("table");


        if (table !== null) {
            var r = confirm("Are you sure? Current game will be deleted.");
        }

        var row;
        var cell;

        for (var i = 0; i < board; i++) {
            row = table.insertRow(0);
            for (var j = 0; j < board; j++) {
                cell = row.insertCell(0);
                cell.onclick = function () {
                    update(this);
                };
                cell.onmouseover = function () {
                    showPlayerTurn(this);
                }
                cell.onmouseout = function () {
                    hidePlayerTurn(this);
                }
            }
        }


        board_size = board;
        tie_size = board * board; // track the number of total cells on the board for the tie state.
    }

    function update(cell) {

        // mark the cell with the current turn. 
        cell.innerHTML = turn;
        moves_done++;

        // remove all events from cell.
        cell.onclick = function () {
            return false;
        }
        cell.onmouseover = function () {
            return false;
        }
        cell.onmouseout = function () {
            return false;
        };

        checkWin(cell);

        // switch players for next loop.
        switchPlayers(turn);


    }

    function showPlayerTurn(cell) {
        if (cell.innerHTML !== ("X" || "O")) {
            cell.innerHTML = turn;
        }
    }

    function hidePlayerTurn(cell) {
        cell.innerHTML = "";
    }

    function switchPlayers(player) {
        if (player === PLAYER_X) {
            turn = PLAYER_O;
        } else if (player === PLAYER_O) {
            turn = PLAYER_X;
        } else {
            turn = PLAYER_X;
        }
        // console.log("Switch to player ", turn);
    }

    function checkWin(cell) {
        var cell_col = cell.cellIndex // gives column index
        var cell_row = cell.parentNode.rowIndex // gives row index
        var cell_check;

        var horiz_checked = 0;
        var vert_checked = 0;
        var right_diag_checked = 0;
        var left_diag_checked = 0;


        // console.log(cell_row); // tables are indexed by 0, be sure to watch bounds.

        // checks compare every cell unfortunately. could write a better algorithm. currently runs at O(n).

        // check the horizontal
        for (var i = 0; i <= board_size - 1; i++) {
            cell_check = table.rows[cell_row].cells[i];
            if (cell_check.innerHTML === turn) {
                horiz_checked++;
            }
            // console.log(cell_check, cell_check.innerHTML, horiz_checked);
        }

        // check the vertical
        for (var i = 0; i <= board_size - 1; i++) {
            cell_check = table.rows[i].cells[cell_col];
            if (cell_check.innerHTML === turn) {
                vert_checked++;
            }
            // console.log(cell_check, cell_check.innerHTML, vert_checked);
        }

        // check the upper right to lower left diagonal
        for (var i = 0; i <= board_size - 1; i++) {
            cell_check = table.rows[i].cells[board_size - 1 - i]; // board_size - 1 for out of bounds.
            if (cell_check.innerHTML === turn) {
                right_diag_checked++;
            }
            // console.log(cell_check, cell_check.innerHTML, right_diag_checked);
        }

        // check the upper left to lower right diagonal
        for (var i = 0; i <= board_size - 1; i++) {
            cell_check = table.rows[i].cells[i]; // board_size - 1 for out of bounds.
            if (cell_check.innerHTML === turn) {
                left_diag_checked++;
            }
            // console.log(cell_check, cell_check.innerHTML, left_diag_checked);
        }

        // declare win state or tie state
        if (horiz_checked == board_size || vert_checked == board_size || right_diag_checked == board_size || left_diag_checked == board_size) {
            alert("Player " + turn + " has won.");
        } else if (moves_done == tie_size) {
            alert("DRAW");
        }


    }


}