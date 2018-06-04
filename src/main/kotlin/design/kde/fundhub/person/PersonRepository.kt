package design.kde.fundhub.person

import org.springframework.data.repository.PagingAndSortingRepository

interface PersonRepository : PagingAndSortingRepository<Person, Long>