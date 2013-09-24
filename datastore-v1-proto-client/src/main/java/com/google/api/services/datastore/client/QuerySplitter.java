/*
 * Copyright 2013 Google Inc. All Rights Reserved.
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
package com.google.api.services.datastore.client;

import com.google.api.services.datastore.DatastoreV1.Query;

import java.util.List;

/**
 * Provides the ability to split a query into multiple shards.
 *
 */
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
   * @param numSplits the desired number of splits.
   * @param datastore the datastore to run on.
   * @throws DatastoreException if there was a datastore error while generating query splits.
   * @throws IllegalArgumentException if the given query or numSplits was invalid.
   */
  List<Query> getSplits(Query query, int numSplits, Datastore datastore)
      throws DatastoreException;
}
