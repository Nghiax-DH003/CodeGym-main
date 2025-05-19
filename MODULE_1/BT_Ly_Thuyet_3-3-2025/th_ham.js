
document.getElementById('btnKiemTra').addEventListener('click', xuLyDuLieu);

function xuLyDuLieu() {
    let giaTriNhap = layGiaTriInput();

    if (!kiemTraDuLieu(giaTriNhap)) {
        hienThiKetQua("Dữ liệu nhập không hợp lệ! Vui lòng nhập số nguyên dương.");
        return;
    }

    let so = parseInt(giaTriNhap);

    // Kiểm tra số hoàn hảo
    if (kiemTraSoHoanHao(so)) {
        hienThiKetQua(so + " là số hoàn hảo.");
    } else {
        hienThiKetQua(so + " không phải là số hoàn hảo.");
    }
}

// Lấy giá trị
function layGiaTriInput() {
    return document.getElementById('soNhap').value.trim();
}

// Kiểm tra dữ liệu nhập
function kiemTraDuLieu(giatri) {
    if (giatri === "") {
        return false;
    }
    let so = Number(giatri);
    if (!Number.isInteger(so) || so <= 0) {
        return false;
    }
    return true;
}

// Kiểm tra số hoàn hảo
function kiemTraSoHoanHao(so) {
    let tong = 0;
    // Duyệt từ 1 đến so/2 vì các ước số của so đều không vượt quá so/2
    for (let i = 1; i <= so / 2; i++) {
        if (so % i === 0) {
            tong += i;
        }
    }
    return tong === so;
}

// Hiển thị kết quả
function hienThiKetQua(thongDiep) {
    document.getElementById('ketQua').innerHTML = `<p>${thongDiep}</p>`;
}
