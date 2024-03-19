package fr.gmarquette.atpwtatour.view.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.gmarquette.atpwtatour.databinding.FragmentMatchBinding

class MatchFragment : Fragment() {

    private lateinit var binding: FragmentMatchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMatchBinding.inflate(inflater, container, false)
        var view = binding.root

        return view
    }

}