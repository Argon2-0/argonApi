package vision2cloud.argon.model.zkt;

public class ResponsePerson {
    private Integer code;
    private String message;
    private Person data;

    public ResponsePerson() {
    }

    public ResponsePerson(Integer code, String message, Person data) {
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

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
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
