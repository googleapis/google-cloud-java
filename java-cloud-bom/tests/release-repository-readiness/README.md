# Repository Readiness for Releases

This tool helps release managers to assess the readiness of the ~14 upstream GitHub
repositories for the libraries-bom, such as the java-bigtable and google-cloud-java repositories.

## clone_repositories.sh

`clone_repositories.sh` clones the upstream repositories in your /tmp directory. You run this after the sdk-platform-java release for your release cycle is available.

```
cd tests/release-repository-readiness
./clone_repositories.sh v2.55.1
...
Updating files: 100% (93964/93964), done.
/tmp/release-readiness/google-cloud-java ~/java-cloud-bom/tests/release-repository-readiness
~/java-cloud-bom/tests/release-repository-readiness
```

## check_status.sh: 

`check_status.sh` fetches the latest information of each upstream repository
using the cloned repositories, and displays the status of the main branch and
the latest released source tree.

A status consists of the shared dependencies BOM version (`shared dep` column)
and hermetic build code generation (`code gen` column).

During the handwritten libraries phase in your release cycle, you run this
occasionally to find actions needed for the repositories.

```
suztomo@suztomo2:~/java-cloud-bom/tests/release-repository-readiness$ ./check_status.sh 
Expected google-cloud-shared-dependencies BOM version: 3.45.1
Expected GAPIC generator Java version: 2.55.1
                    |        main         |      released       |
    repository      |shared dep|code gen  |shared dep|code gen  |
google-cloud-java   |OK        |OK        |OK        |OK        |
java-bigquerystorage|OK        |OK        |OK        |OK        |
java-bigquery       |! 3.44.0  |N/A       |! 3.44.0  |N/A       |
java-bigtable       |OK        |OK        |OK        |OK        |
java-datastore      |OK        |OK        |OK        |OK        |
java-firestore      |OK        |OK        |! 3.44.0  |! 2.54.0  |
java-logging        |OK        |OK        |OK        |OK        |
java-logging-logback|OK        |N/A       |OK        |N/A       |
java-pubsub         |OK        |OK        |OK        |OK        |
java-pubsublite     |OK        |OK        |OK        |OK        |
java-spanner        |! 3.44.0  |! 2.54.0  |! 3.44.0  |! 2.54.0  |
java-spanner-jdbc   |OK        |N/A       |OK        |N/A       |
java-storage        |OK        |OK        |OK        |OK        |
java-storage-nio    |OK        |N/A       |OK        |N/A       |
```

- In this example output above, you can see:
  - The java-bigquery and java-spanner repositories need to merge pull requests
    for the sdk-platform-java-config and hermetic code generation.
  - java-firestore repository has merged the changes in the main branch but
    it hasn't made a release with the changes.
  - The rest of the repositories show the changes are already in the latest release.
- "N/A" means that there's no hermetic code generation in the repository.
