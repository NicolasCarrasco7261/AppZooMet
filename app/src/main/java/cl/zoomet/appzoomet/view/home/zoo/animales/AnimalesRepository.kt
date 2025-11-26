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
            nombre = "Pingüino de Humboldt",
            descripcion = "El pingüino de Humboldt es un ave marina de tamaño mediano que habita las costas de Perú y Chile. Posee un distintivo plumaje blanco y negro con una banda oscura en el pecho. Se alimenta principalmente de peces y crustáceos que captura buceando. Nidifica en grietas rocosas o cuevas naturales. Su supervivencia depende de la estabilidad de la corriente de Humboldt.",
            estadoConservacion = "Vulnerable (Reducción)",
            imagen = R.drawable.pinguino_humboldt
        ),
        Animal(
            nombre = "Hipopótamo",
            descripcion = "El hipopótamo es un mamífero semiacuático de gran tamaño originario del África subsahariana. Pasa la mayor parte del día en ríos y lagos para mantenerse fresco. Posee una piel gruesa y una enorme boca con colmillos que crecen continuamente. Es herbívoro y sale por la noche a pastar. A pesar de su aspecto tranquilo, es muy territorial y puede ser agresivo",
            estadoConservacion = "Vulnerable (Reducción)",
            imagen = R.drawable.hipopotamo
        ),
        Animal(
            nombre = "Zorro culpeo",
            descripcion = "El zorro culpeo es un cánido sudamericano de tamaño mediano, presente desde Ecuador hasta el extremo sur de Chile. Tiene un pelaje gris anaranjado y una cola grande y esponjosa. Se alimenta de roedores, aves, frutas y carroña. Habita bosques, matorrales y zonas cordilleranas. Su adaptabilidad le permite mantenerse en diversas regiones",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.zorro_culpeo
        ),
        Animal(
            nombre = "Mono ardilla",
            descripcion = "El mono ardilla es un primate pequeño y ágil de los bosques tropicales de América del Sur. Posee pelaje amarillo-anaranjado y una cara clara muy característica. Vive en grandes grupos sociales que le brindan protección. Se mueve principalmente en los árboles, donde busca frutas e insectos. Su tamaño reducido le permite desplazarse rápidamente entre las ramas.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.mono_ardilla
        ),
        Animal(
            nombre = "Tití orejas de algodón",
            descripcion = "El tití orejas de algodón es un pequeño primate brasileño, reconocible por los mechones blancos en los costados de su cabeza. Es muy ágil y pasa la mayor parte del tiempo en los árboles. Se alimenta de savia, frutas e insectos. Vive en grupos familiares con una fuerte estructura social. Se adapta bien a zonas modificadas por el ser humano.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.titi_algodon
        ),
        Animal(
            nombre = "Perrito",
            descripcion = "El perro es un mamífero domesticado que desciende del lobo y acompaña al ser humano desde hace miles de años. Presenta gran variedad de razas, tamaños y comportamientos. Es una especie altamente social y adaptable. Su relación con las personas incluye roles de compañía, trabajo y asistencia. Está distribuido en prácticamente todo el mundo.",
            estadoConservacion = "Domesticado",
            imagen = R.drawable.perro
        ),
        Animal(
            nombre = "Mono araña de Geoffroy",
            descripcion = "El mono araña de Geoffroy es un primate arborícola muy ágil que habita los bosques tropicales de Centroamérica. Tiene extremidades largas y una cola prensil usada como quinto brazo. Se alimenta principalmente de frutas y depende de bosques bien conservados. Vive en grupos que se dividen según la disponibilidad de alimento. La deforestación ha reducido significativamente sus poblaciones.",
            estadoConservacion = "En Peligro (Disminución)",
            imagen = R.drawable.mono_arana
        ),
        Animal(
            nombre = "Rosella",
            descripcion = "La rosella es un loro australiano conocido por su vistoso plumaje en tonos rojos, azules, verdes y amarillos. Habita bosques abiertos y zonas rurales. Se alimenta de semillas, frutos e insectos. Es activa y suele desplazarse en parejas o pequeños grupos. Su adaptabilidad ha permitido mantener poblaciones estables en su hábitat natural.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.rosella
        ),
        Animal(
            nombre = "Quique",
            descripcion = "El quique es un pequeño carnívoro sudamericano de cuerpo alargado, patas cortas y pelaje marrón oscuro. Es un depredador ágil que caza roedores, aves y reptiles. Habita bosques, matorrales y áreas abiertas desde Perú hasta el sur de Chile y Argentina. Es solitario y de hábitos principalmente nocturnos. Se adapta bien a distintos ecosistemas, aunque enfrenta amenazas por pérdida de hábitat.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.quique
        ),
        Animal(
            nombre = "Suricata",
            descripcion = "La suricata es un pequeño mamífero social originario del sur de África, conocido por su postura erguida al vigilar. Vive en grandes grupos con roles cooperativos bien definidos. Habita zonas áridas y semidesérticas, donde excava madrigueras extensas. Se alimenta de insectos, pequeños vertebrados y frutos. Su organización social la convierte en una especie muy adaptable.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.suricata
        ),
        Animal(
            nombre = "Caiquén",
            descripcion = "El caiquén es un ganso silvestre de Chile y Argentina, fácilmente reconocible por su plumaje blanco y negro en los machos y más pardo en las hembras. Habita praderas, humedales y zonas costeras del sur austral. Se alimenta principalmente de pastos y hierbas. Forma grupos familiares y migraciones cortas según la disponibilidad de alimento. Su población es estable en la mayor parte de su rango.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.caiquen
        ),
        Animal(
            nombre = "Pudú",
            descripcion = "El pudú es el ciervo más pequeño del mundo y habita los bosques templados de Chile y Argentina. Posee un cuerpo compacto, patas cortas y un pelaje marrón que lo ayuda a camuflarse. Es solitario y muy tímido, alimentándose de hojas, brotes y frutos. Prefiere zonas densas donde puede ocultarse fácilmente. La pérdida de hábitat y los perros asilvestrados amenazan sus poblaciones.",
            estadoConservacion = "Vulnerable (Disminución)",
            imagen = R.drawable.pudu
        ),
        Animal(
            nombre = "Flamenco chileno",
            descripcion = "El flamenco chileno es un ave zancuda de plumaje rosado pálido y patas largas, presente en humedales de Chile, Argentina, Perú y Bolivia. Se alimenta filtrando pequeños crustáceos y algas con su pico curvado. Vive en grandes colonias que dependen de lagunas salinas. Es muy sensible a cambios en el nivel del agua. La disminución de humedales afecta directamente a sus poblaciones.",
            estadoConservacion = "Casi Amenazado (Disminución)",
            imagen = R.drawable.flamenco
        ),
        Animal(
            nombre = "Lémur rufo",
            descripcion = "El lémur rufo es un primate endémico de Madagascar, reconocido por su pelaje espeso blanco y negro y su fuerte vocalización. Vive en bosques tropicales húmedos donde se alimenta principalmente de frutas. Es social y se agrupa en comunidades pequeñas. Su supervivencia depende de bosques bien conservados. La deforestación ha reducido drásticamente sus poblaciones.",
            estadoConservacion = "En Peligro Crítico (Disminución)",
            imagen = R.drawable.lemur_rufo
        ),
        Animal(
            nombre = "Ocelote",
            descripcion = "El ocelote es un felino de tamaño mediano distribuido desde México hasta Argentina. Su pelaje manchado le permite camuflarse en bosques densos y selvas tropicales. Es un cazador nocturno que consume roedores, aves y pequeños vertebrados. Prefiere zonas con vegetación densa para acechar a sus presas. Aunque relativamente común, enfrenta amenazas por pérdida de hábitat y tráfico ilegal.",
            estadoConservacion = "Preocupación Menor (Disminución)",
            imagen = R.drawable.ocelote
        ),
        Animal(
            nombre = "Puerco espín",
            descripcion = "El puerco espín es un roedor grande cubierto de púas modificadas que utiliza como defensa ante depredadores. Hábita bosques, matorrales y áreas rocosas según la especie. Es de hábitos nocturnos y se alimenta de corteza, hojas y frutos. Trepa árboles con facilidad en algunas especies. Su apariencia espinosa es su principal mecanismo de protección.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.puerco_espin
        ),
        Animal(
            nombre = "Papíon sagrado",
            descripcion = "El papión sagrado es un babuino originario del noreste de África y la península arábiga. Los machos presentan una melena gris plateada muy característica. Vive en grandes grupos organizados en harenes y clanes. Se alimenta de hierbas, frutos e insectos. Es una especie muy adaptable a zonas áridas y montañosas.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.papion_sagrado
        ),
        Animal(
            nombre = "Chimpancé",
            descripcion = "El chimpancé es uno de los primates más inteligentes, nativo de las selvas y sabanas de África central. Vive en comunidades complejas con fuertes vínculos sociales. Utiliza herramientas para obtener alimento, como piedras o ramas. Se alimenta de frutas, hojas e insectos, e incluso realiza caza ocasional. La deforestación y la caza ilegal han reducido significativamente sus poblaciones.",
            estadoConservacion = "En Peligro (Disminución)",
            imagen = R.drawable.chimpance
        ),
        Animal(
            nombre = "Canguro",
            descripcion = "El canguro es un marsupial australiano conocido por su poderoso salto y su bolsa ventral para cargar a las crías. Habita praderas, bosques abiertos y zonas áridas según la especie. Se alimenta principalmente de pastos y brotes. Vive en grupos llamados “mobs”, que ofrecen protección y vigilancia. Su gran movilidad le permite recorrer largas distancias en busca de alimento.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.canguro
        ),
        Animal(
            nombre = "Vicuña",
            descripcion = "La vicuña es un camélido sudamericano que habita las zonas altoandinas de Perú, Chile, Bolivia y Argentina. Posee un pelaje fino y dorado que es altamente valorado. Vive en grupos familiares en pastizales de gran altitud. Se alimenta de hierbas duras adaptadas al clima seco. Su población se ha recuperado gracias a programas de conservación.",
            estadoConservacion = "Preocupación Menor (Aumento)",
            imagen = R.drawable.vicuna
        ),
        Animal(
            nombre = "Oso pardo",
            descripcion = "El oso pardo es un gran mamífero carnívoro distribuido por Eurasia y Norteamérica. Tiene un potente cuerpo, garras fuertes y un pelaje grueso de color variable. Es omnívoro y consume frutos, raíces, peces y pequeños animales. Puede recorrer grandes distancias en busca de alimento. Sus poblaciones varían según la región y la presión humana.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.oso_pardo
        ),
        Animal(
            nombre = "Cóndor",
            descripcion = "El cóndor andino es una de las aves voladoras más grandes del mundo, con una gran envergadura alar. Habita cordilleras y acantilados de Sudamérica. Se alimenta principalmente de carroña, cumpliendo un rol ecológico clave. Es de vuelo planeado, aprovechando corrientes térmicas. Su población está afectada por envenenamientos y pérdida de hábitat.",
            estadoConservacion = "Casi Amenazado (Disminución)",
            imagen = R.drawable.condor
        ),
        Animal(
            nombre = "Emú",
            descripcion = "El emú es la segunda ave más grande del mundo y es nativa de Australia. No vuela, pero corre a gran velocidad gracias a sus largas patas. Se alimenta de semillas, frutos e insectos. Vive en praderas abiertas, sabanas y zonas secas del continente australiano. Es una especie adaptable y común en su hábitat natural.",
            estadoConservacion = "Preocupación Menor (Estable) ",
            imagen = R.drawable.emu
        ),
        Animal(
            nombre = "Ñandú",
            descripcion = "El ñandú es un ave corredora sudamericana que habita praderas, estepas y pampas. Tiene cuerpo grande, patas largas y no puede volar. Se alimenta de plantas, semillas e insectos. Forma grupos que se desplazan por grandes áreas abiertas. Algunas poblaciones están afectadas por la fragmentación del hábitat",
            estadoConservacion = "Casi Amenazado.",
            imagen = R.drawable.nandu
        ),
        Animal(
            nombre = "Cebra",
            descripcion = "La cebra es un equino africano conocido por su característico patrón de rayas blancas y negras. Habita sabanas, praderas y zonas secas. Es herbívora y se alimenta de pastos y hojas. Vive en grupos sociales que ofrecen protección contra depredadores. Sus poblaciones varían según la especie y región.",
            estadoConservacion = "Preocupación Menor (Disminución)",
            imagen = R.drawable.cebra
        ),
        Animal(
            nombre = "Gallineta",
            descripcion = "La gallineta es un ave acuática pequeña que habita lagunas, ríos y humedales. Tiene plumaje oscuro con detalles rojos y amarillos en el pico. Nada y bucea con facilidad, buscando insectos, plantas y pequeños invertebrados. Construye nidos flotantes entre la vegetación. Es común en gran parte del mundo.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.gallineta
        ),
        Animal(
            nombre = "Bongo",
            descripcion = "El bongo es un antílope africano de bosque, reconocido por su pelaje rojizo con franjas blancas verticales. Es uno de los antílopes más grandes y tiene cuernos en espiral. Es tímido y se mueve entre vegetación densa. Se alimenta de hojas, frutos y hierbas. Sus poblaciones han disminuido por caza y pérdida de hábitat.",
            estadoConservacion = "Casi Amenazado (Disminución)",
            imagen = R.drawable.bongo
        ),
        Animal(
            nombre = "Zorro chilla",
            descripcion = "El zorro chilla es un cánido sudamericano presente en Chile, Argentina y Perú. Posee pelaje gris, orejas grandes y una cola esponjosa. Es un oportunista que se alimenta de roedores, aves, frutas e insectos. Habita zonas abiertas, matorrales y áreas rurales. Es común y adaptable en gran parte de su rango.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.zorro_chilla
        ),
        Animal(
            nombre = "Cisne",
            descripcion = "El cisne es un ave acuática grande y elegante, reconocible por su largo cuello y su comportamiento sereno. Habita lagos, lagunas y humedales. Se alimenta de plantas acuáticas e invertebrados. Forma parejas monógamas de larga duración. Su estado depende de la especie, aunque muchos están en buen estado de conservación.",
            estadoConservacion = "Generalmente Preocupación Menor",
            imagen = R.drawable.cisne
        ),
        Animal(
            nombre = "Ranita de Darwin",
            descripcion = "La ranita de Darwin es un anfibio chileno único por su hocico puntiagudo y su camuflaje en tonos café y verde. Habita bosques húmedos del sur de Chile. Los machos incuban los renacuajos en una bolsa vocal, un comportamiento excepcional. Es muy sensible a cambios ambientales. La pérdida de hábitat ha afectado gravemente a su población.",
            estadoConservacion = "En Peligro (Disminución)",
            imagen = R.drawable.rana_darwin
        ),
        Animal(
            nombre = "Loro",
            descripcion = "Los loros son aves de colores brillantes que habitan regiones tropicales y subtropicales del mundo. Poseen un pico curvado fuerte y gran capacidad para imitar sonidos. Se alimentan de semillas, frutos y flores. Viven en grupos sociales y muestran gran inteligencia. Algunas especies están amenazadas por pérdida de hábitat y tráfico ilegal.",
            estadoConservacion = "Variable según especie (Preocupación Menor)",
            imagen = R.drawable.loro
        ),
        Animal(
            nombre = "Lobo marino",
            descripcion = "El lobo marino común habita las costas de Sudamérica y forma grandes colonias en playas y rocas. Los machos son mucho más grandes que las hembras y poseen una melena característica. Se alimenta de peces y cefalópodos. Son excelentes nadadores y pasan gran parte del tiempo en el agua. Sus poblaciones son actualmente abundantes y estables.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.lobo_marino
        ),
        Animal(
            nombre = "Gibón",
            descripcion = "Los gibones son primates arborícolas del sudeste asiático, conocidos por su habilidad de balancearse rápidamente entre los árboles. Poseen brazos muy largos y cuerpos ligeros. Viven en parejas o grupos familiares pequeños. Su dieta se basa en frutas y hojas. La deforestación ha afectado severamente a varias de sus especies.",
            estadoConservacion = "Amenazado (Peligro Crítico)",
            imagen = R.drawable.gibon
        ),
        Animal(
            nombre = "Panda rojo",
            descripcion = "El panda rojo es un mamífero arborícola del Himalaya y China, con pelaje rojizo y larga cola anillada. Vive en bosques templados y bambuzales de montaña. Se alimenta principalmente de brotes de bambú, frutos y pequeños invertebrados. Es solitario y de hábitos crepusculares. La pérdida de hábitat ha reducido sus poblaciones.",
            estadoConservacion = "En Peligro (Disminución)",
            imagen = R.drawable.panda_rojo
        ),
        Animal(
            nombre = "Puma",
            descripcion = "El puma es un gran felino distribuido desde Canadá hasta el sur de Chile y Argentina. Tiene cuerpo ágil, patas fuertes y pelaje uniforme. Es un cazador solitario que se alimenta de ciervos y otros vertebrados. Se adapta a bosques, montañas y desiertos. Sus poblaciones varían según presión humana y disponibilidad de presas.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.puma
        ),
        Animal(
            nombre = "Jaguar",
            descripcion = "El jaguar es el felino más grande de América y habita selvas tropicales y bosques densos. Tiene un pelaje dorado con rosetas negras distintivas. Es un depredador poderoso que caza peces, venados y otros animales. Depende de ecosistemas bien conservados. La deforestación y la caza ilegal han reducido sus poblaciones.",
            estadoConservacion = "Casi Amenazado (Disminución)",
            imagen = R.drawable.jaguar
        ),
        Animal(
            nombre = "León",
            descripcion = "El león es un gran felino africano conocido por vivir en grupos llamados manadas. Los machos poseen una melena característica. Habita sabanas y praderas abiertas donde caza grandes herbívoros. Su comportamiento social es único entre los felinos. La pérdida de hábitat y conflictos con humanos afectan su número.",
            estadoConservacion = "Vulnerable (Disminución)",
            imagen = R.drawable.leon
        ),
        Animal(
            nombre = "Gato colocolo",
            descripcion = "El gato colocolo es un felino sudamericano de tamaño pequeño a mediano con pelaje gris amarillento y rayas difusas. Habita zonas áridas, bosques y matorrales. Es un cazador solitario de pequeños vertebrados. Su distribución es amplia, pero fragmentada. Enfrenta amenazas por pérdida de hábitat.",
            estadoConservacion = "Casi Amenazado (Disminución) ",
            imagen = R.drawable.gato_colocolo
        ),
        Animal(
            nombre = "Serval",
            descripcion = "El serval es un felino africano de patas largas y pelaje amarillo con manchas negras. Es un cazador especializado que atrapa roedores y aves mediante saltos precisos. Habita sabanas y áreas húmedas con vegetación alta. Es solitario y de hábitos crepusculares. Aunque común en algunas zonas, la pérdida de humedales afecta a ciertas poblaciones.",
            estadoConservacion = "Preocupación Menor (Disminución)",
            imagen = R.drawable.serval
        ),
        Animal(
            nombre = "Caracal",
            descripcion = "El caracal es un felino africano y asiático reconocido por sus orejas puntiagudas con largos mechones negros. Es muy ágil y puede saltar para atrapar aves en pleno vuelo. Vive en sabanas, semidesiertos y zonas rocosas. Es solitario y territorial. La especie es adaptable, pero enfrenta caza en algunas regiones.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.caracal
        ),
        Animal(
            nombre = "Lémur cola anillada",
            descripcion = "El lémur cola anillada es un primate de Madagascar famoso por su cola con anillos blancos y negros. Vive en grupos sociales numerosos. Habita bosques secos y matorrales. Se alimenta de frutas, hojas y pequeños invertebrados. La deforestación y la caza han disminuido sus poblaciones.",
            estadoConservacion = "En Peligro (Disminución)",
            imagen = R.drawable.lemur_cola_anillada
        ),
        Animal(
            nombre = "Tigre de Bengala",
            descripcion = "El tigre de Bengala es una de las mayores subespecies de tigre y habita India, Nepal y Bangladesh. Tiene un pelaje anaranjado con rayas negras muy distintivas. Es un cazador solitario que depende de grandes territorios. Vive en bosques, manglares y praderas. La caza ilegal y la pérdida de hábitat amenazan su supervivencia.",
            estadoConservacion = "En Peligro (Aumento lento)",
            imagen = R.drawable.tigrebengala
        ),
        Animal(
            nombre = "Camello",
            descripcion = "El camello es un mamífero adaptado a ambientes desérticos, con la capacidad de resistir largas temporadas sin agua. Posee una o dos jorobas según la especie. Se alimenta de hierbas resistentes y plantas espinosas. Ha sido domesticado por miles de años como animal de carga. Las especies salvajes se encuentran muy amenazadas.",
            estadoConservacion = "En Peligro Crítico",
            imagen = R.drawable.camello
        ),
        Animal(
            nombre = "Guanaco",
            descripcion = "El guanaco es un camélido sudamericano que habita zonas áridas, estepas y cordilleras. Tiene pelaje café claro y es muy ágil para recorrer terrenos difíciles. Vive en manadas que se desplazan en busca de pastos. Es un animal resistente a climas extremos. Sus poblaciones son estables en la mayoría de su distribución.",
            estadoConservacion = "Preocupación Menor (Estable)",
            imagen = R.drawable.guanaco
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


