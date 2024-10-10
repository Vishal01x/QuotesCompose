package com.exa.android.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.exa.android.quoteapp.models.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var curQuote : Quote ? = null

    val isDataLoaded = mutableStateOf(false)
    val curPage = mutableStateOf(Pages.LISTING)


    fun loadAssetsFromFile(context : Context){
        val inputStream = context.assets.open("quotes.json")
        val size :Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote :Quote?){
        if(curPage.value == Pages.LISTING){
            curPage.value = Pages.DETAIL
            curQuote = quote
        }else{
            curPage.value = Pages.LISTING
        }
    }
}