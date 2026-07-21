# Validate Maven BOM GitHub Action

This action validates a [Maven BOM](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#bill-of-materials-bom-poms
) specified as argument.

This action performs the following steps:

- It reads the BOM and gets all artifacts.
  - It may filter out "testlib" artifacts if they cause problems in subsequent steps
- It creates a canary Maven project (a directory with a pom.xml file) with the artifacts as the dependencies.
  The canary project uses the BOM and declares the artifacts in the BOM as dependencies.
- It runs `mvn install` in the canary project.
  If the BOM is valid, it should fetch dependencies (the artifacts in the BOM) without an error.

## Usage

You can use this action via `uses: googleapis/java-cloud-bom/tests/validate-bom@main`
in one of the steps in a job in your GitHub repository.

Note that before running this action the caller needs to make the BOM and its
listing artifacts available in Maven Central or local Maven repository.

Here is a concrete example to define a job to use this "validate-bom" action in
a GitHub Actions workflow file:

```
  validate-bom:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - uses: actions/setup-java@v3
      with:
        java-version: 11
        distribution: temurin
        cache: maven
    - name: Install Maven artifacts locally
      run: |
        mvn install -B -ntp -DskipTests
    - uses: googleapis/java-cloud-bom/tests/validate-bom@main
      with:
        path: <path_to_bom_pom.xml>
```

### Results

If there's an error in building the canary project, the check fails.
You see errors in the log:

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  14.253 s
[INFO] Finished at: 2023-04-14T20:41:59Z
[INFO] ------------------------------------------------------------------------
Error:  Failed to execute goal on project bom-validation-canary-project: Could n
ot resolve dependencies for project com.google.cloud:bom-validation-canary-proje
ct:jar:0.0.1-SNAPSHOT: The following artifacts could not be resolved: com.google
.analytics.api.grpc:grpc-google-analytics-admin-v1alpha:jar:0.24.0 ...
```

In this error message, there were invalid artifacts defined in the BOM
(wrong group IDs).

If there's no error, the check passes with a successful message:

```
[INFO] Installing /tmp/bom-validation/pom.xml to /home/runner/.m2/repository/...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.147 s
[INFO] Finished at: 2023-04-14T20:35:58Z
[INFO] ------------------------------------------------------------------------
```

# Disclaimer

This is not an official Google product.
This is intended for Google-internal usages only.
