# Dependency BOM for Google Cloud Bigtable Client

This module contains a BOM that lists all of Cloud Bigtable's dependency versions. Please note that
this BOM is complementary to google-cloud-bigtable-bom. This BOM only contains transitive dependencies,
while google-cloud-bigtable-bom contains versions for direct google-cloud-bigtable artifacts.

This BOM is primarily intended to be used by java-bigtable-hbase to keep the dependencies in sync.

Example usage:

[//]: # ({x-version-update-start:google-cloud-bigtable:released})
```xml
<dependencyManagement>
  <dependencies>
    <!-- Lock google-cloud-bigtable direct dependency versions -->
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-bigtable-bom</artifactId>
      <version>1.8.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
    <!-- Lock google-cloud-bigtable transitive dependency versions -->
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-bigtable-deps-bom</artifactId>
      <version>1.8.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <!-- Declare dependency on google-cloud-client, combined with the above this will
    ensure a consistent set of dependencies --> 
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigtable</artifactId>
  </dependency>
</dependencies>

```
[//]: # ({x-version-update-end})
