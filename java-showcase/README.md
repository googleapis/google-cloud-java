# Showcase Integration Testing

[GAPIC Showcase](https://github.com/googleapis/gapic-showcase) is an API that demonstrates Generated
API Client (GAPIC) features and common API patterns used by Google. It follows the [Cloud APIs
design guide](https://cloud.google.com/apis/design/). `gapic-generator-java` generates a client for
the Showcase API which can communicate with a local Showcase server to perform integration tests.

## Requirements

* Install [Go](https://go.dev) in your `PATH` (version 1.20 or later).

## Installing the Server

Using the latest version of showcase is recommended, but backward compatibility between server
versions is not guaranteed. If changing the version of the server, it may also be necessary to
update to a compatible client version in `./WORKSPACE`.

```shell
# Install the showcase server version defined in gapic-showcase/pom.xml
cd java-showcase
go install github.com/googleapis/gapic-showcase/cmd/gapic-showcase@v"$(cd gapic-showcase;mvn help:evaluate -Dexpression=gapic-showcase.version -q -DforceStdout |sed 's/\x1b\[[0-9;]*m//g')"
PATH=$PATH:`go env GOPATH`/bin
gapic-showcase --help
> Root command of gapic-showcase
> 
> Usage:
>   gapic-showcase [command]
> 
> Available Commands:
>   completion  Emits bash a completion for gapic-showcase
>   compliance  This service is used to test that GAPICs...
>   echo        This service is used showcase the four main types...
>   help        Help about any command
>   identity    A simple identity service.
>   messaging   A simple messaging service that implements chat...
>   run         Runs the showcase server
>   sequence    Sub-command for Service: Sequence
>   testing     A service to facilitate running discrete sets of...
> 
> Flags:
>   -h, --help      help for gapic-showcase
>   -j, --json      Print JSON output
>   -v, --verbose   Print verbose output
>       --version   version for gapic-showcase
```

## Running the Server

Run the showcase server to allow requests to be sent to it. This opens port `:7469` to send and
receive requests.

```shell
gapic-showcase run
> 2022/11/21 16:22:15 Showcase listening on port: :7469
> 2022/11/21 16:22:15 Starting endpoint 0: gRPC endpoint
> 2022/11/21 16:22:15 Starting endpoint 1: HTTP/REST endpoint
> 2022/11/21 16:22:15 Starting endpoint multiplexer
> 2022/11/21 16:22:15 Listening for gRPC-fallback connections
> 2022/11/21 16:22:15 Listening for gRPC connections
> 2022/11/21 16:22:15 Listening for REST connections
> 2022/11/21 16:22:15 Fallback server listening on port: :1337
```

## Running the Integration Tests

Open a new terminal window in the root project directory.
This step does not require Docker.

```shell
cd java-showcase
mvn verify -P enable-integration-tests
```

## Running the Golden tests

This verify check compares the current checked-in files in `java-showcase` against a newly generated client.

### Prerequisites (One-time Setup)
Make sure you have **Go** installed and available in your `PATH` (see the [Requirements](#requirements) section), then run the following setup steps from the repository root:

```shell
# Setup and activate Python virtual environment
python -m venv .venv
source .venv/bin/activate

# Configure pip for external sources
pip config --venv set global.extra-index-url https://pypi.org/simple

# Install and configure Java tools (takes around 5 mins)
V=$(go run github.com/googleapis/librarian/cmd/librarian@latest config get version)
go run github.com/googleapis/librarian/cmd/librarian@${V} install
```

### Running the tests
Once the prerequisites are installed and the virtual environment is activated, run:

```shell
cd java-showcase
mvn verify -P enable-golden-tests
```

> [!IMPORTANT]
> The golden tests run the generator and compare the entire `java-showcase` directory against the newly generated state using `git diff`. For these tests to pass, you must have a completely clean git tree within the `java-showcase` directory before running them. Any uncommitted changes or untracked files will cause the tests to fail.

## Update the Golden Showcase Files

To regenerate the showcase library files and update them in place:

Make sure the Python virtual environment is activated, then run:

```shell
# In repository's root directory
mvn clean install -DskipTests
cd java-showcase
mvn compile -P update
```
