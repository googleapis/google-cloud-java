# Post-Quantum Cryptography (PQC) User Guide for HTTP/JSON Java Client Libraries

## 1. The Quantum Threat & Why PQC is Critical

Traditional TLS public-key encryption (such as RSA and ECDH) is vulnerable to future decryption by quantum computers.

- **The Risk ("Store-Now, Decrypt-Later")**: Adversaries can intercept and store encrypted network traffic today with the intent to decrypt it once cryptographically relevant quantum computers become available.
- **The Consequence**: Without Post-Quantum Cryptography (PQC), sensitive data transmitted today—such as credentials, financial records, and customer data—is at risk of retroactive decryption in the future.
- **The Solution (Hybrid PQC)**: Google Cloud HTTP/JSON Java client libraries support **Hybrid PQC Key Exchange** (such as `X25519MLKEM768`), combining a classical ECDH algorithm (like `X25519`) with a NIST-standardized Post-Quantum Key Encapsulation Mechanism (like `ML-KEM-768`, FIPS 203). This protects encrypted traffic against both present-day and future quantum threats without sacrificing existing security.

---

## 2. Overview & Default Behavior in `gax-httpjson`

PQC support is **enabled by default** for **HTTP/JSON** (REST) transport in Google Cloud Java client libraries (`gax-httpjson`) whenever native Conscrypt / BoringSSL libraries are supported on the runtime environment.

### Transport Support Summary

| Transport | GAX Module | Underlying HTTP Client | Cryptographic Engine | PQC Activation |
| :--- | :--- | :--- | :--- | :--- |
| **HTTP/JSON** | `gax-httpjson` | Google HTTP Client (`NetHttpTransport`) | Conscrypt (BoringSSL JNI) | **Enabled by Default** via `google-http-java-client` security provider API |

---

## 3. How to Verify That You Are Using PQC in Google Cloud Java Client Libraries

You can verify that your Google Cloud HTTP/JSON Java client library is actively negotiating Post-Quantum Cryptography through operational logs, debug logging, or network traffic analysis.

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
During a TLS 1.3 handshake with Google Front End (GFE) services, you can verify PQC negotiation by inspecting the handshake packets:
- **ClientHello**: Inspect the TLS `supported_groups` extension (Extension 10). When PQC is active, `X25519MLKEM768` (Group ID `0x4543` / `17731` or standardized IANA PQC identifier) is advertised in the ClientHello.
- **ServerHello**: The GFE endpoint selects `X25519MLKEM768` in the `key_share` extension, confirming that hybrid post-quantum key agreement was established for the connection.

---

## 4. Architecture & Minimum Required Versions

PQC enablement for HTTP/JSON transport requires compatible versions of `gax-httpjson` and `google-http-client`:

> [!TIP]
> **Recommended BOM**:
> We recommend importing Google Cloud Java libraries using **`libraries-bom` version `26.86.0+`**, which automatically manages compatible dependency versions across all Google Cloud client libraries, GAX, and the Google HTTP Client.

### Minimum Required Versions

| Library | Minimum Required Version | Role |
| :--- | :--- | :--- |
| **`gax-httpjson`** | `2.83.0+` | Automatically registers Conscrypt as the TLS security provider and configures PQC named groups. |
| **`google-http-client`** | `2.2.0+` | Provides security provider registration and socket configurators on `NetHttpTransport.Builder`. |

### How GAX and Google Cloud Servers Work Together

When you construct a Google Cloud HTTP/JSON service client, `gax-httpjson` automatically registers Conscrypt as the underlying cryptographic provider on the Google HTTP Client (`NetHttpTransport`).

- **Negotiation with Google Cloud Servers**: During the TLS 1.3 handshake, `gax-httpjson` advertises Post-Quantum Cryptography named groups (`X25519MLKEM768`, etc.) in preference order alongside classical TLS groups. When connecting to Google Cloud Front End (GFE) endpoints, the server evaluates the client's list from top to bottom and **selects the first compatible algorithm from the list that it also supports**—in this case, `X25519MLKEM768` (#1 preference), establishing an authenticated post-quantum session.
- **Transparent Endpoint Compatibility**: When connecting to endpoints that do not yet support PQC, the server skips the unknown post-quantum identifiers at the top of the list and selects **the first compatible algorithm from the client's list that it recognizes** (such as classical `X25519`), transparently negotiating standard TLS without dropping the connection.
- **Platform Runtime Fallback**: If the runtime environment cannot load native Conscrypt libraries, `gax-httpjson` catches the error, logs a concise warning, and falls back to standard JDK JSSE (`SunJSSE`), ensuring network connectivity is never broken.

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

---

## 5. Supported Key Exchange Groups

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

## 7. Custom & Alternative Configurations

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

### Alternative 3: Configuring Custom Security Providers

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

## 8. Addendum: JDK 27+ and Native OpenJDK PQC Support

As quantum-resistant cryptography standards mature, OpenJDK is incorporating native PQC support directly into standard Java releases:
- Starting with **JDK 27**, standard JDK Security Providers (`SunJSSE`) include native support for NIST post-quantum key encapsulation standards (JEP / ML-KEM).
- When running on JDK 27 or later, Java applications automatically negotiate ML-KEM PQC key exchange out-of-the-box—without requiring Conscrypt or JNI native dependencies.
- No code or configuration changes are required in Google Cloud Java client libraries when running on JDK 27+.
