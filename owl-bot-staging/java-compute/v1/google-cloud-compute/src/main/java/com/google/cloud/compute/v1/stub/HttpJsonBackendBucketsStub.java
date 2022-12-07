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

import static com.google.cloud.compute.v1.BackendBucketsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketList;
import com.google.cloud.compute.v1.DeleteBackendBucketRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.GetBackendBucketRequest;
import com.google.cloud.compute.v1.InsertBackendBucketRequest;
import com.google.cloud.compute.v1.ListBackendBucketsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchBackendBucketRequest;
import com.google.cloud.compute.v1.SetEdgeSecurityPolicyBackendBucketRequest;
import com.google.cloud.compute.v1.UpdateBackendBucketRequest;
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
 * REST stub implementation for the BackendBuckets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonBackendBucketsStub extends BackendBucketsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<AddSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/AddSignedUrlKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddSignedUrlKeyBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}/addSignedUrlKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddSignedUrlKeyBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendBucket", request.getBackendBucket());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddSignedUrlKeyBackendBucketRequest> serializer =
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
                  (AddSignedUrlKeyBackendBucketRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteBackendBucketRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendBucket", request.getBackendBucket());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackendBucketRequest> serializer =
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
                  (DeleteBackendBucketRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/DeleteSignedUrlKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSignedUrlKeyBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}/deleteSignedUrlKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSignedUrlKeyBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendBucket", request.getBackendBucket());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSignedUrlKeyBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteSignedUrlKeyBackendBucketRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetBackendBucketRequest, BackendBucket>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetBackendBucketRequest, BackendBucket>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendBucket", request.getBackendBucket());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendBucket>newBuilder()
                      .setDefaultInstance(BackendBucket.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertBackendBucketRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertBackendBucketRequest> serializer =
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
                                      "backendBucketResource",
                                      request.getBackendBucketResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertBackendBucketRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListBackendBucketsRequest, BackendBucketList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListBackendBucketsRequest, BackendBucketList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackendBucketsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackendBucketsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackendBucketsRequest> serializer =
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
                  ProtoMessageResponseParser.<BackendBucketList>newBuilder()
                      .setDefaultInstance(BackendBucketList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchBackendBucketRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendBucket", request.getBackendBucket());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchBackendBucketRequest> serializer =
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
                                      "backendBucketResource",
                                      request.getBackendBucketResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchBackendBucketRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetEdgeSecurityPolicyBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/SetEdgeSecurityPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetEdgeSecurityPolicyBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}/setEdgeSecurityPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetEdgeSecurityPolicyBackendBucketRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendBucket", request.getBackendBucket());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetEdgeSecurityPolicyBackendBucketRequest>
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
                  (SetEdgeSecurityPolicyBackendBucketRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<UpdateBackendBucketRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Update")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackendBucketRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backendBucket", request.getBackendBucket());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackendBucketRequest> serializer =
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
                                      "backendBucketResource",
                                      request.getBackendBucketResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBackendBucketRequest request, Operation response) -> {
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

  private final UnaryCallable<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeyCallable;
  private final OperationCallable<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable;
  private final UnaryCallable<DeleteBackendBucketRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteBackendBucketRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyCallable;
  private final OperationCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable;
  private final UnaryCallable<GetBackendBucketRequest, BackendBucket> getCallable;
  private final UnaryCallable<InsertBackendBucketRequest, Operation> insertCallable;
  private final OperationCallable<InsertBackendBucketRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListBackendBucketsRequest, BackendBucketList> listCallable;
  private final UnaryCallable<ListBackendBucketsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchBackendBucketRequest, Operation> patchCallable;
  private final OperationCallable<PatchBackendBucketRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicyCallable;
  private final OperationCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable;
  private final UnaryCallable<UpdateBackendBucketRequest, Operation> updateCallable;
  private final OperationCallable<UpdateBackendBucketRequest, Operation, Operation>
      updateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBackendBucketsStub create(BackendBucketsStubSettings settings)
      throws IOException {
    return new HttpJsonBackendBucketsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBackendBucketsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBackendBucketsStub(
        BackendBucketsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBackendBucketsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBackendBucketsStub(
        BackendBucketsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBackendBucketsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendBucketsStub(
      BackendBucketsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBackendBucketsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBackendBucketsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendBucketsStub(
      BackendBucketsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation>
        addSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<AddSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
                .setMethodDescriptor(addSignedUrlKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteBackendBucketRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteBackendBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation>
        deleteSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<DeleteSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSignedUrlKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetBackendBucketRequest, BackendBucket> getTransportSettings =
        HttpJsonCallSettings.<GetBackendBucketRequest, BackendBucket>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertBackendBucketRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertBackendBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBackendBucketsRequest, BackendBucketList> listTransportSettings =
        HttpJsonCallSettings.<ListBackendBucketsRequest, BackendBucketList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchBackendBucketRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchBackendBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
        setEdgeSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<SetEdgeSecurityPolicyBackendBucketRequest, Operation>newBuilder()
                .setMethodDescriptor(setEdgeSecurityPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateBackendBucketRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateBackendBucketRequest, Operation>newBuilder()
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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteSignedUrlKeyMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setEdgeSecurityPolicyMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddSignedUrlKeyBackendBucketRequest, Operation> addSignedUrlKeyCallable() {
    return addSignedUrlKeyCallable;
  }

  @Override
  public OperationCallable<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable() {
    return addSignedUrlKeyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackendBucketRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteBackendBucketRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyCallable() {
    return deleteSignedUrlKeyCallable;
  }

  @Override
  public OperationCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable() {
    return deleteSignedUrlKeyOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackendBucketRequest, BackendBucket> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertBackendBucketRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertBackendBucketRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackendBucketsRequest, BackendBucketList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListBackendBucketsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchBackendBucketRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchBackendBucketRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicyCallable() {
    return setEdgeSecurityPolicyCallable;
  }

  @Override
  public OperationCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable() {
    return setEdgeSecurityPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBackendBucketRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateBackendBucketRequest, Operation, Operation>
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
