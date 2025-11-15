// Request.java
import java.util.List;
import java.util.ArrayList;

public class Request {
    private String action;
    private String keyword;
    // params sẽ lưu mọi thứ không phải action và keyword
    // Ví dụ: ['--adjective', 'a positive factor', 'một nhân tố tích cực']
    private List<String> params;

    public Request() {
        this.params = new ArrayList<>();
    }

    // Các phương thức Setter (để gán dữ liệu vào)
    public void setAction(String action) {
        this.action = action;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void addParam(String param) {
        this.params.add(param);
    }

    // Các phương thức Getter (để lấy dữ liệu ra)
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