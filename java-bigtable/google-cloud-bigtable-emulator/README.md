# Google Cloud Java Emulator for Bigtable

A Java wrapper for the [Cloud Bigtable][cloud-bigtable] emulator. This
wrapper bundles the native Bigtable emulator and exposes a simple Java
interface to ease writing tests. Please note that this wrapper is under
heavy development and APIs may change in the future.

## Quickstart

If you are using Maven, add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-bom</artifactId>
      <!-- Replace with the latest version -->
      <version>0.116.0-alpha</version>
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
