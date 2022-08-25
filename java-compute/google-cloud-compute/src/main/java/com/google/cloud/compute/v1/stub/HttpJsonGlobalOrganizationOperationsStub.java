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

import static com.google.cloud.compute.v1.GlobalOrganizationOperationsClient.ListPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonLongRunningClient;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteGlobalOrganizationOperationRequest;
import com.google.cloud.compute.v1.DeleteGlobalOrganizationOperationResponse;
import com.google.cloud.compute.v1.GetGlobalOrganizationOperationRequest;
import com.google.cloud.compute.v1.ListGlobalOrganizationOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.OperationList;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GlobalOrganizationOperations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGlobalOrganizationOperationsStub extends GlobalOrganizationOperationsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
      deleteMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOrganizationOperations/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteGlobalOrganizationOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/operations/{operation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalOrganizationOperationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalOrganizationOperationRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasParentId()) {
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteGlobalOrganizationOperationResponse>newBuilder()
                      .setDefaultInstance(
                          DeleteGlobalOrganizationOperationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGlobalOrganizationOperationRequest, Operation>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalOrganizationOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOrganizationOperations/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalOrganizationOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/operations/{operation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalOrganizationOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalOrganizationOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasParentId()) {
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
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
                  (GetGlobalOrganizationOperationRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .setPollingRequestFactory(
                  compoundOperationId -> {
                    List<String> idComponents = Arrays.asList(compoundOperationId.split(":"));
                    return GetGlobalOrganizationOperationRequest.newBuilder()
                        .setOperation(idComponents.get(0))
                        .setParentId(idComponents.get(1))
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListGlobalOrganizationOperationsRequest, OperationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalOrganizationOperationsRequest, OperationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOrganizationOperations/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalOrganizationOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/operations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalOrganizationOperationsRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalOrganizationOperationsRequest>
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasParentId()) {
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
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
                  ProtoMessageResponseParser.<OperationList>newBuilder()
                      .setDefaultInstance(OperationList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
      deleteCallable;
  private final UnaryCallable<GetGlobalOrganizationOperationRequest, Operation> getCallable;
  private final UnaryCallable<ListGlobalOrganizationOperationsRequest, OperationList> listCallable;
  private final UnaryCallable<ListGlobalOrganizationOperationsRequest, ListPagedResponse>
      listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final LongRunningClient longRunningClient;
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
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGlobalOrganizationOperationRequest, Operation> getTransportSettings =
        HttpJsonCallSettings.<GetGlobalOrganizationOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListGlobalOrganizationOperationsRequest, OperationList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalOrganizationOperationsRequest, OperationList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

    this.longRunningClient =
        new HttpJsonLongRunningClient<GetGlobalOrganizationOperationRequest, Operation>(
            getCallable,
            getMethodDescriptor.getOperationSnapshotFactory(),
            getMethodDescriptor.getPollingRequestFactory());
    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          DeleteGlobalOrganizationOperationRequest, DeleteGlobalOrganizationOperationResponse>
      deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetGlobalOrganizationOperationRequest, Operation> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListGlobalOrganizationOperationsRequest, OperationList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalOrganizationOperationsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public LongRunningClient longRunningClient() {
    return longRunningClient;
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
