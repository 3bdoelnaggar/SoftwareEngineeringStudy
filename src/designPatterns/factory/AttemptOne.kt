package designPatterns.factory



// Chess game
// Load state of game

val notations = listOf("pa3", "qc5")


sealed class Piece(val position: String) {
    companion object {
        fun formNotation(notation: String): Piece {
            val pieceType = notation[0]
            val position = notation.drop(0)
            return when (pieceType) {
                'p' -> Pawn(position)
                'q' -> Queen(position)
                else -> error("Unknown Piece")
            }

        }

    }
}

class Pawn(position: String) : Piece(position)
class Queen(position: String) : Piece(position)


fun main() {
    val gameState = notations.map { Piece.formNotation(it) }
    notations.map {
        println(it.drop(0))
        println(it.drop(1))
    }
}

/* Factory method
    input of some stuff -> output object of predefined parent
    string of some info -> object of piece with its position
 */