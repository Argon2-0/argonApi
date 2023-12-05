package vision2cloud.argon.model.zkt;

import java.util.ArrayList;

public class ResponseTransaction {
    private Integer code;
    private String message;
    private ArrayList<Transaction> data;

    public ResponseTransaction() {
    }

    public ResponseTransaction(Integer code, String message, ArrayList<Transaction> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Transaction> getData() {
        return data;
    }

    public void setData(ArrayList<Transaction> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReponseStructures{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
