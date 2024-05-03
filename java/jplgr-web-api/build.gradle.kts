plugins {
	java
	war
	id("io.freefair.lombok") version "6.4.2"
}

group = "com.ohmin839.jplgr.web.api"

repositories {
	mavenCentral()
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.ow2.asm") {
            useVersion("9.5")
        }
    }
}

val servletApiVersion: String by project
val springVersion: String by project
dependencies {
    implementation(project(":jplgr-api"))
    compileOnly("jakarta.servlet:jakarta.servlet-api:$servletApiVersion")
	implementation("org.springframework:spring-context:$springVersion")
	implementation("org.springframework:spring-web:$springVersion")
	implementation("org.springframework:spring-webmvc:$springVersion")

    testImplementation(libs.junit.jupiter)
    testImplementation("jakarta.servlet:jakarta.servlet-api:$servletApiVersion")
    testImplementation("org.hamcrest:hamcrest:2.2")
	testImplementation("org.springframework:spring-test:$springVersion")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.war {
    archiveFileName.set("jplgr-web-api.war")
}
