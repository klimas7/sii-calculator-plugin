package pl.sii.calculatorPlugin;

public enum Operation {

    ADD("+"), SUB("-"), MUL("*"), DIV("/");

    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
