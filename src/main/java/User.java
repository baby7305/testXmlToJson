import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
//    private int UserID;
//    private String LoginName;
//    private String Truename;
//    private String Nickname;
//    private String LoginPwd;
//    private String QQ;
//    private String Phone;
//    private String Email;
//    private String Remark;
//    private int Account_Non_Locked;
//    private String Telelephone;
//    private int IsDelete;

    @JsonProperty("UserID")
    private int userID;
    @JsonProperty("LoginName")
    private String loginName;
    @JsonProperty("Truename")
    private String truename;
    @JsonProperty("Nickname")
    private String nickname;
    @JsonProperty("LoginPwd")
    private String loginPwd;
    @JsonProperty("QQ")
    private String qq;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Remark")
    private String remark;
    @JsonProperty("Account_Non_Locked")
    private int account_Non_Locked;
    @JsonProperty("Telelephone")
    private String telelephone;
    @JsonProperty("IsDelete")
    private int isDelete;

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getAccount_Non_Locked() {
        return account_Non_Locked;
    }

    public void setAccount_Non_Locked(int account_Non_Locked) {
        this.account_Non_Locked = account_Non_Locked;
    }

    public String getTelelephone() {
        return telelephone;
    }

    public void setTelelephone(String telelephone) {
        this.telelephone = telelephone;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", loginName='" + loginName + '\'' +
                ", truename='" + truename + '\'' +
                ", nickname='" + nickname + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", account_Non_Locked=" + account_Non_Locked +
                ", telelephone='" + telelephone + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
