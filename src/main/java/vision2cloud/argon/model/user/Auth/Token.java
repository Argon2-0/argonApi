package vision2cloud.argon.model.user.Auth;

import java.util.Date;

public class Token {
    private String token;
    private Date expirationDate;

    public Token(){}
    public Token( String token, Date expirationDate )
    {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getToken()
    {
        return token;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
