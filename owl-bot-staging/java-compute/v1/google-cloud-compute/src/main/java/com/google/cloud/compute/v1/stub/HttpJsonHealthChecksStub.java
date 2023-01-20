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

import static com.google.cloud.compute.v1.HealthChecksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.HealthChecksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListHealthChecksRequest;
import com.google.cloud.compute.v1.DeleteHealthCheckRequest;
import com.google.cloud.compute.v1.GetHealthCheckRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.HealthChecksAggregatedList;
import com.google.cloud.compute.v1.InsertHealthCheckRequest;
import com.google.cloud.compute.v1.ListHealthChecksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchHealthCheckRequest;
import com.google.cloud.compute.v1.UpdateHealthCheckRequest;
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
 * REST stub implementation for the HealthChecks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonHealthChecksStub extends HealthChecksStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/healthChecks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListHealthChecksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListHealthChecksRequest> serializer =
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
                  ProtoMessageResponseParser.<HealthChecksAggregatedList>newBuilder()
                      .setDefaultInstance(HealthChecksAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteHealthCheckRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "healthCheck", request.getHealthCheck());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteHealthCheckRequest> serializer =
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
                  (DeleteHealthCheckRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetHealthCheckRequest, HealthCheck> getMethodDescriptor =
      ApiMethodDescriptor.<GetHealthCheckRequest, HealthCheck>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.HealthChecks/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetHealthCheckRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetHealthCheckRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "healthCheck", request.getHealthCheck());
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetHealthCheckRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<HealthCheck>newBuilder()
                  .setDefaultInstance(HealthCheck.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertHealthCheckRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "healthCheckResource",
                                      request.getHealthCheckResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertHealthCheckRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListHealthChecksRequest, HealthCheckList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListHealthChecksRequest, HealthCheckList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHealthChecksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHealthChecksRequest> serializer =
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
                  ProtoMessageResponseParser.<HealthCheckList>newBuilder()
                      .setDefaultInstance(HealthCheckList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchHealthCheckRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "healthCheck", request.getHealthCheck());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "healthCheckResource",
                                      request.getHealthCheckResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchHealthCheckRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<UpdateHealthCheckRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.HealthChecks/Update")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/healthChecks/{healthCheck}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "healthCheck", request.getHealthCheck());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "healthCheckResource",
                                      request.getHealthCheckResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateHealthCheckRequest request, Operation response) -> {
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

  private final UnaryCallable<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteHealthCheckRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteHealthCheckRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetHealthCheckRequest, HealthCheck> getCallable;
  private final UnaryCallable<InsertHealthCheckRequest, Operation> insertCallable;
  private final OperationCallable<InsertHealthCheckRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListHealthChecksRequest, HealthCheckList> listCallable;
  private final UnaryCallable<ListHealthChecksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchHealthCheckRequest, Operation> patchCallable;
  private final OperationCallable<PatchHealthCheckRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<UpdateHealthCheckRequest, Operation> updateCallable;
  private final OperationCallable<UpdateHealthCheckRequest, Operation, Operation>
      updateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHealthChecksStub create(HealthChecksStubSettings settings)
      throws IOException {
    return new HttpJsonHealthChecksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHealthChecksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHealthChecksStub(
        HealthChecksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHealthChecksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHealthChecksStub(
        HealthChecksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHealthChecksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHealthChecksStub(HealthChecksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonHealthChecksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHealthChecksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHealthChecksStub(
      HealthChecksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteHealthCheckRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetHealthCheckRequest, HealthCheck> getTransportSettings =
        HttpJsonCallSettings.<GetHealthCheckRequest, HealthCheck>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertHealthCheckRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListHealthChecksRequest, HealthCheckList> listTransportSettings =
        HttpJsonCallSettings.<ListHealthChecksRequest, HealthCheckList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchHealthCheckRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateHealthCheckRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
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
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.updateOperationCallable =
        callableFactory.createOperationCallable(
            updateTransportSettings,
            settings.updateOperationSettings(),
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
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListHealthChecksRequest, HealthChecksAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteHealthCheckRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteHealthCheckRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetHealthCheckRequest, HealthCheck> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertHealthCheckRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertHealthCheckRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListHealthChecksRequest, HealthCheckList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListHealthChecksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchHealthCheckRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchHealthCheckRequest, Operation, Operation> patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateHealthCheckRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateHealthCheckRequest, Operation, Operation>
      updateOperationCallable() {
    return updateOperationCallable;
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
