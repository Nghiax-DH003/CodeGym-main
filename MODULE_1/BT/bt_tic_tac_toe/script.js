const board = [
    ["", "", ""],
    ["", "", ""],
    ["", "", ""]
];

let currentPlayer = "X";
const boardSize = 3;

function createBoard() {
    const gameBoard = document.getElementById("gameBoard");
    gameBoard.innerHTML = "";
    for (let i = 0; i < boardSize; i++) {
        for (let j = 0; j < boardSize; j++) {
            let cell = document.createElement("div");
            cell.classList.add("cell");
            cell.dataset.row = i;
            cell.dataset.col = j;
            cell.innerText = board[i][j];
            cell.addEventListener("click", makeMove);
            gameBoard.appendChild(cell);
        }
    }
}

function makeMove(event) {
    let row = event.target.dataset.row;
    let col = event.target.dataset.col;
    if (board[row][col] === "") {
        board[row][col] = currentPlayer;
        event.target.innerText = currentPlayer;
        if (checkWin(currentPlayer)) {
            document.getElementById("status").innerText = `Người chơi ${currentPlayer} thắng!`;
            disableBoard();
            return;
        }
        currentPlayer = currentPlayer === "X" ? "O" : "X";
        document.getElementById("status").innerText = `Lượt chơi: ${currentPlayer}`;
    }
}

function checkWin(player) {
    for (let i = 0; i < boardSize; i++) {
        if (board[i][0] === player && board[i][1] === player && board[i][2] === player) return true;
        if (board[0][i] === player && board[1][i] === player && board[2][i] === player) return true;
    }
    if (board[0][0] === player && board[1][1] === player && board[2][2] === player) return true;
    if (board[0][2] === player && board[1][1] === player && board[2][0] === player) return true;
    return false;
}

function disableBoard() {
    document.querySelectorAll(".cell").forEach(cell => cell.removeEventListener("click", makeMove));
}

function resetGame() {
    for (let i = 0; i < boardSize; i++) {
        for (let j = 0; j < boardSize; j++) {
            board[i][j] = "";
        }
    }
    currentPlayer = "X";
    document.getElementById("status").innerText = "Lượt chơi: X";
    createBoard();
}

createBoard();
