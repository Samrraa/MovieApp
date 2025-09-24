package com.karrar.movieapp.ui.allMedia

import androidx.paging.PagingData
import com.karrar.movieapp.ui.models.MediaUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class AllMediaUiState(
    val allMedia : Flow<PagingData<MediaUi>> = emptyFlow(),
    val isLoading : Boolean = false,
    val error : List<Error> = emptyList(),
    )


data class Error(
    val code : Int,
    val message: String,
)