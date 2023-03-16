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

import static com.google.cloud.compute.v1.GlobalOperationsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.GlobalOperationsClient.ListPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListGlobalOperationsRequest;
import com.google.cloud.compute.v1.DeleteGlobalOperationRequest;
import com.google.cloud.compute.v1.DeleteGlobalOperationResponse;
import com.google.cloud.compute.v1.GetGlobalOperationRequest;
import com.google.cloud.compute.v1.ListGlobalOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.OperationAggregatedList;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.WaitGlobalOperationRequest;
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
 * REST stub implementation for the GlobalOperations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGlobalOperationsStub extends GlobalOperationsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          AggregatedListGlobalOperationsRequest, OperationAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListGlobalOperationsRequest, OperationAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOperations/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListGlobalOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/operations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListGlobalOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListGlobalOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasIncludeAllScopes()) {
                              serializer.putQueryParam(
                                  fields, "includeAllScopes", request.getIncludeAllScopes());
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
                  ProtoMessageResponseParser.<OperationAggregatedList>newBuilder()
                      .setDefaultInstance(OperationAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DeleteGlobalOperationRequest, DeleteGlobalOperationResponse>
      deleteMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteGlobalOperationRequest, DeleteGlobalOperationResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOperations/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlobalOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/operations/{operation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteGlobalOperationResponse>newBuilder()
                      .setDefaultInstance(DeleteGlobalOperationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGlobalOperationRequest, Operation>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOperations/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/operations/{operation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalOperationRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (GetGlobalOperationRequest request, Operation response) -> {
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
                    return GetGlobalOperationRequest.newBuilder()
                        .setOperation(idComponents.get(0))
                        .setProject(idComponents.get(1))
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListGlobalOperationsRequest, OperationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalOperationsRequest, OperationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOperations/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/operations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalOperationsRequest> serializer =
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
                  ProtoMessageResponseParser.<OperationList>newBuilder()
                      .setDefaultInstance(OperationList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<WaitGlobalOperationRequest, Operation>
      waitMethodDescriptor =
          ApiMethodDescriptor.<WaitGlobalOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalOperations/Wait")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WaitGlobalOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/operations/{operation}/wait",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<WaitGlobalOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<WaitGlobalOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<AggregatedListGlobalOperationsRequest, OperationAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListGlobalOperationsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteGlobalOperationRequest, DeleteGlobalOperationResponse>
      deleteCallable;
  private final UnaryCallable<GetGlobalOperationRequest, Operation> getCallable;
  private final UnaryCallable<ListGlobalOperationsRequest, OperationList> listCallable;
  private final UnaryCallable<ListGlobalOperationsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<WaitGlobalOperationRequest, Operation> waitCallable;

  private final BackgroundResource backgroundResources;
  private final LongRunningClient longRunningClient;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalOperationsStub create(GlobalOperationsStubSettings settings)
      throws IOException {
    return new HttpJsonGlobalOperationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalOperationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalOperationsStub(
        GlobalOperationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalOperationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalOperationsStub(
        GlobalOperationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalOperationsStub(
      GlobalOperationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGlobalOperationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalOperationsStub(
      GlobalOperationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListGlobalOperationsRequest, OperationAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListGlobalOperationsRequest, OperationAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteGlobalOperationRequest, DeleteGlobalOperationResponse>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteGlobalOperationRequest, DeleteGlobalOperationResponse>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGlobalOperationRequest, Operation> getTransportSettings =
        HttpJsonCallSettings.<GetGlobalOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListGlobalOperationsRequest, OperationList> listTransportSettings =
        HttpJsonCallSettings.<ListGlobalOperationsRequest, OperationList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<WaitGlobalOperationRequest, Operation> waitTransportSettings =
        HttpJsonCallSettings.<WaitGlobalOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(waitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
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
    this.waitCallable =
        callableFactory.createUnaryCallable(
            waitTransportSettings, settings.waitSettings(), clientContext);

    this.longRunningClient =
        new HttpJsonLongRunningClient<GetGlobalOperationRequest, Operation>(
            getCallable,
            getMethodDescriptor.getOperationSnapshotFactory(),
            getMethodDescriptor.getPollingRequestFactory());
    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(waitMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListGlobalOperationsRequest, OperationAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListGlobalOperationsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteGlobalOperationRequest, DeleteGlobalOperationResponse>
      deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetGlobalOperationRequest, Operation> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListGlobalOperationsRequest, OperationList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalOperationsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<WaitGlobalOperationRequest, Operation> waitCallable() {
    return waitCallable;
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
