/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressList;
import com.google.cloud.compute.v1.DeleteGlobalAddressRequest;
import com.google.cloud.compute.v1.GetGlobalAddressRequest;
import com.google.cloud.compute.v1.InsertGlobalAddressRequest;
import com.google.cloud.compute.v1.ListGlobalAddressesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.SetLabelsGlobalAddressRequest;
import com.google.protobuf.TypeRegistry;
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
@BetaApi
public class HttpJsonGlobalAddressesStub extends GlobalAddressesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteGlobalAddressRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlobalAddressRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/addresses/{address}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "address", request.getAddress());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteGlobalAddressRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetGlobalAddressRequest, Address> getMethodDescriptor =
      ApiMethodDescriptor.<GetGlobalAddressRequest, Address>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetGlobalAddressRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/addresses/{address}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetGlobalAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "address", request.getAddress());
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetGlobalAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Address>newBuilder()
                  .setDefaultInstance(Address.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertGlobalAddressRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertGlobalAddressRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/addresses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("addressResource", request.getAddressResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertGlobalAddressRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListGlobalAddressesRequest, AddressList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalAddressesRequest, AddressList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalAddressesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/addresses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalAddressesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AddressList>newBuilder()
                      .setDefaultInstance(AddressList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLabelsGlobalAddressRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsGlobalAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalAddresses/SetLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsGlobalAddressRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/addresses/{resource}/setLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsGlobalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsGlobalAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetLabelsRequestResource",
                                      request.getGlobalSetLabelsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetLabelsGlobalAddressRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<DeleteGlobalAddressRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteGlobalAddressRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetGlobalAddressRequest, Address> getCallable;
  private final UnaryCallable<InsertGlobalAddressRequest, Operation> insertCallable;
  private final OperationCallable<InsertGlobalAddressRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListGlobalAddressesRequest, AddressList> listCallable;
  private final UnaryCallable<ListGlobalAddressesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetLabelsGlobalAddressRequest, Operation> setLabelsCallable;
  private final OperationCallable<SetLabelsGlobalAddressRequest, Operation, Operation>
      setLabelsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
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
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteGlobalAddressRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteGlobalAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetGlobalAddressRequest, Address> getTransportSettings =
        HttpJsonCallSettings.<GetGlobalAddressRequest, Address>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertGlobalAddressRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertGlobalAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListGlobalAddressesRequest, AddressList> listTransportSettings =
        HttpJsonCallSettings.<ListGlobalAddressesRequest, AddressList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetLabelsGlobalAddressRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsGlobalAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setLabelsOperationCallable =
        callableFactory.createOperationCallable(
            setLabelsTransportSettings,
            settings.setLabelsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

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
    methodDescriptors.add(setLabelsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteGlobalAddressRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteGlobalAddressRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
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
  public OperationCallable<InsertGlobalAddressRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
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
  public UnaryCallable<SetLabelsGlobalAddressRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public OperationCallable<SetLabelsGlobalAddressRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return setLabelsOperationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
