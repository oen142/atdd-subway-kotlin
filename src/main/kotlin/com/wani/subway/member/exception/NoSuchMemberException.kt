package com.wani.subway.member.exception

import java.lang.RuntimeException

class NoSuchMemberException(exception: String) : RuntimeException(exception)
