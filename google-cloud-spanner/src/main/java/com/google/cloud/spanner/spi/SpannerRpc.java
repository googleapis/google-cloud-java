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

package com.google.cloud.spanner.spi;

import com.google.cloud.spanner.SpannerException;
import com.google.common.collect.ImmutableList;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Abstracts remote calls to the Cloud Spanner service. Typically end-consumer code will never use
 * this interface; it's main purpose is to abstract the implementation of the public Cloud Spanner
 * API from the underlying transport mechanism.
 *
 * <p>Each {@code SpannerRPC} instance is bound to a particular project and set of authorization
 * credentials.
 *
 * <p>The interface is currently defined in terms of the generated HTTP client model classes. This
 * is purely for expedience; a future version of this interface is likely to be independent of
 * transport to allow switching between gRPC and HTTP.
 */
public interface SpannerRpc {
  /** Options passed in {@link SpannerRpc} methods to control how an RPC is issued. */
  enum Option {
    CHANNEL_HINT("Channel Hint");

    private final String value;

    Option(String value) {
      this.value = value;
    }

    @SuppressWarnings("unchecked")
    <T> T get(@Nullable Map<Option, ?> options) {
      if (options == null) {
        return null;
      }
      return (T) options.get(this);
    }

    Long getLong(@Nullable Map<Option, ?> options) {
      return get(options);
    }

    @Override
    public String toString() {
      return value;
    }
  }

  /**
   * Represents results from paginated RPCs, i.e., those where up to a maximum number of items is
   * returned from each call and a followup call must be made to fetch more.
   *
   * @param <T> the type of result
   */
  public static final class Paginated<T> {
    private final Iterable<T> results;
    private final String nextPageToken;

    /**
     * Creates a new page of results.
     *
     * @param results the result, or null for no results.
     * @param nextPageToken the token for the next page of results, or null if no more pages exist
     */
    public Paginated(@Nullable Iterable<T> results, @Nullable String nextPageToken) {
      // The generated HTTP client has null members when no results are present, rather than an
      // empty list.  Implicitly convert to an empty list to minimize the risk of NPEs.
      this.results = (results == null) ? ImmutableList.<T>of() : results;
      this.nextPageToken =
          (nextPageToken == null || nextPageToken.isEmpty()) ? null : nextPageToken;
    }

    /**
     * Returns the current page of results. Always returns non-null; if a null "results" was passed
     * to the constructor, a default empty {@code Iterable} will be returned.
     */
    public Iterable<T> getResults() {
      return results;
    }

    /**
     * Returns the token to use in the request for the next page, or null if this is the last page.
     */
    @Nullable
    public String getNextPageToken() {
      return nextPageToken;
    }
  }

  /** Consumer for the results produced by a streaming read or query call. */
  interface ResultStreamConsumer {
    void onPartialResultSet(PartialResultSet results);

    void onCompleted();

    void onError(SpannerException e);
  }

  /** Handle for cancellation of a streaming read or query call. */
  interface StreamingCall {

    /**
     * Requests more messages from the stream. We disable the auto flow control mechanisam in grpc,
     * so we need to request messages ourself. This gives us more control over how much buffer we
     * maintain in the client. Grpc will request 1 initial message automatically so we don't need to
     * call this at the beginning. After that it should be called whenever there is a flow control
     * window available based on the flow control setting configured by the client. Currently we do
     * not have any flow control so this is called automatically when a message is received.
     */
    void request(int numMessages);

    /**
     * Cancels the call.
     *
     * @param message a message to use in the final status of any underlying RPC
     */
    void cancel(@Nullable String message);
  }

  // Instance admin APIs.
  Paginated<InstanceConfig> listInstanceConfigs(int pageSize, @Nullable String pageToken)
      throws SpannerException;

  InstanceConfig getInstanceConfig(String instanceConfigName) throws SpannerException;

  Paginated<Instance> listInstances(
      int pageSize, @Nullable String pageToken, @Nullable String filter) throws SpannerException;

  Operation createInstance(String parent, String instanceId, Instance instance)
      throws SpannerException;

  Operation updateInstance(Instance instance, FieldMask fieldMask) throws SpannerException;

  Instance getInstance(String instanceName) throws SpannerException;

  void deleteInstance(String instanceName) throws SpannerException;

  // Database admin APIs.
  Paginated<Database> listDatabases(String instanceName, int pageSize, @Nullable String pageToken)
      throws SpannerException;

  Operation createDatabase(
      String instanceName, String createDatabaseStatement, Iterable<String> additionalStatements)
      throws SpannerException;

  Operation updateDatabaseDdl(
      String databaseName, Iterable<String> updateDatabaseStatements, @Nullable String updateId)
      throws SpannerException;

  void dropDatabase(String databaseName) throws SpannerException;

  Database getDatabase(String databaseName) throws SpannerException;

  List<String> getDatabaseDdl(String databaseName) throws SpannerException;

  /** Retrieves a long running operation. */
  Operation getOperation(String name) throws SpannerException;

  Session createSession(String databaseName, @Nullable Map<Option, ?> options)
      throws SpannerException;

  void deleteSession(String sessionName, @Nullable Map<Option, ?> options) throws SpannerException;

  StreamingCall read(
      ReadRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options);

  StreamingCall executeQuery(
      ExecuteSqlRequest request, ResultStreamConsumer consumer, @Nullable Map<Option, ?> options);

  Transaction beginTransaction(BeginTransactionRequest request, @Nullable Map<Option, ?> options)
      throws SpannerException;

  CommitResponse commit(CommitRequest commitRequest, @Nullable Map<Option, ?> options)
      throws SpannerException;

  void rollback(RollbackRequest request, @Nullable Map<Option, ?> options) throws SpannerException;
}
