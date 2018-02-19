window.onload = function () {

    var PLAYER_X = "X";
    var PLAYER_O = "O";

    var button = document.getElementById("button");
    button.addEventListener("click", createTable);

    var turn = PLAYER_X; // intialize to player x. it's biased but whatever. Random might help.
    var score = { "Player X": 0, "Player O": 0 };

    var board_size;

    // this is the setup method. Takes input from the user to make the table.
    // the table is always a square matrix for tic tac toe.
    // Board size is set here to track the tie state.
    function createTable() {
        var board = document.getElementById("matrix").value;
        var table = document.getElementById("table");

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


        board_size = board * board; // track the board's size. if the board size = number of moves then its a tie state.
    }

    function update(cell) {

        // mark the cell with the current turn. 
        cell.innerHTML = turn;

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

        // switch players for next loop.
        switchPlayers(turn);

        checkWin();
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
        console.log("Switch to player ", turn);
    }

    function checkWin() {
        // check the horizontal
        // check the vertical
        // check the diagonal
    }


}