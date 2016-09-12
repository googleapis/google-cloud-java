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

package com.google.cloud.datastore.spi;

import com.google.api.client.http.HttpTransport;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

public class DefaultDatastoreRpc implements DatastoreRpc {

  private final com.google.datastore.v1.client.Datastore client;

  public DefaultDatastoreRpc(DatastoreOptions options) {
    HttpTransport transport = options.httpTransportFactory().create();
    com.google.datastore.v1.client.DatastoreOptions.Builder clientBuilder =
        new com.google.datastore.v1.client.DatastoreOptions.Builder()
            .projectId(options.projectId())
            .initializer(options.httpRequestInitializer())
            .transport(transport);
    String normalizedHost = options.host() != null ? options.host().toLowerCase() : "";
    if (isLocalHost(normalizedHost)) {
      clientBuilder = clientBuilder.localHost(removeScheme(normalizedHost));
    } else if (!removeScheme(com.google.datastore.v1.client.DatastoreFactory.DEFAULT_HOST)
                    .equals(removeScheme(normalizedHost))
        && !normalizedHost.isEmpty()) {
      String fullUrl = normalizedHost;
      if (fullUrl.charAt(fullUrl.length() - 1) != '/') {
        fullUrl = fullUrl + '/';
      }
      fullUrl = fullUrl
          + com.google.datastore.v1.client.DatastoreFactory.VERSION
          + "/projects/"
          + options.projectId();
      clientBuilder = clientBuilder.projectId(null).projectEndpoint(fullUrl);
    }
    client = com.google.datastore.v1.client.DatastoreFactory.get()
        .create(clientBuilder.build());
  }

  private static boolean isLocalHost(String host) {
    if (!host.isEmpty()) {
      try {
        String normalizedHost = "http://" + removeScheme(host);
        InetAddress hostAddr = InetAddress.getByName(new URL(normalizedHost).getHost());
        return hostAddr.isAnyLocalAddress() || hostAddr.isLoopbackAddress();
      } catch (Exception e) {
        // ignore
      }
    }
    return false;
  }

  private static String removeScheme(String url) {
    if (url != null) {
      if (url.startsWith("https://")) {
        return url.substring("https://".length());
      } else if (url.startsWith("http://")) {
        return url.substring("http://".length());
      }
    }
    return url;
  }

  private static DatastoreException translate(
      com.google.datastore.v1.client.DatastoreException exception) {
    String reason = "";
    if (exception.getCode() != null) {
      reason = exception.getCode().name();
    }
    if (reason.isEmpty()) {
      if (exception.getCause() instanceof IOException) {
        return new DatastoreException((IOException) exception.getCause());
      }
    }
    return new DatastoreException(
        exception.getCode().getNumber(), exception.getMessage(), reason, exception);
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    try {
      return client.allocateIds(request);
    } catch (com.google.datastore.v1.client.DatastoreException ex) {

      throw translate(ex);
    }
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request) {
    try {
      return client.beginTransaction(request);
    } catch (com.google.datastore.v1.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public CommitResponse commit(CommitRequest request) {
    try {
      return client.commit(request);
    } catch (com.google.datastore.v1.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public LookupResponse lookup(LookupRequest request) {
    try {
      return client.lookup(request);
    } catch (com.google.datastore.v1.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) {
    try {
      return client.rollback(request);
    } catch (com.google.datastore.v1.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) {
    try {
      return client.runQuery(request);
    } catch (com.google.datastore.v1.client.DatastoreException ex) {
      throw translate(ex);
    }
  }
}
