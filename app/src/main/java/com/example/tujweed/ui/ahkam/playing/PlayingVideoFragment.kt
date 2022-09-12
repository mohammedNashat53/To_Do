package com.example.tujweed.ui.ahkam.playing

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import com.example.tujweed.databinding.FragmentPlayingVideoBinding


class PlayingVideoFragment : Fragment() {
    lateinit var binding: FragmentPlayingVideoBinding
    lateinit var videoView: VideoView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayingVideoBinding.inflate(inflater,container,false)
        videoView =  binding.videoView

        val path = "android.resource://" + activity?.packageName.toString() + "/" + com.example.tujweed.R.raw.test_vedio
        videoView.setVideoURI(Uri.parse(path))
        videoView.start()
        videoView.stopPlayback()
        videoView.resume()
        return binding.root
    }

}