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
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.BatchReadOnlyTransaction;
import com.google.cloud.spanner.BatchTransactionId;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Partition;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration test reading large amounts of data using the Batch APIs. The size of data ensures
 * that multiple paritions are returned by the server.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITBatchReadTest {
  private static int numRows;

  private static final int WRITE_BATCH_SIZE = 1 << 20;
  private static final String TABLE_NAME = "BatchTestTable";
  private static final String INDEX_NAME = "TestIndexByValue";
  private static final long STALENESS_MILLISEC = 1 * 1000;

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  private static Database db;
  private static HashFunction hasher;
  private static DatabaseClient dbClient;
  private static BatchClient client;
  private static final Random RANDOM = new Random();

  private BatchReadOnlyTransaction batchTxn;

  // Generate a large number of rows to allow multiple read/query partitions.
  private static List<Integer> manyRows() {
    List<Integer> rows = new ArrayList<>();
    rows.addAll(Collections.nCopies(1000, 4096));
    rows.addAll(Collections.nCopies(100, 40960));
    rows.addAll(Collections.nCopies(25, 409600));
    rows.addAll(Collections.nCopies(10, 4 << 20));
    return rows;
  }

  @BeforeClass
  public static void setUpDatabase() throws Exception {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE "
                    + TABLE_NAME
                    + " ("
                    + "  Key           INT64 NOT NULL,"
                    + "  Data          BYTES(MAX),"
                    + "  Fingerprint   INT64,"
                    + "  Size          INT64,"
                    + ") PRIMARY KEY (Key)",
                "CREATE INDEX " + INDEX_NAME + " ON " + TABLE_NAME + "(Fingerprint)");
    hasher = Hashing.goodFastHash(64);
    dbClient = env.getTestHelper().getDatabaseClient(db);
    client = env.getTestHelper().getBatchClient(db);

    List<Mutation> mutations = new ArrayList<>();
    int totalSize = 0;
    int i = 0;
    for (int row : manyRows()) {
      numRows++;
      byte[] data = new byte[row];
      RANDOM.nextBytes(data);
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to(i)
              .set("Data")
              .to(ByteArray.copyFrom(data))
              .set("Fingerprint")
              .to(hasher.hashBytes(data).asLong())
              .set("Size")
              .to(row)
              .build());
      totalSize += row;
      i++;
      if (totalSize >= WRITE_BATCH_SIZE) {
        dbClient.write(mutations);
        mutations.clear();
        totalSize = 0;
      }
    }
    dbClient.write(mutations);
    // Our read/queries are executed with some staleness.
    Thread.sleep(2 * STALENESS_MILLISEC);
  }

  @Test
  public void read() {
    BitSet seenRows = new BitSet(numRows);
    TimestampBound bound = getRandomBound();
    PartitionOptions partitionParams = getRandomPartitionOptions();
    batchTxn = client.batchReadOnlyTransaction(bound);
    List<Partition> partitions =
        batchTxn.partitionRead(
            partitionParams,
            TABLE_NAME,
            KeySet.all(),
            Arrays.asList("Key", "Data", "Fingerprint", "Size"));
    BatchTransactionId txnID = batchTxn.getBatchTransactionId();
    fetchAndValidateRows(partitions, txnID, seenRows);
  }

  @Test
  public void readUsingIndex() {
    TimestampBound bound = getRandomBound();
    PartitionOptions partitionParams = getRandomPartitionOptions();
    batchTxn = client.batchReadOnlyTransaction(bound);
    List<Partition> partitions =
        batchTxn.partitionReadUsingIndex(
            partitionParams,
            TABLE_NAME,
            INDEX_NAME,
            KeySet.all(),
            Arrays.asList("Fingerprint"));
    BatchTransactionId txnID = batchTxn.getBatchTransactionId();
    int numRowsRead = 0;
    for (Partition p : partitions) {
      BatchReadOnlyTransaction batchTxnOnEachWorker = client.batchReadOnlyTransaction(txnID);
      try (ResultSet result = batchTxnOnEachWorker.execute(p)) {
        while (result.next()) {
          numRowsRead++;
        }
      }
    }
    assertThat(numRowsRead).isEqualTo(numRows);

  }

  @After
  public void tearDown() throws Exception {
    if (batchTxn != null) {
      batchTxn.close();
    }
  }

  @Test
  public void query() {
    BitSet seenRows = new BitSet(numRows);
    TimestampBound bound = getRandomBound();
    PartitionOptions partitionParams = getRandomPartitionOptions();
    batchTxn = client.batchReadOnlyTransaction(bound);
    List<Partition> partitions =
        batchTxn.partitionQuery(
            partitionParams,
            Statement.of("SELECT Key, Data, Fingerprint, Size FROM " + TABLE_NAME));
    BatchTransactionId txnID = batchTxn.getBatchTransactionId();
    fetchAndValidateRows(partitions, txnID, seenRows);
  }

  private PartitionOptions getRandomPartitionOptions() {
    int desiredBytesPerBatch = 1 << 30;
    int maxPartitionCount = 100;
    PartitionOptions parameters =
        PartitionOptions.newBuilder()
            .setPartitionSizeBytes(desiredBytesPerBatch)
            .setMaxPartitions(maxPartitionCount)
            .build();
    if (RANDOM.nextInt(2) == 1) {
      parameters = PartitionOptions.getDefaultInstance();
    }
    return parameters;
  }

  private TimestampBound getRandomBound() {
    Date date = new Date();
    switch (RANDOM.nextInt(3)) {
      case 0:
        return TimestampBound.strong();
      case 1:
        return TimestampBound.ofExactStaleness(STALENESS_MILLISEC, TimeUnit.MILLISECONDS);
      default:
        return TimestampBound.ofReadTimestamp(
            Timestamp.of(new Date(date.getTime() - STALENESS_MILLISEC)));
    }
  }

  private void fetchAndValidateRows(
      List<Partition> partitions, BatchTransactionId txnID, BitSet seenRows) {
    for (Partition p : partitions) {
      BatchReadOnlyTransaction batchTxnOnEachWorker = client.batchReadOnlyTransaction(txnID);
      try (ResultSet result = batchTxnOnEachWorker.execute(p)) {
        // validate no duplicate rows; verify all columns read.
        validate(result, seenRows);
      }
    }
    // verify all rows were read from the database.
    assertThat(seenRows.nextClearBit(0)).isEqualTo(numRows);
  }

  private void validate(ResultSet resultSet, BitSet seenRows) {
    while (resultSet.next()) {
      assertThat(seenRows.get((int) resultSet.getLong(0))).isFalse();
      seenRows.set((int) resultSet.getLong(0));
      ByteArray data = resultSet.getBytes(1);
      assertThat(data.length()).isEqualTo(resultSet.getLong(3));
      assertThat(resultSet.getLong(2)).isEqualTo(hasher.hashBytes(data.toByteArray()).asLong());
    }
  }
}
