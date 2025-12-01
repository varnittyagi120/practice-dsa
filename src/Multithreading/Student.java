package src.Multithreading;

class Student {
    int id;
    String name;
    Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}
