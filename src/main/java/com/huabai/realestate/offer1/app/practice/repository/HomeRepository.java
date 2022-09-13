package com.huabai.realestate.offer1.app.practice.repository;

import com.huabai.realestate.offer1.app.practice.domain.Home;
import com.huabai.realestate.offer1.app.practice.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {


//    public Home findByProperty(Property property);
}
