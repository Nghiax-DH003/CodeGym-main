function bai1() {
    let n = parseInt(prompt("Nhập số lượng phần tử Fibonacci:"));
    let fibo = [0, 1];
    for (let i = 2; i < n; i++) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    document.getElementById("output").textContent = fibo.join(" ");
}

function bai2() {
    let n = parseInt(prompt("Nhập số nguyên dương:"));
    let gt = 1;
    for (let i = 1; i <= n; i++) {
        gt *= i;
    }
    document.getElementById("output").textContent = "Giai thừa: " + gt;
}

function bai3() {
    let n = parseInt(prompt("Nhập số dòng:"));
    let txt = "";
    for (let i = 1; i <= n; i++) {
        txt += "*".repeat(i) + "\n";
    }
    txt += "\n";
    for (let i = n; i >= 1; i--) {
        txt += "*".repeat(i) + "\n";
    }
    txt += "\n";
    for (let i = 1; i <= n; i++) {
        txt += " ".repeat(n - i) + "*".repeat(i) + "\n";
    }
    txt += "\n";
    for (let i = n; i >= 1; i--) {
        txt += " ".repeat(n - i) + "*".repeat(i) + "\n";
    }
    document.getElementById("output").textContent = txt;
}

function bai4() {
    let rows = parseInt(prompt("Nhập số dòng:"));
    let cols = parseInt(prompt("Nhập số cột:"));
    let txt = "";
    for (let i = 1; i <= rows; i++) {
        if (i === 1 || i === rows) {
            txt += "*".repeat(cols) + "\n";
        } else {
            txt += "*" + " ".repeat(cols - 2) + "*\n";
        }
    }
    document.getElementById("output").textContent = txt;
}

function bai5() {
    let principal = parseFloat(prompt("Nhập số tiền ban đầu:"));
    let months = parseInt(prompt("Nhập số tháng:"));
    let rate = parseFloat(prompt("Nhập lãi suất/tháng (vd 0.01):"));
    let total = principal * Math.pow(1 + rate, months);
    document.getElementById("output").textContent =
        "Tiền gốc: " + principal +
        "\nSố tháng: " + months +
        "\nLãi suất/tháng: " + (rate * 100) + "%" +
        "\nTổng: " + total.toFixed(2);
}

function bai6() {
    let txt = "";
    txt += "  **   **  \n";
    txt += " ****** ** \n";
    txt += "***********\n";
    txt += " ********* \n";
    txt += "   *****   \n";
    txt += "    ***    \n";
    txt += "     *     \n";
    document.getElementById("output").textContent = txt;
}
