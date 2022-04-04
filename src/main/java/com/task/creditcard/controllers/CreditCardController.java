package com.task.creditcard.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.creditcard.model.CreditCard;
import com.task.creditcard.service.CreditCardService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class CreditCardController {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(CreditCardController.class);

	@Autowired
	CreditCardService creditCardService;

	
	@ApiOperation(value = "create Creditcard based on CreditCard request",notes="saveCreditcard",response=CreditCard.class)
	@ApiResponses(value= {@ApiResponse(code=201,message="",response=CreditCard.class),
			@ApiResponse(code=400,message="Bad Request")})
	@PostMapping(path="/creditcard")
	public ResponseEntity<CreditCard> saveCreditcard(@Valid @RequestBody(required=true) CreditCard creditCard) {
		LOGGER.debug("Creditcard request  : {}",creditCard);
		CreditCard creditCard1 = creditCardService.insert(creditCard);
		LOGGER.debug("saveCreditcard  Response: {}",creditCard1);
		return new ResponseEntity<>(creditCard1, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Get all the credit card details",notes="getAll")
	@GetMapping(path="/creditcard")
	public ResponseEntity<List<CreditCard>> getAll() {
		List<CreditCard> creditCardList = creditCardService.getAll();
		LOGGER.debug("getCreditcard Response  : {}",creditCardList);
		return new ResponseEntity<>(creditCardList, HttpStatus.OK);
	}

}
