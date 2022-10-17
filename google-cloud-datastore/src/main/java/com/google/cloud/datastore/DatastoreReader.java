/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import com.google.api.core.BetaApi;
import java.util.Iterator;
import java.util.List;

/** An interface to represent Google Cloud Datastore read operations. */
public interface DatastoreReader {

  /**
   * Returns an {@link Entity} for the given {@link Key} or {@code null} if it doesn't exist.
   *
   * @throws DatastoreException upon failure
   */
  Entity get(Key key);

  /**
   * Returns an {@link Entity} for each given {@link Key} that exists in the Datastore. The order of
   * the result is unspecified. Results are loaded lazily, so it is possible to get a {@code
   * DatastoreException} from the returned {@code Iterator}'s {@link Iterator#hasNext hasNext} or
   * {@link Iterator#next next} methods.
   *
   * @throws DatastoreException upon failure
   * @see #get(Key)
   */
  Iterator<Entity> get(Key... keys);

  /**
   * Returns a list with a value for each given key (ordered by input). {@code null} values are
   * returned for nonexistent keys. When possible prefer using {@link #get(Key...)} to avoid eagerly
   * loading the results.
   */
  List<Entity> fetch(Key... keys);

  /**
   * Submits a {@link Query} and returns its result.
   *
   * @throws DatastoreException upon failure
   */
  <T> QueryResults<T> run(Query<T> query);

  /**
   * Submits a {@link AggregationQuery} and returns {@link AggregationResults}.
   *
   * @throws DatastoreException upon failure
   */
  @BetaApi
  default AggregationResults runAggregation(AggregationQuery query) {
    throw new UnsupportedOperationException("Not implemented.");
  }
}
