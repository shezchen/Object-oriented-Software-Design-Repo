package Car;

// 车主视角：关注日常使用与养护
public class OwnerCar {
    public String plate;       // 车牌
    public String brand;
    public double mileage;     // 总里程（km）
    public double fuelLevel;   // 剩余油量（L）
    public double fuelPerKm;   // 油耗（L/km）
    public double nextMaintenanceMileage; // 下次保养里程

    public OwnerCar(String plate, String brand, double fuelPerKm) {
        this.plate = plate;
        this.brand = brand;
        this.fuelPerKm = fuelPerKm;
        this.mileage = 0;
        this.fuelLevel = 40; // 提车时油箱给 40L
        this.nextMaintenanceMileage = 5000;
    }

    // 开车：油够才能走，里程和油量同步变化
    public void drive(double km) {
        double needed = km * fuelPerKm;
        if (fuelLevel < needed) {
            IO.println("油量不足，无法行驶 " + km + " km（剩余 " + fuelLevel + " L）");
            return;
        }
        fuelLevel -= needed;
        mileage += km;
        IO.println("[" + plate + "] 行驶了 " + km + " km，当前总里程 " + mileage + " km，剩余油量 " + fuelLevel + " L");
        if (mileage >= nextMaintenanceMileage) {
            IO.println("提醒：该车已到保养里程，请及时保养");
        }
    }

    // 加油
    public void refuel(double liters) {
        fuelLevel += liters;
        IO.println("[" + plate + "] 加了 " + liters + " L 油，当前油量 " + fuelLevel + " L");
    }

    // 保养：往后顺延 5000 km
    public void doMaintenance() {
        nextMaintenanceMileage = mileage + 5000;
        IO.println("[" + plate + "] 已完成保养，下次保养里程 " + nextMaintenanceMileage + " km");
    }

    public void showInfo() {
        IO.println("[车主] " + brand + "（" + plate + "）总里程 " + mileage + " km，油量 " + fuelLevel
                + " L，下次保养 " + nextMaintenanceMileage + " km");
    }
}
