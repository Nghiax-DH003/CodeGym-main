function calcDays() {
    let m = parseInt(document.getElementById("monthInput").value);
    let msg = "";
    switch (m) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            msg = "Tháng " + m + " có 31 ngày";
            break;
        case 4: case 6: case 9: case 11:
            msg = "Tháng " + m + " có 30 ngày";
            break;
        case 2:
            msg = "Tháng 2 có 28 hoặc 29 ngày";
            break;
        default:
            msg = "Tháng không hợp lệ";
    }
    document.getElementById("result").textContent = msg;
}

window.onload = function() {
    document.getElementById("btnDays").onclick = calcDays;
};
