package cl.zoomet.appzoomet.view.home.zoo.animales

import cl.zoomet.appzoomet.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * Define la estructura de datos para un solo animal.
 * Usamos una data class porque su propósito es solo contener datos.
 */
data class Animal(
    val nombre: String,
    val descripcion: String,
    val estadoConservacion: String,
    val imagen: Int // Int se usa para referenciar un ID de recurso drawable (ej: R.drawable.leon)
)

/**
 * El Repositorio gestiona el origen de los datos de los animales.
 * En este caso, la fuente de datos es una lista estática definida aquí mismo.
 */
class AnimalesRepository {

    // Lista privada de animales.
    private val listaDeAnimales = listOf(
        Animal(
            nombre = "León",
            descripcion = "El león (Panthera leo) es un mamífero carnívoro de la familia de los félidos y una de las cinco especies del género Panthera. Los leones salvajes viven en poblaciones cada vez más dispersas y fragmentadas del África subsahariana (a excepción de las regiones selváticas de la costa del Atlántico y la cuenca del Congo)",
            estadoConservacion = "Vulnerable (Reducción)",
            imagen = R.drawable.leon // ¡IMPORTANTE! Reemplaza esto con tu imagen real, ej: R.drawable.leon
        ),
        Animal(
            nombre = "Camello",
            descripcion = "El camello (camelus) es un género de mamíferos artiodáctilos de la familia Camelidae que incluye a las tres especies vivientes de la familia originarias del Viejo Mundo, que son denominadas popularmente como camellos y dromedarios. Como todos los camélidos, los camellos son artiodáctilos, o ungulados con un número par de pezuñas.",
            estadoConservacion = "No Extinto",
            imagen = R.drawable.camello// Reemplaza con tu imagen, ej: R.drawable.panda
        ),
        Animal(
            nombre = "Tigre de Bengala",
            descripcion = "El tigre de Bengala (Panthera tigris tigris), también conocido como tigre de Bengala real o tigre indio, es una subespecie de tigre que habita en la India, Nepal, Bangladés, Bután, Birmania y Tíbet. Es la subespecie más numerosa y conocida de tigre, y se encuentra en una gran variedad de hábitats, incluyendo sabanas y bosques tropicales y subtropicales. Su pelaje es generalmente de color naranja o leonado",
            estadoConservacion = "En Peligro de extinción (Reducción)",
            imagen = R.drawable.tigrebengala // Reemplaza con tu imagen, ej: R.drawable.tigre
        ),
        Animal(
            nombre = "Elefante",
            descripcion = "Los elefantes o elefántidos (Elephantidae) son una familia de mamíferos placentarios del orden proboscideos. Antiguamente se clasificaban, junto con otros mamíferos de piel gruesa, en el orden, ahora inválido, de los paquidermos (Pachydermata). Existen hoy en día tres especies y diversas subespecies. Entre los géneros extintos de esta familia destacan los mamuts",
            estadoConservacion = "En peligro de extinción (Reducción)",
            imagen = R.drawable.elefante // Reemplaza con tu imagen, ej: R.drawable.condor
        ),
        Animal(
            nombre = "Jirafa",
            descripcion = "La jirafa (Giraffa camelopardalis) es una especie de mamífero artiodáctilo, de la familia Giraffidae propio de África. Es la más alta de todas las especies de animales terrestres existentes, ya que puede alcanzar una altura máxima de 5,7 m y un peso que varía entre 750 y 1600 kg.",
            estadoConservacion = "Vulnerable (Reducción)",
            imagen = R.drawable.jirafa // Reemplaza con tu imagen, ej: R.drawable.pudu
        )
    )

    /**
     * Función que expone la lista de animales.
     * La devuelve dentro de un Flow, que es la práctica moderna en Android
     * para manejar flujos de datos de manera asíncrona.
     * El ViewModel consumirá este Flow.
     */
    fun getAnimales(): Flow<List<Animal>> {
        return flowOf(listaDeAnimales)
    }
}


