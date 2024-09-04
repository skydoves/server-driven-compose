pluginManagement {
  includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "server-driven-compose"
include(":app")
include(":core:designsystem")
include(":core:navigation")
include(":core:network")
include(":core:data")
include(":core:model")
include(":feature:timeline")
include(":feature:details")
