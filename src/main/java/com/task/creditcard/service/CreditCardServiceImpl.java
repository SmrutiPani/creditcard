package com.task.creditcard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.creditcard.exception.ResourceNotFoundException;
import com.task.creditcard.model.CreditCard;
import com.task.creditcard.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	/**
	 * CreditCardRepository autowired
	 */
	@Autowired
	CreditCardRepository creditCardRepository;

	/**
	 * Logger instance is created
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardServiceImpl.class);

	/**
	 * Repository calls to insert/update credit card
	 * 
	 * @param CreditCard - credit card details
	 */
	@Override
	@Transactional
	public CreditCard insert(CreditCard creditCard) {
		CreditCard cc = new CreditCard();

		if (creditCard.getLimit().compareTo(creditCard.getBalance()) == 0
				|| creditCard.getLimit().compareTo(creditCard.getBalance()) == 1) {
			cc = creditCardRepository.save(creditCard);
			LOGGER.info("" + cc);
		} else {
			throw new ResourceNotFoundException("{validate.balance}");
		}
		return cc;
	}

	/**
	 * Repository calls to fetch all credit cards
	 */
	@Override
	public List<CreditCard> getAll() {

		List<CreditCard> listCC = creditCardRepository.findAll();
		LOGGER.info("" + listCC);
		return listCC;
	}

}
