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

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.gcloud.BaseService;
import com.google.gcloud.ExceptionHandler;
import com.google.gcloud.ExceptionHandler.Interceptor;
import com.google.gcloud.RetryHelper;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryParams;
import com.google.gcloud.spi.DatastoreRpc;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException;
import com.google.protobuf.ByteString;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;


final class DatastoreImpl extends BaseService<DatastoreOptions>
    implements Datastore {

  private static final Interceptor EXCEPTION_HANDLER_INTERCEPTOR =
      new Interceptor() {

        private static final long serialVersionUID = 6911242958397733203L;

        @Override
        public RetryResult afterEval(Exception exception, RetryResult retryResult) {
          return null;
        }

        @Override
        public RetryResult beforeEval(Exception exception) {
          if (exception instanceof DatastoreRpcException) {
            boolean retryable = ((DatastoreRpcException) exception).retryable();
            return retryable ? Interceptor.RetryResult.RETRY : Interceptor.RetryResult.ABORT;
          }
          return null;
        }
      };
  private static final ExceptionHandler EXCEPTION_HANDLER = ExceptionHandler.builder()
      .abortOn(RuntimeException.class, DatastoreRpcException.class)
      .interceptor(EXCEPTION_HANDLER_INTERCEPTOR).build();

  private final DatastoreRpc datastoreRpc;
  private final RetryParams retryParams;

  DatastoreImpl(DatastoreOptions options) {
    super(options);
    this.datastoreRpc = options.datastoreRpc();
    retryParams = MoreObjects.firstNonNull(options.retryParams(), RetryParams.noRetries());
  }

  @Override
  public Batch newBatch() {
    return new BatchImpl(this);
  }

  @Override
  public Transaction newTransaction() {
    return new TransactionImpl(this);
  }

  @Override
  public <T> T runInTransaction(TransactionCallable<T> callable) {
    return DatastoreHelper.runInTransaction(this, callable);
  }

  @Override
  public <T> QueryResults<T> run(Query<T> query) {
    return run(null, query);
  }

  <T> QueryResults<T> run(com.google.datastore.v1beta3.ReadOptions readOptionsPb, Query<T> query) {
    // TODO(ajaykannan): fix me!
    //return new QueryResultsImpl<>(this, readOptionsPb, query);
    return null; // TODO(ajaykannan): fix me!
  }

  com.google.datastore.v1beta3.RunQueryResponse runQuery(
      final com.google.datastore.v1beta3.RunQueryRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(
          new Callable<com.google.datastore.v1beta3.RunQueryResponse>() {
        @Override public com.google.datastore.v1beta3.RunQueryResponse call()
            throws DatastoreRpcException {
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
    com.google.datastore.v1beta3.AllocateIdsRequest.Builder requestPb = 
        com.google.datastore.v1beta3.AllocateIdsRequest.newBuilder();
    for (IncompleteKey key : keys) {
      requestPb.addKeys(trimNameOrId(key).toPb());
    }
    com.google.datastore.v1beta3.AllocateIdsResponse responsePb = allocateIds(requestPb.build());
    ImmutableList.Builder<Key> keyList = ImmutableList.builder();
    for (com.google.datastore.v1beta3.Key keyPb : responsePb.getKeysList()) {
      keyList.add(Key.fromPb(keyPb));
    }
    return keyList.build();
  }

  com.google.datastore.v1beta3.AllocateIdsResponse allocateIds(
      final com.google.datastore.v1beta3.AllocateIdsRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(
          new Callable<com.google.datastore.v1beta3.AllocateIdsResponse>() {
        @Override public com.google.datastore.v1beta3.AllocateIdsResponse call()
            throws DatastoreRpcException {
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
    List<com.google.datastore.v1beta3.Mutation> mutationsPb = new ArrayList<>();
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
      } else {
        Preconditions.checkArgument(entity.hasKey(), "entity %s is missing a key", entity);
      }
      mutationsPb.add(com.google.datastore.v1beta3.Mutation.newBuilder()
          .setInsert(entity.toPb()).build());
    }
    com.google.datastore.v1beta3.CommitResponse commitResponse = commitMutation(mutationsPb);
    Iterator<com.google.datastore.v1beta3.MutationResult> mutationResults =
        commitResponse.getMutationResultsList().iterator();
    ImmutableList.Builder<Entity> responseBuilder = ImmutableList.builder();
    for (FullEntity<?> entity : entities) {
      Entity completeEntity = completeEntities.get(entity.key());
      if (completeEntity != null) {
        responseBuilder.add(completeEntity);
        mutationResults.next();
      } else {
        responseBuilder.add(
            Entity.builder(Key.fromPb(mutationResults.next().getKey()), entity).build());
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

  Iterator<Entity> get(com.google.datastore.v1beta3.ReadOptions readOptionsPb, final Key... keys) {
    if (keys.length == 0) {
      return Collections.emptyIterator();
    }
    com.google.datastore.v1beta3.LookupRequest.Builder requestPb = 
        com.google.datastore.v1beta3.LookupRequest.newBuilder();
    if (readOptionsPb != null) {
      requestPb.setReadOptions(readOptionsPb);
    }
    for (Key k : Sets.newLinkedHashSet(Arrays.asList(keys))) {
      requestPb.addKeys(k.toPb());
    }
    return new ResultsIterator(requestPb);
  }

  final class ResultsIterator extends AbstractIterator<Entity> {

    private final com.google.datastore.v1beta3.LookupRequest.Builder requestPb;
    Iterator<com.google.datastore.v1beta3.EntityResult> iter;

    ResultsIterator(com.google.datastore.v1beta3.LookupRequest.Builder requestPb) {
      this.requestPb = requestPb;
      loadResults();
    }

    private void loadResults() {
      com.google.datastore.v1beta3.LookupResponse responsePb = lookup(requestPb.build());
      iter = responsePb.getFoundList().iterator();
      requestPb.clearKeys();
      if (responsePb.getDeferredCount() > 0) {
        requestPb.addAllKeys(responsePb.getDeferredList());
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Entity computeNext() {
      while (!iter.hasNext()) {
        if (requestPb.getKeysCount() == 0) {
          return endOfData();
        }
        loadResults();
      }
      return Entity.fromPb(iter.next().getEntity());
    }
  }

  com.google.datastore.v1beta3.LookupResponse lookup(
      final com.google.datastore.v1beta3.LookupRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(
          new Callable<com.google.datastore.v1beta3.LookupResponse>() {
        @Override public com.google.datastore.v1beta3.LookupResponse call()
            throws DatastoreRpcException {
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
      List<com.google.datastore.v1beta3.Mutation> mutationsPb = 
          new ArrayList<>();
      Map<Key, Entity> dedupEntities = new LinkedHashMap<>();
      for (Entity entity : entities) {
        dedupEntities.put(entity.key(), entity);
      }
      for (Entity entity : dedupEntities.values()) {
        mutationsPb.add(
            com.google.datastore.v1beta3.Mutation.newBuilder().setUpdate(entity.toPb()).build());
      }
      commitMutation(mutationsPb);
    }
  }

  @SafeVarargs
  @Override
  public final void put(Entity... entities) {
    if (entities.length > 0) {
      List<com.google.datastore.v1beta3.Mutation> mutationsPb = 
          new ArrayList<>();
      Map<Key, Entity> dedupEntities = new LinkedHashMap<>();
      for (Entity entity : entities) {
        dedupEntities.put(entity.key(), entity);
      }
      for (Entity e : dedupEntities.values()) {
        mutationsPb.add(
            com.google.datastore.v1beta3.Mutation.newBuilder().setUpsert(e.toPb()).build());
      }
      commitMutation(mutationsPb);
    }
  }

  @Override
  public void delete(Key... keys) {
    if (keys.length > 0) {
      List<com.google.datastore.v1beta3.Mutation> mutationsPb = new ArrayList<>();
      Set<Key> dedupKeys = new LinkedHashSet<>(Arrays.asList(keys));
      for (Key key : dedupKeys) {
        mutationsPb.add(
            com.google.datastore.v1beta3.Mutation.newBuilder().setDelete(key.toPb()).build());
      }
      commitMutation(mutationsPb);
    }
  }

  @Override
  public KeyFactory newKeyFactory() {
    return DatastoreHelper.newKeyFactory(options());
  }

  private com.google.datastore.v1beta3.CommitResponse commitMutation(
      List<com.google.datastore.v1beta3.Mutation> mutationsPb) {
    com.google.datastore.v1beta3.CommitRequest.Builder requestPb = 
        com.google.datastore.v1beta3.CommitRequest.newBuilder();
    requestPb.setMode(com.google.datastore.v1beta3.CommitRequest.Mode.NON_TRANSACTIONAL);
    requestPb.addAllMutations(mutationsPb);
    return commit(requestPb.build());
  }

  com.google.datastore.v1beta3.CommitResponse commit(
      final com.google.datastore.v1beta3.CommitRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(
          new Callable<com.google.datastore.v1beta3.CommitResponse>() {
        @Override public com.google.datastore.v1beta3.CommitResponse call()
            throws DatastoreRpcException {
          return datastoreRpc.commit(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }

  ByteString requestTransactionId(
      com.google.datastore.v1beta3.BeginTransactionRequest.Builder requestPb) {
    return beginTransaction(requestPb.build()).getTransaction();
  }

  com.google.datastore.v1beta3.BeginTransactionResponse beginTransaction(
      final com.google.datastore.v1beta3.BeginTransactionRequest requestPb) {
    try {
      return RetryHelper.runWithRetries(
          new Callable<com.google.datastore.v1beta3.BeginTransactionResponse>() {
        @Override
        public com.google.datastore.v1beta3.BeginTransactionResponse call()
            throws DatastoreRpcException {
          return datastoreRpc.beginTransaction(requestPb);
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }

  void rollbackTransaction(ByteString transaction) {
    com.google.datastore.v1beta3.RollbackRequest.Builder requestPb = 
        com.google.datastore.v1beta3.RollbackRequest.newBuilder();
    requestPb.setTransaction(transaction);
    rollback(requestPb.build());
  }

  void rollback(final com.google.datastore.v1beta3.RollbackRequest requestPb) {
    try {
      RetryHelper.runWithRetries(new Callable<Void>() {
        @Override public Void call() throws DatastoreRpcException {
          datastoreRpc.rollback(requestPb);
          return null;
        }
      }, retryParams, EXCEPTION_HANDLER);
    } catch (RetryHelperException e) {
      throw DatastoreException.translateAndThrow(e);
    }
  }
}
