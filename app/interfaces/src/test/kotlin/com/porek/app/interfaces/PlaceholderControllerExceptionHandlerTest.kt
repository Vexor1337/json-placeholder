package com.porek.app.interfaces

import com.porek.app.commons.PageNotFoundError
import com.porek.app.commons.PlaceholderGenericException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus

class PlaceholderControllerExceptionHandlerTest {

    @Mock
    private lateinit var exception: PlaceholderEitherException

    private val handler = PlaceholderControllerExceptionHandler()

    init {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test handleRuntimeException PlaceholderGenericException`() {
        // Mock exception behavior
        val errorMessage = "Generic exception"
        `when`(exception.eitherError).thenReturn(PlaceholderGenericException(errorMessage))

        // Invoke handler method
        val response = handler.handleRuntimeException(exception)

        // Assertions
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertEquals(errorMessage, response.body?.message)
    }

    @Test
    fun `test handleRuntimeException PageNotFoundError`() {
        // Mock exception behavior
        val errorMessage = "Page not found"
        `when`(exception.eitherError).thenReturn(PageNotFoundError())

        // Invoke handler method
        val response = handler.handleRuntimeException(exception)

        // Assertions
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertEquals(errorMessage, response.body?.message)
    }


}