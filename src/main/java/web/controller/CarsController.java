package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;
    @GetMapping(value = "/cars")
    public String count (@RequestParam (value = "count", defaultValue = "0") int count, ModelMap model) {
        switch (count) {
            case 2: model.addAttribute("list", carService.count(2));
            break;
            case 3: model.addAttribute("list", carService.count(3));
            break;
            case 4: model.addAttribute("list", carService.count(4));
            break;
            default: model.addAttribute("list", carService.listOfCars());
            break;
        }
        model.addAttribute("listik", carService.listOfCars());
        /*чтобы в thymeleaf что-то отобразилось, нужно использовать геттеры, сеттеры и поля*/
        return "cars";
    }

}
