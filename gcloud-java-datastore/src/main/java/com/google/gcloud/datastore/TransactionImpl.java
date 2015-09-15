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

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gcloud.datastore.TransactionOption.ForceWrites;
import com.google.gcloud.datastore.TransactionOption.IsolationLevel;
import com.google.protobuf.ByteString;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class TransactionImpl extends BaseDatastoreBatchWriter implements Transaction {

  private final DatastoreImpl datastore;
  private final ByteString transaction;
  private final boolean force;
  private boolean rolledback;

  static class ResponseImpl implements Transaction.Response {

    private final com.google.datastore.v1beta3.CommitResponse response;

    ResponseImpl(com.google.datastore.v1beta3.CommitResponse response) {
      this.response = response;
    }

    @Override
    public List<Key> generatedKeys() {
      return Lists.transform(response.getMutationResult().getInsertAutoIdKeyList(),
          new Function<com.google.datastore.v1beta3.Key, Key>() {
            @Override public Key apply(com.google.datastore.v1beta3.Key keyPb) {
              return Key.fromPb(keyPb);
            }
          });
    }
  }

  TransactionImpl(DatastoreImpl datastore, TransactionOption... options) {
    super("transaction");
    this.datastore = datastore;
    com.google.datastore.v1beta3.BeginTransactionRequest.Builder requestPb =
        com.google.datastore.v1beta3.BeginTransactionRequest.newBuilder();
    Map<Class<? extends TransactionOption>, TransactionOption> optionsMap =
        TransactionOption.asImmutableMap(options);
    IsolationLevel isolationLevel = (IsolationLevel) optionsMap.get(IsolationLevel.class);
    if (isolationLevel != null) {
      requestPb.setIsolationLevel(isolationLevel.level().toPb());
    }
    ForceWrites forceWrites = (ForceWrites) optionsMap.get(TransactionOption.ForceWrites.class);
    force = forceWrites != null && forceWrites.force();
    transaction = datastore.requestTransactionId(requestPb);
  }

  @Override
  public Entity get(Key key) {
    return DatastoreHelper.get(this, key);
  }

  @Override
  public Iterator<Entity> get(Key... keys) {
    validateActive();
    com.google.datastore.v1beta3.ReadOptions.Builder readOptionsPb = 
        com.google.datastore.v1beta3.ReadOptions.newBuilder();
    readOptionsPb.setTransaction(transaction);
    return datastore.get(readOptionsPb.build(), keys);
  }

  @Override
  public List<Entity> fetch(Key... keys) {
    validateActive();
    return DatastoreHelper.fetch(this, keys);
  }

  @Override
  public <T> QueryResults<T> run(Query<T> query) {
    validateActive();
    com.google.datastore.v1beta3.ReadOptions.Builder readOptionsPb = 
        com.google.datastore.v1beta3.ReadOptions.newBuilder();
    readOptionsPb.setTransaction(transaction);
    return datastore.run(readOptionsPb.build(), query);
  }

  @Override
  public Transaction.Response commit() {
    validateActive();
    com.google.datastore.v1beta3.Mutation.Builder mutationPb = toMutationPb();
    com.google.datastore.v1beta3.CommitRequest.Builder requestPb = 
        com.google.datastore.v1beta3.CommitRequest.newBuilder();
    requestPb.setMode(com.google.datastore.v1beta3.CommitRequest.Mode.TRANSACTIONAL);
    requestPb.setTransaction(transaction);
    requestPb.setMutation(mutationPb);
    com.google.datastore.v1beta3.CommitResponse responsePb = datastore.commit(requestPb.build());
    deactivate();
    return new ResponseImpl(responsePb);
  }

  @Override
  public void rollback() {
    if (rolledback) {
      return;
    }
    validateActive();
    datastore.rollbackTransaction(transaction);
    deactivate();
    rolledback = true;
  }

  @Override
  public Datastore datastore() {
    return datastore;
  }
}
