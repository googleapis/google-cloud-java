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

import static com.google.cloud.compute.v1.GlobalVmExtensionPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.GlobalVmExtensionPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListGlobalVmExtensionPoliciesRequest;
import com.google.cloud.compute.v1.DeleteGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.GetGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.GlobalVmExtensionPolicy;
import com.google.cloud.compute.v1.GlobalVmExtensionPolicyList;
import com.google.cloud.compute.v1.InsertGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.ListGlobalVmExtensionPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.UpdateGlobalVmExtensionPolicyRequest;
import com.google.cloud.compute.v1.VmExtensionPolicyAggregatedListResponse;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GlobalVmExtensionPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonGlobalVmExtensionPoliciesStub extends GlobalVmExtensionPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListGlobalVmExtensionPoliciesRequest, VmExtensionPolicyAggregatedListResponse>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListGlobalVmExtensionPoliciesRequest,
                  VmExtensionPolicyAggregatedListResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalVmExtensionPolicies/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListGlobalVmExtensionPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/vmExtensionPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListGlobalVmExtensionPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListGlobalVmExtensionPoliciesRequest>
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
                            if (request.hasServiceProjectNumber()) {
                              serializer.putQueryParam(
                                  fields,
                                  "serviceProjectNumber",
                                  request.getServiceProjectNumber());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VmExtensionPolicyAggregatedListResponse>newBuilder()
                      .setDefaultInstance(
                          VmExtensionPolicyAggregatedListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGlobalVmExtensionPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalVmExtensionPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalVmExtensionPolicies/Delete")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlobalVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/vmExtensionPolicies/{globalVmExtensionPolicy}/delete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "globalVmExtensionPolicy",
                                request.getGlobalVmExtensionPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalVmExtensionPolicyRequest> serializer =
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
                                      "globalVmExtensionPolicyRolloutOperationRolloutInputResource",
                                      request
                                          .getGlobalVmExtensionPolicyRolloutOperationRolloutInputResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteGlobalVmExtensionPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<
          GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalVmExtensionPolicies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/vmExtensionPolicies/{globalVmExtensionPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "globalVmExtensionPolicy",
                                request.getGlobalVmExtensionPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlobalVmExtensionPolicy>newBuilder()
                      .setDefaultInstance(GlobalVmExtensionPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertGlobalVmExtensionPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalVmExtensionPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalVmExtensionPolicies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertGlobalVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/vmExtensionPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalVmExtensionPolicyRequest> serializer =
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
                                      "globalVmExtensionPolicyResource",
                                      request.getGlobalVmExtensionPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertGlobalVmExtensionPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<
          ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalVmExtensionPolicies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalVmExtensionPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/vmExtensionPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalVmExtensionPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalVmExtensionPoliciesRequest> serializer =
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
                  ProtoMessageResponseParser.<GlobalVmExtensionPolicyList>newBuilder()
                      .setDefaultInstance(GlobalVmExtensionPolicyList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGlobalVmExtensionPolicyRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateGlobalVmExtensionPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalVmExtensionPolicies/Update")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGlobalVmExtensionPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/vmExtensionPolicies/{globalVmExtensionPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlobalVmExtensionPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "globalVmExtensionPolicy",
                                request.getGlobalVmExtensionPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlobalVmExtensionPolicyRequest> serializer =
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
                                      "globalVmExtensionPolicyResource",
                                      request.getGlobalVmExtensionPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGlobalVmExtensionPolicyRequest request, Operation response) -> {
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

  private final UnaryCallable<
          AggregatedListGlobalVmExtensionPoliciesRequest, VmExtensionPolicyAggregatedListResponse>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListGlobalVmExtensionPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteGlobalVmExtensionPolicyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteGlobalVmExtensionPolicyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy>
      getCallable;
  private final UnaryCallable<InsertGlobalVmExtensionPolicyRequest, Operation> insertCallable;
  private final OperationCallable<InsertGlobalVmExtensionPolicyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>
      listCallable;
  private final UnaryCallable<ListGlobalVmExtensionPoliciesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<UpdateGlobalVmExtensionPolicyRequest, Operation> updateCallable;
  private final OperationCallable<UpdateGlobalVmExtensionPolicyRequest, Operation, Operation>
      updateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate AGGREGATED_LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/global/vmExtensionPolicies/{global_vm_extension_policy}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/global/vmExtensionPolicies/{global_vm_extension_policy}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate UPDATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/global/vmExtensionPolicies/{global_vm_extension_policy}");

  public static final HttpJsonGlobalVmExtensionPoliciesStub create(
      GlobalVmExtensionPoliciesStubSettings settings) throws IOException {
    return new HttpJsonGlobalVmExtensionPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalVmExtensionPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalVmExtensionPoliciesStub(
        GlobalVmExtensionPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalVmExtensionPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalVmExtensionPoliciesStub(
        GlobalVmExtensionPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalVmExtensionPoliciesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalVmExtensionPoliciesStub(
      GlobalVmExtensionPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalVmExtensionPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalVmExtensionPoliciesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalVmExtensionPoliciesStub(
      GlobalVmExtensionPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<
            AggregatedListGlobalVmExtensionPoliciesRequest, VmExtensionPolicyAggregatedListResponse>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListGlobalVmExtensionPoliciesRequest,
                    VmExtensionPolicyAggregatedListResponse>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return AGGREGATED_LIST_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<DeleteGlobalVmExtensionPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteGlobalVmExtensionPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "global_vm_extension_policy",
                      String.valueOf(request.getGlobalVmExtensionPolicy()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put(
                      "global_vm_extension_policy",
                      String.valueOf(request.getGlobalVmExtensionPolicy()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "global_vm_extension_policy",
                          String.valueOf(request.getGlobalVmExtensionPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "global_vm_extension_policy",
                          String.valueOf(request.getGlobalVmExtensionPolicy()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<InsertGlobalVmExtensionPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertGlobalVmExtensionPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<UpdateGlobalVmExtensionPolicyRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateGlobalVmExtensionPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "global_vm_extension_policy",
                      String.valueOf(request.getGlobalVmExtensionPolicy()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put(
                      "global_vm_extension_policy",
                      String.valueOf(request.getGlobalVmExtensionPolicy()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return UPDATE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
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
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          AggregatedListGlobalVmExtensionPoliciesRequest, VmExtensionPolicyAggregatedListResponse>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListGlobalVmExtensionPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteGlobalVmExtensionPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteGlobalVmExtensionPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertGlobalVmExtensionPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertGlobalVmExtensionPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalVmExtensionPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateGlobalVmExtensionPolicyRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateGlobalVmExtensionPolicyRequest, Operation, Operation>
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
