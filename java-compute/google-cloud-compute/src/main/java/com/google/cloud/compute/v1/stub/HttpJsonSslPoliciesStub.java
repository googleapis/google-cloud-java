/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.SslPoliciesClient.ListPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteSslPolicyRequest;
import com.google.cloud.compute.v1.GetSslPolicyRequest;
import com.google.cloud.compute.v1.InsertSslPolicyRequest;
import com.google.cloud.compute.v1.ListAvailableFeaturesSslPoliciesRequest;
import com.google.cloud.compute.v1.ListSslPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSslPolicyRequest;
import com.google.cloud.compute.v1.SslPoliciesList;
import com.google.cloud.compute.v1.SslPoliciesListAvailableFeaturesResponse;
import com.google.cloud.compute.v1.SslPolicy;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonSslPoliciesStub extends SslPoliciesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteSslPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSslPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslPolicies.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSslPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslPolicies/{sslPolicy}",
                          new FieldsExtractor<DeleteSslPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteSslPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSslPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "sslPolicy", request.getSslPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<DeleteSslPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteSslPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSslPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteSslPolicyRequest, String>() {
                            @Override
                            public String extract(DeleteSslPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSslPolicyRequest, SslPolicy> getMethodDescriptor =
      ApiMethodDescriptor.<GetSslPolicyRequest, SslPolicy>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.SslPolicies.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSslPolicyRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/sslPolicies/{sslPolicy}",
                      new FieldsExtractor<GetSslPolicyRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetSslPolicyRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetSslPolicyRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "sslPolicy", request.getSslPolicy());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetSslPolicyRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetSslPolicyRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetSslPolicyRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetSslPolicyRequest, String>() {
                        @Override
                        public String extract(GetSslPolicyRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<SslPolicy>newBuilder()
                  .setDefaultInstance(SslPolicy.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertSslPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertSslPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslPolicies.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertSslPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslPolicies",
                          new FieldsExtractor<InsertSslPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertSslPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSslPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<InsertSslPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertSslPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSslPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertSslPolicyRequest, String>() {
                            @Override
                            public String extract(InsertSslPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("sslPolicyResource", request.getSslPolicyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListSslPoliciesRequest, SslPoliciesList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListSslPoliciesRequest, SslPoliciesList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslPolicies.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSslPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslPolicies",
                          new FieldsExtractor<ListSslPoliciesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListSslPoliciesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListSslPoliciesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListSslPoliciesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListSslPoliciesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListSslPoliciesRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListSslPoliciesRequest, String>() {
                            @Override
                            public String extract(ListSslPoliciesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslPoliciesList>newBuilder()
                      .setDefaultInstance(SslPoliciesList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListAvailableFeaturesSslPoliciesRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAvailableFeaturesSslPoliciesRequest, SslPoliciesListAvailableFeaturesResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SslPolicies.ListAvailableFeatures")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAvailableFeaturesSslPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/sslPolicies/listAvailableFeatures",
                          new FieldsExtractor<
                              ListAvailableFeaturesSslPoliciesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListAvailableFeaturesSslPoliciesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListAvailableFeaturesSslPoliciesRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListAvailableFeaturesSslPoliciesRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListAvailableFeaturesSslPoliciesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListAvailableFeaturesSslPoliciesRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListAvailableFeaturesSslPoliciesRequest, String>() {
                            @Override
                            public String extract(ListAvailableFeaturesSslPoliciesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SslPoliciesListAvailableFeaturesResponse>newBuilder()
                      .setDefaultInstance(
                          SslPoliciesListAvailableFeaturesResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchSslPolicyRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchSslPolicyRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.SslPolicies.Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchSslPolicyRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/sslPolicies/{sslPolicy}",
                      new FieldsExtractor<PatchSslPolicyRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchSslPolicyRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchSslPolicyRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "sslPolicy", request.getSslPolicy());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchSslPolicyRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchSslPolicyRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchSslPolicyRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchSslPolicyRequest, String>() {
                        @Override
                        public String extract(PatchSslPolicyRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("sslPolicyResource", request.getSslPolicyResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteSslPolicyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetSslPolicyRequest, SslPolicy> getCallable;
  private final UnaryCallable<InsertSslPolicyRequest, Operation> insertCallable;
  private final UnaryCallable<ListSslPoliciesRequest, SslPoliciesList> listCallable;
  private final UnaryCallable<ListSslPoliciesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<
          ListAvailableFeaturesSslPoliciesRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesCallable;
  private final UnaryCallable<PatchSslPolicyRequest, Operation> patchCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSslPoliciesStub create(SslPoliciesStubSettings settings)
      throws IOException {
    return new HttpJsonSslPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSslPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSslPoliciesStub(SslPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSslPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSslPoliciesStub(
        SslPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSslPoliciesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSslPoliciesStub(SslPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSslPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSslPoliciesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSslPoliciesStub(
      SslPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteSslPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteSslPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetSslPolicyRequest, SslPolicy> getTransportSettings =
        HttpJsonCallSettings.<GetSslPolicyRequest, SslPolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertSslPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertSslPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListSslPoliciesRequest, SslPoliciesList> listTransportSettings =
        HttpJsonCallSettings.<ListSslPoliciesRequest, SslPoliciesList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<
            ListAvailableFeaturesSslPoliciesRequest, SslPoliciesListAvailableFeaturesResponse>
        listAvailableFeaturesTransportSettings =
            HttpJsonCallSettings
                .<ListAvailableFeaturesSslPoliciesRequest, SslPoliciesListAvailableFeaturesResponse>
                    newBuilder()
                .setMethodDescriptor(listAvailableFeaturesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchSslPolicyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchSslPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listAvailableFeaturesCallable =
        callableFactory.createUnaryCallable(
            listAvailableFeaturesTransportSettings,
            settings.listAvailableFeaturesSettings(),
            clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteSslPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetSslPolicyRequest, SslPolicy> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertSslPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListSslPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListSslPoliciesRequest, SslPoliciesList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<
          ListAvailableFeaturesSslPoliciesRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesCallable() {
    return listAvailableFeaturesCallable;
  }

  public UnaryCallable<PatchSslPolicyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
