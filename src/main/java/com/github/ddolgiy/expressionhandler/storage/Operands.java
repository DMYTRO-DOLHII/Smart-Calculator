package com.github.ddolgiy.expressionhandler.storage;

import java.util.ArrayList;

public class Operands extends Storage<Double> {

    public Double replace(int i, Double newOperand){
        return this.storage.set(i, newOperand);
    }
}
