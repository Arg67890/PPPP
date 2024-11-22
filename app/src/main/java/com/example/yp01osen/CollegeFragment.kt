package com.example.yp01osen

import android.graphics.Camera
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class CollegeFragment : Fragment() {
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MapKitFactory.setApiKey("b7c191c9-ad5c-4444-ae63-7b5f2900afaf")
        MapKitFactory.initialize(requireContext())
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_college, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = view.findViewById(R.id.mapview)
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
        val info: TextView = view.findViewById(R.id.textViewCollegeInfo)
        info.text = resources.getText(R.string.collegeInfo)
        mapView.map.move(
            CameraPosition(
                Point(51.245134, 58.462665),17.0f,150.0f,30.0f
            )
        )
     }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}