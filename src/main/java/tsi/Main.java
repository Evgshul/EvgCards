package tsi;

import guru.bug.playcardsfx.Card;
import guru.bug.playcardsfx.PlayCardsFX;
import guru.bug.playcardsfx.Stack;
import guru.bug.playcardsfx.Table;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayCardsFX.launch(args, 8, 5, Main::start);
    }

    private static void start(Table table) {
        List<Card> cards = table.createPack();
        Collections.shuffle(cards);
        Stack stack = table.createStack(1,1, 0.25, 0);
            stack.setCards(cards);
        }
    }

