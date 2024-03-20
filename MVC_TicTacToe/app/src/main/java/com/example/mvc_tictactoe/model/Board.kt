package com.example.mvc_tictactoe.model

import com.example.mvc_tictactoe.model.Player.O
import com.example.mvc_tictactoe.model.Player.X

class Board {

    private var cells = Array(3) { Array(3) { Cell() } }

    private var winner: Player? = null
    private var state: GameState = GameState.IN_PROGRESS
    private var currentTurn: Player = Player.X

    private enum class GameState { IN_PROGRESS, FINISHED }

    init {
        restart()
    }

    /**
     * Restart or start a new game, will clear the board and win status
     */
    fun restart() {
        clearCells()
        winner = null
        currentTurn = Player.X
        state = GameState.IN_PROGRESS
    }

    /**
     * Mark the current row for the player who's current turn it is.
     * Will perform no-op if the arguments are out of range or if that position is already played.
     * Will also perform a no-op if the game is already over.
     *
     * @param row 0..2
     * @param col 0..2
     *
     */
    fun mark(row: Int, col: Int) {
        if (isValid(row, col)) {
            cells[row][col].value = currentTurn

            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED
                winner = currentTurn
            } else {
                // flip the current turn and continue
                flipCurrentTurn()
            }
        }
    }

    fun getWinner(): Player? = winner

    private fun clearCells() {
        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j] = Cell()
            }
        }
    }

    private fun isValid(row: Int, col: Int): Boolean {
        return when {
            state == GameState.FINISHED -> false
            isOutOfBounds(row) || isOutOfBounds(col) -> false
            isCellValueAlreadySet(row, col) -> false
            else -> true
        }
    }

    private fun isOutOfBounds(idx: Int): Boolean = idx < 0 || idx > 2

    private fun isCellValueAlreadySet(row: Int, col: Int): Boolean = cells[row][col].value != null

    /**
     * @param player
     * @param currentRow
     * @param currentCol
     * @return true if <code>player</code> who just played the move at the <code>currentRow</code>, <code>currentCol</code>
     * has a tic tac toe.
     */
    private fun isWinningMoveByPlayer(player: Player, currentRow: Int, currentCol: Int): Boolean {
        return (cells[currentRow][0].value == player // 3-in-the-row
                && cells[currentRow][1].value == player
                && cells[currentRow][2].value == player
                || cells[0][currentCol].value == player // 3-in-the-column
                && cells[1][currentCol].value == player
                && cells[2][currentCol].value == player
                || currentRow == currentCol // 3-in-the-diagonal
                && cells[0][0].value == player
                && cells[1][1].value == player
                && cells[2][2].value == player
                || currentRow + currentCol == 2 // 3-in-the-opposite-diagonal
                && cells[0][2].value == player
                && cells[1][1].value == player
                && cells[2][0].value == player)
    }

    private fun flipCurrentTurn() {
        currentTurn = if (currentTurn == X) O else X
    }
}
