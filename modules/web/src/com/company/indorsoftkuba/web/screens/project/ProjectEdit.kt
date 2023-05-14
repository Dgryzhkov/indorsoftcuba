package com.company.indorsoftkuba.web.screens.project

import com.company.indorsoftkuba.entity.Employee
import com.company.indorsoftkuba.entity.Project
import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.Events.HIGHEST_PLATFORM_PRECEDENCE
import com.haulmont.cuba.gui.UiComponents
import com.haulmont.cuba.gui.components.*
import com.haulmont.cuba.gui.model.CollectionPropertyContainer
import com.haulmont.cuba.gui.model.InstanceContainer
import com.haulmont.cuba.gui.screen.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import java.util.*
import javax.inject.Inject


@UiController("indorsoftkuba_Project.edit")
@UiDescriptor("project-edit.xml")
@EditedEntityContainer("projectDc")
@LoadDataBeforeShow
@Order(HIGHEST_PLATFORM_PRECEDENCE - 10)
class ProjectEdit : StandardEditor<Project>() {

    @Autowired
    private lateinit var employeesDc: CollectionPropertyContainer<Employee>

    @Inject
    private lateinit var uiComponents: UiComponents

    @Inject
    private lateinit var employeesTable: GroupTable<Employee>

    @Inject
    private lateinit var projectDc: InstanceContainer<Project>

    @Inject
    private lateinit var dataManager: DataManager

    @Subscribe
    private fun onBeforeCommitChanges(event: BeforeCommitChangesEvent) {
    }

    @Subscribe("employeesTable.checkBoxRendererColumn")
    fun onEmployeesTableCheckBoxRendererColumnClick(event: Table.Column.ClickEvent<Employee>) {
        val selectedEmployees = employeesTable.selected.map { employeesDc.getItem(it.id) }
        if (selectedEmployees.isNotEmpty()) {
            val project = dataManager.load(Project::class.java).id(event.item.id as UUID).one()
            val employees = project.employees?.toMutableList()
            for (employee in selectedEmployees) {
                if (employees != null) {
                    if (!employees.contains(employee)) { // проверяем, есть ли уже сотрудник в списке проекта
                        employees.addAll(selectedEmployees)
                    }
                }
            }
            project.employees = employees
            projectDc.setItem(project)
        }
    }

    @Subscribe("windowCommit")
    fun onWindowCommit(event: Window.Committable) {
        val project = projectDc.item
        dataManager.commit(project)
    }

    fun gen(entity: Entity<*>): Component {
        val checkBox = uiComponents.create(CheckBox::class.java)
        checkBox.setValue(projectDc.item.employees?.contains(entity) ?: false) // устанавливаем значение чекбокса в зависимости от наличия сотрудника в списке проекта
        checkBox.addValueChangeListener {
            val project = projectDc.item
            val employees = project.employees?.toMutableList() ?: mutableListOf()
            if (it.value == true && !employees.contains(entity)) { // проверяем, есть ли уже сотрудник в списке проекта
                employees.add(entity as Employee)
            } else {
                employees.removeIf { employee -> employee.id == entity.id }
            }
            project.employees = employees
            projectDc.setItem(project)
        }
        return checkBox
    }
}
