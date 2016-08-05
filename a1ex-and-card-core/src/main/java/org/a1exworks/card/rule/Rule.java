package org.a1exworks.card.rule;

import java.util.List;

import org.a1exworks.card.model.Board;
import org.a1exworks.card.model.Card;
import org.a1exworks.card.model.Player;
import org.a1exworks.card.play.Action;
import org.a1exworks.card.round.Phase;
import org.a1exworks.card.round.Turn;

public class Rule<C extends Card, P extends Player> implements Action<C, P> {
    public final void play(Board<C, P> board) {
        P player = nextPlayer(board, null);
        Turn<C> turn = nextRound(board, null);
        for (; null != turn; turn = nextRound(board, turn), player = nextPlayer(board, player)) {
            for (Phase<C> phase : turn.phases) {
                perform(board, player, turn, phase);
            }
        }
    }

    protected Turn<C> nextRound(Board<C, P> board, Turn<C> turn) {
        int count = (null == turn) ? 0 : (turn.count + 1);
        return new Turn<C>(count);
    }

    protected P nextPlayer(Board<C, P> board, P current) {
        List<P> players = board.players;
        int index = (null == current) ? -1 : players.indexOf(current);
        return players.get((index + players.size() + 1) % players.size());
    }

    @Override
    public void perform(Board<C, P> board, P player, Turn<C> turn, Phase<C> phase) {}
}
