package com.example.calculator;

public class Engine {
    private String equation;
    private EngineState engineState;
    private int operandA;
    private int operandB;
    private char operator;

    public Engine(){
        this.equation="0";
        this.engineState=EngineState.INITIALIZED;
    }

    //Methods

    /**
     * takes a character to add to the equation and process.
     * @param c a character inputted to be processed.
     */
    public void input(char c){
        switch(this.engineState){
            case INITIALIZED:
                if(Character.isDigit(c)) {
                    this.equation = ""+c;
                    this.operandA = c-'0';
                    this.engineState=EngineState.READING_OPERAND_A;
                }
                break;
            case READING_OPERAND_A:
                if(Character.isDigit(c)){
                    this.operandA=this.operandA*10+(c-'0');
                    this.equation=this.equation+c;
                }else if(c != '='){
                    this.operator=c;
                    this.engineState=EngineState.READING_OPERAND_B;
                    this.equation=this.equation+c;
                }
                break;
            case READING_OPERAND_B:
                if(Character.isDigit(c)){
                    this.operandB=this.operandB*10+(c-'0');
                    this.equation=this.equation+c;
                }else if (c=='='){
                    this.engineState=EngineState.DISPLAYING_RESULT;
                    int result=0;
                    boolean resultNaN=false;
                    switch(this.operator){
                        case '+':
                            result = this.operandA+this.operandB;
                            break;
                        case '-':
                            result=this.operandA-this.operandB;
                            break;
                        case 'x':
                            result=this.operandA*this.operandB;
                            break;
                        case '/':
                            if(this.operandB==0){
                                result = 0;
                                resultNaN=true;
                            } else {
                                result = this.operandA / this.operandB;
                            }
                            break;
                    }
                    if(resultNaN){
                        this.equation=this.equation + c + "NaN";
                    } else {
                        this.equation = this.equation + c + result;
                    }
                }
                break;
            case DISPLAYING_RESULT:
                if(Character.isDigit(c)) {
                    this.equation = ""+c;
                    this.operandA = c-'0';
                    this.operandB=0;
                    this.engineState=EngineState.READING_OPERAND_A;
                }
                break;
        }
    }

    //getters

    public String getEquation() {
        return equation;
    }
}
