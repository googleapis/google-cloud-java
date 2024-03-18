/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.config.v1.stub;

import static com.google.cloud.config.v1.ConfigClient.ListDeploymentsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListLocationsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListPreviewsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListResourcesPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListRevisionsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListTerraformVersionsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.config.v1.CreateDeploymentRequest;
import com.google.cloud.config.v1.CreatePreviewRequest;
import com.google.cloud.config.v1.DeleteDeploymentRequest;
import com.google.cloud.config.v1.DeletePreviewRequest;
import com.google.cloud.config.v1.DeleteStatefileRequest;
import com.google.cloud.config.v1.Deployment;
import com.google.cloud.config.v1.ExportDeploymentStatefileRequest;
import com.google.cloud.config.v1.ExportLockInfoRequest;
import com.google.cloud.config.v1.ExportPreviewResultRequest;
import com.google.cloud.config.v1.ExportPreviewResultResponse;
import com.google.cloud.config.v1.ExportRevisionStatefileRequest;
import com.google.cloud.config.v1.GetDeploymentRequest;
import com.google.cloud.config.v1.GetPreviewRequest;
import com.google.cloud.config.v1.GetResourceRequest;
import com.google.cloud.config.v1.GetRevisionRequest;
import com.google.cloud.config.v1.GetTerraformVersionRequest;
import com.google.cloud.config.v1.ImportStatefileRequest;
import com.google.cloud.config.v1.ListDeploymentsRequest;
import com.google.cloud.config.v1.ListDeploymentsResponse;
import com.google.cloud.config.v1.ListPreviewsRequest;
import com.google.cloud.config.v1.ListPreviewsResponse;
import com.google.cloud.config.v1.ListResourcesRequest;
import com.google.cloud.config.v1.ListResourcesResponse;
import com.google.cloud.config.v1.ListRevisionsRequest;
import com.google.cloud.config.v1.ListRevisionsResponse;
import com.google.cloud.config.v1.ListTerraformVersionsRequest;
import com.google.cloud.config.v1.ListTerraformVersionsResponse;
import com.google.cloud.config.v1.LockDeploymentRequest;
import com.google.cloud.config.v1.LockInfo;
import com.google.cloud.config.v1.OperationMetadata;
import com.google.cloud.config.v1.Preview;
import com.google.cloud.config.v1.Resource;
import com.google.cloud.config.v1.Revision;
import com.google.cloud.config.v1.Statefile;
import com.google.cloud.config.v1.TerraformVersion;
import com.google.cloud.config.v1.UnlockDeploymentRequest;
import com.google.cloud.config.v1.UpdateDeploymentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the Config service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonConfigStub extends ConfigStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Deployment.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Preview.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          ApiMethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ListDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/GetDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDeploymentRequest, Operation>
      createDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateDeploymentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/CreateDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deploymentId", request.getDeploymentId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDeploymentRequest, Operation>
      updateDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeploymentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/UpdateDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{deployment.name=projects/*/locations/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "deployment.name", request.getDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDeploymentRequest, Operation>
      deleteDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeploymentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/DeleteDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deletePolicy", request.getDeletePolicyValue());
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRevisionsRequest, ListRevisionsResponse>
      listRevisionsMethodDescriptor =
          ApiMethodDescriptor.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ListRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deployments/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRevisionRequest, Revision>
      getRevisionMethodDescriptor =
          ApiMethodDescriptor.<GetRevisionRequest, Revision>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/GetRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Revision>newBuilder()
                      .setDefaultInstance(Revision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetResourceRequest, Resource>
      getResourceMethodDescriptor =
          ApiMethodDescriptor.<GetResourceRequest, Resource>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/GetResource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetResourceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*/revisions/*/resources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Resource>newBuilder()
                      .setDefaultInstance(Resource.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListResourcesRequest, ListResourcesResponse>
      listResourcesMethodDescriptor =
          ApiMethodDescriptor.<ListResourcesRequest, ListResourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ListResources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListResourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deployments/*/revisions/*}/resources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListResourcesResponse>newBuilder()
                      .setDefaultInstance(ListResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileMethodDescriptor =
          ApiMethodDescriptor.<ExportDeploymentStatefileRequest, Statefile>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ExportDeploymentStatefile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportDeploymentStatefileRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deployments/*}:exportState",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDeploymentStatefileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDeploymentStatefileRequest> serializer =
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
                  ProtoMessageResponseParser.<Statefile>newBuilder()
                      .setDefaultInstance(Statefile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileMethodDescriptor =
          ApiMethodDescriptor.<ExportRevisionStatefileRequest, Statefile>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ExportRevisionStatefile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportRevisionStatefileRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deployments/*/revisions/*}:exportState",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportRevisionStatefileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportRevisionStatefileRequest> serializer =
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
                  ProtoMessageResponseParser.<Statefile>newBuilder()
                      .setDefaultInstance(Statefile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportStatefileRequest, Statefile>
      importStatefileMethodDescriptor =
          ApiMethodDescriptor.<ImportStatefileRequest, Statefile>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ImportStatefile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportStatefileRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/deployments/*}:importState",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportStatefileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportStatefileRequest> serializer =
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
                  ProtoMessageResponseParser.<Statefile>newBuilder()
                      .setDefaultInstance(Statefile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteStatefileRequest, Empty>
      deleteStatefileMethodDescriptor =
          ApiMethodDescriptor.<DeleteStatefileRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/DeleteStatefile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteStatefileRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}:deleteState",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStatefileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStatefileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<LockDeploymentRequest, Operation>
      lockDeploymentMethodDescriptor =
          ApiMethodDescriptor.<LockDeploymentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/LockDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LockDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}:lock",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LockDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LockDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (LockDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UnlockDeploymentRequest, Operation>
      unlockDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UnlockDeploymentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/UnlockDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnlockDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}:unlock",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnlockDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnlockDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UnlockDeploymentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportLockInfoRequest, LockInfo>
      exportLockInfoMethodDescriptor =
          ApiMethodDescriptor.<ExportLockInfoRequest, LockInfo>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ExportLockInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportLockInfoRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}:exportLock",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportLockInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportLockInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LockInfo>newBuilder()
                      .setDefaultInstance(LockInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePreviewRequest, Operation>
      createPreviewMethodDescriptor =
          ApiMethodDescriptor.<CreatePreviewRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/CreatePreview")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePreviewRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/previews",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePreviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePreviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "previewId", request.getPreviewId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("preview", request.getPreview(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePreviewRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPreviewRequest, Preview> getPreviewMethodDescriptor =
      ApiMethodDescriptor.<GetPreviewRequest, Preview>newBuilder()
          .setFullMethodName("google.cloud.config.v1.Config/GetPreview")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPreviewRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/previews/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPreviewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPreviewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Preview>newBuilder()
                  .setDefaultInstance(Preview.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListPreviewsRequest, ListPreviewsResponse>
      listPreviewsMethodDescriptor =
          ApiMethodDescriptor.<ListPreviewsRequest, ListPreviewsResponse>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ListPreviews")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPreviewsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/previews",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPreviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPreviewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPreviewsResponse>newBuilder()
                      .setDefaultInstance(ListPreviewsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePreviewRequest, Operation>
      deletePreviewMethodDescriptor =
          ApiMethodDescriptor.<DeletePreviewRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/DeletePreview")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePreviewRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/previews/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePreviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePreviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeletePreviewRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultMethodDescriptor =
          ApiMethodDescriptor.<ExportPreviewResultRequest, ExportPreviewResultResponse>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ExportPreviewResult")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportPreviewResultRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/previews/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportPreviewResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportPreviewResultRequest> serializer =
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
                  ProtoMessageResponseParser.<ExportPreviewResultResponse>newBuilder()
                      .setDefaultInstance(ExportPreviewResultResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListTerraformVersionsRequest, ListTerraformVersionsResponse>
      listTerraformVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListTerraformVersionsRequest, ListTerraformVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/ListTerraformVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTerraformVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/terraformVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTerraformVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTerraformVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTerraformVersionsResponse>newBuilder()
                      .setDefaultInstance(ListTerraformVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTerraformVersionRequest, TerraformVersion>
      getTerraformVersionMethodDescriptor =
          ApiMethodDescriptor.<GetTerraformVersionRequest, TerraformVersion>newBuilder()
              .setFullMethodName("google.cloud.config.v1.Config/GetTerraformVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTerraformVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/terraformVersions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTerraformVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTerraformVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TerraformVersion>newBuilder()
                      .setDefaultInstance(TerraformVersion.getDefaultInstance())
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/deployments/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/deployments/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/deployments/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<CreateDeploymentRequest, Operation> createDeploymentCallable;
  private final OperationCallable<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationCallable;
  private final UnaryCallable<UpdateDeploymentRequest, Operation> updateDeploymentCallable;
  private final OperationCallable<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Operation> deleteDeploymentCallable;
  private final OperationCallable<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable;
  private final UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable;
  private final UnaryCallable<GetResourceRequest, Resource> getResourceCallable;
  private final UnaryCallable<ListResourcesRequest, ListResourcesResponse> listResourcesCallable;
  private final UnaryCallable<ListResourcesRequest, ListResourcesPagedResponse>
      listResourcesPagedCallable;
  private final UnaryCallable<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileCallable;
  private final UnaryCallable<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileCallable;
  private final UnaryCallable<ImportStatefileRequest, Statefile> importStatefileCallable;
  private final UnaryCallable<DeleteStatefileRequest, Empty> deleteStatefileCallable;
  private final UnaryCallable<LockDeploymentRequest, Operation> lockDeploymentCallable;
  private final OperationCallable<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationCallable;
  private final UnaryCallable<UnlockDeploymentRequest, Operation> unlockDeploymentCallable;
  private final OperationCallable<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationCallable;
  private final UnaryCallable<ExportLockInfoRequest, LockInfo> exportLockInfoCallable;
  private final UnaryCallable<CreatePreviewRequest, Operation> createPreviewCallable;
  private final OperationCallable<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationCallable;
  private final UnaryCallable<GetPreviewRequest, Preview> getPreviewCallable;
  private final UnaryCallable<ListPreviewsRequest, ListPreviewsResponse> listPreviewsCallable;
  private final UnaryCallable<ListPreviewsRequest, ListPreviewsPagedResponse>
      listPreviewsPagedCallable;
  private final UnaryCallable<DeletePreviewRequest, Operation> deletePreviewCallable;
  private final OperationCallable<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationCallable;
  private final UnaryCallable<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultCallable;
  private final UnaryCallable<ListTerraformVersionsRequest, ListTerraformVersionsResponse>
      listTerraformVersionsCallable;
  private final UnaryCallable<ListTerraformVersionsRequest, ListTerraformVersionsPagedResponse>
      listTerraformVersionsPagedCallable;
  private final UnaryCallable<GetTerraformVersionRequest, TerraformVersion>
      getTerraformVersionCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConfigStub create(ConfigStubSettings settings) throws IOException {
    return new HttpJsonConfigStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConfigStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonConfigStub(ConfigStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConfigStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConfigStub(
        ConfigStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConfigStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonConfigStub(ConfigStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonConfigCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConfigStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonConfigStub(
      ConfigStubSettings settings,
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
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            HttpJsonCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        HttpJsonCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDeploymentRequest, Operation> createDeploymentTransportSettings =
        HttpJsonCallSettings.<CreateDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDeploymentRequest, Operation> updateDeploymentTransportSettings =
        HttpJsonCallSettings.<UpdateDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDeploymentRequest, Operation> deleteDeploymentTransportSettings =
        HttpJsonCallSettings.<DeleteDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRevisionsRequest, ListRevisionsResponse>
        listRevisionsTransportSettings =
            HttpJsonCallSettings.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
                .setMethodDescriptor(listRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRevisionRequest, Revision> getRevisionTransportSettings =
        HttpJsonCallSettings.<GetRevisionRequest, Revision>newBuilder()
            .setMethodDescriptor(getRevisionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetResourceRequest, Resource> getResourceTransportSettings =
        HttpJsonCallSettings.<GetResourceRequest, Resource>newBuilder()
            .setMethodDescriptor(getResourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListResourcesRequest, ListResourcesResponse>
        listResourcesTransportSettings =
            HttpJsonCallSettings.<ListResourcesRequest, ListResourcesResponse>newBuilder()
                .setMethodDescriptor(listResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportDeploymentStatefileRequest, Statefile>
        exportDeploymentStatefileTransportSettings =
            HttpJsonCallSettings.<ExportDeploymentStatefileRequest, Statefile>newBuilder()
                .setMethodDescriptor(exportDeploymentStatefileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportRevisionStatefileRequest, Statefile>
        exportRevisionStatefileTransportSettings =
            HttpJsonCallSettings.<ExportRevisionStatefileRequest, Statefile>newBuilder()
                .setMethodDescriptor(exportRevisionStatefileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ImportStatefileRequest, Statefile> importStatefileTransportSettings =
        HttpJsonCallSettings.<ImportStatefileRequest, Statefile>newBuilder()
            .setMethodDescriptor(importStatefileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteStatefileRequest, Empty> deleteStatefileTransportSettings =
        HttpJsonCallSettings.<DeleteStatefileRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStatefileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<LockDeploymentRequest, Operation> lockDeploymentTransportSettings =
        HttpJsonCallSettings.<LockDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(lockDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UnlockDeploymentRequest, Operation> unlockDeploymentTransportSettings =
        HttpJsonCallSettings.<UnlockDeploymentRequest, Operation>newBuilder()
            .setMethodDescriptor(unlockDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportLockInfoRequest, LockInfo> exportLockInfoTransportSettings =
        HttpJsonCallSettings.<ExportLockInfoRequest, LockInfo>newBuilder()
            .setMethodDescriptor(exportLockInfoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePreviewRequest, Operation> createPreviewTransportSettings =
        HttpJsonCallSettings.<CreatePreviewRequest, Operation>newBuilder()
            .setMethodDescriptor(createPreviewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetPreviewRequest, Preview> getPreviewTransportSettings =
        HttpJsonCallSettings.<GetPreviewRequest, Preview>newBuilder()
            .setMethodDescriptor(getPreviewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPreviewsRequest, ListPreviewsResponse> listPreviewsTransportSettings =
        HttpJsonCallSettings.<ListPreviewsRequest, ListPreviewsResponse>newBuilder()
            .setMethodDescriptor(listPreviewsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeletePreviewRequest, Operation> deletePreviewTransportSettings =
        HttpJsonCallSettings.<DeletePreviewRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePreviewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportPreviewResultRequest, ExportPreviewResultResponse>
        exportPreviewResultTransportSettings =
            HttpJsonCallSettings
                .<ExportPreviewResultRequest, ExportPreviewResultResponse>newBuilder()
                .setMethodDescriptor(exportPreviewResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListTerraformVersionsRequest, ListTerraformVersionsResponse>
        listTerraformVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListTerraformVersionsRequest, ListTerraformVersionsResponse>newBuilder()
                .setMethodDescriptor(listTerraformVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTerraformVersionRequest, TerraformVersion>
        getTerraformVersionTransportSettings =
            HttpJsonCallSettings.<GetTerraformVersionRequest, TerraformVersion>newBuilder()
                .setMethodDescriptor(getTerraformVersionMethodDescriptor)
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
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.createDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            createDeploymentTransportSettings,
            settings.createDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateDeploymentTransportSettings, settings.updateDeploymentSettings(), clientContext);
    this.updateDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            updateDeploymentTransportSettings,
            settings.updateDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.deleteDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            deleteDeploymentTransportSettings,
            settings.deleteDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listRevisionsCallable =
        callableFactory.createUnaryCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.listRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.getRevisionCallable =
        callableFactory.createUnaryCallable(
            getRevisionTransportSettings, settings.getRevisionSettings(), clientContext);
    this.getResourceCallable =
        callableFactory.createUnaryCallable(
            getResourceTransportSettings, settings.getResourceSettings(), clientContext);
    this.listResourcesCallable =
        callableFactory.createUnaryCallable(
            listResourcesTransportSettings, settings.listResourcesSettings(), clientContext);
    this.listResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listResourcesTransportSettings, settings.listResourcesSettings(), clientContext);
    this.exportDeploymentStatefileCallable =
        callableFactory.createUnaryCallable(
            exportDeploymentStatefileTransportSettings,
            settings.exportDeploymentStatefileSettings(),
            clientContext);
    this.exportRevisionStatefileCallable =
        callableFactory.createUnaryCallable(
            exportRevisionStatefileTransportSettings,
            settings.exportRevisionStatefileSettings(),
            clientContext);
    this.importStatefileCallable =
        callableFactory.createUnaryCallable(
            importStatefileTransportSettings, settings.importStatefileSettings(), clientContext);
    this.deleteStatefileCallable =
        callableFactory.createUnaryCallable(
            deleteStatefileTransportSettings, settings.deleteStatefileSettings(), clientContext);
    this.lockDeploymentCallable =
        callableFactory.createUnaryCallable(
            lockDeploymentTransportSettings, settings.lockDeploymentSettings(), clientContext);
    this.lockDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            lockDeploymentTransportSettings,
            settings.lockDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.unlockDeploymentCallable =
        callableFactory.createUnaryCallable(
            unlockDeploymentTransportSettings, settings.unlockDeploymentSettings(), clientContext);
    this.unlockDeploymentOperationCallable =
        callableFactory.createOperationCallable(
            unlockDeploymentTransportSettings,
            settings.unlockDeploymentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportLockInfoCallable =
        callableFactory.createUnaryCallable(
            exportLockInfoTransportSettings, settings.exportLockInfoSettings(), clientContext);
    this.createPreviewCallable =
        callableFactory.createUnaryCallable(
            createPreviewTransportSettings, settings.createPreviewSettings(), clientContext);
    this.createPreviewOperationCallable =
        callableFactory.createOperationCallable(
            createPreviewTransportSettings,
            settings.createPreviewOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPreviewCallable =
        callableFactory.createUnaryCallable(
            getPreviewTransportSettings, settings.getPreviewSettings(), clientContext);
    this.listPreviewsCallable =
        callableFactory.createUnaryCallable(
            listPreviewsTransportSettings, settings.listPreviewsSettings(), clientContext);
    this.listPreviewsPagedCallable =
        callableFactory.createPagedCallable(
            listPreviewsTransportSettings, settings.listPreviewsSettings(), clientContext);
    this.deletePreviewCallable =
        callableFactory.createUnaryCallable(
            deletePreviewTransportSettings, settings.deletePreviewSettings(), clientContext);
    this.deletePreviewOperationCallable =
        callableFactory.createOperationCallable(
            deletePreviewTransportSettings,
            settings.deletePreviewOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportPreviewResultCallable =
        callableFactory.createUnaryCallable(
            exportPreviewResultTransportSettings,
            settings.exportPreviewResultSettings(),
            clientContext);
    this.listTerraformVersionsCallable =
        callableFactory.createUnaryCallable(
            listTerraformVersionsTransportSettings,
            settings.listTerraformVersionsSettings(),
            clientContext);
    this.listTerraformVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listTerraformVersionsTransportSettings,
            settings.listTerraformVersionsSettings(),
            clientContext);
    this.getTerraformVersionCallable =
        callableFactory.createUnaryCallable(
            getTerraformVersionTransportSettings,
            settings.getTerraformVersionSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    methodDescriptors.add(listDeploymentsMethodDescriptor);
    methodDescriptors.add(getDeploymentMethodDescriptor);
    methodDescriptors.add(createDeploymentMethodDescriptor);
    methodDescriptors.add(updateDeploymentMethodDescriptor);
    methodDescriptors.add(deleteDeploymentMethodDescriptor);
    methodDescriptors.add(listRevisionsMethodDescriptor);
    methodDescriptors.add(getRevisionMethodDescriptor);
    methodDescriptors.add(getResourceMethodDescriptor);
    methodDescriptors.add(listResourcesMethodDescriptor);
    methodDescriptors.add(exportDeploymentStatefileMethodDescriptor);
    methodDescriptors.add(exportRevisionStatefileMethodDescriptor);
    methodDescriptors.add(importStatefileMethodDescriptor);
    methodDescriptors.add(deleteStatefileMethodDescriptor);
    methodDescriptors.add(lockDeploymentMethodDescriptor);
    methodDescriptors.add(unlockDeploymentMethodDescriptor);
    methodDescriptors.add(exportLockInfoMethodDescriptor);
    methodDescriptors.add(createPreviewMethodDescriptor);
    methodDescriptors.add(getPreviewMethodDescriptor);
    methodDescriptors.add(listPreviewsMethodDescriptor);
    methodDescriptors.add(deletePreviewMethodDescriptor);
    methodDescriptors.add(exportPreviewResultMethodDescriptor);
    methodDescriptors.add(listTerraformVersionsMethodDescriptor);
    methodDescriptors.add(getTerraformVersionMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Operation> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public OperationCallable<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationCallable() {
    return createDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDeploymentRequest, Operation> updateDeploymentCallable() {
    return updateDeploymentCallable;
  }

  @Override
  public OperationCallable<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationCallable() {
    return updateDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Operation> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public OperationCallable<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationCallable() {
    return deleteDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    return listRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    return listRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    return getRevisionCallable;
  }

  @Override
  public UnaryCallable<GetResourceRequest, Resource> getResourceCallable() {
    return getResourceCallable;
  }

  @Override
  public UnaryCallable<ListResourcesRequest, ListResourcesResponse> listResourcesCallable() {
    return listResourcesCallable;
  }

  @Override
  public UnaryCallable<ListResourcesRequest, ListResourcesPagedResponse>
      listResourcesPagedCallable() {
    return listResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileCallable() {
    return exportDeploymentStatefileCallable;
  }

  @Override
  public UnaryCallable<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileCallable() {
    return exportRevisionStatefileCallable;
  }

  @Override
  public UnaryCallable<ImportStatefileRequest, Statefile> importStatefileCallable() {
    return importStatefileCallable;
  }

  @Override
  public UnaryCallable<DeleteStatefileRequest, Empty> deleteStatefileCallable() {
    return deleteStatefileCallable;
  }

  @Override
  public UnaryCallable<LockDeploymentRequest, Operation> lockDeploymentCallable() {
    return lockDeploymentCallable;
  }

  @Override
  public OperationCallable<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationCallable() {
    return lockDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<UnlockDeploymentRequest, Operation> unlockDeploymentCallable() {
    return unlockDeploymentCallable;
  }

  @Override
  public OperationCallable<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationCallable() {
    return unlockDeploymentOperationCallable;
  }

  @Override
  public UnaryCallable<ExportLockInfoRequest, LockInfo> exportLockInfoCallable() {
    return exportLockInfoCallable;
  }

  @Override
  public UnaryCallable<CreatePreviewRequest, Operation> createPreviewCallable() {
    return createPreviewCallable;
  }

  @Override
  public OperationCallable<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationCallable() {
    return createPreviewOperationCallable;
  }

  @Override
  public UnaryCallable<GetPreviewRequest, Preview> getPreviewCallable() {
    return getPreviewCallable;
  }

  @Override
  public UnaryCallable<ListPreviewsRequest, ListPreviewsResponse> listPreviewsCallable() {
    return listPreviewsCallable;
  }

  @Override
  public UnaryCallable<ListPreviewsRequest, ListPreviewsPagedResponse> listPreviewsPagedCallable() {
    return listPreviewsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePreviewRequest, Operation> deletePreviewCallable() {
    return deletePreviewCallable;
  }

  @Override
  public OperationCallable<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationCallable() {
    return deletePreviewOperationCallable;
  }

  @Override
  public UnaryCallable<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultCallable() {
    return exportPreviewResultCallable;
  }

  @Override
  public UnaryCallable<ListTerraformVersionsRequest, ListTerraformVersionsResponse>
      listTerraformVersionsCallable() {
    return listTerraformVersionsCallable;
  }

  @Override
  public UnaryCallable<ListTerraformVersionsRequest, ListTerraformVersionsPagedResponse>
      listTerraformVersionsPagedCallable() {
    return listTerraformVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTerraformVersionRequest, TerraformVersion> getTerraformVersionCallable() {
    return getTerraformVersionCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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
