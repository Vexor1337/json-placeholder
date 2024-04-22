package com.porek.app.application

import com.porek.ports.input.projection.PlaceholderPostProjection
import com.porek.ports.output.persistance.PlaceholderPostDto
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface PlaceholderMapper{
    fun postDtoToProjection(placeholderPostDto: PlaceholderPostDto) : PlaceholderPostProjection
}
private val mapperInst = Mappers.getMapper(PlaceholderMapper::class.java)
fun PlaceholderPostDto.toProjection(): PlaceholderPostProjection = mapperInst.postDtoToProjection(this)