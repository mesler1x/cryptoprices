package ru.cryptoprices.mesler.cryptoprices.model.dto;

import jakarta.validation.constraints.NotEmpty;
import ru.cryptoprices.mesler.cryptoprices.model.Coin;

import java.util.List;

public record CoinsDTO(@NotEmpty List<Coin> coins) {
}
