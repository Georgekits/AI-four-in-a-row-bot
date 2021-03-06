package fourinarow2;

// IPlayer.java
import ch.aplu.jgamegrid.*;

public abstract class IPlayer {

    protected int thisPlayer;
    protected int enemyPlayer;
    public static Token[][] board = new Token[7][6]; //first x, then y coordinate
    protected boolean debug = true;
    protected GameGrid gg;

    public abstract int getColumn();

    public IPlayer(GameGrid gg) {
        this.gg = gg;
    }

    protected int insertToken(int column) {
        int rowCount = 0;
        Token[] insertingColumn = board[column];
        for (Token row : insertingColumn) {
            if (row.getPlayer() == -1) {
                return rowCount;
            }
            rowCount++;
        }
        return -1;
    }

    // check if there are X in a Row --------
    protected boolean checkXInARow(int col, int row, int x, int checkPlayer, Token[][] board) {
        if (checkVertically(col, row, x, checkPlayer, board)
                || checkHorizontally(col, row, x, checkPlayer, board)
                || checkDiagonally1(col, row, x, checkPlayer, board)
                || checkDiagonally2(col, row, x, checkPlayer, board)) {
            return true;
        }
        return false;
    }

    //------checking nearOfTokens in  a row
    private boolean checkDiagonally2(int col, int row, int nrOfTokens, int checkTok, Token[][] board) {
        for (int j = 0; j < nrOfTokens; j++) {
            int adjacentSameTokens = 1;
            for (int i = 0; i < nrOfTokens; i++) {
                if ((col - i + j) >= 0 && (col - i + j) < board.length
                        && (row + i - j) >= 0 && (row + i - j) < board[col].length
                        && board[col - i + j][row + i - j].getPlayer() == checkTok) {
                    adjacentSameTokens++;
                }
            }
            if (adjacentSameTokens == nrOfTokens) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonally1(int col, int row, int nrOfTokens, int checkTok, Token[][] board) {
        for (int j = 0; j < nrOfTokens; j++) {
            int adjacentSameTokens = 1;
            for (int i = 0; i < nrOfTokens; i++) {
                if ((col + i - j) >= 0 && (col + i - j) < board.length
                        && (row + i - j) >= 0
                        && (row + i - j) < board[col].length
                        && board[col + i - j][row + i - j].getPlayer() == checkTok) {
                    adjacentSameTokens++;
                }
            }
            if (adjacentSameTokens == nrOfTokens) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontally(int col, int row, int nrOfTokens, int checkTok, Token[][] board) {
        for (int j = 0; j < nrOfTokens; j++) {
            int adjacentSameTokens = 1;
            for (int i = 0; i < nrOfTokens; i++) {
                if ((col + i - j) >= 0 && (col + i - j) < board.length
                        && board[col + i - j][row].getPlayer() == checkTok) {
                    adjacentSameTokens++;
                }
            }
            if (adjacentSameTokens == nrOfTokens) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertically(int col, int row, int nrOfTokens, int checkTok, Token[][] board) {

        for (int j = 0; j < nrOfTokens; j++) {
            int adjacentSameTokens = 1;
            for (int i = 0; i < nrOfTokens; i++) {
                if ((row + i - j) >= 0 && (row + i - j) < board[col].length
                        && board[col][row + i - j].getPlayer() == checkTok) {
                    adjacentSameTokens++;
                }
            }
            if (adjacentSameTokens == nrOfTokens) {
                return true;
            }
        }
        return false;
    }

    protected boolean isBoardEmpty() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0].getPlayer() != -1) {
                return false;
            }
        }
        return true;
    }

    public void multiArrayCopy(Token[][] source, Token[][] destination) {
        for (int a = 0; a < source.length; a++) {
            System.arraycopy(source[a], 0, destination[a], 0, source[a].length);
        }
    }
}
