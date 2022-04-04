package com.task.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.creditcard.model.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long>{

}
