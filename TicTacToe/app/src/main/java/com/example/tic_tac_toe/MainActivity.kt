package com.example.tic_tac_toe

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var player= true
    var count =0
    var boardstatus= Array(3){IntArray(3)}
    lateinit var board: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board= arrayOf(
            arrayOf(button1,button2,button3),arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )
        for(i in board)
        {
            for(button in i)
            {
                button.setOnClickListener(this)
            }
        }


        intitalizearray()
        reset.setOnClickListener()
        {
            count=0
            player=true
            intitalizearray()
            updatedisplay("Player X turn ")

        }
    }

    private fun intitalizearray() {


        for(i in 0..2)
        {
            for (j in 0..2)
            {
                boardstatus[i][j]=-1
                board[i][j].isEnabled = true
                board[i][j].text=""
            }
        }

    }


    override fun onClick(view: View) {

        when(view.id){
            R.id.button1->{
                updateval(row=0,col=0,PLAYER=player)

            }
            R.id.button2->{
                updateval(row=0,col=1,PLAYER=player)
            }
            R.id.button3->{
                updateval(row=0,col=2,PLAYER=player)
            }
            R.id.button4->{
                updateval(row=1,col=0,PLAYER= player)
            }
            R.id.button5->{
                updateval(row=1,col=1,PLAYER=player)
            }
            R.id.button6->{
                updateval(row=1,col=2,PLAYER= player)
            }
            R.id.button7->{
                updateval(row=2,col=0,PLAYER=player)
            }
            R.id.button8->{
                updateval(row=2,col=1,PLAYER=player)
            }
            R.id.button9->{
                updateval(row=2,col=2,PLAYER=player)
            }


        }
        count++
        player=!player
        
        
        if(player)
        {
            updatedisplay("PLayer X turn ")
        }
        else 
        { updatedisplay("PLayer O turn ")}
        
        
        if(count==9)
        {
            updatedisplay("Game Draw")
        }



        checkWinnner()
    }

    private fun checkWinnner() {
       for(i in 0..2) {

           //horizontal
           if (boardstatus[i][0]==boardstatus[i][1]&&boardstatus[i][0]==boardstatus[i][2]) {
               if (boardstatus[i][0] == 1) {
                   updatedisplay("X is WINNER")
                   break
               } else if (boardstatus[i][0] == 0) {
                   updatedisplay("0 is WINNER")
                   break
               }

           }
       }

           //vertical
        for(i in 0..2) {
           if (boardstatus[0][i]==boardstatus[1][i]&&boardstatus[0][i]==boardstatus[2][i]) {
               if (boardstatus[0][i] == 1) {
                   updatedisplay("X is WINNER")
                   break
               } else if (boardstatus[0][i] == 0) {
                   updatedisplay("0 is WINNER")
                   break
               }

           }

       }

        //first diagonal
        if(boardstatus[0][0]==boardstatus[1][1]&&boardstatus[0][0]==boardstatus[2][2]) {
            if (boardstatus[0][0] == 1) {
                updatedisplay("X is WINNER")

            } else if (boardstatus[0][0] == 0) {
                updatedisplay("0 is WINNER")

            }
        }
        //second diagonal
        if(boardstatus[0][2]==boardstatus[1][1]&&boardstatus[0][2]==boardstatus[2][0]){
            if (boardstatus[0][2] == 1) {
                updatedisplay("X is WINNER")

            } else if (boardstatus[0][2] == 0) {
                updatedisplay("0 is WINNER")

            }
        }

    }

    private fun updatedisplay(text: String) {

        displayV.text=text

        if(text.contains("Winner"))
            diablebutton()
    }



    private fun diablebutton(){

        for(i in board)
        {
            for(button in i)
            {
                button.isEnabled=false
            }
        }

    }

    private fun updateval(row: Int, col: Int, PLAYER: Boolean ){

        var text=if (PLAYER)"X" else "O"
        var value=if (PLAYER)1 else 0

        board[row][col].apply {

            isEnabled=false
            setText(text)
        }


        boardstatus[row][col]= value

    }
}
