package org.a1exworks.card.action;

import java.util.List;

import org.a1exworks.card.entity.Board;
import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Player;
import org.a1exworks.card.phase.Phase;
import org.a1exworks.card.phase.Turn;

public class Rule<C extends Card, P extends Player> implements Action<C, P> {
    protected Turn<C, P> nextTurn(Board<C, P> board, Turn<C, P> turn, P player) {
        int count = (null == turn) ? 0 : (turn.count + 1);
        return new Turn<C, P>(count);
    }

    protected P nextPlayer(Board<C, P> board, Turn<C, P> turn, P player) {
        List<P> players = board.players;
        int index = (null == player) ? -1 : players.indexOf(player);
        return players.get((index + players.size() + 1) % players.size());
    }

    protected Phase<C, P> nextPhase(Board<C, P> board, Turn<C, P> turn, P player, Phase<C, P> phase) {
        return null;
    }

    @Override
    public void perform(Board<C, P> board, Turn<C, P> turn, Player player, Phase<C, P> phase) {}

    public final void play(Board<C, P> board) {
        Turn<C, P> turn = null;
        P player = null;
        Phase<C, P> phase = null;

        for (turn = nextTurn(board, turn, player); null != turn; turn = nextTurn(board, turn, player)) {
            player = nextPlayer(board, turn, player);
            phase = nextPhase(board, turn, player, phase);

            perform(board, turn, player, phase);
        }
    }
}
