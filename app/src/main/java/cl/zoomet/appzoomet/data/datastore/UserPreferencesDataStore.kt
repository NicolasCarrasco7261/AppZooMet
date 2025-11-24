package cl.zoomet.appzoomet.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "visto")


// 2) Claves de preferencias
private object PrefKeys {
    val ANIMAL_VISTO: Preferences.Key<Set<String>> =
        stringSetPreferencesKey("nombreAnimal")
}

// 3) Repositorio que expone Flows (lectura) y funciones suspend (escritura)
class PreferencesRepository(private val context: Context) {

    // Flows para leer
    val animalVistoFlow: Flow<Set<String>> = context.dataStore.data
        .map { prefs -> prefs[PrefKeys.ANIMAL_VISTO] ?: emptySet() }

    // Funciones suspend para escribir
    suspend fun setAnimalVisto(nombreAnimal: Set<String>) {
        context.dataStore.edit { prefs ->
            prefs[PrefKeys.ANIMAL_VISTO] = nombreAnimal
        }
    }
}