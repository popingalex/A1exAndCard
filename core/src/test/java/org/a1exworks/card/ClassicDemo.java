package org.a1exworks.card;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.a1exworks.card.action.Rule;
import org.a1exworks.card.entity.Board;
import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Pile;
import org.a1exworks.card.entity.Player;
import org.a1exworks.card.phase.Phase;
import org.a1exworks.card.phase.Turn;
import org.junit.Before;
import org.junit.Test;

public class ClassicDemo {
    private ArrayList<Card>   cards;
    private ArrayList<Player> players;

    @Before
    public void setUp() throws Exception {
        cards = new ArrayList<Card>(52);
        players = new ArrayList<Player>(4);

        String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] suits = { "Heart", "Diamond", "Spade", "Club" };
        for (String suit : suits) {
            for (int i = 0, len = ranks.length; i < len; i++) {
                cards.add(new Card(i, String.format("%-8s%2s", suit, ranks[i])));
            }
        }

        String[] names = { "Alex", "Ted", "Bob" };
        for (String name : names) {
            players.add(new Player(players.size(), name));
        }
    }

    @Test
    public void test() {
        assertEquals(52, cards.size());

        Board<Card, Player> board = new Board<Card, Player>(0, "classic");
        board.piles.put("public_draw", new Pile<Card>(board.piles.size(), "public_draw"));
        board.piles.put("public_discard", new Pile<Card>(board.piles.size(), "public_discard"));
        for (Player player : players) {
            String name = "private_hand_" + player.name;
            board.piles.put(name, new Pile<Card>(board.piles.size(), name));
        }

        board.piles.get("public_draw").cards.addAll(cards);
        board.piles.get("public_draw").shuffle();
        board.players.addAll(players);

        Rule<Card, Player> rule = new Rule<Card, Player>() {
            final int    PHASE_DRAW = 0;
            final int    PHASE_SHOW = 1;
            final Random RANDOM     = new Random();

            @Override
            protected Turn<Card, Player> nextTurn(Board<Card, Player> board, Turn<Card, Player> turn) {
                turn = super.nextTurn(board, turn);
                int countPlayer = 0;
                for (Player player : board.players) {
                    if (!board.piles.get("private_hand_" + player.name).cards.isEmpty()) {
                        countPlayer++;
                    }
                }
                if (!board.piles.get("public_draw").cards.isEmpty()) {
                    turn.phases.add(new Phase<Card>(PHASE_DRAW, "draw"));
                } else if (1 == countPlayer) {
                    return null;
                } else {
                    turn.phases.add(new Phase<Card>(PHASE_SHOW, "show"));
                }
                return turn;
            }

            @Override
            public void perform(Board<Card, Player> board, Turn<Card, Player> turn, Player player, Phase<Card> phase) {
                System.out.println("========================================");
                System.out.println(board);
                System.out.println(player + "/" + turn.count + "/" + phase.name);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Pile<Card> hand = board.piles.get("private_hand_" + player.name);
                switch (phase.id) {
                case PHASE_DRAW:
                    Pile<Card> draw = board.piles.get("public_draw");
                    for (int i = 0; !draw.cards.isEmpty() && i < 1; i++) {
                        Card card = draw.cards.pollLast();
                        hand.cards.offerLast(card);
                    }
                    break;
                case PHASE_SHOW:
                    if (!hand.cards.isEmpty()) {
                        Pile<Card> discard = board.piles.get("public_discard");
                        int index = RANDOM.nextInt(hand.cards.size());
                        Card card = hand.cards.remove(index);
                        discard.cards.offerLast(card);
                    }
                    break;
                }
            }
        };
        rule.play(board);
    }
}
