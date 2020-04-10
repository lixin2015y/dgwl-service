package com.dgwl.service;

import com.dgwl.dao.*;
import com.dgwl.eo.*;
import com.dgwl.util.HadoopFileUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DgwlServiceImpl implements DgwlService {


    @Autowired
    UserDao userDao;


    @Autowired
    CarDao carDao;


    @Autowired
    DriverDao driverDao;

    @Autowired
    HouseDao houseDao;

    @Autowired
    OrderDao orderDao;

    public User getUser(String userName, String password) {
        return userDao.selectUser(userName, password);
    }


    @Override
    public List<Map> getCars(String number, String type, Integer load) {
        return carDao.selectCar(number, type, load);
    }


    @Override
    public List<Map> getLeaveCars(String number, String type, Integer load) {
        return carDao.selectLeaveCar(number, type, load);
    }

    @Override
    public void addCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public void deleteCar(Integer id) {
        carDao.deleteCar(id);
    }

    @Override
    public void editCar(Car car) {
        carDao.updateCar(car);
    }

    @Override
    public List<Map> getDrivers(String name, Integer driveAge) {
        return driverDao.selectDriver(name, driveAge);
    }

    @Override
    public Integer addDriver(Driver driver) {
        return driverDao.insertDriver(driver);
    }

    @Override
    public void updateDriver(Driver driver) {
        driverDao.updateDriver(driver);
    }

    @Override
    public void deleteDriver(Integer id) {
        driverDao.deleteDriver(id);
    }

    @Override
    public List<Area> getArea() {
        return houseDao.selectArea();
    }

    @Override
    public Integer addHouse(House house) {
        return houseDao.insertHouse(house);
    }

    @Override
    public List<Map> getHouse(String name, String address, Integer cover) {
        return houseDao.selectHouse(name, address, cover);
    }

    @Override
    public Integer editHouse(House house) {
        return houseDao.updateHouse(house);
    }

    @Override
    public Integer deleteHouse(Integer id) {
        return houseDao.deleteHouse(id);
    }

    @Override
    public Integer editUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<Map> getMyOrder(Integer userId) {
        return orderDao.selectMyOrder(userId);
    }

    @Override
    public List<Map> getAllOrder() {
        return orderDao.selectAllOrder();
    }

    @Override
    public Integer addOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public Map getPosition(String name) {
        return orderDao.selectPosition(name).get(0);
    }

    @Override
    public Integer deleteOrder(Integer id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public Map getDriversAndHouse() {
        Map map = new HashMap();
        map.put("driverData", orderDao.selectAvailableDriver());
        map.put("houseData", houseDao.selectHouse(null, null, null));
        return map;
    }

    @Override
    public Integer deliverGoods(Order order) {
        return orderDao.deliverGoods(order);
    }

    @Override
    public List<Map> getOrderInHouse(Integer houseId) {
        return orderDao.selectOrderInHouse(houseId);
    }

    @Override
    public Integer handleOrder(Order order) {
        return orderDao.updateOrder(order);
    }


    /**
     * 虚拟机断网问题
     * chkconfig NetworkManager off
     * <p>
     * chkconfig network on
     * <p>
     * service NetworkManager stop
     * <p>
     * service network start
     * <p>
     * /etc/init.d/network restart
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Override
    public void handleOrder() throws IOException, URISyntaxException, InterruptedException {

        final List<Map> maps = orderDao.selectAllFinishOrder();
        System.out.println(maps.get(0).keySet());
        String[] keys = {"houseId", "method", "updateTime", "userName", "goodsWeight", "carNumber", "goodsCapacity", "price", "driverName", "id", "to", "goodsName", "status"};
        final List<String> lines = new ArrayList<>();
        maps.stream().forEach(map -> lines.add(HadoopFileUtil.getLine(map, keys)));
        HadoopFileUtil.WriteToHDFS("hdfs://hadoop101:9000/dgwl/order/orderdata.txt", lines);
    }

    @Override
    public Integer checkUserName(String userName) {
        return userDao.checkUserName(userName);
    }

    @Override
    public void reg(String userName, String password) {
        userDao.insertUser(userName, password);
    }
}
