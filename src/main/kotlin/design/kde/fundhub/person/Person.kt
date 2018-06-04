package design.kde.fundhub.person

import design.kde.fundhub.organization.Organization
import design.kde.fundhub.transaction.Transaction
import javax.persistence.*

@Entity
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        val username: String = "",
        val email: String = "",
        @OneToMany(mappedBy = "issuer")
        val issuedTransactions: List<Transaction>,
        @OneToMany(mappedBy = "recipient")
        val receivedTransactions: List<Transaction>,
        @OneToMany(mappedBy = "owner")
        val ownedOrganizations: List<Organization>,
        @ManyToMany(mappedBy = "members")
        val memberOrganizations: List<Organization>
)
