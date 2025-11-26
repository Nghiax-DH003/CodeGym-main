// Request.java
import java.util.List;
import java.util.ArrayList;

public class Request {
    private String action;
    private String keyword;
    // params sẽ lưu mọi thứ không phải action và keyword
    private List<String> params;

    public Request() {
        this.params = new ArrayList<>();
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void addParam(String param) {
        this.params.add(param);
    }

    public String getAction() {
        return action;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<String> getParams() {
        return params;
    }
}