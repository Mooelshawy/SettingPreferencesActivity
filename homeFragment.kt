package com.omran.settingpreferencesactivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColorInt
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class homeFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab_settings = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab_settings.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        settings(view)
    }

    @SuppressLint("SetTextI18n")
    private fun settings(view: View) {
        val signature_textview :TextView = view.findViewById(R.id.tv_signature)
        val reply_textview :TextView = view.findViewById(R.id.tv_reply)
        val sync_textview :TextView = view.findViewById(R.id.tv_sync)
        val noptication_textview :TextView = view.findViewById(R.id.tv_notifications)
        val volume_progress:ProgressBar = view.findViewById(R.id.pb_volume)
        val color_t:TextView = view.findViewById(R.id.tv_color)


        val container:ConstraintLayout = view.findViewById(R.id.main_container)


        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        val signature = sp.getString("signature", "")
        val defaultReplyAction = sp.getString("reply", "")
        val sync = sp.getBoolean("sync", true)
        val notifications = sp.getBoolean("notifications", true)
        val color = sp.getString("color", "")
        val volume = sp.getInt("volume_notifications", 0)


        signature_textview.text = "Signature: $signature"
        reply_textview.text = "Default reply: $defaultReplyAction"
        sync_textview.text = "Sync: $sync"
        noptication_textview.text = "Disable notifications: $notifications"
        color_t.text = "Background Color: $color"

        volume_progress.progress = volume
        volume_progress.animate()


        when(color){
            "#FFBB86FC" -> container.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.purple_200, null))//without theme)
            "#FF6200EE" -> container.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.purple_500, null))
            "#FF3700B3" -> container.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.purple_700, null))
            //getColor() is deprcated
            "#FF03DAC5" -> container.setBackgroundColor(resources.getColor(R.color.teal_200))
            "#FF018786" -> container.setBackgroundColor(resources.getColor(R.color.teal_700))
            "#FF000000" -> container.setBackgroundColor(resources.getColor(R.color.black))
        }
    }

}