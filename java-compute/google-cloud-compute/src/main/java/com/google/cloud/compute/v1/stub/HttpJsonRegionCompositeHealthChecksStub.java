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

import static com.google.cloud.compute.v1.RegionCompositeHealthChecksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RegionCompositeHealthChecksClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRegionCompositeHealthChecksRequest;
import com.google.cloud.compute.v1.CompositeHealthCheck;
import com.google.cloud.compute.v1.CompositeHealthCheckAggregatedList;
import com.google.cloud.compute.v1.CompositeHealthCheckHealth;
import com.google.cloud.compute.v1.CompositeHealthCheckList;
import com.google.cloud.compute.v1.DeleteRegionCompositeHealthCheckRequest;
import com.google.cloud.compute.v1.GetHealthRegionCompositeHealthCheckRequest;
import com.google.cloud.compute.v1.GetRegionCompositeHealthCheckRequest;
import com.google.cloud.compute.v1.InsertRegionCompositeHealthCheckRequest;
import com.google.cloud.compute.v1.ListRegionCompositeHealthChecksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchRegionCompositeHealthCheckRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionCompositeHealthCheckRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
 * REST stub implementation for the RegionCompositeHealthChecks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonRegionCompositeHealthChecksStub extends RegionCompositeHealthChecksStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListRegionCompositeHealthChecksRequest, CompositeHealthCheckAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListRegionCompositeHealthChecksRequest,
                  CompositeHealthCheckAggregatedList>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionCompositeHealthChecks/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListRegionCompositeHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/compositeHealthChecks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListRegionCompositeHealthChecksRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListRegionCompositeHealthChecksRequest>
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
                  ProtoMessageResponseParser.<CompositeHealthCheckAggregatedList>newBuilder()
                      .setDefaultInstance(CompositeHealthCheckAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRegionCompositeHealthCheckRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionCompositeHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCompositeHealthChecks/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionCompositeHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/compositeHealthChecks/{compositeHealthCheck}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionCompositeHealthCheckRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "compositeHealthCheck", request.getCompositeHealthCheck());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionCompositeHealthCheckRequest>
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
                  (DeleteRegionCompositeHealthCheckRequest request, Operation response) -> {
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
          GetRegionCompositeHealthCheckRequest, CompositeHealthCheck>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionCompositeHealthCheckRequest, CompositeHealthCheck>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCompositeHealthChecks/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionCompositeHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/compositeHealthChecks/{compositeHealthCheck}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionCompositeHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "compositeHealthCheck", request.getCompositeHealthCheck());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionCompositeHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompositeHealthCheck>newBuilder()
                      .setDefaultInstance(CompositeHealthCheck.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetHealthRegionCompositeHealthCheckRequest, CompositeHealthCheckHealth>
      getHealthMethodDescriptor =
          ApiMethodDescriptor
              .<GetHealthRegionCompositeHealthCheckRequest, CompositeHealthCheckHealth>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCompositeHealthChecks/GetHealth")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetHealthRegionCompositeHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/compositeHealthChecks/{compositeHealthCheck}/getHealth",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHealthRegionCompositeHealthCheckRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "compositeHealthCheck", request.getCompositeHealthCheck());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHealthRegionCompositeHealthCheckRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompositeHealthCheckHealth>newBuilder()
                      .setDefaultInstance(CompositeHealthCheckHealth.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionCompositeHealthCheckRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionCompositeHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCompositeHealthChecks/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionCompositeHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/compositeHealthChecks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionCompositeHealthCheckRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionCompositeHealthCheckRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "compositeHealthCheckResource",
                                      request.getCompositeHealthCheckResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertRegionCompositeHealthCheckRequest request, Operation response) -> {
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
          ListRegionCompositeHealthChecksRequest, CompositeHealthCheckList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionCompositeHealthChecksRequest, CompositeHealthCheckList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCompositeHealthChecks/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionCompositeHealthChecksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/compositeHealthChecks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionCompositeHealthChecksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionCompositeHealthChecksRequest> serializer =
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
                  ProtoMessageResponseParser.<CompositeHealthCheckList>newBuilder()
                      .setDefaultInstance(CompositeHealthCheckList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchRegionCompositeHealthCheckRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionCompositeHealthCheckRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionCompositeHealthChecks/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionCompositeHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/compositeHealthChecks/{compositeHealthCheck}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionCompositeHealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "compositeHealthCheck", request.getCompositeHealthCheck());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionCompositeHealthCheckRequest> serializer =
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
                                      "compositeHealthCheckResource",
                                      request.getCompositeHealthCheckResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchRegionCompositeHealthCheckRequest request, Operation response) -> {
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
          TestIamPermissionsRegionCompositeHealthCheckRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsRegionCompositeHealthCheckRequest, TestPermissionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionCompositeHealthChecks/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsRegionCompositeHealthCheckRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/compositeHealthChecks/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRegionCompositeHealthCheckRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRegionCompositeHealthCheckRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          AggregatedListRegionCompositeHealthChecksRequest, CompositeHealthCheckAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListRegionCompositeHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteRegionCompositeHealthCheckRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionCompositeHealthCheckRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRegionCompositeHealthCheckRequest, CompositeHealthCheck>
      getCallable;
  private final UnaryCallable<
          GetHealthRegionCompositeHealthCheckRequest, CompositeHealthCheckHealth>
      getHealthCallable;
  private final UnaryCallable<InsertRegionCompositeHealthCheckRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionCompositeHealthCheckRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionCompositeHealthChecksRequest, CompositeHealthCheckList>
      listCallable;
  private final UnaryCallable<ListRegionCompositeHealthChecksRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchRegionCompositeHealthCheckRequest, Operation> patchCallable;
  private final OperationCallable<PatchRegionCompositeHealthCheckRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<
          TestIamPermissionsRegionCompositeHealthCheckRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate AGGREGATED_LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/compositeHealthChecks/{composite_health_check}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/compositeHealthChecks/{composite_health_check}");
  private static final PathTemplate GET_HEALTH_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/compositeHealthChecks/{composite_health_check}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}");
  private static final PathTemplate PATCH_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/compositeHealthChecks/{composite_health_check}");
  private static final PathTemplate TEST_IAM_PERMISSIONS_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}/compositeHealthChecks/{resource}");

  public static final HttpJsonRegionCompositeHealthChecksStub create(
      RegionCompositeHealthChecksStubSettings settings) throws IOException {
    return new HttpJsonRegionCompositeHealthChecksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionCompositeHealthChecksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionCompositeHealthChecksStub(
        RegionCompositeHealthChecksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionCompositeHealthChecksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionCompositeHealthChecksStub(
        RegionCompositeHealthChecksStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionCompositeHealthChecksStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionCompositeHealthChecksStub(
      RegionCompositeHealthChecksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionCompositeHealthChecksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionCompositeHealthChecksStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionCompositeHealthChecksStub(
      RegionCompositeHealthChecksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<
            AggregatedListRegionCompositeHealthChecksRequest, CompositeHealthCheckAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListRegionCompositeHealthChecksRequest,
                    CompositeHealthCheckAggregatedList>
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
    HttpJsonCallSettings<DeleteRegionCompositeHealthCheckRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionCompositeHealthCheckRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "composite_health_check",
                          String.valueOf(request.getCompositeHealthCheck()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "composite_health_check",
                          String.valueOf(request.getCompositeHealthCheck()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<GetRegionCompositeHealthCheckRequest, CompositeHealthCheck>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionCompositeHealthCheckRequest, CompositeHealthCheck>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "composite_health_check",
                          String.valueOf(request.getCompositeHealthCheck()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "composite_health_check",
                          String.valueOf(request.getCompositeHealthCheck()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<GetHealthRegionCompositeHealthCheckRequest, CompositeHealthCheckHealth>
        getHealthTransportSettings =
            HttpJsonCallSettings
                .<GetHealthRegionCompositeHealthCheckRequest, CompositeHealthCheckHealth>
                    newBuilder()
                .setMethodDescriptor(getHealthMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "composite_health_check",
                          String.valueOf(request.getCompositeHealthCheck()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "composite_health_check",
                          String.valueOf(request.getCompositeHealthCheck()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return GET_HEALTH_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<InsertRegionCompositeHealthCheckRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionCompositeHealthCheckRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<ListRegionCompositeHealthChecksRequest, CompositeHealthCheckList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionCompositeHealthChecksRequest, CompositeHealthCheckList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<PatchRegionCompositeHealthCheckRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionCompositeHealthCheckRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "composite_health_check", String.valueOf(request.getCompositeHealthCheck()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put(
                      "composite_health_check", String.valueOf(request.getCompositeHealthCheck()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                  return PATCH_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<
            TestIamPermissionsRegionCompositeHealthCheckRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsRegionCompositeHealthCheckRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      resourceNameSegments.put("resource", String.valueOf(request.getResource()));
                      return TEST_IAM_PERMISSIONS_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
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
    this.getHealthCallable =
        callableFactory.createUnaryCallable(
            getHealthTransportSettings, settings.getHealthSettings(), clientContext);
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
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getHealthMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          AggregatedListRegionCompositeHealthChecksRequest, CompositeHealthCheckAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<
          AggregatedListRegionCompositeHealthChecksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionCompositeHealthCheckRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionCompositeHealthCheckRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionCompositeHealthCheckRequest, CompositeHealthCheck> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetHealthRegionCompositeHealthCheckRequest, CompositeHealthCheckHealth>
      getHealthCallable() {
    return getHealthCallable;
  }

  @Override
  public UnaryCallable<InsertRegionCompositeHealthCheckRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionCompositeHealthCheckRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionCompositeHealthChecksRequest, CompositeHealthCheckList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionCompositeHealthChecksRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionCompositeHealthCheckRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchRegionCompositeHealthCheckRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRegionCompositeHealthCheckRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
