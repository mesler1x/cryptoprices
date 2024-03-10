package ru.cryptoprices.mesler.cryptoprices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.cryptoprices.mesler.cryptoprices.model.Coin;
import ru.cryptoprices.mesler.cryptoprices.service.CryptoRankCoinService;

@RestController
public class CoinController {
    private final CryptoRankCoinService cryptoRankCoinService;

    @Autowired
    public CoinController(CryptoRankCoinService cryptoRankCoinService) {
        this.cryptoRankCoinService = cryptoRankCoinService;
    }

    @GetMapping("/coins/{symbol}")
    public Coin getCoin(@PathVariable String symbol) throws JsonProcessingException {
        return cryptoRankCoinService.getCoinBySymbol(symbol);
    }
}
