package com.huabai.realestate.offer1.app.practice.service;

import com.huabai.realestate.offer1.app.practice.domain.Home;
import com.huabai.realestate.offer1.app.practice.domain.Property;
import com.huabai.realestate.offer1.app.practice.domain.PropertyAddress;
import com.huabai.realestate.offer1.app.practice.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HomeService {

    final private HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {

        this.homeRepository = homeRepository;
    }

    public void save(List<Home> homes) {

        homeRepository.saveAll(homes);
    }

    public Iterable<Home> getHomes() {

        return homeRepository.findAll();
    }

    public Optional<Home> getHomeById(Long id) {

        return homeRepository.findById(id);
    }

    public Iterable<Home> getHomesByCity(String city) {

        Iterable<Home> result = new ArrayList<>();
        Iterable<Home> list = homeRepository.findAll();
        for (Home home : list) {
            Property property = home.getProperty();
            PropertyAddress address = property.getAddress();
            if (address.getCity().equals(city)) {
                ((ArrayList<Home>) result).add(home);
            }
        }
        return result;
    }

    public Iterable<Home> getHomesByNumOfRooms(int num) {

        Iterable<Home> result = new ArrayList<>();
        Iterable<Home> list = homeRepository.findAll();
        for (Home home : list) {
            Property property = home.getProperty();
            if (property.getNumberBedrooms() == num) {
                ((ArrayList<Home>) result).add(home);
            }
        }
        return result;
    }

    public Iterable<Home> getHomesByPrice(int price) {

        Iterable<Home> result = new ArrayList<>();
        Iterable<Home> list = homeRepository.findAll();
        for (Home home : list) {
            if (home.getPrice() == price) {
                ((ArrayList<Home>) result).add(home);
            }
        }
        return result;
    }

    public Iterable<Home> getHomesForSale() {

        Iterable<Home> result = new ArrayList<>();
        Iterable<Home> list = homeRepository.findAll();
        for (Home home : list) {
            if (home.getState().equals("Active")) {
                ((ArrayList<Home>) result).add(home);
            }
        }
        return result;
    }

    public String makeOffer(Long id, int amount) {

        Optional<Home> home = homeRepository.findById(id);
        if (!home.isPresent()) {
            throw new IllegalArgumentException("Wrong Id to get Home！");
        }
        Home theHome = home.get();
        if (!(theHome.getState()).equals("PreSale")) {
            return "Wrong Id for PreSale state";
        }
        if(amount <= theHome.getOffer()){
            return "Your offer is less competitive.";
        } else {
            theHome.setOffer(amount);
        }
        homeRepository.save(theHome);
        return "Make Offer successfully!";
    }

    public String getOffers() {

        Map<Long, Integer> result = new HashMap<>();
        Iterable<Home> list = homeRepository.findAll();
        for (Home home : list) {
            if (home.getState().equals("PreSale") && home.getOffer() != 0) {
                result.put(home.getId(), home.getOffer()) ;
            }
        }
        Iterator resultIterator = result.entrySet().iterator();
        String resultStr = "";
        while (resultIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry)resultIterator.next();
            Long homeId = (Long) mapElement.getKey();
            int topOffer = (int) mapElement.getValue();

            String temp = "HomeId: " + homeId + ", " + "TopOffer: " + topOffer + "\n";
            resultStr += temp;
        }
        return resultStr;
    }
}
