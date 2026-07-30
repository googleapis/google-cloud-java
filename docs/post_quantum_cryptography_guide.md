# Post-Quantum Cryptography (PQC) User Guide for HTTP/JSON Java Client Libraries

## 1. The Quantum Threat & Why PQC is Critical

### The Problem: Store-Now, Decrypt-Later (SNDL) Attacks
Traditional Transport Layer Security (TLS) relies on classical asymmetric public-key cryptography—such as RSA, Elliptic Curve Diffie-Hellman (`ECDH`), and `X25519`—to establish secure encrypted connections. While these classical algorithms are computationally secure against present-day classical computers, they are vulnerable to **Shor's algorithm** running on a cryptographically relevant quantum computer (CRQC).

An adversary does not need to wait for a quantum computer to be built before attacking classical encryption:
- **Harvest Now, Decrypt Later**: Threat actors can intercept and store encrypted TLS network traffic today.
- **Future Decryption**: Once a sufficiently powerful quantum computer becomes operational, adversaries will be able to retroactively break the classical Diffie-Hellman key exchange and decrypt long-lived confidential data collected years earlier.

### The Consequence of Not Using PQC
Without Post-Quantum Cryptography (PQC), any sensitive data transmitted across networks today—including authentication credentials, financial records, proprietary algorithms, and customer data—remains vulnerable to retroactive decryption in the future.

### The Solution: Hybrid PQC Key Exchange
To mitigate this threat immediately without sacrificing present-day security, Google Cloud HTTP/JSON Java client libraries support **Hybrid PQC Key Exchange**.
- A hybrid key exchange combines a classical ECDH algorithm (such as `X25519`) with a NIST-standardized Post-Quantum Key Encapsulation Mechanism (KEM), such as **ML-KEM-768** (FIPS 203), negotiated as `X25519MLKEM768`.
- This ensures that your communications remain at least as secure as standard classical TLS 1.3 against present-day attacks, while simultaneously protecting encrypted sessions against future quantum decryption.

---

## 2. Overview & Default Behavior in `gax-httpjson`

PQC support is **enabled by default** for **HTTP/JSON** (REST) transport in Google Cloud Java client libraries (`gax-httpjson`) whenever native Conscrypt / BoringSSL libraries are supported on the runtime environment.

> [!NOTE]
> This guide currently focuses on **HTTP/JSON (`gax-httpjson`)** client libraries. Support for gRPC (`gax-grpc`) is under active development and will be detailed in an upcoming release.

### Transport Support Summary

| Transport | GAX Module | Underlying HTTP Client | Cryptographic Engine | PQC Activation |
| :--- | :--- | :--- | :--- | :--- |
| **HTTP/JSON** | `gax-httpjson` | Google HTTP Client (`NetHttpTransport`) | Conscrypt (BoringSSL JNI) | **Enabled by Default** via `google-http-java-client` security provider API |

---

## 3. How to Verify That You Are Using PQC

You can verify that your HTTP/JSON client library is actively negotiating Post-Quantum Cryptography through operational logs, debug logging, or network traffic analysis.

### 1. Check Operational Log Messages
When Conscrypt initializes successfully and configures PQC named groups, **no warning logs are emitted**.

If your environment cannot load native Conscrypt libraries or cannot configure PQC groups, the library emits a concise, one-line warning at `Level.WARNING` and safely falls back to standard JDK TLS:
```
WARNING: Conscrypt native libraries not available. Falling back to JDK TLS.
```
If you **do not see this warning message** in your application logs, Conscrypt has successfully initialized and enabled PQC key exchange.

### 2. Enable Debug Logging (`Level.FINE`)
To inspect the exact initialization status and any underlying native library loader exceptions, enable debug logging (`Level.FINE`) for `com.google.api.gax.httpjson.HttpJsonConscryptUtils`:

- In `logging.properties`:
  ```properties
  com.google.api.gax.httpjson.HttpJsonConscryptUtils.level = FINE
  ```
- If an error occurs during initialization, the full exception stacktrace (`UnsatisfiedLinkError`, `LinkageError`, etc.) will appear only at `FINE` level:
  ```
  FINE: Conscrypt initialization failed with exception: java.lang.UnsatisfiedLinkError: ...
  ```

### 3. Packet & Handshake Inspection
During a TLS 1.3 handshake with Google Front End (GFE) services, you can verify PQC negotiation using network analysis tools (such as Wireshark or OpenSSL `s_client`):
- **ClientHello**: Inspect the TLS `supported_groups` extension (Extension 10). When PQC is active, `X25519MLKEM768` (Group ID `0x4543` / `17731` or standardized IANA PQC identifier) is advertised in the ClientHello.
- **ServerHello**: The GFE endpoint selects `X25519MLKEM768` in the `key_share` extension, confirming that hybrid post-quantum key agreement was established for the connection.

---

## 4. HTTP/JSON Transport Implementation Details (`gax-httpjson` & `google-http-java-client`)

PQC enablement for REST/HTTP transport relies on architecture enhancements in `google-http-java-client` and `gax-httpjson`:

1. **`NetHttpTransport.Builder` API Enhancements**:
   - `NetHttpTransport.Builder` provides `.setSecurityProvider(Provider)` and `.setSslSocketConfigurator(SslSocketConfigurator)`.
   - This allows GAX to inject an explicit cryptographic `Provider` and configure raw `SSLSocket` instances created by standard Java `HttpsURLConnection`.
2. **GAX Conscrypt Registration (`HttpJsonConscryptUtils`)**:
   - `InstantiatingHttpJsonChannelProvider` automatically invokes `HttpJsonConscryptUtils.configureConscryptSecurityProvider(builder)`.
   - This registers Conscrypt as the socket provider and attaches a socket configurator that enables BoringSSL engine sockets (`Conscrypt.setUseEngineSocket(socket, true)`) and prefers hybrid PQC groups (`Conscrypt.setNamedGroups(socket, new String[] {"X25519MLKEM768", ...})`).
3. **TLS 1.3 Handshake Negotiation**:
   - When HTTP connections are established, Conscrypt advertises `X25519MLKEM768` to Google Cloud endpoints, establishing a quantum-resistant TLS 1.3 channel.

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
   google-http-client uses Conscrypt         Falls back to JDK JSSE
   Offers X25519MLKEM768 (PQC Hybrid)        Offers Classical X25519
```

---

## 5. Conscrypt Capabilities & Supported Algorithms

Conscrypt provides high-performance TLS and cryptographic operations by wrapping BoringSSL via JNI native libraries.

> [!NOTE]
> For a full listing of named groups and capabilities supported across Conscrypt versions, refer to the official [Conscrypt Capabilities Documentation](https://github.com/google/conscrypt/blob/2.6.0/CAPABILITIES.md#supported-named-groups).

### Supported PQC & Hybrid Key Exchange Groups

| Named Group Identifier | Description | Status in Conscrypt |
| :--- | :--- | :--- |
| **`X25519MLKEM768`** | Primary hybrid group combining X25519 ECDH with NIST FIPS 203 ML-KEM-768. | Recommended / Offered by Default |
| **`SecP256r1MLKEM768`** | Hybrid group combining NIST P-256 (`secp256r1`) with ML-KEM-768. | Supported |
| **`X25519Kyber768Draft00`** | Pre-standardization draft hybrid group combining X25519 with Kyber-768. | Legacy / Backward compatible |
| **`MLKEM1024`** | Standalone high-security post-quantum key encapsulation mechanism. | Supported |

### Supported Classical (Non-PQC) Groups

For environments or endpoints where PQC key exchange is disabled or unsupported, Conscrypt falls back to standard classical named groups:
- `X25519` (Curve25519 ECDH)
- `SecP256r1` (NIST P-256 ECDH)
- `SecP384r1` (NIST P-384 ECDH)
- `SecP521r1` (NIST P-521 ECDH)

---

## 6. Platform Compatibility & Native Library Limitations

Because Conscrypt relies on C native shared libraries (`conscrypt-openjdk-uber`) loaded via Java Native Interface (JNI), PQC support depends on OS platform compatibility:

1. **System & GLIBC Compatibility Constraints**:
   - **Linux glibc Versioning**: Conscrypt native C binaries require compatible C runtime (`glibc`) versions (such as `GLIBC_2.35+`). Older Linux distributions or lightweight images (such as Alpine Linux using `musl` libc) will fail to load native libraries (`UnsatisfiedLinkError`).
   - **Restricted Filesystems**: Operating systems that mount `/tmp` with `noexec`, strict container security profiles, or environments blocking JNI library extraction will prevent Conscrypt from initializing.

2. **Graceful Fallback Behavior**:
   - Whenever native library loading fails, `gax-httpjson` catches the error, logs a concise warning at `Level.WARNING`, and safely falls back to standard JDK JSSE:
     ```
     WARNING: Conscrypt native libraries not available. Falling back to JDK TLS.
     ```
   - Your application will continue running normally using classical TLS provided by the JDK.

---

## 7. Mutual TLS (mTLS) Support with PQC

Google Cloud HTTP/JSON client libraries support **Mutual TLS (mTLS)** client certificate authentication alongside PQC hybrid key exchange.

- When mTLS is enabled (via `GOOGLE_API_USE_CLIENT_CERTIFICATE="true"` in the system environment or via an explicit `MtlsProvider`), `InstantiatingHttpJsonChannelProvider` configures client certificate keystores and server trust stores.
- The trust manager factory is automatically initialized using the PKIX trust manager (`TrustManagerFactory.getInstance("PKIX", conscryptProvider)`), ensuring seamless compatibility with Conscrypt's TLS 1.3 engine and PQC named groups.

---

## 8. Custom & Alternative Configurations

If you need to disable PQC, force classical key exchange, bypass Conscrypt, or use a third-party security provider, you can customize the transport provider.

### Alternative 1: Forcing Classical (Non-PQC) Key Exchange

To explicitly restrict key exchange to classical `X25519` (disabling post-quantum hybrid groups):

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.HttpJsonConscryptUtils;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
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
                  // Ignore or log socket configuration failure
                }
              }
            })
        .build();

// Step 2: Build transport channel provider using the custom transport
InstantiatingHttpJsonChannelProvider transportChannelProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(transport)
        .build();

// Step 3: Instantiate client with settings
SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportChannelProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using classical X25519 TLS 1.3
}
```

### Alternative 2: Bypassing Conscrypt to Use Standard JDK JSSE

To bypass Conscrypt completely and use the standard JDK JSSE TLS provider:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;

// Build a standard NetHttpTransport without GAX Conscrypt configuration
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
  // Client communicates using standard JDK JSSE TLS
}
```

### Alternative 3: Configuring Custom Security Providers (Locally Scoped to `NetHttpTransport`)

If your application requires a custom cryptographic provider (such as Bouncy Castle), you can configure it **locally on the specific `NetHttpTransport` instance without modifying the global JVM `Security` provider table**:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import java.security.KeyStore;
import java.security.Provider;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

// Step 1: Instantiate custom security provider (without calling Security.addProvider globally)
Provider customProvider = new org.bouncycastle.jce.provider.BouncyCastleProvider();

// Step 2: Initialize TrustManagerFactory and SSLContext locally using customProvider
TrustManagerFactory tmf = TrustManagerFactory.getInstance("PKIX", customProvider);
tmf.init((KeyStore) null); // Loads standard JDK cacerts trust store

SSLContext sslContext = SSLContext.getInstance("TLS", customProvider);
sslContext.init(null, tmf.getTrustManagers(), null);

// Step 3: Configure NetHttpTransport to use the locally scoped SSLSocketFactory
NetHttpTransport customTransport =
    new NetHttpTransport.Builder()
        .setSslSocketFactory(sslContext.getSocketFactory())
        .build();

InstantiatingHttpJsonChannelProvider transportProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(customTransport)
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using Bouncy Castle TLS scoped strictly to this transport
}
```

---

## 9. Future Roadmap

### gRPC Client Library Support
Out-of-the-box PQC support for gRPC client libraries (`gax-grpc`) is under active development and will be detailed in an upcoming release.

### JDK 27+ Native JDK PQC Support
As quantum-resistant cryptography standards mature, OpenJDK is incorporating native PQC support directly into standard Java releases:
- Starting with **JDK 27**, standard JDK Security Providers (`SunJSSE`) will include native support for NIST post-quantum key encapsulation standards (JEP / ML-KEM).
- When running on JDK 27+, Java applications will automatically negotiate ML-KEM PQC key exchange out-of-the-box—without requiring Conscrypt or JNI native dependencies.
- No code or configuration changes will be required in Google Cloud Java client libraries when upgrading to JDK 27+.
