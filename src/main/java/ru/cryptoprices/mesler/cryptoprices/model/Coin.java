package ru.cryptoprices.mesler.cryptoprices.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Coin {
    int id;
    String symbol;
    int rank;
    double price;
    String name;
    String type;
}
