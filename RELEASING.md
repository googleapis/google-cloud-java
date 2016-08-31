### Overview

Most of the release process is handled by the `after_success.sh` script, triggered after Travis CI successfully completes a non-PR build.  A new artifact will be released to Maven Central Repository via Travis CI when "-SNAPSHOT" is not included in the version (as listed in the base directory's `pom.xml`).  The website and README files will also be updated automatically in this case.  When "-SNAPSHOT" is included in the version, Travis only updates the artifact in the snapshot repository.

### To push a release version

1. Run `utilities/update_pom_version.sh` from the repository's base directory.
This script takes an optional argument denoting the new version.  By default, if the current version is X.Y.Z-SNAPSHOT, the script will update the version in all the pom.xml files to X.Y.Z.  If desired, another version can be supplied via command line argument instead.

2. Create a PR to update the pom.xml version.  If releasing a new client library, this PR should also update javadoc grouping in the base directory's [pom.xml](./pom.xml).
PRs that don't release new modules should look something like [#225](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/225).  PRs that do release a new module should also add the appropriate packages to the javadoc groups "SPI" and "Test helpers", as shown in [#802](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/802) for `google-cloud-dns`. After this PR is merged into GoogleCloudPlatform/google-cloud-java, Travis CI will push a new website to GoogleCloudPlatform/gh-pages, push a new artifact to the Maven Central Repository, and update versions in the README files.  Do not merge in any non-release-related pull requests between the start of step 2 and the end of step 6.  Between these steps, the project version is a non-snapshot version, so any commits to the master branch will cause Travis to spend extra resources attempting to redeploy artifacts.

3. Before moving on, verify that the artifacts have successfully been pushed to the Maven Central Repository.  Open Travis CI, click the ["Build History" tab](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java/builds), and open the second build's logs for Step 2's PR.  Be sure that you are not opening the "Pull Request" build logs.  When the build finishes, scroll to the end of the log and verify that the artifacts were successfully staged and deployed.  Search for `google-cloud` on the [Sonatype website](https://oss.sonatype.org/#nexus-search;quick~google-cloud) and check the latest version number.  In rare cases (when the Maven plugin that determines the version of the repository fails), the artifacts may not be deployed even if the version in the pom.xml files doesn't contain `SNAPSHOT`.  If the artifacts weren't deployed due to invalid version parsing or a flaky test, rerun the build.

4. Publish a release on Github manually.
Go to the [releases page](https://github.com/GoogleCloudPlatform/google-cloud-java/releases) and open the appropriate release draft. Make sure the "Tag Version" is `vX.Y.Z` and the "Release Title" is `X.Y.Z`, where `X.Y.Z` is the release version as listed in the `pom.xml` files.  The draft should already have all changes that impact users since the previous release.  To double check this, you can use the `git log` command and look through the merged master branch pull requests.  Here is an example of the log command to get non-merge commits between v0.0.12 and v0.1.0:

  ```
  git --no-pager log v0.0.12..v0.1.0 --pretty=oneline --abbrev-commit --no-merges
  ```

  Ensure that the format is consistent with previous releases (for an example, see the [0.1.0 release](https://github.com/GoogleCloudPlatform/google-cloud-java/releases/tag/v0.1.0)).  After adding any missing updates and reformatting as necessary, publish the draft.  Finally, create a new draft for the next release.

5. Run `utilities/update_pom_version.sh` again (to include "-SNAPSHOT" in the project version).
As mentioned before, there is an optional version argument.  By default, the script will update the version from "X.Y.Z" to "X.Y.Z+1-SNAPSHOT".  Suppose a different version is desired, for example X+1.0.0-SNAPSHOT.  Then the appropriate command to run would be `utilities/update_pom_version.sh X+1.0.0-SNAPSHOT`.

6. Create and merge in another PR to reflect the updated project version.  For an example of what this PR should look like, see [#227](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/227).

7. Be sure to update Google Cloud Platform docs, [java-docs-samples](https://github.com/GoogleCloudPlatform/java-docs-samples) code/docs, and [getting-started-java](https://github.com/GoogleCloudPlatform/getting-started-java) code/docs.  See directions [here](https://docs.google.com/a/google.com/document/d/1SS3xNn2v0qW7EadGUPBUAPIQAH5VY6WSFmT17ZjjUVE/).

### To push a snapshot version

Pushing a snapshot is completely automated.  If "-SNAPSHOT" is included in the version denoted by the base directory's pom.xml, then an updated artifact will be pushed to the snapshot repository when Travis CI successfully completes a non-PR build.

### Improvements

Automatic tagging is not currently implemented, though it was discussed in [#119](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/119).  If the version updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to correctly tag releases.  However, automatically creating useful annotations for this tag will be difficult.  Also, if the release process becomes fully automated, tagging becomes a harder problem, as mentioned in that issue.
