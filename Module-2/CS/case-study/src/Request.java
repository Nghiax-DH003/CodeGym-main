import java.util.Map;

public class Request {
    private String action;
    private Map<String, String> params;

    public Request(String action, Map<String, String> params) {
        this.action = action;
        this.params = params;
    }

    public String getAction() {
        return action;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
