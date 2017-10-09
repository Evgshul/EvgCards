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

        Stack stack1 = table.createStack(0.5, 0.5, 0.01, 0.00);
        Stack stack2 = table.createStack(2.0, 0.5, 0.00, 0.2);
        Stack stack3 = table.createStack(3.5, 0.5, 0.00, 0.2);
        Stack stack4 = table.createStack(5.0, 0.5, 0.00, 0.2);
        Stack stack5 = table.createStack(6.5, 0.5, 0.00, 0.2);

        List<Card> cards = table.createPack(true);
        Collections.shuffle(cards);

        stack1.setCards(cards);

        table.onClick((stack, card) -> {
            if (stack != stack1) {
                moveLastCard(stack1, stack);
            }
        });
    }


    private static void moveLastCard(Stack stackFrom, Stack stackTo) {
        List<Card> source = stackFrom.getCards();
        if (source.isEmpty()) {
            return;
        }
        Card last = source.get(source.size() - 1);
        last.setFaceDown(false);

        List<Card> target = stackTo.getCards();
        target.add(last);

        stackTo.setCards(target);
    }

}

