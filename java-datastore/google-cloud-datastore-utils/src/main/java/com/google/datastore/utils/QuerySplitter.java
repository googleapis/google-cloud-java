/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils;

import com.google.api.core.BetaApi;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.Query;
import com.google.protobuf.Timestamp;
import java.util.List;

/** Provides the ability to split a query into multiple shards. */
public interface QuerySplitter {

  /**
   * Returns a list of sharded {@link Query}s for the given query.
   *
   * <p>This will create up to the desired number of splits, however it may return less splits if
   * the desired number of splits is unavailable. This will happen if the number of split points
   * provided by the underlying Datastore is less than the desired number, which will occur if the
   * number of results for the query is too small.
   *
   * @param query the query to split.
   * @param partition the partition the query is running in.
   * @param numSplits the desired number of splits.
   * @param datastore the datastore to run on.
   * @throws DatastoreException if there was a datastore error while generating query splits.
   * @throws IllegalArgumentException if the given query or numSplits was invalid.
   */
  List<Query> getSplits(Query query, PartitionId partition, int numSplits, Datastore datastore)
      throws DatastoreException;

  /**
   * Same as {@link #getSplits(Query, PartitionId, int, Datastore)} but the splits are based on
   * {@code readTime}, and the returned sharded {@link Query}s should also be executed with {@code
   * readTime}. Reading from a timestamp is currently a private preview feature in Datastore.
   */
  @BetaApi
  default List<Query> getSplits(
      Query query, PartitionId partition, int numSplits, Datastore datastore, Timestamp readTime)
      throws DatastoreException {
    throw new UnsupportedOperationException("Not implemented.");
  }
}
