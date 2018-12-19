plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM
    id("org.jetbrains.kotlin.jvm").version("1.3.10")
    id("net.ltgt.apt").version("0.10")

    // Apply the application to add support for building a CLI application
    application
    idea
}

apply(plugin = "kotlin-kapt")

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}


dependencies {
    // Use the Kotlin JDK 8 standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.dropwizard:dropwizard-core:1.3.5")

    implementation("com.google.dagger:dagger:2.16")
    kapt("com.google.dagger:dagger-compiler:2.16")

    // Use the Kotlin test library
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("io.mockk:mockk:1.8.13")
}

application {
    // Define the main class for the application
    mainClassName = "<%= package %>.<%= name %>Application"
}

