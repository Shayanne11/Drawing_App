package com.example.drawingapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    // todas as variaveis nulas devem ser iniciadas para podermos usá-las
    //obejto da inner class CustomPath
    private var mDrawPath: CustomPath? = null

    //o que Bitmap faz? checar com crtl+B
    private var mCanvasBitmap: Bitmap? = null

    private var mDrawPaint: Paint? = null
    private var mCanvasPaint: Paint? = null

    private var mBrushSize: Float = 0.toFloat()
    private var color = Color.BLACK

    //
    private var canvas: Canvas? = null

    init {
        //chamar as variaveis ou criar um método para chamar todas, optamos pelo método
        setUpDrawing()
    }

    private fun setUpDrawing() {
        //chamar os objetos no método
        //mDrawPaint será nosso pincel?
        mDrawPaint = Paint()
        //color e mBrusSize são as únicas variáveis não nulas, por isso podemos chamar aqui diretamente
        mDrawPath = CustomPath(color,mBrushSize)
        //pelo fato de já termos chamado acima essa variável(mDrawPaint) sabemos que ela não está vazia, mas precisamos colocar !! para garantir que ela não estará nula
        //aqui defininimos que mDrawPaint receberá a cor
        mDrawPaint!!.color = color
        //aqui definimos que mDrawPaint receberá seu estilo, no caso é o STROKE que é uma linha, mas poderíamos escolher outro
        mDrawPaint!!.style = Paint.Style.STROKE
        //aqui definimos que o começo e o fim da linha do mDrawPaint terá formato arredondado
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND
        //aqui definimos que a ponta da linha do mDrawPaint terá formato arredondado
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND
        //mCanvasPaint será nossa tela de fundo? a tela onde vamos pintar?
        //ela terá uma flag (no caso a DITHER_FLAG) procurar sobre isso, no video informa que permite pintar em pontilhamento
        mCanvasPaint = Paint(Paint.DITHER_FLAG)
        //add o tamanho inicial/padrão do pincel
        mBrushSize = 20.toFloat()
    }


    //procurar sobre inner class
    internal inner class CustomPath(var color: Int, var brushThickness: Float) : Path() {

    }
}