package com.example.onlineshop.ui.modules.auth

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.SpannedString
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentAuthBinding
import com.example.onlineshop.assemblies.auth.AuthAssembly
import com.example.onlineshop.datamodels.enums.FieldType
import com.example.onlineshop.datamodels.items.AccountData
import com.example.onlineshop.utils.ANNOTATION_KEY
import com.example.onlineshop.utils.EMPTY_STRING
import com.example.onlineshop.utils.ZERO
import com.example.onlineshop.utils.colorItem
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding
    private val authViewModel by lazy { AuthAssembly(requireContext()).build() }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        authViewModel.apply {
            initScreen()
            binding?.apply {
                hintText.setOnClickListener {
                    clearText()
                    changeCurrentScreen()
                }
                authButton.apply {
                    setOnClickListener {
                        if (authViewModel.isClickable())
                            authButtonPressed(
                                AccountData(
                                    getFirstName(),
                                    getLastName(),
                                    getEmail()
                                )
                            )
                    }
                }
                lastName.apply {
                    setOnClickListener {
                        inputType = getCurrentScreenState().secondFieldType()
                    }
                }
            }
        }
        return binding?.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel.apply {
            currentScreen.observe(viewLifecycleOwner) {
                val text = getText(it.hintTextId()) as SpannedString
                binding?.apply {
                    header.text = getString(it.headerId())
                    authButton.text = getString(it.authButtonTextId())
                    lastName.hint = getString(it.hintId())
                    email.visibility = it.emailVisibility()
                    emailErrorText.visibility = it.emailVisibility()
                    otherSignIn.isVisible = it.isOtherSignInVisible()
                    lastName.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        ZERO,
                        ZERO,
                        it.iconId(),
                        ZERO
                    )
                    hintText.text =
                        SpannableString(text).colorItem(text, ANNOTATION_KEY, it.annotationValue())
                }
                returnNormalState()
            }
            textState.observe(viewLifecycleOwner) {
                val textState = it.first
                val fieldType = it.second
                binding?.apply {
                    val errorLabel = when (fieldType) {
                        FieldType.FIRST_NAME -> firstNameErrorText
                        FieldType.LAST_NAME -> lastNameErrorText
                        FieldType.EMAIL -> emailErrorText
                    }
                    val field = when (fieldType) {
                        FieldType.FIRST_NAME -> firstName
                        FieldType.LAST_NAME -> lastName
                        FieldType.EMAIL -> email
                    }
                    errorLabel.apply {
                        isVisible = textState.isErrorTextVisible()
                        text = getString(textState.errorTextId())
                    }
                    field.apply {
                        background = resources.getDrawable(textState.fieldBackground(), null)
                    }
                    authButton.background =
                        resources.getDrawable(authButtonBackgroundId(), null)
                }
            }

            accountState.observe(viewLifecycleOwner) {
                binding?.apply {
                    authErrorText.isVisible = it.isAuthErrorVisible()
                    authErrorText.text = getString(it.authErrorTextId())
                }
            }

            dataBaseResponse.observe(viewLifecycleOwner) {
                binding?.apply {
                    authErrorText.isVisible = it.isAuthErrorVisible()
                    authErrorText.text = getString(it.authErrorTextId())
                }
            }
        }
        binding?.apply {
            firstName.addTextChangedListener(TextListener(FieldType.FIRST_NAME))
            lastName.addTextChangedListener(TextListener(FieldType.LAST_NAME))
            email.addTextChangedListener(TextListener(FieldType.EMAIL))
        }
    }

    private fun getFirstName() = binding?.firstName?.text.toString()

    private fun getLastName() = binding?.lastName?.text.toString()

    private fun getEmail() = binding?.email?.text.toString()

    private fun clearText() {
        binding?.apply {
            if (firstName.text.isNotEmpty()) {
                val length = firstName.text?.length ?: ZERO
                firstName.text?.replace(ZERO, length, EMPTY_STRING)
            }
            if (lastName.text.isNotEmpty()) {
                val length = lastName.text?.length ?: ZERO
                lastName.text?.replace(ZERO, length, EMPTY_STRING)
            }
            if (email.text.isNotEmpty()) {
                val length = email.text?.length ?: ZERO
                email.text?.replace(ZERO, length, EMPTY_STRING)
            }
        }
    }

    inner class TextListener(private val fieldType: FieldType) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(edit: Editable?) {
            authViewModel.handleEmailText(edit.toString(), fieldType)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun returnNormalState() {
        binding?.apply {
            authErrorText.visibility = View.GONE
            firstNameErrorText.visibility = View.GONE
            lastNameErrorText.visibility = View.GONE
            emailErrorText.visibility = View.GONE
            firstName.background = resources.getDrawable(R.drawable.auth_field_background, null)
            lastName.background = resources.getDrawable(R.drawable.auth_field_background, null)
            email.background = resources.getDrawable(R.drawable.auth_field_background, null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}