package org.a1exworks.card.action;

import java.util.List;

import org.a1exworks.card.entity.Board;
import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Player;
import org.a1exworks.card.phase.Phase;
import org.a1exworks.card.phase.Turn;

public class Rule<C extends Card, P extends Player> {
    protected Turn<C, P> nextTurn(Board<C, P> board, Turn<C, P> turn) {
        int count = (null == turn) ? 0 : (turn.count + 1);
        return new Turn<C, P>(count);
    }

    protected P nextPlayer(Board<C, P> board, Turn<C, P> turn, P current) {
        List<P> players = board.players;
        int index = (null == current) ? -1 : players.indexOf(current);
        return players.get((index + players.size() + 1) % players.size());
    }

    protected void perform(Board<C, P> board, Turn<C, P> turn, Player player, Phase<C> phase) {}

    public final void play(Board<C, P> board) {
        Turn<C, P> turn = nextTurn(board, null);
        for (P player = nextPlayer(board, turn, null); null != turn; player = nextPlayer(board, turn, player)) {
            for (Phase<C> phase : turn.phases) {
                perform(board, turn, player, phase);
            }
            turn = nextTurn(board, turn);
        }
    }
}
