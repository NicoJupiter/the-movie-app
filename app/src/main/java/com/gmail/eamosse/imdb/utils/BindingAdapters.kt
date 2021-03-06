package com.gmail.eamosse.imdb.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.gmail.eamosse.imdb.R

object BindingAdapters {

    @JvmStatic
    @BindingAdapter(value = ["app:bindImage", "app:radius"], requireAll = false)
    fun bindImage(imageView: ImageView, url: String?, radius: Int? = null) {
        url?.let {
            var requestOptions = RequestOptions()
            if(radius !== null) {

                requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(radius));
            }
            Glide.with(imageView)
                .load("https://image.tmdb.org/t/p/original/$url")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .apply(requestOptions)
                .into(imageView)
        }
    }
}

