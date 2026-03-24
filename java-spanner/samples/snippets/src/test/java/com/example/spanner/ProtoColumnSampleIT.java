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

package com.example.spanner;

import static com.example.spanner.SampleRunner.runSample;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.collect.ImmutableList;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for Proto Column type */
@RunWith(JUnit4.class)
public class ProtoColumnSampleIT extends SampleTestBase {

  private static DatabaseId databaseId;
  private static Spanner spanner;

  @BeforeClass
  public static void createTestDatabase() throws Exception {
    spanner = SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
    DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();
    final String database = idGenerator.generateDatabaseId();
    databaseAdminClient
        .createDatabase(
            instanceId,
            database,
            ImmutableList.of(
                "CREATE TABLE Singers (\n"
                    + "    SingerId         INT64 NOT NULL,\n"
                    + "    FirstName        STRING(1024),\n"
                    + "    LastName         STRING(1024),\n"
                    + "    ) PRIMARY KEY (SingerId)"))
        .get(10, TimeUnit.MINUTES);
    databaseId = DatabaseId.of(projectId, instanceId, database);

    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    client.write(
        Arrays.asList(
            Mutation.newInsertOrUpdateBuilder("Singers")
                .set("SingerId")
                .to(1L)
                .set("FirstName")
                .to("Marc")
                .set("LastName")
                .to("Richards")
                .build(),
            Mutation.newInsertOrUpdateBuilder("Singers")
                .set("SingerId")
                .to(2L)
                .set("FirstName")
                .to("Catalina")
                .set("LastName")
                .to("Smith")
                .build(),
            Mutation.newInsertOrUpdateBuilder("Singers")
                .set("SingerId")
                .to(3L)
                .set("FirstName")
                .to("Alice")
                .set("LastName")
                .to("Trentor")
                .build()));
  }

  @After
  public void removeTestData() {
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    client.write(Collections.singletonList(Mutation.delete("Singers", KeySet.all())));
  }

  @Test
  public void testProtoColumns() throws Exception {
    InputStream in =
        ProtoColumnSampleIT.class
            .getClassLoader()
            .getResourceAsStream("com/example/spanner/descriptors.pb");
    System.out.println(in);
    final DatabaseClient client = spanner.getDatabaseClient(databaseId);
    System.out.println(databaseId.toString());
    System.out.println("Adding Proto columns schema to table  ...");
    String out =
        runSample(
            () ->
                AddProtoColumnSample.addProtoColumn(
                    projectId, instanceId, databaseId.getDatabase()));
    assertTrue(out.contains("Added Proto columns"));

    System.out.println("Update data with Proto Columns ...");
    out = runSample(() -> UpdateProtoDataSample.updateProtoData(client));
    assertTrue(out.contains("Data updated"));

    System.out.println("Update data with Proto Columns using DML ...");
    out = runSample(() -> UpdateProtoDataSampleUsingDml.updateProtoDataUsingDml(client));
    assertTrue(out.contains("record(s) updated"));

    System.out.println("Query data with Proto Columns ...");
    out = runSample(() -> QueryWithProtoParameterSample.queryWithProtoParameter(client));
    assertTrue(out.contains("2 singer_id: 2"));
  }
}
