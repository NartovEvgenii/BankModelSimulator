package bankmodelsimulator;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BankCash {
    
    private int account;
    
    public BankCash(int account){
        this.account = account;
    }
    
    synchronized public void refactorAccount(int summ,int duration) throws Exception{
        if (account+summ < 0){
            throw new Exception("The bank does not have enough money for this operation");
        }else{
            Thread.sleep(duration);
            setAccount(account + summ);            
        }
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
    
    
    
}
