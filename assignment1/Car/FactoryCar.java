package Car;

// 厂家视角：关注生产参数与销售
public class FactoryCar {
    public String VIN;
    public String brand;
    public String model;
    public String color;
    public double price;          // 售价（万元）
    public String productionDate; // 生产日期
    public boolean isSold;

    public FactoryCar(String VIN, String brand, String model, String color, double price, String productionDate) {
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.productionDate = productionDate;
        this.isSold = false;
    }

    // 出厂质检
    public boolean qualityInspect() {
        IO.println("[" + VIN + "] " + brand + " " + model + " 质检通过");
        return true;
    }

    // 调价
    public void setPrice(double newPrice) {
        IO.println(brand + " " + model + " 售价从 " + price + " 万调整为 " + newPrice + " 万");
        price = newPrice;
    }

    // 销售
    public boolean sell(String ownerName) {
        if (isSold) {
            IO.println("销售失败：" + brand + " " + model + "（" + VIN + "）已售出");
            return false;
        }
        isSold = true;
        IO.println(brand + " " + model + "（" + VIN + "）已售出给 " + ownerName + "，成交价 " + price + " 万");
        return true;
    }

    public void showInfo() {
        String status = isSold ? "已售出" : "在库";
        IO.println("[厂家] " + brand + " " + model + " " + color + "，VIN: " + VIN
                + "，生产于 " + productionDate + "，售价 " + price + " 万，状态: " + status);
    }
}
