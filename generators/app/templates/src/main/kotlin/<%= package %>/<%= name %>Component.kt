package <%= package %>

import dagger.Component
import <%= package %>.api.<%= name %>Resource
import javax.inject.Singleton

@Singleton
@Component(modules=[<%= name %>Module::class])
interface <%= name %>Component {
    fun get<%= name %>Resource(): <%= name %>Resource
}
