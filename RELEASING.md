### Overview

Most of the release process is handled by the `after_success.sh` script, triggered after Travis CI successfully completes a non-PR build.  A new artifact will be released to Maven Central Repository via Travis CI when "-SNAPSHOT" is not included in the version (as listed in the base directory's `pom.xml`).  The website and README files will also be updated automatically in this case.  When "-SNAPSHOT" is included in the version, Travis only updates the artifact in the snapshot repository.

### To push a release version

1. Run `utilities/update_pom_version.sh` from the repository's base directory.
This script takes an optional argument denoting the new version.  By default, if the current version is X.Y.Z-SNAPSHOT, the script will update the version in all the pom.xml files to X.Y.Z.  If desired, another version can be supplied via command line argument instead.

2. Create a PR to update the pom.xml version.
The PR should look something like [#225](https://github.com/GoogleCloudPlatform/gcloud-java/pull/225).  After this PR is merged into GoogleCloudPlatform/gcloud-java, Travis CI will push a new website to GoogleCloudPlatform/gh-pages, push a new artifact to the Maven Central Repository, and update versions in the README files.

3. Create a release on Github manually.
Go to the [releases page](https://github.com/GoogleCloudPlatform/gcloud-java/releases) and click "Draft a new release."

4. Run `utilities/update_pom_version.sh` again (to include "-SNAPSHOT" in the project version).
As mentioned before, there is an optional version argument.  By default, the script will update the version from "X.Y.Z" to "X.Y.Z+1-SNAPSHOT".  Suppose a different version is desired, for example X+1.0.0-SNAPSHOT.  Then the appropriate command to run would be `utilities/update_pom_version.sh X+1.0.0-SNAPSHOT`.

5. Create and merge in another PR to reflect the updated project version.  For an example of what this PR should look like, see [#227](https://github.com/GoogleCloudPlatform/gcloud-java/pull/227).

### To push a snapshot version

Pushing a snapshot is completely automated.  If "-SNAPSHOT" is included in the version denoted by the base directory's pom.xml, then an updated artifact will be pushed to the snapshot repository when Travis CI successfully completes a non-PR build.

### Improvements

Automatic tagging is not currently implemented, though it was discussed in #119.  If the version updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to correctly tag releases.  However, automatically creating useful annotations for this tag will be difficult.  Also, if the release process becomes fully automated, tagging becomes a harder problem, as mentioned in that issue.
