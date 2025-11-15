// WordEntity.java
import java.util.List;
import java.util.ArrayList;

public class WordEntity {
    private String keyword;
    private List<Definition> definitions; // Một mục từ có nhiều định nghĩa

    public WordEntity(String keyword) {
        this.keyword = keyword;
        this.definitions = new ArrayList<>();
    }

    // Phương thức để thêm một định nghĩa mới cho từ này
    public void addDefinition(Definition definition) {
        this.definitions.add(definition);
    }

    // Các phương thức getter
    public String getKeyword() {
        return keyword;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}