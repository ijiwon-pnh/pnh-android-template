package com.pnhglobal.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

internal const val DATA_STORE_NAME = "ovi_pay"

internal val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATA_STORE_NAME)

class OviPayDataStore(dataStore: DataStore<Preferences>) {
}