function bai1() {
    let c = parseFloat(prompt("Bài 1\nNhập nhiệt độ (°C):"));
    let f = c * 9/5 + 32;
    alert(c + " °C = " + f + " °F");
}

function bai2() {
    let m = parseFloat(prompt("Bài 2\nNhập chiều dài (m):"));
    let ft = m * 3.2808;
    alert(m + " m = " + ft.toFixed(4) + " ft");
}

function bai3() {
    let a = parseFloat(prompt("Bài 3\nNhập cạnh hình vuông (a):"));
    let dt = a * a;
    alert("Diện tích hình vuông = " + dt);
}

function bai4() {
    let a = parseFloat(prompt("Bài 4\nNhập cạnh thứ nhất (a):"));
    let b = parseFloat(prompt("Nhập cạnh thứ hai (b):"));
    let dt = a * b;
    alert("Diện tích hình chữ nhật = " + dt);
}

function bai5() {
    let a = parseFloat(prompt("Bài 5\nNhập cạnh kề thứ nhất (a):"));
    let b = parseFloat(prompt("Nhập cạnh kề thứ hai (b):"));
    let dt = (a * b) / 2;
    alert("Diện tích tam giác vuông = " + dt);
}

function bai6() {
    let a = parseFloat(prompt("Bài 6\nPhương trình a*x + b = 0\nNhập a:"));
    let b = parseFloat(prompt("Nhập b:"));
    if (a === 0) {
        if (b === 0) {
            alert("Phương trình vô số nghiệm.");
        } else {
            alert("Phương trình vô nghiệm.");
        }
    } else {
        let x = -b / a;
        alert("Nghiệm x = " + x);
    }
}

function bai7() {
    let a = parseFloat(prompt("Bài 7\nPhương trình a*x^2 + b*x + c = 0\nNhập a:"));
    let b = parseFloat(prompt("Nhập b:"));
    let c = parseFloat(prompt("Nhập c:"));
    if (a === 0) {
        alert("Không phải phương trình bậc 2.");
        return;
    }
    let delta = b*b - 4*a*c;
    if (delta < 0) {
        alert("Vô nghiệm (delta < 0).");
    } else if (delta === 0) {
        let x = -b / (2*a);
        alert("Nghiệm kép x = " + x);
    } else {
        let x1 = (-b + Math.sqrt(delta)) / (2*a);
        let x2 = (-b - Math.sqrt(delta)) / (2*a);
        alert("2 nghiệm:\nx1 = " + x1 + "\nx2 = " + x2);
    }
}

function bai8() {
    let n = parseInt(prompt("Bài 8\nNhập 1 số nguyên để kiểm tra tuổi:"));
    if (n > 0 && n < 120) {
        alert(n + " là tuổi của 1 người.");
    } else {
        alert(n + " không phải tuổi 1 người.");
    }
}

function bai9() {
    let a = parseFloat(prompt("Bài 9\nNhập cạnh a:"));
    let b = parseFloat(prompt("Nhập cạnh b:"));
    let c = parseFloat(prompt("Nhập cạnh c:"));
    if (a > 0 && b > 0 && c > 0 && (a + b > c) && (b + c > a) && (a + c > b)) {
        alert("a, b, c là 3 cạnh tam giác.");
    } else {
        alert("a, b, c KHÔNG phải 3 cạnh tam giác!");
    }
}

function bai10() {
    let soDien = parseFloat(prompt("Bài 10\nNhập số kWh:"));
    let tienDien = 0;
    if (soDien <= 50) {
        tienDien = soDien * 1678;
    } else if (soDien <= 100) {
        tienDien = 50 * 1678 + (soDien - 50) * 1734;
    } else {
        tienDien = 50 * 1678 + 50 * 1734 + (soDien - 100) * 2014;
    }
    alert("Số điện: " + soDien + " kWh\nThành tiền: " + tienDien + " đ");
}

function bai11() {
    let thuNhap = parseFloat(prompt("Bài 11\nNhập thu nhập (triệu/tháng):"));
    let thue = 0;
    if (thuNhap <= 9) {
        thue = 0;
    } else if (thuNhap <= 15) {
        thue = (thuNhap - 9) * 0.10;
    } else if (thuNhap <= 25) {
        thue = (15 - 9) * 0.10 + (thuNhap - 15) * 0.15;
    } else {
        thue = (15 - 9) * 0.10 + (25 - 15) * 0.15 + (thuNhap - 25) * 0.20;
    }
    alert("Thu nhập: " + thuNhap + " triệu\nThuế TNCN: " + thue + " triệu");
}

function bai12() {
    let principal = parseFloat(prompt("Bài 12\nNhập số tiền gửi ban đầu:"));
    let months = parseInt(prompt("Nhập số tháng gửi:"));
    let rate = parseFloat(prompt("Nhập lãi suất/tháng (vd 0.01):"));
    let finalAmount = principal * Math.pow(1 + rate, months);
    alert("Tiền gốc: " + principal +
        "\nTháng: " + months +
        "\nLãi suất/tháng: " + (rate*100) + "%" +
        "\nTổng: " + finalAmount.toFixed(2));
}
