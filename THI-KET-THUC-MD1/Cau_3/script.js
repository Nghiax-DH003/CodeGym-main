// Kiểm tra năm nhuận
function laNamNhuan(nam) {
    if (nam % 400 === 0) return true;
    if (nam % 100 === 0) return false;
    if (nam % 4 === 0) return true;
    return false;
}

// Switch case tách tháng 2
function soNgayTrongThang(thang, nam) {
    switch(thang) {
        case 2:
            return laNamNhuan(nam) ? 29 : 28;
        case 4: case 6: case 9: case 11:
            return 30;
        default:
            return 31;
    }
}

// Nhập chuỗi tháng năm định dạng MM/YYYY
function kiemTraNgay() {
    let input = prompt("Nhập tháng/năm theo dạng MM/YYYY:");
    if (!input) {
        document.getElementById("ketQua").textContent = "Bạn chưa nhập dữ liệu.";
        return;
    }

// Kiểm tra
    let parts = input.split("/");
    if (parts.length !== 2) {
        document.getElementById("ketQua").textContent = "Định dạng không hợp lệ (cần MM/YYYY).";
        return;
    }

    let thang = parseInt(parts[0]);
    let nam = parseInt(parts[1]);

// Kiểm tra
    if (isNaN(thang) || isNaN(nam)) {
        document.getElementById("ketQua").textContent = "Dữ liệu không phải số.";
        return;
    }
    if (thang < 1 || thang > 12) {
        document.getElementById("ketQua").textContent = "Tháng không hợp lệ (1–12).";
        return;
    }
    if (nam <= 0) {
        document.getElementById("ketQua").textContent = "Năm phải lớn hơn 0.";
        return;
    }

    let soNgay = soNgayTrongThang(thang, nam);
    document.getElementById("ketQua").textContent =
        `Tháng ${thang}/${nam} có ${soNgay} ngày. (Năm nhuận: ${laNamNhuan(nam) ? "Có" : "Không"})`;
}
