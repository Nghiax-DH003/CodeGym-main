class Rectangle {
    constructor(length, width) {
        this.length = length;
        this.width = width;
    }

    getArea() {
        return this.length * this.width;
    }

    getPerimeter() {
        return 2 * (this.length + this.width);
    }

    draw(canvasId) {
        let canvas = document.getElementById(canvasId);
        if (!canvas) return;
        let ctx = canvas.getContext("2d");

        // Xoá canvas
        ctx.clearRect(0, 0, canvas.width, canvas.height);

        // Chọn màu và vẽ
        ctx.fillStyle = "#FF8888";
        ctx.fillRect(50, 50, this.length, this.width);
        ctx.strokeStyle = "#000";
        ctx.strokeRect(50, 50, this.length, this.width);
    }
}

let rect = new Rectangle(100, 60);

function displayInfo() {
    let infoDiv = document.getElementById("info");
    let area = rect.getArea();
    let perimeter = rect.getPerimeter();
    infoDiv.textContent = `Diện tích: ${area}, Chu vi: ${perimeter}`;
}

function updateRectangle() {
    let lengthInput = document.getElementById("length");
    let widthInput = document.getElementById("width");
    let newLength = parseInt(lengthInput.value);
    let newWidth = parseInt(widthInput.value);

    rect.length = newLength;
    rect.width = newWidth;
    rect.draw("myCanvas");
    displayInfo();
}

window.onload = function() {
    rect.draw("myCanvas");
    displayInfo();
};
