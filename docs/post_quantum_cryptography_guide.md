# Post-Quantum Cryptography (PQC) User Guide for Google Cloud Java Client Libraries

## 1. Executive Summary & Core Concepts

### 1.1 What is Post-Quantum Cryptography (PQC)?
Traditional Transport Layer Security (TLS) public-key cryptography—such as RSA and Elliptic Curve Diffie-Hellman (ECDH)—relies on mathematical problems (integer factorization and discrete logarithms) that are practically impossible for classical computers to solve in a reasonable timeframe. 

However, sufficiently large, cryptographically relevant quantum computers (CRQCs) will be capable of breaking these mathematical foundations using [Shor's algorithm](https://en.wikipedia.org/wiki/Shor%27s_algorithm). **Post-Quantum Cryptography (PQC)** refers to a new class of cryptographic algorithms designed to run on classical hardware while remaining mathematically secure against attacks from both classical and quantum computers.

### 1.2 The Threat: "Store-Now, Decrypt-Later" (SNDL)
The primary threat addressed by PQC today is **Store-Now, Decrypt-Later (SNDL)**:
- **The Attack**: Adversaries can intercept and archive encrypted network communications traversing the public internet today.
- **The Consequence**: Even if attackers cannot read ciphertext now, they can store the encrypted traffic indefinitely and decrypt it in the future once quantum computers become available.
- **The Impact**: Any data with a long secrecy lifecycle—such as customer records, credentials, intellectual property, health information, and financial transactions—is vulnerable to retroactive exposure unless protected before transmission.

### 1.3 Addressing the Threat: Hybrid Key Exchange
Rather than completely replacing proven classical algorithms with brand-new post-quantum mechanisms, client libraries can utilize **Hybrid Key Exchange** (e.g., combining classical ECDH with post-quantum algorithms such as `X25519MLKEM768`):

> [!TIP]
> **The Two-Lock Analogy**:
> Think of hybrid key exchange like securing a door with **two distinct locks**:
> 1. A battle-tested **classical lock** (`X25519` elliptic curve).
> 2. A quantum-resistant **post-quantum lock** (`ML-KEM-768`, NIST FIPS 203).
> 
> To decrypt the session, an attacker must break **both** locks simultaneously:
> - If an unforeseen mathematical weakness is ever discovered in the post-quantum algorithm, the classical algorithm still maintains security.
> - If a quantum computer breaks the classical algorithm, the post-quantum algorithm still maintains security.

### 1.4 What Changes vs. What Stays the Same?
Adopting PQC in Google Cloud Java client libraries requires no changes to application business logic across both **gRPC** and **HTTP/JSON** transports:
- **What stays exactly the same**:
  - Your application source code and business logic.
  - How you construct and call API clients (e.g., `SecretManagerServiceClient`, `StorageClient`).
  - Authentication tokens, Service Account keys, and OAuth2 credentials.
  - Request and response message payloads (Protobuf or JSON).
- **What changes**:
  - Only the initial **TLS 1.3 cryptographic handshake** (Layer 4/6) performed when the client establishes a secure connection to Google Cloud service endpoints. By default, this under-the-hood improvement is completely seamless and requires **zero application code changes**.

---

## 2. HTTP/JSON Transport Architecture & Defaults

### 2.1 Minimum Required Versions
PQC enablement for HTTP/JSON transport requires compatible versions of `conscrypt-openjdk-uber`, `gax-httpjson`, and `google-http-client`:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`libraries-bom`** | `26.86.0+` | **Recommended**. Central BOM managing compatible versions across all Google Cloud client libraries. |
| **`gax-httpjson`** | `2.83.0+` | Automatically configures Conscrypt as the TLS security provider and sets PQC named groups. |
| **`google-http-client`** | `2.2.0+` | Provides transport-level security provider registration on `NetHttpTransport.Builder`. |
| **`conscrypt-openjdk-uber`** | `2.6.0+` *(2.6.2+ recommended)* | Provides Google's BoringSSL native C engine and TLS 1.3 PQC hybrid named groups. |

### 2.2 Why Conscrypt?
Built-in Java Development Kits (Java 8 through Java 26) do not support Post-Quantum Cryptography in their default Java Secure Socket Extension provider (`SunJSSE`). While native ML-KEM support is in development for future Java releases (**JDK 27+** via [JEP 496](https://openjdk.org/jeps/496)), requiring all production enterprise workloads to immediately upgrade to bleeding-edge JDK versions is impractical.

To bridge this gap, Google Cloud Java client libraries use **Conscrypt** (`conscrypt-openjdk-uber`) as the default security provider for HTTP/JSON transport:
1. **Immediate PQC Availability Across Java 8+**: Conscrypt embeds Google's open-source BoringSSL cryptographic engine via Java Native Interface (JNI). This enables quantum-resistant TLS 1.3 handshakes on existing production runtimes (Java 8, 11, 17, 21, and 25).
2. **Zero Code Changes**: When `gax-httpjson` detects compatible Conscrypt libraries on the classpath, it automatically configures the HTTPS transport without requiring manual SSLContext setup.
3. **High Performance**: BoringSSL contains hardware-accelerated assembly optimizations for modern CPU architectures (x86_64 and ARM64).

### 2.3 Scoped Security Provider (No Global JVM Impact)
The Google Cloud Java SDK scopes Conscrypt strictly to Google Cloud Java SDK requests:

- `gax-httpjson` configures the Conscrypt `Provider` instance directly on the client's internal `NetHttpTransport.Builder` rather than installing it into the global JVM security registry (`java.security.Security.addProvider(...)`).
- As a result, enabling Conscrypt for Google Cloud calls **does not alter the TLS behavior, cipher suites, or security providers of any other HTTP clients or libraries** in your application (e.g., Apache HttpClient, Spring WebClient, OkHttp, or direct `HttpsURLConnection` calls). Your existing JVM-wide cryptographic configurations remain completely undisturbed.

### 2.4 How HTTP/JSON Clients Negotiate PQC
When a Google Cloud HTTP/JSON client initiates a connection, it advertises supported key exchange groups to the server in preference order. During the TLS 1.3 handshake, the first mutually supported algorithm that both the client and server agree upon is selected and used for the session:

1. `X25519MLKEM768` *(Hybrid Post-Quantum Key Exchange)*
2. `MLKEM1024` *(Pure Post-Quantum Key Exchange)*
3. `X25519` *(Classical ECDH)*
4. `secp256r1` *(Classical ECDH)*
5. `secp384r1` *(Classical ECDH)*

> [!NOTE]
> **Algorithm Selection**:
> These named groups are selected because they are supported by Conscrypt (see [Conscrypt CAPABILITIES.md](https://github.com/google/conscrypt/blob/2.6.2/CAPABILITIES.md) and `HttpJsonConscryptUtils.DEFAULT_CONSCRYPT_NAMED_GROUPS`). If your application requires a cryptographic algorithm or named group not in this list, you can configure an alternative `SecurityProvider` (e.g., Bouncy Castle; see **Section 8.1, Option 3**).

#### Handshake Negotiation Flow:
- **PQC-Enabled Google Cloud Endpoints**: Google Cloud frontends recognize `X25519MLKEM768` as their preferred group. The client and server agree on this hybrid algorithm, establishing a quantum-resistant TLS 1.3 session.
- **Non-PQC Endpoints / Middleboxes**: If a server or intermediate network proxy does not support post-quantum cryptography, it ignores the unrecognized post-quantum identifiers and selects the first mutually supported classical group (e.g., `X25519`).
- **Graceful Client Fallback**: If Conscrypt native libraries cannot load on the client host, the client seamlessly falls back to the environment's configured security provider (which defaults to standard JDK JSSE / `SunJSSE`), negotiating classical TLS 1.3.
  - **Impact of Fallback**: Fallback is completely safe and non-breaking for application availability. Your API calls will continue to execute successfully without throwing errors or dropping traffic. The connection remains fully encrypted using industry-standard classical cryptography (such as `X25519` via standard JDK TLS); it simply does not include quantum-resistant hybrid key exchange for that session.

```
+-------------------------------------------------------------------------------+
|                      GAPIC HTTP/JSON Client Request                           |
+-------------------------------------------------------------------------------+
                                        |
                   Is Conscrypt JNI Available on This Platform?
                                        |
                    +-------------------+-------------------+
                    |                                       |
                 [ YES ]                                 [ NO ]
                    |                                       |
                    v                                       v
     google-http-client uses Conscrypt             Falls back to configured
     Offers Hybrid PQC + Classical Groups          security provider (JDK JSSE)
     - Google Cloud negotiates X25519MLKEM768      - Negotiates classical X25519
     - Non-PQC endpoints fall back to X25519         via standard JDK SunJSSE
```

---

## 3. gRPC Transport Architecture & Defaults

### 3.1 Minimum Required Versions
PQC enablement for gRPC transport requires compatible versions of `grpc-netty-shaded` and `gax-grpc`:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`libraries-bom`** | `26.88.0+` | **Recommended**. Central BOM managing compatible versions across all Google Cloud client libraries. |
| **`gax-grpc`** | `2.85.0+` | Provides gRPC transport channel providers for Google Cloud client libraries. |
| **`grpc-netty-shaded`** | `1.83.0+` | Bundled by `grpc-java`. Includes Netty and `netty-tcnative-boringssl-static` with built-in PQC hybrid key exchange support. |

### 3.2 Bundled BoringSSL Engine in `grpc-java` (Bypassing JDK Security Provider)
Google Cloud Java client libraries rely on **`grpc-java`** for gRPC transport, which chooses by default to bundle **`grpc-netty-shaded`**:

1. **Bundled BoringSSL Native Engine**: The upstream `grpc-java` project bundles a shaded version of Netty along with its native BoringSSL binding (`netty-tcnative-boringssl-static`). This packages Google's BoringSSL C library directly inside the JAR.
2. **Complete Bypass of Host JDK Security Provider**: Netty's OpenSSL engine interfaces directly with the native BoringSSL binary via JNI. It completely bypasses the host JVM's built-in Java Secure Socket Extension provider (`SunJSSE`) and the JVM security provider registry (`java.security.Security`).
3. **Independent of JDK Version**: Because the host JDK's TLS provider is bypassed, `grpc-netty-shaded` delivers post-quantum hybrid key exchange across **all supported JDK versions** (Java 8, 11, 17, 21, and 25). The host JVM's built-in TLS capabilities (or lack of native PQC in `SunJSSE` prior to JDK 27) do not affect gRPC TLS handshakes.
4. **Zero Configuration**: In `grpc-java` version **1.83.0+**, the bundled BoringSSL engine natively enables and prefers TLS 1.3 post-quantum hybrid key exchange (`X25519MLKEM768`) out-of-the-box. Applications using standard client construction negotiate PQC automatically without requiring custom socket configurators or security provider registration.

### 3.3 How gRPC Clients Negotiate PQC
When a Google Cloud gRPC client connects to an endpoint (typically port 443 with TLS):
- **PQC-Enabled Google Cloud Endpoints (GFE)**: The client's BoringSSL engine advertises hybrid PQC algorithms in its TLS 1.3 `ClientHello`. Google Cloud frontends recognize and select `X25519MLKEM768`, establishing a quantum-resistant HTTP/2 TLS session.
- **Non-PQC Endpoints / Middleboxes**: If the endpoint or an intermediary proxy does not support PQC, it selects the first mutually supported classical algorithm (such as `X25519`).
- **Graceful Fallback**: If the bundled native BoringSSL library cannot load on the platform, gRPC safely falls back to standard Java JSSE TLS (or throws an explicit linkage error if shaded Netty native transport is strictly required). When classical TLS is negotiated, your application continues operating normally.
  - **Impact of Fallback**: Fallback does not disrupt service availability. Calls continue over standard classical TLS 1.3 encryption.

```
+-------------------------------------------------------------------------------+
|                         GAPIC gRPC Client Request                             |
+-------------------------------------------------------------------------------+
                                        |
                 Is grpc-netty-shaded Native BoringSSL Available?
                                        |
                    +-------------------+-------------------+
                    |                                       |
                 [ YES ]                                 [ NO ]
                    |                                       |
                    v                                       v
     grpc-netty-shaded uses BoringSSL              Falls back to standard
     Offers Hybrid PQC (X25519MLKEM768)            classical TLS (JDK JSSE)
     - GFE negotiates X25519MLKEM768               - Negotiates classical X25519
     - Non-PQC endpoints fall back to X25519         via standard JDK TLS
```

### 3.4 gRPC Connection Architecture & Multiplexing
gRPC utilizes HTTP/2 as its underlying framing protocol:
- **Long-Lived Multiplexed Channels**: A single `ManagedChannel` maintains persistent TCP/TLS connections to Google Cloud endpoints.
- **Concurrent Stream Multiplexing**: Multiple RPCs execute concurrently over the same underlying connection without creating new TCP or TLS handshakes.
- **Handshake Frequency**: The TLS handshake happens only once when establishing the channel connection. Subsequent RPC calls share the established quantum-resistant session, resulting in zero cryptographic overhead for ongoing API traffic.

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
- **HTTP/JSON (`Keep-Alive`)**:
  - The underlying HTTP transport (`NetHttpTransport` backed by Java's `HttpURLConnection`) supports standard HTTP persistent connections (`Keep-Alive`).
  - When connections are reused from Java's connection cache, the TLS handshake occurs **only once** when establishing the connection.
  - Subsequent API requests routed through that active connection reuse the existing TLS session without repeating the handshake. (Note that applications with high connection churn or infrequent calls outside the keep-alive window will perform new handshakes more often.)
- **gRPC (HTTP/2 Multiplexing)**:
  - gRPC channels maintain persistent, long-lived HTTP/2 connections. Multiple concurrent RPC requests and streaming calls are multiplexed over a single connection.
  - Handshakes occur only when the `ManagedChannel` connects (or reconnects). For warm channels, the amortized latency impact of PQC on individual RPC calls is practically zero.

---

## 5. Deployment Environments & Platform Compatibility

Both HTTP/JSON (via Conscrypt) and gRPC (via `grpc-netty-shaded` / `netty-tcnative`) rely on C native shared libraries (`.so`, `.dylib`, or `.dll`) loaded via JNI. Consequently, both transports share similar platform compatibility considerations.

### 5.1 Compatibility Matrix

| Environment / OS | Status | Notes |
| :--- | :--- | :--- |
| **Standard Linux (e.g., Ubuntu, Debian, RHEL, CentOS — non-exhaustive)** | **Fully Supported** | Requires `glibc` 2.17+ (Conscrypt 2.6.2+ and Netty tcnative). |
| **Google Cloud Managed (Cloud Run, GKE, App Engine)** | **Fully Supported** | Default base container environments use compatible `glibc` runtimes. |
| **macOS (Apple Silicon M-series & Intel)** | **Fully Supported** | Native `osx-aarch_64` and `osx-x86_64` binaries bundled in `conscrypt-openjdk-uber` and `grpc-netty-shaded`. |
| **Windows (x86_64)** | **Fully Supported** | Native `windows-x86_64` binaries bundled in `conscrypt-openjdk-uber` and `grpc-netty-shaded`. |
| **GraalVM Native Image** | **Supported** | Supported when including appropriate reachability metadata and configuration for Conscrypt or Netty JNI libraries. |
| **Alpine Linux / Musl libc Containers** | **Fallback to Classical** | Native binaries are compiled for `glibc`. On Alpine (`musl`), native library loading fails with `UnsatisfiedLinkError` and safely falls back to standard classical TLS. |

### 5.2 Handling Alpine Linux (`musl` libc)
If your container images are based on Alpine Linux (e.g., `eclipse-temurin:17-alpine` or `openjdk:11-alpine`), native C libraries cannot load because Alpine uses `musl` libc instead of `glibc`.

**Some Possible Options on Alpine**:
1. **Accept Classical TLS Fallback**: The client library will safely fall back to classical TLS 1.3 (`X25519`). Your application will function normally without errors.
2. **Use a Glibc-Based Container Image**: If quantum resistance via native BoringSSL is desired, use a base container image that provides `glibc` (such as Debian-, Ubuntu-, or Wolfi-based container images).
3. **Configure an Alternative Security Provider (HTTP/JSON)**: Use an alternative pure-Java security provider that supports your environment (such as Bouncy Castle; see **Section 8.1, Option 3**).

### 5.3 Handling Hardened Filesystems & `noexec /tmp`
In hardened Kubernetes pods or security-conscious Docker containers, `/tmp` may be mounted with the `noexec` flag or the entire root filesystem may be marked read-only.

When native engines start, the JVM extracts bundled native `.so` files to a temporary directory. If that directory does not allow execution:
```text
java.lang.UnsatisfiedLinkError: ... failed to map segment from shared object: Operation not permitted
```

**Possible Solution**: Depending on your container configuration and security constraints, one possible solution is to provide an alternative directory that has write and execute permissions using JVM system properties:
- For Conscrypt (HTTP/JSON):
  ```bash
  java -Dorg.conscrypt.native.workdir=/var/run/app/tmp -jar my-application.jar
  ```
- For Netty / gRPC:
  ```bash
  java -Dio.netty.native.workdir=/var/run/app/tmp -jar my-application.jar
  ```

### 5.4 Classpath Isolation & Version Skew Warning
If your project uses multiple dependencies that transitively pull in different versions of Conscrypt or gRPC Netty components, JNI ABI mismatches can occur during JVM classloading. Always ensure your build tool resolves compatible versions consistently.

One possible solution for this is to use Google Cloud's `libraries-bom` (version `26.86.0+`), which centrally manages dependency versions and ensures consistent, compatible runtime dependencies across all Google Cloud client libraries.

---

## 6. Important Warning: Availability vs. Strict Compliance

Google Cloud Java client libraries follow a deliberate architectural principle: **prefer service availability over hard failures**.

### 6.1 The Silent Fallback Behavior
If native libraries fail to initialize—due to an unsupported operating system, missing `glibc`, permission issues, or file extraction limits—the client libraries catch the exception and log debug messages:
- For HTTP/JSON: Logs at `Level.FINE`:
  ```text
  FINE: Conscrypt native libraries not available. Falling back to JDK TLS.
  ```
The client then proceeds to establish standard classical TLS using the host JVM's configured security provider (by default `SunJSSE`). 

**Why does it behave this way?**
To protect production workloads. A customer updating dependencies or migrating container images should not experience broken API calls or catastrophic application outages simply because a native optimization library could not load on their environment.

**What fallback means for your application**:
- **Application Availability**: Requests continue to succeed normally. No exceptions or errors are raised to application code.
- **Security Baseline**: Traffic remains fully encrypted with classical TLS 1.3 (e.g., ECDHE with AES-GCM), maintaining the standard security posture that Java applications use today.
- **What is absent**: The connection will not be protected against future post-quantum decryption (SNDL).

### 6.2 The Compliance Warning
> [!WARNING]
> **Active Verification is Required for Regulatory Mandates**:
> If your organization operates under strict compliance, governmental, or corporate security mandates requiring Post-Quantum Cryptography today, **you cannot rely solely on the default configuration without verification**.
>
> Because fallback to classical TLS is silent and non-breaking by design, an unexpected environment change (such as switching to an Alpine-based Docker container or changing filesystem mount permissions) could downgrade your connections from hybrid PQC to classical TLS **without throwing exceptions or failing requests**.
>
> If PQC is a mandatory requirement for your workload, you must implement automated verification in your CI/CD pipelines or startup health checks (see **Section 7**).

---

## 7. How to Verify PQC Negotiation

To confirm whether your application is actively negotiating post-quantum hybrid key exchange, use the verification methods below depending on your chosen transport.

### 7.1 Verifying HTTP/JSON Transport

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

### 7.2 Verifying gRPC Transport

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

## 8. Custom & Alternative Configurations

By default, Google Cloud client libraries automatically negotiate PQC when supported on the environment without requiring custom code. If you need to customize transport behavior or security providers, you can configure the transports directly:

### 8.1 HTTP/JSON Custom Configurations

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

### 8.2 gRPC Custom Configurations

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

## 9. Future Outlook: Native OpenJDK PQC Support (JDK 27+)

The cryptographic landscape is continually advancing. The OpenJDK community is integrating standardized post-quantum algorithms directly into the Java platform:
- **[JEP 496](https://openjdk.org/jeps/496) (ML-KEM)**: Introduces native implementations of NIST FIPS 203 (Module-Lattice-Based Key-Encapsulation Mechanism) into OpenJDK's standard security providers (`SunJSSE` and `SunJCE`), targeted for **JDK 27+**.
- **What this means for Google Cloud Java**: Once JDK 27 becomes standard in production environments, Java applications will be capable of negotiating hybrid and pure post-quantum TLS natively without requiring JNI shared libraries or third-party dependencies like Conscrypt or `netty-tcnative`.
- **Future-Proofing**: As native JDK capabilities mature, Google Cloud Java client libraries will adapt to take advantage of built-in JVM providers, preserving a seamless, zero-maintenance security upgrade path for all users across both HTTP/JSON and gRPC transports.
