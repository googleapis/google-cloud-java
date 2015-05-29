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

import java.util.Iterator;
import java.util.List;

/**
 * A Google cloud datastore transaction.
 * Similar to {@link Batch} any write operation that is applied on a transaction will only be sent
 * to the Datastore upon {@link #commit}. A call to {@link #rollback} will invalidate
 * the transaction and discard the changes. Any read operation that is done by a transaction
 * will be part of it and therefore a {@code commit} is guaranteed to fail if an entity
 * was modified outside of the transaction after it was read. Write operation on this
 * transaction will not be reflected by read operation (as the changes are only sent to
 * the Datastore upon {@code commit}.
 * A usage example:
 * <pre> {@code
 *   Transaction transaction = datastore.newTransaction();
 *   try {
 *     Entity entity = transaction.get(key);
 *     if (!entity.contains("last_name") || entity.isNull("last_name")) {
 *       String[] name = entity.getString("name").split(" ");
 *       entity = Entity.builder(entity).remove("name").set("first_name", name[0])
 *           .set("last_name", name[1]).build();
 *       transaction.update(entity);
 *       transaction.commit();
 *     }
 *   } finally {
 *     if (transaction.active()) {
 *       transaction.rollback();
 *     }
 *   }
 * } </pre>
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/transactions">Google Cloud Datastore transactions</a>
 *
 */
public interface Transaction extends DatastoreBatchWriter, DatastoreReaderWriter {

  interface Response {
    List<Key> generatedKeys();
  }

  /**
   * {@inheritDoc}
   * The requested entity will be part of this Datastore transaction (so a commit is guaranteed
   * to fail if entity was changed by others after it was seen by this transaction) but any
   * write changes in this transaction will not be reflected by the returned entity.
   *
   * @throws DatastoreException upon failure or if no longer active
   */
  @Override
  Entity get(Key key);

  /**
   * {@inheritDoc}
   * The requested entities will be part of this Datastore transaction (so a commit is guaranteed
   * to fail if any of the entities was changed by others after they were seen by this transaction)
   * but any write changes in this transaction will not be reflected by the returned entities.
   *
   * @throws DatastoreException upon failure or if no longer active
   */
  @Override
  Iterator<Entity> get(Key... key);

  /**
   * {@inheritDoc}
   * The requested entities will be part of this Datastore transaction (so a commit is guaranteed
   * to fail if any of the entities was changed by others after they were seen by this transaction)
   * but any write changes in this transaction will not be reflected by the returned entities.
   *
   * @throws DatastoreException upon failure or if no longer active
   */
  @Override
  List<Entity> fetch(Key... keys);

  /**
   * {@inheritDoc}
   * The entities returned by the result of this query will be part of this Datastore transaction
   * (so a commit is guaranteed to fail if any of the entities was changed by others after the
   * query was performed) but any write changes in this transaction will not be reflected by
   * the result.
   *
   * @throws DatastoreException upon failure or if no longer active
   */
  @Override
  <T> QueryResults<T> run(Query<T> query);

  /**
   * Commit the transaction.
   *
   * @throws DatastoreException if could not commit the transaction or if no longer active
   */
  Response commit();

  /**
   * Rollback the transaction.
   *
   * @throws DatastoreException if transaction was already committed
   */
  void rollback();

  /**
   * Returns {@code true} if the transaction is still active (was not committed or rolledback).
   */
  @Override
  boolean active();

  /**
   * Returns the transaction associated {@link Datastore}.
   */
  Datastore datastore();
}
