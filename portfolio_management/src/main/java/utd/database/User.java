package utd.database;

import java.util.*;

public class User {
    
    private String accountID;
    protected ArrayList<Holding> stocks = new ArrayList<>();
    private String phrase;
    public User(String accountID){
        this.accountID = accountID;
    }

    public User(){
    }

    public void addStocks(Stock stock, int ammount){
        stocks.add(new Holding(stock, ammount));
    }


    public void setPhrase() { 
        phrase = generateMnemonicPhrase();
        //TODO set it in the database
    }

    public String getPhrase(){
        return phrase;
    }

    private String generateMnemonicPhrase(){
        String phrase = "";
        char[] alphabet = new char[26];
        int character = 65;
        for (int i = 0; i < 26; i++){
            alphabet[i] = (char) character;
            character++;
        }
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            phrase = phrase + alphabet[random.nextInt(26)];
        }
        return phrase;
    }
}
