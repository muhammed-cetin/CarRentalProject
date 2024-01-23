package com.cetin.carrentalproject.mapper;

import com.cetin.carrentalproject.dto.CreditCardDto;
import com.cetin.carrentalproject.model.CreditCard;
import org.springframework.stereotype.Service;

@Service
public class CreditCardDtoMapper {

    public static CreditCard mapToCreditCard(CreditCardDto creditCardDto) {

        return CreditCard.builder()
                .cardNumber(creditCardDto.getCardNumber())
                .month(creditCardDto.getMonth())
                .year(creditCardDto.getYear())
                .CVV(creditCardDto.getCVV())
                .accountBalance(0L)
                .build();
    }
}
