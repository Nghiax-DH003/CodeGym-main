// Mảng 1: Từ tiếng Anh
const englishWords = ["hello", "cat", "dog", "banana", "love", "computer", "car"];

// Mảng 2: Từ tiếng Việt tương ứng
const vietnameseWords = ["xin chào", "mèo", "chó", "chuối", "yêu", "máy tính", "xe hơi"];

function traCuu() {
    let inputWord = document.getElementById("inputWord").value.trim().toLowerCase();
    let resultDiv = document.getElementById("result");

    // Tìm vị trí của từ tiếng Anh trong mảng englishWords
    let index = englishWords.indexOf(inputWord);

    // Nếu tìm thấy
    if (index !== -1) {
        resultDiv.textContent = `"${englishWords[index]}" có nghĩa là "${vietnameseWords[index]}"`;
    } else {
        resultDiv.textContent = "Không tìm thấy.";
    }
}
