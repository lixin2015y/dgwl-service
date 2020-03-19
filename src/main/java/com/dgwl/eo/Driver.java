package com.dgwl.eo;

import java.util.Date;

public class Driver {

    private Integer id;

    private String name;

    private Integer age;

    private Integer tel;

    private String cardId;

    private Integer driveAge;

    private Date updateTime;

    private Integer carId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getDriveAge() {
        return driveAge;
    }

    public void setDriveAge(Integer driveAge) {
        this.driveAge = driveAge;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tel=" + tel +
                ", cardId='" + cardId + '\'' +
                ", driveAge=" + driveAge +
                ", updateTime=" + updateTime +
                ", carId=" + carId +
                '}';
    }
}
