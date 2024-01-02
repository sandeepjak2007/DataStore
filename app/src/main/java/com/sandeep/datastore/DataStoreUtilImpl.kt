package com.sandeep.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class DataStoreUtilImpl(
    private val prefDataStore: DataStore<Preferences>,
    private val protoDataStore: DataStore<UserProto>,
) : DataStoreUtil {

    override val intPreferencesDataStoreValue: Flow<Int>
        get() = prefDataStore.data.map {
            it[PreferencesKey.COUNTER]?.toInt() ?: 0
        }.catch {
            it.printStackTrace()
        }
    override val stringPreferencesDataStoreValue: Flow<String>
        get() = prefDataStore.data.map {
            it[PreferencesKey.USER_NAME] ?: ""
        }.catch {
            it.printStackTrace()
        }
    override val floatPreferencesDataStoreValue: Flow<Float>
        get() = prefDataStore.data.map {
            it[PreferencesKey.AMOUNT] ?: 0f
        }.catch {
            it.printStackTrace()
        }
    override val doublePreferencesDataStoreValue: Flow<Double>
        get() = prefDataStore.data.map {
            it[PreferencesKey.DIAMETER] ?: 0.00
        }.catch {
            it.printStackTrace()
        }
    override val booleanPreferencesDataStoreValue: Flow<Boolean>
        get() = prefDataStore.data.map {
            it[PreferencesKey.IS_LOGGED_IN] ?: false
        }.catch {
            it.printStackTrace()
        }
    override val longPreferencesDataStoreValue: Flow<Long>
        get() = prefDataStore.data.map {
            it[PreferencesKey.ITEMS] ?: 0L
        }.catch {
            it.printStackTrace()
        }
    override val stringSetPreferencesDataStoreValue: Flow<Set<String>>
        get() = prefDataStore.data.map {
            it[PreferencesKey.MONTHS] ?: setOf()
        }.catch {
            it.printStackTrace()
        }

    override suspend fun saveIntPreferenceDataStore(count: Int) {
        prefDataStore.edit { preferences ->
            preferences[PreferencesKey.COUNTER] = count
        }
    }

    override suspend fun saveStringPreferenceDataStore(str: String) {
        prefDataStore.edit { preferences ->
            preferences[PreferencesKey.USER_NAME] = str
        }
    }

    override suspend fun saveFloatPreferenceDataStore(amount: Float) {
        prefDataStore.edit { preferences ->
            preferences[PreferencesKey.AMOUNT] = amount
        }
    }

    override suspend fun saveBooleanPreferenceDataStore(isLoggedIn: Boolean) {
        prefDataStore.edit { preferences ->
            preferences[PreferencesKey.IS_LOGGED_IN] = isLoggedIn
        }
    }

    override suspend fun saveDoublePreferenceDataStore(diameter: Double) {
        prefDataStore.edit { preferences ->
            preferences[PreferencesKey.DIAMETER] = diameter
        }
    }

    override suspend fun saveLongPreferenceDataStore(items: Long) {
        prefDataStore.edit { preferences ->
            preferences[PreferencesKey.ITEMS] = items
        }
    }

    override suspend fun saveStringSetPreferenceSetDataStore(months: Set<String>) {
        prefDataStore.edit { preferences ->
            preferences[PreferencesKey.MONTHS] = months
        }
    }

    override val stringProtoDataStoreValue: Flow<String>
        get() = protoDataStore.data.map {
            it.username
        }.catch {
            it.printStackTrace()
        }
    override val doubleProtoDataStoreValue: Flow<Double>
        get() = protoDataStore.data.map {
            it.diameter
        }.catch {
            it.printStackTrace()
        }
    override val booleanProtoDataStoreValue: Flow<Boolean>
        get() = protoDataStore.data.map {
            it.isLoggedIn
        }.catch {
            it.printStackTrace()
        }
    override val floatProtoDataStoreValue: Flow<Float>
        get() = protoDataStore.data.map {
            it.amount
        }.catch {
            it.printStackTrace()
        }
    override val intProtoDataStoreValue: Flow<Int>
        get() = protoDataStore.data.map {
            it.friendsCount
        }.catch {
            it.printStackTrace()
        }

    override suspend fun saveIntProtoDataStore(count: Int) {
        protoDataStore.updateData { proto ->
            proto.toBuilder().setCounter(count).build()
        }
    }

    override suspend fun saveStringProtoDataStore(str: String) {
        protoDataStore.updateData { proto ->
            proto.toBuilder().setUsername(str).build()
        }
    }

    override suspend fun saveFloatProtoDataStore(amount: Float) {
        protoDataStore.updateData { proto ->
            proto.toBuilder().setAmount(amount).build()
        }
    }

    override suspend fun saveBooleanProtoDataStore(isLoggedIn: Boolean) {
        protoDataStore.updateData { proto ->
            proto.toBuilder().setIsLoggedIn(isLoggedIn).build()
        }
    }

    override suspend fun saveDoubleProtoDataStore(diameter: Double) {
        protoDataStore.updateData { proto ->
            proto.toBuilder().setDiameter(diameter).build()
        }
    }
}