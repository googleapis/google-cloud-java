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
import com.google.cloud.Service;
import com.google.datastore.v1.TransactionOptions;
import java.util.Iterator;
import java.util.List;

/** An interface for Google Cloud Datastore. */
public interface Datastore extends Service<DatastoreOptions>, DatastoreReaderWriter {

  /**
   * Returns a new Datastore transaction.
   *
   * @param options a transaction option indicating the mode of the transaction (read-only or
   *     read-write)
   * @throws DatastoreException upon failure
   */
  Transaction newTransaction(TransactionOptions options);

  /**
   * Returns a new Datastore transaction.
   *
   * @throws DatastoreException upon failure
   */
  Transaction newTransaction();

  /**
   * A callback for running with a transactional {@link
   * com.google.cloud.datastore.DatastoreReaderWriter}. The associated transaction will be committed
   * after a successful return from the {@code run} method. Any propagated exception will cause the
   * transaction to be rolled-back.
   *
   * @param <T> the type of the return value
   */
  interface TransactionCallable<T> {
    T run(DatastoreReaderWriter readerWriter) throws Exception;
  }

  /**
   * Invokes the callback's {@link Datastore.TransactionCallable#run} method with a {@link
   * DatastoreReaderWriter} that is associated with a new transaction. The transaction will be
   * committed upon successful invocation. Any thrown exception will cause the transaction to
   * rollback and will be propagated as a {@link DatastoreException} with the original exception as
   * its root cause.
   *
   * <p>Example of running in a transaction.
   *
   * <pre>{@code
   * String callableResult = "my_callable_result";
   * TransactionCallable<String> callable = new TransactionCallable<String>() {
   *   public String run(DatastoreReaderWriter readerWriter) {
   *     // use readerWriter to run in transaction
   *     return callableResult;
   *   }
   * };
   * String result = datastore.runInTransaction(callable);
   * }</pre>
   *
   * @param callable the callback to call with a newly created transactional readerWriter
   * @throws DatastoreException upon failure
   */
  <T> T runInTransaction(TransactionCallable<T> callable);

  /**
   * Invokes the callback's {@link Datastore.TransactionCallable#run} method with a {@link
   * DatastoreReaderWriter} that is associated with a new transaction. The transaction will be
   * committed upon successful invocation. Any thrown exception will cause the transaction to
   * rollback and will be propagated as a {@link DatastoreException} with the original exception as
   * its root cause. If {@link TransactionOptions} is set to read-write mode, previous transaction
   * Id in the options will be automatically populated each time a transaction is retried.
   *
   * <p>Example of running in a transaction.
   *
   * <pre>{@code
   * String callableResult = "my_callable_result";
   * TransactionCallable<String> callable = new TransactionCallable<String>() {
   *   public String run(DatastoreReaderWriter readerWriter) {
   *     // use readerWriter to run in transaction
   *     return callableResult;
   *   }
   * };
   *
   * TransactionOptions options = TransactionOptions.newBuilder()
   *     .setReadWrite(TransactionOptions.ReadWrite
   *         .getDefaultInstance())
   *     .build();
   *
   * String result = datastore.runInTransaction(callable, options);
   * }</pre>
   *
   * @param callable the callback to call with a newly created transactional readerWriter
   * @param options the Transaction options indicating whether the transaction mode is Read-only or
   *     Read-Write
   * @throws DatastoreException upon failure
   */
  <T> T runInTransaction(TransactionCallable<T> callable, TransactionOptions options);

  /**
   * Returns a new Batch for processing multiple write operations in one request.
   *
   * <p>Example of starting a new batch.
   *
   * <pre>{@code
   * String keyName1 = "my_key_name_1";
   * String keyName2 = "my_key_name_2";
   * Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
   * Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
   * Batch batch = datastore.newBatch();
   * Entity entity1 = Entity.newBuilder(key1).set("name", "John").build();
   * Entity entity2 = Entity.newBuilder(key2).set("title", "title").build();
   * batch.add(entity1);
   * batch.add(entity2);
   * batch.submit();
   * }</pre>
   */
  Batch newBatch();

  /**
   * Allocate a unique id for the given key. The returned key will have the same information
   * (projectId, kind, namespace and ancestors) as the given key and will have a newly assigned id.
   *
   * <p>Example of allocating an id.
   *
   * <pre>{@code
   * KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
   * IncompleteKey incompleteKey = keyFactory.newKey();
   *
   * // let cloud datastore automatically assign an id
   * Key key = datastore.allocateId(incompleteKey);
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  Key allocateId(IncompleteKey key);

  /**
   * Returns a list of keys using the allocated ids ordered by the input.
   *
   * <p>Example of allocating multiple ids in a single batch.
   *
   * <pre>{@code
   * KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
   * IncompleteKey incompleteKey1 = keyFactory.newKey();
   * IncompleteKey incompleteKey2 = keyFactory.newKey();
   *
   * // let cloud datastore automatically assign the ids
   * List<Key> keys = datastore.allocateId(incompleteKey1, incompleteKey2);
   * }</pre>
   *
   * @throws DatastoreException upon failure
   * @see #allocateId(IncompleteKey)
   */
  List<Key> allocateId(IncompleteKey... keys);

  /**
   * Reserve one or more keys, preventing them from being automatically allocated by Datastore.
   *
   * <p>Example of reserving multiple ids in a single batch.
   *
   * <pre>{@code
   * KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
   * Key key1 = keyFactory.newKey(10);
   * Key key2 = keyFactory.newKey("name");
   * List<Key> keys = datastore.reserveIds(key1, key2);
   *
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  List<Key> reserveIds(Key... keys);

  /**
   * {@inheritDoc}
   *
   * <p>If an entity for {@code entity.getKey()} does not exist, {@code entity} is inserted.
   * Otherwise, a {@link DatastoreException} is thrown with {@link DatastoreException#getReason()}
   * equal to {@code "ALREADY_EXISTS"}.
   *
   * <p>Example of adding a single entity.
   *
   * <pre>{@code
   * String keyName = "my_key_name";
   * Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
   * Entity.Builder entityBuilder = Entity.newBuilder(key);
   * entityBuilder.set("propertyName", "value");
   * Entity entity = entityBuilder.build();
   * try {
   *   datastore.add(entity);
   * } catch (DatastoreException ex) {
   *   if ("ALREADY_EXISTS".equals(ex.getReason())) {
   *     // entity.getKey() already exists
   *   }
   * }
   * }</pre>
   *
   * @throws DatastoreException upon failure or if an entity for {@code entity.getKey()} already
   *     exists
   */
  @Override
  Entity add(FullEntity<?> entity);

  /**
   * {@inheritDoc}
   *
   * <p>If none of entities' keys exist, all entities are inserted. If any of entities' keys already
   * exists the method throws a {@link DatastoreException} with {@link
   * DatastoreException#getReason()} equal to {@code "ALREADY_EXISTS"}. All entities in {@code
   * entities} whose key did not exist are inserted. To achieve a transactional behavior, use {@link
   * Transaction}.
   *
   * <p>Example of adding multiple entities.
   *
   * <pre>{@code
   * String keyName1 = "my_key_name1";
   * String keyName2 = "my_key_name2";
   * Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
   * Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
   * entityBuilder1.set("propertyName", "value1");
   * Entity entity1 = entityBuilder1.build();
   *
   * Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
   * Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
   * entityBuilder2.set("propertyName", "value2");
   * Entity entity2 = entityBuilder2.build();
   *
   * try {
   *   datastore.add(entity1, entity2);
   * } catch (DatastoreException ex) {
   *   if ("ALREADY_EXISTS".equals(ex.getReason())) {
   *     // at least one of entity1.getKey() and entity2.getKey() already exists
   *   }
   * }
   * }</pre>
   *
   * @throws DatastoreException upon failure or if any of entities' keys already exists
   */
  @Override
  List<Entity> add(FullEntity<?>... entities);

  /**
   * {@inheritDoc}
   *
   * <p>Example of updating multiple entities.
   *
   * <pre>{@code
   * String keyName1 = "my_key_name_1";
   * String keyName2 = "my_key_name_2";
   * Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
   * Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
   * entityBuilder1.set("propertyName", "updatedValue1");
   * Entity entity1 = entityBuilder1.build();
   *
   * Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
   * Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
   * entityBuilder2.set("propertyName", "updatedValue2");
   * Entity entity2 = entityBuilder2.build();
   *
   * datastore.update(entity1, entity2);
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  @Override
  void update(Entity... entities);

  /**
   * {@inheritDoc}
   *
   * <p>Example of putting a single entity.
   *
   * <pre>{@code
   * String keyName = "my_key_name";
   * Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
   * Entity.Builder entityBuilder = Entity.newBuilder(key);
   * entityBuilder.set("propertyName", "value");
   * Entity entity = entityBuilder.build();
   * datastore.put(entity);
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  @Override
  Entity put(FullEntity<?> entity);

  /**
   * {@inheritDoc}
   *
   * <p>Example of putting multiple entities.
   *
   * <pre>{@code
   * String keyName1 = "my_key_name1";
   * String keyName2 = "my_key_name2";
   * Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
   * Entity.Builder entityBuilder1 = Entity.newBuilder(key1);
   * entityBuilder1.set("propertyName", "value1");
   * Entity entity1 = entityBuilder1.build();
   *
   * Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
   * Entity.Builder entityBuilder2 = Entity.newBuilder(key2);
   * entityBuilder2.set("propertyName", "value2");
   * Entity entity2 = entityBuilder2.build();
   *
   * datastore.put(entity1, entity2);
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  @Override
  List<Entity> put(FullEntity<?>... entities);

  /**
   * {@inheritDoc}
   *
   * <p>Example of deleting multiple entities.
   *
   * <pre>{@code
   * String keyName1 = "my_key_name1";
   * String keyName2 = "my_key_name2";
   * Key key1 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName1);
   * Key key2 = datastore.newKeyFactory().setKind("MyKind").newKey(keyName2);
   * datastore.delete(key1, key2);
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  @Override
  void delete(Key... keys);

  /**
   * Returns a new KeyFactory for this service
   *
   * <p>Example of creating a {@code KeyFactory}.
   *
   * <pre>{@code
   * KeyFactory keyFactory = datastore.newKeyFactory();
   * }</pre>
   */
  KeyFactory newKeyFactory();

  /**
   * Returns an {@link Entity} for the given {@link Key} or {@code null} if it doesn't exist. {@link
   * ReadOption}s can be specified if desired.
   *
   * <p>Example of getting an entity.
   *
   * <pre>{@code
   * String keyName = "my_key_name";
   * Key key = datastore.newKeyFactory().setKind("MyKind").newKey(keyName);
   * Entity entity = datastore.get(key);
   * // Do something with the entity
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  Entity get(Key key, ReadOption... options);

  /**
   * Returns an {@link Entity} for each given {@link Key} that exists in the Datastore. The order of
   * the result is unspecified. Results are loaded lazily, so it is possible to get a {@code
   * DatastoreException} from the returned {@code Iterator}'s {@link Iterator#hasNext hasNext} or
   * {@link Iterator#next next} methods. {@link ReadOption}s can be specified if desired.
   *
   * <p>Example of getting multiple entity objects.
   *
   * <pre>{@code
   * String firstKeyName = "my_first_key_name";
   * String secondKeyName = "my_second_key_name";
   * KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
   * Key firstKey = keyFactory.newKey(firstKeyName);
   * Key secondKey = keyFactory.newKey(secondKeyName);
   * Iterator<Entity> entitiesIterator = datastore.get(Lists.newArrayList(firstKey, secondKey));
   * List<Entity> entities = Lists.newArrayList();
   * while (entitiesIterator.hasNext()) {
   *   Entity entity = entitiesIterator.next();
   *   // do something with the entity
   *   entities.add(entity);
   * }
   * }</pre>
   *
   * @throws DatastoreException upon failure
   * @see #get(Key)
   */
  Iterator<Entity> get(Iterable<Key> keys, ReadOption... options);

  /**
   * Returns a list with a value for each given key (ordered by input). {@code null} values are
   * returned for nonexistent keys. When possible prefer using {@link #get(Key...)} to avoid eagerly
   * loading the results. {@link ReadOption}s can be specified if desired.
   *
   * <p>Example of fetching a list of Entity objects.
   *
   * <pre>{@code
   * String firstKeyName = "my_first_key_name";
   * String secondKeyName = "my_second_key_name";
   * KeyFactory keyFactory = datastore.newKeyFactory().setKind("MyKind");
   * Key firstKey = keyFactory.newKey(firstKeyName);
   * Key secondKey = keyFactory.newKey(secondKeyName);
   * List<Entity> entities = datastore.fetch(Lists.newArrayList(firstKey, secondKey));
   * for (Entity entity : entities) {
   *   // do something with the entity
   * }
   * }</pre>
   */
  List<Entity> fetch(Iterable<Key> keys, ReadOption... options);

  /**
   * Submits a {@link Query} and returns its result. {@link ReadOption}s can be specified if
   * desired.
   *
   * <p>Example of running a query to find all entities of one kind.
   *
   * <pre>{@code
   * String kind = "my_kind";
   * StructuredQuery<Entity> query = Query.newEntityQueryBuilder()
   *     .setKind(kind)
   *     .build();
   * QueryResults<Entity> results = datastore.run(query);
   * List<Entity> entities = Lists.newArrayList();
   * while (results.hasNext()) {
   *   Entity result = results.next();
   *   // do something with result
   *   entities.add(result);
   * }
   * }</pre>
   *
   * <p>Example of running a query to find all entities with a matching property value.
   *
   * <pre>{@code
   * String kind = "my_kind";
   * String property = "my_property";
   * String value = "my_value";
   * StructuredQuery<Entity> query = Query.newEntityQueryBuilder()
   *     .setKind(kind)
   *     .setFilter(PropertyFilter.eq(property, value))
   *     .build();
   * QueryResults<Entity> results = datastore.run(query);
   * List<Entity> entities = Lists.newArrayList();
   * while (results.hasNext()) {
   *   Entity result = results.next();
   *   // do something with result
   *   entities.add(result);
   * }
   * }</pre>
   *
   * @throws DatastoreException upon failure
   */
  <T> QueryResults<T> run(Query<T> query, ReadOption... options);

  /**
   * Submits a {@link AggregationQuery} and returns {@link AggregationResults}. {@link ReadOption}s
   * can be specified if desired.
   *
   * <p>Example of running an {@link AggregationQuery} to find the count of entities of one kind.
   *
   * <p>{@link StructuredQuery} example:
   *
   * <pre>{@code
   * EntityQuery selectAllQuery = Query.newEntityQueryBuilder()
   *    .setKind("Task")
   *    .build();
   * AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
   *    .addAggregation(count().as("total_count"))
   *    .over(selectAllQuery)
   *    .build();
   * AggregationResults aggregationResults = datastore.runAggregation(aggregationQuery);
   * for (AggregationResult aggregationResult : aggregationResults) {
   *     System.out.println(aggregationResult.get("total_count"));
   * }
   * }</pre>
   *
   * <h4>{@link GqlQuery} example:</h4>
   *
   * <pre>{@code
   * GqlQuery<?> selectAllGqlQuery = Query.newGqlQueryBuilder(
   *         "AGGREGATE COUNT(*) AS total_count, COUNT_UP_TO(100) AS count_upto_100 OVER(SELECT * FROM Task)"
   *     )
   *     .setAllowLiteral(true)
   *     .build();
   * AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
   *     .over(selectAllGqlQuery)
   *     .build();
   * AggregationResults aggregationResults = datastore.runAggregation(aggregationQuery);
   * for (AggregationResult aggregationResult : aggregationResults) {
   *   System.out.println(aggregationResult.get("total_count"));
   *   System.out.println(aggregationResult.get("count_upto_100"));
   * }
   * }</pre>
   *
   * @throws DatastoreException upon failure
   * @return {@link AggregationResults}
   */
  @BetaApi
  default AggregationResults runAggregation(AggregationQuery query, ReadOption... options) {
    throw new UnsupportedOperationException("Not implemented.");
  }
}
