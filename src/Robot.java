import static java.lang.Thread.sleep;

public class Robot {

    private String name;
    private boolean working = false;

    public Robot(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public boolean isWorking(){
        return working;
    }

    public void talkToRobot(){
        this.working = true;
    }

    public String getWorkingMsg(){
        if(!working){
            throw new IllegalStateException();
        }
        return "I am in working mode";
    }

    public void waitTillWorking() throws InterruptedException{
        //while(!working){
            sleep(100);
        //}
    }
}