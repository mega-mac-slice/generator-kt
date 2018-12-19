package <%= package %>

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class <%= name %>Application : Application<<%= name %>Configuration>() {

    override fun getName(): String {
        return "<%= package %>"
    }


    override fun initialize(bootstrap: Bootstrap<<%= name %>Configuration>?) {
        // nothing to do yet
    }

    override fun run(configuration: <%= name %>Configuration, environment: Environment) {
        val component = Dagger<%= name %>Component.builder()
                .<%= package %>Module(<%= name %>Module(configuration))
                .build()

        environment.jersey().register(component.get<%= name %>Resource())
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            <%= name %>Application().run(*args)
        }
    }
}
