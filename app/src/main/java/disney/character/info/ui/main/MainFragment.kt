package disney.character.info.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import disney.character.info.R
import disney.character.info.databinding.FragmentMainBinding
import disney.character.info.ui.main.contentAdapter.ContentAdapter
import disney.character.info.ui.main.contentAdapter.ContentModel


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var contentAdapter: ContentAdapter
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()
        initAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        val view = binding.root;
        return view;
    }


    private fun initLiveData() {
        viewModel.getContent()
        viewModel.contentLiveData.observe(viewLifecycleOwner, {
            contentAdapter.update(it)
        })
    }

    private fun initAdapter() {
        contentAdapter = ContentAdapter(onClick = { id -> onClick(id) })
        binding.rvComments.setHasFixedSize(true)
        binding.rvComments.layoutManager = LinearLayoutManager(context)
        binding.rvComments.adapter = contentAdapter
    }

    private fun onClick(item: ContentModel) {
        val bundle = Bundle()
        bundle.putParcelable("content", item)
        showNextFragment(R.id.main_to_details, bundle)
    }


    fun showNextFragment(destination: Int, bundle: Bundle? = Bundle()) {
        try {
            NavHostFragment.findNavController(this).navigate(destination, bundle)
        } catch (e: IllegalArgumentException) {
            Log.d("TAG", "Can't open 2 links at once!")
        } catch (e: IllegalStateException) {
            Log.d("TAG", "IllegalStateException not associated with a fragment manager")
        }
    }
}