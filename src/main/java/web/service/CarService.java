package web.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;

public interface CarService {
     /*String count(int number);*/
     List <Car> count(int number);
     List <Car> listOfCars ();

}
