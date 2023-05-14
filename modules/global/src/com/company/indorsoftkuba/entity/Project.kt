package com.company.indorsoftkuba.entity

import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "INDORSOFTKUBA_PROJECT")
@Entity(name = "indorsoftkuba_Project")
open class Project : StandardEntity() {
    @NotNull
    @Column(name = "NAME", nullable = false)
    var name: String? = null

    @JoinTable(
        name = "INDORSOFTKUBA_PROJECT_EMPLOYEE_LINK",
        joinColumns = [JoinColumn(name = "PROJECT_ID")],
        inverseJoinColumns = [JoinColumn(name = "EMPLOYEE_ID")]
    )
    @ManyToMany
    var employees: MutableList<Employee>? = mutableListOf()

    companion object {
        private const val serialVersionUID = -9153985765830696136L
    }
}