import com.dgwl.App;
import com.dgwl.dao.CarDao;
import com.dgwl.dao.UserDao;
import com.dgwl.eo.Car;
import com.dgwl.service.DgwlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CreateDateBase {


    @Autowired
    CarDao carDao;

    @Test
    public void createCars() {
        for (int i = 0; i < 100; i++) {
            Car car = new Car();
            car.setNumber("津AB" + UUID.randomUUID().toString().substring(0, 6));
            car.setLoad(i % 15 + 1);
            car.setType(i % 2 == 1 ? "小型车" : "大型车");
            car.setCapacity(i % 15 + 1);
            carDao.insertCar(car);
        }
    }

    @Autowired
    @Qualifier("hiveJdbcTemplate")
    JdbcTemplate hiveJdbcTemplate;

    @Test
    public void test2() {
        String sql = "select count(*) from dgwl.test";
        final Integer integer = hiveJdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("integer = " + integer);
    }

    @Resource
    DgwlService dgwlService;

    @Test
    public void test() throws IOException, URISyntaxException, InterruptedException {
        dgwlService.handleOrder();
    }

    @Resource
    UserDao userDao;

    @Test
    public void test3(){
        String sql = "select month,count from dgwl.orderresult";
        final List<Map<String, Object>> maps = hiveJdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

}
