/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server.parser;

/**
 *
 * @author jhony
 */
public class Token {
    private final int Line;
    private final int Column;
    private String Value;
    private final int Type;

    public Token(int Line, int Column, String Value, int Type) {
        this.Line = Line;
        this.Column = Column;
        this.Value = Value;
        this.Type = Type;
    }

    public Token(int Line, int Column, int Type) {
        this.Line = Line;
        this.Column = Column;
        this.Type = Type;
    }
    
    public int getLine() {
        return Line;
    }

    public int getColumn() {
        return Column;
    }

    public String getValue() {
        return Value;
    }
    
    public int getType(){
        return Type;
    }
    
    @Override
    public String toString(){
        return "Valor: " + Value + " linea: " + Line + " Columna: " + Column; 
    }
    
    
}
