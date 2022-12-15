package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpNE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarsController extends CarDaoImpl {

    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public String printAllCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> listCars = carService.getCars(carList, count);
        model.addAttribute("cars", listCars);
        return "cars";
    }
}
