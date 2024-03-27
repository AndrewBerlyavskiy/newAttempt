package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class CarServiceImpl implements CarService {
    List<Car> list;
    {
        list = new ArrayList<>();
        list.add(new Car("lada", "granta", 2009));
        list.add(new Car("bmw", "x5", 2020));
        list.add(new Car("honda", "cr-v", 2012));
        list.add(new Car("cherry", "tigo", 2015));
        list.add(new Car("zhigul", "pacanskiy", 1812));
    }

    public List <Car> count (int number) {
        Stream <Car> carych = list.stream();
        List <Car> carychList = carych.limit(number).collect(Collectors.toList());
        return carychList;
    }

    public List <Car> listOfCars () {
        return list;
    }

}