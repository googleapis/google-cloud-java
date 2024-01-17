# New Google Client Library Generation

The script allows you to create a new client library module in the
google-cloud-java monorepo.

**This tool is for repository maintainers only. Not for library users.**

## Run via Github Action

Your can generate a library by using the
[`generate_new_client.yaml` Github Action](https://github.com/googleapis/google-cloud-java/actions/workflows/generate_new_client.yaml).
This workflow runs `new-client.py` with your input arguments
and creates a pull request with the generated library.

:warning: **IMPORTANT:**
Not all the `new-client.py` arguments are available in the Github Action.
Please refer to
[this
section](https://github.com/googleapis/google-cloud-java/blob/main/generation/new_client/README.md#advanced-options)
for more arguments (it requires to setup a local environment).
The arguments currently supported by the Github Action are:
- API short Name (`api_shortname`)
- Proto path (`proto_path`)
- Name pretty (`name_pretty`)
- Product Docs (`product_docs`)
- REST Docs (`rest_docs`)
- RPC Docs (`rpc_docs`)
- API description (`api_description`)
- Transport (`transport`)
- Destination Name (`destination_name`)
- Distribution Name (`distribution_name`)

### Accessing the generated PR

The workflow automatically creates a PR for you.
Once the workflow has run successfully, you can check the action logs
and see the **last line** of the _"Push to branch and create PR"_ step to
find a link to the generated pull
request.

## Prerequisites (both for Github Action and local environment)

### Ensure no Release Please "SNAPSHOT" pull request open

Ensure google-cloud-java repository does not have [a pull request with "autorelease: snapshot" label](
https://github.com/googleapis/google-cloud-java/pulls?q=is%3Apr+is%3Aopen+label%3A%22autorelease%3A+snapshot%22).

If you find one, merge it after approving it.
This is a pull request to append "-SNAPSHOT" to versions in pom.xml files in the
repostiory. It's not for an actual release.

Background: This new client library generation process creates pom.xml files with
a "-SNAPSHOT" version. To have consistency with other modules, ensure the pom.xml files in
the repository has "-SNAPSHOT" versions too.

## Double check that the library does not already exist within `google-cloud-java`!

Some languages require a new request when a new version of a service is created, but Java manages all versions of the service as a single package, so the client library will automatically be updated to include new versions.

## Execute the Github Action

You in order to run
[Github Action](https://github.com/googleapis/google-cloud-java/actions/workflows/generate_new_client.yaml)
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
run the `new-client.py` script in your local evironment.
For the explanation of the available parameters, run:
`python3.9 generation/new_client/new-client.py generate  --help`.

:warning: **Note: The advanced options that don't appear in the previous section
cannot be specified in the
[Github Action](https://github.com/googleapis/google-cloud-java/actions/workflows/generate_new_client.yaml)
. You will have to run the script locally (refer to the "Prerequisites
(for local environment)" section below for setup instructions)
if you need to specify any of these**

### Special case example: Google Maps

Sometimes, a library generation requires special handling for
Maven coordinates or API ID, especially when the library is not
specific to Google Cloud. Refer to the following command example when we
generated Google Maps Routes API Java client library.

**Note that for `maps` clients, include `maps` as a prefix to the `api_shortname`.**

```
~/google-cloud-java$ python3.9 generation/new_client/new-client.py generate \
  --api_shortname=maps-routing \
  --proto-path=google/maps/routing \
  --name-pretty="Routes API" \
  --product-docs="https://developers.google.com/maps/documentation/routes" \
  --api-description="Routes API is the next generation, performance optimized version of the existing Directions API and Distance Matrix API. It helps you find the ideal route from A to Z, calculates ETAs and distances for matrices of origin and destination locations, and also offers new features." \
  --api-id=routes.googleapis.com \
  --cloud-api=false \
  --requires-billing=true \
  --distribution-name="com.google.maps:google-maps-routing"
```
### Example with duplicate api_short_name

Let's say you get a new library request where the Cloud Drop value for `api_short_name` is `maps-routing`.

You discover that `maps-routing` is already in use by an existing client library!

You need to determine a unique `destination_name` for the new library's subdirectory as well as a unique `distribution_name` for the artifact to be published. There is no hard and fast rule for determining a unique name, so some discussion will be necessary. Confirm the `distribution_name` with the service team on the buganizer ticket before proceeding, as this name is visible to customers as the Maven artifact name.

You will **still use** the non-unique `api_short_name` for the `api_short_name` flag. This is important because the `api_short_name` is used to derive links within cloud.google.com to enable the API.

Let's say that after some discussion, `maps-routing-gps` is selected as a suitable unique subdirectory name and `com.google.maps:google-maps-routing-gps` is selected as a suitable unique artifact name. You would then use the following command:

```
~/google-cloud-java$ python3.9 generation/new_client/new-client.py generate \
  --api_shortname=maps-routing \
  --proto-path=google/maps/routing \
  --name-pretty="Routes API" \
  --product-docs="https://developers.google.com/maps/documentation/routes" \
  --api-description="Routes API is the next generation, performance optimized version of the existing Directions API and Distance Matrix API. It helps you find the ideal route from A to Z, calculates ETAs and distances for matrices of origin and destination locations, and also offers new features." \
  --api-id=routes.googleapis.com \
  --cloud-api=false \
  --requires-billing=true \
  --distribution-name="com.google.maps:google-maps-routing-gps" \
  --destination-name="maps-routing-gps"
```

# Principles

The script should finish creating a pull request even when the newly created
module fails to compile. This gives the user flexibility to fix things in the
created pull request.

## Prerequisites (for local environment)

This section is only needed for the first _local_ run of this script. If it's already
done, go to the "Execute the workflow (either locally or via Github Action)" section.

### Environment

Use Linux environment.

Install Docker.



### Checkout google-cloud-java repository

```
$ git clone https://github.com/googleapis/google-cloud-java
$ git checkout main
$ git pull
```

### Install pyenv

Install pyenv

```
curl -L https://github.com/pyenv/pyenv-installer/raw/master/bin/pyenv-installer \
| bash
```

Append the following lines to `$HOME/.bashrc`.

```
export PYENV_ROOT="$HOME/.pyenv"
command -v pyenv >/dev/null || export PATH="$PYENV_ROOT/bin:$PATH"
eval "$(pyenv init -)"
eval "$(pyenv virtualenv-init -)"
```

Logout the shell and login again. You should be at the home directory.

Assuming you have the following folder structure:
```
~ (Home)
    -> IdeaProjects/
        -> google-cloud-java
    -> ...
```
You can run these next commands in the home directory (or IdeaProjects). Otherwise, run it at `google-cloud-java`'s parent directory.

Confirm pyenv installation succeeded:

```
~$ pyenv
pyenv 2.3.4
Usage: pyenv <command> [<args>]

Some useful pyenv commands are:
   activate    Activate virtual environment
   commands    List all available pyenv commands
   deactivate   Deactivate virtual environment
...
```

### Install Python 3.9 via pyenv

```
~$ pyenv install 3.9.13
Downloading Python-3.9.13.tar.xz...
-> https://www.python.org/ftp/python/3.9.13/Python-3.9.13.tar.xz
Installing Python-3.9.13...
WARNING: The Python sqlite3 extension was not compiled. Missing the SQLite3 lib?
Installed Python-3.9.13 to /usr/local/google/home/suztomo/.pyenv/versions/3.9.13
```

### Install Python v3.9.13 locally

Run this command

```
$ pyenv local 3.9.13
```

Confirm `python3.9` is installed:
```
$ which python3.9
/usr/local/google/home/suztomo/.pyenv/shims/python3.9
```

### Install Python packages

At the root of google-cloud-java repository clone, run:

```
$ python3.9 -m pip install -r generation/new_client/requirements.txt
```

### Install GitHub CLI (Optional)

Install the GitHub CLI and login, if needed (may help with `Common Errors` below):

```
$ sudo apt-get install gh
$ gh auth login
```

## Example arguments for local call

Run `new-client.py` with the arguments above:

```
$ python3.9 generation/new_client/new-client.py generate \
  --api_shortname=alloydb \
  --proto-path=google/cloud/alloydb \
  --name-pretty="AlloyDB API" \
  --product-docs="https://cloud.google.com/alloydb/docs" \
  --api-description="AlloyDB for PostgreSQL is an open source-compatible database service that
    provides a powerful option for migrating, modernizing, or building
    commercial-grade applications."
```

The command creates changes for
the new module in the monorepo. At the end (~ 10 minutes), it tells you to
create a pull request in the monorepo:

```
...
Please create a pull request:
  $ git checkout -b new_module_java-alloydb
  $ git add .
  $ git commit -m 'feat: [alloydb] new module for alloydb'
  $ gh pr create --title 'feat: [alloydb] new module for alloydb'
```

Create a pull request from the change.
In the description, record the `python3.9 generation/new_client/new-client.py generate ...`
command you ran above.

# Common Errors

## Unable to clone googleapis-gen
```
Creating a new module /usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java/java-vmwareengine
gcr.io/cloud-devrel-public-resources/owlbot-java:latest
Cloning googleapis-gen...
Username for 'https://github.com': xxxxxx
Password for 'https://xxxxxx@github.com': ******
remote: Support for password authentication was removed on August 13, 2021.
remote: Please see https://docs.github.com/en/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls for information on currently recommended modes of authentication.
fatal: Authentication failed for 'https://github.com/googleapis/googleapis-gen.git/'
Traceback (most recent call last):
  File "/usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java/generation/new_client/new-client.py", line 291, in <module>
    main()
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1130, in __call__
    return self.main(*args, **kwargs)
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1055, in main
    rv = self.invoke(ctx)
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1657, in invoke
    return _process_result(sub_ctx.command.invoke(sub_ctx))
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1404, in invoke
    return ctx.invoke(self.callback, **ctx.params)
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 760, in invoke
    return __callback(*args, **kwargs)
  File "/usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java/generation/new_client/new-client.py", line 180, in generate
    subprocess.check_call(["git", "clone", "-q", googleapis_gen_url, "./gen/googleapis-gen"], cwd=workdir)
  File "/usr/local/google/home/lawrenceqiu/.pyenv/versions/3.9.13/lib/python3.9/subprocess.py", line 373, in check_call
    raise CalledProcessError(retcode, cmd)
subprocess.CalledProcessError: Command '['git', 'clone', '-q', 'https://github.com/googleapis/googleapis-gen.git', './gen/googleapis-gen']' returned non-zero exit status 128.
```
### Solution
Run `gh auth login` and choose to authenticate with HTTPS. You may already be authenticated with SSH.
![img.png](img.png)

## Owl-bot Staging Directory Not Found
```
Removing googleapis-gen...
mv: cannot stat 'owl-bot-staging': No such file or directory
Traceback (most recent call last):
  File "/usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java/generation/new_client/new-client.py", line 291, in <module>
    main()
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1130, in __call__
    return self.main(*args, **kwargs)
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1055, in main
    rv = self.invoke(ctx)
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1657, in invoke
    return _process_result(sub_ctx.command.invoke(sub_ctx))
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1404, in invoke
    return ctx.invoke(self.callback, **ctx.params)
  File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 760, in invoke
    return __callback(*args, **kwargs)
  File "/usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java/generation/new_client/new-client.py", line 212, in generate
    subprocess.check_call(
  File "/usr/local/google/home/lawrenceqiu/.pyenv/versions/3.9.13/lib/python3.9/subprocess.py", line 373, in check_call
    raise CalledProcessError(retcode, cmd)
subprocess.CalledProcessError: Command '['mv', 'owl-bot-staging', '../']' returned non-zero exit status 1.
```

### Solution
The proto path is incorrect. See the `Proto Path` section to find the correct path.

## Python3.9 is not Installed
```
pyenv: version `3.9.13' is not installed (set by /workspace/.python-version)
Traceback (most recent call last):
File "/usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java/generation/new_client/new-client.py", line 291, in <module>
main()
File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1130, in __call__
return self.main(*args, **kwargs)
File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1055, in main
rv = self.invoke(ctx)
File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1657, in invoke
return _process_result(sub_ctx.command.invoke(sub_ctx))
File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 1404, in invoke
return ctx.invoke(self.callback, **ctx.params)
File "/usr/local/google/home/lawrenceqiu/.local/lib/python3.9/site-packages/click/core.py", line 760, in invoke
return __callback(*args, **kwargs)
File "/usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java/generation/new_client/new-client.py", line 223, in generate
subprocess.check_call(
File "/usr/local/google/home/lawrenceqiu/.pyenv/versions/3.9.13/lib/python3.9/subprocess.py", line 373, in check_call
raise CalledProcessError(retcode, cmd)
subprocess.CalledProcessError: Command '['docker', 'run', '--rm', '-v', '/usr/local/google/home/lawrenceqiu/IdeaProjects/google-cloud-java:/workspace', '--user', '1023638:89939', 'gcr.io/cloud-devrel-public-resources/owlbot-java']' returned non-zero exit status 1.
```

### Solution
You have run the `pyenv local 3.9.13` in the `google-cloud-java` repo.
1. Remove the `.python-version` file in `google-cloud-java`.
2. `cd ..` out to the parent directory and run `pyenv local 3.9.13` there
3. `cd google-cloud-java` back into the repo and run the generation script again
