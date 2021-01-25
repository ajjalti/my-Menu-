package com.ocr.anthony;

import java.util.Scanner;

public class Interaction {


    /**
     * Display a question about a category in the standard input, get response and display it
     * @param category the category of the question
     * @param responses available responses
     */
    public static int askSomething(String category, String[] responses) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix " + category);
        for (int i = 1; i <= responses.length; i++) {
            System.out.println(i + " - " + responses[i - 1]);
        }
        System.out.println("Que souhaitez vous comme " + category + "?");
        int nbResponse;
        boolean responseIsGood;
        do {
            nbResponse =sc.nextInt();
            if (nbResponse >= 1 && nbResponse <= responses.length) {
                responseIsGood = true;
            } else {
                responseIsGood = false;
            }
            if (responseIsGood == true) {

                String choice = "Vous avez choisi comme " + category + " : " + responses[nbResponse - 1];
                Order.orderSummary += choice + "%n";
                System.out.println(choice);
            } else {
                boolean isVowel = "aeiouy".contains(Character.toString(category.charAt(0)));
                if (isVowel) {
                    System.out.println("Vous n'avez pas choisi d'" + category + " parmi les choix proposés");
                } else {
                    System.out.println("Vous n'avez pas choisi de " + category + " parmi les choix proposés");
                }

            } } while (responseIsGood == false);
    return nbResponse;
    }

    /**
     * Display a question about menu in the standard input, get response and display it
     *
     */
    public static int askMenu() {
        String[] menus = {"poulet", "boeuf", "végétarien"};
        return askSomething("menu", menus);
    }

    /**
     * Display a question about side in the standard input, get response and display it
     */
    public static void askSide(boolean allSidesEnable) {
        if (allSidesEnable) {
            String[] responsesAllSide = {"légumes frais", "frites", "riz"};
            askSomething("accompagnement", responsesAllSide);
        } else {
            String[] responsesOnlyRice = {"riz", "pas de riz"};
            askSomething("accompagnement", responsesOnlyRice);
        }

    }

    /**
     * Display a question about drink in the standard input, get response and display it
     */
    public static void askDrink() {
        String[] responsesDrink = {"eau plate", "eau gazeuse", "soda"};
        askSomething("boisson", responsesDrink);
    }
}
