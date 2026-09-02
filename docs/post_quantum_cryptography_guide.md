# Post-Quantum Cryptography (PQC) User Guide for HTTP/JSON (REST) Java Client Libraries

## 1. Executive Summary & Core Concepts

### 1.1 What is Post-Quantum Cryptography (PQC)?
Traditional Transport Layer Security (TLS) public-key cryptography—such as RSA and Elliptic Curve Diffie-Hellman (ECDH)—relies on mathematical problems (integer factorization and discrete logarithms) that are practically impossible for classical computers to solve in a reasonable timeframe. 

However, sufficiently large, cryptographically relevant quantum computers (CRQCs) will be capable of breaking these mathematical foundations using Shor's algorithm. **Post-Quantum Cryptography (PQC)** refers to a new class of cryptographic algorithms designed to run on classical hardware while remaining mathematically secure against attacks from both classical and quantum computers.

### 1.2 The Threat: "Store-Now, Decrypt-Later" (SNDL)
You might wonder why post-quantum security matters today if large-scale quantum computers do not yet exist. The primary threat is **Store-Now, Decrypt-Later (SNDL)**:
- **The Attack**: Adversaries can intercept and archive encrypted network communications traversing the public internet today.
- **The Consequence**: Even if attackers cannot read your ciphertext now, they can store the encrypted traffic indefinitely and decrypt it in the future once quantum computers become available.
- **The Impact**: Any data with a long secrecy lifecycle—such as customer records, credentials, intellectual property, health information, and financial transactions—is vulnerable to retroactive exposure unless protected before transmission.

### 1.3 The Solution: Hybrid Key Exchange
Rather than completely replacing proven classical algorithms with brand-new post-quantum mechanisms, Google Cloud and standards bodies (NIST) utilize **Hybrid Key Exchange** (specifically `X25519MLKEM768`):

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
For software engineers and application developers, adopting PQC in Google Cloud Java client libraries requires no changes to business logic:
- **What stays exactly the same**:
  - Your application source code and business logic.
  - How you construct and call API clients (e.g., `SecretManagerServiceClient`, `StorageClient`).
  - Authentication tokens, Service Account keys, and OAuth2 credentials.
  - Request and response JSON payloads.
- **What changes**:
  - Only the initial **TLS 1.3 cryptographic handshake** (Layer 4/6) performed when the client opens an HTTPS connection to Google Cloud endpoints (`*.googleapis.com`).

---

## 2. Transport Scope: HTTP/JSON (REST) vs. gRPC

Google Cloud Java client libraries support two underlying transport mechanisms: **gRPC** (HTTP/2 with Protobuf) and **HTTP/JSON** (REST with JSON):
- Most Google Cloud Java clients use **gRPC by default** (e.g., Cloud Bigtable, Cloud Spanner, Cloud Pub/Sub).
- Clients use **HTTP/JSON** when explicitly configured (e.g., via `ClientSettings.newHttpJsonBuilder()`), when interacting with HTTP-only services (e.g., Google Cloud Compute Engine, Cloud Storage JSON API), or in corporate networks where firewalls restrict non-standard HTTP/2 gRPC traffic.

> [!NOTE]
> **Scope of This Guide**:
> This guide focuses exclusively on **HTTP/JSON (REST)** transport (`gax-httpjson` and `google-http-client`). gRPC transport manages its TLS lifecycle independently via `grpc-netty-shaded` and will be covered in a subsequent guide.

---

## 3. HTTP/JSON Transport Architecture & Defaults

### 3.1 Minimum Required Versions
PQC enablement for HTTP/JSON transport requires compatible versions of `conscrypt-openjdk-uber`, `gax-httpjson`, and `google-http-client`:

| Library | Minimum Version | Role |
| :--- | :--- | :--- |
| **`libraries-bom`** | `26.86.0+` | **Recommended**. Central BOM managing compatible versions across all Google Cloud client libraries. |
| **`gax-httpjson`** | `2.83.0+` | Automatically configures Conscrypt as the TLS security provider and sets PQC named groups. |
| **`google-http-client`** | `2.2.0+` | Provides transport-level security provider registration on `NetHttpTransport.Builder`. |
| **`conscrypt-openjdk-uber`** | `2.6.0+` *(2.6.2+ recommended)* | Provides Google's BoringSSL native C engine and TLS 1.3 PQC hybrid named groups. |

### 3.2 Why Conscrypt?
Built-in Java Development Kits (Java 8 through Java 20) do not support Post-Quantum Cryptography in their default Java Secure Socket Extension provider (`SunJSSE`). While native ML-KEM support is in development for future Java releases (**JDK 27+** via JEP 496), requiring all production enterprise workloads to immediately upgrade to bleeding-edge JDK versions is impractical.

To bridge this gap, Google Cloud Java client libraries use **Conscrypt** (`conscrypt-openjdk-uber`) as the default security provider for HTTP/JSON transport:
1. **Immediate PQC Availability Across Java 8+**: Conscrypt embeds Google's open-source BoringSSL cryptographic engine via Java Native Interface (JNI). This enables quantum-resistant TLS 1.3 handshakes on existing production runtimes (Java 8, 11, 17, and 21).
2. **Zero Code Changes**: When `gax-httpjson` detects compatible Conscrypt libraries on the classpath, it automatically configures the HTTPS transport without requiring manual SSLContext setup.
3. **High Performance**: BoringSSL contains hardware-accelerated assembly optimizations for modern CPU architectures (x86_64 and ARM64).

### 3.3 How Client and Google Cloud Endpoints Negotiate PQC
When a Google Cloud HTTP/JSON client initiates a connection, it advertises supported key exchange groups to the server in strict preference order:

1. `X25519MLKEM768` *(#1 Preference: Hybrid Post-Quantum Key Exchange)*
2. `SecP256r1MLKEM768` *(Hybrid Post-Quantum Key Exchange with NIST P-256)*
3. `MLKEM1024` *(Pure Post-Quantum Key Exchange)*
4. `MLKEM768` *(Pure Post-Quantum Key Exchange)*
5. `X25519Kyber768Draft00` *(Deprecated draft group retained for backward compatibility)*
6. `X25519` *(Classical ECDH)*
7. `secp256r1` *(Classical ECDH)*
8. `secp384r1` *(Classical ECDH)*

#### Handshake Negotiation Flow:
- **PQC-Enabled Google Cloud Endpoints**: Google Cloud frontends recognize `X25519MLKEM768` as their preferred group. The client and server agree on this hybrid algorithm, establishing a quantum-resistant TLS 1.3 session.
- **Non-PQC Endpoints / Middleboxes**: If a server or intermediate network proxy does not yet support post-quantum cryptography, it ignores the unrecognized post-quantum identifiers and selects the first mutually supported classical group (e.g., `X25519`).
- **Graceful Client Fallback**: If Conscrypt native libraries cannot load on the client host, the client seamlessly falls back to standard JDK JSSE (`SunJSSE`), negotiating classical TLS 1.3.

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
     google-http-client uses Conscrypt             Falls back to JDK JSSE
     Offers Hybrid PQC + Classical Groups          Offers Standard JDK Classical Groups
     - Google Cloud negotiates X25519MLKEM768      - Negotiates classical X25519
     - Non-PQC endpoints fall back to X25519         via standard JDK SunJSSE
```

### 3.4 Performance, Network, & Handshake Characteristics
Understanding the real-world performance implications helps teams make informed deployment decisions:
- **TLS Handshake Size Overhead**:
  - Classical `X25519` public keys are very compact: **32 bytes**.
  - `ML-KEM-768` public keys are **1,184 bytes**, and ciphertexts are **1,088 bytes**.
  - Consequently, the TLS `ClientHello` and `ServerHello` messages increase by approximately **1 to 2 kilobytes**.
- **Connection Pooling & API Latency**:
  - Google Cloud Java client libraries maintain persistent HTTP connection pools (`Keep-Alive`).
  - The TLS handshake occurs **only once** when a pooled connection is established.
  - Subsequent API requests reuse existing open connections without repeating the TLS handshake. Therefore, the runtime latency impact on everyday API requests is **negligible**.
- **CPU Computation**:
  - Modern CPUs execute ML-KEM key generation and encapsulation in under 50 microseconds. In benchmark testing, CPU utilization differences between classical and hybrid handshakes are within normal margin of error.

---

## 4. Deployment Environments & Platform Compatibility

Because Conscrypt relies on C native shared libraries (`.so`, `.dylib`, or `.dll`) loaded via JNI, platform compatibility depends on the host operating system and container environment.

### 4.1 Compatibility Matrix

| Environment / OS | Status | Notes |
| :--- | :--- | :--- |
| **Standard Linux (Ubuntu, Debian, RHEL, CentOS)** | **Fully Supported** | Requires `glibc` 2.17+ (Conscrypt 2.6.2+) or `glibc` 2.35+ (Conscrypt 2.6.0). |
| **Google Cloud Managed (Cloud Run, GKE, App Engine)** | **Fully Supported** | Default base container environments use compatible `glibc` runtimes. |
| **macOS (Apple Silicon M-series & Intel)** | **Fully Supported** | Native `osx-aarch_64` and `osx-x86_64` binaries bundled in `conscrypt-openjdk-uber`. |
| **Windows (x86_64)** | **Fully Supported** | Native `windows-x86_64` binary bundled in `conscrypt-openjdk-uber`. |
| **Alpine Linux / Musl libc Containers** | **Fallback to Classical** | Conscrypt native binaries are compiled for `glibc`. On Alpine (`musl`), native loading fails with `UnsatisfiedLinkError` and gracefully falls back to JDK TLS. |
| **Containers with `noexec /tmp`** | **Requires Configuration** | By default, JNI extracts libraries to `/tmp`. If `/tmp` is mounted `noexec`, specify `-Dorg.conscrypt.native.workdir`. |

### 4.2 Handling Alpine Linux (`musl` libc)
If your container images are based on Alpine Linux (e.g., `eclipse-temurin:17-alpine` or `openjdk:11-alpine`), Conscrypt cannot load its native C library because Alpine uses `musl` libc instead of `glibc`.

**Your Options on Alpine**:
1. **Accept Classical TLS Fallback (No Action)**: The client library will safely fall back to standard JDK JSSE and negotiate classical TLS 1.3 (`X25519`). Your application will function normally without errors.
2. **Switch to a Glibc-Based Base Image (Recommended for PQC)**: If quantum resistance is required in containerized environments, switch to a minimal `glibc`-based base image such as:
   - Debian Slim (e.g., `eclipse-temurin:17-jre-jammy` or `eclipse-temurin:21-jre-noble`)
   - Distroless Java (e.g., `gcr.io/distroless/java17-debian12`)
   - Chainguard JRE with glibc

### 4.3 Handling Hardened Filesystems & `noexec /tmp`
In hardened Kubernetes pods or security-conscious Docker containers, `/tmp` may be mounted with the `noexec` flag or the entire root filesystem may be marked read-only.

When Conscrypt starts, the JVM extracts its bundled native `.so` file to a temporary directory. If that directory does not allow execution:
```text
java.lang.UnsatisfiedLinkError: /tmp/libconscrypt_openjdk_jni...: failed to map segment from shared object: Operation not permitted
```
**Solution**: Provide an alternative directory that has write and execute permissions using the JVM system property:
```bash
java -Dorg.conscrypt.native.workdir=/var/run/app/tmp -jar my-application.jar
```

### 4.4 Classpath Isolation & Version Skew Warning
If your project uses multiple dependencies that transitively pull in different versions of Conscrypt (e.g., older versions like `2.5.2` alongside `2.6.2`), a JNI ABI mismatch can occur during JVM classloading. Always ensure your build tool (Maven/Gradle) resolves `conscrypt-openjdk-uber` to version `2.6.0+` (or `2.6.2+`) consistently.

---

## 5. Important Warning: Availability vs. Strict Compliance

Google Cloud Java client libraries follow a deliberate architectural principle: **prefer service availability over hard failures**.

### 5.1 The Silent Fallback Behavior
If Conscrypt native libraries fail to initialize—due to an unsupported operating system, missing `glibc`, permission issues, or file extraction limits—`gax-httpjson` catches the exception and logs a message at **`Level.FINE` (debug level)**:
```text
FINE: Conscrypt native libraries not available. Falling back to JDK TLS.
```
The client then proceeds to establish standard classical TLS using the host JVM's built-in `SunJSSE` provider. 

**Why does it behave this way?**
To protect production workloads. A customer updating dependencies or migrating container images should not experience broken API calls or catastrophic application outages simply because a native optimization library could not load on their environment.

### 5.2 The Compliance Warning
> [!WARNING]
> **Active Verification is Required for Regulatory Mandates**:
> If your organization operates under strict compliance, governmental, or corporate security mandates requiring Post-Quantum Cryptography today, **you cannot rely solely on the default configuration without verification**.
>
> Because fallback to classical TLS is silent and non-breaking by design, an unexpected environment change (such as switching to an Alpine-based Docker container or changing filesystem mount permissions) could downgrade your connections from hybrid PQC to classical TLS **without throwing exceptions or failing requests**.
>
> If PQC is a mandatory requirement for your workload, you must implement automated verification in your CI/CD pipelines or startup health checks (see **Section 6**).

---

## 6. How to Verify PQC Negotiation

To confirm whether your application is actively negotiating post-quantum hybrid key exchange, use one or more of the following verification methods.

### Method 1: GAX Internal Initialization Logging
Inspect whether `gax-httpjson` successfully loaded Conscrypt or fell back to JDK TLS by enabling debug logging on `HttpJsonConscryptUtils`.

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

### Method 2: JVM TLS Handshake Tracing (`-Djavax.net.debug`)
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
     NamedGroup: SecP256r1MLKEM768 (0x11ed),
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

## 7. Alternative Configurations & Custom Providers

Google Cloud client libraries are designed to be flexible. You are not locked into Conscrypt; you can configure classical-only key exchange, standard JDK TLS, or custom security providers.

### Option A: Default Out-of-the-Box (Conscrypt Automatic PQC)
No code required. If you import `libraries-bom:26.86.0+` on a compatible platform, PQC is enabled automatically:
```java
// Standard client construction automatically leverages Conscrypt PQC
try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
  // Transport negotiates X25519MLKEM768
}
```

---

### Option B: Forcing Classical-Only Key Exchange (Disabling PQC)
If you need to use Conscrypt for high-performance TLS but want to explicitly disable post-quantum hybrid groups (for example, to isolate a network middlebox issue or benchmark legacy performance):

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

---

### Option C: Bypassing Conscrypt to Use Standard JDK JSSE
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

---

### Option D: Completely Excluding Conscrypt via Maven or Gradle
If you want to ensure that Conscrypt is never pulled onto your classpath (and never loaded by any client in your application), exclude it in your build configuration:

**Maven (`pom.xml`)**:
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-secretmanager</artifactId>
  <exclusions>
    <exclusion>
      <groupId>org.conscrypt</groupId>
      <artifactId>conscrypt-openjdk-uber</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

**Gradle (`build.gradle`)**:
```groovy
configurations.all {
  exclude group: 'org.conscrypt', module: 'conscrypt-openjdk-uber'
}
```
When Conscrypt is not present on the classpath, `gax-httpjson` detects its absence and automatically uses standard JDK JSSE.

---

### Option E: Configuring a Third-Party Security Provider (e.g., Bouncy Castle)
If your enterprise utilizes an alternative cryptographic provider (such as Bouncy Castle FIPS), configure it directly on the `NetHttpTransport.Builder`:

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

## 8. Future Outlook: Native OpenJDK PQC Support (JDK 27+)

The cryptographic landscape is continually advancing. The OpenJDK community is integrating standardized post-quantum algorithms directly into the Java platform:
- **JEP 496 (ML-KEM)**: Introduces native implementations of NIST FIPS 203 (Module-Lattice-Based Key-Encapsulation Mechanism) into OpenJDK's standard security providers (`SunJSSE` and `SunJCE`), targeted for **JDK 27+**.
- **What this means for Google Cloud Java**: Once JDK 27 becomes standard in production environments, Java applications will be capable of negotiating hybrid and pure post-quantum TLS natively without requiring JNI shared libraries or third-party dependencies like Conscrypt.
- **Future-Proofing**: As native JDK capabilities mature, Google Cloud Java client libraries will adapt to take advantage of built-in JVM providers, preserving a seamless, zero-maintenance security upgrade path for all users.
