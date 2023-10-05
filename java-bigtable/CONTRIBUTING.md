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

## Developing

This project relocates some of its internal dependencies. Since IDEs can't resolve the relocated symbols on their own,
a workaround is:

1. Install the shaded module `mvn install -pl google-cloud-bigtable-stats`
2. Disable the `with-shaded` profile to force IDEs to resolve the relocated dependencies from the local repository

## Code reviews

All submissions, including submissions by project members, require review. We
use GitHub pull requests for this purpose. Consult
[GitHub Help](https://help.github.com/articles/about-pull-requests/) for more
information on using pull requests.

## Community Guidelines

This project follows
[Google's Open Source Community Guidelines](https://opensource.google.com/conduct/).


## Running Tests

### Integration Tests

Bigtable integration tests can either be run against an emulator or a real Bigtable instance.
The target environment can be selected by setting a maven profile. By default it is set to 
`bigtable-emulator-it` and other options are `bigtable-prod-it` and `bigtable-directpath-it`.

To use the `bigtable-prod-it` and `bigtable-directpath-it` environments:

1. Set up the target table using scripts/setup-test-table.sh
2. Download the JSON service account credentials file from the Google Developer's Console.
3. Set the environment variable GOOGLE_APPLICATION_CREDENTIALS to the path of the credentials file
4. Enable the profile and the system properties `bigtable.project`, `bigtable.instance` 
   and `bigtable.table` to created earlier. Example:
  ```bash
   mvn verify \
  -P bigtable-prod-it \
  -Dbigtable.project=my-project
  -Dbigtable.instance=my-instance
  -Dbigtable.table=my-table
  ```

While developing, it might be helpful to separate running unit tests from integration tests.

```bash
# To skip integration tests:
mvn install -DskipITs

# To skip unit tests
mvn install -DskipUnitTests

# To skip all tests
mvn install -DskipTests
```

### Conformance Tests

Bigtable Conformance Tests test the correctness of the client behavior and must be run for all code changes.
When adding a new feature, conformance tests must be run with the feature enabled.

Refer to the [Test Proxy](https://github.com/googleapis/java-bigtable/tree/main/test-proxy#cbt-java-test-proxy) page
on how to run conformance tests.

## Formatting the code

To auto-format any code changes, run ``mvn com.coveo:fmt-maven-plugin:format``.

## Native Image Testing
Native Image testing is enabled for tests that follow a particular naming
convention (`IT*` or `*ClientTest`). Unit tests that use Mockito or EasyMock
have been excluded for the time being as they are not compatible with native
image compilation.

## Rollback plan

A rollback plan is required for all new features. The rollback plan should include:

1. How to disable this feature from the server side.
2. For features that are strictly client side, what the risks are, and what tests are done.