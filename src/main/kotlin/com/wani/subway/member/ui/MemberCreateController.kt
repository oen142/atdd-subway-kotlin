package com.wani.subway.member.ui

import com.wani.subway.member.application.MemberCreateService
import com.wani.subway.member.application.MemberFindService
import com.wani.subway.member.dto.response.MemberCreateRequest
import com.wani.subway.member.dto.response.MemberCreateResponse
import com.wani.subway.member.dto.response.MemberFindResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class MemberCreateController(
    val memberCreateService: MemberCreateService,
    val memberFindService: MemberFindService
) {


    @PostMapping("/members")
    fun createMember(@RequestBody request: MemberCreateRequest): ResponseEntity<MemberCreateResponse> {
        val response = memberCreateService.createMember(request)

        return ResponseEntity.created(URI.create("/members/${response.id}")).build()
    }

    @GetMapping("/members/{id}")
    fun findMember(@PathVariable id: Long): ResponseEntity<MemberFindResponse> {
        val response = memberFindService.findMember(id)

        return ResponseEntity.ok().body(response)
    }

}