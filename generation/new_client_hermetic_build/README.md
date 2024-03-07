# New client generation (Workflow)
This new generation workflow enables generation of new libraries by
 - appending a new library to our [generation_config.yaml](https://github.com/googleapis/google-cloud-java/blob/c7429c0eec419c01d4e2fe14d063b9335efb810b/generation_config.yaml).
 - running the hermetic build scripts docker image and
 generate the newly added library.
 - create a PR with the changes.


## Components
### `new_library_hermetic_build/new-client.py`
This script takes 10 arguments that map to items in the newly added library that
goes in `generation_config.yaml`. A new entry will be added to `libraries` with
the necessary generation configuration.

### `.github/workflows/generate_new_client_hermetic_build.yaml`
This workflow orchestrates the `new-client.py` script and also uses our docker
image
([gcr.io/cloud-devrel-public-resources/java-library-generation](https://pantheon.corp.google.com/gcr/images/cloud-devrel-public-resources/global/java-library-generation))
to generate a new library. It also creates the pull request.


## Execute the Github Action

You in order to run the
[Github Action](https://github.com/googleapis/google-cloud-java/actions/workflows/generate_new_client_hermetic_build.yaml)
, you need to specify a few parameters.
These parameters will be available in the Cloud Drop link (a YAML file) included in the buganizer request.
The example in this README uses AlloyDB's [Cloud Drop](https://github.com/googleapis/googleapis/blob/master/google/cloud/alloydb/v1/alloydb_v1.yaml) file as an example.

### API short name (`api_shortname`)

For convenience of the subsequent commands, define a variable for API short name.
This value will be used by default to generate the following:
* `--distribution-name`
* `--destination-name`

The corresponding value in the Cloud Drop page is `api_short_name`.

Example: `alloydb`

> [!IMPORTANT]
> `api_short_name` is not always unique across client libraries.
> In the instance that the `api_short_name` is already in use by an existing client library, you will need to determine a unique name.
> See example under [Advanced Options](#Example with duplicate api_short_name).

### Proto path (`proto_path`)

The script takes "proto path" parameter. This is the path from the internal `google3/third_party/googleapis/stable` root to the
directory that contains versions (e.g., "v1" or "v2").
Note that the internal `google3/third_party/googleapis/stable` directory is mirrored externally in https://github.com/googleapis/googleapis/blob/master/.

For example, if the buganizer ticket includes:

> Link to protos: `http://...(omit).../google/cloud/alloydb/v1alpha/alloydb_v1alpha.yaml`.

then the corresponding external mirrored proto is here: https://github.com/googleapis/googleapis/blob/master/google/cloud/alloydb/v1alpha/alloydb_v1alpha.yaml.

Therefore, the "proto path" value we supply to the command is `google/cloud/alloydb`.

We will publish a single module for a service that includes all versions in this path. Once the service has been published once, any future additional versions will automatically be generated via OwlBot.

### Name pretty (`name_pretty`)

The corresponding value in the Cloud Drop page is `title`.

Example: `AlloyDB API`

### Product Docs (`product_docs`)

The corresponding value in the Cloud Drop page is `documentation_uri`.
The value must starts with "https://".

Example: `https://cloud.google.com/alloydb/docs`

### REST Docs (`rest_docs`)

The corresponding value in the Cloud Drop page is `rest_reference_documentation_uri`.
The value must starts with "https://".

Example: `https://cloud.google.com/alloydb/docs/reference/rest`

If they exist, add them as a flag to the python command below like:
`--rest-docs="https://cloud.google.com/alloydb/docs/reference/rest" \`

### RPC Docs (`rpc_docs`)

The corresponding value in the Cloud Drop page is `proto_reference_documentation_uri`.
The value must starts with "https://".

Example: `https://cloud.google.com/speech-to-text/docs/reference/rpc`

If they exist, add them as a flag to the python command below like:
`--rpc-docs="https://cloud.google.com/speech-to-text/docs/reference/rpc" \`

### API description (`api_description`)

The corresponding value in the Cloud Drop page is `documentation.summary` or `documentation.overview`.
If both of those fields are missing, take the description from the product page above. Use the first sentence to keep it concise.

Example:
``` 
    AlloyDB for PostgreSQL is an open source-compatible database service that
    provides a powerful option for migrating, modernizing, or building
    commercial-grade applications.
 ```

### Transport (`transport`)

This variable represents the type of requests the library will make to
its corresponding service. It can be `grpc` (default), `http` or `both`. In
practice, it is mainly used to create a `.repo-metadata.json` file.

### Destination Name (`destination_name`)

This variable represents the folder name to be created in the root of the
monorepo. For example, if it is `java-example-library`, then a new folder
with the generated library will be created in
`google-cloud-java/java-example/library`.

### Distribution Name (`distribution_name`)

This variable determines the Maven coordinates of the generated library. It
defaults to `com.google.cloud:google-cloud-{api_shortname}`. This mainly affect
the values in the generated `pom.xml` files.

## Advanced Options

In case the steps above don't show you how to specify the desired options, you can
run the `new-client.py` script in your local evironment. The advanced options
not shown in the section above **cannot be specified in the Github Action**,
hence the need for a local run (refer to the "Prerequisites
(for local environment)" section).
For the explanation of the available parameters, run:
`python3.9 generation/new_client_hermetic_build/new-client.py generate  --help`.

After you run the script, you will see that the `generation_config.yaml` file
was modified (or the script exited because the library already existed)

The last step you need is to `cd` into the root of `google-cloud-java` and run
```
api_shortname=<the api shortname you used>
repo_volumes="-v repo-google-cloud-java:/workspace/google-cloud-java"
docker run --rm \
  ${repo_volumes} \
  -v /tmp:/tmp \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -e "RUNNING_IN_DOCKER=true" \
  -e "REPO_BINDING_VOLUMES=${repo_volumes}" \
  gcr.io/cloud-devrel-public-resources/java-library-generation:latest \
  python /src/generate_repo.py generate \
  --generation-config-yaml=/workspace/google-cloud-java/generation_config.yaml \
  --repository-path=/workspace/google-cloud-java \
  --target-library-api-shortname=${api_shortname}

```

This docker container will run the generation scripts and generate the library
in your repo. You can create a PR explaining what commands you used (the docker
command is not as informative as the `new-client.py` call, so make sure at least
the new-client arguments were listed.
