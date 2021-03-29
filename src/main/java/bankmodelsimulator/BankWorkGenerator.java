package bankmodelsimulator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BankWorkGenerator {
        
    public static void startBankWork(int summAccount,int colOperationist
            ,int serviceTime,int clientPerMinute) throws InterruptedException{
        Bank bank = new Bank(summAccount,colOperationist);
        while(true){
            Random random = new Random();
            int clientServiceTime = serviceTime - serviceTime/2 + random.nextInt(serviceTime/2);
            int clientSumm = random.nextInt(1000);
            TypeOperation typeOperation = (random.nextInt(2) == 1)?TypeOperation.Put:TypeOperation.Take;
            Client client = new Client(typeOperation,clientSumm,clientServiceTime);
            Logger.getLogger(Operationist.class.getName()).log(Level.INFO,
                    "A new client has appeared");
            bank.addClient(client);
            int timeSleep = 60000/clientPerMinute - 30000/clientPerMinute + random.nextInt(30000/clientPerMinute);
            Thread.sleep(timeSleep); 
        }
    }
    
}
