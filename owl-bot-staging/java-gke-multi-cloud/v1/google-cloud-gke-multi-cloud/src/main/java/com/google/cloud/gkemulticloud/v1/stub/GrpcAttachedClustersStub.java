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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AttachedClustersClient.ListAttachedClustersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AttachedCluster;
import com.google.cloud.gkemulticloud.v1.AttachedServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse;
import com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AttachedClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAttachedClustersStub extends AttachedClustersStub {
  private static final MethodDescriptor<CreateAttachedClusterRequest, Operation>
      createAttachedClusterMethodDescriptor =
          MethodDescriptor.<CreateAttachedClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/CreateAttachedCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAttachedClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterMethodDescriptor =
          MethodDescriptor.<UpdateAttachedClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/UpdateAttachedCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAttachedClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportAttachedClusterRequest, Operation>
      importAttachedClusterMethodDescriptor =
          MethodDescriptor.<ImportAttachedClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/ImportAttachedCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportAttachedClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterMethodDescriptor =
          MethodDescriptor.<GetAttachedClusterRequest, AttachedCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/GetAttachedCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAttachedClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AttachedCluster.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersMethodDescriptor =
          MethodDescriptor.<ListAttachedClustersRequest, ListAttachedClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/ListAttachedClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAttachedClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAttachedClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterMethodDescriptor =
          MethodDescriptor.<DeleteAttachedClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/DeleteAttachedCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAttachedClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigMethodDescriptor =
          MethodDescriptor.<GetAttachedServerConfigRequest, AttachedServerConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/GetAttachedServerConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAttachedServerConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AttachedServerConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestMethodDescriptor =
          MethodDescriptor
              .<GenerateAttachedClusterInstallManifestRequest,
                  GenerateAttachedClusterInstallManifestResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AttachedClusters/GenerateAttachedClusterInstallManifest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateAttachedClusterInstallManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GenerateAttachedClusterInstallManifestResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateAttachedClusterRequest, Operation>
      createAttachedClusterCallable;
  private final OperationCallable<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationCallable;
  private final UnaryCallable<UpdateAttachedClusterRequest, Operation>
      updateAttachedClusterCallable;
  private final OperationCallable<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationCallable;
  private final UnaryCallable<ImportAttachedClusterRequest, Operation>
      importAttachedClusterCallable;
  private final OperationCallable<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationCallable;
  private final UnaryCallable<GetAttachedClusterRequest, AttachedCluster>
      getAttachedClusterCallable;
  private final UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersCallable;
  private final UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersPagedResponse>
      listAttachedClustersPagedCallable;
  private final UnaryCallable<DeleteAttachedClusterRequest, Operation>
      deleteAttachedClusterCallable;
  private final OperationCallable<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationCallable;
  private final UnaryCallable<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigCallable;
  private final UnaryCallable<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAttachedClustersStub create(AttachedClustersStubSettings settings)
      throws IOException {
    return new GrpcAttachedClustersStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAttachedClustersStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAttachedClustersStub(
        AttachedClustersStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAttachedClustersStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAttachedClustersStub(
        AttachedClustersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAttachedClustersStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAttachedClustersStub(
      AttachedClustersStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAttachedClustersCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAttachedClustersStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAttachedClustersStub(
      AttachedClustersStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAttachedClusterRequest, Operation>
        createAttachedClusterTransportSettings =
            GrpcCallSettings.<CreateAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createAttachedClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateAttachedClusterRequest, Operation>
        updateAttachedClusterTransportSettings =
            GrpcCallSettings.<UpdateAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAttachedClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "attached_cluster.name",
                          String.valueOf(request.getAttachedCluster().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ImportAttachedClusterRequest, Operation>
        importAttachedClusterTransportSettings =
            GrpcCallSettings.<ImportAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(importAttachedClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAttachedClusterRequest, AttachedCluster>
        getAttachedClusterTransportSettings =
            GrpcCallSettings.<GetAttachedClusterRequest, AttachedCluster>newBuilder()
                .setMethodDescriptor(getAttachedClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListAttachedClustersRequest, ListAttachedClustersResponse>
        listAttachedClustersTransportSettings =
            GrpcCallSettings.<ListAttachedClustersRequest, ListAttachedClustersResponse>newBuilder()
                .setMethodDescriptor(listAttachedClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAttachedClusterRequest, Operation>
        deleteAttachedClusterTransportSettings =
            GrpcCallSettings.<DeleteAttachedClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAttachedClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAttachedServerConfigRequest, AttachedServerConfig>
        getAttachedServerConfigTransportSettings =
            GrpcCallSettings.<GetAttachedServerConfigRequest, AttachedServerConfig>newBuilder()
                .setMethodDescriptor(getAttachedServerConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            GenerateAttachedClusterInstallManifestRequest,
            GenerateAttachedClusterInstallManifestResponse>
        generateAttachedClusterInstallManifestTransportSettings =
            GrpcCallSettings
                .<GenerateAttachedClusterInstallManifestRequest,
                    GenerateAttachedClusterInstallManifestResponse>
                    newBuilder()
                .setMethodDescriptor(generateAttachedClusterInstallManifestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.createAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            createAttachedClusterTransportSettings,
            settings.createAttachedClusterSettings(),
            clientContext);
    this.createAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            createAttachedClusterTransportSettings,
            settings.createAttachedClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            updateAttachedClusterTransportSettings,
            settings.updateAttachedClusterSettings(),
            clientContext);
    this.updateAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateAttachedClusterTransportSettings,
            settings.updateAttachedClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.importAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            importAttachedClusterTransportSettings,
            settings.importAttachedClusterSettings(),
            clientContext);
    this.importAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            importAttachedClusterTransportSettings,
            settings.importAttachedClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.getAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            getAttachedClusterTransportSettings,
            settings.getAttachedClusterSettings(),
            clientContext);
    this.listAttachedClustersCallable =
        callableFactory.createUnaryCallable(
            listAttachedClustersTransportSettings,
            settings.listAttachedClustersSettings(),
            clientContext);
    this.listAttachedClustersPagedCallable =
        callableFactory.createPagedCallable(
            listAttachedClustersTransportSettings,
            settings.listAttachedClustersSettings(),
            clientContext);
    this.deleteAttachedClusterCallable =
        callableFactory.createUnaryCallable(
            deleteAttachedClusterTransportSettings,
            settings.deleteAttachedClusterSettings(),
            clientContext);
    this.deleteAttachedClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteAttachedClusterTransportSettings,
            settings.deleteAttachedClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.getAttachedServerConfigCallable =
        callableFactory.createUnaryCallable(
            getAttachedServerConfigTransportSettings,
            settings.getAttachedServerConfigSettings(),
            clientContext);
    this.generateAttachedClusterInstallManifestCallable =
        callableFactory.createUnaryCallable(
            generateAttachedClusterInstallManifestTransportSettings,
            settings.generateAttachedClusterInstallManifestSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateAttachedClusterRequest, Operation> createAttachedClusterCallable() {
    return createAttachedClusterCallable;
  }

  @Override
  public OperationCallable<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationCallable() {
    return createAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAttachedClusterRequest, Operation> updateAttachedClusterCallable() {
    return updateAttachedClusterCallable;
  }

  @Override
  public OperationCallable<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationCallable() {
    return updateAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ImportAttachedClusterRequest, Operation> importAttachedClusterCallable() {
    return importAttachedClusterCallable;
  }

  @Override
  public OperationCallable<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationCallable() {
    return importAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAttachedClusterRequest, AttachedCluster> getAttachedClusterCallable() {
    return getAttachedClusterCallable;
  }

  @Override
  public UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersCallable() {
    return listAttachedClustersCallable;
  }

  @Override
  public UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersPagedResponse>
      listAttachedClustersPagedCallable() {
    return listAttachedClustersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAttachedClusterRequest, Operation> deleteAttachedClusterCallable() {
    return deleteAttachedClusterCallable;
  }

  @Override
  public OperationCallable<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationCallable() {
    return deleteAttachedClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigCallable() {
    return getAttachedServerConfigCallable;
  }

  @Override
  public UnaryCallable<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestCallable() {
    return generateAttachedClusterInstallManifestCallable;
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
