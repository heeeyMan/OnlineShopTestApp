package com.example.testapp.ui.modules.signin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.databinding.FragmentSignInBinding
import android.text.InputType
import android.view.MotionEvent
import android.widget.EditText
import android.widget.Toast
import com.example.testapp.R
import com.example.testapp.assemblies.signin.SignInAssembly
import com.example.testapp.utils.ZERO

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding
    private val signInViewModel by lazy { SignInAssembly(requireContext()).build() }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        binding?.lastName?.setCompoundDrawablesRelativeWithIntrinsicBounds(ZERO, ZERO, R.drawable.eye_off, ZERO)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInViewModel.apply {
            currentScreen.observe(viewLifecycleOwner) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}