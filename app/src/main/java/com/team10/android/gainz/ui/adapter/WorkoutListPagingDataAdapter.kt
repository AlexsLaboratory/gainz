package com.team10.android.gainz.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team10.android.gainz.databinding.WorkoutListItemBinding
import com.team10.android.gainz.models.WorkoutPaging
import com.team10.android.gainz.utils.DiffUtilCallBack

class WorkoutListPagingDataAdapter(private val listener: OnWorkoutClickListener) :
  PagingDataAdapter<WorkoutPaging.Data, WorkoutListPagingDataAdapter.WorkoutListViewHolder>(
    DiffUtilCallBack()
  ) {
  private lateinit var workouts: WorkoutPaging.Data

  override fun onBindViewHolder(holder: WorkoutListViewHolder, position: Int) {
    val item = getItem(position)
    item?.let {
      holder.onBind(it)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutListViewHolder {
    val binding = WorkoutListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return WorkoutListViewHolder(binding)
  }

  inner class WorkoutListViewHolder(private val binding: WorkoutListItemBinding) :
    RecyclerView.ViewHolder(binding.root),
    View.OnClickListener {

    private lateinit var data: WorkoutPaging.Data

    init {
      itemView.setOnClickListener(this)
    }

    fun onBind(data: WorkoutPaging.Data) {
      this.data = data
      binding.workoutId.text = data.id.toString()
      binding.workoutTitle.text = data.title
      binding.workoutBody.text = data.body
    }

    override fun onClick(v: View?) {
      listener.onWorkoutClick(data)
    }
  }
}