### Overview

The release process for SNAPSHOT versions is handled by the `after_success.sh` script, triggered after Travis CI successfully completes a non-PR build. A new SNAPSHOT artifact will be released to the snapshot repository as part of this script.

### To push a release version

1. Make sure the team agrees that it is time to release. Verify that all unit and integration tests for the last commit have passed.

2. Run `utilities/update_pom_version.sh` from the repository's base directory.
This script takes an optional argument denoting the new version. By default, if the current version is X.Y.Z-SNAPSHOT, the script will update the version in all the pom.xml files to X.Y.Z. If desired, another version can be supplied via command line argument instead. Commit this version locally:

  ```
  git commit -m "Release [VERSION HERE]"
  ```

3. Run `utilities/stage_release.sh`.
This script builds and stages the release artifact on the Maven Central Repository, updates the README.md files with the release version + commits them locally, and finally generates a new site version for the gh-pages branch under a temporary directory named `tmp_gh-pages`. If you haven't run the release process before, it's worth verifying everything; check the staged release on the Sonatype website, and verify that the local commits have the right version updates.

4. Run `utilities/finalize_release.sh`.
This script will release the staged artifact on the Maven Central Repository and push the README.md and gh-pages updates to github.

5. Publish a release on Github manually.
Go to the [releases page](https://github.com/GoogleCloudPlatform/google-cloud-java/releases) and open the appropriate release draft. Make sure the "Tag Version" is `vX.Y.Z` and the "Release Title" is `X.Y.Z`, where `X.Y.Z` is the release version as listed in the `pom.xml` files.  The draft should already have all changes that impact users since the previous release.  To double check this, you can use the `git log` command and look through the merged master branch pull requests.  Here is an example of the log command to get non-merge commits between v0.0.12 and v0.1.0:

  ```
  git --no-pager log v0.0.12..v0.1.0 --pretty=oneline --abbrev-commit --no-merges
  ```

  Ensure that the format is consistent with previous releases (for an example, see the [0.1.0 release](https://github.com/GoogleCloudPlatform/google-cloud-java/releases/tag/v0.1.0)).  After adding any missing updates and reformatting as necessary, publish the draft.  Finally, create a new draft for the next release.

6. Run `utilities/update_pom_version.sh` again (to include "-SNAPSHOT" in the project version).
As mentioned before, there is an optional version argument.  By default, the script will update the version from "X.Y.Z" to "X.Y.Z+1-SNAPSHOT".  Suppose a different version is desired, for example X+1.0.0-SNAPSHOT.  Then the appropriate command to run would be `utilities/update_pom_version.sh X+1.0.0-SNAPSHOT`.

7. Create and merge in another PR to reflect the updated project version.  For an example of what this PR should look like, see [#227](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/227).

8. Be sure to update Google Cloud Platform docs, [java-docs-samples](https://github.com/GoogleCloudPlatform/java-docs-samples) code/docs, and [getting-started-java](https://github.com/GoogleCloudPlatform/getting-started-java) code/docs.  See directions [here](https://docs.google.com/a/google.com/document/d/1SS3xNn2v0qW7EadGUPBUAPIQAH5VY6WSFmT17ZjjUVE/).

### To push a snapshot version

Pushing a snapshot is completely automated.  If "-SNAPSHOT" is included in the version denoted by the base directory's pom.xml, then an updated artifact will be pushed to the snapshot repository when Travis CI successfully completes a non-PR build.

### Improvements

Automatic tagging is not currently implemented, though it was discussed in [#119](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/119).  If the version updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to correctly tag releases.  However, automatically creating useful annotations for this tag will be difficult.  Also, if the release process becomes fully automated, tagging becomes a harder problem, as mentioned in that issue.
