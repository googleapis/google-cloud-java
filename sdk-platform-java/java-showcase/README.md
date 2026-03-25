# Showcase Integration Testing

[GAPIC Showcase](https://github.com/googleapis/gapic-showcase) is an API that demonstrates Generated
API Client (GAPIC) features and common API patterns used by Google. It follows the [Cloud APIs
design guide](https://cloud.google.com/apis/design/). `gapic-generator-java` generates a client for
the Showcase API which can communicate with a local Showcase server to perform integration tests.

## Requirements

* Install [Go](https://go.dev) in your `PATH`.

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

**NOTE** This requires Docker to be installed in your machine.
Open a new terminal window in the root project directory.

```shell
cd java-showcase
mvn verify -P enable-golden-tests
```


## Update the Golden Showcase Files

**NOTE** This requires Docker to be installed in your machine.
Open a new terminal window in the root project directory.

```shell
# In repository's root directory
mvn clean install -DskipTests
cd java-showcase
mvn compile -P update
```
