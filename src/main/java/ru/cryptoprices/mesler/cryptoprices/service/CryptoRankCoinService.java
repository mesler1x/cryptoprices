package ru.cryptoprices.mesler.cryptoprices.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.cryptoprices.mesler.cryptoprices.exception.CoinNotFoundException;
import ru.cryptoprices.mesler.cryptoprices.model.Coin;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoRankCoinService implements CoinService{
    private final String apiKey;
    public CryptoRankCoinService(@Value("${cryptorank.api_key}") String apiKey) {
        this.apiKey = apiKey;
    }
    @Override
    public Coin getCoinBySymbol(String symbol) throws JsonProcessingException {
        List<Coin> allCoins = getAllCurrencies();
        for(Coin coin : allCoins){
            if (coin.getSymbol().equalsIgnoreCase(symbol)){
                return coin;
            }
        }
        throw new CoinNotFoundException(symbol);
    }

    public List<Coin> getAllCurrencies() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.cryptorank.io/v1/currencies/?api_key=";
        url += apiKey;
        url += "&limit=5";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);
        List<Coin> coinList = new ArrayList<>();
        for(JsonNode node : jsonNode.get("data")){
            Coin coin = new Coin();
            coin.setId(node.get("id").asInt());
            coin.setSymbol(node.get("symbol").asText());
            coin.setRank(node.get("rank").asInt());
            coin.setPrice(node.get("values").get("USD").get("price").asDouble());
            coin.setCategory(node.get("category").asText());
            coin.setName(node.get("name").asText());
            coin.setType(node.get("type").asText());
            coinList.add(coin);
        }


        return coinList;
    }
}
