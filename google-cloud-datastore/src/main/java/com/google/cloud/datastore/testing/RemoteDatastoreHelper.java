/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.datastore.testing;

import com.google.cloud.HttpTransportOptions;
import com.google.cloud.RetryParams;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;

import java.util.UUID;

/**
 * Utility to create a remote datastore configuration for testing. Datastore options can be obtained
 * via the {@link #getOptions()} method. Returned options use a randomly generated namespace
 * ({@link DatastoreOptions#getNamespace()}) that can be used to run the tests. Once the tests are
 * run, all entities in the namespace can be deleted using {@link #deleteNamespace()}. Returned
 * options also have custom {@link DatastoreOptions#getRetryParams()}:
 * {@link RetryParams#getRetryMaxAttempts()} is {@code 10},
 * {@link RetryParams#getRetryMinAttempts()} is {@code 6},
 * {@link RetryParams#getMaxRetryDelayMillis()} is {@code 30000},
 * {@link RetryParams#getTotalRetryPeriodMillis()} is {@code 120000} and
 * {@link RetryParams#getInitialRetryDelayMillis()} is {@code 250}.
 * {@link HttpTransportOptions#getConnectTimeout()} and
 * {@link HttpTransportOptions#getReadTimeout()} are both
 * both set to {@code 60000}.
 */
public class RemoteDatastoreHelper {

  private final DatastoreOptions options;
  private final Datastore datastore;
  private final String namespace;

  private RemoteDatastoreHelper(DatastoreOptions options) {
    this.options = options;
    this.datastore = options.getService();
    this.namespace = options.getNamespace();
  }


  /**
   * Returns a {@link DatastoreOptions} object to be used for testing. The options are associated
   * to a randomly generated namespace.
   */
  public DatastoreOptions getOptions() {
    return options;
  }

  /**
   * Deletes all entities in the namespace associated with this {@link RemoteDatastoreHelper}.
   */
  public void deleteNamespace() {
    StructuredQuery<Key> query = Query.newKeyQueryBuilder().setNamespace(namespace).build();
    QueryResults<Key> keys = datastore.run(query);
    while (keys.hasNext()) {
      datastore.delete(keys.next());
    }
  }

  /**
   * Creates a {@code RemoteStorageHelper} object.
   */
  public static RemoteDatastoreHelper create() {
    HttpTransportOptions transportOptions = DatastoreOptions.getDefaultHttpTransportOptions();
    transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
        .build();
    DatastoreOptions datastoreOption = DatastoreOptions.newBuilder()
        .setNamespace(UUID.randomUUID().toString())
        .setRetryParams(retryParams())
        .setTransportOptions(transportOptions)
        .build();
    return new RemoteDatastoreHelper(datastoreOption);
  }

  private static RetryParams retryParams() {
    return RetryParams.newBuilder()
        .setRetryMaxAttempts(10)
        .setRetryMinAttempts(6)
        .setMaxRetryDelayMillis(30000)
        .setTotalRetryPeriodMillis(120000)
        .setInitialRetryDelayMillis(250)
        .build();
  }
}
