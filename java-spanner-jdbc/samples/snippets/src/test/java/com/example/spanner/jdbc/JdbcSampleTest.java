/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner.jdbc;

import static com.example.spanner.jdbc.JdbcSample.addColumn;
import static com.example.spanner.jdbc.JdbcSample.addColumnPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.arrayOfStructAsQueryParameter;
import static com.example.spanner.jdbc.JdbcSample.createConnection;
import static com.example.spanner.jdbc.JdbcSample.createConnectionWithEmulator;
import static com.example.spanner.jdbc.JdbcSample.createDatabase;
import static com.example.spanner.jdbc.JdbcSample.createPostgreSQLDatabase;
import static com.example.spanner.jdbc.JdbcSample.dataBoost;
import static com.example.spanner.jdbc.JdbcSample.dataBoostPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.ddlBatch;
import static com.example.spanner.jdbc.JdbcSample.ddlBatchPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.partitionedDml;
import static com.example.spanner.jdbc.JdbcSample.partitionedDmlPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.protoColumns;
import static com.example.spanner.jdbc.JdbcSample.queryData;
import static com.example.spanner.jdbc.JdbcSample.queryDataPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.queryDataWithNewColumn;
import static com.example.spanner.jdbc.JdbcSample.queryDataWithNewColumnPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.queryWithParameter;
import static com.example.spanner.jdbc.JdbcSample.queryWithParameterPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.readOnlyTransaction;
import static com.example.spanner.jdbc.JdbcSample.readOnlyTransactionPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.tags;
import static com.example.spanner.jdbc.JdbcSample.tagsPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.updateDataWithMutations;
import static com.example.spanner.jdbc.JdbcSample.updateDataWithMutationsPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.writeDataWithDml;
import static com.example.spanner.jdbc.JdbcSample.writeDataWithDmlBatch;
import static com.example.spanner.jdbc.JdbcSample.writeDataWithDmlBatchPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.writeDataWithDmlPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.writeDataWithMutations;
import static com.example.spanner.jdbc.JdbcSample.writeDataWithMutationsPostgreSQL;
import static com.example.spanner.jdbc.JdbcSample.writeWithTransactionUsingDml;
import static com.example.spanner.jdbc.JdbcSample.writeWithTransactionUsingDmlPostgreSQL;
import static org.junit.Assert.assertEquals;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminSettings;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient;
import com.google.cloud.spanner.admin.instance.v1.InstanceAdminSettings;
import com.google.cloud.spanner.connection.SpannerPool;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstanceName;
import com.google.spanner.admin.instance.v1.ProjectName;
import com.google.spanner.v1.DatabaseName;
import io.grpc.ManagedChannelBuilder;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Properties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

@RunWith(JUnit4.class)
public class JdbcSampleTest {
  private static final String PROJECT_ID = "emulator-project";
  private static final String INSTANCE_ID = "test-instance";
  private static final String DATABASE_ID = "test-database";
  private static final String PG_DATABASE_ID = "pg-test-database";

  private static final ProjectName PROJECT_NAME = ProjectName.of(PROJECT_ID);

  private static final InstanceName INSTANCE_NAME = InstanceName.of(PROJECT_ID, INSTANCE_ID);

  private static GenericContainer<?> emulator;

  private static Properties properties;

  @BeforeClass
  public static void setup() throws Exception {
    emulator =
        new GenericContainer<>(
                DockerImageName.parse("gcr.io/cloud-spanner-emulator/emulator:latest"))
            .withExposedPorts(9010)
            .waitingFor(Wait.forListeningPort());
    emulator.start();
    try (InstanceAdminClient client =
        InstanceAdminClient.create(
            InstanceAdminSettings.newBuilder()
                .setTransportChannelProvider(
                    InstantiatingGrpcChannelProvider.newBuilder()
                        .setEndpoint(emulator.getHost() + ":" + emulator.getMappedPort(9010))
                        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                        .build())
                .setCredentialsProvider(NoCredentialsProvider.create())
                .build())) {
      InstanceConfig config =
          client.listInstanceConfigs(PROJECT_NAME).iterateAll().iterator().next();
      client
          .createInstanceAsync(
              PROJECT_NAME,
              INSTANCE_ID,
              Instance.newBuilder()
                  .setConfig(config.getName())
                  .setDisplayName("Test Instance")
                  .setNodeCount(1)
                  .build())
          .get();
    }
    // Create properties for the JDBC driver to connect to the emulator.
    properties = new Properties();
    properties.put("autoConfigEmulator", "true");
    properties.put("lenient", "true");
    properties.put("endpoint", emulator.getHost() + ":" + emulator.getMappedPort(9010));
  }

  @AfterClass
  public static void cleanup() {
    SpannerPool.closeSpannerPool();
    emulator.stop();
  }

  DatabaseAdminClient createDatabaseAdminClient() throws Exception {
    return DatabaseAdminClient.create(
        DatabaseAdminSettings.newBuilder()
            .setTransportChannelProvider(
                InstantiatingGrpcChannelProvider.newBuilder()
                    .setEndpoint(emulator.getHost() + ":" + emulator.getMappedPort(9010))
                    .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build());
  }

  @Test
  public void testGoogleSQLSamples() throws Exception {
    String result;
    try (DatabaseAdminClient client = createDatabaseAdminClient()) {
      result = runSample(() -> createDatabase(client, INSTANCE_NAME, DATABASE_ID, properties));
    }
    assertEquals(
        "Created database [" + DatabaseName.of(PROJECT_ID, INSTANCE_ID, DATABASE_ID) + "]\n",
        result);

    result = runSample(() -> createConnection(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Hello World!\n", result);

    result = runSample(() -> createConnectionWithEmulator(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Hello World!\n", result);

    result = runSample(() -> writeDataWithDml(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("4 records inserted.\n", result);

    result =
        runSample(() -> writeDataWithDmlBatch(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("3 records inserted.\n", result);

    result =
        runSample(() -> writeDataWithMutations(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Inserted 10 rows.\n", result);

    result = runSample(() -> queryData(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals(
        "1 2 Go, Go, Go\n"
            + "2 2 Forever Hold Your Peace\n"
            + "1 1 Total Junk\n"
            + "2 1 Green\n"
            + "2 3 Terrified\n",
        result);

    result = runSample(() -> queryWithParameter(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("12 Melissa Garcia\n", result);

    result = runSample(() -> addColumn(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Added MarketingBudget column\n", result);

    result = runSample(() -> ddlBatch(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Added Venues and Concerts tables\n", result);

    result =
        runSample(() -> updateDataWithMutations(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Updated albums\n", result);

    result =
        runSample(() -> queryDataWithNewColumn(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals(
        "1 2 null\n" + "2 2 500000\n" + "1 1 100000\n" + "2 1 null\n" + "2 3 null\n", result);

    result =
        runSample(
            () -> writeWithTransactionUsingDml(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Transferred marketing budget from Album 2 to Album 1\n", result);

    result =
        runSample(
            () -> tags(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Reduced marketing budget\n", result);

    result = runSample(() -> readOnlyTransaction(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals(
        "1 1 Total Junk\n"
            + "1 2 Go, Go, Go\n"
            + "2 1 Green\n"
            + "2 2 Forever Hold Your Peace\n"
            + "2 3 Terrified\n"
            + "2 2 Forever Hold Your Peace\n"
            + "1 2 Go, Go, Go\n"
            + "2 1 Green\n"
            + "2 3 Terrified\n"
            + "1 1 Total Junk\n",
        result);

    result = runSample(() -> dataBoost(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals(
        "2 Catalina Smith\n"
            + "4 Lea Martin\n"
            + "12 Melissa Garcia\n"
            + "14 Jacqueline Long\n"
            + "16 Sarah Wilson\n"
            + "18 Maya Patel\n"
            + "1 Marc Richards\n"
            + "3 Alice Trentor\n"
            + "5 David Lomond\n"
            + "13 Russel Morales\n"
            + "15 Dylan Shaw\n"
            + "17 Ethan Miller\n",
        result);

    result = runSample(() -> partitionedDml(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Updated at least 3 albums\n", result);

    result = runSample(
        () -> arrayOfStructAsQueryParameter(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("value1;1;\nvalue2;2;\n", result);

    result = runSample(
        () -> protoColumns(PROJECT_ID, INSTANCE_ID, DATABASE_ID, properties));
    assertEquals("Inserted 2 singers\n"
        + "2:\n"
        + "singer_id: 2\n"
        + "birth_date: \"2001-12-03\"\n"
        + "nationality: \"FO\"\n"
        + "genre: POP\n"
        + "\n"
        + "POP\n"
        + "1:\n"
        + "singer_id: 1\n"
        + "birth_date: \"1998-07-04\"\n"
        + "nationality: \"ES\"\n"
        + "genre: ROCK\n"
        + "\n"
        + "ROCK\n", result);
  }

  @Test
  public void testPostgreSQLSamples() throws Exception {
    String result;
    try (DatabaseAdminClient client = createDatabaseAdminClient()) {
      result =
          runSample(
              () -> createPostgreSQLDatabase(client, INSTANCE_NAME, PG_DATABASE_ID, properties));
    }
    assertEquals(
        "Created database [" + DatabaseName.of(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID) + "]\n",
        result);

    result = runSample(() -> createConnection(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Hello World!\n", result);

    result = runSample(() -> createConnectionWithEmulator(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Hello World!\n", result);

    result =
        runSample(
            () -> writeDataWithDmlPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("4 records inserted.\n", result);

    result =
        runSample(
            () ->
                writeDataWithDmlBatchPostgreSQL(
                    PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("3 records inserted.\n", result);

    result =
        runSample(
            () ->
                writeDataWithMutationsPostgreSQL(
                    PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Inserted 10 rows.\n", result);

    result =
        runSample(() -> queryDataPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals(
        "1 2 Go, Go, Go\n"
            + "2 2 Forever Hold Your Peace\n"
            + "1 1 Total Junk\n"
            + "2 1 Green\n"
            + "2 3 Terrified\n",
        result);

    result =
        runSample(
            () ->
                queryWithParameterPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("12 Melissa Garcia\n", result);

    result =
        runSample(() -> addColumnPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Added marketing_budget column\n", result);

    result =
        runSample(() -> ddlBatchPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Added venues and concerts tables\n", result);

    result =
        runSample(
            () ->
                updateDataWithMutationsPostgreSQL(
                    PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Updated albums\n", result);

    result =
        runSample(
            () ->
                queryDataWithNewColumnPostgreSQL(
                    PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals(
        "1 2 null\n" + "2 2 500000\n" + "1 1 100000\n" + "2 1 null\n" + "2 3 null\n", result);

    result =
        runSample(
            () ->
                writeWithTransactionUsingDmlPostgreSQL(
                    PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Transferred marketing budget from Album 2 to Album 1\n", result);

    result =
        runSample(
            () ->
                tagsPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Reduced marketing budget\n", result);

    result =
        runSample(
            () ->
                readOnlyTransactionPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals(
        "1 1 Total Junk\n"
            + "1 2 Go, Go, Go\n"
            + "2 1 Green\n"
            + "2 2 Forever Hold Your Peace\n"
            + "2 3 Terrified\n"
            + "2 2 Forever Hold Your Peace\n"
            + "1 2 Go, Go, Go\n"
            + "2 1 Green\n"
            + "2 3 Terrified\n"
            + "1 1 Total Junk\n",
        result);

    result =
        runSample(() -> dataBoostPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals(
        "2 Catalina Smith\n"
            + "4 Lea Martin\n"
            + "12 Melissa Garcia\n"
            + "14 Jacqueline Long\n"
            + "16 Sarah Wilson\n"
            + "18 Maya Patel\n"
            + "1 Marc Richards\n"
            + "3 Alice Trentor\n"
            + "5 David Lomond\n"
            + "13 Russel Morales\n"
            + "15 Dylan Shaw\n"
            + "17 Ethan Miller\n",
        result);

    result =
        runSample(
            () -> partitionedDmlPostgreSQL(PROJECT_ID, INSTANCE_ID, PG_DATABASE_ID, properties));
    assertEquals("Updated at least 3 albums\n", result);
  }

  interface Sample {
    void run() throws Exception;
  }

  String runSample(Sample sample) throws Exception {
    PrintStream stdOut = System.out;
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
    try {
      sample.run();
    } finally {
      System.setOut(stdOut);
    }
    return bout.toString();
  }
}
