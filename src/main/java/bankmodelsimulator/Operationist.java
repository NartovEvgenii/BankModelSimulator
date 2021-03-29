package bankmodelsimulator;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Operationist implements Runnable {
    
    private BankCash bankCash;
    private Queue<Client> queue = new ArrayDeque<Client>();
    
    public Operationist(BankCash bankCash){
        this.bankCash = bankCash;
    }

    @Override
    public void run() {
        while(bankCash.getAccount() > 0){
            while(queue.size() < 1)
            {
                Thread.yield();
            }
            workWithClient(queue.poll());
        }
    }
    
    private void workWithClient(Client client){
        int summ;
        if(client.getTypeOperation().equals(TypeOperation.Put)){
            summ = client.getSummOperation();
        }else{
            summ = -client.getSummOperation();
        }
        try {
            bankCash.refactorAccount(summ,client.getDuration());
            Logger.getLogger(Operationist.class.getName()).log(Level.INFO,
                    "The client made a transaction with the amount {0}. New bankAccount: {1}", new Object[]{summ,bankCash.getAccount()});
        } catch (Exception ex) {
            Logger.getLogger(Operationist.class.getName()).log(Level.WARNING, "The client was unable to complete the transaction: {0}. {1}", new Object[]{summ, ex.getMessage()});
        }
    }
    
    public void addClientToQueue(Client client){
        queue.add(client);
    }
    
    public int getSizeQueue(){
        return queue.size();
    }
    
}
