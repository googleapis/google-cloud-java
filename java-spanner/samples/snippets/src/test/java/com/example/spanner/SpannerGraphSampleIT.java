/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@code SpannerGraphSample} */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SpannerGraphSampleIT extends SampleTestBaseV2 {

  private static final int DBID_LENGTH = 20;
  // The instance needs to exist for tests to pass.
  private static final String instanceId = System.getProperty("spanner.test.instance.mr");
  private static final String baseDbId = System.getProperty("spanner.sample.database");
  static Spanner spanner;
  static DatabaseAdminClient databaseAdminClient;

  private String runSample(String command, String databaseId) throws Exception {
    System.out.println("Running " + command + " on " + instanceId + ":" + databaseId);
    PrintStream stdOut = System.out;
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
    SpannerGraphSample.main(new String[] {command, instanceId, databaseId});
    System.setOut(stdOut);
    return bout.toString();
  }

  @Test
  public void testSample() throws Exception {
    String databaseId = idGenerator.generateDatabaseId();
    assertThat(instanceId).isNotNull();
    assertThat(databaseId).isNotNull();

    System.out.println("Create database with property graph ...");
    String out = runSample("createdatabase", databaseId);

    DatabaseId dbId = DatabaseId.of(projectId, instanceId, databaseId);
    assertThat(out).contains("Created database");
    assertThat(out).contains(dbId.getName());

    System.out.println("Insert some data ...");
    out = runSample("insert", databaseId);

    System.out.println("Insert more data using DML ...");
    out = runSample("insertusingdml", databaseId);
    assertThat(out).contains("2 record(s) inserted into Account.");
    assertThat(out).contains("2 record(s) inserted into AccountTransferAccount.");

    System.out.println("Update some data using DML ...");
    out = runSample("updateusingdml", databaseId);
    assertThat(out).contains("1 Account record(s) updated.");
    assertThat(out).contains("1 AccountTransferAccount record(s) updated.");

    System.out.println("Update some data using a graph query in DML ...");
    out = runSample("updateusinggraphqueryindml", databaseId);
    assertThat(out).contains("2 Account record(s) updated.");

    System.out.println("Query the property graph ...");
    out = runSample("query", databaseId);
    assertThat(out).contains("Dana Alex 500.0");
    assertThat(out).contains("Lee Dana 300.0");
    assertThat(out).contains("Alex Lee 300.0");
    assertThat(out).contains("Alex Lee 100.0");
    assertThat(out).contains("Dana Lee 200.0");

    System.out.println("Query the property graph with a parameter ...");
    out = runSample("querywithparameter", databaseId);
    assertThat(out).contains("Dana Alex 500.0");

    System.out.println("Delete some data using DML ...");
    out = runSample("deleteusingdml", databaseId);
    assertThat(out).contains("1 Account record(s) deleted.");

    System.out.println("Delete the remaining data in the database ...");
    out = runSample("delete", databaseId);
    assertThat(out).contains("Records deleted.");

    System.out.println("Query the property graph ...");
    out = runSample("query", databaseId);
    assertThat(out).doesNotContain("Dana");
    assertThat(out).doesNotContain("Alex");
    assertThat(out).doesNotContain("Lee");
  }
}
