package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryHistory {
    private String code;
    private String name;
    private int age;
    private double salary;
    private String status;
    private Date date;

    public SalaryHistory() {
    }

    public SalaryHistory(String code, String name, int age, double salary, String status) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = new Date();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-5d %-10.0f %-10s %-15s", 
                code, name, age, salary, status, getFormattedDate());
    }
}
