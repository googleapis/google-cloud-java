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

import static com.google.cloud.compute.v1.NetworkEdgeSecurityServicesClient.AggregatedListPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListNetworkEdgeSecurityServicesRequest;
import com.google.cloud.compute.v1.DeleteNetworkEdgeSecurityServiceRequest;
import com.google.cloud.compute.v1.GetNetworkEdgeSecurityServiceRequest;
import com.google.cloud.compute.v1.InsertNetworkEdgeSecurityServiceRequest;
import com.google.cloud.compute.v1.NetworkEdgeSecurityService;
import com.google.cloud.compute.v1.NetworkEdgeSecurityServiceAggregatedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchNetworkEdgeSecurityServiceRequest;
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
 * REST stub implementation for the NetworkEdgeSecurityServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonNetworkEdgeSecurityServicesStub extends NetworkEdgeSecurityServicesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListNetworkEdgeSecurityServicesRequest,
                  NetworkEdgeSecurityServiceAggregatedList>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkEdgeSecurityServices/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListNetworkEdgeSecurityServicesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/networkEdgeSecurityServices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNetworkEdgeSecurityServicesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNetworkEdgeSecurityServicesRequest>
                                serializer = ProtoRestSerializer.create();
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
                  ProtoMessageResponseParser.<NetworkEdgeSecurityServiceAggregatedList>newBuilder()
                      .setDefaultInstance(
                          NetworkEdgeSecurityServiceAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNetworkEdgeSecurityServiceRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteNetworkEdgeSecurityServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEdgeSecurityServices/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNetworkEdgeSecurityServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEdgeSecurityServices/{networkEdgeSecurityService}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkEdgeSecurityServiceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "networkEdgeSecurityService",
                                request.getNetworkEdgeSecurityService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkEdgeSecurityServiceRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (DeleteNetworkEdgeSecurityServiceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEdgeSecurityServices/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNetworkEdgeSecurityServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEdgeSecurityServices/{networkEdgeSecurityService}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkEdgeSecurityServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "networkEdgeSecurityService",
                                request.getNetworkEdgeSecurityService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkEdgeSecurityServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkEdgeSecurityService>newBuilder()
                      .setDefaultInstance(NetworkEdgeSecurityService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertNetworkEdgeSecurityServiceRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertNetworkEdgeSecurityServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEdgeSecurityServices/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertNetworkEdgeSecurityServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEdgeSecurityServices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNetworkEdgeSecurityServiceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNetworkEdgeSecurityServiceRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasValidateOnly()) {
                              serializer.putQueryParam(
                                  fields, "validateOnly", request.getValidateOnly());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "networkEdgeSecurityServiceResource",
                                      request.getNetworkEdgeSecurityServiceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertNetworkEdgeSecurityServiceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<PatchNetworkEdgeSecurityServiceRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchNetworkEdgeSecurityServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkEdgeSecurityServices/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchNetworkEdgeSecurityServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/networkEdgeSecurityServices/{networkEdgeSecurityService}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchNetworkEdgeSecurityServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "networkEdgeSecurityService",
                                request.getNetworkEdgeSecurityService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchNetworkEdgeSecurityServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPaths()) {
                              serializer.putQueryParam(fields, "paths", request.getPaths());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasUpdateMask()) {
                              serializer.putQueryParam(
                                  fields, "updateMask", request.getUpdateMask());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "networkEdgeSecurityServiceResource",
                                      request.getNetworkEdgeSecurityServiceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchNetworkEdgeSecurityServiceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListNetworkEdgeSecurityServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
      getCallable;
  private final UnaryCallable<InsertNetworkEdgeSecurityServiceRequest, Operation> insertCallable;
  private final OperationCallable<InsertNetworkEdgeSecurityServiceRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<PatchNetworkEdgeSecurityServiceRequest, Operation> patchCallable;
  private final OperationCallable<PatchNetworkEdgeSecurityServiceRequest, Operation, Operation>
      patchOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNetworkEdgeSecurityServicesStub create(
      NetworkEdgeSecurityServicesStubSettings settings) throws IOException {
    return new HttpJsonNetworkEdgeSecurityServicesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetworkEdgeSecurityServicesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNetworkEdgeSecurityServicesStub(
        NetworkEdgeSecurityServicesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNetworkEdgeSecurityServicesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetworkEdgeSecurityServicesStub(
        NetworkEdgeSecurityServicesStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetworkEdgeSecurityServicesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonNetworkEdgeSecurityServicesStub(
      NetworkEdgeSecurityServicesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNetworkEdgeSecurityServicesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetworkEdgeSecurityServicesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonNetworkEdgeSecurityServicesStub(
      NetworkEdgeSecurityServicesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<
            AggregatedListNetworkEdgeSecurityServicesRequest,
            NetworkEdgeSecurityServiceAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNetworkEdgeSecurityServicesRequest,
                    NetworkEdgeSecurityServiceAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteNetworkEdgeSecurityServiceRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteNetworkEdgeSecurityServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertNetworkEdgeSecurityServiceRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertNetworkEdgeSecurityServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchNetworkEdgeSecurityServiceRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchNetworkEdgeSecurityServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
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
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<
          AggregatedListNetworkEdgeSecurityServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkEdgeSecurityServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
      getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertNetworkEdgeSecurityServiceRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertNetworkEdgeSecurityServiceRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<PatchNetworkEdgeSecurityServiceRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchNetworkEdgeSecurityServiceRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
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
