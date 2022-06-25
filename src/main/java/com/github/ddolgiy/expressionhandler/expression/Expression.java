package com.github.ddolgiy.expressionhandler.expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Provides access to the expression string and methods on it
 */
public class Expression {

    private final static Logger logger = LoggerFactory.getLogger(Expression.class);

    private final String expression;

    private int index;

    /**
     * Initializes new string expression with given string and sets index of next character
     * that able for reading to zero.
     * Expression is final, after initializing it can not be changed
     *
     * @param expression input string of expression
     */
    public Expression(String expression){
        this.expression = expression;
        index = 0;
        System.out.println(index);
    }

    public String get(){
        if(logger.isInfoEnabled()){
            logger.info(
                    "Getting character {"
                    .concat(String.valueOf(expression.charAt(index)))
                    .concat("} at position ").concat(String.valueOf(index)));
        }

        return String.valueOf(expression.charAt(index));
    }

    /**
     * Gets character as a string on particular position
     *
     * @param i index of character that will return
     * @return character as a string
     */
    public String get(int i){
        if (logger.isInfoEnabled()){
            logger.info("Get character : " + expression.charAt(i) + " at position : " + i);
        }
        return String.valueOf(expression.charAt(i));
    }

    /**
     * Gets character as a string on current index
     *
     * @return character as a string onn current index
     */
    public String cut(){
        String res = String.valueOf(expression.charAt(index++));

        if (logger.isInfoEnabled()){
            logger.info("Cutting one character from the expression");
            logger.info("Returned string : " + res);
        }

        return res;
    }

    /**
     * Gets particular amount of characters as a string from expression
     *
     * @param n amount of characters, that will be cut from the expression, starting from index
     * @return string of character taken from expression
     */
    public String cut(int n){
        String res = expression.substring(index++, n);

        if (logger.isInfoEnabled()){
            logger.info("Cutting " + n + "characters from the expression");
            logger.info("Returned string : " + res);
        }

        return res;
    }

    /**
     * Gets string of expression
     *
     * @return string of expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Gets index of current character that will be read.
     * If index equals to length of string then we reached all of the characters
     * and there is not character for read
     *
     * @return index of current processed character
     */
    public int position(){
        return index;
    }

    public boolean isNotEnd(){
        return index != expression.length();
    }
}
