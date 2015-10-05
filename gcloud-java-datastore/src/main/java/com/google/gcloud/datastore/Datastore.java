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
 * An interface for Google Cloud Datastore.
 */
public interface Datastore extends Service<DatastoreOptions>, DatastoreReaderWriter {

  /**
   * Returns a new Datastore transaction.
   *
   * @throws DatastoreException upon failure
   */
  Transaction newTransaction();


  /**
   * A callback for running with a transactional
   * {@link com.google.gcloud.datastore.DatastoreReaderWriter}.
   * The associated transaction will be committed after a successful return from the {@code run}
   * method. Any propagated exception will cause the transaction to be rolled-back.
   *
   * @param <T> the type of the return value
   */
  interface TransactionCallable<T> {
    T run(DatastoreReaderWriter readerWriter) throws Exception;
  }


  /**
   * Invokes the callback's {@link Datastore.TransactionCallable#run} method with a
   * {@link DatastoreReaderWriter} that is associated with a new transaction.
   * The transaction will be committed upon successful invocation.
   * Any thrown exception will cause the transaction to rollback and will be propagated
   * as a {@link DatastoreException} with the original exception as its root cause.
   *
   * @param callable the callback to call with a newly created transactional readerWriter
   * @throws DatastoreException upon failure
   */
  <T> T runInTransaction(TransactionCallable<T> callable);

  /**
   * Returns a new Batch for processing multiple write operations in one request.
   */
  Batch newBatch();

  /**
   * Allocate a unique id for the given key.
   * The returned key will have the same information (projectId, kind, namespace and ancestors)
   * as the given key and will have a newly assigned id.
   *
   * @throws DatastoreException upon failure
   */
  Key allocateId(IncompleteKey key);

  /**
   * Returns a list of keys using the allocated ids ordered by the input.
   *
   * @throws DatastoreException upon failure
   * @see #allocateId(IncompleteKey)
   */
  List<Key> allocateId(IncompleteKey... key);

  /**
   * {@inheritDoc}
   * @throws DatastoreException upon failure
   */
  @Override
  void update(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreException upon failure
   */
  @Override
  void put(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreException upon failure
   */
  @Override
  void delete(Key... key);

  /**
   * Returns a new KeyFactory for this service
   */
  KeyFactory newKeyFactory();
}
