package design.kde.fundhub.transaction

import design.kde.fundhub.currency.Currency
import design.kde.fundhub.person.Person
import javax.persistence.*

@Entity
data class Transaction(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        @ManyToOne
        @JoinColumn(name="transaction_issuer", nullable = false)
        val issuer: Person,
        @ManyToOne
        @JoinColumn(name="transaction_recipient", nullable = false)
        val recipient: Person,
        val amount: Long,
        @ManyToOne
        @JoinColumn(name="transaction_currency", nullable = false)
        val currency: Currency,
        val refunded: Boolean = false,
        val paid: Boolean = false
)
