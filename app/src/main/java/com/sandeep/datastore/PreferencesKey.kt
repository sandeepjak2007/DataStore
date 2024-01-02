package com.sandeep.datastore

import androidx.datastore.preferences.core.*

object PreferencesKey {
    val COUNTER = intPreferencesKey("counter")
    val USER_NAME = stringPreferencesKey("user_name")
    val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    val AMOUNT = floatPreferencesKey("amount")
    val DIAMETER = doublePreferencesKey("diameter")
    val ITEMS = longPreferencesKey("items")
    val MONTHS = stringSetPreferencesKey("months")
}