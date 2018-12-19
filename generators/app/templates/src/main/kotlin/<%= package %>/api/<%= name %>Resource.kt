package <%= package %>.api

import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path

@Singleton
@Path("/api")
class <%= name %>Resource @Inject constructor() {
    @GET
    @Path("hello")
    fun hello() : String {
        return "hello"
    }
}