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
	implementation("org.springframework:spring-jdbc:$springVersion")

    implementation("org.mybatis:mybatis:3.5.16")
    implementation("org.mybatis:mybatis-spring:3.0.3")
    runtimeOnly("com.mysql:mysql-connector-j:8.3.0")
    runtimeOnly("org.apache.tomcat:tomcat-jdbc:10.1.23")

    testImplementation(libs.junit.jupiter)
    testImplementation("jakarta.servlet:jakarta.servlet-api:$servletApiVersion")
    testImplementation("org.hamcrest:hamcrest:2.2")
	testImplementation("org.springframework:spring-test:$springVersion")
    testImplementation("org.dbunit:dbunit:2.7.3")
    testImplementation("com.github.springtestdbunit:spring-test-dbunit:1.3.0")
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
