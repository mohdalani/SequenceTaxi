package com.example.pauline.groupprojecttry;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Style {

    private ArrayList<Integer> images;
    private HashMap<Integer, Integer> sequenceButtons;
    private HashMap<Integer, String> styles;
    private Random randomInt = new Random();


    // Edmundo Note: The "Controller" field does not have an access modifier do we need it? This method is not used do we need to have it?
    Controller controller;
    // Edmundo Note: The "pos" field does not have an access modifier do we need it? This method is not used do we need to have it?
    int pos;

    /**
     *
     * Constructor method that initializes the sequenceButtons, images, styles field and
     *
     * @param pos
     */
    public Style(int pos) {
        sequenceButtons = new HashMap<>();
        images = new ArrayList<>();
        styles = new HashMap<>();


        //Edmundo Note: Is it common practice to have methods in the constructor?
        // But if we want to use the code form lines 31 to 33 we should create a method instead.
        styles.put(0, "directions");
        styles.put(1, "animals");
        styles.put(2, "numbers");
        loadStyle(pos);

    }

    public int getImages() {
        int value = randomInt.nextInt(images.size());
        return images.get(value);
    }

    public int getPlayButtons(int key) {
        if (key > 0 && key <5) {
            return sequenceButtons.get(key);
        }
        return 0;
    }

    public String getStyle(int pos){
        String style = styles.get(pos);
        return style;
    }

    public HashMap<Integer, String> getAllStyle() {
        return styles;
    }

    public void loadStyle(int pos) {
        if(getStyle(pos).equals("directions")){
            directionStyle();
        } else if(getStyle(pos).equals("animals")){
            animalStyle();
        } else if(getStyle(pos).equals("numbers")) {
            numberColorStyle();
        } else{
            directionStyle();
        }

    }

    public void directionStyle() {
        sequenceButtons.put(1, R.drawable.left_white);
        sequenceButtons.put(2, R.drawable.up_white);
        sequenceButtons.put(3, R.drawable.down_white);
        sequenceButtons.put(4, R.drawable.right_white);

        images.add(R.drawable.stockholm_colorful);
        images.add(R.drawable.stockholm_gamlastan);
        images.add(R.drawable.stockholm_gamlastannight);
        images.add(R.drawable.stockholm_globen);
        images.add(R.drawable.stockholm_oldstreet);
        images.add(R.drawable.stockholm_segelstorg);
        images.add(R.drawable.stockholm_winterbridge);
    }

    public void animalStyle() {
        sequenceButtons.put(1, R.drawable.cow_button);
        sequenceButtons.put(2, R.drawable.horse_button);
        sequenceButtons.put(3, R.drawable.pig_button);
        sequenceButtons.put(4, R.drawable.sheep_button);

        images.add(R.drawable.farm_calf);
        images.add(R.drawable.farm_chicks);
        images.add(R.drawable.farm_duckcat);
        images.add(R.drawable.farm_lamb);
        images.add(R.drawable.farm_piglets);
        images.add(R.drawable.farm_poney);
        images.add(R.drawable.farm_sheep);
    }

    public void numberColorStyle() {
        sequenceButtons.put(1, R.drawable.one_color);
        sequenceButtons.put(2, R.drawable.two_color);
        sequenceButtons.put(3, R.drawable.three_color);
        sequenceButtons.put(4, R.drawable.four_color);

        images.add(R.drawable.matrix_1);
        images.add(R.drawable.matrix_binary);
        images.add(R.drawable.matrix_emc2);
        images.add(R.drawable.matrix_fibonaci);
        images.add(R.drawable.matrix_numbers);
        images.add(R.drawable.matrix_pi);
        images.add(R.drawable.matrix_systemfailure);
    }
}