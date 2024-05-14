import arrow.core.getOrElse
import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PostsRepositoryAdapterTest {

    @Test
    fun `test saveAllPosts`() {
        // Mock ObjectMapper
        val mapper = mockk<ObjectMapper>()

        // Mock ObjectMapper behavior
        every { mapper.writeValueAsString(any()) } returns "{}"

        // Initialize repository with mocked ObjectMapper
        val repository = PostsRepositoryAdapter()

        // Create sample data
        val postsList = listOf(
            PlaceholderPostDto(1, 1, "Title 1", "Body 1"),
            PlaceholderPostDto(2, 2, "Title 2", "Body 1")
        )

        // Invoke repository method
        val result = repository.saveAllPosts(postsList)

        // Assertions
        assertEquals(postsList, result.getOrElse { emptyList() })
    }
}