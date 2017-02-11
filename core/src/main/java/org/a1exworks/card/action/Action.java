package org.a1exworks.card.action;

import org.a1exworks.card.entity.Board;
import org.a1exworks.card.entity.Card;
import org.a1exworks.card.entity.Player;
import org.a1exworks.card.phase.Phase;
import org.a1exworks.card.phase.Turn;

public interface Action<C extends Card, P extends Player> {
    /**
     * to perform
     * 
     * @param board
     *            with current board
     * @param turn
     *            with current turn
     * @param player
     *            with current player
     * @param phase
     *            with current phase
     */
    void perform(Board<C, P> board, Turn<C, P> turn, Player player, Phase<C, P> phase);
}
