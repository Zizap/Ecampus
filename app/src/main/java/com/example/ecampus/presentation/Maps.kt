package com.example.ecampus.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecampus.R
import com.example.ecampus.data.models.getModels.GetSpecialtiesModel
import com.example.ecampus.data.models.mapPlace.MapPlaces
import com.example.ecampus.databinding.FragmentMapsBinding
import com.example.ecampus.presentation.adapters.CorpsAdapter
import com.example.ecampus.presentation.adapters.InstitutesAdapter
import com.google.android.gms.location.LocationServices
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class Maps : Fragment() {

    private var binding: FragmentMapsBinding? = null
    private lateinit var mapview: MapView
    private var initialized = false
    private var corpsAdapter: CorpsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(inflater,container,false)

        mapview = MapView(requireContext())
        binding?.mapView?.addView(mapview)

        val mapKit: MapKit = MapKitFactory.getInstance()
        val traffic = mapKit.createTrafficLayer(mapview.mapWindow)
        var trafficIsOn = false

        binding?.trafficButton?.setOnClickListener {
            when(trafficIsOn) {
                true -> {
                    trafficIsOn = false
                    traffic.isTrafficVisible = false
                }
                false -> {
                    trafficIsOn = true
                    traffic.isTrafficVisible = true
                }
            }
        }

        binding?.moveUser?.setOnClickListener {
            moveUserPosition()
        }

        initRecycler()

        requestLocationPermission()

        val locationMapKit = mapKit.createUserLocationLayer(mapview.mapWindow)
        locationMapKit.isVisible = true


        val popup = PopupMenu(context as FragmentActivity,binding?.popupButton)
        popup.menuInflater.inflate(R.menu.popup_menu_button,popup.menu)
        binding?.popupButton?.setText(R.string.stavropol)

        binding?.popupButton?.setOnClickListener {
            popup.setOnMenuItemClickListener {
                    meniItem: MenuItem ->
                when(meniItem.itemId) {
                    R.id.stavropol -> {
                        binding?.popupButton?.setText(R.string.stavropol)
                        loadPlace(corpsStavList)
                        true
                    }
                    R.id.piatigorsk -> {
                        binding?.popupButton?.setText(R.string.piatigorsk)
                        loadPlace(corpsPtgrskList)
                        true
                    }
                    R.id.nevinnomissk -> {
                        binding?.popupButton?.setText(R.string.nevinnomissk)
                        loadPlace(corpsNewinkaList)
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
            popup.show()
        }

        //corpsStavList.forEach{ item -> addPlaceMark(item) }
        //corpsPtgrskList.forEach{ item -> addPlaceMark(item) }
        //corpsNewinkaList.forEach{ item -> addPlaceMark(item) }

        return binding?.root
    }

    private fun initRecycler(){
        binding?.corpsRecycler?.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        corpsAdapter = CorpsAdapter({ mapPlaces: MapPlaces -> movePlace(mapPlaces)})
        binding?.corpsRecycler?.adapter = corpsAdapter
        loadPlace(corpsStavList)
    }

    private fun loadPlace(corps:List<MapPlaces>){
        corpsAdapter?.setList(corps)
        corpsAdapter?.notifyDataSetChanged()
    }

    private fun movePlace(mapPlaces: MapPlaces){
        addPlaceMark(mapPlaces)
        moveCameraPosition(mapPlaces.latitude,mapPlaces.longitude)
    }

    private fun addPlaceMark(mapPlaces: MapPlaces){
        val mapObjects = mapview.map.mapObjects
        val point = Point(mapPlaces.latitude, mapPlaces.longitude)
        val placemark = mapObjects.addPlacemark(point)

        placemark.setIcon(ImageProvider.fromResource(context, R.drawable.map_mark))
        placemark.setText(mapPlaces.namber)
        //placemark.setNoninteractive(true)
    }

    private fun requestLocationPermission(){
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {

            }
            else {
                // Do otherwise
            }
        }

        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapview.onStart()
        moveUserPosition()


    }

    private fun moveUserPosition(){
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context as FragmentActivity)
        if (ContextCompat.checkSelfPermission(context as FragmentActivity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    val latitude = location.latitude
                    val longitude = location.longitude

                    moveCameraPosition(latitude,longitude)
                }
            }
        }
    }

    private fun moveCameraPosition(latitude:Double,longitude:Double){
        mapview.map?.move(CameraPosition(
            Point(latitude,longitude),
            17.0f,
            0.0f,
            0.0f
        ),
            Animation(Animation.Type.SMOOTH,1f),null)
    }

    fun initialize() {
        if (initialized) {
            return
        }
        //MapKitFactory.setApiKey(Constants.MAPKIT_KEY)
        MapKitFactory.initialize(context as FragmentActivity)
        initialized = true
    }



    override fun onStart() {
        super.onStart()
        mapview.onStart()
        MapKitFactory.getInstance().onStart()

    }

    override fun onStop() {
        super.onStop()
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
    }

    companion object{
        private val corps1 = MapPlaces(1,45.043521, 41.961798, "Корпус № 1, Административный корпус","Улица Пушкина, 1, лит. А1","Корпус № 1")
        private val corps2 = MapPlaces(2,45.042642, 41.962202,"Корпус № 2, Физико-технический факультет, Факультет математики и компьютерных наук имени профессора Н.И. Червякова", "Улица Пушкина, 1, лит. А","Корпус № 2")
        private val corps3 = MapPlaces(3,45.042082, 41.959516, "Корпус № 3 Химико-фармацевтический факультет", "Улица Пушкина, 1, лит. Р-Р1","Корпус № 3")
        private val corps4 = MapPlaces(4,45.042419, 41.959633, "Корпус № 4", "Улица Пушкина, 1, лит. У","Корпус № 4")
        private val corps5 = MapPlaces(5,45.044298, 41.962714, "Корпус № 5", "Улица Дзержинского, 153","Корпус № 5")
        private val corps6 = MapPlaces(6,45.042827, 41.964385, "Корпус № 6 и 6А", "Площадь Ленина, 3А","Корпус № 6 и 6А")
        private val corps7 = MapPlaces(7,45.040203, 41.969488, "Корпус № 7", "Улица Маршала Жукова, 9","Корпус № 7")
        private val corps8 = MapPlaces(8,45.041572, 41.983645, "Корпус № 8, Психолого-педагогический факультет", "Улица Ленина, 133Б","Корпус № 8")
        private val corps9 = MapPlaces(9,45.041043, 41.910127, "Корпус № 9, Институт цифрового развития", "Проспект Кулакова, 2, лит. А, Б, В","Корпус № 9")
        private val corps10 = MapPlaces(10,45.040757, 41.909381, "Корпус № 10, Инженерный институт" ,"Проспект Кулакова, 2, лит. Ж","Корпус № 10")
        private val corps11 = MapPlaces(11,45.043279, 41.910406, "Корпус № 11, Инженерный институт" ,"Проспект Кулакова, 2, лит. Д","Корпус № 11")
        private val corps12 = MapPlaces(12,45.041566, 41.905977, "Корпус № 12" ,"Проспект Кулакова, 2, лит. Е, З","Корпус № 12")
        private val corps14 = MapPlaces(14,45.046068, 41.900829, "Корпус № 14, Военный учебный центр" ,"Улица Индустриальная, 27","Корпус № 14")
        private val corps15 = MapPlaces(15,45.071956, 41.941128, "Корпус № 15" ,"Улица Октябрьская, 184","Корпус № 15")
        private val corps16 = MapPlaces(16,45.058409, 41.917224, "Корпус № 16, Институт наук о Земле" ,"Проспект Кулакова, 16/1","Корпус № 16")
        private val corps17 = MapPlaces(17,45.040489, 41.910201, "Корпус № 17, Инженерный институт" ,"Проспект Кулакова, 2, лит. Х","Корпус № 17")
        private val corps20 = MapPlaces(20,45.042808, 41.960639, "Корпус № 20, Гуманитарный институт, Юридический институт" ,"Улица Пушкина, 1, лит.","Корпус № 20")
        private val corps21 = MapPlaces(21,45.042387, 41.960756, "Корпус № 21, Институт экономики и управления" ,"Улица Пушкина, 1, лит. Е-1","Корпус № 21")
        private val corps22 = MapPlaces(22,45.041770, 41.910759, "Корпус № 22, Инженерный институт" ,"Проспект Кулакова, 2","Корпус № 22")
        private val corps23 = MapPlaces(23,45.041747, 41.910229, "Корпус № 23, Факультет пищевой инженерии и биотехнологий, Медико-биологический факультет" ,"Проспект Кулакова, 2","Корпус № 23")

        private val corpsPtgrsk1 = MapPlaces(1, 44.043372, 43.063744, "Корпус № 1", "проспект 40 лет Октября, 56","Корпус № 1")
        private val corpsPtgrsk2 = MapPlaces(3,44.052469, 43.041600,"Школа Кавказского гостеприимства","Улица Украинская, 56А","Корпус № 3")
        private val corpsPtgrsk3 = MapPlaces(4,44.035920, 43.071604,"Центр дополнительного профессионального образования и повышения квалификации","Проспект Кирова, 45","Корпус № 4")
        private val corpsPtgrsk4 = MapPlaces(5,44.032336, 43.081530,"Юридический факультет","Улица Партизанская, 1Б корпус 3","Корпус № 5")
        private val corpsPtgrsk5 = MapPlaces(6,44.043308, 43.054608,"Факультет экономики и управления","Улица Матвеева, 35Б","Корпус № 6")
        private val corpsPtgrsk6 = MapPlaces(7,44.051465, 43.000215,"Инженерный факультет","Улица Ермолова, 46","Корпус № 7")
        private val corpsPtgrsk7 = MapPlaces(8,44.048588, 43.059710,"Колледж СКФУ","Улица Московская, 31","Корпус № 8")
        private val corpsPtgrsk8 = MapPlaces(9,44.039297, 43.051374,"Кафедра дизайна инженерного факультета","Улица Козлова, 54","Корпус № 9")
        private val corpsPtgrsk9 = MapPlaces(10,44.037644, 43.076032,"Юридический факультет","Улица Гоголя, 2","Корпус № 10")

        private val corpsNewinka1 = MapPlaces(1,44.644591, 41.941227,"Корпус № 1","Улица Гагарина, дом 1","Корпус № 1")

        private val corpsStavList = listOf(corps1,corps2,corps3,corps4,corps5,corps6,
            corps7,corps8,corps9,corps10,corps11,corps12,corps14,
            corps15,corps16,corps17,corps20,corps21,corps22,corps23)

        private val corpsPtgrskList = listOf(corpsPtgrsk1,corpsPtgrsk2,corpsPtgrsk3,corpsPtgrsk4,
                corpsPtgrsk5,corpsPtgrsk6,corpsPtgrsk7,corpsPtgrsk8,corpsPtgrsk9)

        private val corpsNewinkaList = listOf(corpsNewinka1)
    }

}

