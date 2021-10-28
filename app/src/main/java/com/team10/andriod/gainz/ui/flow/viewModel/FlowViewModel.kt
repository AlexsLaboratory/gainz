package com.team10.andriod.gainz.ui.flow.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.team10.andriod.gainz.models.WorkoutPaging
import com.team10.andriod.gainz.repository.flow.WorkoutFlowRepositoryImpl
import kotlinx.coroutines.flow.Flow

class FlowViewModel(
  private val repositoryImpl: WorkoutFlowRepositoryImpl
) : ViewModel() {
  fun getWorkoutListPaging(): Flow<PagingData<WorkoutPaging.Data>> =
    repositoryImpl.getWorkoutListPaging().cachedIn(viewModelScope)
}