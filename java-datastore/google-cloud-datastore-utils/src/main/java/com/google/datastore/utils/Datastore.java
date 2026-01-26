/*
 * Copyright 2024 Google LLC
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
package com.google.datastore.utils;

import com.google.datastore.v1.*;
import com.google.rpc.Code;
import java.io.IOException;
import java.io.InputStream;

/**
 * Provides access to Cloud Datastore.
 *
 * <p>This class is thread-safe.
 */
public class Datastore {

  final RemoteRpc remoteRpc;

  Datastore(RemoteRpc remoteRpc) {
    this.remoteRpc = remoteRpc;
  }

  /** Reset the RPC count. */
  public void resetRpcCount() {
    remoteRpc.resetRpcCount();
  }

  /**
   * Returns the number of RPC calls made since the client was created or {@link #resetRpcCount} was
   * called.
   */
  public int getRpcCount() {
    return remoteRpc.getRpcCount();
  }

  private com.google.datastore.utils.DatastoreException invalidResponseException(
      String method, IOException exception) {
    return RemoteRpc.makeException(
        remoteRpc.getUrl(), method, Code.UNAVAILABLE, "Invalid response", exception);
  }

  public AllocateIdsResponse allocateIds(AllocateIdsRequest request)
      throws com.google.datastore.utils.DatastoreException {
    try (InputStream is =
        remoteRpc.call("allocateIds", request, request.getProjectId(), request.getDatabaseId())) {
      return AllocateIdsResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("allocateIds", exception);
    }
  }

  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws com.google.datastore.utils.DatastoreException {
    try (InputStream is =
        remoteRpc.call(
            "beginTransaction", request, request.getProjectId(), request.getDatabaseId())) {
      return BeginTransactionResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("beginTransaction", exception);
    }
  }

  public CommitResponse commit(CommitRequest request)
      throws com.google.datastore.utils.DatastoreException {
    try (InputStream is =
        remoteRpc.call("commit", request, request.getProjectId(), request.getDatabaseId())) {
      return CommitResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("commit", exception);
    }
  }

  public LookupResponse lookup(LookupRequest request)
      throws com.google.datastore.utils.DatastoreException {
    try (InputStream is =
        remoteRpc.call("lookup", request, request.getProjectId(), request.getDatabaseId())) {
      return LookupResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("lookup", exception);
    }
  }

  public ReserveIdsResponse reserveIds(ReserveIdsRequest request)
      throws com.google.datastore.utils.DatastoreException {
    try (InputStream is =
        remoteRpc.call("reserveIds", request, request.getProjectId(), request.getDatabaseId())) {
      return ReserveIdsResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("reserveIds", exception);
    }
  }

  public RollbackResponse rollback(RollbackRequest request)
      throws com.google.datastore.utils.DatastoreException {
    try (InputStream is =
        remoteRpc.call("rollback", request, request.getProjectId(), request.getDatabaseId())) {
      return RollbackResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("rollback", exception);
    }
  }

  public RunQueryResponse runQuery(RunQueryRequest request)
      throws com.google.datastore.utils.DatastoreException {
    try (InputStream is =
        remoteRpc.call("runQuery", request, request.getProjectId(), request.getDatabaseId())) {
      return RunQueryResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("runQuery", exception);
    }
  }

  public RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request)
      throws DatastoreException {
    try (InputStream is =
        remoteRpc.call(
            "runAggregationQuery", request, request.getProjectId(), request.getDatabaseId())) {
      return RunAggregationQueryResponse.parseFrom(is);
    } catch (IOException exception) {
      throw invalidResponseException("runAggregationQuery", exception);
    }
  }
}
