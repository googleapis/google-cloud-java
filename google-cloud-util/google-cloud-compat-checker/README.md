Google Cloud Java Compatibility Checker
==========================

Usage:

```
git clone https://github.com/GoogleCloudPlatform/google-cloud-java.git
cd google-cloud-java/google-cloud-util/google-cloud-compat-checker
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
Checking compatibility...
  This OS + architecture is supported by Forked Tomcat Native.
Result: UNKNOWN (checker implementation not complete)
```
