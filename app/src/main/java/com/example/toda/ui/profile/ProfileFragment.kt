package com.example.toda.ui.profile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.toda.LoginActivity
import com.example.toda.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val fullNameText = view.findViewById<TextView>(R.id.fullNameText)
        val phoneText = view.findViewById<TextView>(R.id.phoneText)
        val addressText = view.findViewById<TextView>(R.id.addressText)
        val logoutButton = view.findViewById<Button>(R.id.logoutButton)

        val firstName = sharedPreferences.getString("firstName", "N/A")
        val lastName = sharedPreferences.getString("lastName", "N/A")
        val phone = sharedPreferences.getString("phone", "N/A")
        val address = sharedPreferences.getString("address", "N/A")

        fullNameText.text = "Full Name: $firstName $lastName"
        phoneText.text = "Phone: $phone"
        addressText.text = "Address: $address"

        logoutButton.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }
}
