public class EntityFactory {

    public WordEntity createWordEntity(String keyword) {
        // Tạo một WordEntity
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