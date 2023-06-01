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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.storagetransfer.v1.proto.TransferProto;
import com.google.storagetransfer.v1.proto.TransferTypes;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the StorageTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStorageTransferServiceStub extends StorageTransferServiceStub {
  private static final MethodDescriptor<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountMethodDescriptor =
          MethodDescriptor
              .<TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/GetGoogleServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      TransferProto.GetGoogleServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferTypes.GoogleServiceAccount.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobMethodDescriptor =
          MethodDescriptor
              .<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/CreateTransferJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      TransferProto.CreateTransferJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferTypes.TransferJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobMethodDescriptor =
          MethodDescriptor
              .<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/UpdateTransferJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      TransferProto.UpdateTransferJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferTypes.TransferJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobMethodDescriptor =
          MethodDescriptor
              .<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/GetTransferJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.GetTransferJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferTypes.TransferJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
      listTransferJobsMethodDescriptor =
          MethodDescriptor
              .<TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/ListTransferJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.ListTransferJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      TransferProto.ListTransferJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationMethodDescriptor =
          MethodDescriptor.<TransferProto.PauseTransferOperationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/PauseTransferOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      TransferProto.PauseTransferOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationMethodDescriptor =
          MethodDescriptor.<TransferProto.ResumeTransferOperationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/ResumeTransferOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      TransferProto.ResumeTransferOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferProto.RunTransferJobRequest, Operation>
      runTransferJobMethodDescriptor =
          MethodDescriptor.<TransferProto.RunTransferJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/RunTransferJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.RunTransferJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferProto.DeleteTransferJobRequest, Empty>
      deleteTransferJobMethodDescriptor =
          MethodDescriptor.<TransferProto.DeleteTransferJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storagetransfer.v1.StorageTransferService/DeleteTransferJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      TransferProto.DeleteTransferJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolMethodDescriptor =
          MethodDescriptor
              .<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/CreateAgentPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.CreateAgentPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferTypes.AgentPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolMethodDescriptor =
          MethodDescriptor
              .<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/UpdateAgentPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.UpdateAgentPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferTypes.AgentPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolMethodDescriptor =
          MethodDescriptor.<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/GetAgentPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.GetAgentPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferTypes.AgentPool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
      listAgentPoolsMethodDescriptor =
          MethodDescriptor
              .<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/ListAgentPools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.ListAgentPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TransferProto.ListAgentPoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferProto.DeleteAgentPoolRequest, Empty>
      deleteAgentPoolMethodDescriptor =
          MethodDescriptor.<TransferProto.DeleteAgentPoolRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storagetransfer.v1.StorageTransferService/DeleteAgentPool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferProto.DeleteAgentPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcStorageTransferServiceStub create(
      StorageTransferServiceStubSettings settings) throws IOException {
    return new GrpcStorageTransferServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStorageTransferServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcStorageTransferServiceStub(
        StorageTransferServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStorageTransferServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStorageTransferServiceStub(
        StorageTransferServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcStorageTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcStorageTransferServiceStub(
      StorageTransferServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcStorageTransferServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStorageTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcStorageTransferServiceStub(
      StorageTransferServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
        getGoogleServiceAccountTransportSettings =
            GrpcCallSettings
                .<TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
                    newBuilder()
                .setMethodDescriptor(getGoogleServiceAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
        createTransferJobTransportSettings =
            GrpcCallSettings
                .<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
                .setMethodDescriptor(createTransferJobMethodDescriptor)
                .build();
    GrpcCallSettings<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
        updateTransferJobTransportSettings =
            GrpcCallSettings
                .<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>newBuilder()
                .setMethodDescriptor(updateTransferJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("job_name", String.valueOf(request.getJobName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
        getTransferJobTransportSettings =
            GrpcCallSettings
                .<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>newBuilder()
                .setMethodDescriptor(getTransferJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("job_name", String.valueOf(request.getJobName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
        listTransferJobsTransportSettings =
            GrpcCallSettings
                .<TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
                    newBuilder()
                .setMethodDescriptor(listTransferJobsMethodDescriptor)
                .build();
    GrpcCallSettings<TransferProto.PauseTransferOperationRequest, Empty>
        pauseTransferOperationTransportSettings =
            GrpcCallSettings.<TransferProto.PauseTransferOperationRequest, Empty>newBuilder()
                .setMethodDescriptor(pauseTransferOperationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.ResumeTransferOperationRequest, Empty>
        resumeTransferOperationTransportSettings =
            GrpcCallSettings.<TransferProto.ResumeTransferOperationRequest, Empty>newBuilder()
                .setMethodDescriptor(resumeTransferOperationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.RunTransferJobRequest, Operation>
        runTransferJobTransportSettings =
            GrpcCallSettings.<TransferProto.RunTransferJobRequest, Operation>newBuilder()
                .setMethodDescriptor(runTransferJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("job_name", String.valueOf(request.getJobName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.DeleteTransferJobRequest, Empty>
        deleteTransferJobTransportSettings =
            GrpcCallSettings.<TransferProto.DeleteTransferJobRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteTransferJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("job_name", String.valueOf(request.getJobName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
        createAgentPoolTransportSettings =
            GrpcCallSettings
                .<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
                .setMethodDescriptor(createAgentPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
        updateAgentPoolTransportSettings =
            GrpcCallSettings
                .<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
                .setMethodDescriptor(updateAgentPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "agent_pool.name", String.valueOf(request.getAgentPool().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
        getAgentPoolTransportSettings =
            GrpcCallSettings
                .<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>newBuilder()
                .setMethodDescriptor(getAgentPoolMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
        listAgentPoolsTransportSettings =
            GrpcCallSettings
                .<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
                    newBuilder()
                .setMethodDescriptor(listAgentPoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("project_id", String.valueOf(request.getProjectId()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<TransferProto.DeleteAgentPoolRequest, Empty> deleteAgentPoolTransportSettings =
        GrpcCallSettings.<TransferProto.DeleteAgentPoolRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAgentPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
