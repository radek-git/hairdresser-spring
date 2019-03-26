package com.radek.haidresser.repository;

import com.radek.haidresser.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service findByName(String name);

//    List<Service> findAllByPriceGreaterThan(BigDecimal totalPrice);
//
//    List<Service> findAllByPriceIsLessThan(BigDecimal totalPrice);
//
//    List<Service> findAllByPriceIsNear(BigDecimal totalPrice);

}
