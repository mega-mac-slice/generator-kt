package pokegym

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class PokegymApplication : Application<PokegymConfiguration>() {

    override fun getName(): String {
        return "pokegym"
    }


    override fun initialize(bootstrap: Bootstrap<PokegymConfiguration>?) {
        // nothing to do yet
    }

    override fun run(configuration: PokegymConfiguration, environment: Environment) {
        val component = DaggerPokegymComponent.builder()
                .pokegymModule(PokegymModule(configuration))
                .build()

        environment.jersey().register(component.getPokegymResource())
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            PokegymApplication().run(*args)
        }
    }
}
