package com.bankapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.entities.TransactionLog;

public interface TransactionLogRepository extends JpaRepository<TransactionLog,Long>{

}
