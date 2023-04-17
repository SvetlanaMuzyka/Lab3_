package disney.character.info.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import disney.character.info.databinding.FragmentDetailsBinding
import disney.character.info.ui.main.contentAdapter.ContentModel


class DetailsFragment : Fragment() {

    lateinit var contentModel: ContentModel
    lateinit var binding: FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contentModel = arguments?.getParcelable<ContentModel>("content")!!
        binding.tvName.text = contentModel.name
        Glide.with(requireContext()).load(contentModel.image).into(binding.image)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        val view = binding.root;
        return view;
    }


}


