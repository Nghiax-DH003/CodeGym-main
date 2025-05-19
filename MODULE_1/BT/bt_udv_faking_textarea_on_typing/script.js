const fixedText = "Bạn bị ngu ngốc à?";
let index = 0;

document.getElementById("typingArea").addEventListener("keydown", function(event) {
    event.preventDefault();
    if (index < fixedText.length) {
        this.value += fixedText[index];
        index++;
    }
});
