import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.report.ReportMergeTask

plugins {
    id("base-convention")
    id("web-convention")
    id("persistence-convention")
    id("io.gitlab.arturbosch.detekt")
}

detekt {
    // The directories where detekt looks for source files.
    // Defaults to `files("src/main/java", "src/test/java", "src/main/kotlin", "src/test/kotlin")`.
    source.setFrom("src/main/kotlin", "src/test/kotlin")

    // Specify the base path for file paths in the formatted reports.
    // If not set, all file paths reported will be absolute file path.
    basePath = rootProject.projectDir.toString()

    // Define the detekt configuration(s) you want to use.
    // Defaults to the default detekt configuration.
    config.setFrom("${rootProject.projectDir}/detekt.yml")
    autoCorrect = true
    buildUponDefaultConfig = true
}

val reportMerge by tasks.registering(ReportMergeTask::class) {
    output.set(rootProject.layout.buildDirectory.file("reports/detekt/merge.xml"))
}

reportMerge {
    input.from(tasks.withType<Detekt>().map(Detekt::xmlReportFile))
}

tasks.withType<Detekt>().configureEach {
    finalizedBy(reportMerge)
}
