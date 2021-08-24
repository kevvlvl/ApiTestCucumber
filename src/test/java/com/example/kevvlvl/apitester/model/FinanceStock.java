package com.example.kevvlvl.apitester.model;

import java.math.BigDecimal;

public class FinanceStock {

    private String symbol;
    private String name;
    private BigDecimal stockValue;
    private BigDecimal total;

    public FinanceStock() {

    }

    public FinanceStock(String symbol, String name, BigDecimal stockValue, BigDecimal total) {
        this.symbol = symbol;
        this.name = name;
        this.stockValue = stockValue;
        this.total = total;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getStockValue() {
        return stockValue;
    }
    public void setStockValue(BigDecimal stockValue) {
        this.stockValue = stockValue;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
