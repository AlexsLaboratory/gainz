package com.team10.android.gainz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val ID_PARAM = "id"

class WorkoutFragment : Fragment() {
  private var id: Int? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      id = it.getInt(ID_PARAM)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_workout, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    Log.d("WorkoutFragment", arguments?.getInt(ID_PARAM).toString())
  }

  companion object {
    fun newInstance(id: Int): WorkoutFragment {
      val args = Bundle().apply {
        putInt(ID_PARAM, id)
      }
      return WorkoutFragment().apply {
        arguments = args
      }
    }
  }
}