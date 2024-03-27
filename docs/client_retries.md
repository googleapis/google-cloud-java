# Client Side Retries
Client Libraries use retries to handle unexpected, transient failures (i.e. server is temporarily unavailable).
Multiple attempts, hopefully, will result in a successful response from the server.

Default retry values are selected by the team operating the cloud service. These retry parameters are defined
for each RPC. A service *may* choose to only enable retries for a subset of RPCs. It is possible that for a single
service, each RPC is configured differently.

## Retry Parameters
Client libraries have two types of retry parameters to configure:
1. Retry Status Code: Set of failure status codes to retry on
2. Retry Time/ Attempt Bounds: Configurable [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings) to define the bounds

### RPC Retry Configurations
Using Java-Asset v3.41.0 as an example, the default configurations are configured in the following files:

Retry Status Codes are configured [here](https://github.com/googleapis/google-cloud-java/blob/d9da511b4b56302e509abe8b2d919a15ea7dcae7/java-asset/google-cloud-asset/src/main/java/com/google/cloud/asset/v1/stub/AssetServiceStubSettings.java#L1058-L1082)

Example:
```java
definitions.put(
  "retry_policy_1_codes",
  ImmutableSet.copyOf(
      Lists.<StatusCode.Code>newArrayList(
          StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
```

Retry parameters are configured [here](https://github.com/googleapis/google-cloud-java/blob/d9da511b4b56302e509abe8b2d919a15ea7dcae7/java-asset/google-cloud-asset/src/main/java/com/google/cloud/asset/v1/stub/AssetServiceStubSettings.java#L1086-L1155)

Example:
```java
settings =
  RetrySettings.newBuilder()
      .setInitialRpcTimeout(Duration.ofMillis(60000L))
      .setRpcTimeoutMultiplier(1.0)
      .setMaxRpcTimeout(Duration.ofMillis(60000L))
      .setTotalTimeout(Duration.ofMillis(60000L))
      .build();
```

The default configurations are mapped [here](https://github.com/googleapis/google-cloud-java/blob/d9da511b4b56302e509abe8b2d919a15ea7dcae7/java-asset/google-cloud-asset/src/main/java/com/google/cloud/asset/v1/stub/AssetServiceStubSettings.java#L1306-L1474)

Example:
```java
builder
  .exportAssetsSettings()
  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));
```

## Client Library Retry Concepts
Enabling retries allow an RPC multiple attempts to try and achieve a successful call. A successful call
is a response from a server that returns an `OK` Status Code (from gRPC) or a `2xx` Status Code (from HttpJson).

### When is an RPC retried
Take a sample RetrySettings configuration
```java
settings =
  RetrySettings.newBuilder()
      .setInitialRetryDelay(Duration.ofMillis(100L))
      .setRetryDelayMultiplier(1.3)
      .setMaxRetryDelay(Duration.ofMillis(60000L))
      .setInitialRpcTimeout(Duration.ofMillis(60000L))
      .setRpcTimeoutMultiplier(1.0)
      .setMaxRpcTimeout(Duration.ofMillis(60000L))
      .setTotalTimeout(Duration.ofMillis(60000L))
      .build();
```
The configuration above modifies the retry settings for both an RPC's operation and attempt. An RPC operation
is collection of all attempts made and an RPC attempt is the individual attempt made. A single RPC invocation will
have a single operation and one or more attempts.

Individual RPC Bounds (an attempt) are controlled by the following settings:
- setInitialRetryDelay
- setRetryDelayMultiplier
- setMaxRetryDelay
- setInitialRpcTimeout
- setRpcTimeoutMultiplier
- setMaxRpcTimeout

Total RPC Bounds (an operation) are controlled by the following settings:
- setTotalTimeout
- setAttemptCount

An RPC will be retried when _both_ of the following scenarios occur:
- Non-successful status code is received by the library and the status code is marked as retryable*
- An RPC invocation exceeds the individual RPC bounds, but still falls within total RPC bounds**

Note: If only one (or neither) of the scenarios above are true, then the RPC will not be retried.
i.e. If the total timeout has not been exceeded, but the latest attempt receives a non-retryable status code.

*The client library will check RPC's list of retryable status codes and mark a status code accordingly. 
It is marked as retryable if the response's status code matches with any of the RPC's configured retryable status
codes.

**When configuring the RPC bounds, you may configure the bounds for each attempt as well as the
total RPC's bounds. The retry algorithm will ensure that an individual attempt's bounds falls within
the total RPC's bounds.

### Jitter
Jitter is added variance via randomness to spread out when the RPCs are invoked. By default, Google Cloud
Client Libraries enable jitter for retries. When jitter is enabled with exponential backoff, the client libraries
are able to spread out the retry attempts without overwhelming the server.

The jitter randomness is computed on the retry delay. Before each attempt, the retry algorithm will compute
a random value with the between [1, RETRY_DELAY]. This computed value is the *approximate* delay before the request
is sent to the server.

For example, with the following retry configurations:
```
Initial Retry Delay: 100ms
Retry Delay Multiplier: 2.0
Max Retry Delay: 500ms
```

- Attempt 1: Random value between [1, 100]
- Attempt 2: Random value between [1, 200]
- Attempt 3: Random value between [1, 400]
- Attempt 3: Random value between [1, 500]
- ...
- Attempt X: Random value between [1, 500]

## Retry Examples
The following examples below show the behavior of some retry configurations.

Note: These examples below assume that jitter is disabled. The retry delay is computed to be the maximum value
at the end of each attempt.

### No Retry
```java
RetrySettings defaultNoRetrySettings =
    RetrySettings.newBuilder()
    // ... Other configurations do not matter
    .setTotalTimeout(Duration.ofMillis(5000L))
    // Explicitly set retries as disabled (maxAttempts == 1)
    .setMaxAttempts(1)
    .build();
```

The following table shows the attempts:

| Attempt Number 	| RPC Timeout 	| Retry Delay 	| Call Invoked 	| Call Ended 	|
|----------------	|-------------	|-------------	|--------------	|-----------	|
| 1              	| 5000ms      	| 0ms         	| 0ms          	| 5000ms    	|

### Retry
#### Example 1
```java
RetrySettings.newBuilder()
    .setInitialRetryDelay(Duration.ofMillis(200L))
    .setRetryDelayMultiplier(2.0)
    .setMaxRetryDelay(Duration.ofMillis(500L))
    .setInitialRpcTimeout(Duration.ofMillis(1500L))
    .setRpcTimeoutMultiplier(2.0)
    .setMaxRpcTimeout(Duration.ofMillis(3000L))
    .setTotalTimeout(Duration.ofMillis(5000L))
    .build();
```

The following table shows the attempts:

| Attempt Number          	| RPC Timeout 	| Retry Delay 	| Call Invoked 	| Call Ended 	|
|-------------------------	|-------------	|-------------	|--------------	|------------	|
| 1                       	| 1500ms      	| 0ms         	| 0ms          	| 1500ms     	|
| 2 (Retry)               	| 3000ms      	| 200ms       	| 1700ms       	| 4700ms     	|
| 3 (Retry Not Attempted) 	| -           	| 400ms       	| -            	| -          	|

The third retry attempt is not attempted because the computed retry delay (400ms) would invoke the after
the total timeout (400 + 4700 > 5000).

#### Example 2
This example is similar to Example #1, but has a longer total timeout to showcase an additional
retry attempt and the capped RPC Timeout for the last retry attempt.
```java
RetrySettings.newBuilder()
    .setInitialRetryDelay(Duration.ofMillis(200L))
    .setRetryDelayMultiplier(2.0)
    .setMaxRetryDelay(Duration.ofMillis(500L))
    .setInitialRpcTimeout(Duration.ofMillis(1500L))
    .setRpcTimeoutMultiplier(2.0)
    .setMaxRpcTimeout(Duration.ofMillis(3000L))
    .setTotalTimeout(Duration.ofMillis(10000L))
    .build();
```

The following table shows the attempts:

| Attempt Number 	| RPC Timeout 	| Retry Delay 	| Call Invoked 	| Call Ended 	|
|----------------	|-------------	|-------------	|--------------	|------------	|
| 1              	| 1500ms      	| 0ms         	| 0ms          	| 1500ms     	|
| 2 (Retry)      	| 3000ms      	| 200ms       	| 1700ms       	| 4700ms     	|
| 3 (Retry)      	| 4900ms      	| 400ms       	| 5100ms       	| 10000ms    	|

The third retry’s RPC Timeout value is limited due the Total Timeout value. Using the multiplier (2.0) with the
previous timeout value (3000ms) should result in an RPC Timeout of 6000ms. However, the RPC Timeout should not
exceed the Total Timeout and is reduced to be the "time left" (10000 - 5100 = 4900).

#### Example 3
```java
RetrySettings defaultRetrySettings =
    RetrySettings.newBuilder()
        .setInitialRetryDelay(Duration.ofMillis(200L))
        .setRetryDelayMultiplier(2.0)
        .setMaxRetryDelay(Duration.ofMillis(500L))
        .setInitialRpcTimeout(Duration.ofMillis(500L))
        .setRpcTimeoutMultiplier(2.0)
        .setMaxRpcTimeout(Duration.ofMillis(2000L))
        .setTotalTimeout(Duration.ofMillis(4000L))
        .build();
```

The following table shows the attempts:

| Attempt Number 	| RPC Timeout 	| Retry Delay 	| Call Invoked 	| Call Ended 	|
|----------------	|-------------	|-------------	|--------------	|------------	|
| 1              	| 500ms       	| 0ms         	| 0ms          	| 500ms      	|
| 2 (Retry)      	| 1000ms      	| 200ms       	| 700ms        	| 1700ms     	|
| 3 (Retry)      	| 1900ms      	| 400ms       	| 2100ms       	| 4000ms     	|

Another example where the RPC Timeout is capped to not exceed the total timeout.

## How to configure a custom retry configuration for an RPC
1. Create the RetrySettings class with your custom configurations
```java
RetrySettings customRetrySettings =
  RetrySettings.newBuilder()
      // ... Retry Configurations
      .build();
```
2. Create the StubSettings.Builder for your client and configure it for the RPC
```java
AssetServiceStubSettings.Builder assetStubSettingsBuilder = AssetServiceStubSettings.newBuilder();
assetStubSettingsBuilder
  .exportAssetsSettings()
  // Set your custom Retry Settings
  .setRetrySettings(customRetrySettings)
  // Set your custom Retryable Codes
  .setRetryableCodes(ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));
```

The example above is configuring the java-asset library. The code snippet above is setting custom
retry configurations for AssetServiceClient's ExportAssets RPC. It configures the ExportAssets RPC
to use the retry settings configured in `customRetrySettings` and sets the retryable codes to be
`DEADLINE_EXCEEDED`.

3. Create the Settings for the Client
```java
AssetServiceSettings assetSettings = AssetServiceSettings.create(assetStubSettingsBuilder.build());
```
4.Create the Client with the Settings
```java
try (AssetServiceClient assetClient = AssetServiceClient.create(assetSettings)) {
  ...
}
```

Repeat Step #2 for each RPC that you want to configure. For example:
```java
AssetServiceStubSettings.Builder assetStubSettingsBuilder = AssetServiceStubSettings.newBuilder();
  
// Modify the retry params for ExportAssets RPC
assetStubSettingsBuilder
.exportAssetsSettings()
.setRetrySettings(customRetrySettings)
.setRetryableCodes(ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));

// Modify the retry params for ListAssets RPC
assetStubSettingsBuilder
.listAssetsSettings()
.setRetrySettings(customRetrySettings2)
.setRetryableCodes(ImmutableSet.of(StatusCode.Code.UNAVAILABLE));
```