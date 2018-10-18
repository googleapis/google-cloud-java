Google Cloud Java Compatibility Checker
==========================

The Google Cloud Java Compatibility Checker is a utility to check
compatibility of your environment with grpc-based clients in Google
Cloud Java (e.g. Pub/Sub, Vision, Speech, and others).

Usage:

```
git clone https://github.com/googleapis/google-cloud-java.git
cd google-cloud-java/google-cloud-bom
mvn install
cd ../google-cloud-util/google-cloud-compat-checker
mvn install
mvn exec:java
```

The output should look something like this:

```
OS details:
  os.detected.name: linux
  os.detected.arch: x86_64
  os.detected.classifier: linux-x86_64
  os.detected.release: ubuntu
  os.detected.release.version: 14.04
JVM details:
  Java version: 1.8.0_144-b01
  Java specification version: 1.8
  JVM bit mode: 64
OpenSSL details:
  open ssl is available: true
  ALPN is supported: true
Checking compatibility...
  [PASS] This OS + architecture is supported.
  [PASS] 64-bit JVM is supported.
  [PASS] Open SSL is available
  [PASS] Open SSL ALPN is supported
Result: UNKNOWN (checker implementation not complete)
  Based on what was checked, nothing was identified that would
  prevent you from using grpc-based APIs.
```
