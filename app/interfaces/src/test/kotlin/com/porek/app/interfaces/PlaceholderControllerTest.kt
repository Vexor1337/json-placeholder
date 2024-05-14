import arrow.core.right
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import kotlin.io.path.ExperimentalPathApi

@ExperimentalPathApi
class PlaceholderControllerTest {

    @Test
    fun `test getAllPostsAndSaveToSeparateFiles`() {
        // Mock PlaceholderService
        val placeholderService = mockk<PlaceholderService>()
        val posts = listOf(
            PlaceholderPostProjection(1, 1, "Title 1", "Body 1"),
            PlaceholderPostProjection(2, 2, "Title 2", "Body 1")
        )
        every { placeholderService.getAllServicesAndSave() } returns posts.right()

        // Initialize controller with mocked service
        val controller = PlaceholderController(placeholderService)

        // Invoke controller method
        val response = controller.getAllPostsAndSaveToSeparateFiles()

        // Assertions
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(posts, response.body!!.data)
    }
}