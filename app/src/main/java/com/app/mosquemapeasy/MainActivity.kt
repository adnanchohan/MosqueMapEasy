package com.app.mosquemapeasy

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mapFragment: SupportMapFragment?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMap()
    }

    private fun setupMap(){
        mapFragment = supportFragmentManager.findFragmentById(R.id.mosque_map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    @SuppressLint("MissingInflatedId")
    override fun onMapReady(googleMap: GoogleMap) {
        val gateOne = LatLng(24.923805, 67.064155)
        val gateTwo = LatLng(24.923357, 67.065467)
        val gateThree = LatLng(24.922324, 67.065404)
        val gateFour = LatLng(24.922093, 67.064564)
        val gateFive = LatLng(24.922131, 67.064115)

        val markerView = (getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.marker_layout, null)
        val text= markerView.findViewById<TextView>(R.id.markerTextView)
        val cardView = markerView.findViewById<CardView>(R.id.markerCardView)

        text.text = "Gate One"
        val bitmap1 = Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height, false)
        val smallMarkerIcon1 = BitmapDescriptorFactory.fromBitmap(bitmap1)
        googleMap.addMarker(MarkerOptions().position(gateOne).icon(smallMarkerIcon1))

        text.text = "Gate Two"
        val bitmap2 = Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height, false)
        val smallMarkerIcon2 = BitmapDescriptorFactory.fromBitmap(bitmap2)
        googleMap.addMarker(MarkerOptions().position(gateTwo).icon(smallMarkerIcon2))

        text.text = "Gate Three"
        val bitmap3 = Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height, false)
        val smallMarkerIcon3 = BitmapDescriptorFactory.fromBitmap(bitmap3)
        googleMap.addMarker(MarkerOptions().position(gateThree).icon(smallMarkerIcon3))

        text.text = "Gate Four"
        val bitmap4 = Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height, false)
        val smallMarkerIcon4 = BitmapDescriptorFactory.fromBitmap(bitmap4)
        googleMap.addMarker(MarkerOptions().position(gateFour).icon(smallMarkerIcon4))

        text.text = "Gate Five"
        val bitmap5 = Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height, false)
        val smallMarkerIcon5 = BitmapDescriptorFactory.fromBitmap(bitmap5)
        googleMap.addMarker(MarkerOptions().position(gateFive).icon(smallMarkerIcon5))
    }

    private fun viewToBitmap(view: View): Bitmap? {
        view.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
        val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }
}
