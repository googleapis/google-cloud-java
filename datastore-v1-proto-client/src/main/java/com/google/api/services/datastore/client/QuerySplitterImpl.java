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

import com.google.api.services.datastore.DatastoreV1.EntityResult;
import com.google.api.services.datastore.DatastoreV1.Filter;
import com.google.api.services.datastore.DatastoreV1.Key;
import com.google.api.services.datastore.DatastoreV1.PropertyExpression;
import com.google.api.services.datastore.DatastoreV1.PropertyFilter;
import com.google.api.services.datastore.DatastoreV1.PropertyFilter.Operator;
import com.google.api.services.datastore.DatastoreV1.PropertyOrder.Direction;
import com.google.api.services.datastore.DatastoreV1.PropertyReference;
import com.google.api.services.datastore.DatastoreV1.Query;
import com.google.api.services.datastore.DatastoreV1.QueryResultBatch;
import com.google.api.services.datastore.DatastoreV1.QueryResultBatch.MoreResultsType;
import com.google.api.services.datastore.DatastoreV1.RunQueryRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An implementation of {@link QuerySplitter} for the Datastore.
 *
 * Runs a query on the scatter property to get a random sampling of entities.
 *
 **/
final class QuerySplitterImpl implements QuerySplitter {

  /** The number of keys to sample for each split. **/
  private static final int KEYS_PER_SPLIT = 32;

  static final QuerySplitter INSTANCE = new QuerySplitterImpl();

  QuerySplitterImpl() {
    // No initialization required.
  }

  /**
   * @see QuerySplitter#getSplits
   */
  @Override
  public List<Query> getSplits(Query query, int numSplits, Datastore datastore)
      throws DatastoreException, IllegalArgumentException {

    validateQuery(query);
    validateSplitSize(numSplits);

    List<Query> splits = new ArrayList<Query>();
    List<Key> scatterKeys = getScatterKeys(numSplits, query, datastore);
    Key lastKey = null;
    for (Key nextKey : getSplitKey(scatterKeys, numSplits)) {
      splits.add(createSplit(lastKey, nextKey, query));
      lastKey = nextKey;
    }
    splits.add(createSplit(lastKey, null, query));
    return splits;
  }

  /**
   * Helper to determine if a filter operator is an inequality.
   */
  private boolean isInequality(Operator operator) {
    return operator == Operator.LESS_THAN ||
        operator == Operator.LESS_THAN_OR_EQUAL ||
        operator == Operator.GREATER_THAN ||
        operator == Operator.GREATER_THAN_OR_EQUAL;
  }

  /**
   * Verify that the given number of splits is not out of bounds.
   * @param numSplits the number of splits.
   * @throws IllegalArgumentException if the split size is invalid.
   */
  private void validateSplitSize(int numSplits) throws IllegalArgumentException {
    if (numSplits < 1) {
      throw new IllegalArgumentException("The number of splits must be greater than 0.");
    }
  }

  /**
   * Validate that we only have allowable filters.
   *
   * Note that equality and ancestor filters are allowed, however they may result in
   * inefficient sharding.
   */
  private void validateFilter(Filter filter) throws IllegalArgumentException {
    if (filter.hasCompositeFilter()) {
      for (Filter subFilter : filter.getCompositeFilter().getFilterList()) {
        validateFilter(subFilter);
      }
    } else if (filter.hasPropertyFilter()) {
      if (isInequality(filter.getPropertyFilter().getOperator())) {
        throw new IllegalArgumentException("Query cannot have an inequality filter.",
            new IllegalArgumentException());
      }
    }
  }

  /**
   * Verify that the given query can be properly scattered.
   *
   * @param query the query to verify
   * @throws IllegalArgumentException if the query is invalid.
   */
  private void validateQuery(Query query) throws IllegalArgumentException {
    if (query.getKindCount() != 1) {
      throw new IllegalArgumentException("Query must have exactly one kind.");
    }
    if (query.getOrderCount() != 0) {
      throw new IllegalArgumentException("Query cannot have a sort order.");
    }
    if (query.hasFilter()) {
      validateFilter(query.getFilter());
    }
  }

  /**
   * Create a new {@link Query} given the query and range.
   *
   * @param lastKey the previous key. If null then assumed to be the beginning.
   * @param nextKey the next key. If null then assumed to be the end.
   * @param query the desired query.
   */
  private Query createSplit(Key lastKey, Key nextKey, Query query) {
    List<Filter> keyFilters = new ArrayList<Filter>();
    if (query.hasFilter()) {
      keyFilters.add(query.getFilter());
    }
    if (lastKey != null) {
      keyFilters.add(DatastoreHelper.makeFilter(
          DatastoreHelper.KEY_PROPERTY_NAME, PropertyFilter.Operator.GREATER_THAN_OR_EQUAL,
          DatastoreHelper.makeValue(lastKey)).build());
    }
    if (nextKey != null) {
      keyFilters.add(DatastoreHelper.makeFilter(
              DatastoreHelper.KEY_PROPERTY_NAME, PropertyFilter.Operator.LESS_THAN,
              DatastoreHelper.makeValue(nextKey)).build());
    }
    return Query.newBuilder(query).setFilter(
        DatastoreHelper.makeCompositeFilter(keyFilters)).build();
  }

  /**
   * Given a number of desired splits gets a list of scatter keys with multiples at each split.
   *
   * @param numSplits the number of desired splits.
   * @param query the user query.
   * @param datastore the datastore containing the data.
   * @throws DatastoreException if there was an error when executing the datastore query.
   */
  private List<Key> getScatterKeys(int numSplits, Query query, Datastore datastore)
      throws DatastoreException {
    Query.Builder scatterPointQuery = createScatterQuery(query, numSplits);

    List<Key> keySplits = new ArrayList<Key>();

    QueryResultBatch batch = null;
    do {
      batch = datastore.runQuery(RunQueryRequest.newBuilder().setQuery(query).build()).getBatch();
      for (EntityResult result : batch.getEntityResultList()) {
        keySplits.add(result.getEntity().getKey());
      }
      scatterPointQuery.setStartCursor(batch.getEndCursor());
      scatterPointQuery.setLimit(scatterPointQuery.getLimit() - batch.getEntityResultCount());
    } while (batch.getMoreResults() == MoreResultsType.NOT_FINISHED);

    Collections.sort(keySplits, DatastoreHelper.getKeyComparator());
    return keySplits;
  }

  /**
   * Creates a scatter query from the given user query
   *
   * @param query the user's query.
   * @param numSplits the number of splits to create.
   */
  private Query.Builder createScatterQuery(Query query, int numSplits) {
    // TODO(user): We can potentially support better splits with equality filters in our query
    // if there exists a composite index on property, __scatter__, __key__. Until an API for
    // metadata exists, this isn't possible. Note that ancestor and inequality queries fall into
    // the same category.
    Query.Builder scatterPointQuery = Query.newBuilder();
    scatterPointQuery.addAllKind(query.getKindList());
    scatterPointQuery.addOrder(DatastoreHelper.makeOrder(
        DatastoreHelper.SCATTER_PROPERTY_NAME, Direction.ASCENDING));
    scatterPointQuery.setLimit(numSplits * KEYS_PER_SPLIT - 1);
    scatterPointQuery.addProjection(PropertyExpression.newBuilder().setProperty(
        PropertyReference.newBuilder().setName("__key__")));
    return scatterPointQuery;
  }

  /**
   * Given a list of keys and a number of splits find the keys to split on.
   * @param keys the list of keys.
   * @param numSplits the number of splits.
   */
  private Iterable<Key> getSplitKey(List<Key> keys, int numSplits) {
    // If the number of keys is less than the number of splits, we are limited in the number of
    // splits we can make.
    if (keys.size() < numSplits - 1) {
      return keys;
    }

    // Calculate the number of keys per split. This should be {@link KEYS_PER_SPLIT}, but may
    // be less if there are not KEYS_PER_SPLIT * numSplits scatter properties.
    double numKeysPerSplit = Math.max(1.0, (keys.size() + 1) / numSplits);

    List<Key> keysList = new ArrayList<Key>(numSplits - 1);
    // Grab the last sample for each split, otherwise the first split will be too small.
    for (int i = 1; i < numSplits; i++) {
      int splitIndex = ((int) (i * numKeysPerSplit)) - 1;
      keysList.add(keys.get(splitIndex));
    }

    return keysList;
  }

}
