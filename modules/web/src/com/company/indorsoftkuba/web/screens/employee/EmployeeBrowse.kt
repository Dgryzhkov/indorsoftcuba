package com.company.indorsoftkuba.web.screens.employee

import com.haulmont.cuba.gui.screen.*
import com.company.indorsoftkuba.entity.Employee

@UiController("indorsoftkuba_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
class EmployeeBrowse : StandardLookup<Employee>()