public class Spyware extends Virus {

    
Spyware (String name){
        super(name);
    }
    
    @Override
    void spread(){
        population += 1;
    }
}