# Developer Guide: Using the Java Showcase Library for Local Server Testing

## Overview

The [GAPIC Showcase](https://github.com/googleapis/gapic-showcase) library and server framework demonstrate Generated API Client (GAPIC) features and standard Cloud API design patterns (following the [Cloud APIs Design Guide](https://cloud.google.com/apis/design/)). 

For developers building, debugging, or enhancing Google Cloud Java client library features, **Showcase provides a fast, offline, dependency-free mock server environment** that simulates standard APIs—such as `Echo`, `Identity`, `Messaging`, `Sequence`, `Compliance`, and `Testing`—without needing active GCP credentials or real network infrastructure.

> [!NOTE]
> For instructions on installing the `gapic-showcase` server binary, running standard plaintext verification tests, and generating/updating golden Showcase files, please refer to the primary **[Showcase README](../java-showcase/README.md)**.
>
> This developer guide focuses specifically on **programmatically instantiating and configuring Java client instances (`EchoClient`, `IdentityClient`, etc.) in unit/integration test code**, testing **gRPC** and **HTTP/REST (HttpJson)** transport modes, and verifying **channel pool lifecycle and dynamic certificate rotation**.

---

## 1. Local Server Startup Modes

While standard offline testing uses the default plaintext server (`gapic-showcase run` on port `:7469`, as documented in [java-showcase/README.md](../java-showcase/README.md#running-the-server)), verifying dynamic certificate rotation or TLS-protected endpoints requires starting a server instance in TLS mode.

### Secure TLS Server Mode (for mTLS & Cert Rotation Testing)

To test features requiring secure TLS connections or dynamic certificate loading, start a secondary Showcase server instance with `--tls`:

```bash
gapic-showcase run \
  --port 7470 \
  --tls \
  --ca-cert-output-file /tmp/showcase-ca.pem
```

> [!IMPORTANT]
> **No manual certificate generation (`openssl`) is required!**
> When `--tls` is specified, the `gapic-showcase` server **automatically generates** a self-signed root CA certificate on startup and writes it to the output path specified by `--ca-cert-output-file` (`/tmp/showcase-ca.pem`). Client test suites can read this dynamically generated file to populate custom trust stores.

> [!TIP]
> When executing integration tests in CI pipelines, wait deterministically for the local server port to bind and the CA certificate to be written before launching client initialization:
> ```bash
> for i in $(seq 1 30); do
>   if (echo > /dev/tcp/127.0.0.1/7470) 2>/dev/null && [ -f /tmp/showcase-ca.pem ]; then
>     break
>   fi
>   sleep 0.2
> done
> ```

---

## 2. Programmatic Java Client Setup

Because standard Google Cloud Java clients default to production cloud endpoints and Application Default Credentials (ADC), writing code to test against a local server requires explicitly configuring three client settings:
1. **Credentials**: Disable cloud authorization lookup via `NoCredentialsProvider.create()`.
2. **Endpoint**: Point client settings to `localhost:7469` (for gRPC) or `http://localhost:7469` (for HTTP/JSON).
3. **Transport Configuration**: Configure plaintext gRPC channels or disable TLS cert checking for local HTTP testing.

Reference implementation helper: [`TestClientInitializer.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/util/TestClientInitializer.java).

### 2.1 gRPC Plaintext Connection (`EchoClient`)

```java
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoSettings;
import io.grpc.ManagedChannelBuilder;

public class ShowcaseGrpcClientExample {
  public static EchoClient createLocalGrpcEchoClient() throws Exception {
    EchoSettings settings =
        EchoSettings.newBuilder()
            // 1. Disable Google auth header requirements for local server
            .setCredentialsProvider(NoCredentialsProvider.create())
            // 2. Configure plaintext channel over gRPC
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            // 3. Point to local gRPC port (format: {host}:{port})
            .setEndpoint("localhost:7469")
            .build();

    return EchoClient.create(settings);
  }
}
```

> [!IMPORTANT]
> For gRPC transport, `.setEndpoint(...)` expects the string format `"host:port"` without any protocol scheme prefix (`http://` or `https://`).

---

### 2.2 HTTP / REST (`HttpJson`) Connection (`EchoClient`)

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoSettings;

public class ShowcaseRestClientExample {
  public static EchoClient createLocalHttpJsonEchoClient() throws Exception {
    EchoSettings settings =
        EchoSettings.newHttpJsonBuilder()
            // 1. Disable Google auth header requirements
            .setCredentialsProvider(NoCredentialsProvider.create())
            // 2. Disable SSL certificate validation for HTTP/JSON testing
            .setTransportChannelProvider(
                EchoSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint("http://localhost:7469")
                    .build())
            .build();

    return EchoClient.create(settings);
  }
}
```

> [!TIP]
> Notice that `HttpJson` settings explicitly use **`EchoSettings.newHttpJsonBuilder()`** and specify the `http://` prefix in `"http://localhost:7469"`. Without `http://`, GAX defaults to HTTPS and connection attempts will fail with SSL handshake errors against the local plaintext endpoint.

---

## 3. Key Testing Capabilities & Examples

The Java Showcase package ([`com.google.showcase.v1beta1`](../java-showcase/gapic-showcase/src/main/java/com/google/showcase/v1beta1/)) exposes several specialized services for exercising SDK features:

### 3.1 Core RPC Service Matrix

| Service Client | Target Test Domain | Notable Local Integration Tests |
| :--- | :--- | :--- |
| `EchoClient` | Unary RPCs, Server/Client/Bidi Streaming, Error injection, Deadlines, LROs | [`ITUnaryCallable.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITUnaryCallable.java), [`ITLongRunningOperation.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITLongRunningOperation.java) |
| `IdentityClient` | Resource names (`users/{user}`, `tenants/{tenant}`), IAM policy methods | [`ITCrud.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITCrud.java), [`ITIam.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITIam.java) |
| `MessagingClient` | Pagination, dynamic routing headers, field masks | [`ITPagination.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITPagination.java), [`ITDynamicRoutingHeaders.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITDynamicRoutingHeaders.java) |
| `ComplianceClient` | Complex HTTP/REST binding rules (query params, body fields, verb mapping) | [`ComplianceClientTest.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/ComplianceClientTest.java) |
| `SequenceServiceClient` | Custom retry curves, backoff validation, golden metric verification | [`SequenceServiceClientTest.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/SequenceServiceClientTest.java) |

---

### 3.2 Infrastructure & Transport Verification Examples

In addition to core functional API tests, developers use local Showcase and mTLS servers to verify SDK transport lifecycle and infrastructure stability under simulated production conditions.

#### Example A: OpenTelemetry & Structured Logging Verification
To verify that metrics, trace contexts, and SLF4J MDC attributes (such as `request.url` or RPC service names) propagate correctly across GAX call chains, supply a custom `ApiTracerFactory` when instantiating showcase clients (see reference test in [`ITOtelMetrics.java`](../java-showcase/gapic-showcase/src/test/java/com/google/showcase/v1beta1/it/ITOtelMetrics.java)):

```java
EchoSettings.Builder settingsBuilder =
    EchoSettings.newBuilder()
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setEndpoint("localhost:7469");

// Attach a custom OpenTelemetry ApiTracerFactory directly to the stub settings builder
settingsBuilder.getStubSettingsBuilder().setTracerFactory(openTelemetryTracerFactory);

EchoClient client = EchoClient.create(settingsBuilder.build());
```

#### Example B: Channel Pool Refresh & Dynamic Certificate Rotation
A critical resilience capability in GAX is **dynamic mTLS certificate rotation** without channel downtime. In enterprise environments (e.g. SPIFFE / Workload Identity certificates managed by [`WorkloadCertificateUtils`](../sdk-platform-java/gax-java/gax/src/main/java/com/google/api/gax/rpc/mtls/WorkloadCertificateUtils.java)), client certificates expire and are periodically rotated on disk. 

To ensure applications do not drop connections when certificates rotate:
* **gRPC Channel Pools (`ChannelPool`)**: Track client certificate fingerprints via [`CertificateBasedAccess`](../sdk-platform-java/gax-java/gax/src/main/java/com/google/api/gax/rpc/mtls/CertificateBasedAccess.java). When fingerprint changes are detected, pooled connections in [`InstantiatingGrpcChannelProvider`](../sdk-platform-java/gax-java/gax-grpc/src/main/java/com/google/api/gax/grpc/InstantiatingGrpcChannelProvider.java) are gracefully replaced.
* **HTTP/REST Channels (`RefreshingHttpJsonChannel`)**: Dynamically refresh underlying `NetHttpTransport` and `SSLContext` engines upon fingerprint rotation.
* **Transparent Retry Loop (`AttemptCallable`)**: If a dynamic certificate rotation occurs during a handoff causing a transient `401` / `UNAUTHENTICATED` error, GAX's [`ApiResultRetryAlgorithm`](../sdk-platform-java/gax-java/gax/src/main/java/com/google/api/gax/rpc/ApiResultRetryAlgorithm.java) transparently retries the RPC over the refreshed pool.

**Local Verification Pattern**:
To verify whether channel pools cleanly update SSL/TLS contexts during rotation using a local server (see reference test pattern in [`MtlsCertRotationIntegrationTest.java`](../google-auth-library-java/oauth2_http/javatests/com/google/auth/oauth2/MtlsCertRotationIntegrationTest.java)):

1. Configure a multi-channel `ChannelPool` pointed at a local mTLS-enabled test endpoint:
   ```java
   InstantiatingGrpcChannelProvider transportProvider =
       EchoSettings.defaultGrpcTransportProviderBuilder()
           .setChannelPoolSettings(
               ChannelPoolSettings.newBuilder()
                   .setInitialChannelCount(4)
                   .build())
           .setEndpoint("localhost:7470")
           .build();
   ```
2. Warm up the channel pool by firing RPCs across all 4 channels.
3. Overwrite / update the client certificate and key files on disk (simulating Workload Identity rotation).
4. Issue subsequent RPCs across the pool and verify that:
   - Existing pooled channels refresh their TLS fingerprints automatically.
   - All subsequent calls complete with status `OK` without certificate validation failures.

---

## 4. Complete JUnit 5 Integration Test Recipe

Here is a full, self-contained JUnit 5 integration test demonstrating client lifecycle and assertions against a local Showcase server:

```java
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.rpc.Status;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.EchoSettings;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocalShowcaseIntegrationTest {

  private EchoClient echoClient;

  @BeforeEach
  public void setUp() throws Exception {
    EchoSettings settings =
        EchoSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                EchoSettings.defaultGrpcTransportProviderBuilder()
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setEndpoint("localhost:7469")
            .build();
    echoClient = EchoClient.create(settings);
  }

  @AfterEach
  public void tearDown() throws Exception {
    if (echoClient != null) {
      echoClient.shutdown();
      echoClient.awaitTermination(10, TimeUnit.SECONDS);
    }
  }

  @Test
  public void testEcho_success() {
    EchoRequest request = EchoRequest.newBuilder().setContent("Hello Local Showcase").build();
    EchoResponse response = echoClient.echo(request);

    assertThat(response.getContent()).isEqualTo("Hello Local Showcase");
  }

  @Test
  public void testEcho_errorInjection() {
    // Showcase allows injecting expected gRPC error status via request status parameter
    Status status = Status.newBuilder().setCode(com.google.rpc.Code.INVALID_ARGUMENT_VALUE).build();
    EchoRequest request = EchoRequest.newBuilder().setError(status).build();

    InvalidArgumentException exception =
        assertThrows(InvalidArgumentException.class, () -> echoClient.echo(request));

    assertThat(exception.getStatusCode().getCode())
        .isEqualTo(com.google.api.gax.rpc.StatusCode.Code.INVALID_ARGUMENT);
  }
}
```

---

## 5. Troubleshooting Common Issues

| Issue / Error | Root Cause | Solution |
| :--- | :--- | :--- |
| `io.grpc.StatusRuntimeException: UNAVAILABLE: Failed to connect` | Either `gapic-showcase run` is not running, or gRPC client used `http://localhost:7469` instead of `localhost:7469`. | Verify process is listening with `netstat -tlpn \| grep 7469` or `curl http://localhost:7469/v1beta1/echo:echo`. Use host:port without scheme for gRPC `.setEndpoint("localhost:7469")`. |
| `javax.net.ssl.SSLHandshakeException: PKIX path building failed` | `HttpJson` builder attempted an HTTPS connection against local HTTP plaintext endpoint. | Ensure your endpoint URI starts with `http://localhost:7469` and `doNotValidateCertificate()` is configured on `NetHttpTransport.Builder()`. |
| `Address already in use (bind failed)` | Another `gapic-showcase` instance or service is occupying port `7469`. | Kill existing instances (`pkill gapic-showcase`) or pass custom ports `--port <port>` when starting the server. |
| Test hang or thread resource leak in test suites | Client channels were not explicitly closed after tests complete. | Always call `client.shutdown()` and `client.awaitTermination(...)` inside test `@AfterEach` or `@AfterClass` teardown blocks. |
