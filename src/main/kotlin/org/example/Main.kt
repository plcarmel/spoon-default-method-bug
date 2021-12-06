package org.example

import spoon.Launcher
import spoon.reflect.declaration.CtType
import spoon.support.sniper.SniperJavaPrettyPrinter

fun main() {
    val launcher = Launcher()
    launcher.environment.setPrettyPrinterCreator { SniperJavaPrettyPrinter(launcher.environment) }
    launcher.addInputResource("./srcToTransform")
    val model = launcher.buildModel()
    val t = model.allTypes.first()
    val m = t.allMethods.first()
    m.setSimpleName<CtType<*>>("potato")
    launcher.prettyprint()
}