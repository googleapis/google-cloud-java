# Post-Quantum Cryptography (PQC) User Guide for Java Client Libraries

## Overview

**Post-Quantum Cryptography (PQC)** refers to cryptographic algorithms designed to secure communications against future attacks by quantum computers. Quantum computers utilizing Shor's algorithm threaten traditional public-key algorithms (such as RSA and ECDH key exchange) by making it possible to retroactively decrypt intercepted TLS communications ("store-now, decrypt-later" attacks).

Google Cloud Java client libraries (via `gax-grpc` and `gax-httpjson`) provide out-of-the-box support for **hybrid PQC key exchange** (combining classical algorithms like `X25519` with post-quantum key encapsulation mechanisms like `ML-KEM-768` / `X25519MLKEM768`). This hybrid approach guarantees that security is at least as strong as traditional TLS 1.3 even if post-quantum algorithms encounter unforeseen implementation flaws, while protecting present-day encrypted traffic against future quantum decryption.

---

## Default Behavior

PQC support is **enabled by default** for both **gRPC** (`gax-grpc`) and **HTTP/JSON** (REST, `gax-httpjson`) transports in Google Cloud Java client libraries whenever native BoringSSL/Conscrypt libraries are available on the runtime environment.

### Transport Support Summary

| Transport | GAX Module | Underlying Transport Library | Native Engine | PQC Activation |
| :--- | :--- | :--- | :--- | :--- |
| **HTTP/JSON** | `gax-httpjson` | Google HTTP Client (`NetHttpTransport`) | Conscrypt (BoringSSL JNI) | Enabled via `google-http-java-client` Conscrypt provider API |
| **gRPC** | `gax-grpc` | gRPC-Java (`grpc-netty-shaded` / Netty) | Netty-tcnative (BoringSSL JNI) or Conscrypt | Built-in via gRPC-Java v1.83.0+ |

---

## Transport Implementation Details

The underlying TLS implementation and configuration mechanism differs between HTTP/JSON and gRPC.

### 1. HTTP/JSON Transport (`gax-httpjson` & `google-http-java-client`)

For REST/HTTP transport, PQC enablement relies on updates introduced in `google-http-java-client`:

- **`google-http-java-client` API Enhancements**: `NetHttpTransport.Builder` introduced `.setSecurityProvider(Provider)` and `.setSslSocketConfigurator(...)`. This allows higher-level libraries (like GAX) to register a specific Security Provider and customize `SSLSocket` / `SSLEngine` instances created by standard Java `HttpsURLConnection`.
- **GAX Integration (`HttpJsonConscryptUtils`)**: GAX uses these APIs to register **Conscrypt** as the security provider and set a socket configurator (`Conscrypt.setUseEngineSocket(socket, true)`).
- **TLS 1.3 Negotiation**: When HTTPS connections are opened, Conscrypt advertises `X25519MLKEM768` to Google Front End (GFE) endpoints during the TLS 1.3 handshake.

```
+-------------------------------------------------------------------+
|               GAPIC HTTP/JSON Client Request                      |
+-------------------------------------------------------------------+
                                  |
               Is Conscrypt JNI Available on Platform?
                                  |
                 +----------------+----------------+
                 |                                 |
              [ YES ]                           [ NO ]
                 |                                 |
                 v                                 v
   google-http-client registers Conscrypt     Falls back to JDK TLS (JSSE)
   Offers X25519MLKEM768 (PQC)                Offers Classical TLS (X25519)
```

### 2. gRPC Transport (`gax-grpc` & gRPC-Java v1.83.0+)

For gRPC transport, PQC key exchange is built into **gRPC-Java v1.83.0+**:

- **BoringSSL under the Hood**: gRPC-Java (`grpc-netty-shaded`) defaults to Netty's `netty-tcnative` (Netty's Tomcat Native JNI wrapper around **BoringSSL**). Like Conscrypt, it uses BoringSSL for C-level cryptographic execution.
- **gRPC-Java v1.83.0+ PQC Support**: Starting in version 1.83.0, `grpc-netty-shaded` has PQC hybrid key exchange (`X25519MLKEM768`) enabled by default for TLS 1.3 connections.
- **ALPN & Channel Pooling**: gRPC-Java advertises HTTP/2 (`h2`) via ALPN while offering `X25519MLKEM768` in the ClientHello. This negotiation operates seamlessly across all channels in GAX's `ChannelPoolSettings`.

```
+-------------------------------------------------------------------+
|                  GAPIC gRPC Client Request                        |
+-------------------------------------------------------------------+
                                  |
            gRPC-Java v1.83.0+ Netty Channel Builder
                                  |
            Is Netty-tcnative / Conscrypt JNI Available?
                                  |
                 +----------------+----------------+
                 |                                 |
              [ YES ]                           [ NO ]
                 |                                 |
                 v                                 v
   Netty SSLContext uses BoringSSL/Conscrypt  Netty uses Standard JDK JSSE
   Offers X25519MLKEM768 (PQC)                Offers Classical TLS (X25519)
```

---

## Conscrypt Capabilities & Supported Algorithms

Conscrypt provides high-performance TLS and cryptographic operations by wrapping BoringSSL via JNI native libraries.

> [!NOTE]
> For a full, up-to-date listing of named groups and capabilities supported across Conscrypt versions, refer to the official [Conscrypt Capabilities Documentation](https://github.com/google/conscrypt/blob/2.6.0/CAPABILITIES.md#supported-named-groups).

### Supported PQC & Hybrid Key Exchange Groups

Conscrypt supports several post-quantum and hybrid named groups for TLS 1.3 key exchange:

| Named Group Identifier | Description | Status in Conscrypt |
| :--- | :--- | :--- |
| `X25519MLKEM768` | Primary hybrid group combining X25519 ECDH with NIST FIPS 203 ML-KEM-768. | Recommended / Offered by Default |
| `SecP256r1MLKEM768` | Hybrid group combining NIST P-256 (secp256r1) with ML-KEM-768. | Supported |
| `X25519Kyber768Draft00` | Pre-standardization draft hybrid group combining X25519 with Kyber-768. | Legacy / Supported for backward compatibility |
| `MLKEM1024` | Standalone high-security post-quantum key encapsulation mechanism. | Supported |

### Supported Classical (Non-PQC) Groups

For environments or server endpoints where PQC key exchange is disabled or unsupported, Conscrypt falls back to classical named groups:

- `X25519` (Curve25519 ECDH)
- `SecP256r1` (NIST P-256 ECDH)
- `SecP384r1` (NIST P-384 ECDH)
- `SecP521r1` (NIST P-521 ECDH)

### What to Do If a Required Algorithm Is Unsupported

If your application or security policy mandates a specific PQC algorithm variant that Conscrypt does not support (or if you must use a custom security module):
1. Configure a custom Security Provider (such as Bouncy Castle) as described in [Alternatives & How to Configure Them](#alternatives--how-to-configure-them).
2. Explicitly override the transport builder's channel provider or `SSLContext`.

---

## Limitations of Native PQC Engines (Conscrypt & Netty-tcnative)

Both HTTP/JSON (via Conscrypt) and gRPC (via Netty-tcnative / BoringSSL) rely on C native shared libraries loaded via JNI. Consequently, **both transports share the same platform limitations**:

1. **JNI Native Binary Dependencies**:
   - Conscrypt uses `conscrypt-openjdk-uber`, which extracts `.so`, `.dylib`, or `.dll` native libraries into temporary directories at runtime.
   - `grpc-netty-shaded` embeds pre-compiled `netty-tcnative` BoringSSL native libraries into its JAR.

2. **System & GLIBC Compatibility Constraints**:
   - **Linux glibc Versioning**: Native C binaries require compatible C runtime (`glibc`) versions (e.g. `GLIBC_2.35+`). Older Linux enterprise distributions or base images with older `glibc` releases will fail to load native libraries (`UnsatisfiedLinkError`).
   - **Restricted / Read-Only Filesystems**: Environments that mount `/tmp` with `noexec`, strict container runtimes, Android/GraalVM native images without JNI support, or security managers blocking C library loading will prevent native PQC initialization.

3. **Graceful Fallback Behavior**:
   When native C libraries fail to load for either transport, the client libraries safely fall back to standard JDK JSSE:
   ```
   WARNING: Conscrypt native libraries not available. Falling back to JDK TLS.
   java.lang.UnsatisfiedLinkError: ... libc.so.6: version `GLIBC_2.35' not found
   ```
   The client will continue operating using classical TLS provided by the JDK.

---

## Alternatives & How to Configure Them

If you need to disable PQC, force classical key exchange, or use a custom TLS engine, you can configure alternative transport providers for both gRPC and HTTP/JSON.

### Alternative 1: Forcing Classical (Non-PQC) Key Exchange (HTTP/JSON)

To explicitly force classical key exchange (such as `X25519` or `SecP256r1`) for HTTP/JSON clients:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.HttpJsonConscryptUtils;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import org.conscrypt.Conscrypt;

// Step 1: Create NetHttpTransport configured with explicit classical named groups
NetHttpTransport transport =
    HttpJsonConscryptUtils.configureConscryptSecurityProvider(new NetHttpTransport.Builder())
        .setSslSocketConfigurator(
            socket -> {
              if (Conscrypt.isConscrypt(socket)) {
                try {
                  // Explicitly offer only classical X25519 (disabling PQC hybrid groups)
                  Conscrypt.setNamedGroups(socket, new String[] {"X25519"});
                } catch (Exception e) {
                  // Handle or log socket configuration failure
                }
              }
            })
        .build();

// Step 2: Build transport channel provider using custom transport
InstantiatingHttpJsonChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(transport)
        .build();

// Step 3: Instantiate client with settings
SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();
```

### Alternative 2: Forcing Classical (Non-PQC) Key Exchange (gRPC)

For gRPC clients, you can configure `InstantiatingGrpcChannelProvider` with custom Netty SSL context options to restrict key exchange groups:

```java
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;

InstantiatingGrpcChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultGrpcTransportProviderBuilder()
        .setChannelConfigurator(
            managedChannelBuilder -> {
              // Custom channel configuration to override SSL/TLS settings
            })
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();
```

### Alternative 3: Bypassing Conscrypt to Use Standard JDK JSSE (HTTP/JSON)

If you prefer to bypass Conscrypt completely and use the standard JDK JSSE provider:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;

// Build standard NetHttpTransport without Conscrypt configuration
NetHttpTransport standardTransport = new NetHttpTransport.Builder().build();

InstantiatingHttpJsonChannelProvider transportProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(standardTransport)
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client uses standard JDK JSSE TLS
}
```

### Alternative 4: Configuring Custom Security Providers (e.g., Bouncy Castle)

To use a third-party Security Provider (such as Bouncy Castle) for TLS:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import java.security.Provider;
import java.security.Security;
import javax.net.ssl.SSLContext;

// Register custom provider
Provider customProvider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
Security.addProvider(customProvider);

// Initialize custom SSLContext
SSLContext sslContext = SSLContext.getInstance("TLS", customProvider);
sslContext.init(null, null, null);

// Configure transport builder with custom SSLSocketFactory
NetHttpTransport customTransport =
    new NetHttpTransport.Builder()
        .setSslSocketFactory(sslContext.getSocketFactory())
        .build();

InstantiatingHttpJsonChannelProvider transportProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(customTransport)
        .build();
```

---

## Future Roadmap: JDK 27+ and Native JDK PQC Support

As quantum-resistant cryptography standards mature, Java is incorporating native PQC support directly into standard OpenJDK distributions.

> [!IMPORTANT]
> **JDK 27+ Native PQC Support**:
> Starting with JDK 27, standard JDK Security Providers (SunJSSE) will include native support for NIST post-quantum key encapsulation standards (JEP / ML-KEM).

### What JDK 27+ Means for Java SDK Users

1. **Zero-Dependency Native PQC**:
   On JDK 27 and future Java LTS releases, applications running standard OpenJDK will automatically negotiate PQC key exchange natively out-of-the-box—even without Conscrypt or JNI native dependencies.

2. **Forward Compatibility**:
   The GAX transport layer (`gax-grpc` and `gax-httpjson`) is designed so that when running on JDK 27+:
   - If native BoringSSL libraries (Conscrypt / Netty-tcnative) are present, they continue to offer hardware-accelerated PQC key exchange.
   - If native libraries are absent or disabled, the JDK's standard JSSE provider natively offers ML-KEM PQC key exchange.
   - Applications do not need to make any code or configuration changes when upgrading to JDK 27+.
