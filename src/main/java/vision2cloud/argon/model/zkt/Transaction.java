package vision2cloud.argon.model.zkt;

public class Transaction {
    private  String id;
    private  String eventTime;
    private  String pin;
    private  String name;
    private  String lastName;
    private  String deptName;
    private  String areaName;
    private  String cardNo;
    private  String devSn;
    private  String verifyModeName;
    private  String eventName;
    private  String eventPointName;
    private  String readerName;
    private  String accZone;
    private  String devName;
    private  String logId;

    public Transaction() {

    }

    public Transaction(String id, String eventTime, String pin, String name, String lastName, String deptName, String areaName, String cardNo, String devSn, String verifyModeName, String eventName, String eventPointName, String readerName, String accZone, String devName, String logId) {
        this.id = id;
        this.eventTime = eventTime;
        this.pin = pin;
        this.name = name;
        this.lastName = lastName;
        this.deptName = deptName;
        this.areaName = areaName;
        this.cardNo = cardNo;
        this.devSn = devSn;
        this.verifyModeName = verifyModeName;
        this.eventName = eventName;
        this.eventPointName = eventPointName;
        this.readerName = readerName;
        this.accZone = accZone;
        this.devName = devName;
        this.logId = logId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getDevSn() {
        return devSn;
    }

    public void setDevSn(String devSn) {
        this.devSn = devSn;
    }

    public String getVerifyModeName() {
        return verifyModeName;
    }

    public void setVerifyModeName(String verifyModeName) {
        this.verifyModeName = verifyModeName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventPointName() {
        return eventPointName;
    }

    public void setEventPointName(String eventPointName) {
        this.eventPointName = eventPointName;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getAccZone() {
        return accZone;
    }

    public void setAccZone(String accZone) {
        this.accZone = accZone;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
}
