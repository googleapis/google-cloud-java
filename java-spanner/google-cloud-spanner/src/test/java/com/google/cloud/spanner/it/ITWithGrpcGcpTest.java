/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for using gRPC-GCP extension. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITWithGrpcGcpTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String TABLE_NAME = "TestTable";
  private static final List<String> ALL_COLUMNS = Arrays.asList("Key", "StringValue");

  private static RemoteSpannerHelper testHelper;
  private static Database db;
  private static DatabaseClient client;

  @BeforeClass
  public static void setUpDatabase() {
    // Get default spanner options for an integration test.
    SpannerOptions.Builder builder = env.getTestHelper().getOptions().toBuilder();
    builder.enableGrpcGcpExtension();

    // Create a new testHelper with the gRPC-GCP extension enabled.
    testHelper = RemoteSpannerHelper.create(builder.build(), env.getTestHelper().getInstanceId());

    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE "
                    + TABLE_NAME
                    + " ("
                    + "  Key                STRING(MAX) NOT NULL,"
                    + "  StringValue        STRING(MAX),"
                    + ") PRIMARY KEY (Key)");
    client = testHelper.getDatabaseClient(db);

    List<Mutation> mutations = new ArrayList<>();
    for (int i = 0; i < 3; ++i) {
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to("k" + i)
              .set("StringValue")
              .to("v" + i)
              .build());
    }
    client.write(mutations);
  }

  @Test
  public void singleRead() {
    Struct row =
        client.singleUse(TimestampBound.strong()).readRow(TABLE_NAME, Key.of("k1"), ALL_COLUMNS);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo("k1");
    assertThat(row.getString(1)).isEqualTo("v1");
  }

  @Test
  public void usingTransaction() {
    final Long updatedCount =
        client
            .readWriteTransaction()
            .run(
                transaction ->
                    transaction.executeUpdate(
                        Statement.of(
                            "UPDATE " + TABLE_NAME + " SET StringValue='v2upd' WHERE Key='k2'")));
    assertThat(updatedCount).isEqualTo(1L);

    Struct row =
        client.singleUse(TimestampBound.strong()).readRow(TABLE_NAME, Key.of("k2"), ALL_COLUMNS);
    assertThat(row).isNotNull();
    assertThat(row.getString(0)).isEqualTo("k2");
    assertThat(row.getString(1)).isEqualTo("v2upd");
  }
}
