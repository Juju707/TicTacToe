package com.jujulad.tictactoe

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tictactoe.*
import pwr.jszy.TicTacToeTable
import pwr.jszy.TicTacToeType.*

class ThirdActivity : AppCompatActivity() {
    var playerSign= X
    private val board = TicTacToeTable()
    var gameOn=true
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        btn_playerfirst.isEnabled = false
        btn_playerfirst.isClickable = false
        clearBoard()

        btn_playerfirst.setOnClickListener{
            clearBoard()
            btn_cmpfirst.isEnabled = true
            btn_cmpfirst.isClickable = true
            btn_playerfirst.isEnabled = false
            btn_playerfirst.isClickable = false
        }

        btn_cmpfirst.setOnClickListener{
            clearBoard()
            btn_cmpfirst.isEnabled = false
            btn_cmpfirst.isClickable = false
            btn_playerfirst.isEnabled = true
            btn_playerfirst.isClickable = true
            playerSign=X
            makeMove()
        }


        btn_00.setOnClickListener{
            if(btn_00.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_00.text=playerSign.id
                board.makeMove(playerSign,0,0)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_01.setOnClickListener{
            if(btn_01.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_01.text=playerSign.id
                board.makeMove(playerSign,0,1)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_02.setOnClickListener{
            if(btn_02.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_02.text=playerSign.id
                board.makeMove(playerSign,0,2)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_10.setOnClickListener{
            if(btn_10.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_10.text=playerSign.id
                board.makeMove(playerSign,1,0)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_11.setOnClickListener{
            if(btn_11.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_11.text=playerSign.id
                board.makeMove(playerSign,1,1)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_12.setOnClickListener{
            if(btn_12.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_12.text=playerSign.id
                board.makeMove(playerSign,1,2)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_20.setOnClickListener{
            if(btn_20.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_20.text=playerSign.id
                board.makeMove(playerSign,2,0)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_21.setOnClickListener{
            if(btn_21.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_21.text=playerSign.id
                board.makeMove(playerSign,2,1)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_22.setOnClickListener{
            if(btn_22.text!=EMPTY.id || !gameOn){
                Toast.makeText(this@ThirdActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_22.text=playerSign.id
                board.makeMove(playerSign,2,2)
                checkGame()
                changeSign()
                makeMove()
            }
        }
        btn_restart.setOnClickListener{
            clearBoard()
            playerSign=X
        }
    }
    private fun clearBoard(){
        board.emptyTable()
        gameOn=true
        btn_00.text = EMPTY.id
        btn_01.text = EMPTY.id
        btn_02.text = EMPTY.id
        btn_10.text = EMPTY.id
        btn_11.text = EMPTY.id
        btn_12.text = EMPTY.id
        btn_20.text = EMPTY.id
        btn_21.text = EMPTY.id
        btn_22.text = EMPTY.id
    }
    fun checkGame(){
        checkBoard()
        if(board.game){
            if(board.drawEnd)Toast.makeText(this@ThirdActivity,"It's a draw!",Toast.LENGTH_LONG).show()
            else Toast.makeText(this@ThirdActivity,"Player ${playerSign.id} wins!",Toast.LENGTH_LONG).show()
            gameOn=false
        }
    }
    fun makeMove(){
        if(gameOn) {
            board.computerMove(playerSign)
            checkGame()
            changeSign()
        }
    }
    private fun checkBoard(){
        val buttons=listOf(btn_00,btn_01,btn_02,btn_10,btn_11,btn_12,btn_20,btn_21,btn_22)
        var counter=0
        board.table.forEach {
            it.forEach { element ->
                if (element.id != buttons[counter].text) {
                    buttons[counter].text = element.id
                };counter++
            }
        }
    }
    private fun changeSign(){
        playerSign = if(playerSign==X) O
        else X
    }
}