package vision2cloud.argon.model.zkt;

public class Person {
    private String accEndTime ="";
    private String accLevelIds="";
    private String accStartTime="";
    private String birthday="";
    private String carPlate="";
    private String cardNo="";
    private String certNumber="";
    private String certType="";
    private String deptCode="";
    private String email="";
    private String gender="";
    private Boolean isSendMail=true;
    private String lastName="";
    private String mobilePhone="";
    private String name="";
    private String pin="";

    public Person() {
    }

    public Person(String accEndTime, String accLevelIds, String accStartTime, String birthday, String carPlate, String cardNo, String certNumber, String certType, String deptCode, String email, String gender, Boolean isSendMail, String lastName, String mobilePhone, String name, String pin) {
        this.accEndTime = accEndTime;
        this.accLevelIds = accLevelIds;
        this.accStartTime = accStartTime;
        this.birthday = birthday;
        this.carPlate = carPlate;
        this.cardNo = cardNo;
        this.certNumber = certNumber;
        this.certType = certType;
        this.deptCode = deptCode;
        this.email = email;
        this.gender = gender;
        this.isSendMail = isSendMail;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.name = name;
        this.pin = pin;
    }

    public String getAccEndTime() {
        return accEndTime;
    }

    public void setAccEndTime(String accEndTime) {
        this.accEndTime = accEndTime;
    }

    public String getAccLevelIds() {
        return accLevelIds;
    }

    public void setAccLevelIds(String accLevelIds) {
        this.accLevelIds = accLevelIds;
    }

    public String getAccStartTime() {
        return accStartTime;
    }

    public void setAccStartTime(String accStartTime) {
        this.accStartTime = accStartTime;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getSendMail() {
        return isSendMail;
    }

    public void setSendMail(Boolean sendMail) {
        isSendMail = sendMail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "person{" +
                "accEndTime='" + accEndTime + '\'' +
                ", accLevelIds='" + accLevelIds + '\'' +
                ", accStartTime='" + accStartTime + '\'' +
                ", birthday='" + birthday + '\'' +
                ", carPlate='" + carPlate + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", certNumber=" + certNumber +
                ", certType=" + certType +
                ", deptCode='" + deptCode + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", isSendMail=" + isSendMail +
                ", lastName='" + lastName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", name='" + name + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
