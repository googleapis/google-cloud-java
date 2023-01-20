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

package com.google.storagetransfer.v1.proto.stub;

import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListAgentPoolsPagedResponse;
import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListTransferJobsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.storagetransfer.v1.proto.TransferProto;
import com.google.storagetransfer.v1.proto.TransferTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the StorageTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonStorageTransferServiceStub extends StorageTransferServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(TransferTypes.TransferOperation.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
                  newBuilder()
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/GetGoogleServiceAccount")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TransferProto.GetGoogleServiceAccountRequest>newBuilder()
                      .setPath(
                          "/v1/googleServiceAccounts/{projectId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.GetGoogleServiceAccountRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.GetGoogleServiceAccountRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferTypes.GoogleServiceAccount>newBuilder()
                      .setDefaultInstance(TransferTypes.GoogleServiceAccount.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/CreateTransferJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.CreateTransferJobRequest>newBuilder()
                      .setPath(
                          "/v1/transferJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.CreateTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.CreateTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("transferJob", request.getTransferJob(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferTypes.TransferJob>newBuilder()
                      .setDefaultInstance(TransferTypes.TransferJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/UpdateTransferJob")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.UpdateTransferJobRequest>newBuilder()
                      .setPath(
                          "/v1/{jobName=transferJobs/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.UpdateTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobName", request.getJobName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.UpdateTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearJobName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferTypes.TransferJob>newBuilder()
                      .setDefaultInstance(TransferTypes.TransferJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>newBuilder()
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/GetTransferJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.GetTransferJobRequest>newBuilder()
                      .setPath(
                          "/v1/{jobName=transferJobs/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.GetTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobName", request.getJobName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.GetTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "projectId", request.getProjectId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferTypes.TransferJob>newBuilder()
                      .setDefaultInstance(TransferTypes.TransferJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
      listTransferJobsMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/ListTransferJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.ListTransferJobsRequest>newBuilder()
                      .setPath(
                          "/v1/transferJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.ListTransferJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.ListTransferJobsRequest> serializer =
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
                  ProtoMessageResponseParser.<TransferProto.ListTransferJobsResponse>newBuilder()
                      .setDefaultInstance(
                          TransferProto.ListTransferJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationMethodDescriptor =
          ApiMethodDescriptor.<TransferProto.PauseTransferOperationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/PauseTransferOperation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TransferProto.PauseTransferOperationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=transferOperations/**}:pause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.PauseTransferOperationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.PauseTransferOperationRequest>
                                serializer = ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationMethodDescriptor =
          ApiMethodDescriptor.<TransferProto.ResumeTransferOperationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/ResumeTransferOperation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TransferProto.ResumeTransferOperationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=transferOperations/**}:resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.ResumeTransferOperationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.ResumeTransferOperationRequest>
                                serializer = ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<TransferProto.RunTransferJobRequest, Operation>
      runTransferJobMethodDescriptor =
          ApiMethodDescriptor.<TransferProto.RunTransferJobRequest, Operation>newBuilder()
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/RunTransferJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.RunTransferJobRequest>newBuilder()
                      .setPath(
                          "/v1/{jobName=transferJobs/**}:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.RunTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobName", request.getJobName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.RunTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearJobName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (TransferProto.RunTransferJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<TransferProto.DeleteTransferJobRequest, Empty>
      deleteTransferJobMethodDescriptor =
          ApiMethodDescriptor.<TransferProto.DeleteTransferJobRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/DeleteTransferJob")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.DeleteTransferJobRequest>newBuilder()
                      .setPath(
                          "/v1/{jobName=transferJobs/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.DeleteTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobName", request.getJobName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.DeleteTransferJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "projectId", request.getProjectId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/CreateAgentPool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.CreateAgentPoolRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId=*}/agentPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.CreateAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.CreateAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "agentPoolId", request.getAgentPoolId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("agentPool", request.getAgentPool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferTypes.AgentPool>newBuilder()
                      .setDefaultInstance(TransferTypes.AgentPool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/UpdateAgentPool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.UpdateAgentPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{agentPool.name=projects/*/agentPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.UpdateAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "agentPool.name", request.getAgentPool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.UpdateAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("agentPool", request.getAgentPool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferTypes.AgentPool>newBuilder()
                      .setDefaultInstance(TransferTypes.AgentPool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/GetAgentPool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.GetAgentPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/agentPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.GetAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.GetAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TransferTypes.AgentPool>newBuilder()
                      .setDefaultInstance(TransferTypes.AgentPool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
      listAgentPoolsMethodDescriptor =
          ApiMethodDescriptor
              .<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
                  newBuilder()
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/ListAgentPools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.ListAgentPoolsRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId=*}/agentPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.ListAgentPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.ListAgentPoolsRequest> serializer =
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
                  ProtoMessageResponseParser.<TransferProto.ListAgentPoolsResponse>newBuilder()
                      .setDefaultInstance(TransferProto.ListAgentPoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TransferProto.DeleteAgentPoolRequest, Empty>
      deleteAgentPoolMethodDescriptor =
          ApiMethodDescriptor.<TransferProto.DeleteAgentPoolRequest, Empty>newBuilder()
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/DeleteAgentPool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferProto.DeleteAgentPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/agentPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.DeleteAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferProto.DeleteAgentPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountCallable;
  private final UnaryCallable<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobCallable;
  private final UnaryCallable<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobCallable;
  private final UnaryCallable<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobCallable;
  private final UnaryCallable<
          TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
      listTransferJobsCallable;
  private final UnaryCallable<TransferProto.ListTransferJobsRequest, ListTransferJobsPagedResponse>
      listTransferJobsPagedCallable;
  private final UnaryCallable<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationCallable;
  private final UnaryCallable<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationCallable;
  private final UnaryCallable<TransferProto.RunTransferJobRequest, Operation>
      runTransferJobCallable;
  private final OperationCallable<
          TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
      runTransferJobOperationCallable;
  private final UnaryCallable<TransferProto.DeleteTransferJobRequest, Empty>
      deleteTransferJobCallable;
  private final UnaryCallable<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolCallable;
  private final UnaryCallable<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolCallable;
  private final UnaryCallable<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolCallable;
  private final UnaryCallable<
          TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
      listAgentPoolsCallable;
  private final UnaryCallable<TransferProto.ListAgentPoolsRequest, ListAgentPoolsPagedResponse>
      listAgentPoolsPagedCallable;
  private final UnaryCallable<TransferProto.DeleteAgentPoolRequest, Empty> deleteAgentPoolCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonStorageTransferServiceStub create(
      StorageTransferServiceStubSettings settings) throws IOException {
    return new HttpJsonStorageTransferServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonStorageTransferServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonStorageTransferServiceStub(
        StorageTransferServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonStorageTransferServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonStorageTransferServiceStub(
        StorageTransferServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonStorageTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageTransferServiceStub(
      StorageTransferServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonStorageTransferServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonStorageTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageTransferServiceStub(
      StorageTransferServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<
            TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
        getGoogleServiceAccountTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
                    newBuilder()
                .setMethodDescriptor(getGoogleServiceAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
        createTransferJobTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
                .setMethodDescriptor(createTransferJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
        updateTransferJobTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
                .setMethodDescriptor(updateTransferJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
        getTransferJobTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>newBuilder()
                .setMethodDescriptor(getTransferJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
        listTransferJobsTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
                    newBuilder()
                .setMethodDescriptor(listTransferJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.PauseTransferOperationRequest, Empty>
        pauseTransferOperationTransportSettings =
            HttpJsonCallSettings.<TransferProto.PauseTransferOperationRequest, Empty>newBuilder()
                .setMethodDescriptor(pauseTransferOperationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.ResumeTransferOperationRequest, Empty>
        resumeTransferOperationTransportSettings =
            HttpJsonCallSettings.<TransferProto.ResumeTransferOperationRequest, Empty>newBuilder()
                .setMethodDescriptor(resumeTransferOperationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.RunTransferJobRequest, Operation>
        runTransferJobTransportSettings =
            HttpJsonCallSettings.<TransferProto.RunTransferJobRequest, Operation>newBuilder()
                .setMethodDescriptor(runTransferJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.DeleteTransferJobRequest, Empty>
        deleteTransferJobTransportSettings =
            HttpJsonCallSettings.<TransferProto.DeleteTransferJobRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteTransferJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
        createAgentPoolTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
                .setMethodDescriptor(createAgentPoolMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
        updateAgentPoolTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
                .setMethodDescriptor(updateAgentPoolMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
        getAgentPoolTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
                .setMethodDescriptor(getAgentPoolMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
        listAgentPoolsTransportSettings =
            HttpJsonCallSettings
                .<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
                    newBuilder()
                .setMethodDescriptor(listAgentPoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferProto.DeleteAgentPoolRequest, Empty>
        deleteAgentPoolTransportSettings =
            HttpJsonCallSettings.<TransferProto.DeleteAgentPoolRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAgentPoolMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getGoogleServiceAccountCallable =
        callableFactory.createUnaryCallable(
            getGoogleServiceAccountTransportSettings,
            settings.getGoogleServiceAccountSettings(),
            clientContext);
    this.createTransferJobCallable =
        callableFactory.createUnaryCallable(
            createTransferJobTransportSettings,
            settings.createTransferJobSettings(),
            clientContext);
    this.updateTransferJobCallable =
        callableFactory.createUnaryCallable(
            updateTransferJobTransportSettings,
            settings.updateTransferJobSettings(),
            clientContext);
    this.getTransferJobCallable =
        callableFactory.createUnaryCallable(
            getTransferJobTransportSettings, settings.getTransferJobSettings(), clientContext);
    this.listTransferJobsCallable =
        callableFactory.createUnaryCallable(
            listTransferJobsTransportSettings, settings.listTransferJobsSettings(), clientContext);
    this.listTransferJobsPagedCallable =
        callableFactory.createPagedCallable(
            listTransferJobsTransportSettings, settings.listTransferJobsSettings(), clientContext);
    this.pauseTransferOperationCallable =
        callableFactory.createUnaryCallable(
            pauseTransferOperationTransportSettings,
            settings.pauseTransferOperationSettings(),
            clientContext);
    this.resumeTransferOperationCallable =
        callableFactory.createUnaryCallable(
            resumeTransferOperationTransportSettings,
            settings.resumeTransferOperationSettings(),
            clientContext);
    this.runTransferJobCallable =
        callableFactory.createUnaryCallable(
            runTransferJobTransportSettings, settings.runTransferJobSettings(), clientContext);
    this.runTransferJobOperationCallable =
        callableFactory.createOperationCallable(
            runTransferJobTransportSettings,
            settings.runTransferJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTransferJobCallable =
        callableFactory.createUnaryCallable(
            deleteTransferJobTransportSettings,
            settings.deleteTransferJobSettings(),
            clientContext);
    this.createAgentPoolCallable =
        callableFactory.createUnaryCallable(
            createAgentPoolTransportSettings, settings.createAgentPoolSettings(), clientContext);
    this.updateAgentPoolCallable =
        callableFactory.createUnaryCallable(
            updateAgentPoolTransportSettings, settings.updateAgentPoolSettings(), clientContext);
    this.getAgentPoolCallable =
        callableFactory.createUnaryCallable(
            getAgentPoolTransportSettings, settings.getAgentPoolSettings(), clientContext);
    this.listAgentPoolsCallable =
        callableFactory.createUnaryCallable(
            listAgentPoolsTransportSettings, settings.listAgentPoolsSettings(), clientContext);
    this.listAgentPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listAgentPoolsTransportSettings, settings.listAgentPoolsSettings(), clientContext);
    this.deleteAgentPoolCallable =
        callableFactory.createUnaryCallable(
            deleteAgentPoolTransportSettings, settings.deleteAgentPoolSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getGoogleServiceAccountMethodDescriptor);
    methodDescriptors.add(createTransferJobMethodDescriptor);
    methodDescriptors.add(updateTransferJobMethodDescriptor);
    methodDescriptors.add(getTransferJobMethodDescriptor);
    methodDescriptors.add(listTransferJobsMethodDescriptor);
    methodDescriptors.add(pauseTransferOperationMethodDescriptor);
    methodDescriptors.add(resumeTransferOperationMethodDescriptor);
    methodDescriptors.add(runTransferJobMethodDescriptor);
    methodDescriptors.add(deleteTransferJobMethodDescriptor);
    methodDescriptors.add(createAgentPoolMethodDescriptor);
    methodDescriptors.add(updateAgentPoolMethodDescriptor);
    methodDescriptors.add(getAgentPoolMethodDescriptor);
    methodDescriptors.add(listAgentPoolsMethodDescriptor);
    methodDescriptors.add(deleteAgentPoolMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountCallable() {
    return getGoogleServiceAccountCallable;
  }

  @Override
  public UnaryCallable<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobCallable() {
    return createTransferJobCallable;
  }

  @Override
  public UnaryCallable<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobCallable() {
    return updateTransferJobCallable;
  }

  @Override
  public UnaryCallable<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobCallable() {
    return getTransferJobCallable;
  }

  @Override
  public UnaryCallable<
          TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
      listTransferJobsCallable() {
    return listTransferJobsCallable;
  }

  @Override
  public UnaryCallable<TransferProto.ListTransferJobsRequest, ListTransferJobsPagedResponse>
      listTransferJobsPagedCallable() {
    return listTransferJobsPagedCallable;
  }

  @Override
  public UnaryCallable<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationCallable() {
    return pauseTransferOperationCallable;
  }

  @Override
  public UnaryCallable<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationCallable() {
    return resumeTransferOperationCallable;
  }

  @Override
  public UnaryCallable<TransferProto.RunTransferJobRequest, Operation> runTransferJobCallable() {
    return runTransferJobCallable;
  }

  @Override
  public OperationCallable<
          TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
      runTransferJobOperationCallable() {
    return runTransferJobOperationCallable;
  }

  @Override
  public UnaryCallable<TransferProto.DeleteTransferJobRequest, Empty> deleteTransferJobCallable() {
    return deleteTransferJobCallable;
  }

  @Override
  public UnaryCallable<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolCallable() {
    return createAgentPoolCallable;
  }

  @Override
  public UnaryCallable<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolCallable() {
    return updateAgentPoolCallable;
  }

  @Override
  public UnaryCallable<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolCallable() {
    return getAgentPoolCallable;
  }

  @Override
  public UnaryCallable<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
      listAgentPoolsCallable() {
    return listAgentPoolsCallable;
  }

  @Override
  public UnaryCallable<TransferProto.ListAgentPoolsRequest, ListAgentPoolsPagedResponse>
      listAgentPoolsPagedCallable() {
    return listAgentPoolsPagedCallable;
  }

  @Override
  public UnaryCallable<TransferProto.DeleteAgentPoolRequest, Empty> deleteAgentPoolCallable() {
    return deleteAgentPoolCallable;
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
