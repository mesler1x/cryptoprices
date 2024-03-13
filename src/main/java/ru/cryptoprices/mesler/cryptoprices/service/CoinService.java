package ru.cryptoprices.mesler.cryptoprices.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.cryptoprices.mesler.cryptoprices.model.Coin;
import ru.cryptoprices.mesler.cryptoprices.model.dto.CoinsDTO;
import ru.cryptoprices.mesler.cryptoprices.model.dto.SymbolsDTO;


public interface CoinService {
    Coin getCoinBySymbol(String symbol) throws JsonProcessingException;
    CoinsDTO getCoinsBySymbols(SymbolsDTO symbolsDTO);
}
