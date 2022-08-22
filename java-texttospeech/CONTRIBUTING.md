# How to Contribute

We'd love to accept your patches and contributions to this project. There are
just a few small guidelines you need to follow.

## Contributor License Agreement

Contributions to this project must be accompanied by a Contributor License
Agreement. You (or your employer) retain the copyright to your contribution;
this simply gives us permission to use and redistribute your contributions as
part of the project. Head over to <https://cla.developers.google.com/> to see
your current agreements on file or to sign a new one.

You generally only need to submit a CLA once, so if you've already submitted one
(even if it was for a different project), you probably don't need to do it
again.

## Code reviews

All submissions, including submissions by project members, require review. We
use GitHub pull requests for this purpose. Consult
[GitHub Help](https://help.github.com/articles/about-pull-requests/) for more
information on using pull requests.

## Community Guidelines

This project follows
[Google's Open Source Community Guidelines](https://opensource.google.com/conduct/).

## Building the project

To build, package, and run all unit tests run the command

```
mvn clean verify
```

### Running Integration tests

To include integration tests when building the project, you need access to
a GCP Project with a valid service account. 

For instructions on how to generate a service account and corresponding
credentials JSON see: [Creating a Service Account][1].

Then run the following to build, package, run all unit tests and run all
integration tests.

```bash
export GOOGLE_APPLICATION_CREDENTIALS=/path/to/service/account.json
mvn -Penable-integration-tests clean verify
```

## Code Samples

All code samples must be in compliance with the [java sample formatting guide][3].
Code Samples must be bundled in separate Maven modules.

The samples must be separate from the primary project for a few reasons:
1. Primary projects have a minimum Java version of Java 8 whereas samples can have
   Java version of Java 11. Due to this we need the ability to
   selectively exclude samples from a build run.
2. Many code samples depend on external GCP services and need
   credentials to access the service.
3. Code samples are not released as Maven artifacts and must be excluded from 
   release builds.
   
### Building

```bash
mvn clean verify
```

Some samples require access to GCP services and require a service account:

```bash
export GOOGLE_APPLICATION_CREDENTIALS=/path/to/service/account.json
mvn clean verify
```

### Code Formatting

Code in this repo is formatted with
[google-java-format](https://github.com/google/google-java-format).
To run formatting on your project, you can run:
```
mvn com.coveo:fmt-maven-plugin:format
```

[1]: https://cloud.google.com/docs/authentication/getting-started#creating_a_service_account
[2]: https://maven.apache.org/settings.html#Active_Profiles
[3]: https://github.com/GoogleCloudPlatform/java-docs-samples/blob/main/SAMPLE_FORMAT.md