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

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.services.datastore.DatastoreV1.AllocateIdsRequest;
import com.google.api.services.datastore.DatastoreV1.AllocateIdsResponse;
import com.google.api.services.datastore.DatastoreV1.BeginTransactionRequest;
import com.google.api.services.datastore.DatastoreV1.BeginTransactionResponse;
import com.google.api.services.datastore.DatastoreV1.CommitRequest;
import com.google.api.services.datastore.DatastoreV1.CommitResponse;
import com.google.api.services.datastore.DatastoreV1.LookupRequest;
import com.google.api.services.datastore.DatastoreV1.LookupResponse;
import com.google.api.services.datastore.DatastoreV1.RollbackRequest;
import com.google.api.services.datastore.DatastoreV1.RollbackResponse;
import com.google.api.services.datastore.DatastoreV1.RunQueryRequest;
import com.google.api.services.datastore.DatastoreV1.RunQueryResponse;

import java.io.IOException;

/**
 * Provides access to the Datastore.
 *
 */
public class Datastore {

  final RemoteRpc remoteRpc;

  Datastore(RemoteRpc remoteRpc) {
    this.remoteRpc = remoteRpc;
  }

  /**
   * Reset the RPC count.
   */
  public void resetRpcCount() {
    remoteRpc.resetRpcCount();
  }

  /**
   * Returns the number of RPC calls made since the client was created
   * or {@link #resetRpcCount} was called.
   */
  public int getRpcCount() {
    return remoteRpc.getRpcCount();
  }

  private DatastoreException invalidResponseException(String method, IOException exception) {
    return RemoteRpc.makeException(remoteRpc.getUrl(), method,
        HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Invalid response", exception);
  }

  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) throws DatastoreException {
    try {
      return AllocateIdsResponse.parseFrom(remoteRpc.call("allocateIds", request));
    } catch (IOException exception) {
      throw invalidResponseException("allocateIds", exception);
    }
  }

  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws DatastoreException {
    try {
      return BeginTransactionResponse.parseFrom(remoteRpc.call("beginTransaction", request));
    } catch (IOException exception) {
      throw invalidResponseException("beginTransaction", exception);
    }
  }

  public CommitResponse commit(CommitRequest request) throws DatastoreException {
    try {
      return CommitResponse.parseFrom(remoteRpc.call("commit", request));
    } catch (IOException exception) {
      throw invalidResponseException("commit", exception);
    }
  }

  public LookupResponse lookup(LookupRequest request) throws DatastoreException {
    try {
      return LookupResponse.parseFrom(remoteRpc.call("lookup", request));
    } catch (IOException exception) {
      throw invalidResponseException("lookup", exception);
    }
  }

  public RollbackResponse rollback(RollbackRequest request) throws DatastoreException {
    try {
      return RollbackResponse.parseFrom(remoteRpc.call("rollback", request));
    } catch (IOException exception) {
      throw invalidResponseException("rollback", exception);
    }
  }

  public RunQueryResponse runQuery(RunQueryRequest request) throws DatastoreException {
    try {
      return RunQueryResponse.parseFrom(remoteRpc.call("runQuery", request));
    } catch (IOException exception) {
      throw invalidResponseException("runQuery", exception);
    }
  }
}
