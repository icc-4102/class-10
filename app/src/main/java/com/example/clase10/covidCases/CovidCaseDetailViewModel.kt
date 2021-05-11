package com.example.clase09.covidCases

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.clase09.MainActivity
import com.example.clase09.model.CovidCaseEntityMapper
import com.example.clase09.model.CovidCaseModel
import com.example.clase09.model.CovidCasesDao
import com.example.clase09.model.DatabaseRepository
import com.example.clase09.navigation.Navigator
import com.example.clase09.networking.CovidCaseRepository
import com.example.clase09.networking.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CovidCaseDetailViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var case: CovidCaseModel
    val myCase = MutableLiveData<CovidCaseModel>()
    lateinit var navigator: Navigator
    var database: CovidCasesDao

    // Ya que AsyncTask esta deprecado utilizaremos esta forma. Y como vamos a hacer lectura y escritura en mas de un lado es mejor crearla aca
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())


    init {
        database = DatabaseRepository(application).getCovidCaseDao()
    }

    fun loadCases(countryId: String) {
        executor.execute {
            case = CovidCaseEntityMapper().mapFromCached(database.getCountry(countryId))
            myCase.postValue(case)
        }
    }

    fun setNavigator(activity: MainActivity?) {
        navigator = Navigator(activity)
    }



}