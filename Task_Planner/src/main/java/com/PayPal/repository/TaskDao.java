package com.PayPal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PayPal.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {

}
