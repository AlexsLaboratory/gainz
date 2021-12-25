package com.team10.android.gainz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.team10.android.gainz.databinding.WorkoutListFragmentBinding
import com.team10.android.gainz.repository.flow.WorkoutFlowRepositoryImpl
import com.team10.android.gainz.repository.paging.WorkoutFlowPagingSource
import com.team10.android.gainz.ui.adapter.WorkoutListPagingDataAdapter
import com.team10.android.gainz.ui.flow.viewModel.WorkoutViewModel
import com.team10.android.gainz.utils.SessionManager
import com.team10.android.gainz.utils.ViewModelProviderFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WorkoutListFragment : Fragment() {
  private lateinit var binding: WorkoutListFragmentBinding
  private lateinit var viewModel: WorkoutViewModel
  private lateinit var repository: WorkoutFlowRepositoryImpl
  private lateinit var pagingSource: WorkoutFlowPagingSource
  private lateinit var pagingDataAdapter: WorkoutListPagingDataAdapter
  private lateinit var sessionManager: SessionManager

  companion object {
    fun newInstance() = WorkoutListFragment()
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    sessionManager = SessionManager(requireContext())
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = WorkoutListFragmentBinding.inflate(layoutInflater)
    pagingSource =
      WorkoutFlowPagingSource(
        (requireActivity().application as MyApplication)
          .workoutService
      )
    pagingSource.token = sessionManager.getAuthToken()
    repository = WorkoutFlowRepositoryImpl(pagingSource)
    pagingDataAdapter = WorkoutListPagingDataAdapter()
    binding.workoutRecyclerView.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = pagingDataAdapter
    }
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel = ViewModelProvider(this, ViewModelProviderFactory(WorkoutViewModel::class) {
      WorkoutViewModel(repository)
    })[WorkoutViewModel::class.java]
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