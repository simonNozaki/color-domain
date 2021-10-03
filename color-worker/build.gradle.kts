plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.0"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

repositories {
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // spring
    implementation("org.springframework.boot:spring-boot-starter-batch:2.5.5")
    implementation("com.h2database:h2:1.4.200")

    implementation(project(":color-usecase"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
