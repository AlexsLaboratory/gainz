package com.team10.android.gainz.repository.flow

import androidx.paging.PagingData
import com.team10.android.gainz.models.WorkoutPaging
import kotlinx.coroutines.flow.Flow

interface WorkoutFlowRepository {
  fun getWorkoutListPaging() : Flow<PagingData<WorkoutPaging.Data>>
}