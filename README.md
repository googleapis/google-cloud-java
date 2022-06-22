## Generating the monorepo

Built by running [bootstrap.sh](bootstrap.sh).

The script creates a new Git repository in `monorepo/google-cloud-java`.
After running the script locally, you can `cd` into the generated repository and build the project.

```shell
cd monorepo/google-cloud-java
mvn test -T C1 -B
```

To generate the coverage report, then run:
```shell
mvn jacoco:report-aggregate -T C1 -B
```
The coverage report will be in `monorepo/google-cloud-java/CoverageAggregator/target/site/jacoco-aggregate`.

## Output

See: [monorepo_script_output](https://github.com/googleapis/google-cloud-java/tree/monorepo_script_output) branch.


## Note on Cut-over

Googleapis Sync (Hermetic Build)

- Update templates/googleapis_commit.txt to an appropriate value
- Update templates/.github/workflows/googleapis_hermetic_sync.yaml to point to
  the main branch.
