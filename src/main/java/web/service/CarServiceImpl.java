package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarServiceImpl(@Qualifier("carDaoImpl") CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(List<Car> carList, int count) {
        return carDao.getCars(carList, count);
    }
}
