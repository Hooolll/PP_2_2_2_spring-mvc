package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CarDaoImpl implements CarDao {

    protected static final List<Car> carList = Arrays.asList(
            new Car("Ferrari", 12, (short) 5),
            new Car("Bentley", 1, (short) 2),
            new Car("BMW", 2, (short) 3),
            new Car("Lada", 4, (short) 5),
            new Car("Toyota", 2, (short) 3)
    );

//    static {
//        carList.add(new Car("Ferrari", 12, (short) 5));
//        carList.add(new Car("Bentley", 1, (short) 2));
//        carList.add(new Car("BMW", 2, (short) 3));
//        carList.add(new Car("Lada", 4, (short) 5));
//        carList.add(new Car("Toyota", 2, (short) 3));
//    }

    @Override
    public List<Car> getCars(List<Car> carList, int count) {
        if (count >= 5) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
