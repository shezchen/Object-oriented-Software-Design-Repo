package Car;

// 交通管理机构视角：关注登记、检验与违法记录
public class RegisteredCar {
    public String VIN;
    public String plate;
    public String ownerName;
    public String registrationDate; // 注册登记日期
    public boolean inspectionValid; // 年检是否有效
    public int violationCount;      // 违法次数
    public double unpaidFines;      // 未缴纳罚款

    public RegisteredCar(String VIN, String plate, String ownerName, String registrationDate) {
        this.VIN = VIN;
        this.plate = plate;
        this.ownerName = ownerName;
        this.registrationDate = registrationDate;
        this.inspectionValid = true; // 登记时视同通过检验
        this.violationCount = 0;
        this.unpaidFines = 0;
    }

    // 记录一次违法
    public void recordViolation(String type, double fine) {
        violationCount++;
        unpaidFines += fine;
        IO.println("[" + plate + "] 记录违法「" + type + "」，罚款 " + fine + " 元，累计未缴 " + unpaidFines + " 元");
    }

    // 缴纳罚款
    public void payFines() {
        IO.println("[" + plate + "] 缴清罚款 " + unpaidFines + " 元");
        unpaidFines = 0;
    }

    // 年检
    public void renewInspection() {
        inspectionValid = true;
        IO.println("[" + plate + "] 年检通过，检验状态有效");
    }

    // 是否具备合法上路资格：年检有效且无未缴罚款
    public boolean isLegalToDrive() {
        return inspectionValid && unpaidFines == 0;
    }

    public void showInfo() {
        String legal = isLegalToDrive() ? "可合法上路" : "禁止上路";
        IO.println("[交管] " + plate + "（VIN: " + VIN + "）车主 " + ownerName
                + "，登记于 " + registrationDate + "，违法 " + violationCount + " 次，未缴罚款 "
                + unpaidFines + " 元，状态: " + legal);
    }
}
