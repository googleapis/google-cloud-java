/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.GlobalAddressesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressList;
import com.google.cloud.compute.v1.DeleteGlobalAddressRequest;
import com.google.cloud.compute.v1.GetGlobalAddressRequest;
import com.google.cloud.compute.v1.InsertGlobalAddressRequest;
import com.google.cloud.compute.v1.ListGlobalAddressesRequest;
import com.google.cloud.compute.v1.Operation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GlobalAddresses service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonGlobalAddressesStub extends GlobalAddressesStub {
  private static final ApiMethodDescriptor<DeleteGlobalAddressRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlobalAddressRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/addresses/{address}",
                          new FieldsExtractor<DeleteGlobalAddressRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteGlobalAddressRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalAddressRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "address", request.getAddress());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteGlobalAddressRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteGlobalAddressRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalAddressRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteGlobalAddressRequest, String>() {
                            @Override
                            public String extract(DeleteGlobalAddressRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGlobalAddressRequest, Address> getMethodDescriptor =
      ApiMethodDescriptor.<GetGlobalAddressRequest, Address>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetGlobalAddressRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/addresses/{address}",
                      new FieldsExtractor<GetGlobalAddressRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetGlobalAddressRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetGlobalAddressRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "address", request.getAddress());
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetGlobalAddressRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetGlobalAddressRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetGlobalAddressRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetGlobalAddressRequest, String>() {
                        @Override
                        public String extract(GetGlobalAddressRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Address>newBuilder()
                  .setDefaultInstance(Address.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertGlobalAddressRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertGlobalAddressRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/addresses",
                          new FieldsExtractor<InsertGlobalAddressRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertGlobalAddressRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertGlobalAddressRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertGlobalAddressRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertGlobalAddressRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertGlobalAddressRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertGlobalAddressRequest, String>() {
                            @Override
                            public String extract(InsertGlobalAddressRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("addressResource", request.getAddressResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGlobalAddressesRequest, AddressList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalAddressesRequest, AddressList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalAddressesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/addresses",
                          new FieldsExtractor<ListGlobalAddressesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListGlobalAddressesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalAddressesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListGlobalAddressesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListGlobalAddressesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalAddressesRequest> serializer =
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
                          new FieldsExtractor<ListGlobalAddressesRequest, String>() {
                            @Override
                            public String extract(ListGlobalAddressesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AddressList>newBuilder()
                      .setDefaultInstance(AddressList.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<DeleteGlobalAddressRequest, Operation> deleteCallable;
  private final UnaryCallable<GetGlobalAddressRequest, Address> getCallable;
  private final UnaryCallable<InsertGlobalAddressRequest, Operation> insertCallable;
  private final UnaryCallable<ListGlobalAddressesRequest, AddressList> listCallable;
  private final UnaryCallable<ListGlobalAddressesRequest, ListPagedResponse> listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalAddressesStub create(GlobalAddressesStubSettings settings)
      throws IOException {
    return new HttpJsonGlobalAddressesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalAddressesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalAddressesStub(
        GlobalAddressesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalAddressesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalAddressesStub(
        GlobalAddressesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalAddressesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalAddressesStub(
      GlobalAddressesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGlobalAddressesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalAddressesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalAddressesStub(
      GlobalAddressesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteGlobalAddressRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteGlobalAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetGlobalAddressRequest, Address> getTransportSettings =
        HttpJsonCallSettings.<GetGlobalAddressRequest, Address>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertGlobalAddressRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertGlobalAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListGlobalAddressesRequest, AddressList> listTransportSettings =
        HttpJsonCallSettings.<ListGlobalAddressesRequest, AddressList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteGlobalAddressRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetGlobalAddressRequest, Address> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertGlobalAddressRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListGlobalAddressesRequest, AddressList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalAddressesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
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
