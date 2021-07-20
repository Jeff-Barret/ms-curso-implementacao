package com.microservico.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservico.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
