package v_builders

import org.junit.Assert.assertTrue
import org.junit.Test

class N39HtmlBuildersKtTest {
    @Test fun productTableIsFilled() {
        val result = renderProductTable()
        assertTrue("Product table should contain corresponding data", result.contains("cactus"))
    }

    @Test fun productTableIsColored() {
        val result = renderProductTable()
        assertTrue("Product table should be colored", result.contains("bgcolor"))
    }

    @Test fun productTableIsColoredAlternatively() {
        val result = renderProductTable()
        val colors : Map<String, List<String>> =
        result.split("bgcolor")
        .filter { it.contains("#") }
        .map {
            it.substringAfter("#").substring(0, 6)
        }.groupBy { it }

        assertTrue("Product table cell should alternate colors", colors["dce4ff"]!!.size == colors["eff2ff"]!!.size)
    }
}
