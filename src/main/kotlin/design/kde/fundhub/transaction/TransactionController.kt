package design.kde.fundhub.transaction

import design.kde.fundhub.common.Response
import design.kde.fundhub.common.success
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transaction")
class TransactionController(val repository: TransactionRepository) {
    @GetMapping("")
    fun findAll(): Response<MutableIterable<Transaction>> = success(repository.findAll()).logs("transaction list")

    @PostMapping("")
    fun create(@RequestBody transaction: Transaction): Response<Transaction> = success(repository.save(transaction)).logs("transaction")

    @PostMapping("bulk")
    fun bulkCreate(@RequestBody transactionList: List<Transaction>): Response<MutableIterable<Transaction>> = success(repository.saveAll(transactionList)).logs("transaction list")

    @PostMapping("find")
    fun find(@RequestBody pageable: Pageable): Response<MutableIterable<Transaction>> = success(repository.findAll(pageable))
}