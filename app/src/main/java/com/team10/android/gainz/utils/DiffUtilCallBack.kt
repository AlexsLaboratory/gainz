package com.team10.android.gainz.utils

import androidx.recyclerview.widget.DiffUtil
import com.team10.android.gainz.models.WorkoutPaging

class DiffUtilCallBack : DiffUtil.ItemCallback<WorkoutPaging.Data>() {
  override fun areItemsTheSame(
    oldItem: WorkoutPaging.Data,
    newItem: WorkoutPaging.Data
  ): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(
    oldItem: WorkoutPaging.Data,
    newItem: WorkoutPaging.Data
  ): Boolean {
    return oldItem == newItem
  }
}