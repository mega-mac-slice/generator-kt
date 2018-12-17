package pokegym

import dagger.Component
import pokegym.api.PokegymResource
import javax.inject.Singleton

@Singleton
@Component(modules=[PokegymModule::class])
interface PokegymComponent {
    fun getPokegymResource(): PokegymResource
}