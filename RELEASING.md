### Overview

The release process for SNAPSHOT versions is handled by the `after_success.sh` script, triggered after Travis CI successfully completes a non-PR build. A new SNAPSHOT artifact will be released to the snapshot repository as part of this script.

### To push a release version

1. Make sure the team agrees that it is time to release. 

2. Look over all of the commits since the last release and make sure there are no breaking changes on the public surface. If there are any breaking changes, create and merge a new PR to revert the surface back.

  Note - this should just be a scan of the public surface that would appear in Java doc. Implementation changes, README changes, and snippet changes can all be skipped for this check.

3. Verify that all unit and integration tests for the last commit have passed.

4. Run `utilities/update_versions.sh` from the repository's base directory.
This script takes optional arguments denoting the new versions for each qualifier (alpha, beta and/or GA). By default, if the current version is X.Y.Z-SNAPSHOT, the script will update the version in all the pom.xml and other relevant files to X.Y.Z. Please refer to the documentation in `utilities/update_versions.sh` for more details. Commit this version locally:
  
  ```
  git add .
  git commit -m "Release [VERSION HERE]"
  ```
  
5. Run `utilities/stage_release.sh`.
This script builds and stages the release artifact on the Maven Central Repository, updates the README.md files with the release version + commits them locally, and finally generates a new site version for the gh-pages branch under a temporary directory named `tmp_gh-pages`. If you haven't run the release process before, it's worth verifying everything; check the staged release on the Sonatype website, and verify that the local commits have the right version updates.

6. Run `utilities/finalize_release.sh`.
This script will release the staged artifact on the Maven Central Repository and push the README.md and gh-pages updates to github.

7. Publish a release on Github manually.
Go to the [releases page](https://github.com/GoogleCloudPlatform/google-cloud-java/releases) and open the appropriate release draft. Make sure the "Tag Version" is `vX.Y.Z` and the "Release Title" is `X.Y.Z`, where `X.Y.Z` is the release version as listed in the `pom.xml` files. 
  
  Add the commits since the last release into the release draft. Try to group them into sections with related changes. Anything that is a breaking change needs to be marked with `*breaking change*`. Such changes are only allowed for alpha/beta modules and `@BetaApi` features.

  Ensure that the format is consistent with previous releases (for an example, see the [0.1.0 release](https://github.com/GoogleCloudPlatform/google-cloud-java/releases/tag/v0.1.0)).  After adding any missing updates and reformatting as necessary, publish the draft.  Finally, create a new draft for the next release.

8. Run `utilities/update_versions.sh` again (to include "-SNAPSHOT" in the project version). Please refer to documentation in `utilities/update_versions.sh` for more details. 

9. Create and merge in another PR to reflect the updated project version.  For an example of what this PR should look like, see [#227](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/227).

### To push a snapshot version

Pushing a snapshot is completely automated.  If "-SNAPSHOT" is included in the version denoted by the base directory's pom.xml, then an updated artifact will be pushed to the snapshot repository when Travis CI successfully completes a non-PR build.

### Improvements

Automatic tagging is not currently implemented, though it was discussed in [#119](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/119).  If the version updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to correctly tag releases.  However, automatically creating useful annotations for this tag will be difficult.  Also, if the release process becomes fully automated, tagging becomes a harder problem, as mentioned in that issue.
