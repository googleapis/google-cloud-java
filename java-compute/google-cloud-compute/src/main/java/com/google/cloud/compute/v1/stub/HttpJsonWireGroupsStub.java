/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.compute.v1.WireGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteWireGroupRequest;
import com.google.cloud.compute.v1.GetWireGroupRequest;
import com.google.cloud.compute.v1.InsertWireGroupRequest;
import com.google.cloud.compute.v1.ListWireGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchWireGroupRequest;
import com.google.cloud.compute.v1.WireGroup;
import com.google.cloud.compute.v1.WireGroupList;
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
 * REST stub implementation for the WireGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonWireGroupsStub extends WireGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteWireGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteWireGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.WireGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWireGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}/wireGroups/{wireGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWireGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "wireGroup", request.getWireGroup());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWireGroupRequest> serializer =
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
                  (DeleteWireGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetWireGroupRequest, WireGroup> getMethodDescriptor =
      ApiMethodDescriptor.<GetWireGroupRequest, WireGroup>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.WireGroups/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetWireGroupRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}/wireGroups/{wireGroup}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetWireGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(
                            fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "wireGroup", request.getWireGroup());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetWireGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<WireGroup>newBuilder()
                  .setDefaultInstance(WireGroup.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertWireGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertWireGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.WireGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertWireGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}/wireGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertWireGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertWireGroupRequest> serializer =
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
                                      "wireGroupResource", request.getWireGroupResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertWireGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListWireGroupsRequest, WireGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListWireGroupsRequest, WireGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.WireGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWireGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}/wireGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWireGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWireGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<WireGroupList>newBuilder()
                      .setDefaultInstance(WireGroupList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchWireGroupRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchWireGroupRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.WireGroups/Patch")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchWireGroupRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/crossSiteNetworks/{crossSiteNetwork}/wireGroups/{wireGroup}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PatchWireGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(
                            fields, "crossSiteNetwork", request.getCrossSiteNetwork());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "wireGroup", request.getWireGroup());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PatchWireGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        if (request.hasUpdateMask()) {
                          serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
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
                              .toBody("wireGroupResource", request.getWireGroupResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (PatchWireGroupRequest request, Operation response) -> {
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

  private final UnaryCallable<DeleteWireGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteWireGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetWireGroupRequest, WireGroup> getCallable;
  private final UnaryCallable<InsertWireGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertWireGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListWireGroupsRequest, WireGroupList> listCallable;
  private final UnaryCallable<ListWireGroupsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchWireGroupRequest, Operation> patchCallable;
  private final OperationCallable<PatchWireGroupRequest, Operation, Operation>
      patchOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWireGroupsStub create(WireGroupsStubSettings settings)
      throws IOException {
    return new HttpJsonWireGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWireGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWireGroupsStub(WireGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonWireGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWireGroupsStub(
        WireGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWireGroupsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWireGroupsStub(WireGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonWireGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWireGroupsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWireGroupsStub(
      WireGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteWireGroupRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteWireGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("wire_group", String.valueOf(request.getWireGroup()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetWireGroupRequest, WireGroup> getTransportSettings =
        HttpJsonCallSettings.<GetWireGroupRequest, WireGroup>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("wire_group", String.valueOf(request.getWireGroup()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<InsertWireGroupRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertWireGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListWireGroupsRequest, WireGroupList> listTransportSettings =
        HttpJsonCallSettings.<ListWireGroupsRequest, WireGroupList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PatchWireGroupRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchWireGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cross_site_network", String.valueOf(request.getCrossSiteNetwork()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("wire_group", String.valueOf(request.getWireGroup()));
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
  public UnaryCallable<DeleteWireGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteWireGroupRequest, Operation, Operation> deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetWireGroupRequest, WireGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertWireGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertWireGroupRequest, Operation, Operation> insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListWireGroupsRequest, WireGroupList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListWireGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchWireGroupRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchWireGroupRequest, Operation, Operation> patchOperationCallable() {
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
