// EntityFactory.java
// "Nhà máy" của chúng ta để sản xuất các đối tượng
public class EntityFactory {

    public WordEntity createWordEntity(String keyword) {
        // Đơn giản là tạo một WordEntity mới
        return new WordEntity(keyword);
    }

    public Definition createDefinition(DefinitionType type, String meaning) {
        // Tạo một Definition mới
        return new Definition(type, meaning);
    }

    public ExampleSentence createExampleSentence(String sentence, String meaning) {
        // Tạo một câu mẫu mới
        return new ExampleSentence(sentence, meaning);
    }
}