# Google Cloud Java Emulator for Bigtable

A Java wrapper for the [Cloud Bigtable][cloud-bigtable] emulator. This
wrapper bundles the native Bigtable emulator and exposes a simple Java
interface to ease writing tests. Please note that this wrapper is under
heavy development and APIs may change in the future.

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable-emulator.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-bigtable-emulator.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

## Quickstart

[//]: # ({x-version-update-start:google-cloud-bom:released})
If you are using Maven, add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-bom</artifactId>
      <version>0.114.0-alpha</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigtable</artifactId>
  </dependency>

  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-bigtable-emulator</artifactId>
    <scope>test</scope>
  </dependency>

  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-bigtable:0.114.0-alpha'
testCompile 'com.google.cloud:google-cloud-bigtable-emulator:0.114.0-alpha'
testCompile 'junit:junit:4.12'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-bigtable" % "0.114.0-alpha"
libraryDependencies += "com.google.cloud" % "google-cloud-bigtable-emulator" % "0.114.0-alpha" % Test
libraryDependencies += "junit" % "junit" % "4.12" % Test
```
[//]: # ({x-version-update-end})

## Getting Started

Here is a code snippet showing a simple JUnit test. Add the following imports
at the top of your file:

```java
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.emulator.v2.BigtableEmulatorRule;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
```

Then, to make a query to Bigtable, use the following code:
```java
@RunWith(JUnit4.class)
public class ExampleTest {
  // Initialize the emulator Rule
  @Rule
  public final BigtableEmulatorRule bigtableEmulator = BigtableEmulatorRule.create();

  // Clients that will be connected to the emulator
  private BigtableTableAdminClient tableAdminClient;
  private BigtableDataClient dataClient;

  @Before
  public void setUp() throws IOException {
    // Initialize the clients to connect to the emulator
    BigtableTableAdminSettings.Builder tableAdminSettings = BigtableTableAdminSettings.newBuilderForEmulator(bigtableEmulator.getPort());
    tableAdminClient = BigtableTableAdminClient.create(tableAdminSettings.build());

    BigtableDataSettings.Builder dataSettings = BigtableDataSettings.newBuilderForEmulator(bigtableEmulator.getPort());
    dataClient = BigtableDataClient.create(dataSettings.build());

    // Create a test table that can be used in tests
    tableAdminClient.createTable(
        CreateTableRequest.of("fake-table")
          .addFamily("cf")
    );
  }

  @Test
  public void testWriteRead() throws ExecutionException, InterruptedException {
    ApiFuture<Void> mutateFuture = dataClient.mutateRowAsync(
        RowMutation.create("fake-table", "fake-key")
            .setCell("cf", "col", "value")
    );

    mutateFuture.get();

    ApiFuture<Row> rowFuture = dataClient.readRowAsync("fake-table", "fake-key");

    Assert.assertEquals("value", rowFuture.get().getCells().get(0).getValue().toStringUtf8());
  }
}
```

## Java Versions

Java 7 or above is required for using this emulator.

## Versioning

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (`0.y.z`), which means that anything may
change at any time and the public API should not be considered stable.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING] for more information on how to get started and [DEVELOPING] for a layout of the
codebase.

## License

Apache 2.0 - See [LICENSE] for more information.

[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[cloud-bigtable]: https://cloud.google.com/bigtable/

