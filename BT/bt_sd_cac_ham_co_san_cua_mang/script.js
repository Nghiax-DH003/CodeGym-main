function bai1() {
    let myColor = ["Red", "Green", "White", "Black"];
    let result = myColor.join();
    document.getElementById("output").textContent = result;
}

function bai2() {
    let inputStr = prompt("Nhập chuỗi số:");
    let result = "";
    for (let i = 0; i < inputStr.length; i++) {
        result += inputStr[i];
        if (i < inputStr.length - 1) {
            let current = parseInt(inputStr[i]);
            let next = parseInt(inputStr[i + 1]);
            if (!isNaN(current) && !isNaN(next)) {
                if (current % 2 === 0 && next % 2 === 0) {
                    result += "-";
                }
            }
        }
    }
    document.getElementById("output").textContent = result;
}

function bai3() {
    let inputStr = prompt("Nhập chuỗi:");
    let result = "";
    for (let i = 0; i < inputStr.length; i++) {
        let ch = inputStr[i];
        if (ch === ch.toLowerCase()) {
            result += ch.toUpperCase();
        } else {
            result += ch.toLowerCase();
        }
    }
    document.getElementById("output").textContent = result;
}
