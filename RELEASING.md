Set up Sonatype Account
-----------------------
* Sign up for a Sonatype JIRA account [here](https://issues.sonatype.org)
* Click *Sign Up* in the login box, follow instructions

Get access to repository
------------------------
* Go to [community support](https://issues.sonatype.org/browse/OSSRH)
* Ask for publish rights by creating an issue similar to [this one](https://issues.sonatype.org/browse/OSSRH-32032)
  * You must be logged in to create a new issue
  * Use the *Create* button at the top tab

Set up PGP keys
---------------
* Install GNU Privacy Guard (GPG)
  * GPG is installed by default on Ubuntu systems
  * For other systems, see [GnuPG download page](https://www.gnupg.org/download/)

* Generate the key ```gpg --gen-key```

  * Keep the defaults, but specify a passphrase
  * The passphrase can be random; you just need to remember it long enough to finish the next step
  * One way to make a random passphrase: ```base64 /dev/urandom | head -c20; echo;```

* Find the ID of your public key ```gpg --list-secret-keys```
  * Look for the line with format ```sec   2048R/ABCDEFGH 2015-11-17```
  * The ```ABCDEFGH``` is the ID for your public key

* Upload your public key to a public server: ```gpg --send-keys --keyserver hkp://pgp.mit.edu ABCDEFGH```

Create a Maven settings file
----------------------------
* Create a file at ```$HOME/.m2/settings.xml``` with your passphrase and your sonatype username and password
```
<settings>
  <profiles>
    <profile>
      <id>ossrh</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <gpg.executable>gpg</gpg.executable>
        <gpg.passphrase>[the password for your gpg key]</gpg.passphrase>
      </properties>
    </profile>
  </profiles>
  <servers>
    <server>
      <id>ossrh</id>
      <username>[your sonatype account name]</username>
      <password>[your sonatype account password]</password>
    </server>
    <server>
      <id>sonatype-nexus-snapshots</id>
      <username>[your sonatype account name]</username>
      <password>[your sonatype account password]</password>
    </server>
    <server>
      <id>sonatype-nexus-staging</id>
      <username>[your sonatype account name]</username>
      <password>[your sonatype account password]</password>
    </server>
  </servers>
</settings>
```

To push a release version
-------------------------

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

1. Make sure you are using Maven version 3.3 or higher to support the Nexus plugin required to stage a release.

1. To ensure a clean build, remove *all* Maven targets (including subdirectories not handled by `mvn clean`) by running `rm -rf target */target`.

5. Run `utilities/stage_release.sh`.
This script builds and stages the release artifact on the Maven Central Repository, updates the README.md files with the release version + commits them locally, and finally generates a new site version for the gh-pages branch under a temporary directory named `tmp_gh-pages`. If you haven't run the release process before, it's worth verifying everything; check the staged release on the Sonatype website, and verify that the local commits have the right version updates.

If you experience failures, you may need to:
- repeat the clean step above
- remove the temporary directory created to store docs by running `rm -rf tmp_gh-pages`
- remove staged repositories from Sonatype: if a staged repository appears [here](https://oss.sonatype.org/#nexus-search;quick~com.google.cloud), remove it by running `mvn nexus-staging:drop`.

6. Run `utilities/finalize_release.sh`.
This script will release the staged artifact on the Maven Central Repository and push the README.md and gh-pages updates to github.

7. Publish a release on Github manually.
Go to the [releases page](https://github.com/GoogleCloudPlatform/google-cloud-java/releases) and open the appropriate release draft. Make sure the "Tag Version" is `vX.Y.Z` and the "Release Title" is `X.Y.Z`, where `X.Y.Z` is the release version as listed in the `pom.xml` files. 
  
  Add the commits since the last release into the release draft. Try to group them into sections with related changes. Anything that is a breaking change needs to be marked with `*breaking change*`. Such changes are only allowed for alpha/beta modules and `@BetaApi` features.

  Ensure that the format is consistent with previous releases (for an example, see the [0.1.0 release](https://github.com/GoogleCloudPlatform/google-cloud-java/releases/tag/v0.1.0)).  After adding any missing updates and reformatting as necessary, publish the draft.

1. Create a new draft for the next release. Note any commits not included in the release that have been submitted before the release commit, to ensure they are documented in the next release.

8. Run `utilities/update_versions.sh` again (to include "-SNAPSHOT" in the project version). Please refer to documentation in `utilities/update_versions.sh` for more details. 

9. Create and merge in another PR to reflect the updated project version.  For an example of what this PR should look like, see [#227](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/227).

To push a snapshot version
--------------------------

Pushing a snapshot is completely automated.  If "-SNAPSHOT" is included in the version denoted by the base directory's pom.xml, then an updated artifact will be pushed to the snapshot repository when Travis CI successfully completes a non-PR build. The build triggers the `after_success.sh` script, which handles the release process for SNAPSHOT versions.

Improvements
------------

Automatic tagging is not currently implemented, though it was discussed in [#119](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/119).  If the version updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to correctly tag releases.  However, automatically creating useful annotations for this tag will be difficult.  Also, if the release process becomes fully automated, tagging becomes a harder problem, as mentioned in that issue.
