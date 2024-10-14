package com.example.nagaparkmaster.ui.account;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nagaparkmaster.MainActivity
import com.example.nagaparkmaster.databinding.FragmentAccountBinding

import com.example.nagaparkmaster.databinding.FragmentParkingHistoryBinding
import com.example.nagaparkmaster.ui.account.AccountViewModel
import com.google.firebase.auth.FirebaseAuth


class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val accountViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)

        auth = FirebaseAuth.getInstance();


        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAccount
        accountViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val buttonLogout: Button = binding.buttonLogout;
        buttonLogout.setOnClickListener {
            if(auth.currentUser!=null){
                auth.signOut();
            }

            val intent = Intent(context, MainActivity::class.java);
            startActivity(intent);
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}