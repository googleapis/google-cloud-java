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

import static com.google.cloud.compute.v1.ServiceAttachmentsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.ServiceAttachmentsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListServiceAttachmentsRequest;
import com.google.cloud.compute.v1.DeleteServiceAttachmentRequest;
import com.google.cloud.compute.v1.GetIamPolicyServiceAttachmentRequest;
import com.google.cloud.compute.v1.GetServiceAttachmentRequest;
import com.google.cloud.compute.v1.InsertServiceAttachmentRequest;
import com.google.cloud.compute.v1.ListServiceAttachmentsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchServiceAttachmentRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ServiceAttachment;
import com.google.cloud.compute.v1.ServiceAttachmentAggregatedList;
import com.google.cloud.compute.v1.ServiceAttachmentList;
import com.google.cloud.compute.v1.SetIamPolicyServiceAttachmentRequest;
import com.google.cloud.compute.v1.TestIamPermissionsServiceAttachmentRequest;
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
 * REST stub implementation for the ServiceAttachments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonServiceAttachmentsStub extends ServiceAttachmentsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListServiceAttachmentsRequest, ServiceAttachmentAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListServiceAttachmentsRequest, ServiceAttachmentAggregatedList>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListServiceAttachmentsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/serviceAttachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListServiceAttachmentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListServiceAttachmentsRequest>
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
                  ProtoMessageResponseParser.<ServiceAttachmentAggregatedList>newBuilder()
                      .setDefaultInstance(ServiceAttachmentAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteServiceAttachmentRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteServiceAttachmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServiceAttachmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments/{serviceAttachment}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "serviceAttachment", request.getServiceAttachment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServiceAttachmentRequest> serializer =
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
                  (DeleteServiceAttachmentRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetServiceAttachmentRequest, ServiceAttachment>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetServiceAttachmentRequest, ServiceAttachment>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServiceAttachmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments/{serviceAttachment}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "serviceAttachment", request.getServiceAttachment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ServiceAttachment>newBuilder()
                      .setDefaultInstance(ServiceAttachment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyServiceAttachmentRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyServiceAttachmentRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyServiceAttachmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyServiceAttachmentRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertServiceAttachmentRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertServiceAttachmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertServiceAttachmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertServiceAttachmentRequest> serializer =
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
                                      "serviceAttachmentResource",
                                      request.getServiceAttachmentResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertServiceAttachmentRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListServiceAttachmentsRequest, ServiceAttachmentList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListServiceAttachmentsRequest, ServiceAttachmentList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServiceAttachmentsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceAttachmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServiceAttachmentsRequest> serializer =
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
                  ProtoMessageResponseParser.<ServiceAttachmentList>newBuilder()
                      .setDefaultInstance(ServiceAttachmentList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchServiceAttachmentRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchServiceAttachmentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchServiceAttachmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments/{serviceAttachment}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "serviceAttachment", request.getServiceAttachment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchServiceAttachmentRequest> serializer =
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
                                      "serviceAttachmentResource",
                                      request.getServiceAttachmentResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchServiceAttachmentRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetIamPolicyServiceAttachmentRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyServiceAttachmentRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyServiceAttachmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyServiceAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetPolicyRequestResource",
                                      request.getRegionSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.ServiceAttachments/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsServiceAttachmentRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/serviceAttachments/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsServiceAttachmentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsServiceAttachmentRequest>
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
          AggregatedListServiceAttachmentsRequest, ServiceAttachmentAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListServiceAttachmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteServiceAttachmentRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteServiceAttachmentRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetServiceAttachmentRequest, ServiceAttachment> getCallable;
  private final UnaryCallable<GetIamPolicyServiceAttachmentRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertServiceAttachmentRequest, Operation> insertCallable;
  private final OperationCallable<InsertServiceAttachmentRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListServiceAttachmentsRequest, ServiceAttachmentList> listCallable;
  private final UnaryCallable<ListServiceAttachmentsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchServiceAttachmentRequest, Operation> patchCallable;
  private final OperationCallable<PatchServiceAttachmentRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetIamPolicyServiceAttachmentRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonServiceAttachmentsStub create(ServiceAttachmentsStubSettings settings)
      throws IOException {
    return new HttpJsonServiceAttachmentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonServiceAttachmentsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonServiceAttachmentsStub(
        ServiceAttachmentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonServiceAttachmentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonServiceAttachmentsStub(
        ServiceAttachmentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonServiceAttachmentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceAttachmentsStub(
      ServiceAttachmentsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonServiceAttachmentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonServiceAttachmentsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceAttachmentsStub(
      ServiceAttachmentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AggregatedListServiceAttachmentsRequest, ServiceAttachmentAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListServiceAttachmentsRequest, ServiceAttachmentAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteServiceAttachmentRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteServiceAttachmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetServiceAttachmentRequest, ServiceAttachment> getTransportSettings =
        HttpJsonCallSettings.<GetServiceAttachmentRequest, ServiceAttachment>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyServiceAttachmentRequest, Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyServiceAttachmentRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertServiceAttachmentRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertServiceAttachmentRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListServiceAttachmentsRequest, ServiceAttachmentList>
        listTransportSettings =
            HttpJsonCallSettings.<ListServiceAttachmentsRequest, ServiceAttachmentList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchServiceAttachmentRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchServiceAttachmentRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyServiceAttachmentRequest, Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyServiceAttachmentRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListServiceAttachmentsRequest, ServiceAttachmentAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListServiceAttachmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceAttachmentRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteServiceAttachmentRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetServiceAttachmentRequest, ServiceAttachment> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyServiceAttachmentRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertServiceAttachmentRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertServiceAttachmentRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceAttachmentsRequest, ServiceAttachmentList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListServiceAttachmentsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchServiceAttachmentRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchServiceAttachmentRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyServiceAttachmentRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>
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
