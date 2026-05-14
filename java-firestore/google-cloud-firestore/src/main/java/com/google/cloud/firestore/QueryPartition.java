/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.firestore;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nullable;

/**
 * A split point that can be used in a query as a starting and/or end point for the query results.
 * The cursors returned by {@link #getStartAt()} and {@link #getEndBefore()} can only be used in a
 * query that matches the constraint of query that produced this partition.
 */
public class QueryPartition {
  private final Query query;
  @Nullable private final Object[] startAt;
  @Nullable private final Object[] endBefore;

  public QueryPartition(Query query, @Nullable Object[] startAt, @Nullable Object[] endBefore) {
    this.query = query;
    this.startAt = startAt;
    this.endBefore = endBefore;
  }

  /**
   * The cursor that defines the first result for this partition. {@code null} if this is the first
   * partition.
   *
   * @return a cursor value that can be used with {@link Query#startAt(Object...)} or {@code null}
   *     if this is the first partition.
   */
  @Nullable
  public Object[] getStartAt() {
    return startAt;
  }

  /**
   * The cursor that defines the first result after this partition. {@code null} if this is the last
   * partition.
   *
   * @return a cursor value that can be used with {@link Query#endBefore(Object...)} or {@code null}
   *     if this is the last partition.
   */
  @Nullable
  public Object[] getEndBefore() {
    return endBefore;
  }

  /**
   * Returns a query that only returns the documents for this partition.
   *
   * @return a query partitioned by a {@link Query#startAt(Object...)} and {@link
   *     Query#endBefore(Object...)} cursor.
   */
  public Query createQuery() {
    Query baseQuery = query;
    if (startAt != null) {
      baseQuery = baseQuery.startAt(startAt);
    }
    if (endBefore != null) {
      baseQuery = baseQuery.endBefore(endBefore);
    }
    return baseQuery;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof QueryPartition)) return false;
    QueryPartition partition = (QueryPartition) o;
    return query.equals(partition.query)
        && Arrays.equals(startAt, partition.startAt)
        && Arrays.equals(endBefore, partition.endBefore);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(query);
    result = 31 * result + Arrays.hashCode(startAt);
    result = 31 * result + Arrays.hashCode(endBefore);
    return result;
  }
}
