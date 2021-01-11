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

import static com.google.cloud.compute.v1.GlobalOrganizationOperationsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteGlobalOrganizationOperationRequest;
import com.google.cloud.compute.v1.DeleteGlobalOrganizationOperationResponse;
import com.google.cloud.compute.v1.GetGlobalOrganizationOperationRequest;
import com.google.cloud.compute.v1.ListGlobalOrganizationOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationList;
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
public class HttpJsonGlobalOrganizationOperationsStub extends GlobalOrganizationOperationsStub {

  @InternalApi
  public static final ApiMethodDescriptor<
          DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
      deleteMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOrganizationOperations.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteGlobalOrganizationOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/operations/{operation}",
                          new FieldsExtractor<
                              DeleteGlobalOrganizationOperationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteGlobalOrganizationOperationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalOrganizationOperationRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "operation", request.getOperation());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteGlobalOrganizationOperationRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteGlobalOrganizationOperationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalOrganizationOperationRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteGlobalOrganizationOperationRequest, String>() {
                            @Override
                            public String extract(
                                DeleteGlobalOrganizationOperationRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteGlobalOrganizationOperationResponse>newBuilder()
                      .setDefaultInstance(
                          DeleteGlobalOrganizationOperationResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetGlobalOrganizationOperationRequest, Operation>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalOrganizationOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOrganizationOperations.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalOrganizationOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/operations/{operation}",
                          new FieldsExtractor<
                              GetGlobalOrganizationOperationRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetGlobalOrganizationOperationRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetGlobalOrganizationOperationRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "operation", request.getOperation());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetGlobalOrganizationOperationRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetGlobalOrganizationOperationRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetGlobalOrganizationOperationRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetGlobalOrganizationOperationRequest, String>() {
                            @Override
                            public String extract(GetGlobalOrganizationOperationRequest request) {
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
  public static final ApiMethodDescriptor<ListGlobalOrganizationOperationsRequest, OperationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalOrganizationOperationsRequest, OperationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOrganizationOperations.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalOrganizationOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/operations",
                          new FieldsExtractor<
                              ListGlobalOrganizationOperationsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListGlobalOrganizationOperationsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalOrganizationOperationsRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListGlobalOrganizationOperationsRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListGlobalOrganizationOperationsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalOrganizationOperationsRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListGlobalOrganizationOperationsRequest, String>() {
                            @Override
                            public String extract(ListGlobalOrganizationOperationsRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OperationList>newBuilder()
                      .setDefaultInstance(OperationList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
      deleteCallable;
  private final UnaryCallable<GetGlobalOrganizationOperationRequest, Operation> getCallable;
  private final UnaryCallable<ListGlobalOrganizationOperationsRequest, OperationList> listCallable;
  private final UnaryCallable<ListGlobalOrganizationOperationsRequest, ListPagedResponse>
      listPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalOrganizationOperationsStub create(
      GlobalOrganizationOperationsStubSettings settings) throws IOException {
    return new HttpJsonGlobalOrganizationOperationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalOrganizationOperationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalOrganizationOperationsStub(
        GlobalOrganizationOperationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalOrganizationOperationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalOrganizationOperationsStub(
        GlobalOrganizationOperationsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalOrganizationOperationsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalOrganizationOperationsStub(
      GlobalOrganizationOperationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalOrganizationOperationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalOrganizationOperationsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalOrganizationOperationsStub(
      GlobalOrganizationOperationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteGlobalOrganizationOperationRequest,
                    DeleteGlobalOrganizationOperationResponse>
                    newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetGlobalOrganizationOperationRequest, Operation> getTransportSettings =
        HttpJsonCallSettings.<GetGlobalOrganizationOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListGlobalOrganizationOperationsRequest, OperationList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalOrganizationOperationsRequest, OperationList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<
          DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
      deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetGlobalOrganizationOperationRequest, Operation> getCallable() {
    return getCallable;
  }

  public UnaryCallable<ListGlobalOrganizationOperationsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListGlobalOrganizationOperationsRequest, OperationList> listCallable() {
    return listCallable;
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
