import com.dgwl.App;
import com.dgwl.dao.CarDao;
import com.dgwl.eo.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
