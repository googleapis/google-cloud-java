## Setup

### Install releasetool

See [releasetool](https://github.com/googleapis/releasetool) for installation instructions. You will
need python 3.6+ to run this tool.

## Prepare a release

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

## Pushing a release to Maven using Kokoro

To manually publish the artifacts to Maven (rather than using Kokoro), you will need to follow the
"Additional setup for manual publishing" steps below and follow the instructions in the
"Manually publishing" section.

1. Trigger the `google-cloud-java/release/stage` Kokoro job and wait for it to complete. This will
   stage the built artifacts and prepare them for publishing.

2. Look through the logs for the `google-cloud-java/release/stage` and find the staging repository
   ids used. They will look like `comgoogleapi-XYZ` and `comgooglecloud-XYZ`.

3. Promote or drop the staged repository.

  a. To publish the staged repository, trigger the `google-cloud-java/release/promote` Kokoro job for
     each staging repository. To specify the staging repository, add an environment variable
     configuration with `STAGING_REPOSITORY_ID=<staging repository id>` from the UI. **Note: thi 
     will need to be run for each staging repository. It may take a few hours for the released
     versions to be available for users to download.**

  b. To drop (abort) the staged repository, trigger the `google-cloud-java/release/drop` Kokoro job
     with the same staging repository id configuration as if you were publishing.

## Publish Javadoc

1. Run `git clean -x -f -d` to put the repo in a clean state.

2. Locally build the repo by running `mvn install -DskipTests`.

3. Run `python utilities/stage_sites.py`. This script checks out `gh-pages` branch of the
   repository, builds the documentation site and javadocs, copies them to the branch and commits it.
   This script does not push the docs and it must be done manually on the later step. The script
   assumes that there is no directory called `tmp_gh-pages` in the repository root. If it is
   present, remove it before running the script.

4. Run `cd tmp_gh-pages && git push && cd ..`.

5. (Optional) Run `rm -rf tmp_gh-pages` to remove the generated docs directory from your local
   machine.

## Tag the release

1. Run `releasetool tag` to publish a release on Github. It will list the last few merged PRs.
   Select the newly merged release PR. Releasetool will create the GitHub release with notes
   extracted from the pull request and tag the new release.

## Prepare the next snapshot version

1. Run `releasetool start` to bump the next snapshot version. Select "snapshot" when prompted for
   the release type. This will bump the artifact versions and create a pull request.

2. Review and submit the PR.

## Additional setup for manual publishing

### Set up Sonatype Account

* Sign up for a Sonatype JIRA account [here](https://issues.sonatype.org)
* Click *Sign Up* in the login box, follow instructions

### Get access to repository

* Go to [community support](https://issues.sonatype.org/browse/OSSRH)
* Ask for publish rights by creating an issue similar to [this one](https://issues.sonatype.org/browse/OSSRH-32032)
  * You must be logged in to create a new issue
  * Use the *Create* button at the top tab

### Set up PGP keys

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

### Create a Maven settings file

* Create a file at ```$HOME/.m2/settings.xml``` with your passphrase and your sonatype username and password
```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
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

### Manually publishing (from a local machine)

1. Run `git clean -x -f -d` to put the repo in a clean state.

2. Locally build the repo by running `mvn install -DskipTests`.

3.  and then run `mvn clean deploy -DskipTests=true --settings ~/.m2/settings.xml -P release`
   command. It will build and deploy artifacts to the staging repository.

  **Note:** you may need to specify the stagingProfileId with `-DstagingProfileId=3187e4f20d328b`
  **Note:** you may need to specify the GPG tty with `GPG_TTY=$(tty)`

9. Run `mvn nexus-staging:release` to release the artifacts. If you wish to abort the release, run
   `mvn nexus-staging:drop`.

## Improvements

* Automatic tagging is not currently implemented, though it was discussed in #119. If the version 
  updates continue to be manual, a one-line git tag command can be added to `after_success.sh` to 
  correctly tag releases.  However, automatically creating useful annotations for this tag will be 
  difficult.  Also, if the release process becomes fully automated, tagging becomes a harder 
  problem, as mentioned in that issue.

