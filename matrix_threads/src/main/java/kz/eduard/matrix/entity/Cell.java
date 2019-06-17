package kz.eduard.matrix.entity;


public class Cell {
    private int number;
    private boolean isEmpty;

    public Cell(int number){
        this.number = number;
        this.isEmpty = false;
    }

    public Cell(){
        this.isEmpty = true;
    }

    public int getNumber(){
        return number;
    }

    public boolean getEmpty(){
        return isEmpty;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}