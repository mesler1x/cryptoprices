package ru.cryptoprices.mesler.cryptoprices.model.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;



public record SymbolsDTO(@NotEmpty List<String> symbols) {

}
