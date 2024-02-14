/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.securityposture.v1.stub;

import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListLocationsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureDeploymentsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureRevisionsPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPostureTemplatesPagedResponse;
import static com.google.cloud.securityposture.v1.SecurityPostureClient.ListPosturesPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.CreatePostureRequest;
import com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.DeletePostureRequest;
import com.google.cloud.securityposture.v1.ExtractPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureDeploymentRequest;
import com.google.cloud.securityposture.v1.GetPostureRequest;
import com.google.cloud.securityposture.v1.GetPostureTemplateRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest;
import com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse;
import com.google.cloud.securityposture.v1.ListPostureRevisionsRequest;
import com.google.cloud.securityposture.v1.ListPostureRevisionsResponse;
import com.google.cloud.securityposture.v1.ListPostureTemplatesRequest;
import com.google.cloud.securityposture.v1.ListPostureTemplatesResponse;
import com.google.cloud.securityposture.v1.ListPosturesRequest;
import com.google.cloud.securityposture.v1.ListPosturesResponse;
import com.google.cloud.securityposture.v1.OperationMetadata;
import com.google.cloud.securityposture.v1.Posture;
import com.google.cloud.securityposture.v1.PostureDeployment;
import com.google.cloud.securityposture.v1.PostureTemplate;
import com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest;
import com.google.cloud.securityposture.v1.UpdatePostureRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the SecurityPosture service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSecurityPostureStub extends SecurityPostureStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Posture.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(PostureDeployment.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListPosturesRequest, ListPosturesResponse>
      listPosturesMethodDescriptor =
          ApiMethodDescriptor.<ListPosturesRequest, ListPosturesResponse>newBuilder()
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/ListPostures")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPosturesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/postures",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPosturesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPosturesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPosturesResponse>newBuilder()
                      .setDefaultInstance(ListPosturesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPostureRevisionsRequest, ListPostureRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/ListPostureRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPostureRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/postures/*}:listRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPostureRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPostureRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPostureRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListPostureRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPostureRequest, Posture> getPostureMethodDescriptor =
      ApiMethodDescriptor.<GetPostureRequest, Posture>newBuilder()
          .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/GetPosture")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPostureRequest>newBuilder()
                  .setPath(
                      "/v1/{name=organizations/*/locations/*/postures/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPostureRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPostureRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "revisionId", request.getRevisionId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Posture>newBuilder()
                  .setDefaultInstance(Posture.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreatePostureRequest, Operation>
      createPostureMethodDescriptor =
          ApiMethodDescriptor.<CreatePostureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/CreatePosture")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePostureRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/postures",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "postureId", request.getPostureId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("posture", request.getPosture(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePostureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePostureRequest, Operation>
      updatePostureMethodDescriptor =
          ApiMethodDescriptor.<UpdatePostureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/UpdatePosture")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePostureRequest>newBuilder()
                      .setPath(
                          "/v1/{posture.name=organizations/*/locations/*/postures/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "posture.name", request.getPosture().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "revisionId", request.getRevisionId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("posture", request.getPosture(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePostureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePostureRequest, Operation>
      deletePostureMethodDescriptor =
          ApiMethodDescriptor.<DeletePostureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/DeletePosture")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePostureRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/postures/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeletePostureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExtractPostureRequest, Operation>
      extractPostureMethodDescriptor =
          ApiMethodDescriptor.<ExtractPostureRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.securityposture.v1.SecurityPosture/ExtractPosture")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExtractPostureRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/postures:extract",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExtractPostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExtractPostureRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExtractPostureRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/ListPostureDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPostureDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/postureDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPostureDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPostureDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPostureDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListPostureDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetPostureDeploymentRequest, PostureDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/GetPostureDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPostureDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/postureDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PostureDeployment>newBuilder()
                      .setDefaultInstance(PostureDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreatePostureDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/CreatePostureDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePostureDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/postureDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "postureDeploymentId", request.getPostureDeploymentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "postureDeployment", request.getPostureDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePostureDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdatePostureDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/UpdatePostureDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePostureDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{postureDeployment.name=organizations/*/locations/*/postureDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "postureDeployment.name",
                                request.getPostureDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "postureDeployment", request.getPostureDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePostureDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeletePostureDeploymentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/DeletePostureDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePostureDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/postureDeployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePostureDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeletePostureDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListPostureTemplatesRequest, ListPostureTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/ListPostureTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPostureTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/postureTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPostureTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPostureTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPostureTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListPostureTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetPostureTemplateRequest, PostureTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.securityposture.v1.SecurityPosture/GetPostureTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPostureTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/postureTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPostureTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPostureTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "revisionId", request.getRevisionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PostureTemplate>newBuilder()
                      .setDefaultInstance(PostureTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListPosturesRequest, ListPosturesResponse> listPosturesCallable;
  private final UnaryCallable<ListPosturesRequest, ListPosturesPagedResponse>
      listPosturesPagedCallable;
  private final UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsCallable;
  private final UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsPagedResponse>
      listPostureRevisionsPagedCallable;
  private final UnaryCallable<GetPostureRequest, Posture> getPostureCallable;
  private final UnaryCallable<CreatePostureRequest, Operation> createPostureCallable;
  private final OperationCallable<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationCallable;
  private final UnaryCallable<UpdatePostureRequest, Operation> updatePostureCallable;
  private final OperationCallable<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationCallable;
  private final UnaryCallable<DeletePostureRequest, Operation> deletePostureCallable;
  private final OperationCallable<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationCallable;
  private final UnaryCallable<ExtractPostureRequest, Operation> extractPostureCallable;
  private final OperationCallable<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationCallable;
  private final UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsCallable;
  private final UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsPagedCallable;
  private final UnaryCallable<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentCallable;
  private final UnaryCallable<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentCallable;
  private final OperationCallable<
          CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationCallable;
  private final UnaryCallable<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentCallable;
  private final OperationCallable<
          UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationCallable;
  private final UnaryCallable<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentCallable;
  private final OperationCallable<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationCallable;
  private final UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesCallable;
  private final UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesPagedResponse>
      listPostureTemplatesPagedCallable;
  private final UnaryCallable<GetPostureTemplateRequest, PostureTemplate>
      getPostureTemplateCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSecurityPostureStub create(SecurityPostureStubSettings settings)
      throws IOException {
    return new HttpJsonSecurityPostureStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecurityPostureStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecurityPostureStub(
        SecurityPostureStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSecurityPostureStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecurityPostureStub(
        SecurityPostureStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecurityPostureStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityPostureStub(
      SecurityPostureStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSecurityPostureCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecurityPostureStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityPostureStub(
      SecurityPostureStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=organizations/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=organizations/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListPosturesRequest, ListPosturesResponse> listPosturesTransportSettings =
        HttpJsonCallSettings.<ListPosturesRequest, ListPosturesResponse>newBuilder()
            .setMethodDescriptor(listPosturesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
        listPostureRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListPostureRevisionsRequest, ListPostureRevisionsResponse>newBuilder()
                .setMethodDescriptor(listPostureRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPostureRequest, Posture> getPostureTransportSettings =
        HttpJsonCallSettings.<GetPostureRequest, Posture>newBuilder()
            .setMethodDescriptor(getPostureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePostureRequest, Operation> createPostureTransportSettings =
        HttpJsonCallSettings.<CreatePostureRequest, Operation>newBuilder()
            .setMethodDescriptor(createPostureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePostureRequest, Operation> updatePostureTransportSettings =
        HttpJsonCallSettings.<UpdatePostureRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePostureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("posture.name", String.valueOf(request.getPosture().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePostureRequest, Operation> deletePostureTransportSettings =
        HttpJsonCallSettings.<DeletePostureRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePostureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExtractPostureRequest, Operation> extractPostureTransportSettings =
        HttpJsonCallSettings.<ExtractPostureRequest, Operation>newBuilder()
            .setMethodDescriptor(extractPostureMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
        listPostureDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listPostureDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPostureDeploymentRequest, PostureDeployment>
        getPostureDeploymentTransportSettings =
            HttpJsonCallSettings.<GetPostureDeploymentRequest, PostureDeployment>newBuilder()
                .setMethodDescriptor(getPostureDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePostureDeploymentRequest, Operation>
        createPostureDeploymentTransportSettings =
            HttpJsonCallSettings.<CreatePostureDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(createPostureDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePostureDeploymentRequest, Operation>
        updatePostureDeploymentTransportSettings =
            HttpJsonCallSettings.<UpdatePostureDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePostureDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "posture_deployment.name",
                          String.valueOf(request.getPostureDeployment().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePostureDeploymentRequest, Operation>
        deletePostureDeploymentTransportSettings =
            HttpJsonCallSettings.<DeletePostureDeploymentRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePostureDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
        listPostureTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListPostureTemplatesRequest, ListPostureTemplatesResponse>newBuilder()
                .setMethodDescriptor(listPostureTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPostureTemplateRequest, PostureTemplate>
        getPostureTemplateTransportSettings =
            HttpJsonCallSettings.<GetPostureTemplateRequest, PostureTemplate>newBuilder()
                .setMethodDescriptor(getPostureTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listPosturesCallable =
        callableFactory.createUnaryCallable(
            listPosturesTransportSettings, settings.listPosturesSettings(), clientContext);
    this.listPosturesPagedCallable =
        callableFactory.createPagedCallable(
            listPosturesTransportSettings, settings.listPosturesSettings(), clientContext);
    this.listPostureRevisionsCallable =
        callableFactory.createUnaryCallable(
            listPostureRevisionsTransportSettings,
            settings.listPostureRevisionsSettings(),
            clientContext);
    this.listPostureRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listPostureRevisionsTransportSettings,
            settings.listPostureRevisionsSettings(),
            clientContext);
    this.getPostureCallable =
        callableFactory.createUnaryCallable(
            getPostureTransportSettings, settings.getPostureSettings(), clientContext);
    this.createPostureCallable =
        callableFactory.createUnaryCallable(
            createPostureTransportSettings, settings.createPostureSettings(), clientContext);
    this.createPostureOperationCallable =
        callableFactory.createOperationCallable(
            createPostureTransportSettings,
            settings.createPostureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePostureCallable =
        callableFactory.createUnaryCallable(
            updatePostureTransportSettings, settings.updatePostureSettings(), clientContext);
    this.updatePostureOperationCallable =
        callableFactory.createOperationCallable(
            updatePostureTransportSettings,
            settings.updatePostureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePostureCallable =
        callableFactory.createUnaryCallable(
            deletePostureTransportSettings, settings.deletePostureSettings(), clientContext);
    this.deletePostureOperationCallable =
        callableFactory.createOperationCallable(
            deletePostureTransportSettings,
            settings.deletePostureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.extractPostureCallable =
        callableFactory.createUnaryCallable(
            extractPostureTransportSettings, settings.extractPostureSettings(), clientContext);
    this.extractPostureOperationCallable =
        callableFactory.createOperationCallable(
            extractPostureTransportSettings,
            settings.extractPostureOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listPostureDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listPostureDeploymentsTransportSettings,
            settings.listPostureDeploymentsSettings(),
            clientContext);
    this.listPostureDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listPostureDeploymentsTransportSettings,
            settings.listPostureDeploymentsSettings(),
            clientContext);
    this.getPostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            getPostureDeploymentTransportSettings,
            settings.getPostureDeploymentSettings(),
            clientContext);
    this.createPostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            createPostureDeploymentTransportSettings,
            settings.createPostureDeploymentSettings(),
            clientContext);
    this.createPostureDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createPostureDeploymentTransportSettings,
            settings.createPostureDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            updatePostureDeploymentTransportSettings,
            settings.updatePostureDeploymentSettings(),
            clientContext);
    this.updatePostureDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            updatePostureDeploymentTransportSettings,
            settings.updatePostureDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePostureDeploymentCallable =
        callableFactory.createUnaryCallable(
            deletePostureDeploymentTransportSettings,
            settings.deletePostureDeploymentSettings(),
            clientContext);
    this.deletePostureDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deletePostureDeploymentTransportSettings,
            settings.deletePostureDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listPostureTemplatesCallable =
        callableFactory.createUnaryCallable(
            listPostureTemplatesTransportSettings,
            settings.listPostureTemplatesSettings(),
            clientContext);
    this.listPostureTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listPostureTemplatesTransportSettings,
            settings.listPostureTemplatesSettings(),
            clientContext);
    this.getPostureTemplateCallable =
        callableFactory.createUnaryCallable(
            getPostureTemplateTransportSettings,
            settings.getPostureTemplateSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listPosturesMethodDescriptor);
    methodDescriptors.add(listPostureRevisionsMethodDescriptor);
    methodDescriptors.add(getPostureMethodDescriptor);
    methodDescriptors.add(createPostureMethodDescriptor);
    methodDescriptors.add(updatePostureMethodDescriptor);
    methodDescriptors.add(deletePostureMethodDescriptor);
    methodDescriptors.add(extractPostureMethodDescriptor);
    methodDescriptors.add(listPostureDeploymentsMethodDescriptor);
    methodDescriptors.add(getPostureDeploymentMethodDescriptor);
    methodDescriptors.add(createPostureDeploymentMethodDescriptor);
    methodDescriptors.add(updatePostureDeploymentMethodDescriptor);
    methodDescriptors.add(deletePostureDeploymentMethodDescriptor);
    methodDescriptors.add(listPostureTemplatesMethodDescriptor);
    methodDescriptors.add(getPostureTemplateMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListPosturesRequest, ListPosturesResponse> listPosturesCallable() {
    return listPosturesCallable;
  }

  @Override
  public UnaryCallable<ListPosturesRequest, ListPosturesPagedResponse> listPosturesPagedCallable() {
    return listPosturesPagedCallable;
  }

  @Override
  public UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsResponse>
      listPostureRevisionsCallable() {
    return listPostureRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListPostureRevisionsRequest, ListPostureRevisionsPagedResponse>
      listPostureRevisionsPagedCallable() {
    return listPostureRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPostureRequest, Posture> getPostureCallable() {
    return getPostureCallable;
  }

  @Override
  public UnaryCallable<CreatePostureRequest, Operation> createPostureCallable() {
    return createPostureCallable;
  }

  @Override
  public OperationCallable<CreatePostureRequest, Posture, OperationMetadata>
      createPostureOperationCallable() {
    return createPostureOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePostureRequest, Operation> updatePostureCallable() {
    return updatePostureCallable;
  }

  @Override
  public OperationCallable<UpdatePostureRequest, Posture, OperationMetadata>
      updatePostureOperationCallable() {
    return updatePostureOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePostureRequest, Operation> deletePostureCallable() {
    return deletePostureCallable;
  }

  @Override
  public OperationCallable<DeletePostureRequest, Empty, OperationMetadata>
      deletePostureOperationCallable() {
    return deletePostureOperationCallable;
  }

  @Override
  public UnaryCallable<ExtractPostureRequest, Operation> extractPostureCallable() {
    return extractPostureCallable;
  }

  @Override
  public OperationCallable<ExtractPostureRequest, Posture, OperationMetadata>
      extractPostureOperationCallable() {
    return extractPostureOperationCallable;
  }

  @Override
  public UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsResponse>
      listPostureDeploymentsCallable() {
    return listPostureDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListPostureDeploymentsRequest, ListPostureDeploymentsPagedResponse>
      listPostureDeploymentsPagedCallable() {
    return listPostureDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPostureDeploymentRequest, PostureDeployment>
      getPostureDeploymentCallable() {
    return getPostureDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreatePostureDeploymentRequest, Operation>
      createPostureDeploymentCallable() {
    return createPostureDeploymentCallable;
  }

  @Override
  public OperationCallable<CreatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      createPostureDeploymentOperationCallable() {
    return createPostureDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePostureDeploymentRequest, Operation>
      updatePostureDeploymentCallable() {
    return updatePostureDeploymentCallable;
  }

  @Override
  public OperationCallable<UpdatePostureDeploymentRequest, PostureDeployment, OperationMetadata>
      updatePostureDeploymentOperationCallable() {
    return updatePostureDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePostureDeploymentRequest, Operation>
      deletePostureDeploymentCallable() {
    return deletePostureDeploymentCallable;
  }

  @Override
  public OperationCallable<DeletePostureDeploymentRequest, Empty, OperationMetadata>
      deletePostureDeploymentOperationCallable() {
    return deletePostureDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesResponse>
      listPostureTemplatesCallable() {
    return listPostureTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListPostureTemplatesRequest, ListPostureTemplatesPagedResponse>
      listPostureTemplatesPagedCallable() {
    return listPostureTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPostureTemplateRequest, PostureTemplate> getPostureTemplateCallable() {
    return getPostureTemplateCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
