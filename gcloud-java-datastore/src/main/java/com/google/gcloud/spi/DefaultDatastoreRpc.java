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

package com.google.gcloud.spi;

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
import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreException;
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreOptions.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.datastore.DatastoreOptions;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException.Reason;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

public class DefaultDatastoreRpc implements DatastoreRpc {

  private final Datastore client;

  private static final ImmutableMap<String, Reason> STR_TO_REASON;
  private static final ImmutableMap<Integer, Reason> HTTP_STATUS_TO_REASON;

  static {
    ImmutableMap.Builder<String, Reason> builder = ImmutableMap.builder();
    Map<Integer, Reason> httpCodes = new HashMap<>();
    for (Reason reason : Reason.values()) {
      builder.put(reason.name(), reason);
      httpCodes.put(reason.httpStatus(), reason);
    }
    STR_TO_REASON = builder.build();
    HTTP_STATUS_TO_REASON = ImmutableMap.copyOf(httpCodes);
  }

  public DefaultDatastoreRpc(DatastoreOptions options) {
    client = DatastoreFactory.get().create(
        new Builder()
            .dataset(options.projectId())
            .host(options.host())
            .initializer(options.httpRequestInitializer())
            .build());
  }

  private static DatastoreRpcException translate(DatastoreException exception) {
    String message = exception.getMessage();
    String reasonStr = "";
    if (message != null) {
      try {
        JSONObject json = new JSONObject(new JSONTokener(message));
        JSONObject error = json.getJSONObject("error").getJSONArray("errors").getJSONObject(0);
        reasonStr = error.getString("reason");
        message = error.getString("message");
      } catch (JSONException ignore) {
        // ignore - will be converted to unknown
      }
    }
    Reason reason = STR_TO_REASON.get(reasonStr);
    if (reason == null) {
      reason = HTTP_STATUS_TO_REASON.get(exception.getCode());
    }
    return reason != null
        ? new DatastoreRpcException(reason)
        : new DatastoreRpcException("Unknown", exception.getCode(), false, message);
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request)
      throws DatastoreRpcException {
    try {
      return client.allocateIds(request);
    } catch (DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws DatastoreRpcException {
    try {
      return client.beginTransaction(request);
    } catch (DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public CommitResponse commit(CommitRequest request) throws DatastoreRpcException {
    try {
      return client.commit(request);
    } catch (DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public LookupResponse lookup(LookupRequest request) throws DatastoreRpcException {
    try {
      return client.lookup(request);
    } catch (DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) throws DatastoreRpcException {
    try {
      return client.rollback(request);
    } catch (DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) throws DatastoreRpcException {
    try {
      return client.runQuery(request);
    } catch (DatastoreException ex) {
      throw translate(ex);
    }
  }
}

