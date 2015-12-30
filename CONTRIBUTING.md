Contributing
============

1. **Please sign one of the contributor license agreements below.**
1. Fork the repo, develop and test your code changes, add docs.
1. Make sure that your commit messages clearly describe the changes.
1. Send a pull request.


Here are some guidelines for hacking on gcloud-java.


Using maven for build/test
--------------------------
After you cloned the repository use Maven for building and running the tests.
Maven 3.0+ is required.

When downloading the source, we recommend you obtain service account credentials. 
These credentials will allow you to run integration tests using `mvn verify` in command line. 
Follow step 2 of the [authentication instructions](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) to generate and use JSON service account credentials.

It's also important to test that changes don't break compatibility with App/Compute Engine and when running elsewhere. 
To run tests on different platforms, try deploying the apps available on the [gcloud-java-examples](https://github.com/GoogleCloudPlatform/gcloud-java-examples) repository. 
End-to-end tests should ensure that gcloud-java works when running on the

* App Engine production environment (see the docs for [uploading your app to production App Engine](https://cloud.google.com/appengine/docs/java/tools/maven#uploading_your_app_to_production_app_engine))
* App Engine development server (see the docs for [testing your app with the development server](https://cloud.google.com/appengine/docs/java/tools/maven#testing_your_app_with_the_development_server))
* Compute Engine (see the [Getting Started Guide](https://cloud.google.com/compute/docs/quickstart), and be sure to [enable the appropriate APIs](https://github.com/GoogleCloudPlatform/gcloud-common/tree/master/authentication#on-google-compute-engine))
* Your desktop (using `mvn exec:java`, for example)

When changes are made to authentication and project ID-related code, authentication and project ID inference should be tested using all relevant methods detailed in the [authentication docs](https://github.com/GoogleCloudPlatform/gcloud-java#authentication) and [project ID docs](https://github.com/GoogleCloudPlatform/gcloud-java#specifying-a-project-id).

Adding Features
---------------
In order to add a feature to gcloud-java:

The feature must be fully documented using Javadoc and examples should be provided.
The feature must work fully on Java 7 and above.
The feature must not add unnecessary dependencies (where "unnecessary" is of course subjective,
but new dependencies should be discussed).


Coding Style
------------
Maintain the coding style in the project and in particular the modified files.
Follow the Google Java [style](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html).


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
[code-of-conduct]:https://github.com/GoogleCloudPlatform/gcloud-java/blob/master/CODE_OF_CONDUCT.md
