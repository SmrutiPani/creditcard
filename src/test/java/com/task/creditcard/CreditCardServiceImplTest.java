package com.task.creditcard;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.creditcard.model.CreditCard;
import com.task.creditcard.repository.CreditCardRepository;
import com.task.creditcard.service.CreditCardServiceImpl;



@SpringBootTest
public class CreditCardServiceImplTest {
	
	@Mock
	CreditCardRepository creditCardRepository;
	
	@InjectMocks
	CreditCardServiceImpl creditCardServiceImpl;
	
//	@Before
//	public void init() {
//		MockitoAnnotations.openMocks(this);
//	}
@Test
public void saveTest() {
	CreditCard c=new CreditCard();
	c.setCreditcard_number("79927398713");
	c.setCurrencyType("inr");
	c.setLastModified(new Date());
	BigDecimal vb=BigDecimal.ONE;
	c.setLimit(vb);
	c.setBalance(vb);
	c.setDateCreated(new Date());
	c.setName("Smruti");
	c.setId(1l);
	when(creditCardRepository.save(Mockito.any(CreditCard.class))).thenReturn(c);
	CreditCard ceditcard=creditCardServiceImpl.insert(c);
	
	assertEquals("79927398713", ceditcard.getCreditcard_number());
	assertEquals("inr", ceditcard.getCurrencyType());
	
}

@Test
public void saveTestneg() {
	List<CreditCard> cl=new ArrayList<>();
	CreditCard c=new CreditCard();
	c.setCreditcard_number("79927398713");
	c.setCurrencyType("inr");
	c.setLastModified(new Date());
	BigDecimal vb=BigDecimal.TEN;
	BigDecimal limit=BigDecimal.TEN;
	c.setLimit(limit);
	c.setBalance(vb);
	c.setDateCreated(new Date());
	c.setName("Smruti");
	c.setId(1l);
	cl.add(c);
	when(creditCardRepository.findAll()).thenReturn(cl);
	List<CreditCard> ceditcardList=creditCardServiceImpl.getAll();
	
	assertEquals(1,ceditcardList.size());
}
}
