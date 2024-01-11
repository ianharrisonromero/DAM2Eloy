/* You have to write a function that takes for input a 8x8 chessboard in the form of a bi-dimensional array of chars (or strings of length 1, depending on the language) and returns a boolean indicating whether the king is in check.
The array will include 64 squares which can contain the following characters :
'K' for the black King;
'Q' for a white Queen;
'B' for a white Bishop;
'N' for a white kNight;
'R' for a white Rook;
'P' for a white Pawn;
' ' (a space) if there is no piece on that square.
There will always be exactly one king, which is the black king, whereas all the other pieces are white.
The board is oriented from Black's perspective.
Remember that pawns can only move and take forward.
Also be careful with the pieces' lines of sight ;-) . */

public class IsKingInCheckKata {

    static int pawnIPosition;
    static int pawnJPosition;
    static int rookIPosition;
    static int rookJPosition;
    static int knightIPosition;
    static int knightJPosition;
    static int bishopPositionI;
    static int bishopPositionJ;
    static int queenIPosition;
    static int queenJPosition;
    static int kingPositionI;
    static int kingPositionJ;

    public static boolean isTheKinginCheck(char[][] chessboard) {
        return false;
    }

    // positions
    public static void kingPositions(char[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'K') {
                    kingPositionI = i;
                    kingPositionJ = j;
                }
            }
        }
    }

    public static void pawnPositions(char[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'P') {
                    pawnIPosition = i;
                    pawnJPosition = j;
                }
            }
        }
    }

    public static void knightPositions(char[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'N') {
                    knightIPosition = i;
                    knightJPosition = j;
                }
            }
        }
    }

    public static void rookPositions(char[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'R') {
                    rookIPosition = i;
                    rookJPosition = j;
                }
            }
        }
    }

    public static void bishopPositions(char[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'B') {
                    bishopPositionI = i;
                    bishopPositionJ = j;
                }
            }
        }
    }

    public static void queenPositions(char[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'Q') {
                    queenIPosition = i;
                    queenJPosition = j;
                }
            }
        }
    }

    public static boolean checkByPawn(char[][] chessboard) {
        // for (int i = 0; i < chessboard.length; i++) {
        // for (int j = 0; j < chessboard.length; j++) {
        // if (chessboard[i][j] == 'P') {
        // pawnIPosition = i;
        // pawnJPosition = j;
        // }
        // if (chessboard[i][j] == 'K') {
        // kingPositionI = i;
        // kingPositionJ = j;
        // }
        // }
        // }

        if (kingPositionI == pawnIPosition + 1) {
            if (kingPositionJ == pawnJPosition + 1 || kingPositionJ == pawnJPosition - 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkByKnight(char[][] chessboard) {

        if (kingPositionI == knightIPosition + 2 || kingPositionI == knightIPosition - 2) {
            if (kingPositionJ == knightJPosition + 1 || kingPositionJ == knightJPosition - 1) {
                return true;
            }
        }

        if (kingPositionI == knightIPosition + 1 || kingPositionI == knightIPosition - 1) {
            if (kingPositionJ == knightJPosition + 2 || kingPositionJ == knightJPosition - 2) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkByRook(char[][] chessboard) {

        if (kingPositionI == rookIPosition && rookVisibility(chessboard) == true) {
            return true;
        }

        if (kingPositionJ == rookJPosition && rookVisibility(chessboard) == true) {
            return true;
        }

        return false;
    }

    public static boolean checkByBishop(char[][] chessboard) {
        // checking downwards
        if (bishopPositionI < kingPositionI) {
            for (int i = bishopPositionI; i <= kingPositionI; i++) {
                for (int j = bishopPositionJ; j <= kingPositionJ; j++) {
                    System.out.println(i + "-" + j);
                    if (chessboard[i][j] == 'K') {
                        return true;
                    } else {
                        i++;
                    }
                }
            }
            // for (int i = bishopPositionI; i < chessboard.length; i++) {
            // for (int j = bishopPositionJ; j < chessboard.length; j--) {
            // if (chessboard[i][j] == 'K') {
            // return true;
            // }
            // break;
            // }
            // }

        }

        return false;
    }

    public static boolean rookVisibility(char[][] chessboard) {

        if (!(rookJPosition == kingPositionJ || rookIPosition == kingPositionI)) {
            return false;
        }

        // checking visibility with same i positions
        if (kingPositionI == rookIPosition) {
            if (kingPositionJ > rookJPosition) {
                for (int j = rookJPosition + 1; j < kingPositionJ; j++) {
                    if (chessboard[kingPositionI][j] != ' ') {
                        return false;
                    }
                }
            }
            if (kingPositionJ < rookJPosition) {
                for (int j = (rookJPosition - 1); j < kingPositionJ; j--) {
                    // System.out.println("J position in iteration: " + j);
                    if (chessboard[kingPositionI][j] != ' ') {
                        return false;
                    }
                }
            }
        }
        // checking visibility with same j positions
        if (kingPositionJ == rookJPosition) {
            if (kingPositionI > rookIPosition) {
                for (int i = rookIPosition + 1; i < kingPositionI; i++) {
                    if (chessboard[i][kingPositionJ] != ' ') {
                        return false;
                    }
                }
            }
            if (kingPositionI < rookIPosition) {
                for (int i = rookIPosition - 1; i > kingPositionI; i--) {
                    if (chessboard[i][kingPositionJ] != ' ') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // public static boolean bishopVisibility(char[][] chessboard) {

    // // checking visibility with same i positions
    // if (kingPositionI == rookIPosition) {
    // if (kingPositionJ > rookJPosition) {
    // for (int j = rookJPosition + 1; j < kingPositionJ; j++) {
    // if (chessboard[kingPositionI][j] != ' ') {
    // return false;
    // }
    // }
    // }
    // if (kingPositionJ < rookJPosition) {
    // for (int j = (rookJPosition - 1); j < kingPositionJ; j--) {
    // // System.out.println("J position in iteration: " + j);
    // if (chessboard[kingPositionI][j] != ' ') {
    // return false;
    // }
    // }
    // }
    // }
    // // checking visibility with same j positions
    // if (kingPositionJ == rookJPosition) {
    // if (kingPositionI > rookIPosition) {
    // for (int i = rookIPosition + 1; i < kingPositionI; i++) {
    // if (chessboard[i][kingPositionJ] != ' ') {
    // return false;
    // }
    // }
    // }
    // if (kingPositionI < rookIPosition) {
    // for (int i = rookIPosition - 1; i > kingPositionI; i--) {
    // if (chessboard[i][kingPositionJ] != ' ') {
    // return false;
    // }
    // }
    // }
    // }
    // return true;
    // }

    public static void printBoard(char[][] test) {
        for (int i = 0; i < test.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < test.length; j++) {
                System.out.print(test[i][j] + " | ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        final char[][] test1 = {
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { 'B', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { 'R', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', 'P', ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', ' ', 'K', ' ', ' ', ' ' }
        };

        knightPositions(test1);
        kingPositions(test1);
        pawnPositions(test1);
        rookPositions(test1);
        bishopPositions(test1);

        printBoard(test1);
        // System.out.println(
        // "ROOK i: " + rookIPosition + " // j: " + rookJPosition + " // rookVisibility
        // => "
        // + rookVisibility(test1));
        System.out.println("king i: " + kingPositionI + " // j: " + kingPositionJ);
        System.out.println("bishop i: " + bishopPositionI + " // j: " + bishopPositionJ);
        System.out.println("check by BISHOP => " + checkByBishop(test1));

        System.out.println("Pawn check : " + checkByPawn(test1));
        System.out.println("Knight check : " + checkByKnight(test1));
        System.out.println("Rook check : " + checkByRook(test1));

    }
}
