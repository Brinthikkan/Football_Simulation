public abstract class Virus {

    String name;
    int age;
    boolean isPatched;
    int population;
    
    Virus (String name){
        this.name = name;
    } 

    abstract void spread();
    
}
