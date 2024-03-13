package ru.cryptoprices.mesler.cryptoprices.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.cryptoprices.mesler.cryptoprices.exception.CoinNotFoundException;
import ru.cryptoprices.mesler.cryptoprices.model.Coin;
import ru.cryptoprices.mesler.cryptoprices.model.dto.CoinsDTO;
import ru.cryptoprices.mesler.cryptoprices.model.dto.SymbolsDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoRankCoinService implements CoinService {
    private final String apiKey = System.getenv("apiKey");

    @Override
    public Coin getCoinBySymbol(String symbol) {
        List<Coin> allCoins = getAllCoins();
        for (Coin coin : allCoins) {
            if (coin.getSymbol().equalsIgnoreCase(symbol)) {
                return coin;
            }
        }
        throw new CoinNotFoundException(symbol);
    }

    public List<Coin> getAllCoins() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.cryptorank.io/v1/currencies/?api_key=";
        url += apiKey;
        url += "&limit=20";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<Coin> coinList = new ArrayList<>();
        for (JsonNode node : jsonNode.get("data")) {
            Coin coin = new Coin();
            coin.setId(node.get("id").asInt());
            coin.setSymbol(node.get("symbol").asText());
            coin.setRank(node.get("rank").asInt());
            coin.setPrice(node.get("values").get("USD").get("price").asDouble());
            coin.setName(node.get("name").asText());
            coin.setType(node.get("type").asText());
            coinList.add(coin);
        }


        return coinList;
    }

    public CoinsDTO getCoinsBySymbols(SymbolsDTO symbolsDTO) {// [BTC, USDT, ALL]
        List<String> symbols = symbolsDTO.symbols();
        List<Coin> acceptedCoins = new ArrayList<>();
        for (String sym : symbols){
            acceptedCoins.add(getCoinBySymbol(sym));
        }
        return new CoinsDTO(acceptedCoins);
    }
}
