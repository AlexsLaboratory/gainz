package com.team10.android.gainz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team10.android.gainz.databinding.WorkoutListViewBinding
import com.team10.android.gainz.models.WorkoutPaging
import com.team10.android.gainz.utils.DiffUtilCallBack

class WorkoutPagingDataAdapter() :
  PagingDataAdapter<WorkoutPaging.Data, WorkoutPagingDataAdapter.WorkoutViewHolder>(DiffUtilCallBack()) {

  override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
    getItem(position)?.let {
      holder.onBind(it)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
    val binding = WorkoutListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return WorkoutViewHolder(binding)
  }

  class WorkoutViewHolder(val binding: WorkoutListViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: WorkoutPaging.Data) {
      binding.workoutId.text = data.id.toString()
      binding.workoutTitle.text = data.title
      binding.workoutBody.text = data.body
    }
  }
}