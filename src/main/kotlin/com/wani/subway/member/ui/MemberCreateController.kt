package com.wani.subway.member.ui

import com.wani.subway.member.application.MemberCreateService
import com.wani.subway.member.dto.response.MemberCreateRequest
import com.wani.subway.member.dto.response.MemberCreateResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class MemberCreateController(
    val memberCreateService: MemberCreateService
) {


    @PostMapping("/members")
    fun createMember(@RequestBody request: MemberCreateRequest): ResponseEntity<MemberCreateResponse> {
        val response = memberCreateService.createMember(request)

        return ResponseEntity.created(URI.create("/members/${response.id}")).build()
    }
}