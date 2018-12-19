package <%= package %>

import dagger.Module

@Module
class <%= name %>Module(
        private val configuration: <%= name %>Configuration
)
