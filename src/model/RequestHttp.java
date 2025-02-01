package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RequestHttp implements Serializable {
    private static final long serialVersionId = 1L;

    private String method;
    private String uri;
    private String httpVersion = "HTTP1.1";
    private Map<String, String> headers = new HashMap<>();
    private String body;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    public Optional<String> getHeader(String key) {
        return Optional.of(this.headers.get(key));
    }
}
