package com.task.creditcard.utility;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CreditcardValidation {

	public static boolean isValidCreditCardNumber(String cardNumber) {
		if (cardNumber.matches("[0-9]+")) {
			// int array for processing the cardNumber
			int[] cardIntArray = new int[cardNumber.length()];

			IntStream.range(0, cardNumber.length()).forEach(t -> {
				cardIntArray[t] = Integer.parseInt("" + cardNumber.charAt(t));
			});
			// Iterate cardIntArray from rightmost side starting from cardIntArray.length-2
			// with step of i=i-2
			for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
				int num = cardIntArray[i];
				num = num * 2; // Mulitply digit by 2
				if (num > 9) {
					num = num % 10 + num / 10; // If product is greater than 9, sum the product
				}
				cardIntArray[i] = num; // Assign result back to cardIntArray[i]
			}
			int sum = sumDigits(cardIntArray); // compute sum of elements of cardIntArray

			if (sum % 10 == 0) // if sum%10 is 0 then credit card number is valid else not valid as per luhn
								// algorithm
			{
				return true;
			}
		}
		return false;

	}

	public static int sumDigits(int[] arr) {
		return Arrays.stream(arr).sum();
	}

}
