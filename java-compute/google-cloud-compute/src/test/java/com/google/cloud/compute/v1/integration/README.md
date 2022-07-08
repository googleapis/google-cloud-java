## Integration tests

These tests were created to verify that compute features(Pagination, Calls, LRO) work in DIREGAPIC.

## Running Integration tests
To include integration tests when building the project, you need access to
a GCP Project with a valid service account. 

Then run the following to build, package, run all unit tests and run all
integration tests.

```bash
export GOOGLE_APPLICATION_CREDENTIALS=/path/to/service/account.json
mvn -Penable-integration-tests clean verify
```
