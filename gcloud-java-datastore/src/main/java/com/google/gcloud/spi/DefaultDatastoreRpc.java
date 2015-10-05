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

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.datastore.DatastoreOptions;
import com.google.gcloud.spi.DatastoreRpc.DatastoreRpcException.Reason;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DefaultDatastoreRpc implements DatastoreRpc {

  private final com.google.datastore.v1beta3.client.Datastore client;

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
    com.google.datastore.v1beta3.client.DatastoreOptions.Builder clientBuilder = 
        new com.google.datastore.v1beta3.client.DatastoreOptions.Builder()
            .projectId(options.projectId())
            .initializer(options.httpRequestInitializer());
    if (isLocalHost(options.host())) {
      clientBuilder = clientBuilder.localHost(removeScheme(options.host()));
    } else if (!com.google.datastore.v1beta3.client.DatastoreFactory.DEFAULT_HOST
        .equals(options.host()) && !Strings.isNullOrEmpty(options.host())) {
      String fullURL = options.host();
      if (fullURL.charAt(fullURL.length() - 1) != '/') {
        fullURL = fullURL + '/';
      }
      fullURL = fullURL + "datastore/"
          + com.google.datastore.v1beta3.client.DatastoreFactory.VERSION + "/projects/"
          + options.projectId();
      clientBuilder = clientBuilder.projectId(null).projectEndpoint(fullURL);
    }
    client = com.google.datastore.v1beta3.client.DatastoreFactory.get()
        .create(clientBuilder.build());
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
      } catch (UnknownHostException | MalformedURLException e) {
        // ignore
      }
    }
    return false;
  }

  private static boolean includesScheme(String url) {
    return url.startsWith("http://") || url.startsWith("https://");
  }

  private static String removeScheme(String url) {
    if (url.startsWith("https://")) {
      return url.substring("https://".length());
    } else if (url.startsWith("http://")) {
      return url.substring("http://".length());
    }
    return url;
  }

  private static DatastoreRpcException translate(
      com.google.datastore.v1beta3.client.DatastoreException exception) {
    String reasonStr = "";
    if (exception.getCode() != null) {
      reasonStr = exception.getCode().name();
    }
    Reason reason = STR_TO_REASON.get(reasonStr);
    if (reason == null) {
      reason = HTTP_STATUS_TO_REASON.get(exception.getCode());
    }
    return reason != null
        ? new DatastoreRpcException(reason)
        : new DatastoreRpcException("Unknown", 
            exception.getCode().ordinal(), 
            false, 
            exception.getMessage());
  }

  @Override
  public com.google.datastore.v1beta3.AllocateIdsResponse allocateIds(
      com.google.datastore.v1beta3.AllocateIdsRequest request) throws DatastoreRpcException {
    try {
      return client.allocateIds(request);
    } catch (com.google.datastore.v1beta3.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public com.google.datastore.v1beta3.BeginTransactionResponse beginTransaction(
      com.google.datastore.v1beta3.BeginTransactionRequest request) throws DatastoreRpcException {
    try {
      return client.beginTransaction(request);
    } catch (com.google.datastore.v1beta3.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public com.google.datastore.v1beta3.CommitResponse commit(
      com.google.datastore.v1beta3.CommitRequest request) throws DatastoreRpcException {
    try {
      return client.commit(request);
    } catch (com.google.datastore.v1beta3.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public com.google.datastore.v1beta3.LookupResponse lookup(
      com.google.datastore.v1beta3.LookupRequest request) throws DatastoreRpcException {
    try {
      return client.lookup(request);
    } catch (com.google.datastore.v1beta3.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public com.google.datastore.v1beta3.RollbackResponse rollback(
      com.google.datastore.v1beta3.RollbackRequest request) throws DatastoreRpcException {
    try {
      return client.rollback(request);
    } catch (com.google.datastore.v1beta3.client.DatastoreException ex) {
      throw translate(ex);
    }
  }

  @Override
  public com.google.datastore.v1beta3.RunQueryResponse runQuery(
      com.google.datastore.v1beta3.RunQueryRequest request) throws DatastoreRpcException {
    try {
      return client.runQuery(request);
    } catch (com.google.datastore.v1beta3.client.DatastoreException ex) {
      throw translate(ex);
    }
  }
}

