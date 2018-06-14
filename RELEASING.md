One-time setup
==============

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

Make sure you are using Maven version 3.3 or higher to support the Nexus plugin required to stage a release.

To push a release version
=========================

1. Make sure the team agrees that it is time to release. 

2. Look over all of the commits since the last release and make sure there are no breaking changes on the public surface. If there are any breaking changes, create and merge a new PR to revert the surface back.

  Note - this should just be a scan of the public surface that would appear in Java doc. Implementation changes, README changes, and snippet changes can all be skipped for this check.

3. Verify that all unit and integration tests for the last commit have passed.

4. Run `python utilities/bump_versions.py next_release minor` from the repository's base directory. (If there are only bug fixes and no additions to the surface, use `patch` instead of `minor`.) Alternatively, update the versions in `versions.txt` to the correct versions for the next release.

5. Run `python utilities/replace_versions.py` from the repository's base directory. This updates the versions in all `pom.xml` and `README.md` files in preparation for a release. Commit these files locally:
  
  ```
  git add .
  git commit -m "Release [VERSION HERE]"
  ```

6. Create and merge in a PR to reflect the updated project version.

7. Put the repo in a clean state: a) `mvn clean`, then b) `git clean -x -f -d`.

8. Locally build the repo by running `mvn install -DskipTests`.

9. Run `python utilities/stage_sites.py`.
This script checks out `gh-pages` branch of the repository, builds the documentation site and javadocs, copies them to the branch and commits it. This script does not push the docs and it must be done manually on the later step. The script assumes that there is no directory called `tmp_gh-pages` in the repository root. If it is present, remove it before running the script.

10. Check that you are not trying to release a SNAPSHOT build (the artifacts versions do not have "-SNAPSHOT" suffix) and then run `mvn clean deploy -DskipTests=true --settings ~/.m2/settings.xml -P release` command. It will build and deploy artifacts to the staging repository. 

11. Run `mvn nexus-staging:release` to release the artifacts. 

12. Run `cd tmp_gh-pages && git push && cd ..` to push the previously generated docs (step 8).

13. Run `rm -rf tmp_gh-pages` to remove the generated docs directory from your local machine. 

14. Publish a release on Github manually.
Go to the [releases page](https://github.com/GoogleCloudPlatform/google-cloud-java/releases) and open the appropriate release draft. Make sure the "Tag Version" is `vX.Y.Z` and the "Release Title" is `X.Y.Z`, where `X.Y.Z` is the release version as listed in the `pom.xml` files. 
  
  Add the commits since the last release into the release draft. Try to group them into sections with related changes. Anything that is a breaking change needs to be marked with `*breaking change*`. Such changes are only allowed for alpha/beta modules and `@BetaApi` features.

  Ensure that the format is consistent with previous releases (for an example, see the [0.1.0 release](https://github.com/GoogleCloudPlatform/google-cloud-java/releases/tag/v0.1.0)).  After adding any missing updates and reformatting as necessary, publish the draft.

15. Run `python utilities/bump_versions.py next_snapshot patch` to include "-SNAPSHOT" in the current project version (Alternatively, update the versions in `versions.txt` to the correct versions for the next release.). Then, run `python utilities/replace_versions.py` to update the `pom.xml` files. (If you see updates in `README.md` files at this step, you probably did something wrong.)

16. Create and merge in another PR to reflect the updated project version.

Improvements
============

Automatic tagging is not currently implemented, though it was discussed in [#119](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/119).  If the version updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to correctly tag releases.  However, automatically creating useful annotations for this tag will be difficult.  Also, if the release process becomes fully automated, tagging becomes a harder problem, as mentioned in that issue.
