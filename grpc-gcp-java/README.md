# gRPC-GCP for Java

grpc-gcp provides gRPC support for Google Cloud Clients.

This module is currently used by the Google Cloud Spanner client library to provide
gRPC-GCP channel pooling and related transport behavior. It is published separately
as `com.google.cloud:grpc-gcp` because Spanner exposes grpc-gcp types in its public
API.

## Usage

Use Spanner API as an example.

First, Create a json file defining API configuration, with ChannelPoolConfig and MethodConfig.

```json
{
  "channelPool": {
    "maxSize": 3,
    "maxConcurrentStreamsLowWatermark": 0
  },
  "method": [
    {
      "name": [ "google.spanner.v1.Spanner/CreateSession" ],
      "affinity": {
        "command": "BIND",
        "affinityKey": "name"
      }
    },
    {
      "name": [ "google.spanner.v1.Spanner/GetSession" ],
      "affinity": {
        "command": "BOUND",
        "affinityKey": "name"
      }
    },
    {
      "name": [ "google.spanner.v1.Spanner/DeleteSession" ],
      "affinity": {
        "command": "UNBIND",
        "affinityKey": "name"
      }
    }
  ]
}
```

Initialize `GcpManagedChannel` based on this API config file.

```java
String API_CONFIG_FILE = "api_config_file.json"
String SPANNER_TARGET = "spanner.googleapis.com";
...

ManagedChannelBuilder delegateChannelBuilder = ManagedChannelBuilder.forAddress(SPANNER_TARGET, 443);
GcpManagedChannelBuilder gcpBuilder = 
  GcpManagedChannelBuilder.forDelegateBuilder(delegateChannelBuilder)
                          .withApiConfigJsonFile(jsonApiConfig);
ManagedChannel gcpChannel = gcpBuilder.build();
```

Create Cloud API stub using `GcpManagedChannel`.

```java
GoogleCredentials creds = getCreds();
SpannerBlockingStub stub =
    SpannerGrpc.newBlockingStub(gcpChannel)
               .withCallCredentials(MoreCallCredentials.from(creds));
```

## Build from source

Download source.

```sh
git clone https://github.com/googleapis/google-cloud-java.git && cd google-cloud-java/grpc-gcp-java
```

Build project with unit tests.

```sh
mvn verify
```

Install the jar to your local Maven repository.

```sh
mvn install
```

## Test

Setup credentials. See [Getting Started With Authentication](https://cloud.google.com/docs/authentication/getting-started) for more details.

```sh
export GOOGLE_APPLICATION_CREDENTIALS=path/to/key.json
```

```sh
export GCP_PROJECT_ID=project_id
```

Run unit tests.

```sh
mvn test
```

Integration tests are kept as source references but are not wired into the default monorepo Maven lifecycle.

## Publish

This artifact is released by the `google-cloud-java` monorepo release pipeline.

## Code Format

Run google-java-format

```sh
mvn fmt:format
```
