/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore.spi.v1;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.TraceUtil;
import com.google.cloud.http.CensusHttpModule;
import com.google.cloud.http.HttpTransportOptions;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

public class HttpDatastoreRpc implements DatastoreRpc {

  private final com.google.datastore.v1.client.Datastore client;

  public HttpDatastoreRpc(DatastoreOptions options) {
    HttpTransportOptions httpTransportOptions =
        (HttpTransportOptions) options.getTransportOptions();
    HttpTransport transport = httpTransportOptions.getHttpTransportFactory().create();
    com.google.datastore.v1.client.DatastoreOptions.Builder clientBuilder =
        new com.google.datastore.v1.client.DatastoreOptions.Builder()
            .projectId(options.getProjectId())
            .initializer(getHttpRequestInitializer(options, httpTransportOptions))
            .transport(transport);
    String normalizedHost = options.getHost() != null ? options.getHost().toLowerCase() : "";
    if (isLocalHost(normalizedHost)) {
      clientBuilder = clientBuilder.localHost(removeScheme(normalizedHost));
    } else if (!removeScheme(com.google.datastore.v1.client.DatastoreFactory.DEFAULT_HOST)
            .equals(removeScheme(normalizedHost))
        && !normalizedHost.isEmpty()) {
      String fullUrl = normalizedHost;
      if (fullUrl.charAt(fullUrl.length() - 1) != '/') {
        fullUrl = fullUrl + '/';
      }
      fullUrl =
          fullUrl
              + com.google.datastore.v1.client.DatastoreFactory.VERSION
              + "/projects/"
              + options.getProjectId();
      clientBuilder = clientBuilder.projectId(null).projectEndpoint(fullUrl);
    }
    client = com.google.datastore.v1.client.DatastoreFactory.get().create(clientBuilder.build());
  }

  private HttpRequestInitializer getHttpRequestInitializer(
      final DatastoreOptions options, HttpTransportOptions httpTransportOptions) {
    // Open Census initialization
    CensusHttpModule censusHttpModule =
        new CensusHttpModule(TraceUtil.getInstance().getTracer(), true);
    final HttpRequestInitializer censusHttpModuleHttpRequestInitializer =
        censusHttpModule.getHttpRequestInitializer(
            httpTransportOptions.getHttpRequestInitializer(options));

    final String applicationName = options.getApplicationName();
    return new HttpRequestInitializer() {
      @Override
      public void initialize(HttpRequest httpRequest) throws IOException {
        censusHttpModuleHttpRequestInitializer.initialize(httpRequest);
        httpRequest.getHeaders().setUserAgent(applicationName);
      }
    };
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
    return translate(exception, true);
  }

  private static DatastoreException translate(
      com.google.datastore.v1.client.DatastoreException exception, boolean idempotent) {
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
        exception.getCode().getNumber(), exception.getMessage(), reason, idempotent, exception);
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
      throw translate(ex, request.getMode() == CommitRequest.Mode.NON_TRANSACTIONAL);
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
  public ReserveIdsResponse reserveIds(ReserveIdsRequest request) {
    try {
      return client.reserveIds(request);
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

  @Override
  public RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request) {
    try {
      return client.runAggregationQuery(request);
    } catch (com.google.datastore.v1.client.DatastoreException ex) {
      throw translate(ex);
    }
  }
}
