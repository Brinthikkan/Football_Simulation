public class Ball extends Entity {

    Ball (int xPos, int yPos){
        super(xPos, yPos);
    }

        void move(int x, int y){
        xPos += x;
        yPos += y;
    }

}
