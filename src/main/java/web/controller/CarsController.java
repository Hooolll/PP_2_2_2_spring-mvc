package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final List<Car> carList = Arrays.asList(
            new Car("Ferrari", 24,(short) 2010),
            new Car("BMW", 2, (short) 2008),
            new Car("Toyota", 5, (short) 2015),
            new Car("Buggati", 1, (short) 2018),
            new Car("Mazda", 13, (short) 2001)
    );

    @Autowired
    private CarService carService;

    @GetMapping
    public String printAllCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> carList1 = carService.getCars(carList, count);
        model.addAttribute("carList1", carList1);
        return "cars";
    }
}
