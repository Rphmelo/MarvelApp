package com.rphmelo.marvelapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.rphmelo.marvelapp.databinding.FragmentRegisterCharacterBinding
import com.rphmelo.marvelapp.model.CharacterInfo

class RegisterCharacterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_character, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun clearFields() {
        binding.textInputEditTextCharacterName.text?.clear()
        binding.textInputEditTextCharacterDescription.text?.clear()
    }

    private fun setupViews() {
        with(binding) {
            registerButton.setOnClickListener {
                val characterInfo = CharacterInfo(
                    name = textInputEditTextCharacterName.text.toString(),
                    description = textInputEditTextCharacterDescription.text.toString()
                )
                Database.characterList.add(characterInfo)
                clearFields()
            }

            goToListButton.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_registerCharacterFragment_to_characterFragment)
            }
        }
    }
}