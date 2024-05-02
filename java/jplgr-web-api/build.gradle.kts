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

val springVersion: String by project
dependencies {
    implementation(project(":jplgr-api"))
    compileOnly("jakarta.servlet:jakarta.servlet-api:5.0.0")
	implementation("org.springframework:spring-context:$springVersion")
	implementation("org.springframework:spring-web:$springVersion")
	implementation("org.springframework:spring-webmvc:$springVersion")
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
