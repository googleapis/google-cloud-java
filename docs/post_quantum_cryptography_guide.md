# Post-Quantum Cryptography (PQC) User Guide for Google Cloud Java Client Libraries

## 1. Core Concepts

**Post-Quantum Cryptography (PQC)** refers to cryptographic algorithms designed to protect encrypted communications against attacks from future quantum computers. The primary threat addressed today is **Store-Now, Decrypt-Later (SNDL)**—where encrypted network traffic is intercepted and stored today by an adversary with the goal of decrypting it once cryptographically relevant quantum computers emerge.

To defend against this without sacrificing stability, Google Cloud Java client libraries adopt **Hybrid Key Exchange** (combining classical algorithms like `X25519` with standardized post-quantum algorithms like `ML-KEM-768`). This ensures connections remain secure even if an unforeseen mathematical weakness is discovered in either algorithm.

For in-depth background on PQC, NIST standards, and Google's quantum-safe roadmap, refer to the following resources:
- [Google Cloud Post-Quantum Cryptography Resources](https://cloud.google.com/security/resources/post-quantum-cryptography)
- [How Google is preparing for a post-quantum world](https://cloud.google.com/blog/products/identity-security/how-google-is-preparing-for-a-post-quantum-world/?e=48754805)
- [PQC in Plaintext: Google Cloud's Post-Quantum Cryptography Roadmap](https://cloud.google.com/blog/products/identity-security/pqc-in-plaintext-google-clouds-post-quantum-cryptography-roadmap)
- [Post-Quantum Cryptography Standards: What you need to know](https://security.googleblog.com/2024/08/post-quantum-cryptography-standards.html)

### 1.1 What Changes in Google Cloud Java Client Libraries?
Enabling PQC in Google Cloud Java client libraries requires **zero changes to application business logic** across both **gRPC** and **HTTP/JSON** transports:
- **What stays exactly the same**:
  - Application source code and business logic.
  - How you construct and invoke API clients (e.g., `SecretManagerServiceClient`, `StorageClient`).
  - Authentication tokens, Service Account keys, and OAuth2 credentials.
  - Request and response message payloads (Protobuf or JSON).
- **What changes under the hood**:
  - Only the initial **TLS 1.3 cryptographic handshake** (Layer 4/6) performed when establishing a secure connection to Google Cloud service endpoints. The client automatically negotiates hybrid post-quantum key exchange (`X25519MLKEM768`) instead of classical-only key exchange (`X25519`).

---

## 2. gRPC Transport Architecture & Defaults

As the default transport for Google Cloud Java client libraries, gRPC offers high-performance RPCs multiplexed over HTTP/2.

### 2.1 Minimum Required Versions
PQC enablement for gRPC transport requires compatible versions of `grpc-netty-shaded` and `gax-grpc`:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`libraries-bom`** | `26.88.0+` | **Recommended**. Central BOM managing compatible versions across all Google Cloud client libraries. |
| **`gax-grpc`** | `2.85.0+` | Provides gRPC transport channel providers for Google Cloud client libraries. |
| **`grpc-netty-shaded`** | `1.83.0+` | Bundled by `grpc-java`. Includes Netty and `netty-tcnative-boringssl-static` with built-in PQC hybrid key exchange support. |

### 2.2 Bundled BoringSSL Engine in `grpc-java` (Bypassing JDK Security Provider)
Google Cloud Java client libraries rely on **`grpc-java`** for gRPC transport, which chooses by default to bundle **`grpc-netty-shaded`**:

1. **Bundled BoringSSL Native Engine**: The upstream `grpc-java` project bundles a shaded version of Netty along with its native BoringSSL binding (`netty-tcnative-boringssl-static`). This packages Google's BoringSSL C library directly inside the JAR.
2. **Complete Bypass of Host JDK Security Provider**: Netty's OpenSSL engine interfaces directly with the native BoringSSL binary via JNI. It completely bypasses the host JVM's built-in Java Secure Socket Extension provider (`SunJSSE`) and the JVM security provider registry (`java.security.Security`).
3. **Independent of JDK Version**: Because the host JDK's TLS provider is bypassed, `grpc-netty-shaded` delivers post-quantum hybrid key exchange across **all supported JDK versions** (Java 8, 11, 17, 21, and 25). The host JVM's built-in TLS capabilities (or lack of native PQC in `SunJSSE` prior to JDK 27) do not affect gRPC TLS handshakes.
4. **Zero Configuration**: In `grpc-java` version **1.83.0+**, the bundled BoringSSL engine natively enables and prefers TLS 1.3 post-quantum hybrid key exchange (`X25519MLKEM768`) out-of-the-box. Applications using standard client construction negotiate PQC automatically without requiring custom socket configurators or security provider registration.

### 2.3 How gRPC Clients Negotiate PQC
When a Google Cloud gRPC client connects to an endpoint (typically port 443 with TLS):
- **PQC-Enabled Google Cloud Endpoints**: The client's BoringSSL engine advertises hybrid PQC algorithms (`X25519MLKEM768`) in its TLS 1.3 `ClientHello`. Google Cloud frontends recognize and select `X25519MLKEM768`, establishing a quantum-resistant HTTP/2 TLS session.
- **Non-PQC Endpoints / Middleboxes**: If the endpoint or an intermediary proxy does not support PQC, standard TLS 1.3 negotiation selects the first mutually supported classical algorithm (such as `X25519`).
- **Transport & Provider Resolution**: Unlike HTTP/JSON (where fallback is explicitly intercepted and handled by the SDK's `HttpJsonConscryptUtils`), the Google Cloud Java SDK does not implement custom TLS fallback logic for gRPC. Instead, upstream `grpc-java` (`grpc-netty-shaded`) manages SSL provider selection:
  - By default, `grpc-netty-shaded` bundles native BoringSSL (`netty-tcnative-boringssl-static`) and configures Netty's OpenSSL provider (`SslProvider.OPENSSL`).
  - If native BoringSSL cannot be loaded (for example, on environments without compatible `glibc` or where native library extraction is restricted), `grpc-java`'s `GrpcSslContexts` checks for an available JDK security provider supporting ALPN (present by default via `SunJSSE` on Java 9+) and falls back to Netty's JDK JSSE provider (`SslProvider.JDK`).
  - If neither native OpenSSL nor an ALPN-capable JDK provider is available, channel initialization fails with an `IllegalStateException`.
- **Impact of Classical Fallback**: If classical TLS is negotiated, your application continues operating normally without disruption. Calls continue over standard classical TLS 1.3 encryption (`X25519`).

```
+-------------------------------------------------------------------------------+
|                      Google Cloud gRPC Client Request                         |
+-------------------------------------------------------------------------------+
                                        |
                 Is grpc-netty-shaded Native BoringSSL Available?
                                        |
                     +-------------------+-------------------+
                     |                                       |
                  [ YES ]                                 [ NO ]
                     |                                       |
                     v                                       v
      grpc-netty-shaded uses BoringSSL              grpc-java selects JDK JSSE
      Offers Hybrid PQC (X25519MLKEM768)            (Java 9+ ALPN supported)
      - Google Cloud negotiates X25519MLKEM768      - Negotiates classical X25519
      - Non-PQC endpoints fall back to X25519         via standard JDK SunJSSE
```

### 2.4 gRPC Connection Architecture & Multiplexing
gRPC utilizes HTTP/2 as its underlying framing protocol:
- **Long-Lived Multiplexed Channels**: A single `ManagedChannel` maintains persistent TCP/TLS connections to Google Cloud endpoints.
- **Concurrent Stream Multiplexing**: Multiple RPCs execute concurrently over the same underlying connection without creating new TCP or TLS handshakes.
- **Handshake Frequency**: The TLS handshake happens only once when establishing the channel connection. Subsequent RPC calls share the established quantum-resistant session, resulting in zero cryptographic overhead for ongoing API traffic.

---

## 3. HTTP/JSON Transport Architecture & Defaults

For environments where HTTP/1.1 REST is preferred or required, Google Cloud Java client libraries provide HTTP/JSON transport.

### 3.1 Minimum Required Versions
PQC enablement for HTTP/JSON transport requires compatible versions of `conscrypt-openjdk-uber`, `gax-httpjson`, and `google-http-client`:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`libraries-bom`** | `26.86.0+` | **Recommended**. Central BOM managing compatible versions across all Google Cloud client libraries. |
| **`gax-httpjson`** | `2.83.0+` | Automatically configures Conscrypt as the TLS security provider and sets PQC named groups. |
| **`google-http-client`** | `2.2.0+` | Provides transport-level security provider registration on `NetHttpTransport.Builder`. |
| **`conscrypt-openjdk-uber`** | `2.6.0+` *(2.6.2+ recommended)* | Provides Google's BoringSSL native C engine and TLS 1.3 PQC hybrid named groups. |

### 3.2 Why Conscrypt?
Built-in Java Development Kits (Java 8 through Java 26) do not support Post-Quantum Cryptography in their default Java Secure Socket Extension provider (`SunJSSE`). While native ML-KEM support is in development for future Java releases (**JDK 27+** via [JEP 496](https://openjdk.org/jeps/496)), requiring all production enterprise workloads to immediately upgrade to bleeding-edge JDK versions is impractical.

To bridge this gap, Google Cloud Java client libraries use **Conscrypt** (`conscrypt-openjdk-uber`) as the default security provider for HTTP/JSON transport:
1. **Immediate PQC Availability Across Java 8+**: Conscrypt embeds Google's open-source BoringSSL cryptographic engine via Java Native Interface (JNI). This enables quantum-resistant TLS 1.3 handshakes on existing production runtimes (Java 8, 11, 17, 21, and 25).
2. **Zero Code Changes**: When `gax-httpjson` detects compatible Conscrypt libraries on the classpath, it automatically configures the HTTPS transport without requiring manual SSLContext setup.
3. **High Performance**: BoringSSL contains hardware-accelerated assembly optimizations for modern CPU architectures (x86_64 and ARM64).

### 3.3 Scoped Security Provider (No Global JVM Impact)
The Google Cloud Java SDK scopes Conscrypt strictly to Google Cloud Java SDK requests:

- `gax-httpjson` configures the Conscrypt `Provider` instance directly on the client's internal `NetHttpTransport.Builder` rather than installing it into the global JVM security registry (`java.security.Security.addProvider(...)`).
- As a result, enabling Conscrypt for Google Cloud calls **does not alter the TLS behavior, cipher suites, or security providers of any other HTTP clients or libraries** in your application (e.g., Apache HttpClient, Spring WebClient, OkHttp, or direct `HttpsURLConnection` calls). Your existing JVM-wide cryptographic configurations remain completely undisturbed.

### 3.4 How HTTP/JSON Clients Negotiate PQC
When a Google Cloud HTTP/JSON client initiates a connection, it advertises supported key exchange groups in preference order:
1. `X25519MLKEM768` *(Hybrid Post-Quantum Key Exchange)*
2. `MLKEM1024` *(Pure Post-Quantum Key Exchange)*
3. `X25519` *(Classical ECDH)*
4. `secp256r1` *(Classical ECDH)*
5. `secp384r1` *(Classical ECDH)*

During the TLS 1.3 handshake:
- **PQC-Enabled Google Cloud Endpoints**: Google Cloud frontends recognize and select `X25519MLKEM768`, establishing a quantum-resistant TLS 1.3 session.
- **Non-PQC Endpoints / Middleboxes**: If a server or intermediate network proxy does not support post-quantum cryptography, it ignores unrecognized post-quantum identifiers and standard TLS 1.3 negotiation selects the first mutually supported classical group (`X25519`).
- **Platform Fallback**: If Conscrypt native libraries cannot load on the client host, `gax-httpjson` catches the linkage error and defaults to the environment's configured security provider (standard JDK `SunJSSE`), safely negotiating classical TLS 1.3 without failing application requests (see **Section 6** for fallback mechanics and implications).

---

## 4. Performance & Network Considerations

Note the following performance and network considerations across both transports:

### 4.1 TLS Handshake Size Overhead
- **Public Key & Ciphertext Sizes**:
  - Classical `X25519` public keys are very compact: **32 bytes**.
  - `ML-KEM-768` public keys are **1,184 bytes**, and ciphertexts are **1,088 bytes**.
- **Handshake Size**:
  - Consequently, the TLS `ClientHello` and `ServerHello` messages increase by approximately **1 to 2 kilobytes**.
- **Fragmentation & Middleboxes**:
  - While modern networks handle handshakes of this size smoothly, rare legacy network middleboxes or firewalls with strict MTU limits or packet inspection might drop larger `ClientHello` frames.

### 4.2 Transport Connection Characteristics & API Latency
Because both transports maintain persistent connections, the latency impact of the larger PQC handshake is limited to initial connection establishment:
- **gRPC (HTTP/2 Multiplexing)**:
  - gRPC channels maintain persistent, long-lived HTTP/2 connections. Multiple concurrent RPC requests and streaming calls are multiplexed over a single connection.
  - Handshakes occur only when the `ManagedChannel` connects (or reconnects). For warm channels, the amortized latency impact of PQC on individual RPC calls is practically zero.
- **HTTP/JSON (`Keep-Alive`)**:
  - The underlying HTTP transport (`NetHttpTransport` backed by Java's `HttpURLConnection`) supports standard HTTP persistent connections (`Keep-Alive`).
  - When connections are reused from Java's connection cache, the TLS handshake occurs **only once** when establishing the connection.
  - Subsequent API requests routed through that active connection reuse the existing TLS session without repeating the handshake. (Note that applications with high connection churn or infrequent calls outside the keep-alive window will perform new handshakes more often.)

---

## 5. Environment & Runtime Considerations

Because PQC negotiation relies on native BoringSSL C binaries (bundled in `grpc-netty-shaded` and `conscrypt-openjdk-uber`) loaded over JNI, compatibility depends on the underlying runtime environment. Most standard Linux (`glibc`), macOS, and Windows environments support native execution out of the box.

### 5.1 GraalVM Native Image
GraalVM Native Image compilation is supported for applications that include the appropriate reachability metadata and JNI configuration for Netty or Conscrypt native libraries.

### 5.2 Classpath Isolation & Version Skew Warning
If your project uses multiple dependencies that transitively pull in different versions of gRPC Netty components or Conscrypt, JNI ABI mismatches can occur during JVM classloading. Always ensure your build tool resolves compatible versions consistently.

One possible solution for this is to use Google Cloud's `libraries-bom` (version `26.88.0+`), which centrally manages dependency versions and ensures consistent, compatible runtime dependencies across all Google Cloud client libraries.

---

## 6. Classical Fallback: Mechanics, Implications & Concerns

Google Cloud Java client libraries follow a deliberate architectural principle: **prefer service availability over hard failures**.

### 6.1 Fallback Mechanics: Availability Over Hard Failures
If native libraries fail to initialize—due to an unsupported operating system, missing `glibc`, permission constraints, or file extraction limits—connections continue using classical TLS:
- **For HTTP/JSON**: The Google Cloud Java SDK explicitly configures fallback in `HttpJsonConscryptUtils`. If Conscrypt native libraries fail to load, the SDK catches the `LinkageError`, logs at `Level.FINE`:
  ```text
  FINE: Conscrypt native library unavailable. Falling back to default JDK TLS.
  ```
  and proceeds to establish standard classical TLS using the host JVM's configured security provider (by default `SunJSSE`).
- **For gRPC**: The SDK delegates transport and channel creation to upstream `grpc-java` (`grpc-netty-shaded`). If the bundled native BoringSSL library fails to load, `grpc-java`'s `GrpcSslContexts` checks for an available ALPN-capable JDK security provider (provided by `SunJSSE` on Java 9+) and falls back to standard JDK JSSE.

**Why does it behave this way?**
To protect production workloads. Updating dependencies or migrating container images should not cause broken API calls or catastrophic application outages simply because a native optimization library could not load on a given runtime.

### 6.2 Common Scenarios Triggering Fallback
Several operational conditions can trigger a fallback to classical TLS:
- **Alpine Linux (`musl` libc)**:
  Precompiled native binaries bundled in `grpc-netty-shaded` and `conscrypt-openjdk-uber` require `glibc` and cannot load on Alpine Linux or other `musl`-based container distributions (e.g., `eclipse-temurin:17-alpine`). On these platforms, native loading fails with an `UnsatisfiedLinkError`, and the client automatically falls back to classical TLS (`X25519`). Workloads requiring post-quantum hybrid key exchange should use a `glibc`-compatible base image (such as Debian, Ubuntu, or Wolfi).
- **Hardened Filesystems (`noexec /tmp`)**:
  In security-hardened container or Kubernetes environments where `/tmp` is mounted with the `noexec` flag or the filesystem is strictly read-only, the JVM cannot load native shared libraries extracted to `/tmp`, resulting in an `UnsatisfiedLinkError` (`failed to map segment from shared object: Operation not permitted`). The client safely falls back to classical TLS. If PQC is required in these environments, configure an executable working directory using JVM system properties (e.g., `-Dio.netty.native.workdir=/path/to/executable/dir` for gRPC or `-Dorg.conscrypt.native.workdir=/path/to/executable/dir` for HTTP/JSON).
- **Non-PQC Endpoints & Middleboxes**:
  If a server endpoint or an intermediate network proxy does not support post-quantum cryptography, standard TLS 1.3 negotiation naturally selects the first mutually supported classical algorithm (`X25519`).

### 6.3 Security & Operational Implications
When fallback occurs, understand what this means for your workload:
- **Application Availability (Preserved)**: Requests continue to succeed normally. No exceptions or errors are raised to application code.
- **Security Baseline (Preserved)**: Traffic remains fully encrypted with standard classical TLS 1.3 (e.g., ECDHE with AES-GCM), maintaining the standard security posture that Java applications use today.
- **Post-Quantum Protection (Absent)**: The connection will **not** be protected against future quantum decryption. Encrypted traffic archived by adversaries remains susceptible to future Store-Now, Decrypt-Later (SNDL) attacks.

### 6.4 Regulatory & Compliance Concerns (Silent Fallback Warning)
> [!WARNING]
> **Active Verification is Required for Regulatory Mandates**:
> If your organization operates under strict compliance, governmental, or corporate security mandates requiring Post-Quantum Cryptography today, **you cannot rely solely on the default configuration without verification**.
>
> Because fallback to classical TLS is silent and non-breaking by design, an unexpected environment change (such as switching base container images to Alpine or changing filesystem mount permissions) could downgrade your connections from hybrid PQC to classical TLS **without throwing exceptions or failing requests**.
>
> If PQC is a mandatory requirement for your workload, you must implement automated verification in your CI/CD pipelines or startup health checks (see **Section 7**).

---

## 7. How to Verify PQC Negotiation

To confirm whether your application is actively negotiating post-quantum hybrid key exchange, use the verification methods below depending on your chosen transport.

### 7.1 Verifying gRPC Transport

> [!NOTE]
> **Why `-Djavax.net.debug` does not capture gRPC handshakes**:
> By default, gRPC uses `grpc-netty-shaded`, which uses its bundled native BoringSSL engine (`netty-tcnative`) via JNI, bypassing the JVM's built-in Java Secure Socket Extension (`SunJSSE`). Standard JVM `-Djavax.net.debug` flags will not output gRPC handshake details.

#### Method 1: Netty SSL Debug Logging
You can enable debug logging for Netty's shaded SSL handler to observe TLS handshake details:

```bash
java -Dio.grpc.netty.shaded.io.netty.handler.ssl=DEBUG -jar my-application.jar
```

#### Method 2: gRPC Client Interceptor Verification
In integration tests or test environments, you can verify the negotiated TLS parameters by attaching a `ClientInterceptor` to inspect response metadata returned by endpoints or test servers:

```java
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.Collections;

public class TlsVerificationInterceptor implements ClientInterceptor {
  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
        next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        super.start(
            new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                responseListener) {
              @Override
              public void onHeaders(Metadata headers) {
                // Inspect response headers or TLS metadata if published by server/proxy
                super.onHeaders(headers);
              }
            },
            headers);
      }
    };
  }
}

// Attach the interceptor to the client's gRPC transport provider:
InstantiatingGrpcChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultGrpcTransportProviderBuilder()
        .setInterceptorProvider(() -> Collections.singletonList(new TlsVerificationInterceptor()))
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Execute calls; interceptor captures response metadata
}
```

---

### 7.2 Verifying HTTP/JSON Transport

#### Method 1: GAX Internal Initialization Logging
Inspect whether `gax-httpjson` successfully loaded Conscrypt or fell back to the default security provider by enabling debug logging on `HttpJsonConscryptUtils`.

In your `logging.properties` file:
```properties
com.google.api.gax.httpjson.HttpJsonConscryptUtils.level = FINE
java.util.logging.ConsoleHandler.level = FINE
```

Or programmatically at application startup:
```java
import java.util.logging.Level;
import java.util.logging.Logger;

Logger.getLogger("com.google.api.gax.httpjson.HttpJsonConscryptUtils").setLevel(Level.FINE);
```

- **When Conscrypt initializes successfully**: No fallback messages appear in the log.
- **When fallback occurs**: You will observe:
  ```text
  FINE: Conscrypt native library unavailable. Falling back to default JDK TLS.
  FINE: Conscrypt initialization failed with exception: java.lang.UnsatisfiedLinkError: ...
  ```

#### Method 2: JVM TLS Handshake Tracing (`-Djavax.net.debug`)
To inspect the actual cryptographic parameters negotiated during the TLS 1.3 handshake with Google Cloud servers, start your Java application with the standard JSSE debug flag:

```bash
java -Djavax.net.debug=ssl:handshake -jar my-application.jar
```

Look for the following entries in standard error during the initial HTTPS connection:

1. **ClientHello (Groups Offered)**:
   Verify that your client advertises post-quantum hybrid named groups:
   ```text
   Extension supported_groups (10): [
     NamedGroup: X25519MLKEM768 (0x11ec),
     NamedGroup: MLKEM1024 (0x0202),
     NamedGroup: x25519 (0x001d),
     NamedGroup: secp256r1 (0x0017)
   ]
   ```

2. **ServerHello (Negotiated Algorithm)**:
   Verify that the Google Cloud endpoint selects `X25519MLKEM768`:
   ```text
   ServerHello:
     Version: TLSv1.3
     Cipher Suite: TLS_AES_128_GCM_SHA256
     Extension key_share (51): [
       NamedGroup: X25519MLKEM768 (0x11ec)
     ]
   ```
If the negotiated group displays `X25519MLKEM768` (or `0x11ec`), your connection is fully protected with hybrid Post-Quantum Cryptography.

---

## 8. Custom & Alternative Configurations

By default, Google Cloud client libraries automatically negotiate PQC when supported on the environment without requiring custom code. If you need to customize transport behavior or security providers, you can configure the transports directly:

### 8.1 gRPC Custom Configurations

#### Option 1: Configuring Custom Netty SSL Context
For gRPC clients, you can configure `InstantiatingGrpcChannelProvider` with a channel configurator to customize Netty's SSL context (such as setting custom trust certificates, cipher suites, or SSL providers):

```java
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import java.io.File;

// 1. Configure the gRPC channel provider with a custom Netty SSLContext
InstantiatingGrpcChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultGrpcTransportProviderBuilder()
        .setChannelConfigurator(
            managedChannelBuilder -> {
              if (managedChannelBuilder instanceof NettyChannelBuilder) {
                try {
                  ((NettyChannelBuilder) managedChannelBuilder)
                      .sslContext(
                          GrpcSslContexts.forClient()
                              // Custom SSL options (e.g., custom trust managers or ciphers)
                              .build());
                } catch (Exception e) {
                  throw new RuntimeException("Failed to configure gRPC SSL context", e);
                }
              }
              return managedChannelBuilder;
            })
        .build();

// 2. Build client settings using the custom gRPC channel provider
SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using customized gRPC channel
}
```

---

### 8.2 HTTP/JSON Custom Configurations

#### Option 1: Forcing Classical-Only Key Exchange (Disabling PQC)
If you need to use Conscrypt for high-performance TLS but want to explicitly disable post-quantum hybrid groups:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.HttpJsonConscryptUtils;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import org.conscrypt.Conscrypt;

// 1. Build a NetHttpTransport with Conscrypt restricted to classical X25519
NetHttpTransport classicalTransport =
    HttpJsonConscryptUtils.configureConscryptSecurityProvider(new NetHttpTransport.Builder())
        .setSslSocketConfigurator(
            socket -> {
              if (Conscrypt.isConscrypt(socket)) {
                try {
                  // Restrict offered groups exclusively to classical X25519
                  Conscrypt.setNamedGroups(socket, new String[] {"X25519"});
                } catch (Exception e) {
                  // Fallback or log if needed
                }
              }
            })
        .build();

// 2. Configure the transport channel provider
InstantiatingHttpJsonChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(classicalTransport)
        .build();

// 3. Instantiate the service client
SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using classical X25519 TLS 1.3
}
```

#### Option 2: Bypassing Conscrypt to Use Standard JDK JSSE
If your deployment environment prohibits native JNI libraries or you prefer using the JVM's built-in cryptographic engine (`SunJSSE`):

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;

// 1. Build a standard NetHttpTransport without Conscrypt configuration
NetHttpTransport standardTransport = new NetHttpTransport.Builder().build();

// 2. Attach the standard transport to the channel provider
InstantiatingHttpJsonChannelProvider transportProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(standardTransport)
        .build();

// 3. Create settings and instantiate client
SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using standard JDK JSSE TLS
}
```

#### Option 3: Configuring a Third-Party Security Provider (e.g., Bouncy Castle)
If your enterprise utilizes an alternative cryptographic provider (such as Bouncy Castle), configure it directly on the `NetHttpTransport.Builder`:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import java.security.Provider;
import java.security.Security;

// 1. Instantiate or lookup custom security provider
Provider customProvider = Security.getProvider("BC"); // e.g., BouncyCastleProvider

// 2. Configure NetHttpTransport with the custom provider
NetHttpTransport customTransport =
    new NetHttpTransport.Builder()
        .setSecurityProvider(customProvider)
        .setSslSocketConfigurator(
            socket -> {
              // Apply custom socket settings (cipher suites, protocols, named groups)
            })
        .build();

// 3. Attach custom transport to client settings
InstantiatingHttpJsonChannelProvider transportProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(customTransport)
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using custom security provider
}
```

---

## 9. Future Outlook: Native OpenJDK PQC Support (JDK 27+)

The cryptographic landscape is continually advancing. The OpenJDK community is integrating standardized post-quantum algorithms directly into the Java platform:
- **[JEP 496](https://openjdk.org/jeps/496) (ML-KEM)**: Introduces native implementations of NIST FIPS 203 (Module-Lattice-Based Key-Encapsulation Mechanism) into OpenJDK's standard security providers (`SunJSSE` and `SunJCE`), targeted for **JDK 27+**.
- **What this means for Google Cloud Java**: Once JDK 27 becomes standard in production environments, Java applications will be capable of negotiating hybrid and pure post-quantum TLS natively without requiring JNI shared libraries or third-party dependencies like Conscrypt or `netty-tcnative`.
- **Future-Proofing**: As native JDK capabilities mature, Google Cloud Java client libraries will adapt to take advantage of built-in JVM providers, preserving a seamless, zero-maintenance security upgrade path for all users across both gRPC and HTTP/JSON transports.
