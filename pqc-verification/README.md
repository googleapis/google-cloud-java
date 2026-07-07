# GAPIC Post-Quantum Cryptography (PQC) Support & Verification

This directory contains verification tools and samples to test, trace, and verify Post-Quantum Cryptography (PQC) support in Google Cloud Java client libraries, covering both gRPC and HttpJson (REST) transports.

---

## 1. Prerequisites & Dependencies

### Java Version
*   To perform PQC handshakes, JDK 11+ is required for compiling Conscrypt. JDK 17+ or JDK 21+ is highly recommended.
*   Conscrypt acts as the security provider providing hybrid group `X25519MLKEM768`.

### Core Snapshot Artifacts
The PQC verification depends on local SNAPSHOT builds of libraries containing our PQC enhancements:
1.  **`google-http-java-client`** (`pqc-support-conscrypt` branch): Enforces and wraps standard HTTP connections to prefer Conscrypt PQC sockets.
2.  **`gRPC-Java`** (`1.83.0-SNAPSHOT`): Enables Netty 4.2 support which negotiates hybrid key exchange by default.

---

## 2. Setting Up Showcase (Local TLS Server)

The `ITPqc` test suite runs integration tests against the local secure **GAPIC Showcase** server.

### Step 2.1: Download & Build Showcase with TLS Support
Clone the showcase server and checkout the PQC TLS support branch:
```shell
git clone https://github.com/googleapis/gapic-showcase.git
cd gapic-showcase
git checkout feat-pqc-tls
go build ./cmd/gapic-showcase
```

### Step 2.2: Run the Showcase Server with Auto-TLS (Recommended)
Start the Showcase server in Auto-TLS mode. This automatically generates a CA certificate in-memory at startup and saves it to the target directory:

```shell
# Run on secure port 7470
./gapic-showcase run \
  --port 7470 \
  --tls \
  --ca-cert-output-file /tmp/showcase-ca.pem
```

*Note: The helper script `build-with-local-http-client.sh` will automatically launch and clean up this Showcase server if it finds the `gapic-showcase` repository cloned next to the `google-cloud-java` monorepo.*
If running manually, execute the tests using:
`mvn test -pl java-showcase/gapic-showcase -Dtest=ITPqc -Dshowcase.ca.cert.path=/tmp/showcase-ca.pem`

---

## 3. Running Local Verification Tests

Use the helper script `build-with-local-http-client.sh` to automatically build/install `google-http-java-client` as a local snapshot, compile the monorepo, and execute Showcase PQC integration tests:

```shell
# Set path to the google-http-java-client repository
export HTTP_CLIENT_DIR=~/IdeaProjects/google-http-java-client

# Run the verification script
./build-with-local-http-client.sh
```

If successful, you will see `BUILD SUCCESS` and both `testGrpcPqc` and `testHttpJsonPqc` passing.

---

## 4. Standalone BigQuery PQC Verification Sample

The class `BqPqcTest` runs a live connection to Google Cloud BigQuery using the default client settings. Since the PQC changes are enabled by default in the underlying HTTP client transport, this sample does not require any custom PQC configurations.

### Run the Sample
You can run the sample directly from your IDE, or via Maven. The project ID is resolved automatically via Application Default Credentials (ADC), and TLS/SSL handshake tracing is configured programmatically:

```shell
cd pqc-verification

# Run using exec-maven-plugin
mvn clean compile exec:java
```

### Expected Output
The program will automatically intercept the TLS handshake and assert on the negotiated curve. If successful, you will see a validation summary at the end of execution:

```
[DEBUG] Java Version: 17.0.19
[DEBUG] Java Runtime: 17.0.19+10
[DEBUG] Java VM     : OpenJDK 64-Bit Server VM (17.0.19+10)
Initializing default BigQuery client for project: your-gcp-project-id
Listing datasets using default BigQuery Client...
- my_dataset1
- my_dataset2
Success! BigQuery datasets retrieved successfully.

==================================================
TLS Handshake Verification Results:
  Protocol      : TLSv1.3
  Cipher Suite  : TLS_AES_128_GCM_SHA256
  Negotiated KEX: X25519MLKEM768
==================================================
VERIFICATION SUCCESS: PQC Hybrid key exchange negotiated successfully!
```
