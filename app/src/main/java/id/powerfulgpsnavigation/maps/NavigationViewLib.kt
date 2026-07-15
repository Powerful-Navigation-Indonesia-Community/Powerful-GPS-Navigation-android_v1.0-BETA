package id.powerfulgpsnavigation.maps

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.location.LocationComponent
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap

class NavigationViewLib: AppCompatActivity() {

    private lateinit var navigationMapView: View
    private lateinit var navigationMapViewFps: MapView
    private lateinit var maplibreNavMap: MapboxMap
    private lateinit var locationComponent: LocationComponent

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = LayoutInflater.from(this)
        navigationMapView = inflater.inflate(com.mapbox.services.android.navigation.ui.v5.R.layout.navigation_view_layout, null)

        navigationMapViewFps = navigationMapView.findViewById(com.mapbox.services.android.navigation.ui.v5.R.id.navigationMapView)
        navigationMapViewFps.onCreate(savedInstanceState)
        navigationMapViewFps.getMapAsync { map ->
            maplibreNavMap = map
            locationComponent = maplibreNavMap.locationComponent
            locationComponent.setMaxAnimationFps(70)
        }
    }
}