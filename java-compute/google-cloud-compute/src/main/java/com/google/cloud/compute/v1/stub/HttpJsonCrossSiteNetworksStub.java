/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.compute.v1.CrossSiteNetworksClient.ListPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.CrossSiteNetwork;
import com.google.cloud.compute.v1.CrossSiteNetworkList;
import com.google.cloud.compute.v1.DeleteCrossSiteNetworkRequest;
import com.google.cloud.compute.v1.GetCrossSiteNetworkRequest;
import com.google.cloud.compute.v1.InsertCrossSiteNetworkRequest;
import com.google.cloud.compute.v1.ListCrossSiteNetworksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchCrossSiteNetworkRequest;
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
 * REST stub implementation for the CrossSiteNetworks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCrossSiteNetworksStub extends CrossSiteNetworksStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteCrossSiteNetworkRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteCrossSiteNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.CrossSiteNetworks/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCrossSiteNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCrossSiteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCrossSiteNetworkRequest> serializer =
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
                  (DeleteCrossSiteNetworkRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetCrossSiteNetworkRequest, CrossSiteNetwork>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetCrossSiteNetworkRequest, CrossSiteNetwork>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.CrossSiteNetworks/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCrossSiteNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCrossSiteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCrossSiteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CrossSiteNetwork>newBuilder()
                      .setDefaultInstance(CrossSiteNetwork.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertCrossSiteNetworkRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertCrossSiteNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.CrossSiteNetworks/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertCrossSiteNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertCrossSiteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertCrossSiteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
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
                                      "crossSiteNetworkResource",
                                      request.getCrossSiteNetworkResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertCrossSiteNetworkRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListCrossSiteNetworksRequest, CrossSiteNetworkList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListCrossSiteNetworksRequest, CrossSiteNetworkList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.CrossSiteNetworks/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCrossSiteNetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCrossSiteNetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCrossSiteNetworksRequest> serializer =
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
                  ProtoMessageResponseParser.<CrossSiteNetworkList>newBuilder()
                      .setDefaultInstance(CrossSiteNetworkList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchCrossSiteNetworkRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchCrossSiteNetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.CrossSiteNetworks/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchCrossSiteNetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchCrossSiteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchCrossSiteNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasUpdateMask()) {
                              serializer.putQueryParam(
                                  fields, "updateMask", request.getUpdateMask());
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
                                      "crossSiteNetworkResource",
                                      request.getCrossSiteNetworkResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchCrossSiteNetworkRequest request, Operation response) -> {
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

  private final UnaryCallable<DeleteCrossSiteNetworkRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteCrossSiteNetworkRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetCrossSiteNetworkRequest, CrossSiteNetwork> getCallable;
  private final UnaryCallable<InsertCrossSiteNetworkRequest, Operation> insertCallable;
  private final OperationCallable<InsertCrossSiteNetworkRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListCrossSiteNetworksRequest, CrossSiteNetworkList> listCallable;
  private final UnaryCallable<ListCrossSiteNetworksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchCrossSiteNetworkRequest, Operation> patchCallable;
  private final OperationCallable<PatchCrossSiteNetworkRequest, Operation, Operation>
      patchOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCrossSiteNetworksStub create(CrossSiteNetworksStubSettings settings)
      throws IOException {
    return new HttpJsonCrossSiteNetworksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCrossSiteNetworksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCrossSiteNetworksStub(
        CrossSiteNetworksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCrossSiteNetworksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCrossSiteNetworksStub(
        CrossSiteNetworksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCrossSiteNetworksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCrossSiteNetworksStub(
      CrossSiteNetworksStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCrossSiteNetworksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCrossSiteNetworksStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCrossSiteNetworksStub(
      CrossSiteNetworksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteCrossSiteNetworkRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteCrossSiteNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetCrossSiteNetworkRequest, CrossSiteNetwork> getTransportSettings =
        HttpJsonCallSettings.<GetCrossSiteNetworkRequest, CrossSiteNetwork>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<InsertCrossSiteNetworkRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertCrossSiteNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCrossSiteNetworksRequest, CrossSiteNetworkList> listTransportSettings =
        HttpJsonCallSettings.<ListCrossSiteNetworksRequest, CrossSiteNetworkList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PatchCrossSiteNetworkRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchCrossSiteNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteCrossSiteNetworkRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteCrossSiteNetworkRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetCrossSiteNetworkRequest, CrossSiteNetwork> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertCrossSiteNetworkRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertCrossSiteNetworkRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListCrossSiteNetworksRequest, CrossSiteNetworkList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListCrossSiteNetworksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchCrossSiteNetworkRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchCrossSiteNetworkRequest, Operation, Operation>
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
