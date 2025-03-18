function bai1() {
    let physics = Number(prompt("Bài 1 - Điểm Vật Lý:"));
    let chemistry = Number(prompt("Bài 1 - Điểm Hóa Học:"));
    let biology = Number(prompt("Bài 1 - Điểm Sinh Học:"));
    let total = physics + chemistry + biology;
    let average = total / 3;
    return "Bài 1:\nTổng = " + total + "\nTrung bình = " + average.toFixed(2) + "\n";
}

function bai2() {
    let celsius = Number(prompt("Bài 2 - Nhiệt độ (°C):"));
    let fahrenheit = (9 * celsius) / 5 + 32;
    return "Bài 2:\n" + celsius + "°C = " + fahrenheit.toFixed(2) + "°F\n";
}

function bai3() {
    let radius = Number(prompt("Bài 3 - Bán kính (tính diện tích):"));
    let area = Math.PI * Math.pow(radius, 2);
    return "Bài 3:\nDiện tích = " + area.toFixed(2) + "\n";
}

function bai4() {
    let radius = Number(prompt("Bài 4 - Bán kính (tính chu vi):"));
    let circumference = 2 * Math.PI * radius;
    return "Bài 4:\nChu vi = " + circumference.toFixed(2) + "\n";
}

function runAll() {
    let result = "";
    result += bai1() + "\n";
    result += bai2() + "\n";
    result += bai3() + "\n";
    result += bai4() + "\n";
    document.getElementById("output").textContent = result;
}

window.onload = function() {
    document.getElementById("btn-run").addEventListener("click", runAll);
};
