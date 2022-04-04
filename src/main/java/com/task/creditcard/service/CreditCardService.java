package com.task.creditcard.service;

import java.util.List;

import com.task.creditcard.model.CreditCard;

public interface CreditCardService {

	CreditCard insert(CreditCard creditCard);

	List<CreditCard> getAll();

}
