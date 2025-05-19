// BÀI 1: Kiểm tra a có chia hết cho b hay không
function bai1() {
    let a = parseFloat(prompt("Bài 1\nNhập số a:"));
    let b = parseFloat(prompt("Nhập số b:"));
    if (b === 0) {
        alert("Không thể kiểm tra vì b = 0!");
        return;
    }
    if (a % b === 0) {
        alert(a + " chia hết cho " + b);
    } else {
        alert(a + " không chia hết cho " + b);
    }
}

// BÀI 2: Kiểm tra tuổi đủ điều kiện vào lớp 10
function bai2() {
    let tuoi = parseInt(prompt("Bài 2\nNhập tuổi học sinh:"));
    if (tuoi >= 16) {
        alert("Đủ điều kiện vào học lớp 10.");
    } else {
        alert("Không đủ điều kiện vào học lớp 10.");
    }
}

// BÀI 3: Kiểm tra số lớn hơn, nhỏ hơn hay bằng 0
function bai3() {
    let n = parseFloat(prompt("Bài 3\nNhập một số bất kỳ:"));
    if (n > 0) {
        alert(n + " lớn hơn 0");
    } else if (n < 0) {
        alert(n + " nhỏ hơn 0");
    } else {
        alert(n + " bằng 0");
    }
}

// BÀI 4: Tìm giá trị lớn nhất trong 3 số
function bai4() {
    let x = parseFloat(prompt("Bài 4\nNhập số thứ nhất:"));
    let y = parseFloat(prompt("Nhập số thứ hai:"));
    let z = parseFloat(prompt("Nhập số thứ ba:"));

    let maxVal = x;
    if (y > maxVal) {
        maxVal = y;
    }
    if (z > maxVal) {
        maxVal = z;
    }
    alert("Số lớn nhất là: " + maxVal);
}

// BÀI 5: Xếp loại học lực dựa trên 3 điểm (kiểm tra, giữa kỳ, cuối kỳ)
function bai5() {
    let diemKT = parseFloat(prompt("Bài 5\nNhập điểm bài kiểm tra:"));
    let diemGK = parseFloat(prompt("Nhập điểm thi giữa kỳ:"));
    let diemCK = parseFloat(prompt("Nhập điểm thi cuối kỳ:"));

    let dtb = (diemKT + diemGK + diemCK) / 3;
    let xepLoai = "";

    if (dtb >= 8) {
        xepLoai = "Giỏi";
    } else if (dtb >= 6.5) {
        xepLoai = "Khá";
    } else if (dtb >= 5) {
        xepLoai = "Trung bình";
    } else {
        xepLoai = "Yếu";
    }

    alert("Điểm trung bình: " + dtb.toFixed(2) + "\nXếp loại: " + xepLoai);
}

// BÀI 6: Tính hoa hồng dựa trên doanh số bán hàng
function bai6() {
    let ds = parseFloat(prompt("Bài 6\nNhập doanh số bán hàng:"));
    let hoaHong = 0;

    if (ds < 100) {
        hoaHong = 0;
    } else if (ds < 500) {
        hoaHong = ds * 0.05;
    } else if (ds < 1000) {
        hoaHong = ds * 0.10;
    } else {
        hoaHong = ds * 0.15;
    }

    alert("Doanh số: " + ds + "\nHoa hồng: " + hoaHong);
}

// BÀI 7: Tính cước điện thoại cho 1 hộ gia đình
function bai7() {
    let cuocThueBao = 25000;
    let soPhut = parseInt(prompt("Bài 7\nNhập số phút gọi:"));
    let cuocGoi = 0;

    if (soPhut <= 50) {
        cuocGoi = soPhut * 200;
    } else if (soPhut <= 100) {
        cuocGoi = 50 * 200 + (soPhut - 50) * 180;
    } else {
        cuocGoi = 50 * 200 + 50 * 180 + (soPhut - 100) * 150;
    }

    let tongCuoc = cuocThueBao + cuocGoi;
    alert("Số phút: " + soPhut +
        "\nCước thuê bao: " + cuocThueBao +
        "\nCước gọi: " + cuocGoi +
        "\nTổng cước: " + tongCuoc);
}
