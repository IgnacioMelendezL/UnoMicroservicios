package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Carta;

public interface BarajaDao extends JpaRepository<Carta, Integer> {

}