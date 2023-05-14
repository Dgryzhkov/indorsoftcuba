package com.company.indorsoftkuba.entity

import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import javax.persistence.*
import javax.validation.constraints.NotNull
@NamePattern(value = "%s|fullName")
@Table(name = "INDORSOFTKUBA_EMPLOYEE")
@Entity(name = "indorsoftkuba_Employee")
open class Employee : StandardEntity() {


    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    var fullName: String? = null

    @JoinTable(
        name = "INDORSOFTKUBA_PROJECT_EMPLOYEE_LINK",
        joinColumns = [JoinColumn(name = "EMPLOYEE_ID")],
        inverseJoinColumns = [JoinColumn(name = "PROJECT_ID")]
    )
    @ManyToMany
    var projects: MutableList<Project>? = mutableListOf()

    companion object {
        private const val serialVersionUID = -5710966858884024006L
    }
}