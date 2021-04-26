package by.htp.les02.bean;

import java.io.Serializable;
import java.util.Objects;

public class LoginationInfo implements Serializable {

	private static final long serialVersionUID = 8049593752174658133L;

	private String login;
    private String password;
    
    public LoginationInfo() {
        super();
    }

    public LoginationInfo(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        LoginationInfo logInfo = (LoginationInfo) obj;
        return (login == logInfo.login || (login != null && login.equals(logInfo.login)))
                && (password == logInfo.password || (password != null && password.equals(logInfo.password)));
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "login: " + this.login;
    }

}
