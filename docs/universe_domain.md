# Universe Domain
See [Anatomy of an Endpoint](endpoint.md#anatomy-of-an-endpoint) for more information about how the Universe Domain is used
as part of an endpoint.

Universe Domain default value: `googleapis.com`. This is known as the Google Default
Universe (GDU). If the Universe Domain value is not specified, the GDU value is used.

## Configuring a Specific Universe Domain
There are two ways to configure the endpoint in Java Client Libraries: ServiceSettings and
Environment Variable.

### Set through the generated {Service}Settings
Configuring the Universe Domain is done via the generated {Service}Settings. The following example
is using Java-KMS v2.42.0 as an example:

1. Set the endpoint in {Service}Settings.Builder and create the Settings object
```java
String universeDomain = "myUniverseDomain.com";
KeyManagementServiceSettings keyManagementServiceSettings =
  KeyManagementServiceSettings.newBuilder()
    .setUniverseDomain(universeDomain).build();
```
2. Create the client with the Settings
```java
try (KeyManagementServiceClient keyManagementServiceClient =
  KeyManagementServiceClient.create(keyManagementServiceSettings)) {
  ...
}
```

With this configuration, the client library will resolve the endpoint to be:
`https://cloudkms.myUniverseDomain.com:443`.

### Set through an Environment Variable
Set the Universe Domain to the `GOOGLE_CLOUD_UNIVERSE_DOMAIN`. If set, Java client libraries
use this value.

### Universe Domain Hierarchy
1. If set in the ClientSettings, use this value. Otherwise, go to the next step.
2. If set via the Environment Variable, use this value. Otherwise, go to the next step.
3. Use the GDU value (i.e Universe Domain is set to be `googleapis.com`)

### Configuring a Specific Universe Domain and a Custom Endpoint
The following example is using Java-KMS v2.42.0 as an example:

1. Set the endpoint in {Service}Settings.Builder and create the Settings object
```java
String endpoint = "settingsEndpoint.com:443";
String universeDomain = "universeDomain.com";
KeyManagementServiceSettings keyManagementServiceSettings =
  KeyManagementServiceSettings.newBuilder()
    .setEndpoint(endpoint)
    .setUniverseDomain(universeDomain)
    .build();
```

- The resolved endpoint is: `settingsEndpoint.com:443`
- The resolved Universe Domain is: `universeDomain.com`

The custom set endpoint triumphs over any other configurations.

### How can I confirm the universe domain the library is using
Assuming you have configured a custom endpoint, like:
```java
String universeDomain = "...";
KeyManagementServiceSettings keyManagementServiceSettings =
  KeyManagementServiceSettings.newBuilder()
    .setUniverseDomain(universeDomain)
    .build();
try (KeyManagementServiceClient keyManagementServiceClient =
  KeyManagementServiceClient.create(keyManagementServiceSettings)) {
  ...
}
```

Retrieve the endpoint from the Setting's `getUniverseDomain()` method.
```java
keyManagementServiceClient.getSettings().getUniverseDomain();
```

## Universe Domain Compatibility with
### ... DirectPath
Currently, DirectPath code only works in the GDU. If the Universe Domain is configured to not be in the
GDU, DirectPath will not be used.
### ... GDC-H
Universe Domain is incompatible with [GDC-H](https://cloud.google.com/distributed-cloud/hosted/docs/latest/gdch/overview).
Do not set the Universe Domain if you are using GDC-H Credentials.