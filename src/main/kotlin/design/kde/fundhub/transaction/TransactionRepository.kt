package design.kde.fundhub.transaction

import org.springframework.data.repository.PagingAndSortingRepository

interface TransactionRepository : PagingAndSortingRepository<Transaction, Long>
