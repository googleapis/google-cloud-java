/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration test reading large amounts of data. The size of data ensures that multiple chunks are
 * returned by the server.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITLargeReadTest {
  private static int numRows;

  private static final int WRITE_BATCH_SIZE = 1 << 20;
  private static final String TABLE_NAME = "TestTable";

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  private static Database db;
  private static HashFunction hasher;
  private static DatabaseClient client;

  // Generate a combination of small and large row sizes to allow multiple read/query restarts and
  // to exercise chunking.
  private static List<Integer> rowSizes() {
    List<Integer> rowSizes = new ArrayList<>();
    rowSizes.addAll(Collections.nCopies(1000, 4096));
    rowSizes.addAll(Collections.nCopies(100, 40960));
    rowSizes.addAll(Collections.nCopies(25, 409600));
    rowSizes.addAll(Collections.nCopies(10, 4 << 20));
    Collections.shuffle(rowSizes);
    return rowSizes;
  }

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE TestTable ("
                    + "  Key           INT64 NOT NULL,"
                    + "  Data          BYTES(MAX),"
                    + "  Fingerprint   INT64,"
                    + "  Size          INT64,"
                    + ") PRIMARY KEY (Key)");
    hasher = Hashing.goodFastHash(64);
    client = env.getTestHelper().getDatabaseClient(db);

    List<Mutation> mutations = new ArrayList<>();
    Random rnd = new Random();
    int totalSize = 0;
    int i = 0;
    for (int rowSize : rowSizes()) {
      numRows++;
      byte[] data = new byte[rowSize];
      rnd.nextBytes(data);
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to(i)
              .set("Data")
              .to(ByteArray.copyFrom(data))
              .set("Fingerprint")
              .to(hasher.hashBytes(data).asLong())
              .set("Size")
              .to(rowSize)
              .build());
      totalSize += rowSize;
      i++;
      if (totalSize >= WRITE_BATCH_SIZE) {
        client.write(mutations);
        mutations.clear();
        totalSize = 0;
      }
    }
    client.write(mutations);
  }

  @Test
  public void read() {
    try (ResultSet resultSet =
        client
            .singleUse()
            .read(TABLE_NAME, KeySet.all(), Arrays.asList("Key", "Data", "Fingerprint", "Size"))) {
      validate(resultSet);
    }
  }

  @Test
  public void readWithSmallPrefetchChunks() {
    try (ResultSet resultSet =
        client
            .singleUse()
            .read(
                TABLE_NAME,
                KeySet.all(),
                Arrays.asList("Key", "Data", "Fingerprint", "Size"),
                Options.prefetchChunks(1))) {
      validate(resultSet);
    }
  }

  @Test
  public void query() {
    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT Key, Data, Fingerprint, Size FROM " + TABLE_NAME + " ORDER BY Key"))) {
      validate(resultSet);
    }
  }

  @Test
  public void queryWithSmallPrefetchChunks() {
    try (ResultSet resultSet =
        client
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT Key, Data, Fingerprint, Size FROM " + TABLE_NAME + " ORDER BY Key"),
                Options.prefetchChunks(1))) {
      validate(resultSet);
    }
  }

  private void validate(ResultSet resultSet) {
    int i = 0;
    while (resultSet.next()) {
      assertThat(resultSet.getLong(0)).isEqualTo(i);
      ByteArray data = resultSet.getBytes(1);
      assertThat(data.length()).isEqualTo(resultSet.getLong(3));
      assertThat(resultSet.getLong(2)).isEqualTo(hasher.hashBytes(data.toByteArray()).asLong());
      assertThat(++i).isAtMost(numRows);
    }
    assertThat(i).isEqualTo(numRows);
  }
}
