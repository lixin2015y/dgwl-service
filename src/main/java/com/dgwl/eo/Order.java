package com.dgwl.eo;

import java.util.List;

public class Order {

    private Integer id;

    private String to;

    private String goodsName;

    private Double goodsWeight;

    private Double goodsCapacity;

    private String status;

    private String price;

    private Integer userId;

    private String updateTime;

    private String method;

    private Integer houseId;


    private Integer driverId;


    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getGoodsCapacity() {
        return goodsCapacity;
    }

    public void setGoodsCapacity(Double goodsCapacity) {
        this.goodsCapacity = goodsCapacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsWeight=" + goodsWeight +
                ", goodsCapacity=" + goodsCapacity +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                ", userId=" + userId +
                ", updateTime='" + updateTime + '\'' +
                ", method='" + method + '\'' +
                ", houseId=" + houseId +
                '}';
    }
}
