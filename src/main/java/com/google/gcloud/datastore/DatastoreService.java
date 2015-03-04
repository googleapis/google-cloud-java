/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import com.google.gcloud.Service;

import java.util.List;

/**
 * An interface for Google Cloud Datastore dataset.
 */
public interface DatastoreService extends Service<DatastoreServiceOptions>, DatastoreReaderWriter {

  /**
   * Returns a new Datastore transaction.
   *
   * @throws DatastoreServiceException upon failure
   */
  Transaction newTransaction(TransactionOption... options);

  interface RunInTransaction {
    void run(DatastoreReaderWriter readerWriter);
  }


  /**
   * Invokes the callback's {@link RunInTransaction#run} method with a
   * {@link DatastoreReaderWriter} that is associated with a new transaction.
   * The transaction will be committed upon successful invocation or rollback
   * otherwise.
   *
   * @param runFor the functor to call with the transactional readerWriter
   * @param options the options for the created transaction
   */
  void runInTransaction(RunInTransaction runFor, TransactionOption... options);

  /**
   * Returns a new Batch for processing multiple write operations in one request.
   */
  Batch newBatch(BatchOption... options);

  /**
   * Allocate a unique id for the given key.
   * The returned key will have the same information (dataset, kind, namespace and ancestors)
   * as the given key and will have a newly assigned id.
   *
   * @throws DatastoreServiceException upon failure
   */
  Key allocateId(PartialKey key);

  /**
   * Returns a list of keys using the allocated ids ordered by the input.
   *
   * @throws DatastoreServiceException upon failure
   * @see #allocateId(PartialKey)
   */
  List<Key> allocateId(PartialKey... key);

  /**
   * Datastore add operation.
   * This method will automatically allocate an id if necessary.
   *
   * @param entity the entity to add
   * @return an {@code Entity} with the same properties and a key that is either newly allocated
   *     or the same one if was already complete
   * @throws DatastoreServiceException upon failure
   * @throws IllegalArgumentException if the given entity is missing a key
   */
  Entity add(PartialEntity entity);

  /**
   * Datastore add operation.
   * This method will automatically allocate id for any entity with incomplete key.
   *
   * @return a list of {@code Entity} ordered by input with the same properties and a key that is
   *     either newly allocated or the same one if was already complete
   * @throws DatastoreServiceException upon failure
   * @throws IllegalArgumentException if any of the given entities is missing a key
   * @see #add(PartialEntity)
   */
  List<Entity> add(PartialEntity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void add(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void update(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void put(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void delete(Key... key);

  /**
   * Returns a new KeyFactory for this service
   */
  KeyFactory newKeyFactory();
}
