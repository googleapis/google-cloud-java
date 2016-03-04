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
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreOptions.Builder;
import com.google.common.base.Preconditions;
import com.google.gcloud.datastore.DatastoreException;
import com.google.gcloud.datastore.DatastoreOptions;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

public class DefaultDatastoreRpc implements DatastoreRpc {

  private final Datastore client;

  public DefaultDatastoreRpc(DatastoreOptions options) {
    String normalizedHost = normalizeHost(options.host());
    client = DatastoreFactory.get().create(
        new Builder()
            .dataset(options.projectId())
            .host(normalizedHost)
            .initializer(options.httpRequestInitializer())
            .build());
  }

  private static String normalizeHost(String host) {
    host = host.toLowerCase();
    if (includesScheme(host)) {
      Preconditions.checkArgument(!(host.startsWith("https://") && isLocalHost(host)),
          "\"https\" is not supported for localhost.  Use \"http\" instead.");
      return host;
    }
    return "http://" + host;
  }

  private static boolean isLocalHost(String host) {
    if (host != null) {
      try {
        String normalizedHost = host;
        if (!includesScheme(normalizedHost)) {
          normalizedHost = "http://" + normalizedHost;
        }
        InetAddress hostAddr = InetAddress.getByName(new URL(normalizedHost).getHost());
        return hostAddr.isAnyLocalAddress() || hostAddr.isLoopbackAddress();
      } catch (Exception e) {
        // ignore
      }
    }
    return false;
  }

  private static boolean includesScheme(String url) {
    return url.startsWith("http://") || url.startsWith("https://");
  }

  private static DatastoreException translate(
      com.google.api.services.datastore.client.DatastoreException exception) {
    String message = exception.getMessage();
    int code = exception.getCode();
    String reason = "";
    if (message != null) {
      try {
        JSONObject json = new JSONObject(new JSONTokener(message));
        JSONObject error = json.getJSONObject("error").getJSONArray("errors").getJSONObject(0);
        reason = error.getString("reason");
        message = error.getString("message");
      } catch (JSONException ignore) {
        // ignore - will be converted to unknown
      }
    }
    if (reason == null) {
      if (exception.getCause() instanceof IOException) {
        return new DatastoreException((IOException) exception.getCause());
      }
    }
    return new DatastoreException(code, message, reason, exception);
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    try {
      return client.allocateIds(request);
    } catch (com.google.api.services.datastore.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request) {
    try {
      return client.beginTransaction(request);
    } catch (com.google.api.services.datastore.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public CommitResponse commit(CommitRequest request) {
    try {
      return client.commit(request);
    } catch (com.google.api.services.datastore.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public LookupResponse lookup(LookupRequest request) {
    try {
      return client.lookup(request);
    } catch (com.google.api.services.datastore.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) {
    try {
      return client.rollback(request);
    } catch (com.google.api.services.datastore.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) {
    try {
      return client.runQuery(request);
    } catch (com.google.api.services.datastore.client.DatastoreException ex) {
      throw translate(ex);
    }
  }
}
