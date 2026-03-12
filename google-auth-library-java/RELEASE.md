One-time setup
==============

Set up Sonatype Account
-----------------------
* Sign up for a Sonatype JIRA account [here](https://issues.sonatype.org)
* Click *Sign Up* in the login box, follow instructions

Get access to repository
------------------------
* Go to [community support](https://issues.sonatype.org/browse/OSSRH)
* Ask for publish rights by creating an issue similar to [this one](https://issues.sonatype.org/browse/OSSRH-16798)
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
  * If you see the error, `gpg: keyserver send failed: No data`, try again in ~5m. The mit server semi-frequently has trouble accepting keys

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
  </servers>
</settings>
```

To prepare a release
====================

Versioning
----------
Minor changes should be a point increase (0.6.0 -> 0.6.1).  Additions to API or breaking changes should be
a major release. (0.6.0 -> 0.7.0)

Prepare release
---------------
* Run `releasetool start`. Select "minor" or "patch" for the release type. This will bump the
  artifact versions, ask you to edit release notes, and create the release pull request.
* Run `mvn clean install deploy -DperformRelease=true` to stage the release.
* Verify the result [here](https://oss.sonatype.org/#nexus-search;quick~com.google.auth).
  * If there is a problem, undo by `mvn nexus-staging:drop`.

Publish release
---------------
* `mvn nexus-staging:release -DperformRelease=true`
* It will take some time (10 minutes to 8 hours) for the package to be released
* Confirm that the release appears in the [parent folder on Maven
Central](https://repo1.maven.org/maven2/com/google/auth/google-auth-library-parent/)
* If the release doesn't show up, do the following to check for failures:
  * Go to [Sonatype](https://oss.sonatype.org/) and log in
  * Click on *Staging Repositories* on the left
  * Filter down to the repository by typing the package's groupId in the search box
    * In our case, `com.google.auth`
  * Click on the repository and check for errors
* Submit the pull request to bump the version numbers
* Update Javadoc on GitHub using `scripts/update_javadoc.sh`.
* Run `releasetool tag` to create the GitHub release.
* Run `releasetool start` to bump the next snapshot version. Select "snapshot" when prompted for
  the release type. This will bump the artifact versions and create a pull request.
* Review and submit the PR.

Special cases
=============

Deploying version not at the head of the repository
---------------------------------------------------
* Check out the version you want to deploy
  * ```git checkout <ref>```
* Make sure all ```pom.xml``` file are not using ```SNAPSHOT``` versions
* Proceed to **Deploy to Sonatype**
