Contributing
============

1. **Please sign one of the contributor license agreements below.**
2. Fork the repo, develop and test your code changes, add docs.
3. Make sure that your commit messages clearly describe the changes.
4. Send a pull request.


Here are some guidelines for hacking on google-cloud-java.

Repository Structure
--------------------
* `google-cloud-pom-parent`
  * The root aggregator POM that lists all of the modules.
  * Serves as the parent POM for the `gapic-libraries-bom` and module mini BOMs.
  * Should not have any dependency management so as not to impact the BOMs.
* `google-cloud-jar-parent`
  * The root POM for all modules.
  * The only POM where non-annotated versions should be managed using `dependencyManagement`.
  * Contains common configuration for `jar` projects.
* `generation`
  * A collection of scripts that are used to make updates across modules.
* `gapic-libraries-bom`
  * A BOM for all non-preview libraries in the monorepo.
* `java-*`
  * Individual client libraries. 

Using maven for build/test
--------------------------

To run the tests, you must have application default credentials in a JSON file on your development machine. 
[Generate a JSON service account key](https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts)
in the cloud console and download they key to a secure location on your development box.
Then set the environment variable GOOGLE_APPLICATION_CREDENTIALS to the location of the JSON file.
For example:

  ```bash
  export GOOGLE_APPLICATION_CREDENTIALS=/path/to/my/key.json
   ```

After you clone the repository, use Maven for building and running the tests.

Integration tests run tests against real services and take a long time to run.
Consider `mvn install -DskipITs` to skip them when installing.
Maven 3.0+ is required.

It's also important to test that changes don't break compatibility with App/Compute Engine and when running elsewhere. 
To run tests on different platforms, try deploying the apps available on the [google-cloud-examples](https://github.com/googleapis/google-cloud-examples) repository.
End-to-end tests should ensure that google-cloud-java works when running on the

* App Engine production environment (see the docs for [uploading your app to production App Engine](https://cloud.google.com/appengine/docs/java/tools/maven#uploading_your_app_to_production_app_engine))
* App Engine development server (see the docs for [testing your app with the development server](https://cloud.google.com/appengine/docs/java/tools/maven#testing_your_app_with_the_development_server))
* Compute Engine (see the [Getting Started Guide](https://cloud.google.com/compute/docs/quickstart), and be sure to [enable the appropriate APIs](https://github.com/googleapis/google-cloud-common/tree/master/authentication#on-google-compute-engine))
* Your desktop (using `mvn exec:java`, for example)

When changes are made to authentication and project ID-related code, authentication and project ID inference should be tested using all relevant methods detailed in the [authentication docs](https://github.com/googleapis/google-cloud-java#authentication) and [project ID docs](https://github.com/googleapis/google-cloud-java#specifying-a-project-id).

Known issue: If you have installed the Google Cloud SDK, be sure to log in (using `gcloud auth login`) before running tests. Though the Datastore tests use a local Datastore emulator that doesn't require authentication, they will not run if you have the Google Cloud SDK installed but aren't authenticated.

**Please, do not use your production projects for executing integration tests.** While we do our best to make our tests independent of your project's state and content, they do perform create, modify and deletes, and you do not want to have your production data accidentally modified.

Adding Features
---------------
In order to add a feature to google-cloud-java:

The feature must be fully documented using Javadoc and examples should be provided.
The feature must work fully on Java 7 and above.
The feature must not add unnecessary dependencies (where "unnecessary" is of course subjective,
but new dependencies should be discussed).

Adding Support for a New Service
--------------------------------
See [SUPPORTING_NEW_SERVICES](./SUPPORTING_NEW_SERVICES.md) for guidelines on how to add support for a new Google Cloud service to `google-cloud-java`.

Coding Style
------------
Maintain the coding style in the project and in particular the modified files.
Follow the Google Java [style](https://google.github.io/styleguide/javaguide.html).

In pull requests, please run `mvn com.coveo:fmt-maven-plugin:format` to format your code diff.

## Contributor License Agreements

Before we can accept your pull requests you'll need to sign a Contributor
License Agreement (CLA):

- **If you are an individual writing original source code** and **you own the intellectual property**,
then you'll need to sign an [individual CLA][indvcla].
- **If you work for a company that wants to allow you to contribute your work**,
then you'll need to sign a [corporate CLA][corpcla].

You can sign these electronically (just scroll to the bottom). After that,
we'll be able to accept your pull requests.

## Code of Conduct

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

[gcloudcli]: https://developers.google.com/cloud/sdk/gcloud/
[indvcla]: https://developers.google.com/open-source/cla/individual
[corpcla]: https://developers.google.com/open-source/cla/corporate
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md
