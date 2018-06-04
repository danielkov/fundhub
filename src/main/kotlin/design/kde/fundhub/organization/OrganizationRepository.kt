package design.kde.fundhub.organization

import org.springframework.data.repository.PagingAndSortingRepository

interface OrganizationRepository : PagingAndSortingRepository<Organization, Long>
