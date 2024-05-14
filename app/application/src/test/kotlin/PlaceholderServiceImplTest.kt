import arrow.core.getOrElse
import arrow.core.right
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlaceholderServiceImplTest {

    @Test
    fun `test getAllServicesAndSave`() {
        // Mock PlaceholderApiClient
        val placeholderApiClient = mockk<PlaceholderApiClient>()
        every { placeholderApiClient.getAllPosts() } returns listOf(
            PlaceholderPostDto(1, 1, "Title 1", "Body 1"),
            PlaceholderPostDto(2, 2, "Title 2", "Body 1")
        ).right()

        // Mock PostsRepository
        val postsRepository = mockk<PostsRepository>()
        every { postsRepository.saveAllPosts(any()) } returns listOf(
            PlaceholderPostDto(1, 1, "Title 1", "Body 1"),
            PlaceholderPostDto(2, 2, "Title 2", "Body 1")
        ).right()

        // Initialize service with mocked dependencies
        val service = PlaceholderServiceImpl(placeholderApiClient, postsRepository)

        // Invoke service method
        val result = service.getAllServicesAndSave()

        // Assertions
        assertEquals(2, result.getOrElse { emptyList() }.size)
    }

}