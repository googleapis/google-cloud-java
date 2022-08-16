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

### Preparing .github/workflows directory

Once the monorepo_script_output branch is updated by monorepo.yaml, create
a pull request to rename its `.github/rename-to-workflows` to
`.github/workflows`.
This additional work is added because we cannot modify workflow
(googleapis_hermetic_sync.yaml) from another workflow (monorepo.yaml)
using the default workflow access token ([GitHub Actions permissions](
https://docs.github.com/en/actions/using-workflows/workflow-syntax-for-github-actions#permissions)).

## Note on Cutover

### Googleapis Sync (Hermetic Build)

For Day 1 cutover, once we have main branch:

- Update `googleapis_commit.txt` to an appropriate value
- Update `.github/workflows/googleapis_hermetic_sync.yaml` to point to
  the main branch.

### The BOM coverage and its version

Review the artifact name "google-cloud-gapic-bom" in the bom directory and
configure the version managed by Release Please. Ensure the BOM is part of the
entire release pipeline.

Confirm the effective-pom (`mvn help:effective-pom`) of the BOM covers the same
member of the google-cloud-bom except the handwritten libraries.
