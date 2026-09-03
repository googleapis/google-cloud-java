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

---

## 1. gRPC Transport (Default)

gRPC is the default transport across Google Cloud Java client libraries.

### 1.1 Minimum Required Versions
We recommend using Google Cloud's **`libraries-bom` (version `26.88.0+`)** to guarantee that dependencies have compatible, required versions.

If managing dependencies directly, ensure the following minimum versions are present:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`gax-grpc`** | `2.85.0+` | Configures and manages gRPC channel providers and client settings. |
| **`grpc-netty-shaded`** | `1.76.0+` | Upstream transport bundling Google's BoringSSL engine and native TLS 1.3 PQC hybrid named groups. |

### 1.2 Transport Architecture & Bundled BoringSSL Engine
Built-in Java Development Kits (Java 8 - 26) do not support Post-Quantum Cryptography in their default Java Secure Socket Extension provider (`SunJSSE`). Native ML-KEM support is planned for future Java releases (**JDK 27+** via [JEP 496](https://openjdk.org/jeps/496)).

To bridge until users can upgrade to JDK 27+, `grpc-java` bundles a shaded version of Netty with native BoringSSL binaries (`grpc-netty-shaded`):
- **Bypasses JDK Security Providers**: Because `grpc-netty-shaded` executes TLS via its bundled BoringSSL C engine over JNI (`netty-tcnative`), it operates independently of the JVM's installed `java.security` providers. Post-quantum hybrid key exchange is available regardless of the underlying JDK version (Java 8 - 26).
- **No JVM-Wide Side Effects**: The bundled native engine is used exclusively by gRPC channels and does not affect the rest of your JVM application.

### 1.3 Supported Key Exchange Algorithms & Negotiation
When a gRPC client establishes a channel with Google Cloud endpoints, `grpc-netty-shaded` advertises supported key exchange groups with `X25519MLKEM768` preferred.

Because Google Cloud servers support PQC algorithms, `X25519MLKEM768` will typically be selected. If an intermediate proxy or server does not support post-quantum cryptography, standard TLS 1.3 negotiation automatically falls back to a mutually supported classical group (`X25519`).

### 1.4 How to Verify gRPC PQC Negotiation
Because `grpc-netty-shaded` bypasses the JDK's built-in JSSE provider, standard JVM flags like `-Djavax.net.debug=ssl:handshake` will not capture gRPC TLS handshake details.

#### Method 1: Netty SSL Debug Logging
Enable debug logging for Netty's shaded SSL handler to observe the TLS handshake parameters:

```bash
java -Dio.grpc.netty.shaded.io.netty.handler.ssl=DEBUG -jar my-application.jar
```

#### Method 2: gRPC Client Interceptor Verification
In integration tests or debugging workflows, attach a `ClientInterceptor` to inspect response headers or channel metadata:

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

### 1.5 Custom gRPC Configurations
If you need to configure custom Netty SSL contexts (such as custom trust certificates or cipher suites):

```java
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

InstantiatingGrpcChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultGrpcTransportProviderBuilder()
        .setChannelConfigurator(
            managedChannelBuilder -> {
              if (managedChannelBuilder instanceof NettyChannelBuilder) {
                try {
                  ((NettyChannelBuilder) managedChannelBuilder)
                      .sslContext(
                          GrpcSslContexts.forClient()
                              // Custom SSL options (e.g., trust managers or ciphers)
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
  // Client communicates using customized gRPC channel
}
```

---

## 2. HTTP/JSON (REST) Transport

HTTP/JSON (REST) transport is used by clients configured explicitly for REST communication.

### 2.1 Minimum Required Versions
We recommend using Google Cloud's **`libraries-bom` (version `26.86.0+`)** to guarantee that dependencies have compatible, required versions.

If managing dependencies directly, ensure the following minimum versions are present:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`gax-httpjson`** | `2.83.0+` | Automatically configures Conscrypt as the TLS security provider and sets PQC named groups. |
| **`google-http-client`** | `2.2.0+` | Provides transport-level security provider registration on `NetHttpTransport.Builder`. |
| **`conscrypt-openjdk-uber`** | `2.6.0+` *(2.6.2+ recommended)* | Provides Google's BoringSSL native C engine and TLS 1.3 PQC hybrid named groups. |

### 2.2 Transport Architecture & Scoped Conscrypt Provider
Built-in Java Development Kits (Java 8 - 26) do not support Post-Quantum Cryptography in their default Java Secure Socket Extension provider (`SunJSSE`). While native ML-KEM support is in development for future Java releases (**JDK 27+** via [JEP 496](https://openjdk.org/jeps/496)), requiring all production enterprise workloads to immediately upgrade to bleeding-edge JDK versions is impractical.

To bridge until users can upgrade to JDK 27+, HTTP/JSON transport uses **Conscrypt** (`conscrypt-openjdk-uber`):
- **BoringSSL via JNI**: Conscrypt embeds Google's BoringSSL engine, providing hybrid post-quantum key exchange across Java 8 - 26.
- **Scoped Security Provider (No Global JVM Impact)**: The Google Cloud Java SDK scopes Conscrypt strictly to Google Cloud client requests and avoids modifying global JVM security defaults. As a result, enabling Conscrypt for Google Cloud calls **does not alter the TLS behavior, cipher suites, or security providers of any other HTTP clients or libraries** in your application (e.g., Apache HttpClient, Spring WebClient, OkHttp, or direct `HttpsURLConnection` calls).

### 2.3 Supported Key Exchange Algorithms & Preference Order
Based on [Conscrypt's supported named groups](https://github.com/google/conscrypt/blob/2.6.2/CAPABILITIES.md#supported-named-groups), HTTP/JSON clients advertise supported key exchange groups in the following preference order:
1. `X25519MLKEM768` *(Hybrid Post-Quantum Key Exchange)*
2. `MLKEM1024` *(Pure Post-Quantum Key Exchange)*
3. `X25519` *(Classical ECDH)*
4. `secp256r1` *(Classical ECDH)*
5. `secp384r1` *(Classical ECDH)*

Because Google Cloud servers support PQC algorithms, `X25519MLKEM768` will typically be selected. If an intermediate proxy or non-PQC endpoint does not support post-quantum cryptography, standard TLS 1.3 negotiation selects the first mutually supported classical group (`X25519`).

### 2.4 Classical Fallback

> [!WARNING]
> **Active Verification is Required for Regulatory Mandates**:
> If your organization operates under strict compliance, governmental, or corporate security mandates requiring Post-Quantum Cryptography today, **you cannot rely solely on the default configuration without verification**.
>
> Because fallback to classical TLS is silent and non-breaking by design, an unexpected environment change could downgrade your connections from hybrid PQC to classical TLS **without throwing exceptions or failing requests**.
>
> If PQC is a mandatory requirement for your workload, you must implement automated verification in your CI/CD pipelines or startup health checks (see **Section 2.5**).

#### Fallback Implications
When fallback occurs:
- **Application Availability (Preserved)**: Requests continue to succeed normally. No exceptions or errors are raised to application code.
- **Security Baseline (Preserved)**: Traffic remains fully encrypted with standard classical TLS 1.3 (e.g., ECDHE with AES-GCM), maintaining the standard security posture that Java applications use today.
- **Post-Quantum Protection (Absent)**: The connection will **not** be protected against future quantum decryption. Encrypted traffic archived by adversaries remains susceptible to future Store-Now, Decrypt-Later (SNDL) attacks.

#### How to Detect Fallback
If Conscrypt native libraries fail to load (or are unavailable on the host platform), `gax-httpjson` catches the linkage error, logs a debug message at `Level.FINE`, and defaults to standard JDK TLS (`SunJSSE`):
```text
FINE: Conscrypt native library unavailable. Falling back to default JDK TLS.
```
See **Section 2.5** for instructions on enabling internal logging or tracing TLS handshakes to verify whether your application is using PQC.

#### Common Triggers for Fallback
- **Alpine Linux (`musl` libc)**: Precompiled Conscrypt binaries require `glibc`. On `musl`-based distributions (e.g., `alpine`), Conscrypt cannot load and falls back to classical TLS. Use a `glibc`-compatible base image (such as Debian, Ubuntu, or Wolfi) for PQC.
- **Hardened Filesystems (`noexec /tmp`)**: If `/tmp` is mounted with `noexec` or is read-only, Conscrypt cannot load extracted native libraries. To enable PQC, specify an executable directory via `-Dorg.conscrypt.native.workdir=/path/to/executable/dir`.
- **Non-PQC Endpoints or Middleboxes**: If a network proxy or endpoint does not support PQC, TLS 1.3 negotiation automatically selects classical `X25519`.

### 2.5 How to Verify HTTP/JSON PQC Negotiation

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

### 2.6 Custom HTTP/JSON Configurations
If you need to customize transport behavior or security providers for HTTP/JSON clients:

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

## 3. Environment & Runtime Considerations

Because PQC negotiation relies on native BoringSSL C binaries (bundled in `grpc-netty-shaded` and `conscrypt-openjdk-uber`) loaded over JNI, compatibility depends on the underlying runtime environment. Most standard Linux (`glibc`), macOS, and Windows environments support native execution out of the box.

### 3.1 GraalVM Native Image
GraalVM Native Image compilation is supported for applications that include the appropriate reachability metadata and JNI configuration for Netty or Conscrypt native libraries.

### 3.2 Classpath Isolation & Version Skew Warning
If your project uses multiple dependencies that transitively pull in different versions of gRPC Netty components or Conscrypt, JNI ABI mismatches can occur during JVM classloading. Always ensure your build tool resolves compatible versions consistently.

We recommend using Google Cloud's `libraries-bom` (version `26.88.0+`), which centrally manages dependency versions and ensures consistent, compatible runtime dependencies across all Google Cloud client libraries.

---

## 4. Future Outlook: Native OpenJDK PQC Support (JDK 27+)

The cryptographic landscape is continually advancing. The OpenJDK community is integrating standardized post-quantum algorithms directly into the Java platform:
- **[JEP 496](https://openjdk.org/jeps/496) (ML-KEM)**: Introduces native implementations of NIST FIPS 203 (Module-Lattice-Based Key-Encapsulation Mechanism) into OpenJDK's standard security providers (`SunJSSE` and `SunJCE`), targeted for **JDK 27+**.
- **What this means for Google Cloud Java**: Once JDK 27 becomes standard in production environments, Java applications will be capable of negotiating hybrid and pure post-quantum TLS natively without requiring JNI shared libraries or third-party dependencies like Conscrypt or `netty-tcnative`.
- **Future-Proofing**: As native JDK capabilities mature, Google Cloud Java client libraries will adapt to take advantage of built-in JVM providers, preserving a seamless, zero-maintenance security upgrade path for all users across both gRPC and HTTP/JSON transports.
