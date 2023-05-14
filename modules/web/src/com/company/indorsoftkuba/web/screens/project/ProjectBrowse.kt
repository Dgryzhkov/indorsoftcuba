package com.company.indorsoftkuba.web.screens.project

import com.haulmont.cuba.gui.screen.*
import com.company.indorsoftkuba.entity.Project

@UiController("indorsoftkuba_Project.browse")
@UiDescriptor("project-browse.xml")
@LookupComponent("projectsTable")
@LoadDataBeforeShow
class ProjectBrowse : StandardLookup<Project>()