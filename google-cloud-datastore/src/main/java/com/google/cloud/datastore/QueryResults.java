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

import com.google.datastore.v1.QueryResultBatch;
import java.util.Iterator;

/**
 * The result of a Google Cloud Datastore query submission. When the result is not typed it is
 * possible to cast it to its appropriate type according to the {@link #getResultClass} value.
 * Results are loaded lazily in batches, where batch size is set by Cloud Datastore. As a result, it
 * is possible to get a {@code DatastoreException} upon {@link Iterator#hasNext hasNext} or {@link
 * Iterator#next next} calls.
 *
 * @param <V> the type of the results value.
 */
public interface QueryResults<V> extends Iterator<V> {

  /** Returns the actual class of the result's values. */
  Class<?> getResultClass();

  /**
   * Returns the Cursor for the point after the value returned in the last {@link #next} call. This
   * cursor can be used to issue subsequent queries (with the same constraints) that may return
   * additional results.
   *
   * <p>A simple use case:
   *
   * <pre>{@code
   * Query<Entity> query = Query.newEntityQueryBuilder()
   *     .setKind("Person")
   *     .setFilter(PropertyFilter.eq("favoriteFood", "pizza"))
   *     .build();
   * QueryResults<Entity> results = datastore.run(query);
   * // Consume some results (using results.next()) and do any other actions as necessary.
   * query = query.toBuilder().setStartCursor(results.getCursorAfter()).build();
   * results = datastore.run(query); // now we will iterate over all entities not yet consumed
   * }</pre>
   */
  Cursor getCursorAfter();

  /**
   * Returns the number of results skipped, typically because of an offset.
   *
   * <p>A simple use case to count entities:
   *
   * <pre>{@code
   * Query<Key> query = Query.newKeyQueryBuilder().setOffset(Integer.MAX_VALUE).build();
   * QueryResults<Key> result = datasore.datastore.run(query);
   * if (!result.hasNext()) {
   *  int numberOfEntities = result.getSkippedResults();
   * }
   * }</pre>
   */
  int getSkippedResults();

  /** Returns MoreResults state of the query after the current batch. */
  QueryResultBatch.MoreResultsType getMoreResults();
}
