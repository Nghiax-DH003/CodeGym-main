import java.util.List;
import java.util.ArrayList;

public class WordEntity {
    private String keyword;
    private List<Definition> definitions; 

    public WordEntity(String keyword) {
        this.keyword = keyword;
        this.definitions = new ArrayList<>();
    }


    public void addDefinition(Definition definition) {
        this.definitions.add(definition);
    }


    public String getKeyword() {
        return keyword;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}