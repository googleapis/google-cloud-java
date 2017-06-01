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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.*;

import com.google.cloud.spanner.Options;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import org.junit.Test;

public class PartitionTest {

  @Test
  public void defaultInstance() {
    String partitionToken = "partitionToken";
    String sessionId = "sessionId";
    ByteString transactionId = ByteString.copyFromUtf8("transactionId");
    Partition p = Partition.getDefaultInstance(partitionToken, sessionId, transactionId);
    assertThat(p.getPartitionToken()).isEqualTo(partitionToken);
    assertThat(p.getSessionId()).isEqualTo(sessionId);
    assertThat(p.getTransactionId()).isEqualTo(transactionId);

    assertNull(p.getTable());
    assertNull(p.getColumns());
    assertNull(p.getKeys());
    assertNull(p.getIndex());
    assertNull(p.getReadOptions());
    assertNull(p.getStatement());
    assertNull(p.getQueryOptions());
    assertNull(p.getPartitionParameters());
  }

  @Test
  public void statementInstance() {
    String partitionToken = "partitionToken";
    String sessionId = "sessionId";
    ByteString transactionId = ByteString.copyFromUtf8("transactionId");
    Statement stmt =
        Statement.newBuilder("SELECT Name FROM Users")
            .append(" WHERE Id = @id")
            .bind("id")
            .to(1234)
            .append(" AND Status = @status")
            .bind("status")
            .to("ACTIVE")
            .build();
    Options.QueryOption queryOptions = Options.prefetchChunks(10);

    Partition p =
        Partition.newBuilder(partitionToken, sessionId, transactionId)
            .setStatement(stmt)
            .setQueryOptions(queryOptions)
            .build();
    assertThat(p.getPartitionToken()).isEqualTo(partitionToken);
    assertThat(p.getSessionId()).isEqualTo(sessionId);
    assertThat(p.getTransactionId()).isEqualTo(transactionId);
    assertThat(p.getStatement()).isEqualTo(stmt);
    assertThat(p.getQueryOptions().hasPrefetchChunks()).isTrue();
    assertThat(p.getQueryOptions().prefetchChunks()).isEqualTo(10);
    assertTrue(p.hasQueryParams());
    
    assertNull(p.getTable());
    assertNull(p.getColumns());
    assertNull(p.getKeys());
    assertNull(p.getIndex());
    assertNull(p.getReadOptions());
    assertNull(p.getPartitionParameters());
  }

  @Test
  public void readInstance() {
    String partitionToken = "partitionToken";
    String sessionId = "sessionId";
    ByteString transactionId = ByteString.copyFromUtf8("transactionId");
    String table = "table";
    KeySet keySet = KeySet.singleKey(Key.of("a", "b", "c"));
    Iterable<String> columns = Arrays.asList("c1", "c2");
    Options.ReadOption readOptions = Options.limit(10);

    Partition p =
        Partition.newBuilder(partitionToken, sessionId, transactionId)
            .setTable(table)
            .setKeys(keySet)
            .setColumns(columns)
            .setReadOptions(readOptions)
            .build();
    assertThat(p.getPartitionToken()).isEqualTo(partitionToken);
    assertThat(p.getSessionId()).isEqualTo(sessionId);
    assertThat(p.getTransactionId()).isEqualTo(transactionId);

    assertThat(p.getTable()).isEqualTo(table);
    assertThat(p.getKeys()).isEqualTo(keySet);
    assertThat(p.getColumns()).isEqualTo(columns);
    assertTrue(p.getReadOptions().hasLimit());
    assertThat(p.getReadOptions().limit()).isEqualTo(10);
    assertTrue(p.hasReadParams());
    
    assertNull(p.getIndex());
    assertNull(p.getStatement());
    assertNull(p.getQueryOptions());
    assertNull(p.getPartitionParameters());
  }

  @Test
  public void readUsingIndexInstance() {
    String partitionToken = "partitionToken";
    String sessionId = "sessionId";
    ByteString transactionId = ByteString.copyFromUtf8("transactionId");
    String table = "table";
    String index = "index";
    KeySet keySet = KeySet.singleKey(Key.of("a", "b", "c"));
    Iterable<String> columns = Arrays.asList("c1", "c2");
    Options.ReadOption readOptions = Options.limit(10);

    Partition p =
        Partition.newBuilder(partitionToken, sessionId, transactionId)
            .setTable(table)
            .setIndex(index)
            .setKeys(keySet)
            .setColumns(columns)
            .setReadOptions(readOptions)
            .build();
    assertThat(p.getPartitionToken()).isEqualTo(partitionToken);
    assertThat(p.getSessionId()).isEqualTo(sessionId);
    assertThat(p.getTransactionId()).isEqualTo(transactionId);
    assertTrue(p.hasReadUsingIndexParams());

    assertThat(p.getTable()).isEqualTo(table);
    assertThat(p.getIndex()).isEqualTo(index);
    assertThat(p.getKeys()).isEqualTo(keySet);
    assertThat(p.getColumns()).isEqualTo(columns);
    assertTrue(p.getReadOptions().hasLimit());
    assertThat(p.getReadOptions().limit()).isEqualTo(10);

    assertNull(p.getStatement());
    assertNull(p.getQueryOptions());
    assertNull(p.getPartitionParameters());
  }
}