// Definition.java
import java.util.List;
import java.util.ArrayList; // ArrayList để lưu danh sách

public class Definition {
    private DefinitionType type;
    private String meaning;
    private List<ExampleSentence> examples; // Danh sách các câu mẫu

    public Definition(DefinitionType type, String meaning) {
        this.type = type;
        this.meaning = meaning;
        this.examples = new ArrayList<>(); // Khởi tạo danh sách
    }

    // Thêm một câu mẫu vào định nghĩa
    public void addExample(ExampleSentence example) {
        this.examples.add(example);
    }

    // Phương thức getter
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