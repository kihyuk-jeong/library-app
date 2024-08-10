package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JavaUserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @Test
    fun saveUserTest() {

        val request = UserCreateRequest("정기혁", null)

        userService.saveUser(request)

        val results = userRepository.findAll()
        assertThat(results).hasSize(1)
    }


}