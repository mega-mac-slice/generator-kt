package <%= package %>

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class <%= name %>Module(
        private val configuration: <%= name %>Configuration
) {
    @Provides
    @Singleton
    fun getConfiguration(): <%= name %>Configuration {
        return configuration
    }
}
