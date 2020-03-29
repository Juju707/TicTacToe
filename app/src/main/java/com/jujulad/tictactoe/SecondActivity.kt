package com.jujulad.tictactoe

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tictactoe.*
import pwr.jszy.TicTacToeTable
import pwr.jszy.TicTacToeType.*

class SecondActivity : AppCompatActivity() {
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
        clearBoard()
        btn_playerfirst.isEnabled = false
        btn_playerfirst.isClickable = false
        btn_playerfirst.visibility= View.GONE
        btn_cmpfirst.isEnabled = false
        btn_cmpfirst.isClickable = false
        btn_cmpfirst.visibility= View.GONE

        btn_00.setOnClickListener{
            if(btn_00.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_00.text=playerSign.id
                board.makeMove(playerSign,0,0)
                checkGame()
                changeSign()
            }
        }
        btn_01.setOnClickListener{
            if(btn_01.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_01.text=playerSign.id
                board.makeMove(playerSign,0,1)
                checkGame()
                changeSign()
            }
        }
        btn_02.setOnClickListener{
            if(btn_02.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_02.text=playerSign.id
                board.makeMove(playerSign,0,2)
                checkGame()
                changeSign()
            }
        }
        btn_10.setOnClickListener{
            if(btn_10.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_10.text=playerSign.id
                board.makeMove(playerSign,1,0)
                checkGame()
                changeSign()
            }
        }
        btn_11.setOnClickListener{
            if(btn_11.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_11.text=playerSign.id
                board.makeMove(playerSign,1,1)
                checkGame()
                changeSign()
            }
        }
        btn_12.setOnClickListener{
            if(btn_12.text!=EMPTY.id){
            Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
        }else if(gameOn){
            btn_12.text=playerSign.id
            board.makeMove(playerSign,1,2)
            checkGame()
            changeSign()
        }
        }
        btn_20.setOnClickListener{
            if(btn_20.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_20.text=playerSign.id
                board.makeMove(playerSign,2,0)
                checkGame()
                changeSign()
            }
        }
        btn_21.setOnClickListener{
            if(btn_21.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_21.text=playerSign.id
                board.makeMove(playerSign,2,1)
                checkGame()
                changeSign()
            }
        }
        btn_22.setOnClickListener{
            if(btn_22.text!=EMPTY.id){
                Toast.makeText(this@SecondActivity,"You cannot make that move",Toast.LENGTH_LONG).show()
            }else if(gameOn){
                btn_22.text=playerSign.id
                board.makeMove(playerSign,2,2)
                checkGame()
                changeSign()
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
        if(board.game){
            if(board.drawEnd)Toast.makeText(this@SecondActivity,"It's a draw!",Toast.LENGTH_LONG).show()
            else Toast.makeText(this@SecondActivity,"Player ${playerSign.id} wins!",Toast.LENGTH_LONG).show()
            gameOn=false
        }
    }

    private fun changeSign(){
        playerSign = if(playerSign==X) O
        else X
    }
}