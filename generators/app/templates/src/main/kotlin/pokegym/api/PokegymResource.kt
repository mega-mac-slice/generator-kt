package pokegym.api

import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path

@Singleton
@Path("/api")
class PokegymResource @Inject constructor() {
    @GET
    @Path("hello")
    fun hello() : String {
        return "hello"
    }
}