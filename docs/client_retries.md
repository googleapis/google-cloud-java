# Client Side Retries
Client Libraries use retries to handle unexpected, transient failures (i.e. server is temporarily unavailable).
Multiple attempts, hopefully, will result in a successful response from the server.

Default retry values are selected by the team operating the cloud service. These retry values are configured
per RPC. A service *may* choose to only enable retries for a subset of RPCs. It is possible that each RPC for
a service is configured differently.

## Retry Parameters
Client libraries have two types of retry parameters to configure:
1. Retry Status Code: Set of status codes to retry on
2. Retry Timeout/ Attempt Bounds: Configurable [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings) to define the bounds

### Default RPC Retry Configuration Location
The default retry configurations are defined in the generated `{Client}StubSettings` file. Using the ExportAssets RPC in
Java-Asset v3.41.0 as an example, the default retry configurations are defined in the following places:
<br>
- Retry Status Codes are configured [here](https://github.com/googleapis/google-cloud-java/blob/d9da511b4b56302e509abe8b2d919a15ea7dcae7/java-asset/google-cloud-asset/src/main/java/com/google/cloud/asset/v1/stub/AssetServiceStubSettings.java#L1058-L1082). Example:
    ```java
    ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions = ImmutableMap.builder();
    definitions.put("no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
    // ... More StatusCode configurations
    RETRYABLE_CODE_DEFINITIONS = definitions.build();
    ```

- Retry parameters are configured [here](https://github.com/googleapis/google-cloud-java/blob/d9da511b4b56302e509abe8b2d919a15ea7dcae7/java-asset/google-cloud-asset/src/main/java/com/google/cloud/asset/v1/stub/AssetServiceStubSettings.java#L1086-L1155). Example:
    ```java
    ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
    RetrySettings settings = null;
    settings =
        RetrySettings.newBuilder()
        .setInitialRpcTimeout(Duration.ofMillis(60000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeout(Duration.ofMillis(60000L))
        .setTotalTimeout(Duration.ofMillis(60000L))
        .build();
    definitions.put("no_retry_0_params", settings);
    // ... More RetrySettings configurations
    RETRY_PARAM_DEFINITIONS = definitions.build();
    ```

- The configurations above are mapped to the RPC [here](https://github.com/googleapis/google-cloud-java/blob/d9da511b4b56302e509abe8b2d919a15ea7dcae7/java-asset/google-cloud-asset/src/main/java/com/google/cloud/asset/v1/stub/AssetServiceStubSettings.java#L1306-L1474). Example:
    ```java
    builder
      .exportAssetsSettings()
      .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
      .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));
    ```

## Client Library Retry Concepts
Enabling retries allow an RPC multiple attempts to try and achieve a successful call. A successful call
is a response from a server that returns an `OK` Status Code (from gRPC) or a `2xx` Status Code (from HttpJson).

### Attempt vs Operation
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
The configuration above modifies the retry settings for both an RPC's attempt and operation. An RPC attempt is the
individual attempt made and an RPC operation is collection of all attempts made. A single RPC invocation will
have one or more attempts in a single operation.

Individual RPC Bounds (an attempt) are controlled by the following settings:
- [setInitialRetryDelay](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setInitialRetryDelay_org_threeten_bp_Duration_): Delay before the first attempt
- [setRetryDelayMultiplier](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setRetryDelayMultiplier_double_) - Delay multiplier applied between each attempt
- [setMaxRetryDelay](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setMaxRetryDelay_org_threeten_bp_Duration_) - Max Delay possible for an attempt
- [setInitialRpcTimeout](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setInitialRpcTimeout_org_threeten_bp_Duration_) - Timeout for the first attempt
- [setRpcTimeoutMultiplier](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setRpcTimeoutMultiplier_double_) - Timeout multiplier applied between each attempt
- [setMaxRpcTimeout](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setMaxRpcTimeout_org_threeten_bp_Duration_) - Max Timeout possible for an attempt

Total RPC Bounds (an operation) are controlled by the following settings:
- [setTotalTimeout](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setTotalTimeout_org_threeten_bp_Duration_) - Total timeout allowed the entire operation
- [setMaxAttempts](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings.Builder#com_google_api_gax_retrying_RetrySettings_Builder_setMaxAttempts_int_) - Max number of attempts allowed

### When is an RPC retried
An RPC will be retried when _both_ of the following scenarios occur:
- Non-successful status code is received by the library and the status code is marked as retryable*
- An RPC invocation exceeds the individual RPC bounds, but still falls within total RPC bounds**

Note: If only one (or neither) of the scenarios above are true, then the RPC will _NOT_ be retried.
i.e. If the total timeout has not been exceeded, but the latest attempt receives a non-retryable status code.

*The client library will check RPC's list of retryable status codes and mark a status code accordingly. 
It is marked as retryable if the response's status code matches with any of the RPC's configured retryable status
codes.

**When configuring the RPC bounds, you may configure the bounds for each attempt as well as the
total RPC's bounds. The retry algorithm will ensure that an individual attempt's bounds falls within
the total RPC's bounds.

### Exponential Backoff
Exponential backoff will retry requests with an increasing delay between each retry attempt. This retry delay value
can be capped with a maximum retry delay value.

For example, the following retry configurations may result in the following delay times:
```
Initial Retry Delay: 100ms
Retry Delay Multiplier: 2.0
Max Retry Delay: 500ms
```
- Attempt 1: Delay 100ms
- Attempt 2: Delay 200ms
- Attempt 3: Delay 400ms
- Attempt 4: Delay 500ms
- ...
- Attempt X: Delay 500ms

Note: The example above is configured to retry indefinitely. Do set an RPC operation cap by setting the TotalTimeout
and/or MaxAttempts value.

### Jitter
Jitter is added variance via randomness to spread out when the RPCs are invoked. Google Cloud Client Libraries 
always enable jitter for retries. This is to help spread out the retry attempts without overwhelming the server.

The jitter random value is computed as the retry delay. Before each attempt, the retry algorithm will compute a random
value between `[1, RETRY_DELAY]`. This computed value is the *approximate* delay before the request is sent to the
server.

For example, the following retry configurations utilizes Jitter and Exponential Backoff, which may result in the
following delays times:
```
Initial Retry Delay: 100ms
Retry Delay Multiplier: 2.0
Max Retry Delay: 500ms
```
- Attempt 1: Delay a random value between `[1, 100]`ms
- Attempt 2: Delay a random value between `[1, 200]`ms
- Attempt 3: Delay a random value between `[1, 400]`ms
- Attempt 4: Delay a random value between `[1, 500]`ms
- ...
- Attempt X: Delay a random value between `[1, 500]`ms

Note: The example above is configured to retry indefinitely. Do set an RPC operation cap by setting the TotalTimeout
and/or MaxAttempts value.

## Retry Examples
The following examples below show the behavior of some retry configurations.
<br>
Note: These examples below assume that jitter is disabled. The retry delay is computed to be the attempt's maximum
value at the end of each attempt.

### No Retry
```java
RetrySettings defaultNoRetrySettings =
    RetrySettings.newBuilder()
    // Use the default configurations for other settings
    .setTotalTimeout(Duration.ofMillis(5000L))
    // Explicitly set retries as disabled (maxAttempts == 1)
    .setMaxAttempts(1)
    .build();
```
Alternatively, this same behavior can be configured with
```java
RetrySettings defaultNoRetrySettings =
    RetrySettings.newBuilder()
    .setLogicalTimeout(Duration.ofMillis(5000L))
    .build();
```

The following table shows the attempts:

| Attempt Number 	| RPC Timeout 	| Retry Delay 	| Call Invoked 	| Call Ended 	|
|----------------	|-------------	|-------------	|--------------	|-----------	|
| 1              	| 5000ms      	| 0ms         	| 0ms          	| 5000ms    	|

### Retry Examples
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
The third retry attempt is not attempted because the computed retry delay (400ms) would invoke the
RPC after the total timeout (400 + 4700 > 5000). The RPC will return a failure message after 4700ms.

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

## How to configure a custom retry parameters for an RPC
The following example is using the Java-Asset client library:

1. Create the RetrySettings class with your custom configurations
```java
RetrySettings customRetrySettings =
  RetrySettings.newBuilder()
    // ... Retry Configurations
    .build();
RetrySettings customRetrySettings2 =
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
The code snippet above is setting custom retry configurations for AssetServiceClient's ExportAssets
RPC. It configures the ExportAssets RPC to use the retry settings configured in `customRetrySettings`
and sets the retryable codes to be `DEADLINE_EXCEEDED`.

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

## FAQ
### I expected X retry attempts, but it attempted Y times
Unless you explicitly specify the number of max attempts (along with disabling the timeout configurations),
you may not consistently see the same number of retry attempts made. [Jitter's](#jitter) random values for 
RPC delay make it difficult predict when the request is actually sent.

### The RPC returned a failure before the Total Timeout value was reached
The retry algorithm will calculate the jittered retry delay value during each retry attempt. The calculated
retry delay will be scheduled to run in the future (i.e. `currentTime() + jitteredRetryDelay`). If that attempt's
scheduled attempt time exceeds the total timeout, the "final" retry attempt will not be made.

See this [example](#example-1) as an example of this behavior.

### I configured custom settings and am seeing quota issues
You may have configured the RetrySettings to run too aggressively. The default retry values are chosen by
the team operation the service. 

Consider increasing the retry delay (initial retry delay and retry multiplier) so that the retry attempts 
are spaced out and less frequent. Note that this *may* result in a slower response.

Your use case may require a quicker response and/or more frequent retry attempts. If that is the case, try to
increase the quota limits.