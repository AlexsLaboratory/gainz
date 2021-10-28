package com.team10.andriod.gainz.repository.flow

import androidx.paging.PagingData
import com.team10.andriod.gainz.models.WorkoutPaging
import kotlinx.coroutines.flow.Flow

interface WorkoutFlowRepository {
  fun getWorkoutListPaging() : Flow<PagingData<WorkoutPaging.Data>>
}