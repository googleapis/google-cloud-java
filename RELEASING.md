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

Install releasetool
-------------------
See [releasetool](https://github.com/googleapis/releasetool) for installation instructions. You will
need python 3.6+ to run this tool.

To push a release version
=========================

1. Make sure the team agrees that it is time to release. 

2. Look over all of the commits since the last release and make sure there are no breaking changes
   on the public surface. If there are any breaking changes, create and merge a new PR to revert the
   surface back.

  **Note:** this should just be a scan of the public surface that would appear in Java doc.
  Implementation changes, README changes, and snippet changes can all be skipped for this check.

3. Verify that all unit and integration tests for the last commit have passed.

4. Run `releasetool start`. Select "minor" or "patch" for the release type. This will bump the
   artifact versions, ask you to edit release notes, and create the release pull request.

  **Note:** be sure to make these notes nice as they will be used for the release notes as well.

5. Run `git clean -x -f -d` to put the repo in a clean state.

6. Locally build the repo by running `mvn install -DskipTests`.

7. Run `python utilities/stage_sites.py`. This script checks out `gh-pages` branch of the
   repository, builds the documentation site and javadocs, copies them to the branch and commits it.
   This script does not push the docs and it must be done manually on the later step. The script
   assumes that there is no directory called `tmp_gh-pages` in the repository root. If it is
   present, remove it before running the script.

8. Locally edit the root `pom.xml` so that `mvn deploy` works:
  1. Under `<modules>`, comment out `google-cloud-examples`, `google-cloud-testing`, and
     `google-cloud-util`.
  2. Comment out the `nexus-staging-maven-plugin` plugin definition at the end of the file.

  **Don't commit these changes.**

9. Check that you are not trying to release a SNAPSHOT build (the artifacts versions do not have
   "-SNAPSHOT" suffix) and then run `mvn clean deploy -DskipTests=true --settings ~/.m2/settings.xml -P release`
   command. It will build and deploy artifacts to the staging repository.

  **Note:** you may need to specify the stagingProfileId with `-DstagingProfileId=3187e4f20d328b`
  **Note:** you may need to specify the GPG tty with `GPG_TTY=$(tty)`

10. Uncomment the `nexus-staging-maven-plugin` plugin definition from step 8; This plugin is
    needed to release the artifacts. Run `mvn nexus-staging:release` to release the artifacts.

11. Revert the local edits to your `pom.xml` performed a couple steps above by running `git checkout pom.xml`.

12. Run `cd tmp_gh-pages && git push && cd ..` to push the previously generated docs (step 7).

13. Run `rm -rf tmp_gh-pages` to remove the generated docs directory from your local machine.

14. Publish a release on Github. Run `releasetool tag`. It will list the last few merged PRs. Select
    the newly merged release PR. Releasetool will create the GitHub release with notes extracted
    from the pull request and tag the new release.

15. Bump the next snapshot version. Run `releasetool start`. Select "snapshot" when prompted for the
    release type. This will bump the artifact versions and create a pull request.

16. Review and submit the PR.

Improvements
============

Automatic tagging is not currently implemented, though it was discussed in [#119](https://github.com/GoogleCloudPlatform/google-cloud-java/pull/119).  If the version updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to correctly tag releases.  However, automatically creating useful annotations for this tag will be difficult.  Also, if the release process becomes fully automated, tagging becomes a harder problem, as mentioned in that issue.
