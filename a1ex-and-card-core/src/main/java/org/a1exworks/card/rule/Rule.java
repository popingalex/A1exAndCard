package org.a1exworks.card.rule;

import java.util.List;

import org.a1exworks.card.model.Board;
import org.a1exworks.card.model.Card;
import org.a1exworks.card.model.Player;
import org.a1exworks.card.play.Action;
import org.a1exworks.card.round.Phase;
import org.a1exworks.card.round.Round;

public class Rule<C extends Card, P extends Player> implements Action<C, P> {
    public void play(Board<C, P> board) {
        P player = nextPlayer(board, null);
        Round<C> round = nextRound(board, null);
        for (; null != round; round = nextRound(board, round), player = nextPlayer(board, player)) {
            for (Phase<C> phase : round.process) {
                perform(board, player, round, phase);
            }
        }
    }

    @Override
    public void perform(Board<C, P> board, P player, Round<C> round, Phase<C> phase) {}

    protected Round<C> nextRound(Board<C, P> board, Round<C> round) {
        int count = (null == round) ? 0 : (round.count + 1);
        return new Round<C>(count);
    }

    protected P nextPlayer(Board<C, P> board, P current) {
        List<P> party = board.party;
        int index = (null == current) ? -1 : party.indexOf(current);
        return party.get(index % party.size());
    }
}
