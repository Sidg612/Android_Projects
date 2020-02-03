package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Numbers
        //_______________________________________________________________________________
        btnZero.setOnClickListener(){onappeendExpression("0",true )}
        btnOne.setOnClickListener(){onappeendExpression("1",true )}
        btnTwo.setOnClickListener(){onappeendExpression("2",true )}
        btnThree.setOnClickListener(){onappeendExpression("3",true )}
        btnFour.setOnClickListener(){onappeendExpression("4",true )}
        btnFive.setOnClickListener(){onappeendExpression("5",true )}
        btnSix.setOnClickListener(){onappeendExpression("6",true )}
        btnSeven.setOnClickListener(){onappeendExpression("7",true )}
        btnEight.setOnClickListener(){onappeendExpression("8",true )}
        btnNine.setOnClickListener(){onappeendExpression("9",true )}
        btnDot.setOnClickListener(){onappeendExpression(".",true )}
        //_______________________________________________________________________________

        //operators
        //_______________________________________________________________________________

        btnPlus.setOnClickListener(){onappeendExpression("+",false )}
        btnMinus.setOnClickListener(){onappeendExpression("-",false )}
        btnMultiply.setOnClickListener(){onappeendExpression("x",false)}
        btnDivide.setOnClickListener(){onappeendExpression("/",false )}
        btnOpen.setOnClickListener(){onappeendExpression("(",false )}
        btnClose.setOnClickListener(){onappeendExpression(")",false )}
        //_______________________________________________________________________________


        btnAllClr.setOnClickListener(){

            TvExpression.text=""
            TvResult.text=""
        }
        btnDel.setOnClickListener(){
            var string= TvExpression.text.toString()
            if(string.isNotEmpty()){

                TvExpression.text= string.substring(0,string.length-1)
            }
            TvResult.text=""

        }
        btnEqual.setOnClickListener(){

            try{

                val expression =ExpressionBuilder(TvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longresult= result.toLong()

                if(result== longresult.toDouble())
                    TvResult.text= longresult.toString()
                else
                    TvResult.text= Result.toString()
            }
            catch (e: Exception){

                Log.i("Exception", "Message: "+ e.message)
            }

        }


    }



    fun onappeendExpression(string: String,canClear:Boolean){

        if(canClear){

            TvResult.text=""
            TvExpression.append(string)
        }

        else{
            TvExpression.append(TvResult.text)
            TvExpression.append(string)
            TvResult.text=""
        }

    }
}
