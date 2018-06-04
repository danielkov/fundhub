package design.kde.fundhub.person

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import org.springframework.transaction.annotation.Transactional

val singlePersonJSON = """{
    "username": "test",
    "email": "test@test.com"
}""".trimIndent()

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerIntTest() {

    lateinit private var mockMvc: MockMvc

    var contentType = "application/json;charset=UTF-8"

    @Mock
    private lateinit var repository: PersonRepository

    @Before
    fun setup() {
        mockMvc = standaloneSetup(PersonController(repository)).build()
    }

    @Test
    fun testFindAll_whenEmpty() {
        mockMvc.perform(get("/api/person"))
                .andDo({ print(it)})
                .andExpect {
                    status().isOk
                    content().contentType(contentType)
                    jsonPath("$.message").value("success")
                    jsonPath("$.error").value("")
                    jsonPath("$.data").isEmpty
                }
    }

    @Test
    @Transactional
    fun testCreate_shouldSucceed() {
        mockMvc.perform(post("/api/person").contentType(contentType).content(singlePersonJSON))
                .andDo({ print(it) })
                .andExpect {
                    status().isOk
                    content().contentType(contentType)
                    jsonPath("$.message").value("success")
                    jsonPath("$.error").value("")
                    jsonPath("$.data.username").value("test")
                    jsonPath("$.data.email").value("test@test.com")
                    jsonPath("$.data.id").value(1)
                }
    }
}