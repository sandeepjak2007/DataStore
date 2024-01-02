package com.sandeep.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreUtil {

    val intPreferencesDataStoreValue: Flow<Int>
    val stringPreferencesDataStoreValue: Flow<String>
    val floatPreferencesDataStoreValue: Flow<Float>
    val doublePreferencesDataStoreValue: Flow<Double>
    val booleanPreferencesDataStoreValue: Flow<Boolean>
    val longPreferencesDataStoreValue: Flow<Long>
    val stringSetPreferencesDataStoreValue: Flow<Set<String>>

    //Save Preference Data Store
    suspend fun saveIntPreferenceDataStore(count: Int)
    suspend fun saveStringPreferenceDataStore(str: String)
    suspend fun saveFloatPreferenceDataStore(amount: Float)
    suspend fun saveBooleanPreferenceDataStore(isLoggedIn: Boolean)
    suspend fun saveDoublePreferenceDataStore(diameter: Double)
    suspend fun saveLongPreferenceDataStore(items: Long)
    suspend fun saveStringSetPreferenceSetDataStore(months: Set<String>)

    val stringProtoDataStoreValue: Flow<String>
    val doubleProtoDataStoreValue: Flow<Double>
    val booleanProtoDataStoreValue: Flow<Boolean>
    val floatProtoDataStoreValue: Flow<Float>
    val intProtoDataStoreValue: Flow<Int>

    //Save Proto Data Store
    suspend fun saveIntProtoDataStore(count: Int)
    suspend fun saveStringProtoDataStore(str: String)
    suspend fun saveFloatProtoDataStore(amount: Float)
    suspend fun saveBooleanProtoDataStore(isLoggedIn: Boolean)
    suspend fun saveDoubleProtoDataStore(diameter: Double)
}