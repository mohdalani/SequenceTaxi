package com.example.pauline.groupprojecttry;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Sequence sequence;
    private Player player;
    private Style style;
    private JSON json;

    /**
     * Constructor method that initializes a JSON field that will store all the fields of the Player class. Will create a Player class object, a Style class object and Sequence class object.
     * @param context "Edmundo Note: Explain what is the context parameter!!!"
     */
    public Controller(Context context){

        json = new JSON();

        player = json.loadPlayer(context);

        style = Style.build(player.getPreferedStyle());

        //Edmundo Note: Is it common to have methods in the constructor?
        createSequence();
    }

    public int getPositionStyle() {
        return player.getPreferedStyle();
    }

    public int getPlayerLives(){
        int lives = player.getLives();
        return lives;
    }

    public List<Style> allStyles() {
        return style.getAllStyles();
    }

    public boolean isStyleBought(int style) {
        return player.isBoughtStyle(style);
    }

    public int getPlayerCoins(){
        int coins = player.getCoins();
        return coins;
    }

    public int getPlayerLevel(){
        int level = player.getLevel();
        return level;
    }

    public void createSequence() {
        sequence = new Sequence(player.getLevel());
    }

    public void upLevel() {
        player.setCoins(player.getCoins()+5+player.getLevel()-1);
        player.setTimeLevel();
    }

    public void clearSequence(Context context) {
        sequence.clearSequence();
        json.savePlayer(context, player);
    }


    public void sequenceSetUserInputs(int valueClick) {
        sequence.setUserInputs(valueClick);
    }

    public boolean checkSequence() {
        return sequence.check();

    }

    public boolean lifeDown() {
        player.setLives(player.getLives()-1);
        if(player.getLives()>0)
            return true;
        else
            return false;
    }

    public ArrayList<Integer> getSequenceOfNumber() {
        return sequence.getSequenceOfNumbers();
    }


    public void resetPlayer() {
        player.resetLevel();
        player.setLives(5);
    }

    public boolean canPay(int i) {
        if(player.getCoins()>i)
            return true;
        else
            return false;
    }

    public void pay(int i) {
        player.setCoins(player.getCoins() - i);
    }

    public void resetUserInput(){
        sequence.userInputReset();
    }

    public void resetPlayerFull() {
       player = new Player();
    }

}
