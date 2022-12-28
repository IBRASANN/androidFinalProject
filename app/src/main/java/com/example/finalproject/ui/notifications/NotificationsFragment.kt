package com.example.finalproject.ui.notifications

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.databinding.FragmentNotificationsBinding
import com.example.finalproject.ui.MusicPlayer

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val toggle = binding.toggle1 as ToggleButton

        toggle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                activity!!.startService(Intent(activity, MusicPlayer::class.java))
            } else {
                activity!!.stopService(Intent(activity, MusicPlayer::class.java))
            }
        }
        
        val contact : Button = binding.btnContacts
        contact.setOnClickListener {
            val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "I have a question")
            type = "text/plain"
        }

        // Try to invoke the intent.
        try {
            startActivity(sendIntent)
        } catch (e: ActivityNotFoundException) {
            // Define what your app should do if no activity can handle the intent.
        }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}