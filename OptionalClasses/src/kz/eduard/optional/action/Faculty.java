package kz.eduard.optional.action;

public enum Faculty {
    COMPUTER_SCIENCE("Computer Science"), LITERATURE("Literature"), DESIGN("Design");

    private String facultyName;

    Faculty(String facultyName){
        this.facultyName = facultyName;
    }

    public String getFacultyName(){
        return facultyName;
    }
}
