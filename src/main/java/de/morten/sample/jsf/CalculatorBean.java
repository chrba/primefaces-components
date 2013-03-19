package de.morten.sample.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

@RequestScoped
@Named
public class CalculatorBean {
    @Inject
    Calculator calculator;
    private double x;
    private double y;
    private double result;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String add() {
        result = calculator.add(x, y);
        return "result";
    }
}