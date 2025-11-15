// ExampleSentence.java
public class ExampleSentence {
    private String sentence;
    private String meaning;

    // Đây là Constructor, dùng để tạo một đối tượng mới
    public ExampleSentence(String sentence, String meaning) {
        this.sentence = sentence;
        this.meaning = meaning;
    }

    // Các phương thức getter (để lấy dữ liệu ra)
    public String getSentence() {
        return sentence;
    }

    public String getMeaning() {
        return meaning;
    }
}