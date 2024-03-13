package ru.cryptoprices.mesler.cryptoprices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coin {
    int id;
    String symbol;
    int rank;
    double price;
    String name;
    String type;
}
