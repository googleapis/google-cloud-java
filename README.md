## Generating the monorepo

Built by running [bootstrap.sh](bootstrap.sh).

The script creates a new Git repository in `monorepo/google-cloud-java`.
After running the script locally, you can `cd` into the generated repository and build the project.

```shell
cd monorepo/google-cloud-java
mvn install -T C1 -B
```

To generate the coverage report, then run:
```shell
mvn jacoco:report-aggregate -T C1 -B
```
The coverage report will be in `monorepo/google-cloud-java/CoverageAggregator/target/site/jacoco-aggregate`.