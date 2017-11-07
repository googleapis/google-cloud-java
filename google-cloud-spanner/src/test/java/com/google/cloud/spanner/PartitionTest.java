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

package com.google.cloud.spanner;

import static com.google.common.testing.SerializableTester.reserializeAndAssert;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.testing.EqualsTester;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Partition}. */
@RunWith(JUnit4.class)
public class PartitionTest {

  ByteString partitionToken = ByteString.copyFromUtf8("partitionToken");
  PartitionOptions partitionOptions = PartitionOptions.getDefaultInstance();
  String table = "table";
  String index = "index";
  KeySet keys = KeySet.singleKey(Key.of("a", "b", "c"));
  Iterable<String> columns = Arrays.asList("c1", "c2");
  Options.ReadOption rOption = Options.limit(10);
  Options readOptions = Options.fromReadOptions(rOption);
  Statement stmt =
      Statement.newBuilder("SELECT Name FROM Users")
          .append(" WHERE Id = @id")
          .bind("id")
          .to(1234)
          .append(" AND Status = @status")
          .bind("status")
          .to("ACTIVE")
          .build();
  Options.QueryOption qOption = Options.prefetchChunks(10);
  Options queryOptions = Options.fromQueryOptions(qOption);

  @Test
  public void statementInstance() {
    Partition p =
        Partition.createQueryPartition(partitionToken, partitionOptions, stmt, queryOptions);
    assertThat(p.getPartitionToken()).isEqualTo(partitionToken);
    assertThat(p.getStatement()).isEqualTo(stmt);
    assertThat(p.getQueryOptions().hasPrefetchChunks()).isTrue();
    assertThat(p.getQueryOptions().prefetchChunks()).isEqualTo(10);

    assertNull(p.getTable());
    assertNull(p.getColumns());
    assertNull(p.getKeys());
    assertNull(p.getIndex());
    assertNull(p.getReadOptions());

    // Test serialization.
    reserializeAndAssert(p);
  }

  @Test
  public void readInstance() {
    Partition p =
        Partition.createReadPartition(
            partitionToken, partitionOptions, table, null /*index*/, keys, columns, readOptions);
    assertThat(p.getPartitionToken()).isEqualTo(partitionToken);

    assertThat(p.getTable()).isEqualTo(table);
    assertThat(p.getKeys()).isEqualTo(keys);
    assertThat(p.getColumns()).isEqualTo(columns);
    assertTrue(p.getReadOptions().hasLimit());
    assertThat(p.getReadOptions().limit()).isEqualTo(10);

    assertNull(p.getIndex());
    assertNull(p.getStatement());
    assertNull(p.getQueryOptions());

    // Test serialization.
    reserializeAndAssert(p);
  }

  @Test
  public void readUsingIndexInstance() {
    Partition p =
        Partition.createReadPartition(
            partitionToken, partitionOptions, table, index, keys, columns, readOptions);
    assertThat(p.getPartitionToken()).isEqualTo(partitionToken);
    assertThat(p.getTable()).isEqualTo(table);
    assertThat(p.getIndex()).isEqualTo(index);
    assertThat(p.getKeys()).isEqualTo(keys);
    assertThat(p.getColumns()).isEqualTo(columns);
    assertTrue(p.getReadOptions().hasLimit());
    assertThat(p.getReadOptions().limit()).isEqualTo(10);

    assertNull(p.getStatement());
    assertNull(p.getQueryOptions());

    // Test serialization.
    reserializeAndAssert(p);
  }

  @Test
  public void equalAndHashCode() {
    new EqualsTester()
        .addEqualityGroup(
            Partition.createQueryPartition(partitionToken, partitionOptions, stmt, queryOptions),
            Partition.createQueryPartition(partitionToken, partitionOptions, stmt, queryOptions))
        .addEqualityGroup(
            Partition.createReadPartition(
                partitionToken,
                partitionOptions,
                table,
                null /*index*/,
                keys,
                columns,
                readOptions),
            Partition.createReadPartition(
                partitionToken,
                partitionOptions,
                table,
                null /*index*/,
                keys,
                columns,
                readOptions))
        .addEqualityGroup(
            Partition.createReadPartition(
                partitionToken, partitionOptions, table, index, keys, columns, readOptions),
            Partition.createReadPartition(
                partitionToken, partitionOptions, table, index, keys, columns, readOptions))
        .testEquals();
  }
}
