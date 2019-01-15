import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", "1.3.10"))
    }
}

plugins {
    kotlin("jvm") version "1.3.10"
    id("io.gitlab.arturbosch.detekt") version "1.0.0-RC11"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))

    val junitJupiterVersion = "5.3.1"

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")

    testImplementation("io.mockk:mockk:1.8.13")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.10")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.3.10")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }

    reports {
        html.isEnabled = true
    }
}