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

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.gcloud.BaseService;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryParams;
import com.google.gcloud.datastore.spi.DatastoreRpc;
import com.google.protobuf.ByteString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

final class DatastoreImpl extends BaseService<DatastoreOptions> implements Datastore {

  private final DatastoreRpc datastoreRpc;
  private final RetryParams retryParams;

  DatastoreImpl(DatastoreOptions options) {
    super(options);
    this.datastoreRpc = options.rpc();
    retryParams = MoreObjects.firstNonNull(options.retryParams(), RetryParams.noRetries());
  }

  @Override
  public Batch newBatch(BatchOption... options) {
    return new BatchImpl(this, options);
  }

  @Override
  public Transaction newTransaction(TransactionOption... options) {
    return new TransactionImpl(this, options);
  }

  @Override
  public <T> T runInTransaction(TransactionCallable<T> callable, TransactionOption... options) {
    return DatastoreHelper.runInTransaction(this, callable, options);
  }

  @Override
  public <T> QueryResults<T> run(Query<T> query) {
    return run(null, query);
  }

  <T> QueryResults<T> run(DatastoreV1.ReadOptions readOptionsPb, Query<T> query) {
    return new QueryResultsImpl<>(this, readOptionsPb, query);
  }

  DatastoreV1.RunQueryResponse runQuery(final DatastoreV1.RunQueryRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.RunQueryResponse>() {
        @Override public DatastoreV1.RunQueryResponse call() throws DatastoreException {
          return datastoreRpc.runQuery(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }

  @Override
  public Key allocateId(IncompleteKey key) {
    return DatastoreHelper.allocateId(this, key);
  }

  @Override
  public List<Key> allocateId(IncompleteKey... keys) {
    if (keys.length == 0) {
      return Collections.emptyList();
    }
    DatastoreV1.AllocateIdsRequest.Builder requestPb = DatastoreV1.AllocateIdsRequest.newBuilder();
    for (IncompleteKey key : keys) {
      requestPb.addKey(trimNameOrId(key).toPb());
    }
    DatastoreV1.AllocateIdsResponse responsePb = allocateIds(requestPb.build());
    ImmutableList.Builder<Key> keyList = ImmutableList.builder();
    for (DatastoreV1.Key keyPb : responsePb.getKeyList()) {
      keyList.add(Key.fromPb(keyPb));
    }
    return keyList.build();
  }

  DatastoreV1.AllocateIdsResponse allocateIds(final DatastoreV1.AllocateIdsRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.AllocateIdsResponse>() {
        @Override public DatastoreV1.AllocateIdsResponse call() throws DatastoreException {
          return datastoreRpc.allocateIds(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }

  private IncompleteKey trimNameOrId(IncompleteKey key) {
    if (key instanceof Key) {
      return IncompleteKey.builder(key).build();
    }
    return key;
  }

  @Override
  public Entity add(FullEntity<?> entity) {
    return DatastoreHelper.add(this, entity);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Entity> add(FullEntity<?>... entities) {
    if (entities.length == 0) {
      return Collections.emptyList();
    }
    DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
    Map<Key, Entity> completeEntities = new LinkedHashMap<>();
    for (FullEntity<?> entity : entities) {
      Entity completeEntity = null;
      if (entity.key() instanceof Key) {
        completeEntity = Entity.convert((FullEntity<Key>) entity);
      }
      if (completeEntity != null) {
        if (completeEntities.put(completeEntity.key(), completeEntity) != null) {
          throw DatastoreException.throwInvalidRequest(
            "Duplicate entity with the key %s", entity.key());
        }
        mutationPb.addInsert(completeEntity.toPb());
      } else {
        Preconditions.checkArgument(entity.hasKey(), "entity %s is missing a key", entity);
        mutationPb.addInsertAutoId(entity.toPb());
      }
    }
    DatastoreV1.CommitResponse commitResponse = commitMutation(mutationPb);
    Iterator<DatastoreV1.Key> allocatedKeys =
        commitResponse.getMutationResult().getInsertAutoIdKeyList().iterator();
    ImmutableList.Builder<Entity> responseBuilder = ImmutableList.builder();
    for (FullEntity<?> entity : entities) {
      Entity completeEntity = completeEntities.get(entity.key());
      if (completeEntity != null) {
        responseBuilder.add(completeEntity);
      } else {
        responseBuilder.add(Entity.builder(Key.fromPb(allocatedKeys.next()), entity).build());
      }
    }
    return responseBuilder.build();
  }

  @Override
  public Entity get(Key key) {
    return DatastoreHelper.get(this, key);
  }

  @Override
  public Iterator<Entity> get(Key... keys) {
    return get(null, keys);
  }

  @Override
  public List<Entity> fetch(Key... keys) {
    return DatastoreHelper.fetch(this, keys);
  }

  Iterator<Entity> get(DatastoreV1.ReadOptions readOptionsPb, final Key... keys) {
    if (keys.length == 0) {
      return Collections.emptyIterator();
    }
    DatastoreV1.LookupRequest.Builder requestPb = DatastoreV1.LookupRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPb.setReadOptions(readOptionsPb);
    }
    for (Key k : Sets.newLinkedHashSet(Arrays.asList(keys))) {
      requestPb.addKey(k.toPb());
    }
    return new ResultsIterator(requestPb);
  }

  final class ResultsIterator extends AbstractIterator<Entity> {

    private final DatastoreV1.LookupRequest.Builder requestPb;
    Iterator<DatastoreV1.EntityResult> iter;

    ResultsIterator(DatastoreV1.LookupRequest.Builder requestPb) {
      this.requestPb = requestPb;
      loadResults();
    }

    private void loadResults() {
      DatastoreV1.LookupResponse responsePb = lookup(requestPb.build());
      iter = responsePb.getFoundList().iterator();
      requestPb.clearKey();
      if (responsePb.getDeferredCount() > 0) {
        requestPb.addAllKey(responsePb.getDeferredList());
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Entity computeNext() {
      while (!iter.hasNext()) {
        if (requestPb.getKeyCount() == 0) {
          return endOfData();
        }
        loadResults();
      }
      return Entity.fromPb(iter.next().getEntity());
    }
  }

  DatastoreV1.LookupResponse lookup(final DatastoreV1.LookupRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.LookupResponse>() {
        @Override public DatastoreV1.LookupResponse call() throws DatastoreException {
          return datastoreRpc.lookup(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }

  @SafeVarargs
  @Override
  public final void update(Entity... entities) {
    if (entities.length > 0) {
      DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
      Map<Key, Entity> dedupEntities = new LinkedHashMap<>();
      for (Entity entity : entities) {
        dedupEntities.put(entity.key(), entity);
      }
      for (Entity entity : dedupEntities.values()) {
        mutationPb.addUpdate(entity.toPb());
      }
      commitMutation(mutationPb);
    }
  }

  @SafeVarargs
  @Override
  public final void put(Entity... entities) {
    if (entities.length > 0) {
      DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
      Map<Key, Entity> dedupEntities = new LinkedHashMap<>();
      for (Entity entity : entities) {
        dedupEntities.put(entity.key(), entity);
      }
      for (Entity e : dedupEntities.values()) {
        mutationPb.addUpsert(e.toPb());
      }
      commitMutation(mutationPb);
    }
  }

  @Override
  public void delete(Key... keys) {
    if (keys.length > 0) {
      DatastoreV1.Mutation.Builder mutationPb = DatastoreV1.Mutation.newBuilder();
      Set<Key> dedupKeys = new LinkedHashSet<>(Arrays.asList(keys));
      for (Key key : dedupKeys) {
        mutationPb.addDelete(key.toPb());
      }
      commitMutation(mutationPb);
    }
  }

  @Override
  public KeyFactory newKeyFactory() {
    return DatastoreHelper.newKeyFactory(options());
  }

  private DatastoreV1.CommitResponse commitMutation(DatastoreV1.Mutation.Builder mutationPb) {
    if (options().force()) {
      mutationPb.setForce(true);
    }
    DatastoreV1.CommitRequest.Builder requestPb = DatastoreV1.CommitRequest.newBuilder();
    requestPb.setMode(DatastoreV1.CommitRequest.Mode.NON_TRANSACTIONAL);
    requestPb.setMutation(mutationPb);
    return commit(requestPb.build());
  }

  DatastoreV1.CommitResponse commit(final DatastoreV1.CommitRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.CommitResponse>() {
        @Override public DatastoreV1.CommitResponse call() throws DatastoreException {
          return datastoreRpc.commit(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }

  ByteString requestTransactionId(DatastoreV1.BeginTransactionRequest.Builder requestPb) {
    return beginTransaction(requestPb.build()).getTransaction();
  }

  DatastoreV1.BeginTransactionResponse beginTransaction(
      final DatastoreV1.BeginTransactionRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(new Callable<DatastoreV1.BeginTransactionResponse>() {
        @Override
        public DatastoreV1.BeginTransactionResponse call() throws DatastoreException {
          return datastoreRpc.beginTransaction(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }

  void rollbackTransaction(ByteString transaction) {
    DatastoreV1.RollbackRequest.Builder requestPb = DatastoreV1.RollbackRequest.newBuilder();
    requestPb.setTransaction(transaction);
    rollback(requestPb.build());
  }

  void rollback(final DatastoreV1.RollbackRequest requestPb) {
    try {
      RetryHelper.runWithRetries(new Callable<Void>() {
        @Override public Void call() throws DatastoreException {
          datastoreRpc.rollback(requestPb);
          return null;
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }
}
