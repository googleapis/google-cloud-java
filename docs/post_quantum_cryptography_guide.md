# Post-Quantum Cryptography (PQC) User Guide for Google Cloud Java Client Libraries

## Overview

**Post-Quantum Cryptography (PQC)** refers to cryptographic algorithms designed to protect encrypted communications against attacks from future quantum computers. The primary threat addressed today is **Store-Now, Decrypt-Later (SNDL)**—where encrypted network traffic is intercepted and stored today by an adversary with the goal of decrypting it once cryptographically relevant quantum computers emerge.

To defend against this without sacrificing stability, Google Cloud Java client libraries adopt **Hybrid Key Exchange** (combining classical algorithms like `X25519` with standardized post-quantum algorithms like `ML-KEM-768`). This ensures connections remain secure even if an unforeseen mathematical weakness is discovered in either algorithm.

For in-depth background on PQC, NIST standards, and Google's quantum-safe roadmap, refer to the following resources:
- [Google Cloud Post-Quantum Cryptography Resources](https://cloud.google.com/security/resources/post-quantum-cryptography)
- [How Google is preparing for a post-quantum world](https://cloud.google.com/blog/products/identity-security/how-google-is-preparing-for-a-post-quantum-world/?e=48754805)
- [PQC in Plaintext: Google Cloud's Post-Quantum Cryptography Roadmap](https://cloud.google.com/blog/products/identity-security/pqc-in-plaintext-google-clouds-post-quantum-cryptography-roadmap)
- [Post-Quantum Cryptography Standards: What you need to know](https://security.googleblog.com/2024/08/post-quantum-cryptography-standards.html)

### What Changes in Google Cloud Java Client Libraries?
Enabling PQC in Google Cloud Java client libraries requires **zero changes to application business logic**:
- **What stays exactly the same**:
  - Application source code and business logic.
  - How you construct and invoke API clients (e.g., `SecretManagerServiceClient`, `StorageClient`).
  - Authentication tokens, Service Account keys, and OAuth2 credentials.
  - Request and response payloads.
- **What changes under the hood**:
  - Only the initial **TLS 1.3 cryptographic handshake** performed when establishing a connection to Google Cloud service endpoints. The client automatically negotiates hybrid post-quantum key exchange (`X25519MLKEM768`) instead of classical-only key exchange (`X25519`).

### Supported Key Exchange Algorithms & Negotiation
Across all supported transports, Google Cloud Java client libraries negotiate TLS 1.3 key exchange by offering a preference-ordered list of post-quantum and classical named groups. Today, the primary algorithms negotiated with Google Cloud endpoints are:
- **Primary Post-Quantum Group (Default Example)**: `X25519MLKEM768` (hybrid combining classical X25519 ECDH and NIST FIPS 203 ML-KEM-768).
- **Classical Fallback (Default Example)**: `X25519` (classical ECDH; or other mutually supported curves such as `secp256r1`).

> [!NOTE]
> `X25519MLKEM768` and `X25519` are representative examples of the primary groups currently deployed and negotiated by default across Google Cloud infrastructure. Client engines offer additional groups (such as `MLKEM1024` or classical elliptic curves), and future algorithm standards may be supported as the post-quantum ecosystem evolves.

When a client establishes a connection with Google Cloud endpoints, it advertises post-quantum hybrid groups (such as `X25519MLKEM768`) at the top of its preference list. Because Google Cloud frontend servers support PQC algorithms, `X25519MLKEM768` is selected by default. If an intermediate proxy, middlebox, or non-PQC endpoint does not recognize or support post-quantum key exchange, standard TLS 1.3 negotiation automatically falls back to a mutually supported classical group (such as `X25519`).

For transport-specific configurations and group preference lists, see [HTTP/JSON Supported Named Groups Preference Order](#httpjson-supported-named-groups-preference-order) and [Custom & Alternative Configurations](#4-custom--alternative-configurations).

---

## 1. Transport Architecture & Setup

Google Cloud Java client libraries support two transports: **gRPC** (default) and **HTTP/JSON (REST)**.

Built-in Java Development Kits (Java 8–26) do not support Post-Quantum Cryptography in their default Java Secure Socket Extension provider (`SunJSSE`). Standardized native ML-KEM support is planned for future Java releases (**JDK 27+** via [JEP 496](https://openjdk.org/jeps/496)). To bridge until users can adopt JDK 27+, Google Cloud client libraries leverage Google's native **BoringSSL** engine via JNI to deliver hybrid PQC today without modifying global JVM security defaults.

> [!NOTE]
> **Zero Global JVM Impact**:
> Enabling PQC on either gRPC or HTTP/JSON is scoped strictly to Google Cloud client calls. It **does not alter the TLS behavior, cipher suites, or security providers of any other HTTP clients or libraries** in your application (e.g., Apache HttpClient, Spring WebClient, OkHttp, or direct `HttpsURLConnection` calls). Neither transport modifies global `Security.addProvider()` or default JVM SSL contexts.

---

### 1.1 gRPC Transport (Default)

gRPC is the default transport across Google Cloud Java client libraries.

#### Minimum Required Versions
We recommend using Google Cloud's **`libraries-bom` (version `26.88.0+`)** to guarantee that dependencies have compatible, required versions.

If managing dependencies directly, ensure the following minimum versions are present:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`gax-grpc`** | `2.85.0+` | Configures and manages gRPC channel providers and client settings. |
| **`grpc-netty-shaded`** | `1.76.0+` | Upstream transport bundling Google's BoringSSL engine and native TLS 1.3 PQC hybrid named groups. |

---

### 1.2 HTTP/JSON (REST) Transport

HTTP/JSON (REST) transport is used by clients configured explicitly for REST communication.

#### Minimum Required Versions
We recommend using Google Cloud's **`libraries-bom` (version `26.86.0+`)** to guarantee that dependencies have compatible, required versions.

If managing dependencies directly, ensure the following minimum versions are present:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`gax-httpjson`** | `2.83.0+` | Automatically configures Conscrypt as the TLS security provider and sets PQC named groups. |
| **`google-http-client`** | `2.2.0+` | Provides transport-level security provider registration on `NetHttpTransport.Builder`. |
| **`conscrypt-openjdk-uber`** | `2.6.0+` *(2.6.2+ recommended)* | Provides Google's BoringSSL native C engine and TLS 1.3 PQC hybrid named groups. |

#### Why Conscrypt?
Google Cloud Java client libraries use **Conscrypt** (`conscrypt-openjdk-uber`) for HTTP/JSON transport primarily for **high performance and speed**: Conscrypt embeds Google's native BoringSSL engine via JNI, utilizing hardware-accelerated assembly optimizations for modern CPU architectures (x86_64 and ARM64). This provides significantly higher throughput, lower latency, and reduced CPU overhead compared to pure Java security providers (such as Bouncy Castle or standard `SunJSSE`).

#### HTTP/JSON Supported Named Groups Preference Order
Based on [Conscrypt's supported named groups](https://github.com/google/conscrypt/blob/2.6.2/CAPABILITIES.md#supported-named-groups), HTTP/JSON clients advertise supported key exchange groups in the following preference order:
1. `X25519MLKEM768` *(Hybrid Post-Quantum Key Exchange)*
2. `MLKEM1024` *(Pure Post-Quantum Key Exchange)*
3. `X25519` *(Classical ECDH)*
4. `secp256r1` *(Classical ECDH)*
5. `secp384r1` *(Classical ECDH)*

---

## 2. Classical Fallback

> [!WARNING]
> **Active Verification is Required for Regulatory Mandates**:
> If your organization operates under strict compliance, governmental, or corporate security mandates requiring Post-Quantum Cryptography today, **you cannot rely solely on the default configuration without verification**.
>
> Because fallback to classical TLS is silent and non-breaking by design, an unexpected environment change could downgrade your connections from hybrid PQC to classical TLS **without throwing exceptions or failing requests**.
>
> If PQC is a mandatory requirement for your workload, you must implement automated verification in your CI/CD pipelines or startup health checks (see [Section 3](#3-how-to-verify-pqc-negotiation)).

### 2.1 Fallback Implications
When fallback occurs on either transport:
- **Application Availability (Preserved)**: Requests continue to succeed normally. No exceptions or errors are raised to application code.
- **Security Baseline (Preserved)**: Traffic remains fully encrypted with standard classical TLS 1.3 (e.g., ECDHE with AES-GCM), maintaining the standard security posture that Java applications use today.
- **Post-Quantum Protection (Absent)**: The connection will **not** be protected against future quantum decryption. Encrypted traffic archived by adversaries remains susceptible to future Store-Now, Decrypt-Later (SNDL) attacks.

### 2.2 Universal Fallback Triggers
- **Non-PQC Endpoints or Middleboxes**: If an intermediate corporate proxy, firewall, or endpoint does not support post-quantum key exchange (or strips unrecognized TLS 1.3 extensions), standard TLS 1.3 negotiation automatically selects classical `X25519`. This network-level fallback applies equally to both gRPC and HTTP/JSON transports.

### 2.3 gRPC Fallback Behavior
If native library linkage fails, Netty logs debug messages at `Level.FINE` and silently defaults to standard JDK TLS (`SunJSSE`):
```text
FINE: Failed to initialize netty-tcnative; OpenSslEngine will be unavailable.
FINE: Selecting JDK with provider SunJSSE version ...
```
Channels continue to operate normally with classical TLS, but post-quantum protection will be absent.

### 2.4 HTTP/JSON Fallback Behavior
- **Silent Fallback to Standard JDK TLS (`SunJSSE`)**: If Conscrypt native libraries fail to load (or are unavailable on the host platform), `gax-httpjson` catches the linkage error, logs a debug message at `Level.FINE`, and silently defaults to standard JDK TLS (`SunJSSE`):
  ```text
  FINE: Conscrypt native library unavailable. Falling back to default JDK TLS.
  ```
  See [Section 3](#3-how-to-verify-pqc-negotiation) for instructions on enabling internal logging or tracing TLS handshakes to verify whether your application is using PQC.
- **Common Host Triggers**:
  - **Alpine Linux (`musl` libc)**: Precompiled Conscrypt binaries require `glibc`. On `musl`-based distributions (e.g., `alpine`), Conscrypt cannot load and falls back to classical TLS. Use a `glibc`-compatible base image (such as Debian, Ubuntu, or Wolfi) for PQC.
  - **Hardened Filesystems (`noexec /tmp`)**: If `/tmp` is mounted with `noexec` or is read-only, Conscrypt cannot load extracted native libraries. To enable PQC, specify an executable directory via `-Dorg.conscrypt.native.workdir=/path/to/executable/dir`.

---

## 3. How to Verify PQC Negotiation

To confirm whether your application is actively negotiating post-quantum hybrid key exchange, choose the verification method matching your transport:

| Transport | Underlying TLS Engine | Verification Method | What to Look For |
| :--- | :--- | :--- | :--- |
| **gRPC** | Shaded Netty BoringSSL (JNI) | `-Dio.grpc.netty.shaded.io.netty.handler.ssl=DEBUG` | Handshake logs showing `HANDSHAKEN: TLS_AES_128_GCM_SHA256` |
| **HTTP/JSON** | Conscrypt BoringSSL (`SSLContext`) | `-Djavax.net.debug=ssl:handshake` | `ClientHello` offering `X25519MLKEM768` (`0x11ec`), `ServerHello` selecting `X25519MLKEM768` |
| **HTTP/JSON** | `gax-httpjson` Provider Bridge | `HttpJsonConscryptUtils` (`Level.FINE`) | Absence of fallback log (`FINE: Conscrypt native library unavailable...`) |

> [!NOTE]
> **Why gRPC ignores `-Djavax.net.debug`**:
> `grpc-netty-shaded` uses its own native BoringSSL engine rather than JDK JSSE. Standard JVM flags like `-Djavax.net.debug=ssl:handshake` only trace JSSE providers and will not output gRPC handshake logs. Use Netty debug logging instead.

### 3.1 Verifying gRPC Connections

Because `grpc-netty-shaded` encapsulates TLS within its native BoringSSL C engine, gRPC connections do not surface TLS 1.3 named groups directly to application code or response headers.

To inspect the TLS handshake parameters on gRPC channels, start your Java application with Netty SSL debug logging enabled:

```bash
java -Dio.grpc.netty.shaded.io.netty.handler.ssl=DEBUG -jar my-application.jar
```

During connection establishment with Google Cloud service endpoints, inspect standard error for Netty's handshake completion log:
```text
DEBUG io.grpc.netty.shaded.io.netty.handler.ssl.SslHandler - [id: 0x..., L:... - R:...] HANDSHAKEN: TLS_AES_128_GCM_SHA256
```
Because `grpc-netty-shaded` advertises `X25519MLKEM768` as its preferred named group, a successful TLS 1.3 handshake with Google Cloud endpoints confirms hybrid post-quantum key exchange negotiation.

### 3.2 Verifying HTTP/JSON Connections

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

## 4. Custom & Alternative Configurations

By default, client libraries automatically negotiate PQC when running in compatible environments without requiring custom code. If you need to customize transport behavior or security providers, configure the transport directly:

### 4.1 Custom gRPC Configurations

#### Option 1: Forcing Classical-Only Key Exchange (Disabling PQC)
If you need to use Netty's bundled BoringSSL engine for high-performance TLS but want to explicitly disable post-quantum hybrid groups, configure `OpenSslContextOption.GROUPS` on `SslContextBuilder`:

```java
InstantiatingGrpcChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultGrpcTransportProviderBuilder()
        .setChannelConfigurator(
            managedChannelBuilder -> {
              if (managedChannelBuilder instanceof NettyChannelBuilder) {
                try {
                  ((NettyChannelBuilder) managedChannelBuilder)
                      .sslContext(
                          GrpcSslContexts.forClient()
                              // Restrict offered groups exclusively to classical X25519
                              .option(OpenSslContextOption.GROUPS, new String[] {"X25519"})
                              .build());
                } catch (Exception e) {
                  throw new RuntimeException("Failed to configure gRPC SSL context", e);
                }
              }
              return managedChannelBuilder;
            })
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using classical X25519 TLS 1.3 via BoringSSL
}
```

#### Option 2: Bypassing BoringSSL to Use Standard JDK JSSE
If your deployment environment prohibits native JNI libraries or you prefer using the JVM's built-in cryptographic engine (`SunJSSE`):

```java
InstantiatingGrpcChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultGrpcTransportProviderBuilder()
        .setChannelConfigurator(
            managedChannelBuilder -> {
              if (managedChannelBuilder instanceof NettyChannelBuilder) {
                try {
                  ((NettyChannelBuilder) managedChannelBuilder)
                      .sslContext(
                          GrpcSslContexts.configure(
                                  SslContextBuilder.forClient(), SslProvider.JDK)
                              .build());
                } catch (Exception e) {
                  throw new RuntimeException("Failed to configure gRPC SSL context", e);
                }
              }
              return managedChannelBuilder;
            })
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using standard JDK JSSE TLS
}
```

---

### 4.2 Custom HTTP/JSON Configurations

#### Option 1: Forcing Classical-Only Key Exchange (Disabling PQC)
If you need to use Conscrypt for high-performance TLS but want to explicitly disable post-quantum hybrid groups:

```java
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

## 5. Environment & Runtime Considerations

Because PQC negotiation relies on native BoringSSL C binaries (bundled in `grpc-netty-shaded` and `conscrypt-openjdk-uber`) loaded over JNI, compatibility depends on the underlying runtime environment. Most standard Linux (`glibc`), macOS, and Windows environments support native execution out of the box.

### 5.1 GraalVM Native Image
GraalVM Native Image compilation is supported for applications that include the appropriate reachability metadata and JNI configuration for Netty or Conscrypt native libraries.

### 5.2 Classpath Isolation & Version Skew Warning
If your project uses multiple dependencies that transitively pull in different versions of gRPC Netty components or Conscrypt, JNI ABI mismatches can occur during JVM classloading. Always ensure your build tool resolves compatible versions consistently.

We recommend using Google Cloud's `libraries-bom` (version `26.88.0+`), which centrally manages dependency versions and ensures consistent, compatible runtime dependencies across all Google Cloud client libraries.

---

## 6. Native OpenJDK PQC Support (JDK 27+)

The OpenJDK community is integrating standardized post-quantum algorithms directly into the Java platform:
- **[JEP 496](https://openjdk.org/jeps/496) (ML-KEM)**: Introduces native implementations of NIST FIPS 203 (Module-Lattice-Based Key-Encapsulation Mechanism) into OpenJDK's standard security providers (`SunJSSE` and `SunJCE`), targeted for **JDK 27+**.
- **What this means for Google Cloud Java**: On JDK 27+, applications configuring standard JDK security providers (see **Option 2** in Section 4.1 and Section 4.2) will negotiate post-quantum TLS natively using `SunJSSE`, without requiring Conscrypt or JNI native shared libraries.
