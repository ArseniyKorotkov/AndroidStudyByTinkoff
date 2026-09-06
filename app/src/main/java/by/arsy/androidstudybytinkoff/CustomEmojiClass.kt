package by.arsy.androidstudybytinkoff

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import by.arsy.androidstudybytinkoff.MainActivity.Companion.happinessState
import kotlin.math.min

class CustomEmojiClass(context: Context, attrs: AttributeSet) : View(context, attrs) {


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mouthPath = Path()
    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK
    private var borderWidth = 4.0f
    private var size = 320

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    private fun drawFaceBackground(canvas: Canvas) {
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size / 2f

        canvas.drawCircle(radius, radius, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas.drawCircle(radius, radius, radius - borderWidth / 2f, paint)
    }

    private fun drawEyes(canvas: Canvas) {
        paint.color = eyesColor
        paint.style = Paint.Style.FILL
        val leftEyeRect = RectF(size * 0.25f, size * 0.23f, size * 0.43f, size * 0.50f)
        canvas.drawOval(leftEyeRect, paint)
        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.75f, size * 0.50f)
        canvas.drawOval(rightEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas) {
        mouthPath.reset()
        mouthPath.moveTo(size * 0.22f, size * 0.7f)
        if (happinessState == HAPPY_STATE) {
            mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)
            mouthPath.quadTo(size * 0.50f, size * 1f, size * 0.22f, size * 0.70f)
        } else {
            mouthPath.quadTo(size * 0.50f, size * 0.50f, size * 0.78f, size * 0.70f)
            mouthPath.quadTo(size * 0.50f, size * 0.60f, size * 0.22f, size * 0.70f)
        }
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas.drawPath(mouthPath, paint)
    }

}