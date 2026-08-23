public class Worm extends Virus {

    Worm (String name){
        super(name);
    }
    
    @Override
    void spread(){
        population += 2;
    }
}
