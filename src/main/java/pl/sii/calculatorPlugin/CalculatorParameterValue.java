package pl.sii.calculatorPlugin;

import hudson.model.ParameterValue;
import org.kohsuke.stapler.DataBoundConstructor;

public class CalculatorParameterValue extends ParameterValue {
    private String first;
    private String second;
    private Operation operation;

    @DataBoundConstructor
    public CalculatorParameterValue(String name, String description) {
        this(name, description, null, null, Operation.ADD);
    }

    public CalculatorParameterValue(String name, String description, String first, String second, Operation operation) {
        super(name, description);
        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String toString() {
        return "(CalculatorParameterValue) " + this.getName() + ": First: " + this.first + " Second: " + this.second;
    }

    //TODO createBuildWrapper
}
