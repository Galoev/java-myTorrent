plugins {
    application
}

configure<JavaApplication> {
    mainClass.set("ru.itmo.java.tracker.Tracker")
}

dependencies {
    implementation(project(":common"))
}