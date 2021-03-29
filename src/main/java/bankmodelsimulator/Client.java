
package bankmodelsimulator;

import java.time.Duration;

enum TypeOperation{
    Put,
    Take
}

public class Client {
    
    private TypeOperation typeOperation;
    
    private int summOperation;
    
    private int duration;
    
    public Client(TypeOperation typeOperation,int summOperation,int duration){
        this.typeOperation = typeOperation;
        this.summOperation = Math.abs(summOperation);
        this.duration = duration;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getSummOperation() {
        return summOperation;
    }

    public void setSummOperation(int summOperation) {
        this.summOperation = summOperation;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
    
}
