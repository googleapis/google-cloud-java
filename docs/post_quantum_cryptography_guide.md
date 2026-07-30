# Post-Quantum Cryptography (PQC) User Guide for HTTP/JSON Java Client Libraries

## 1. The Quantum Threat & Why PQC is Critical

Traditional TLS public-key encryption (such as RSA and ECDH) is vulnerable to future decryption by quantum computers.

- **The Risk ("Store-Now, Decrypt-Later")**: Adversaries can intercept and store encrypted network traffic today with the intent to decrypt it once cryptographically relevant quantum computers become available.
- **The Consequence**: Without Post-Quantum Cryptography (PQC), sensitive data transmitted today—such as credentials, financial records, and customer data—is at risk of retroactive decryption in the future.
- **The Solution (Hybrid PQC)**: Google Cloud HTTP/JSON Java client libraries support **Hybrid PQC Key Exchange** (such as `X25519MLKEM768`), combining a classical ECDH algorithm (like `X25519`) with a NIST-standardized Post-Quantum Key Encapsulation Mechanism (like `ML-KEM-768`, FIPS 203). This protects encrypted traffic against both present-day and future quantum threats without sacrificing existing security.

---

## 2. HTTP/JSON (REST) Client Library Support

Post-Quantum Cryptography is **enabled by default** for **HTTP/JSON** (REST) transport in Google Cloud Java client libraries (`gax-httpjson`) whenever native Conscrypt / BoringSSL libraries are supported on the runtime environment.

### 2.1 Minimum Required Versions

PQC enablement for HTTP/JSON transport requires compatible versions of `conscrypt-openjdk-uber`, `gax-httpjson`, and `google-http-client`:

> [!TIP]
> **Recommended BOM**:
> We recommend importing Google Cloud Java libraries using **`libraries-bom` version `26.86.0+`**, which automatically manages compatible dependency versions across all Google Cloud client libraries, GAX, and the Google HTTP Client.

| Library | Minimum Required Version | Role |
| :--- | :--- | :--- |
| **`conscrypt-openjdk-uber`** | `2.6.0+` | Provides BoringSSL native C engine and TLS 1.3 PQC hybrid named groups. |
| **`gax-httpjson`** | `2.83.0+` | Automatically registers Conscrypt as the TLS security provider and configures PQC named groups. |
| **`google-http-client`** | `2.2.0+` | Provides security provider registration and socket configurators on `NetHttpTransport.Builder`. |

### 2.2 Why Conscrypt?

Standard Java Development Kits (JDK 8, 11, 17, and 21) do not natively support Post-Quantum Cryptography in their built-in TLS providers (`SunJSSE`). While native ML-KEM support is planned for **JDK 27+**, requiring all users to upgrade to JDK 27 is not feasible for most production environments.

We chose **Conscrypt** (`conscrypt-openjdk-uber`) because:
1. **Maximum Java & OS Compatibility**: Conscrypt wraps Google's BoringSSL cryptographic engine via JNI, enabling quantum-resistant TLS 1.3 handshakes across existing Java LTS runtimes (Java 8, 11, 17, 21, and 25).
2. **Zero Runtime Configuration Required**: By bundling Conscrypt as an optional dependency, `gax-httpjson` delivers high-performance PQC out-of-the-box without requiring users to replace their JVM or upgrade their JDK.

### 2.3 How HTTP/JSON Clients and Google Cloud Servers Work Together

When you construct a Google Cloud HTTP/JSON service client, `gax-httpjson` registers Conscrypt on the Google HTTP Client (`NetHttpTransport`) to advertise PQC and classical groups in preference order:

- **PQC-Enabled Endpoints (GFE)**: During the TLS 1.3 handshake, Google Front End servers select `X25519MLKEM768` (#1 preference), establishing a quantum-resistant session.
- **Non-PQC Endpoints**: Endpoints that do not support PQC ignore unknown post-quantum identifiers and select the first compatible classical algorithm (such as `X25519`).
- **Platform Runtime Fallback**: If Conscrypt native libraries cannot load on the OS, the client logs a concise warning and falls back to standard JDK JSSE (`SunJSSE`).

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
   Offers PQC Hybrid + Classical Groups      Offers Standard JDK Classical Groups
   - Server selects 1st compatible group     - Server negotiates Classical
   - Negotiates X25519MLKEM768 on            - Negotiates Classical X25519 /
     Google Cloud Front End (GFE)              secp256r1 via JDK TLS
   - Automatically falls back to X25519
     on older non-PQC servers
```

### 2.4 Supported Key Exchange Groups

Google Cloud HTTP/JSON client libraries configure Conscrypt to advertise the following named groups in preference order:

1. `X25519MLKEM768`
2. `SecP256r1MLKEM768`
3. `MLKEM1024`
4. `MLKEM768`
5. `X25519Kyber768Draft00` *(deprecated draft group kept for backward compatibility)*
6. `X25519`
7. `secp256r1`
8. `secp384r1`

For additional details on Conscrypt's cryptographic algorithms and capabilities, refer to the official [Conscrypt CAPABILITIES.md](https://github.com/google/conscrypt/blob/2.6.0/CAPABILITIES.md#supported-named-groups).

### 2.5 Platform Compatibility & Native Library Limitations

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

### 2.6 Verifying PQC in HTTP/JSON Client Libraries

You can verify that your Google Cloud HTTP/JSON Java client library is actively negotiating Post-Quantum Cryptography through operational logs or debug logging. Note that the log messages and logger categories below apply specifically to HTTP/JSON (REST) client libraries.

#### 1. Check Operational Log Messages
When Conscrypt initializes successfully and configures PQC named groups, **no warning logs are emitted**.

If your environment cannot load native Conscrypt libraries or cannot configure PQC groups, the library emits a concise, one-line warning at `Level.WARNING` and safely falls back to standard JDK TLS:
```
WARNING: Conscrypt native libraries not available. Falling back to JDK TLS.
```
If you **do not see this warning message** in your application logs, Conscrypt has successfully initialized and enabled PQC key exchange.

#### 2. Enable Debug Logging (`Level.FINE`)
To inspect the exact initialization status and any underlying native library loader exceptions, enable debug logging (`Level.FINE`) for `com.google.api.gax.httpjson.HttpJsonConscryptUtils`:

- In `logging.properties`:
  ```properties
  com.google.api.gax.httpjson.HttpJsonConscryptUtils.level = FINE
  ```
- If an error occurs during initialization, the full exception stacktrace (`UnsatisfiedLinkError`, `LinkageError`, etc.) will appear only at `FINE` level:
  ```
  FINE: Conscrypt initialization failed with exception: java.lang.UnsatisfiedLinkError: ...
  ```

### 2.7 Custom & Alternative Configurations

If you need to disable PQC, force classical key exchange, bypass Conscrypt, or use a third-party security provider, you can customize the transport provider.

#### Alternative 1: Forcing Classical (Non-PQC) Key Exchange

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

#### Alternative 2: Bypassing Conscrypt to Use Standard JDK JSSE

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

#### Alternative 3: Configuring Custom Security Providers

If your application requires a custom cryptographic provider (such as Bouncy Castle), you can configure it on a specific `NetHttpTransport` instance using `NetHttpTransport.Builder.setSecurityProvider(...)` and `.setSslSocketConfigurator(...)`:

```java
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import java.security.Provider;

// Step 1: Instantiate custom security provider
Provider customProvider = new org.bouncycastle.jce.provider.BouncyCastleProvider();

// Step 2: Configure NetHttpTransport with custom security provider and SSLSocketConfigurator
NetHttpTransport customTransport =
    new NetHttpTransport.Builder()
        .setSecurityProvider(customProvider)
        .setSslSocketConfigurator(
            socket -> {
              // Configure custom SSLSocket options (e.g., cipher suites, protocols, or named groups)
            })
        .build();

// Step 3: Build transport provider and service client
InstantiatingHttpJsonChannelProvider transportProvider =
    SecretManagerServiceSettings.defaultHttpJsonTransportProviderBuilder()
        .setHttpTransport(customTransport)
        .build();

SecretManagerServiceSettings settings =
    SecretManagerServiceSettings.newHttpJsonBuilder()
        .setTransportChannelProvider(transportProvider)
        .build();

try (SecretManagerServiceClient client = SecretManagerServiceClient.create(settings)) {
  // Client communicates using custom security provider scoped strictly to this transport
}
```

---

## 3. Addendum: JDK 27+ and Native OpenJDK PQC Support

As quantum-resistant cryptography standards mature, OpenJDK is incorporating native PQC support directly into standard Java releases:
- Starting with **JDK 27**, standard JDK Security Providers (`SunJSSE`) include native support for NIST post-quantum key encapsulation standards (JEP / ML-KEM).
- **Google Cloud Java Client Libraries**: Google Cloud Java client SDKs use Conscrypt by default whenever it is available on the platform (delivering hardware-accelerated BoringSSL performance across all Java releases).
- **Your Own Applications**: For your own Java applications or non-Conscrypt HTTPS connections running on JDK 27 or later, standard OpenJDK Security Providers automatically negotiate ML-KEM PQC key exchange out-of-the-box—even without Conscrypt or JNI native dependencies.
- No code or configuration changes are required in Google Cloud Java client libraries when running on JDK 27+.
