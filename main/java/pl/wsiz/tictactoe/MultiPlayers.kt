package pl.wsiz.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tictac.*
import kotlinx.android.synthetic.main.activity_tictac.text_view_result

class MultiPlayers : AppCompatActivity() {

    /**
     * dwuwymiarowa tablica
     */
    
    private val boardCells = Array(3) { arrayOfNulls<ImageView>(3) }
    
    /**
     * stworzenie obiektu clasy Board
     */
    var board = Board()

    /**
     * przeładowanie metody onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_players)

        loadBoard()


        button_restart.setOnClickListener {

            board = Board()

            text_view_result.text = ""

            mapBoardToUi()
        }
    }

    /**
     * funkcja odpowiadajaca za rozmieszczanie ruchow komputera
     */
    private fun mapBoardToUi() {
        for (i in board.board.indices) {
            for (j in board.board.indices) {
                when (board.board[i][j]) {
                    Board.PLAYER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.circle)
                        boardCells[i][j]?.isEnabled = false
                    }
                    Board.COMPUTER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.cross)
                        boardCells[i][j]?.isEnabled = false
                    }
                    else -> {
                        boardCells[i][j]?.setImageResource(0)
                        boardCells[i][j]?.isEnabled = true
                    }
                }
            }
        }
    }

    /**
     * funckja odpowiadajaca za załadowanie planszy
     */
    private fun loadBoard() {
        for (i in boardCells.indices) {
            for (j in boardCells.indices) {
                boardCells[i][j] = ImageView(this)
                boardCells[i][j]?.layoutParams = GridLayout.LayoutParams().apply {
                    rowSpec = GridLayout.spec(i)
                    columnSpec = GridLayout.spec(j)
                    width = 250
                    height = 230
                    bottomMargin = 5
                    topMargin = 5
                    leftMargin = 5
                    rightMargin = 5
                }
                boardCells[i][j]?.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
                boardCells[i][j]?.setOnClickListener(CellClickListener(i, j))
                layout_board.addView(boardCells[i][j])
            }
        }
    }

    /**
     * zmienna odpowiada za kolejnosc ruchow graczy
     */
    var k: Int = 0

    /**
     * klasa klikniecia w plasze
     */
    inner class CellClickListener(
        private val i: Int,
        private val j: Int
    ) : View.OnClickListener {

        override fun onClick(p0: View?) {
            if (!board.isGameOver){
if(k==1){
          val cell = Cell(i,j)
            board.placeMove(cell, Board.PLAYER)
                mapBoardToUi()

                k=2}
            else if(k==2) {
    val cell = Cell(i,j)
    board.placeMove(cell, Board.COMPUTER)
    mapBoardToUi()
    k=1 }
            else{val cell = Cell(i,j)
    board.placeMove(cell, Board.PLAYER)
    mapBoardToUi()

    k=2

            }
        }
            when {
                board.hasComputerWon() -> text_view_result.text = "Cross Won"
                board.hasPlayerWon() -> text_view_result.text = "Circle Won"
                board.isGameOver -> text_view_result.text = "Game Tied"
            }}


        }
    }


