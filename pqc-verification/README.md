# GAPIC Post-Quantum Cryptography (PQC) Support & Verification

This directory contains verification tools and samples to test, trace, and verify Post-Quantum Cryptography (PQC) support in Google Cloud Java client libraries, covering both gRPC and HttpJson (REST) transports.

---

## 1. Prerequisites & Dependencies

### Java Version Compatibility & JDK 8 Support
*   **Build Environment**: JDK 11+ is required if compiling Conscrypt from source. JDK 17+ or JDK 21+ is recommended for modern development.
*   **JDK 8 Runtime Support**: Applications running on **JDK 8** are fully supported at runtime. The `conscrypt-openjdk-uber` dependency targets Java 8 bytecode compatibility and bundles pre-compiled BoringSSL native binaries for all major OS architectures. When Conscrypt is registered as a Security Provider on Java 8, TLS 1.3 PQC handshakes (`X25519MLKEM768`, `SecP256r1MLKEM768`) execute natively at the C/C++ layer without requiring JDK JSSE upgrades.

### Core Production Dependencies
PQC support is built natively into the core transport libraries:
1.  **`google-http-java-client`** (`v2.2.0`): Provides `.setSslSocketConfigurator(...)` on `NetHttpTransport.Builder` to configure Conscrypt PQC named groups.
2.  **`gax-httpjson`** (`GAX`): Configures `NetHttpTransport.Builder` with Conscrypt security provider and `InstantiatingHttpJsonChannelProvider.DEFAULT_PQC_GROUPS` by default.
3.  **`google-cloud-core-http`**: Enables Conscrypt security provider and `DEFAULT_PQC_GROUPS` by default for handwritten client transports.

---

## 2. Running Showcase Integration Tests (Local TLS Server)

The `ITPqc` test suite runs integration tests against a local secure **GAPIC Showcase** server to verify end-to-end PQC handshake negotiation.

### Step 2.1: Build Showcase Server
Clone the showcase server and checkout the PQC TLS support branch:
```shell
git clone https://github.com/googleapis/gapic-showcase.git
cd gapic-showcase
git checkout feat-pqc-tls
go build ./cmd/gapic-showcase
```

### Step 2.2: Run the Showcase Server with Auto-TLS
Start the Showcase server in Auto-TLS mode to generate a local CA certificate:

```shell
./gapic-showcase run \
  --port 7470 \
  --tls \
  --ca-cert-output-file /tmp/showcase-ca.pem
```

### Step 2.3: Execute Integration Tests
Run the Showcase PQC integration test suite:
```shell
mvn test -pl java-showcase/gapic-showcase -Dtest=ITPqc -Dshowcase.ca.cert.path=/tmp/showcase-ca.pem
```

---

## 3. Standalone BigQuery PQC Verification Sample

The sample `BqPqcTest` runs a connection against Google Cloud BigQuery using default client settings and intercepts the TLS handshake to programmatically verify that PQC (`X25519MLKEM768`) is negotiated.

### Run the Sample
You can run the sample directly via Maven from the repository root:

```shell
# Run using exec-maven-plugin
mvn clean compile exec:java -f pqc-verification/pom.xml
```

### Expected Output
The program will automatically trace the TLS handshake and print the negotiated protocol and key exchange group:

```
[DEBUG] Java Version: 17.0.19
[DEBUG] Java Runtime: 17.0.19+10
[DEBUG] Java VM     : OpenJDK 64-Bit Server VM (17.0.19+10)
Conscrypt is functional. Configuring TLS hybrid PQC tracing...
Initializing default BigQuery client for project: your-gcp-project-id
Executing API call to trigger TLS handshake...
TLS connection established. Proceeding with verification...

==================================================
TLS Handshake Verification Results:
  Protocol      : TLSv1.3
  Cipher Suite  : TLS_AES_128_GCM_SHA256
  Negotiated KEX: X25519MLKEM768
==================================================
VERIFICATION SUCCESS: Key exchange (X25519MLKEM768) negotiated successfully!
```
