package ru.cryptoprices.mesler.cryptoprices.exception;

import java.util.function.Supplier;

public class CoinNotFoundException extends RuntimeException {
    public CoinNotFoundException(String symbol){
        super("could not find coin with symbol" + symbol);
    }
}
