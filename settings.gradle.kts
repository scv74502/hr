plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "hr"
include("api")
include("domain")
include("core")
include("external-api")
include("external-api:public-client")
findProject(":external-api:public-client")?.name = "public-client"
