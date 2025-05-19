class CongNhan {
    constructor(stt, hoTen, ngaySinh, diaChi, luong, chucVu) {
        this.stt = stt;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.luong = luong;
        this.chucVu = chucVu;
    }
}

let dsCongNhan = [];

// Thêm công nhân
function themCongNhan() {
    let stt = parseInt(document.getElementById("sttInput").value);
    let hoTen = document.getElementById("nameInput").value.trim();
    let ngaySinh = document.getElementById("dobInput").value;
    let diaChi = document.getElementById("addressInput").value.trim();
    let luong = parseInt(document.getElementById("salaryInput").value);
    let chucVu = document.getElementById("positionInput").value.trim();

    // Kiểm tra
    if (isNaN(stt) || !hoTen || !ngaySinh || !diaChi || isNaN(luong) || !chucVu) {
        alert("Vui lòng nhập đầy đủ và chính xác thông tin!");
        return;
    }

    // Tạo đối tượng mới
    let cn = new CongNhan(stt, hoTen, ngaySinh, diaChi, luong, chucVu);
    dsCongNhan.push(cn);
    alert("Đã thêm công nhân: " + hoTen);

    document.getElementById("sttInput").value = "";
    document.getElementById("nameInput").value = "";
    document.getElementById("dobInput").value = "";
    document.getElementById("addressInput").value = "";
    document.getElementById("salaryInput").value = "";
    document.getElementById("positionInput").value = "";
}

// Sắp xếp tên
function hienThiDanhSach() {
    dsCongNhan.sort(function(a, b) {
        return a.hoTen.localeCompare(b.hoTen);
    });

    let tbody = document.getElementById("tableBody");
    tbody.innerHTML = "";

    // Tạo dòng
    for (let i = 0; i < dsCongNhan.length; i++) {
        let cn = dsCongNhan[i];

        let tr = document.createElement("tr");

        let tdStt = document.createElement("td");
        tdStt.textContent = cn.stt;
        tr.appendChild(tdStt);

        let tdName = document.createElement("td");
        tdName.textContent = cn.hoTen;
        tr.appendChild(tdName);

        let tdDob = document.createElement("td");
        tdDob.textContent = cn.ngaySinh;
        tr.appendChild(tdDob);

        let tdAddress = document.createElement("td");
        tdAddress.textContent = cn.diaChi;
        tr.appendChild(tdAddress);

        let tdSalary = document.createElement("td");
        tdSalary.textContent = cn.luong;
        tr.appendChild(tdSalary);

        let tdPosition = document.createElement("td");
        tdPosition.textContent = cn.chucVu;
        tr.appendChild(tdPosition);

        tbody.appendChild(tr);
    }
}
