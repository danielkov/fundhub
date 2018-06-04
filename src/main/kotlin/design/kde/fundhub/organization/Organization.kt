package design.kde.fundhub.organization

import design.kde.fundhub.person.Person
import javax.persistence.*

@Entity
data class Organization(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val name: String,
        val abbreviation: String,
        @ManyToOne
        @JoinColumn(name="organization_owner", nullable = false)
        val owner: Person,
        @ManyToMany(cascade = [(CascadeType.ALL)])
        @JoinTable(
                name = "organization_members",
                joinColumns = [(JoinColumn(name = "organization_id"))],
                inverseJoinColumns = [(JoinColumn(name = "person_id"))]
        )
        val members: List<Person>
)
