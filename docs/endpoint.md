# Client Library Endpoint
Google Client libraries will automatically resolve an endpoint to connect to Google Cloud services.
The default resolved endpoint will be to Google servers (i.e. `https://speech.googleapis.com:443`).

## Anatomy of an Endpoint
Using the default java-speech endpoint as an example: `https://speech.googleapis.com:443`:

| Scheme   	| Service Name 	| Universe Domain 	| Port 	|
|----------	|--------------	|-----------------	|------	|
| https:// 	| speech       	| googleapis.com  	| 443  	|

Default values for Java SDK Client libraries:
- Scheme: https://
- [Universe Domain](universe_domain.md): googleapis.com
- Port: 443

Note: Service Name does not have a default value and is different for each cloud service.

## Configuring a Specific Endpoint
There are two ways to configure the endpoint in Java Cloud Client Libraries: ServiceSettings and
TransportChannelProvider.

### (Recommended) Set through the generated {Service}Settings
The following example is using Java-KMS v2.42.0 as an example:

1. Set the endpoint in {Service}Settings.Builder and create the Settings object
```java
String endpoint = "settingsEndpoint.com";
KeyManagementServiceSettings keyManagementServiceSettings =
  KeyManagementServiceSettings.newBuilder()
    .setEndpoint(endpoint)
    .build();
```
2. Create the client with the Settings
```java
try (KeyManagementServiceClient keyManagementServiceClient =
  KeyManagementServiceClient.create(keyManagementServiceSettings)) {
  ...
}
```
The endpoint will be resolved to `settingsEndpoint.com`.

### Set through the Instantiating{Transport}ChannelProvider
The following example is using Java-KMS v2.42.0 as an example:

1. Create the transport specific TransportChannelProvider
```java
String endpoint = "transportEndpoint.com";
InstantiatingGrpcChannelProvider instantiatingGrpcChannelProvider =
    InstantiatingGrpcChannelProvider.newBuilder()
    .setEndpoint(endpoint)
    // ... Other required configurations
    .build();
```
2. Pass the TransportChannelProvider to the Settings
```java
KeyManagementServiceSettings keyManagementServiceSettings =
  KeyManagementServiceSettings.newBuilder()
    .setTransportChannelProvider(instantiatingGrpcChannelProvider)
    .build();
```
3. Create the client with the Settings
```java
try (KeyManagementServiceClient keyManagementServiceClient =
  KeyManagementServiceClient.create(keyManagementServiceSettings)) {
  ...
}
```
The endpoint will be resolved to `transportEndpoint.com`.

### Set through ServiceSettings and TransportChannelProvider
If you are setting an endpoint via both methods above, like:
```java
String endpoint1 = "transportEndpoint.com";
  InstantiatingGrpcChannelProvider instantiatingGrpcChannelProvider =
  InstantiatingGrpcChannelProvider.newBuilder()
    .setEndpoint(endpoint1)
    // ... Other required configurations
    .build();

String endpoint2 = "settingsEndpoint.com";
KeyManagementServiceSettings keyManagementServiceSettings =
  KeyManagementServiceSettings.newBuilder()
    .setEndpoint(endpoint2)
    .setTransportChannelProvider(instantiatingGrpcChannelProvider)
    .build();
```
The endpoint will be resolved to `transportEndpoint.com`.

### Endpoint Hierarchy
1. If set in the TransportChannelProvider, use this value. Otherwise, go to the next step.
2. If set via the ClientSettings, use this value. Otherwise, go to the next step.
3. Use the default endpoint (i.e. `https://{serviceName}.googleapis.com:443`)

#### How can I check which endpoint the client library is using
Assuming you have configured a custom endpoint, like:
```java
String endpoint = "...";
KeyManagementServiceSettings keyManagementServiceSettings =
  KeyManagementServiceSettings.newBuilder()
    .setEndpoint(endpoint)
    .build();
try (KeyManagementServiceClient keyManagementServiceClient = 
  KeyManagementServiceClient.create(keyManagementServiceSettings)) {
  ...
}
```

Retrieve the resolved endpoint from the Setting's `getEndpoint()` method
```java
keyManagementServiceClient.getSettings().getEndpoint();
```

## When should I specify my custom endpoint
There are a few use cases:
1. Service offers [regional endpoints](https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library) and you do not want the default endpoint.
2. Service can't use https (i.e. local testing to hit localhost)