// Definition.java
import java.util.List;
import java.util.ArrayList; // Chúng ta dùng ArrayList để lưu danh sách

public class Definition {
    private DefinitionType type;
    private String meaning;
    private List<ExampleSentence> examples; // Một danh sách các câu mẫu

    public Definition(DefinitionType type, String meaning) {
        this.type = type;
        this.meaning = meaning;
        this.examples = new ArrayList<>(); // Khởi tạo danh sách rỗng
    }

    // Phương thức để thêm một câu mẫu vào định nghĩa này
    public void addExample(ExampleSentence example) {
        this.examples.add(example);
    }

    // Các phương thức getter
    public DefinitionType getType() {
        return type;
    }

    public String getMeaning() {
        return meaning;
    }

    public List<ExampleSentence> getExamples() {
        return examples;
    }
}