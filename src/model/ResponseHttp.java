package model;

import java.io.Serializable;

public class ResponseHttp implements Serializable {
    private static final long serialVersionId = 1L;

    private Integer status;
    private String message;
    private String body;


}
