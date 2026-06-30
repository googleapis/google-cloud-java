## Coverage Report

This module gathers aggregated jacoco test coverage metrics across the `api-common`, `gax-java` and `showcase` modules. The purpose of
the metrics is to provide insights into how much of api-common and GAX code is being exercised by showcase, GAX and api-common tests and where 
(unit tests versus integration tests). They will also assist with tracking any changes in coverage as showcase tests continue to be added to the repository.

### Unit Test Coverage
In order to view aggregate unit test coverage of api-common and GAX in `api-common`, `gax-java` and `showcase`:

1. At the root of the repository, run `mvn clean test -DenableShowcaseTestCoverage`.
2. The metrics can be found at `gapic-generator-java/coverage-report/target/site/jacoco-aggregate/index.html`

![Screenshot 2023-03-23 at 4 29 36 PM](https://user-images.githubusercontent.com/66699525/227346653-b50ec440-71f9-49f4-be21-3976c7f995c7.png)

### Integration Test Coverage

In order to view aggregate integration test coverage of api-common and GAX in `api-common`, `gax-java` and `showcase`:

1. At the root of the repository, run `mvn clean verify -DskipUnitTests -DenableShowcaseTestCoverage -Penable-integration-tests`.
2. The metrics can be found at `gapic-generator-java/coverage-report/target/site/jacoco-aggregate/index.html`

![Screenshot 2023-03-23 at 4 33 11 PM](https://user-images.githubusercontent.com/66699525/227348487-f1ba2bb8-7577-4280-a1a1-7aa78e242f12.png)