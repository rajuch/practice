package misc;

import java.util.Date;

public class Employee {

    private int employeeId;
    private String name;
    private Date birthDay;
    private double basePay;

    private double grossPercentage = 0.8;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Double getBasePay() {
        return basePay;
    }

    public void setBasePay(Double basePay) {
        this.basePay = basePay;
    }

    public void timeIn(String timeIn) {

    }

    public Double getNetSalary() {
        return grossPercentage * getBasePay();
    }
}
