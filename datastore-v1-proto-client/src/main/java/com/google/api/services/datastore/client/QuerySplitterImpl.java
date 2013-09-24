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

import static com.google.api.services.datastore.client.DatastoreHelper.makeFilter;

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
import java.util.EnumSet;
import java.util.List;

/**
 * Provides the ability to split a query into multiple shards using Cloud Datastore.
 *
 * <p>This implementation of the QuerySplitter uses the __scatter__ property to gather
 * random split points for a query.
 *
 **/
final class QuerySplitterImpl implements QuerySplitter {

  /** The number of keys to sample for each split. **/
  private static final int KEYS_PER_SPLIT = 32;

  private static final EnumSet<Operator> UNSUPPORTED_OPERATORS = EnumSet.of(Operator.LESS_THAN,
      Operator.LESS_THAN_OR_EQUAL, Operator.GREATER_THAN, Operator.GREATER_THAN_OR_EQUAL);

  static final QuerySplitter INSTANCE = new QuerySplitterImpl();

  private QuerySplitterImpl() {
    // No initialization required.
  }

  @Override
  public List<Query> getSplits(Query query, int numSplits, Datastore datastore)
      throws DatastoreException, IllegalArgumentException {

    validateQuery(query);
    validateSplitSize(numSplits);

    List<Query> splits = new ArrayList<Query>(numSplits);
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
   * Validates that we only have allowable filters.
   *
   * <p>Note that equality and ancestor filters are allowed, however they may result in
   * inefficient sharding.
   */
  private void validateFilter(Filter filter) throws IllegalArgumentException {
    if (filter.hasCompositeFilter()) {
      for (Filter subFilter : filter.getCompositeFilter().getFilterList()) {
        validateFilter(subFilter);
      }
    } else if (filter.hasPropertyFilter()) {
      if (UNSUPPORTED_OPERATORS.contains(filter.getPropertyFilter().getOperator())) {
        throw new IllegalArgumentException("Query cannot have any inequality filters.");
      }
    }
  }

  /**
   * Verifies that the given query can be properly scattered.
   *
   * @param query the query to verify
   * @throws IllegalArgumentException if the query is invalid.
   */
  private void validateQuery(Query query) throws IllegalArgumentException {
    if (query.getKindCount() != 1) {
      throw new IllegalArgumentException("Query must have exactly one kind.");
    }
    if (query.getOrderCount() != 0) {
      throw new IllegalArgumentException("Query cannot have any sort orders.");
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
      Filter lowerBound = DatastoreHelper.makeFilter(DatastoreHelper.KEY_PROPERTY_NAME,
          PropertyFilter.Operator.GREATER_THAN_OR_EQUAL,
          DatastoreHelper.makeValue(lastKey)).build();
      keyFilters.add(lowerBound);
    }
    if (nextKey != null) {
      Filter upperBound = DatastoreHelper.makeFilter(DatastoreHelper.KEY_PROPERTY_NAME,
          PropertyFilter.Operator.LESS_THAN,
          DatastoreHelper.makeValue(nextKey)).build();
      keyFilters.add(upperBound);
    }
    return Query.newBuilder(query).setFilter(makeFilter(keyFilters)).build();
  }

  /**
   * Gets a list of split keys given a desired number of splits.
   *
   * <p>This list will contain multiple split keys for each split. Only a single split key
   * will be chosen as the split point, however providing multiple keys allows for more uniform
   * sharding.
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

    QueryResultBatch batch;
    do {
      RunQueryRequest scatterRequest = RunQueryRequest.newBuilder()
          .setQuery(scatterPointQuery).build();
      batch = datastore.runQuery(scatterRequest).getBatch();
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
    // There is a split containing entities before and after each scatter entity:
    // ||---*------*------*------*------*------*------*---||  = scatter entity
    // If we represent each split as a region before a scatter entity, there is an extra region
    // following the last scatter point. Thus, we do not need the scatter entities for the last
    // region.
    scatterPointQuery.setLimit((numSplits - 1) * KEYS_PER_SPLIT);
    scatterPointQuery.addProjection(PropertyExpression.newBuilder().setProperty(
        PropertyReference.newBuilder().setName("__key__")));
    return scatterPointQuery;
  }

  /**
   * Given a list of keys and a number of splits find the keys to split on.
   *
   * @param keys the list of keys.
   * @param numSplits the number of splits.
   */
  private Iterable<Key> getSplitKey(List<Key> keys, int numSplits) {
    // If the number of keys is less than the number of splits, we are limited in the number of
    // splits we can make.
    if (keys.size() < numSplits - 1) {
      return keys;
    }

    // Calculate the number of keys per split. This should be KEYS_PER_SPLIT, but may
    // be less if there are not KEYS_PER_SPLIT * (numSplits - 1) scatter entities.
    //
    // Consider the following dataset, where - represents an entity and * represents an entity
    // that is returned as a scatter entity:
    // ||---*-----*----*-----*-----*------*----*----||
    // If we want 4 splits in this data, the optimal split would look like:
    // ||---*-----*----*-----*-----*------*----*----||
    //            |          |            |
    // The scatter keys in the last region are not useful to us, so we never request them:
    // ||---*-----*----*-----*-----*------*---------||
    //            |          |            |
    // With 6 scatter keys we want to set scatter points at indexes: 1, 3, 5.
    //
    // We keep this as a double so that any "fractional" keys per split get distributed throughout
    // the splits and don't make the last split significantly larger than the rest.
    double numKeysPerSplit = Math.max(1.0, ((double) keys.size()) / (numSplits - 1));

    List<Key> keysList = new ArrayList<Key>(numSplits - 1);
    // Grab the last sample for each split, otherwise the first split will be too small.
    for (int i = 1; i < numSplits; i++) {
      int splitIndex = (int) Math.round(i * numKeysPerSplit) - 1;
      keysList.add(keys.get(splitIndex));
    }

    return keysList;
  }

}
