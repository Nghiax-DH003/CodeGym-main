function calcBMI() {
    let w = Number(prompt("Nhập cân nặng (kg):"));
    let h = Number(prompt("Nhập chiều cao (m):"));
    let bmi = w / (h * h);
    let msg = "BMI = " + bmi.toFixed(2) + "\nPhân loại: ";
    if (bmi < 18.5) {
        msg += "Underweight";
    } else if (bmi < 25.0) {
        msg += "Normal";
    } else if (bmi < 30.0) {
        msg += "Overweight";
    } else {
        msg += "Obese";
    }
    document.getElementById("output").textContent = msg;
}

window.onload = function() {
    document.getElementById("btn-bmi").onclick = calcBMI;
};
