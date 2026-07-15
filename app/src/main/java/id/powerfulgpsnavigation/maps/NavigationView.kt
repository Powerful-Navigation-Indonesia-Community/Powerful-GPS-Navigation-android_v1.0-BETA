package id.powerfulgpsnavigation.maps

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.location.LocationComponent
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap

class NavigationView: AppCompatActivity() {

    private lateinit var navigationMapView: View
    private lateinit var navigationMapViewRefreshRate: MapView
    private lateinit var maplibreNavMap: MapboxMap
    private lateinit var locationComponent: LocationComponent

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this)

        val inflater = LayoutInflater.from(this)
        navigationMapView = inflater.inflate(R.layout.navigation_view_layout, null)

        navigationMapViewRefreshRate = navigationMapView.findViewById(R.id.navigationMapView)
        navigationMapViewRefreshRate.onCreate(savedInstanceState)
        navigationMapViewRefreshRate.getMapAsync { map ->
            maplibreNavMap = map
            locationComponent = maplibreNavMap.locationComponent
            locationComponent.setMaxAnimationFps(70)
        }
    }
}