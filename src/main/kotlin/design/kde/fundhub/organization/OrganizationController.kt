package design.kde.fundhub.organization

import design.kde.fundhub.common.Response
import design.kde.fundhub.common.respond
import design.kde.fundhub.common.success
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/organization")
class OrganizationController(val repository: OrganizationRepository) {
    @GetMapping("")
    fun findAll(): Response<MutableIterable<Organization>> = success(repository.findAll()).logs("organization list")

    @PostMapping("/find")
    fun find(@RequestBody page: Pageable): Response<MutableIterable<Organization>> = success(repository.findAll(page)).logs("organization list")

    @PostMapping("")
    fun create(@RequestBody organization: Organization): Response<Organization> = success(repository.save(organization)).logs("organization")

    @GetMapping("{id}")
    fun findOne(@RequestParam("id") id: Long): Response<Organization> = respond(repository.findById(id)).logs("organization")

    @PutMapping("")
    fun update(@RequestBody organization: Organization): Response<Organization> = success(repository.save(organization)).logs("organization")

    @DeleteMapping("{id}")
    fun delete(@RequestParam("id") id: Long): Response<Unit> = success(repository.deleteById(id)).logs("organization")
}