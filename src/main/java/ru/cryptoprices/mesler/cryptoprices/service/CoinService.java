package ru.cryptoprices.mesler.cryptoprices.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.cryptoprices.mesler.cryptoprices.model.Coin;


public interface CoinService {
    public Coin getCoinBySymbol(String symbol) throws JsonProcessingException;
}
