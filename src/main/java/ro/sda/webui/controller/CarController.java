package ro.sda.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sda.webui.car.Car;
import ro.sda.webui.car.CarService;

import java.util.List;

@Controller
@RequestMapping("car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("car/add.html");
        Car car = new Car();
        car.setName("Dacia");
        car.setHp(10);
        modelAndView.addObject("myCar", car);
        return modelAndView;
    }

    @PostMapping("save")
    public String savePage(@ModelAttribute("myCar") Car car) {
        System.out.println(car);
        return "car/add.html";
    }

    @GetMapping("list")
    public ModelAndView listPage() {
        List<Car> allCars = carService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("car/list.html");
        modelAndView.addObject("cars", allCars);
        return modelAndView;
    }
}