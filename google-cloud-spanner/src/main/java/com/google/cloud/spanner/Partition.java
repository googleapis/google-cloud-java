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

import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.protobuf.ByteString;
import java.io.Serializable;

// TODO(snehashah): add serializable support. Add javadocs.
public class Partition implements Serializable {

  private final String partitionToken;
  private final String sessionId;
  private final ByteString transactionId;
  private final String table;
  private final KeySet keys;
  private final Iterable<String> columns;
  private final String index;
  private final Options readOptions;
  private final Statement statement;
  private final Options queryOptions;
  private final PartitionParameters partitionParameters;

  protected Partition(Builder builder) {
    this.partitionToken = builder.partitionToken;
    this.sessionId = builder.sessionId;
    this.transactionId = builder.transactionId;
    this.table = builder.table;
    this.keys = builder.keys;
    this.columns = builder.columns;
    this.index = builder.index;
    this.readOptions = builder.readOptions;
    this.statement = builder.statement;
    this.queryOptions = builder.queryOptions;
    this.partitionParameters = builder.partitionParameters;
  }

  // TODO(snehashah): add precondition check to ensure both Query & Read params are not set ?
  protected static class Builder {
    private String partitionToken;
    private String sessionId;
    private ByteString transactionId;
    private String table;
    private KeySet keys;
    private Iterable<String> columns;
    private String index;
    private Options readOptions;
    private Statement statement;
    private Options queryOptions;
    private PartitionParameters partitionParameters;

    Builder(String partitionToken, String sessionId, ByteString transactionId) {
      this.partitionToken = partitionToken;
      this.sessionId = sessionId;
      this.transactionId = transactionId;
    }

    protected Partition build() {
      return new Partition(this);
    }

    protected Builder setTable(String table) {
      this.table = table;
      return this;
    }

    protected Builder setKeys(KeySet keys) {
      this.keys = keys;
      return this;
    }

    protected Builder setColumns(Iterable<String> columns) {
      this.columns = columns;
      return this;
    }

    protected Builder setIndex(String index) {
      this.index = index;
      return this;
    }

    protected Builder setReadOptions(ReadOption... readOptions) {
      this.readOptions = Options.fromReadOptions(readOptions);
      return this;
    }

    protected Builder setStatement(Statement statement) {
      this.statement = statement;
      return this;
    }

    protected Builder setQueryOptions(QueryOption... queryOptions) {
      this.queryOptions = Options.fromQueryOptions(queryOptions);
      return this;
    }

    protected Builder setPartitionParameters(PartitionParameters parameters) {
      this.partitionParameters = parameters;
      return this;
    }
  }

  protected static Builder newBuilder(
      String partitionToken, String sessionId, ByteString transactionId) {
    return new Builder(partitionToken, sessionId, transactionId);
  }

  public static Partition getDefaultInstance(
      String partitionToken, String sessionId, ByteString transactionId) {
    return newBuilder(partitionToken, sessionId, transactionId).build();
  }

  protected boolean hasQueryParams() {
    return statement != null;
  }

  // TODO(snehashah): verify other mandatory args.
  protected boolean hasReadUsingIndexParams() {
    return table != null && index != null;
  }

  // TODO(snehashah): verify other mandatory args.
  protected boolean hasReadParams() {
    return table != null;
  }

  protected String getPartitionToken() {
    return partitionToken;
  }

  protected String getSessionId() {
    return sessionId;
  }

  protected ByteString getTransactionId() {
    return transactionId;
  }

  protected String getTable() {
    return table;
  }

  protected KeySet getKeys() {
    return keys;
  }

  protected Iterable<String> getColumns() {
    return columns;
  }

  protected String getIndex() {
    return index;
  }

  protected Options getReadOptions() {
    return readOptions;
  }

  protected Statement getStatement() {
    return statement;
  }

  protected Options getQueryOptions() {
    return queryOptions;
  }

  protected PartitionParameters getPartitionParameters() {
    return partitionParameters;
  }
}