package com.catalyte.training.hotel_room_booking.Controllers;

import com.catalyte.training.hotel_room_booking.Entities.Currency;
import com.catalyte.training.hotel_room_booking.Entities.CurrencyUpdateWrapper;
import com.catalyte.training.hotel_room_booking.Services.CurrencyExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeServiceImpl currencyExchangeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Currency> getCurrencies(@RequestParam(required = false) String currencyName){
        return StringUtils.isEmpty(currencyName) ? currencyExchangeService.getAllCurrencies() : Collections
                .singletonList(currencyExchangeService.getCurrencyByName(currencyName));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCurrency(@RequestBody Currency newCurrency){
        currencyExchangeService.addCurrency(newCurrency);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateCurrency(@RequestBody CurrencyUpdateWrapper currencyUpdateWrapper){
        currencyExchangeService.updateCurrency(currencyUpdateWrapper.getOldCurrency(), currencyUpdateWrapper.getNewCurrency());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCurrency(@RequestParam String currencyName){
        currencyExchangeService.removeCurrency(currencyName);
    }
}
