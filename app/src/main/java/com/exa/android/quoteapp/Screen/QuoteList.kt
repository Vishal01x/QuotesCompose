package com.exa.android.quoteapp.Screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.exa.android.quoteapp.DataManager.data
import com.exa.android.quoteapp.models.Quote

@Composable
fun QuoteList(data : Array<Quote>, onClick : (quote : Quote) ->Unit) {
       LazyColumn {
           items(data){
               QuoteListItem(quote = it, onClick)
           }
       }
    }
