package com.porek.app.interfaces

import com.porek.app.commons.web.Response
import com.porek.app.commons.web.toResponse
import com.porek.ports.input.projection.PlaceholderPostProjection
import com.porek.ports.input.service.PlaceholderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/placeholder")
class PlaceholderController(private val placeholderService: PlaceholderService) {
    @GetMapping("getAllPostsAndSaveToSeparateFiles")
    fun getAllPostsAndSaveToSeparateFiles(): Response<List<PlaceholderPostProjection>> =
        placeholderService.getAllServicesAndSave().fold({ throw it.toException() }, { it.toResponse() })
}