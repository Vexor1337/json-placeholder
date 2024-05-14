import arrow.core.getOrElse
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlaceholderApiClientAdapterTest {

    @Test
    fun `test getAllPosts`() {
        // Mock PlaceholderFeignClient
        val placeholderFeignClient = mockk<PlaceholderFeignClient>()

        // Mock PlaceholderFeignClient behavior
        every { placeholderFeignClient.getAllPosts() } returns listOf(
            PlaceholderPostDto(1, 1, "Title 1", "Body 1"),
            PlaceholderPostDto(2, 2, "Title 2", "Body 1")
        )

        // Initialize adapter with mocked FeignClient
        val adapter = PlaceholderApiClientAdapter(placeholderFeignClient)

        // Invoke adapter method
        val result = adapter.getAllPosts()

        // Assertions
        assertEquals(2, result.getOrElse { emptyList() }.size)
    }
}
