///////////////////////////////////////////
//
//  Sid: 1955004
//
///////////////////////////////////////////

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;



public class Car {
    //private attributes
    private final static String RED_KART = "KartRed"; //standard name of the images Red kart
    private final static String BLUE_KART = "KartBlue"; //standard name of the images Blue kart
    protected ImageIcon images[];
    private final int TOT_IMAGES = 16;
    private int currentImg = 0;//img index
    private int pNum;//Player number
    public final static int MAX_SPEED = 100;
    public final static int MIN_SPEED = 0;
    private int lap = 0;
    private int speed;
    private int positionX;
    private int positionY;
    private boolean crashed = false;
    private int direction = 4;
    private String alert = "";
    private String Status;
    public Rectangle area;
    private boolean accelerating = false;
    private int checkPoint=0;
    private int[] checkPoints={1,2,3,4,5};
    public boolean isPlayed=false;






    //methods
    //setting the player number and loading sprite
    public Car(int PNum) {
        this.pNum = PNum;
        if (PNum == 1) {
            images = new ImageIcon[TOT_IMAGES];
            //loading all 32 Images
            for (int i = 0; i < images.length; i++) {
                images[i] = new ImageIcon(getClass().getResource("Karts/KartRed/" + RED_KART + i + ".png"));
            }//For loop
            setPositionX(580);
            setPositionY(550);
            setStatus("Press 'Z' to start.");
        } else if (PNum == 2) {
            images = new ImageIcon[TOT_IMAGES];
            //loading all 32 Images
            for (int i = 0; i < images.length; i++) {
                images[i] = new ImageIcon(getClass().getResource("Karts/KartBlue/" + BLUE_KART + i + ".png"));
            }//For loop
            setPositionX(575);
            setPositionY(500);
            setStatus("Press 'M' to start.");
        }
    }//end Car
    //draw Car in the main panel
    public void draw(Graphics2D g2, JPanel panel) {
        this.images[this.getDirection()].paintIcon(panel, g2, this.getPositionX(), this.getPositionY());
        //invisible rectangle as car solid area
        area = new Rectangle(positionX+15,positionY+15,17,17);
        Color c6 = Color.WHITE;
    }

    //move car based on speed and car direction
    public void animate() {
        if(this.getDirection()==0)
        {
            this.setPositionY(this.getPositionY() - 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==1)

        {
            this.setPositionX(this.getPositionX() + 1 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() - 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==2)

        {
            this.setPositionX(this.getPositionX() + 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() - 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==3)

        {
            this.setPositionX(this.getPositionX() + 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() - 1 * (this.getSpeed() / 10));
        }else if(this.getDirection()==4 )

        {
            // displace image
            this.setPositionX(this.getPositionX() + 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==5)

        {
            this.setPositionX(this.getPositionX() + 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() + 1 * (this.getSpeed() / 10));
        }else if(this.getDirection()==6)

        {
            this.setPositionX(this.getPositionX() + 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() + 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==7)

        {
            this.setPositionX(this.getPositionX() + 1 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() + 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==8)

        {

            this.setPositionY(this.getPositionY() + 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==9)

        {
            this.setPositionX(this.getPositionX() - 1 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() + 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==10)

        {
            this.setPositionX(this.getPositionX() - 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() + 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==11)

        {
            this.setPositionX(this.getPositionX() - 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() + 1 * (this.getSpeed() / 10));
        }else if(this.getDirection()==12)

        {
            // displace image
            this.setPositionX(this.getPositionX() - 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==13)

        {
            this.setPositionX(this.getPositionX() - 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() - 1 * (this.getSpeed() / 10));
        }else if(this.getDirection()==14)

        {
            this.setPositionX(this.getPositionX() - 2 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() - 2 * (this.getSpeed() / 10));
        }else if(this.getDirection()==15)

        {
            this.setPositionX(this.getPositionX() - 1 * (this.getSpeed() / 10));
            this.setPositionY(this.getPositionY() - 2 * (this.getSpeed() / 10));
        }

    }

    //speed controls
    public void increaseSpeed() {
        setSpeed(speed + 10);
    }

    public void decreaseSpeed(){
        this.speed = speed-10;
    }




    //collision control
    public boolean checkCollision( ) {
        //check collision for the outer edge
        //check if within the box

        if (getPositionX() +25 >= 250 &&
                getPositionX() <= 250 + 750 &&
                getPositionY() + 25 >= 100 &&
                getPositionY() <= 100 + 500
        ){
            //check collision for the grass field
            // 50 px margin allowed on each side
            if (getPositionX()  >= 350 &&
                    getPositionX() <= 350 + 500 &&
                    getPositionY() +50 >= 240&&
                    getPositionY() <= 170 + 290
            ) {
                this.setAlert("Hit the grass Field.");
                setCrashed(true);
                return true;
            }else {
                if(!alert.equals("Winner!")){
                    this.setAlert("");
                }

            }
        }else {
            this.setAlert("Hit the wall.");
            setSpeed(MIN_SPEED);
            setCrashed(true);
            return true;
        }
        return false;
    }

    //implement sounds
    public void audioPlayer(int event){
        switch(event){
            case 1: //Cars crash
                try{
                    String audioFilePath="Sounds/Crash.wav";
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResource(audioFilePath));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
            case 2: // Cars goes out of track
                try{
                    String audioFilePath="Sounds/outfield.wav";
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResource(audioFilePath));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
            case 3://match start countdown
                try{
                    String audioFilePath="Sounds/start-count.wav";
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResource(audioFilePath));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
            case 4://winner message
                try{
                    String audioFilePath="Sounds/win.wav";
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResource(audioFilePath));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
        }

    }


    public void checkCrash(Car redCar,Car blueCar) {
        //game over if cars intersect
        if (redCar.area.intersects(blueCar.area)) {
            redCar.setSpeed(redCar.MIN_SPEED);
            blueCar.setSpeed(blueCar.MIN_SPEED);
            redCar.setAlert("Game Over");
            blueCar.setAlert("Game Over");
            if(!this.isPlayed) {
                redCar.audioPlayer(1);
                isPlayed = true;
            }
        }
    }




    //Laps
    public void countLaps(Match match,Rectangle cP1,Rectangle cP2,Rectangle cP3,Rectangle cP4, Rectangle cP5,Rectangle gameField){
        //if the cars go aut of the game-field rectangle then are teleported to the last checkpoint
        //if cars go through a cP then increase the current checkpoint
        switch (checkPoint){
            case 0:
                if(!gameField.contains(this.area)){
                    setPositionX(cP5.x-50);
                    setPositionY(cP5.y+50);
                    setSpeed(0);
                    setDirection(4);
                } else if(this.area.intersects(cP1)){
                    checkPoint++;
                }

                break;
            case 1:
                if(!gameField.contains(this.area)){
                    setPositionX(cP1.x+50);
                    setPositionY(cP1.y+50);
                    setSpeed(0);
                    setDirection(0);
                }else if(this.area.intersects(cP2)){
                    checkPoint++;
                }

                break;
            case 2:
                if(!gameField.contains(this.area)){
                    setPositionX(cP2.x+50);
                    setPositionY(cP2.y+50);
                    setSpeed(0);
                    setDirection(12);
                }
                else if(this.area.intersects(cP3)){
                    checkPoint++;
                }

                break;
            case 3:

                if(!gameField.contains(this.area)){
                    setPositionX(cP3.x+50);
                    setPositionY(cP3.y+50);
                    setSpeed(0);
                    setDirection(8);
                }
                else if(this.area.intersects(cP4)){
                    checkPoint++;
                }
                break;
            case 4:

                if(!gameField.contains(this.area)){
                    setPositionX(cP4.x+50);
                    setPositionY(cP4.y+50);
                    setSpeed(0);
                    setDirection(4);
                }
                else if(cP5.intersects(this.area)){
                    checkPoint++;
                }
                break;
            case 5:

                checkPoint =0;
                this.setLap(lap+1);
                break;
        }

        if(match.getLaps() == this.lap){
            match.setWinner(this.pNum);
            match.setFinished(true);
            //this.setStatus("Race Finished!");

        }
    }







    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }

    //Getter and Setter
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public boolean isCrashed() {
        return crashed;
    }
    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }
    public String getAlert() {
        return alert;
    }
    public void setAlert(String alert) {
        this.alert = alert;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public int getLap() {
        return lap;
    }
    public void setLap(int lap) {
        this.lap = lap;
    }

    public void setCheckpoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }
}
