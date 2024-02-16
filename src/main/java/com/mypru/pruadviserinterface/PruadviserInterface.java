package com.mypru.pruadviserinterface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.mypru.entity.PruadviserEntity;
@Repository
@EnableJpaRepositories
public interface PruadviserInterface extends JpaRepository<PruadviserEntity, Long> 
{
 List<PruadviserEntity> findAll();
 Optional<PruadviserEntity> findById(Long id);
 public void deleteAll();
 public void deleteAllById(Long id);
 public Optional<PruadviserEntity> getByPruadviserName(String pruadviserName);
 
 
 
 }