package bankmodelsimulator;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    
    private BankCash bankCash;
    
    private List<Operationist> listOperationist = new ArrayList();
    
    public Bank(int summAccount,int colOperationist){
        this.bankCash = new BankCash(summAccount);
        for(int i = 0;i < colOperationist;i++){
            Operationist oper = new Operationist(bankCash);
            listOperationist.add(oper);
            Thread tr = new Thread(oper);
            tr.start();
        }
    }
    
    public void addClient(Client client){
        Operationist minOperationist = null;
        int minSize = -1;
        for(int i = 0;i < listOperationist.size();i++){
            if(minSize < 0 || listOperationist.get(i).getSizeQueue() <= minSize){
                minSize = listOperationist.get(i).getSizeQueue();
                minOperationist = listOperationist.get(i);
            }
        }
        minOperationist.addClientToQueue(client);
    }

    public BankCash getBankCash() {
        return bankCash;
    }

    public void setBankCash(BankCash bankCash) {
        this.bankCash = bankCash;
    }

    public List<Operationist> getListOperationist() {
        return listOperationist;
    }

    public void setListOperationist(List<Operationist> listOperationist) {
        this.listOperationist = listOperationist;
    }
    
    
}
