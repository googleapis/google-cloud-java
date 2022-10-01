# Generation

## Using scripts independently

Most of the scripts in this directory can be used independently to do file updates across all modules.
They are also used and tested by `bootstrap.sh`.

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

### Input

The file `repos.txt` lists all the split repos to include in the aggregation into the monorepo.

### Output

See: [bootstrap_output](https://github.com/googleapis/google-cloud-java/tree/bootstrap_output) branch.

### Diffs

The workflow also generates a diff between the current `main` branch and the generated aggregation of modules from split repos.
See: `boostrap_outout_diff_{event}` branches.