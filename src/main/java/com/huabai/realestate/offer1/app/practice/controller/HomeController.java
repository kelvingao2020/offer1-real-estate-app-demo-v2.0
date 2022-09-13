package com.huabai.realestate.offer1.app.practice.controller;

import com.huabai.realestate.offer1.app.practice.domain.Home;
import com.huabai.realestate.offer1.app.practice.service.HomeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/homes")
public class HomeController {

    private HomeService homeService;

    public HomeController(HomeService homeService) {

        this.homeService = homeService;
    }

    @GetMapping("/getHomes")
    public Iterable<Home> getHomes() {

        return homeService.getHomes();
    }

    @GetMapping("/{id}")
    public Optional<Home> getHomeById(@PathVariable Long id){

        return homeService.getHomeById(id);
    }

    @GetMapping("/city/{city}")
    public Iterable<Home> getHomesByCity(@PathVariable String city){

        return homeService.getHomesByCity(city);
    }

    @GetMapping("/price/{price}")
    public Iterable<Home> getHomesByPrice(@PathVariable int price){
        return homeService.getHomesByPrice(price);
    }

    @GetMapping("/rooms/{num}")
    public Iterable<Home> getHomesByNumOfRooms(@PathVariable int num){
        return homeService.getHomesByNumOfRooms(num);
    }

    @GetMapping("/forSale")
    public Iterable<Home> getHomesForSale(){
        return homeService.getHomesForSale();
    }

    @PutMapping("/offer")
    public String makeOffer(@RequestParam Long id, @RequestParam int amount){
        return homeService.makeOffer(id, amount);
    }

    @GetMapping("/getOffers")
    public String getOffers(){
        return homeService.getOffers();
    }
}
