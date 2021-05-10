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

import static com.google.cloud.compute.v1.ExternalVpnGatewaysClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteExternalVpnGatewayRequest;
import com.google.cloud.compute.v1.ExternalVpnGateway;
import com.google.cloud.compute.v1.ExternalVpnGatewayList;
import com.google.cloud.compute.v1.GetExternalVpnGatewayRequest;
import com.google.cloud.compute.v1.InsertExternalVpnGatewayRequest;
import com.google.cloud.compute.v1.ListExternalVpnGatewaysRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsExternalVpnGatewayRequest;
import com.google.cloud.compute.v1.TestIamPermissionsExternalVpnGatewayRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
public class HttpJsonExternalVpnGatewaysStub extends ExternalVpnGatewaysStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteExternalVpnGatewayRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteExternalVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ExternalVpnGateways.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExternalVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/externalVpnGateways/{externalVpnGateway}",
                          new FieldsExtractor<
                              DeleteExternalVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteExternalVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "externalVpnGateway", request.getExternalVpnGateway());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteExternalVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteExternalVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteExternalVpnGatewayRequest, String>() {
                            @Override
                            public String extract(DeleteExternalVpnGatewayRequest request) {
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
  public static final ApiMethodDescriptor<GetExternalVpnGatewayRequest, ExternalVpnGateway>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetExternalVpnGatewayRequest, ExternalVpnGateway>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ExternalVpnGateways.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExternalVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/externalVpnGateways/{externalVpnGateway}",
                          new FieldsExtractor<GetExternalVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetExternalVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "externalVpnGateway", request.getExternalVpnGateway());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetExternalVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetExternalVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetExternalVpnGatewayRequest, String>() {
                            @Override
                            public String extract(GetExternalVpnGatewayRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalVpnGateway>newBuilder()
                      .setDefaultInstance(ExternalVpnGateway.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertExternalVpnGatewayRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertExternalVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ExternalVpnGateways.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertExternalVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/externalVpnGateways",
                          new FieldsExtractor<
                              InsertExternalVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertExternalVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertExternalVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertExternalVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertExternalVpnGatewayRequest, String>() {
                            @Override
                            public String extract(InsertExternalVpnGatewayRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "externalVpnGatewayResource",
                                      request.getExternalVpnGatewayResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ExternalVpnGateways.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExternalVpnGatewaysRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/externalVpnGateways",
                          new FieldsExtractor<
                              ListExternalVpnGatewaysRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListExternalVpnGatewaysRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListExternalVpnGatewaysRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListExternalVpnGatewaysRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListExternalVpnGatewaysRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListExternalVpnGatewaysRequest> serializer =
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
                          new FieldsExtractor<ListExternalVpnGatewaysRequest, String>() {
                            @Override
                            public String extract(ListExternalVpnGatewaysRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalVpnGatewayList>newBuilder()
                      .setDefaultInstance(ExternalVpnGatewayList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsExternalVpnGatewayRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsExternalVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ExternalVpnGateways.SetLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsExternalVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/externalVpnGateways/{resource}/setLabels",
                          new FieldsExtractor<
                              SetLabelsExternalVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetLabelsExternalVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetLabelsExternalVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetLabelsExternalVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsExternalVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetLabelsExternalVpnGatewayRequest, String>() {
                            @Override
                            public String extract(SetLabelsExternalVpnGatewayRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetLabelsRequestResource",
                                      request.getGlobalSetLabelsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsExternalVpnGatewayRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsExternalVpnGatewayRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ExternalVpnGateways.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsExternalVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/externalVpnGateways/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsExternalVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsExternalVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsExternalVpnGatewayRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsExternalVpnGatewayRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsExternalVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsExternalVpnGatewayRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsExternalVpnGatewayRequest, String>() {
                            @Override
                            public String extract(
                                TestIamPermissionsExternalVpnGatewayRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteExternalVpnGatewayRequest, Operation> deleteCallable;
  private final UnaryCallable<GetExternalVpnGatewayRequest, ExternalVpnGateway> getCallable;
  private final UnaryCallable<InsertExternalVpnGatewayRequest, Operation> insertCallable;
  private final UnaryCallable<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList> listCallable;
  private final UnaryCallable<ListExternalVpnGatewaysRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetLabelsExternalVpnGatewayRequest, Operation> setLabelsCallable;
  private final UnaryCallable<TestIamPermissionsExternalVpnGatewayRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonExternalVpnGatewaysStub create(
      ExternalVpnGatewaysStubSettings settings) throws IOException {
    return new HttpJsonExternalVpnGatewaysStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonExternalVpnGatewaysStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonExternalVpnGatewaysStub(
        ExternalVpnGatewaysStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonExternalVpnGatewaysStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonExternalVpnGatewaysStub(
        ExternalVpnGatewaysStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonExternalVpnGatewaysStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonExternalVpnGatewaysStub(
      ExternalVpnGatewaysStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonExternalVpnGatewaysCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonExternalVpnGatewaysStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonExternalVpnGatewaysStub(
      ExternalVpnGatewaysStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteExternalVpnGatewayRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteExternalVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetExternalVpnGatewayRequest, ExternalVpnGateway> getTransportSettings =
        HttpJsonCallSettings.<GetExternalVpnGatewayRequest, ExternalVpnGateway>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertExternalVpnGatewayRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertExternalVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetLabelsExternalVpnGatewayRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsExternalVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsExternalVpnGatewayRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsExternalVpnGatewayRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
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
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteExternalVpnGatewayRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetExternalVpnGatewayRequest, ExternalVpnGateway> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertExternalVpnGatewayRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListExternalVpnGatewaysRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListExternalVpnGatewaysRequest, ExternalVpnGatewayList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<SetLabelsExternalVpnGatewayRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  public UnaryCallable<TestIamPermissionsExternalVpnGatewayRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
