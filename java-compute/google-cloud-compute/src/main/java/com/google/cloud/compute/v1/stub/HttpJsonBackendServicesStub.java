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

import static com.google.cloud.compute.v1.BackendServicesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.BackendServicesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.AggregatedListBackendServicesRequest;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceAggregatedList;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteBackendServiceRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.GetBackendServiceRequest;
import com.google.cloud.compute.v1.GetHealthBackendServiceRequest;
import com.google.cloud.compute.v1.GetIamPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.InsertBackendServiceRequest;
import com.google.cloud.compute.v1.ListBackendServicesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchBackendServiceRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetEdgeSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.SetIamPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.SetSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.UpdateBackendServiceRequest;
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
 * REST stub implementation for the BackendServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonBackendServicesStub extends BackendServicesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<AddSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/AddSignedUrlKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddSignedUrlKeyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/addSignedUrlKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddSignedUrlKeyBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddSignedUrlKeyBackendServiceRequest> serializer =
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
                                      "signedUrlKeyResource",
                                      request.getSignedUrlKeyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddSignedUrlKeyBackendServiceRequest request, Operation response) -> {
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
          AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListBackendServicesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/backendServices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListBackendServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListBackendServicesRequest> serializer =
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
                  ProtoMessageResponseParser.<BackendServiceAggregatedList>newBuilder()
                      .setDefaultInstance(BackendServiceAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBackendServiceRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackendServiceRequest> serializer =
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
                  (DeleteBackendServiceRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/DeleteSignedUrlKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSignedUrlKeyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/deleteSignedUrlKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSignedUrlKeyBackendServiceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSignedUrlKeyBackendServiceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "keyName", request.getKeyName());
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
                  (DeleteSignedUrlKeyBackendServiceRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetBackendServiceRequest, BackendService>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetBackendServiceRequest, BackendService>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendService>newBuilder()
                      .setDefaultInstance(BackendService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthMethodDescriptor =
          ApiMethodDescriptor
              .<GetHealthBackendServiceRequest, BackendServiceGroupHealth>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/GetHealth")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHealthBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/getHealth",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHealthBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHealthBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "resourceGroupReferenceResource",
                                      request.getResourceGroupReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendServiceGroupHealth>newBuilder()
                      .setDefaultInstance(BackendServiceGroupHealth.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyBackendServiceRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyBackendServiceRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasOptionsRequestedPolicyVersion()) {
                              serializer.putQueryParam(
                                  fields,
                                  "optionsRequestedPolicyVersion",
                                  request.getOptionsRequestedPolicyVersion());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertBackendServiceRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertBackendServiceRequest> serializer =
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
                                      "backendServiceResource",
                                      request.getBackendServiceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertBackendServiceRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListBackendServicesRequest, BackendServiceList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListBackendServicesRequest, BackendServiceList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackendServicesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackendServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackendServicesRequest> serializer =
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
                  ProtoMessageResponseParser.<BackendServiceList>newBuilder()
                      .setDefaultInstance(BackendServiceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchBackendServiceRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchBackendServiceRequest> serializer =
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
                                      "backendServiceResource",
                                      request.getBackendServiceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchBackendServiceRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
      setEdgeSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetEdgeSecurityPolicyBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/SetEdgeSecurityPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetEdgeSecurityPolicyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/setEdgeSecurityPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetEdgeSecurityPolicyBackendServiceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetEdgeSecurityPolicyBackendServiceRequest>
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
                                      "securityPolicyReferenceResource",
                                      request.getSecurityPolicyReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetEdgeSecurityPolicyBackendServiceRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetIamPolicyBackendServiceRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyBackendServiceRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetPolicyRequestResource",
                                      request.getGlobalSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetSecurityPolicyBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/SetSecurityPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSecurityPolicyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/setSecurityPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSecurityPolicyBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSecurityPolicyBackendServiceRequest> serializer =
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
                                      "securityPolicyReferenceResource",
                                      request.getSecurityPolicyReferenceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetSecurityPolicyBackendServiceRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<UpdateBackendServiceRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Update")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackendServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendService", request.getBackendService());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackendServiceRequest> serializer =
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
                                      "backendServiceResource",
                                      request.getBackendServiceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBackendServiceRequest request, Operation response) -> {
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

  private final UnaryCallable<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeyCallable;
  private final OperationCallable<AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable;
  private final UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListBackendServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteBackendServiceRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteBackendServiceRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyCallable;
  private final OperationCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable;
  private final UnaryCallable<GetBackendServiceRequest, BackendService> getCallable;
  private final UnaryCallable<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable;
  private final UnaryCallable<GetIamPolicyBackendServiceRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertBackendServiceRequest, Operation> insertCallable;
  private final OperationCallable<InsertBackendServiceRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListBackendServicesRequest, BackendServiceList> listCallable;
  private final UnaryCallable<ListBackendServicesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchBackendServiceRequest, Operation> patchCallable;
  private final OperationCallable<PatchBackendServiceRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
      setEdgeSecurityPolicyCallable;
  private final OperationCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable;
  private final UnaryCallable<SetIamPolicyBackendServiceRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyCallable;
  private final OperationCallable<SetSecurityPolicyBackendServiceRequest, Operation, Operation>
      setSecurityPolicyOperationCallable;
  private final UnaryCallable<UpdateBackendServiceRequest, Operation> updateCallable;
  private final OperationCallable<UpdateBackendServiceRequest, Operation, Operation>
      updateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBackendServicesStub create(BackendServicesStubSettings settings)
      throws IOException {
    return new HttpJsonBackendServicesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBackendServicesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBackendServicesStub(
        BackendServicesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBackendServicesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBackendServicesStub(
        BackendServicesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBackendServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendServicesStub(
      BackendServicesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBackendServicesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBackendServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendServicesStub(
      BackendServicesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation>
        addSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<AddSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(addSignedUrlKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteBackendServiceRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation>
        deleteSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<DeleteSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSignedUrlKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetBackendServiceRequest, BackendService> getTransportSettings =
        HttpJsonCallSettings.<GetBackendServiceRequest, BackendService>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
        getHealthTransportSettings =
            HttpJsonCallSettings
                .<GetHealthBackendServiceRequest, BackendServiceGroupHealth>newBuilder()
                .setMethodDescriptor(getHealthMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIamPolicyBackendServiceRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyBackendServiceRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertBackendServiceRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBackendServicesRequest, BackendServiceList> listTransportSettings =
        HttpJsonCallSettings.<ListBackendServicesRequest, BackendServiceList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchBackendServiceRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
        setEdgeSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<SetEdgeSecurityPolicyBackendServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(setEdgeSecurityPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetIamPolicyBackendServiceRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyBackendServiceRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetSecurityPolicyBackendServiceRequest, Operation>
        setSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<SetSecurityPolicyBackendServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(setSecurityPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateBackendServiceRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.addSignedUrlKeyCallable =
        callableFactory.createUnaryCallable(
            addSignedUrlKeyTransportSettings, settings.addSignedUrlKeySettings(), clientContext);
    this.addSignedUrlKeyOperationCallable =
        callableFactory.createOperationCallable(
            addSignedUrlKeyTransportSettings,
            settings.addSignedUrlKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.deleteSignedUrlKeyCallable =
        callableFactory.createUnaryCallable(
            deleteSignedUrlKeyTransportSettings,
            settings.deleteSignedUrlKeySettings(),
            clientContext);
    this.deleteSignedUrlKeyOperationCallable =
        callableFactory.createOperationCallable(
            deleteSignedUrlKeyTransportSettings,
            settings.deleteSignedUrlKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getHealthCallable =
        callableFactory.createUnaryCallable(
            getHealthTransportSettings, settings.getHealthSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    this.setEdgeSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            setEdgeSecurityPolicyTransportSettings,
            settings.setEdgeSecurityPolicySettings(),
            clientContext);
    this.setEdgeSecurityPolicyOperationCallable =
        callableFactory.createOperationCallable(
            setEdgeSecurityPolicyTransportSettings,
            settings.setEdgeSecurityPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            setSecurityPolicyTransportSettings,
            settings.setSecurityPolicySettings(),
            clientContext);
    this.setSecurityPolicyOperationCallable =
        callableFactory.createOperationCallable(
            setSecurityPolicyTransportSettings,
            settings.setSecurityPolicyOperationSettings(),
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
    methodDescriptors.add(addSignedUrlKeyMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteSignedUrlKeyMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getHealthMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setEdgeSecurityPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setSecurityPolicyMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddSignedUrlKeyBackendServiceRequest, Operation> addSignedUrlKeyCallable() {
    return addSignedUrlKeyCallable;
  }

  @Override
  public OperationCallable<AddSignedUrlKeyBackendServiceRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable() {
    return addSignedUrlKeyOperationCallable;
  }

  @Override
  public UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListBackendServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBackendServiceRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteBackendServiceRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyCallable() {
    return deleteSignedUrlKeyCallable;
  }

  @Override
  public OperationCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable() {
    return deleteSignedUrlKeyOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackendServiceRequest, BackendService> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable() {
    return getHealthCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyBackendServiceRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertBackendServiceRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertBackendServiceRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackendServicesRequest, BackendServiceList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListBackendServicesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchBackendServiceRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchBackendServiceRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation>
      setEdgeSecurityPolicyCallable() {
    return setEdgeSecurityPolicyCallable;
  }

  @Override
  public OperationCallable<SetEdgeSecurityPolicyBackendServiceRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable() {
    return setEdgeSecurityPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyBackendServiceRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyCallable() {
    return setSecurityPolicyCallable;
  }

  @Override
  public OperationCallable<SetSecurityPolicyBackendServiceRequest, Operation, Operation>
      setSecurityPolicyOperationCallable() {
    return setSecurityPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBackendServiceRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateBackendServiceRequest, Operation, Operation>
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
