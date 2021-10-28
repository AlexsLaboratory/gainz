package com.team10.andriod.gainz.repository.flow

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.team10.andriod.gainz.models.WorkoutPaging
import com.team10.andriod.gainz.repository.paging.WorkoutFlowPagingSource
import kotlinx.coroutines.flow.Flow

class WorkoutFlowRepositoryImpl(
  private val pagingSource: WorkoutFlowPagingSource
) : WorkoutFlowRepository {
  override fun getWorkoutListPaging(): Flow<PagingData<WorkoutPaging.Data>> {
    return Pager(
      defaultPagingSource(),
      pagingSourceFactory = {pagingSource}
    ).flow
  }

  private fun defaultPagingSource() : PagingConfig {
    return PagingConfig(
      pageSize = 10,
      prefetchDistance = 20,
      enablePlaceholders = false,
      initialLoadSize = 20,
      maxSize = 50
    )
  }
}