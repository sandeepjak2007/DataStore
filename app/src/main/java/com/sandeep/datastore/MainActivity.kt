package com.sandeep.datastore

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var dataStoreUtil: DataStoreUtilImpl

    private val Context.prefDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "pref_data_Store"
    )

    private val Context.protoDataStore: DataStore<UserProto> by dataStore(
        fileName = "proto_data_store.pb", serializer = UserProtoDataStoreSerializer
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Creation of the data store object
        dataStoreUtil = DataStoreUtilImpl(prefDataStore, protoDataStore)
    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(Dispatchers.IO).launch {
            //Saving Preference Data Store
            dataStoreUtil.saveIntPreferenceDataStore(20)
            dataStoreUtil.saveFloatPreferenceDataStore(200.9f)
            dataStoreUtil.saveStringPreferenceDataStore("Android")
            dataStoreUtil.saveBooleanPreferenceDataStore(false)
            dataStoreUtil.saveDoublePreferenceDataStore(34.9)
            dataStoreUtil.saveLongPreferenceDataStore(56789876)
            dataStoreUtil.saveStringSetPreferenceSetDataStore(
                setOf(
                    "January",
                    "February",
                    "March",
                    "April",
                    "May",
                    "June",
                    "July",
                    "August",
                    "September",
                    "October",
                    "November",
                    "December"
                )
            )

            // Saving Proto Data Store
            dataStoreUtil.saveIntProtoDataStore(30)
            dataStoreUtil.saveFloatProtoDataStore(45.8f)
            dataStoreUtil.saveDoubleProtoDataStore(378.9)
            dataStoreUtil.saveStringProtoDataStore("Android")
            dataStoreUtil.saveBooleanProtoDataStore(true)

            dataStoreUtil.apply {
                //Retrieving Preference Data Store
                intPreferencesDataStoreValue.collect().let {
                    Log.i(TAG, "Int Preference Data Store: $it")
                }
                floatPreferencesDataStoreValue.collect().let {
                    Log.i(TAG, "Float Preference Data Store:$it")
                }
                stringPreferencesDataStoreValue.collect().let {
                    Log.i(TAG, "String Preference Data Store: $it")
                }
                booleanPreferencesDataStoreValue.collect().let {
                    Log.i(
                        TAG, "Boolean Preference Data Store: $it"
                    )
                }
                doublePreferencesDataStoreValue.collect().let {
                    Log.i(TAG, "Double Preference Data Store: $it")
                }
                longPreferencesDataStoreValue.collect().let {
                    Log.i(TAG, "Long Preference Data Store: $it")
                }
                stringPreferencesDataStoreValue.collect().let {
                    Log.i(
                        TAG, "String Set Preference Data Store: $it"
                    )
                }
                //Retrieving Proto Data Store
                intProtoDataStoreValue.collect().let {
                    Log.i(TAG, "Int Proto Data Store: $it")
                }
                floatProtoDataStoreValue.collect().let {
                    Log.i(TAG, "Float Proto Data Store: $it")
                }
                doubleProtoDataStoreValue.collect().let {
                    Log.i(TAG, "Double Proto Data Store: $it")
                }
                stringProtoDataStoreValue.collect().let {
                    Log.i(TAG, "String Proto Data Store: $it")
                }
                booleanProtoDataStoreValue.collect().let {
                    Log.i(TAG, "Boolean Proto Data Store:$it")
                }
            }
        }

    }

    companion object {
        const val TAG = "MainActivity"
    }
}