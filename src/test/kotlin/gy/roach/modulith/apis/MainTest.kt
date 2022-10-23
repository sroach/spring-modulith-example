package gy.roach.modulith.apis

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.modulith.docs.Documenter
import org.springframework.modulith.model.ApplicationModules




class MainTest {

    @Test
    fun genDoc() {
        val modules: ApplicationModules = ApplicationModules.of(Main::class.java)
        val opts  = Documenter.DiagramOptions.defaults()
            .withStyle(Documenter.DiagramOptions.DiagramStyle.C4);
        Documenter(modules)
            .writeModulesAsPlantUml(opts)
            //.writeIndividualModulesAsPlantUml()
            //.writeModuleCanvases()
            .withOutputFolder("docs").writeDocumentation();
    }
}