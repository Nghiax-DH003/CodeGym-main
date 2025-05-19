function xuLyMang() {

    let inputText = document.getElementById("inputArray").value;
    let soCanDem = parseInt(document.getElementById("inputNumber").value);

    let mang = inputText.split(",").map(Number);

    if (mang.length === 0 || isNaN(mang[0])) {
        document.getElementById("output").innerHTML = "<p class='result'>Vui lòng nhập mảng hợp lệ!</p>";
        return;
    }

    let tong = tinhTong(mang);
    let soLonNhat = timSoLonNhat(mang);
    let soLanXuatHien = demSoLanXuatHien(mang, soCanDem);
    let mangDaoNguoc = daoNguocMang([...mang]); // Giữ nguyên mảng gốc
    let soChan = locSoChan(mang);

    document.getElementById("output").innerHTML = `
        <p class='result'>Tổng các phần tử: ${tong}</p>
        <p class='result'>Số lớn nhất: ${soLonNhat}</p>
        <p class='result'>Số ${soCanDem} xuất hiện: ${soLanXuatHien} lần</p>
        <p class='result'>Mảng đảo ngược: [${mangDaoNguoc.join(", ")}]</p>
        <p class='result'>Các số chẵn: [${soChan.join(", ")}]</p>
    `;
}

// Bài 1: Tính tổng các phần tử trong mảng
function tinhTong(mang) {
    return mang.reduce((tong, so) => tong + so, 0);
}

// Bài 2: Tìm số lớn nhất trong mảng
function timSoLonNhat(mang) {
    return Math.max(...mang);
}

// Bài 3: Đếm số lần xuất hiện của một phần tử trong mảng
function demSoLanXuatHien(mang, soCanDem) {
    return mang.filter(so => so === soCanDem).length;
}

// Bài 4: Đảo ngược mảng
function daoNguocMang(mang) {
    return mang.reverse();
}

// Bài 5: Lọc ra các số chẵn trong mảng
function locSoChan(mang) {
    return mang.filter(so => so % 2 === 0);
}
