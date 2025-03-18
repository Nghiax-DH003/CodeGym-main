let products = [
    "Sony Xperia",
    "Samsung Galaxy",
    "Nokia 6",
    "Xiaomi Redmi Note 4",
    "Apple iPhone 6S",
    "Xiaomi Mi 5s Plus",
    "Apple iPhone 8 Plus",
    "Fujitsu F-04E",
    "Oppo A71"
];

function displayProducts() {
    let tbody = document.getElementById("productBody");
    tbody.innerHTML = "";
    for (let i = 0; i < products.length; i++) {
        let tr = document.createElement("tr");

        let tdIndex = document.createElement("td");
        tdIndex.textContent = i + 1;
        tr.appendChild(tdIndex);

        let tdName = document.createElement("td");
        tdName.textContent = products[i];
        tdName.onclick = function() {
            editProduct(i);
        };
        tr.appendChild(tdName);

        let tdAction = document.createElement("td");
        let btnEdit = document.createElement("button");
        btnEdit.textContent = "Edit";
        btnEdit.onclick = function() {
            editProduct(i);
        };
        tdAction.appendChild(btnEdit);

        let btnDelete = document.createElement("button");
        btnDelete.textContent = "Delete";
        btnDelete.style.marginLeft = "10px";
        btnDelete.onclick = function() {
            deleteProduct(i);
        };
        tdAction.appendChild(btnDelete);

        tr.appendChild(tdAction);
        tbody.appendChild(tr);
    }
}

function addProduct() {
    let newName = document.getElementById("newProduct").value.trim();
    let msgDiv = document.getElementById("msg");
    if (newName === "") {
        msgDiv.textContent = "Vui lòng nhập tên sản phẩm!";
        return;
    }
    products.push(newName);
    msgDiv.textContent = "Thêm thành công!";
    document.getElementById("newProduct").value = "";
    displayProducts();
}

function editProduct(index) {
    let newName = prompt("Nhập tên mới:", products[index]);
    if (newName !== null && newName.trim() !== "") {
        products[index] = newName.trim();
        displayProducts();
    }
}

function deleteProduct(index) {
    products.splice(index, 1);
    displayProducts();
}

displayProducts();
