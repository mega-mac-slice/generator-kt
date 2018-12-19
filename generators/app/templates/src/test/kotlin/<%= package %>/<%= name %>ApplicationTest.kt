package <%= package %>

import kotlin.test.Test
import kotlin.test.assertNotNull

class <%= name %>ApplicationTest {
    @Test fun testAppHasName() {
        val classUnderTest = <%= name %>Application()
        assertNotNull(classUnderTest.name, "app should have a name")
    }
}
