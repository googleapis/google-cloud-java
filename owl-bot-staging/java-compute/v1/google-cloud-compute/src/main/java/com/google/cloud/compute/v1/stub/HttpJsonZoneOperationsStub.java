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

import static com.google.cloud.compute.v1.ZoneOperationsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteZoneOperationRequest;
import com.google.cloud.compute.v1.DeleteZoneOperationResponse;
import com.google.cloud.compute.v1.GetZoneOperationRequest;
import com.google.cloud.compute.v1.ListZoneOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.WaitZoneOperationRequest;
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
 * REST stub implementation for the ZoneOperations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonZoneOperationsStub extends ZoneOperationsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<DeleteZoneOperationRequest, DeleteZoneOperationResponse>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteZoneOperationRequest, DeleteZoneOperationResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneOperations/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteZoneOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/operations/{operation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteZoneOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteZoneOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteZoneOperationResponse>newBuilder()
                      .setDefaultInstance(DeleteZoneOperationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetZoneOperationRequest, Operation> getMethodDescriptor =
      ApiMethodDescriptor.<GetZoneOperationRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.ZoneOperations/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetZoneOperationRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/operations/{operation}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetZoneOperationRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "operation", request.getOperation());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetZoneOperationRequest> serializer =
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
              (GetZoneOperationRequest request, Operation response) -> {
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
                return GetZoneOperationRequest.newBuilder()
                    .setOperation(idComponents.get(0))
                    .setProject(idComponents.get(1))
                    .setZone(idComponents.get(2))
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<ListZoneOperationsRequest, OperationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListZoneOperationsRequest, OperationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneOperations/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListZoneOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/operations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListZoneOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListZoneOperationsRequest> serializer =
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

  private static final ApiMethodDescriptor<WaitZoneOperationRequest, Operation>
      waitMethodDescriptor =
          ApiMethodDescriptor.<WaitZoneOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneOperations/Wait")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WaitZoneOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/operations/{operation}/wait",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<WaitZoneOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<WaitZoneOperationRequest> serializer =
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

  private final UnaryCallable<DeleteZoneOperationRequest, DeleteZoneOperationResponse>
      deleteCallable;
  private final UnaryCallable<GetZoneOperationRequest, Operation> getCallable;
  private final UnaryCallable<ListZoneOperationsRequest, OperationList> listCallable;
  private final UnaryCallable<ListZoneOperationsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<WaitZoneOperationRequest, Operation> waitCallable;

  private final BackgroundResource backgroundResources;
  private final LongRunningClient longRunningClient;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonZoneOperationsStub create(ZoneOperationsStubSettings settings)
      throws IOException {
    return new HttpJsonZoneOperationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonZoneOperationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonZoneOperationsStub(
        ZoneOperationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonZoneOperationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonZoneOperationsStub(
        ZoneOperationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonZoneOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonZoneOperationsStub(
      ZoneOperationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonZoneOperationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonZoneOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonZoneOperationsStub(
      ZoneOperationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteZoneOperationRequest, DeleteZoneOperationResponse>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteZoneOperationRequest, DeleteZoneOperationResponse>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetZoneOperationRequest, Operation> getTransportSettings =
        HttpJsonCallSettings.<GetZoneOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListZoneOperationsRequest, OperationList> listTransportSettings =
        HttpJsonCallSettings.<ListZoneOperationsRequest, OperationList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<WaitZoneOperationRequest, Operation> waitTransportSettings =
        HttpJsonCallSettings.<WaitZoneOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(waitMethodDescriptor)
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
    this.waitCallable =
        callableFactory.createUnaryCallable(
            waitTransportSettings, settings.waitSettings(), clientContext);

    this.longRunningClient =
        new HttpJsonLongRunningClient<GetZoneOperationRequest, Operation>(
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
    methodDescriptors.add(waitMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteZoneOperationRequest, DeleteZoneOperationResponse> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetZoneOperationRequest, Operation> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListZoneOperationsRequest, OperationList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListZoneOperationsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<WaitZoneOperationRequest, Operation> waitCallable() {
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
