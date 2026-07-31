/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.example.spanner.TagTestHelper;
import com.google.cloud.NoCredentials;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MockAutoTaggingTest extends AbstractMockServerTest {

  @Before
  public void setUpProperties() {
    System.clearProperty("spanner.disable_auto_tagging");
    System.clearProperty("spanner.enable_auto_tagging");
    SpannerOptions.useDefaultEnvironment();
  }

  @After
  public void tearDownProperties() {
    System.clearProperty("spanner.disable_auto_tagging");
    System.clearProperty("spanner.enable_auto_tagging");
    SpannerOptions.useDefaultEnvironment();
  }

  private Spanner createSpanner(boolean enableAutoTag, String targetPackage) {
    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance());
    if (enableAutoTag) {
      builder.enableAutoTagging();
    }
    if (targetPackage != null) {
      builder.setAutoTaggingPackages(targetPackage);
    }
    builder.setAutoTaggingTracerLimit(200);
    builder.setSessionPoolOption(
        SessionPoolOptions.newBuilder()
            .setWaitForMinSessionsDuration(java.time.Duration.ofSeconds(10))
            .build());
    return builder.build().getService();
  }

  @Test
  public void testReadWriteTransactionAutoTagging() {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.run(
          databaseClient,
          transaction -> {
            transaction.executeUpdate(Statement.of("UPDATE Venues SET Capacity = 100"));
            return null;
          });

      // Verify transaction tag populated on ExecuteSqlRequest
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      String transactionTag = sqlRequest.getRequestOptions().getTransactionTag();
      assertEquals("TagTestHelper.run", transactionTag);
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());

      // Verify transaction tag matches on CommitRequest
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
      assertEquals(transactionTag, commitRequest.getRequestOptions().getTransactionTag());
    }
  }

  @Test
  public void testReadWriteTransactionAutoTaggingWithExplicitTag() {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.runWithOptions(
          databaseClient,
          transaction -> {
            transaction.executeUpdate(Statement.of("UPDATE Venues SET Capacity = 100"));
            return null;
          },
          Options.tag("my-explicit-tag"));

      // Verify explicit tag is preserved and not overwritten by auto-tag
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("my-explicit-tag", sqlRequest.getRequestOptions().getTransactionTag());
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());
    }
  }

  @Test
  public void testReadWriteTransactionAutoTaggingTruncation() {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.ExtremelyLongClassNameForTestingTagTruncationSupportUnderCheckstyle.run(
          databaseClient,
          transaction -> {
            transaction.executeUpdate(Statement.of("UPDATE Venues SET Capacity = 100"));
            return null;
          });

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      String transactionTag = sqlRequest.getRequestOptions().getTransactionTag();
      assertNotNull(transactionTag);
      assertTrue(transactionTag.length() <= 50);
      assertTrue(transactionTag.endsWith("uncationSupportUnderCheckstyle.run"));
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());
    }
  }

  @Test
  public void testGlobalDisableOverride() {
    System.setProperty("spanner.disable_auto_tagging", "true");
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.run(
          databaseClient,
          transaction -> {
            transaction.executeUpdate(Statement.of("UPDATE Venues SET Capacity = 100"));
            return null;
          });

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("", sqlRequest.getRequestOptions().getTransactionTag());
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());
    }
  }

  @Test
  public void testGlobalEnableOverride() {
    System.setProperty("spanner.enable_auto_tagging", "true");
    try (Spanner spannerInstance = createSpanner(false, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.run(
          databaseClient,
          transaction -> {
            transaction.executeUpdate(Statement.of("UPDATE Venues SET Capacity = 100"));
            return null;
          });

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("TagTestHelper.run", sqlRequest.getRequestOptions().getTransactionTag());
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());
    }
  }

  @Test
  public void testReadWriteTransactionAsyncAutoTagging() throws Exception {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.runAsync(
              databaseClient,
              transaction ->
                  transaction.executeUpdateAsync(Statement.of("UPDATE Venues SET Capacity = 100")))
          .get();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      String transactionTag = sqlRequest.getRequestOptions().getTransactionTag();
      assertEquals("TagTestHelper.runAsync", transactionTag);
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());

      // Verify transaction tag matches on CommitRequest
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
      assertEquals(transactionTag, commitRequest.getRequestOptions().getTransactionTag());
    }
  }

  @Test
  public void testSingleUseQueryAutoTagging() {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      com.google.spanner.v1.ResultSet select1ResultSet =
          com.google.spanner.v1.ResultSet.newBuilder()
              .addRows(
                  com.google.protobuf.ListValue.newBuilder()
                      .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                      .build())
              .setMetadata(
                  com.google.spanner.v1.ResultSetMetadata.newBuilder()
                      .setRowType(
                          com.google.spanner.v1.StructType.newBuilder()
                              .addFields(
                                  com.google.spanner.v1.StructType.Field.newBuilder()
                                      .setName("COL1")
                                      .setType(
                                          com.google.spanner.v1.Type.newBuilder()
                                              .setCode(com.google.spanner.v1.TypeCode.INT64)
                                              .build())
                                      .build())
                              .build())
                      .build())
              .build();
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.query(
              Statement.of("SELECT * FROM Albums"), select1ResultSet));

      TagTestHelper.singleUseConsume(databaseClient, Statement.of("SELECT * FROM Albums"));

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals(
          "TagTestHelper.singleUseConsume", sqlRequest.getRequestOptions().getRequestTag());
      assertEquals("", sqlRequest.getRequestOptions().getTransactionTag());
    }
  }

  @Test
  public void testMultiUseReadOnlyTransactionAutoTagging() {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      com.google.spanner.v1.ResultSet select1ResultSet =
          com.google.spanner.v1.ResultSet.newBuilder()
              .addRows(
                  com.google.protobuf.ListValue.newBuilder()
                      .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                      .build())
              .setMetadata(
                  com.google.spanner.v1.ResultSetMetadata.newBuilder()
                      .setRowType(
                          com.google.spanner.v1.StructType.newBuilder()
                              .addFields(
                                  com.google.spanner.v1.StructType.Field.newBuilder()
                                      .setName("COL1")
                                      .setType(
                                          com.google.spanner.v1.Type.newBuilder()
                                              .setCode(com.google.spanner.v1.TypeCode.INT64)
                                              .build())
                                      .build())
                              .build())
                      .build())
              .build();
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.query(
              Statement.of("SELECT * FROM Albums"), select1ResultSet));

      try (ReadOnlyTransaction transaction = databaseClient.readOnlyTransaction()) {
        TagTestHelper.readOnlyTxnConsume(transaction, Statement.of("SELECT * FROM Albums"));
      }

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals(
          "TagTestHelper.readOnlyTxnConsume", sqlRequest.getRequestOptions().getRequestTag());
      assertEquals("", sqlRequest.getRequestOptions().getTransactionTag());
    }

    mockSpanner.clearRequests();
    try (Spanner spannerInstance = createSpanner(false, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      try (ReadOnlyTransaction transaction = databaseClient.readOnlyTransaction()) {
        TagTestHelper.readOnlyTxnConsume(transaction, Statement.of("SELECT * FROM Albums"));
      }

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());
      assertEquals("", sqlRequest.getRequestOptions().getTransactionTag());
    }
  }

  @Test
  public void testTransactionManagerAutoTagging() {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.runWithManager(
          databaseClient, Statement.of("UPDATE Venues SET Capacity = 100"));

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals(
          "TagTestHelper.runWithManager", sqlRequest.getRequestOptions().getTransactionTag());
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());
    }
  }

  @Test
  public void testAsyncTransactionManagerAutoTagging() throws Exception {
    try (Spanner spannerInstance = createSpanner(true, "com.example.spanner")) {
      DatabaseClient databaseClient =
          spannerInstance.getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(
              Statement.of("UPDATE Venues SET Capacity = 100"), 1L));

      TagTestHelper.runWithAsyncManager(
              databaseClient, Statement.of("UPDATE Venues SET Capacity = 100"))
          .get();

      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest sqlRequest = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      String transactionTag = sqlRequest.getRequestOptions().getTransactionTag();
      assertTrue(transactionTag.contains("runWithAsyncManager"));
      assertEquals("", sqlRequest.getRequestOptions().getRequestTag());
    }
  }
}
