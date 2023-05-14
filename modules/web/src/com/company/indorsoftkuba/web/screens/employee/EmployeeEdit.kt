package com.company.indorsoftkuba.web.screens.employee

import com.haulmont.cuba.gui.screen.*
import com.company.indorsoftkuba.entity.Employee

@UiController("indorsoftkuba_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
class EmployeeEdit : StandardEditor<Employee>()