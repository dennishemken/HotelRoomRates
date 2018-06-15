package com.catalyte.training.hotel_room_booking.Services;

import com.catalyte.training.hotel_room_booking.Constants.ErrorMessages;
import com.catalyte.training.hotel_room_booking.CustomExceptions.CurrencyNotFound;
import com.catalyte.training.hotel_room_booking.CustomExceptions.InvalidCurrency;
import com.catalyte.training.hotel_room_booking.Entities.Currency;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyExchangeServiceImpl {
    private List<Currency> currencyList;

    public CurrencyExchangeServiceImpl(){
        currencyList = new ArrayList<>();
        currencyList.add(new Currency("BTC", .00083d));
        currencyList.add(new Currency("CAD", 1.31d));
        currencyList.add(new Currency("GDP", .80d));
        currencyList.add(new Currency("CNY", 6.87d));
        currencyList.add(new Currency("USD", 1d));
    }

    public Double convertCurrency(String selectedCurrencyName, Double price) {
        Currency selectedCurrency = getCurrencyByName(selectedCurrencyName);

       return price * selectedCurrency.getCurrencyExchangeRate();
    }

    public Currency getCurrencyByName(String selectedCurrencyName){
        for(Currency currency : currencyList){
            if(currency.getCurrencyName().equals(selectedCurrencyName)){
                return currency;
            }
        }
        throw new CurrencyNotFound();
    }

    public void updateCurrency(Currency oldTarget, Currency newTarget){
        //region Guard Clauses
        validateCurrency(newTarget);
        //endregion
        if(currencyList.contains(oldTarget)){
            currencyList.remove(oldTarget);
            currencyList.add(newTarget);
        }
        else{
            throw new CurrencyNotFound();
        }
    }

    private void validateCurrency(Currency currency){
        if(StringUtils.isEmpty(currency.getCurrencyName())){
            throw new InvalidCurrency(ErrorMessages.MISSING_CURRENCY_NAME);
        }
        if(currency.getCurrencyExchangeRate() == null){
            throw new InvalidCurrency(ErrorMessages.MISSING_CURRENCY_EXCHANGE_RATE);
        }
    }

    public void removeCurrency(Currency target){
        //region Guard Clauses
        validateCurrency(target);
        if(!currencyList.contains(target)){
            throw new CurrencyNotFound();
        }
        //endregion
        currencyList.remove(target);
    }

    public void removeCurrency(String currencyName){
        //region Guard Clauses
        if(currencyName.equals("USD")){
            throw new InvalidCurrency(ErrorMessages.CANNOT_REMOVE_USD);
        }
        //endregion

        removeCurrency(getCurrencyByName(currencyName));
    }

    public List<Currency> getAllCurrencies(){
        return currencyList;
    }

    public void addCurrency(Currency newCurrency){
        //region Guard Clauses
        validateCurrency(newCurrency);
        if(currencyList.contains(newCurrency)){
            throw new InvalidCurrency(ErrorMessages.CURRENCY_ALREADY_EXISTS);
        }
        //endregion
        currencyList.add(newCurrency);
    }
}
