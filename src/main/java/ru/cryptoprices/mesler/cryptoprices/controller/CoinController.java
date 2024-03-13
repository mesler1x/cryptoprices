package ru.cryptoprices.mesler.cryptoprices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cryptoprices.mesler.cryptoprices.model.Coin;
import ru.cryptoprices.mesler.cryptoprices.model.dto.CoinsDTO;
import ru.cryptoprices.mesler.cryptoprices.model.dto.SymbolsDTO;
import ru.cryptoprices.mesler.cryptoprices.service.CryptoRankCoinService;

@RestController
@RequiredArgsConstructor
public class CoinController {
    private final CryptoRankCoinService cryptoRankCoinService;
    @GetMapping("/coins/{symbol}")
    public Coin getCoin(@PathVariable String symbol){
        return cryptoRankCoinService.getCoinBySymbol(symbol);
    }

    @PostMapping("/coins/getCoinsBySymbols")
    public CoinsDTO getCoinsBySymbols(@RequestBody SymbolsDTO symbolsDTO){
        return cryptoRankCoinService.getCoinsBySymbols(symbolsDTO);
    }
}
