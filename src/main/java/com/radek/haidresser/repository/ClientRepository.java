package com.radek.haidresser.repository;

import com.radek.haidresser.entity.Client;
import com.radek.haidresser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client> {

    Optional<Client> findByName(String name);

    Optional<Client> findByUsername(String username);
}
