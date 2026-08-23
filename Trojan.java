public class Trojan extends Virus {

    Trojan (String name){
        super(name);
    }
    
    @Override
    void spread(){
        population += 1;
    }
}