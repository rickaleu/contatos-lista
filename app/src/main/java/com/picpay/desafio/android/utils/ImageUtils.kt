package com.picpay.desafio.android.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.picpay.desafio.android.R

private const val STROKE_WIDTH = 5f
private const val CENTER_RADIUS = 120f

fun loadImage(target: ImageView, url: String?) {
    Glide
        .with(target.context)
        .load(url)
        .placeholder(R.drawable.ic_round_account_circle)
        .error(R.drawable.ic_launcher_foreground)
        .into(target)
}

//fun loadImageWithCircularProgress(target: ImageView, url: String) {
//    val circularProgress = CircularProgressDrawable(target.context)
//    circularProgress.strokeWidth = STROKE_WIDTH
//    circularProgress.centerRadius = CENTER_RADIUS
//    circularProgress.start()
//
//    Glide
//        .with(target)
//        .load(url)
//        .placeholder(circularProgress)
//        .error(R.drawable.ic_broken_image)
//        .into(target)
//}

//fun loadImageWithCustomProgress(target: ImageView, customProgress: View, url: String) {
//    customProgress.isVisible = true
//    Glide
//        .with(target.context)
//        .load(url)
//        .listener(object : RequestListener<Drawable> {
//            override fun onLoadFailed(
//                e: GlideException?,
//                model: Any?,
//                target: Target<Drawable>?,
//                isFirstResource: Boolean
//            ): Boolean {
//                customProgress.isVisible = false
//                return false
//            }
//
//            override fun onResourceReady(
//                resource: Drawable?,
//                model: Any?,
//                target: Target<Drawable>?,
//                dataSource: DataSource?,
//                isFirstResource: Boolean
//            ): Boolean {
//                customProgress.isVisible = false
//                return false
//            }
//
//        })
//        .error(R.drawable.ic_broken_image)
//        .into(target)
//}