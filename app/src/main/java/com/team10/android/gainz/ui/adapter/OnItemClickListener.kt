package com.team10.android.gainz.ui.adapter

import com.team10.android.gainz.models.WorkoutPaging

interface OnWorkoutClickListener {
  fun onWorkoutClick(workout: WorkoutPaging.Data)
}