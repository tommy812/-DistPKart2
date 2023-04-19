///////////////////////////////////////////
//
//  Sid: 1955004
//
///////////////////////////////////////////
public class Match {

    private boolean started =false;
    private boolean finished =false;
    private int winner;
    private int laps;
    private boolean p1Ready =false;
    private boolean p2Ready =false;


    public String winMessage(){
        return "Winner!";
    }
    public String loserMessage(){
        return "Loser!";
    }


    //Getter and Setter
    public boolean isP1Ready() {
        return p1Ready;
    }
    public void setP1Ready(boolean p1Ready) {
        this.p1Ready = p1Ready;
    }
    public boolean isP2Ready() {
        return p2Ready;
    }
    public void setP2Ready(boolean p2Ready) {
        this.p2Ready = p2Ready;
    }
    public boolean isFinished() {
        return finished;
    }
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    public int getLaps() {
        return laps;
    }
    public void setLaps(int laps) {
        this.laps = laps;
    }
    public boolean isStarted() {
        return started;
    }
    public void setStarted(boolean started) {
        this.started = started;
    }
    public int getWinner() {
        return winner;
    }
    public void setWinner(int winner) {
        this.winner = winner;
    }
}
