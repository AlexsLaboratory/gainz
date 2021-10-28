package com.team10.android.gainz.ui.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.team10.android.gainz.MyApplication
import com.team10.android.gainz.databinding.FragmentFlowPagingSourceBinding
import com.team10.android.gainz.repository.flow.WorkoutFlowRepositoryImpl
import com.team10.android.gainz.repository.paging.WorkoutFlowPagingSource
import com.team10.android.gainz.ui.adapter.WorkoutPagingDataAdapter
import com.team10.android.gainz.ui.flow.viewModel.FlowViewModel
import com.team10.android.gainz.utils.ViewModelProviderFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class FlowPagingSourceFragment : Fragment() {
  private lateinit var binding: FragmentFlowPagingSourceBinding
  private lateinit var viewModel: FlowViewModel
  private lateinit var repository: WorkoutFlowRepositoryImpl
  private lateinit var pagingSource: WorkoutFlowPagingSource
  private lateinit var pagingDataAdapter: WorkoutPagingDataAdapter
  private val linearLayoutManager: LinearLayoutManager by lazy {
    LinearLayoutManager(requireContext())
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentFlowPagingSourceBinding.inflate(layoutInflater)
    pagingSource =
      WorkoutFlowPagingSource(
        (requireActivity().application as MyApplication)
          .workoutService
      )
    repository = WorkoutFlowRepositoryImpl(pagingSource)
    viewModel = ViewModelProvider(this, ViewModelProviderFactory(FlowViewModel::class) {
      FlowViewModel(repository)
    })[FlowViewModel::class.java]
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    pagingDataAdapter = WorkoutPagingDataAdapter()
    binding.rwFlowPagingData.apply {
      layoutManager = linearLayoutManager
      adapter = pagingDataAdapter
    }
    observers()
  }

  private fun observers() {
    lifecycleScope.launch {
      viewModel.getWorkoutListPaging()
        .collectLatest {
          pagingDataAdapter.submitData(lifecycle, it)
        }
    }
  }

}