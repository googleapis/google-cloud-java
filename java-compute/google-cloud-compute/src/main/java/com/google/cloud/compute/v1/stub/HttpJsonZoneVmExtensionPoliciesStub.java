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

import static com.google.cloud.compute.v1.ZoneVmExtensionPoliciesClient.ListPagedResponse;

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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.DeleteZoneVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.GetZoneVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.InsertZoneVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.ListZoneVmExtensionPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.UpdateZoneVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.VmExtensionPolicy;
import com.google.cloud.compute.v1.VmExtensionPolicyList;
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
 * REST stub implementation for the ZoneVmExtensionPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonZoneVmExtensionPoliciesStub extends ZoneVmExtensionPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteZoneVmExtensionPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteZoneVmExtensionPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneVmExtensionPolicies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteZoneVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/vmExtensionPolicies/{vmExtensionPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteZoneVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "vmExtensionPolicy", request.getVmExtensionPolicy());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteZoneVmExtensionPolicyRequest> serializer =
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
                  (DeleteZoneVmExtensionPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetZoneVmExtensionPolicyRequest, VmExtensionPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetZoneVmExtensionPolicyRequest, VmExtensionPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneVmExtensionPolicies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetZoneVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/vmExtensionPolicies/{vmExtensionPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetZoneVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "vmExtensionPolicy", request.getVmExtensionPolicy());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetZoneVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VmExtensionPolicy>newBuilder()
                      .setDefaultInstance(VmExtensionPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertZoneVmExtensionPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertZoneVmExtensionPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneVmExtensionPolicies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertZoneVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/vmExtensionPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertZoneVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertZoneVmExtensionPolicyRequest> serializer =
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
                                      "vmExtensionPolicyResource",
                                      request.getVmExtensionPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertZoneVmExtensionPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
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
          ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneVmExtensionPolicies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListZoneVmExtensionPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/vmExtensionPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListZoneVmExtensionPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListZoneVmExtensionPoliciesRequest> serializer =
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
                  ProtoMessageResponseParser.<VmExtensionPolicyList>newBuilder()
                      .setDefaultInstance(VmExtensionPolicyList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateZoneVmExtensionPolicyRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateZoneVmExtensionPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ZoneVmExtensionPolicies/Update")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateZoneVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/vmExtensionPolicies/{vmExtensionPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateZoneVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "vmExtensionPolicy", request.getVmExtensionPolicy());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateZoneVmExtensionPolicyRequest> serializer =
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
                                      "vmExtensionPolicyResource",
                                      request.getVmExtensionPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateZoneVmExtensionPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<DeleteZoneVmExtensionPolicyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteZoneVmExtensionPolicyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetZoneVmExtensionPolicyRequest, VmExtensionPolicy> getCallable;
  private final UnaryCallable<InsertZoneVmExtensionPolicyRequest, Operation> insertCallable;
  private final OperationCallable<InsertZoneVmExtensionPolicyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList>
      listCallable;
  private final UnaryCallable<ListZoneVmExtensionPoliciesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<UpdateZoneVmExtensionPolicyRequest, Operation> updateCallable;
  private final OperationCallable<UpdateZoneVmExtensionPolicyRequest, Operation, Operation>
      updateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/zones/{zone}/vmExtensionPolicies/{vm_extension_policy}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/zones/{zone}/vmExtensionPolicies/{vm_extension_policy}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/zones/{zone}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/zones/{zone}");
  private static final PathTemplate UPDATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/zones/{zone}/vmExtensionPolicies/{vm_extension_policy}");

  public static final HttpJsonZoneVmExtensionPoliciesStub create(
      ZoneVmExtensionPoliciesStubSettings settings) throws IOException {
    return new HttpJsonZoneVmExtensionPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonZoneVmExtensionPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonZoneVmExtensionPoliciesStub(
        ZoneVmExtensionPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonZoneVmExtensionPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonZoneVmExtensionPoliciesStub(
        ZoneVmExtensionPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonZoneVmExtensionPoliciesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonZoneVmExtensionPoliciesStub(
      ZoneVmExtensionPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonZoneVmExtensionPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonZoneVmExtensionPoliciesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonZoneVmExtensionPoliciesStub(
      ZoneVmExtensionPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteZoneVmExtensionPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteZoneVmExtensionPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add(
                      "vm_extension_policy", String.valueOf(request.getVmExtensionPolicy()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put(
                      "vm_extension_policy", String.valueOf(request.getVmExtensionPolicy()));
                  resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<GetZoneVmExtensionPolicyRequest, VmExtensionPolicy> getTransportSettings =
        HttpJsonCallSettings.<GetZoneVmExtensionPolicyRequest, VmExtensionPolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add(
                      "vm_extension_policy", String.valueOf(request.getVmExtensionPolicy()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put(
                      "vm_extension_policy", String.valueOf(request.getVmExtensionPolicy()));
                  resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<InsertZoneVmExtensionPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertZoneVmExtensionPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                  return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                      return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<UpdateZoneVmExtensionPolicyRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateZoneVmExtensionPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add(
                      "vm_extension_policy", String.valueOf(request.getVmExtensionPolicy()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put(
                      "vm_extension_policy", String.valueOf(request.getVmExtensionPolicy()));
                  resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                  return UPDATE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteZoneVmExtensionPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteZoneVmExtensionPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetZoneVmExtensionPolicyRequest, VmExtensionPolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertZoneVmExtensionPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertZoneVmExtensionPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListZoneVmExtensionPoliciesRequest, VmExtensionPolicyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListZoneVmExtensionPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateZoneVmExtensionPolicyRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateZoneVmExtensionPolicyRequest, Operation, Operation>
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
