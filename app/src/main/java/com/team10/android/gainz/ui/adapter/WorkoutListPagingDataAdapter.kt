package com.team10.android.gainz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team10.android.gainz.databinding.WorkoutListItemBinding
import com.team10.android.gainz.models.WorkoutPaging
import com.team10.android.gainz.utils.DiffUtilCallBack

class WorkoutListPagingDataAdapter() :
  PagingDataAdapter<WorkoutPaging.Data, WorkoutListPagingDataAdapter.WorkoutListViewHolder>(DiffUtilCallBack()) {

  override fun onBindViewHolder(holder: WorkoutListViewHolder, position: Int) {
    getItem(position)?.let {
      holder.onBind(it)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListViewHolder {
    val binding = WorkoutListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return WorkoutListViewHolder(binding)
  }

  class WorkoutListViewHolder(private val binding: WorkoutListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: WorkoutPaging.Data) {
      binding.workoutId.text = data.id.toString()
      binding.workoutTitle.text = data.title
      binding.workoutBody.text = data.body
    }
  }
}