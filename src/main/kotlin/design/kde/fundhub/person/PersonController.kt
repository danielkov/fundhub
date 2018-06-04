package design.kde.fundhub.person

import design.kde.fundhub.common.Response
import design.kde.fundhub.common.respond
import design.kde.fundhub.common.success
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/person")
class PersonController(val repository: PersonRepository) {
    @GetMapping("")
    fun findAll(): Response<MutableIterable<Person>> = success(repository.findAll()).logs("person list")

    @PostMapping("/find")
    fun find(@RequestBody page: Pageable): Response<MutableIterable<Person>> = success(repository.findAll(page)).logs("person list")

    @PostMapping("")
    fun create(@RequestBody person: Person): Response<Person> = success(repository.save(person)).logs("person")

    @GetMapping("{id}")
    fun findOne(@RequestParam("id") id: Long): Response<Person> = respond(repository.findById(id)).logs("person")

    @PutMapping("")
    fun update(@RequestBody person: Person): Response<Person> = success(repository.save(person)).logs("person")

    @DeleteMapping("{id}")
    fun delete(@RequestParam("id") id: Long): Response<Unit> = success(repository.deleteById(id)).logs("person")
}