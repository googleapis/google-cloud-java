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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.FoldersClient.ListFoldersPagedResponse;
import static com.google.cloud.resourcemanager.v3.FoldersClient.SearchFoldersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateFolderMetadata;
import com.google.cloud.resourcemanager.v3.CreateFolderRequest;
import com.google.cloud.resourcemanager.v3.DeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.DeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.Folder;
import com.google.cloud.resourcemanager.v3.GetFolderRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersResponse;
import com.google.cloud.resourcemanager.v3.MoveFolderMetadata;
import com.google.cloud.resourcemanager.v3.MoveFolderRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersResponse;
import com.google.cloud.resourcemanager.v3.UndeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.UndeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.UpdateFolderMetadata;
import com.google.cloud.resourcemanager.v3.UpdateFolderRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Folders service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcFoldersStub extends FoldersStub {
  private static final MethodDescriptor<GetFolderRequest, Folder> getFolderMethodDescriptor =
      MethodDescriptor.<GetFolderRequest, Folder>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Folders/GetFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Folder.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListFoldersRequest, ListFoldersResponse>
      listFoldersMethodDescriptor =
          MethodDescriptor.<ListFoldersRequest, ListFoldersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/ListFolders")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFoldersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFoldersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchFoldersRequest, SearchFoldersResponse>
      searchFoldersMethodDescriptor =
          MethodDescriptor.<SearchFoldersRequest, SearchFoldersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/SearchFolders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchFoldersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchFoldersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFolderRequest, Operation>
      createFolderMethodDescriptor =
          MethodDescriptor.<CreateFolderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/CreateFolder")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFolderRequest, Operation>
      updateFolderMethodDescriptor =
          MethodDescriptor.<UpdateFolderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/UpdateFolder")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MoveFolderRequest, Operation> moveFolderMethodDescriptor =
      MethodDescriptor.<MoveFolderRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Folders/MoveFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(MoveFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteFolderRequest, Operation>
      deleteFolderMethodDescriptor =
          MethodDescriptor.<DeleteFolderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/DeleteFolder")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteFolderRequest, Operation>
      undeleteFolderMethodDescriptor =
          MethodDescriptor.<UndeleteFolderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/UndeleteFolder")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Folders/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.Folders/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.Folders/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetFolderRequest, Folder> getFolderCallable;
  private final UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable;
  private final UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse>
      listFoldersPagedCallable;
  private final UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable;
  private final UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable;
  private final UnaryCallable<CreateFolderRequest, Operation> createFolderCallable;
  private final OperationCallable<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationCallable;
  private final UnaryCallable<UpdateFolderRequest, Operation> updateFolderCallable;
  private final OperationCallable<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationCallable;
  private final UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable;
  private final OperationCallable<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationCallable;
  private final UnaryCallable<DeleteFolderRequest, Operation> deleteFolderCallable;
  private final OperationCallable<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationCallable;
  private final UnaryCallable<UndeleteFolderRequest, Operation> undeleteFolderCallable;
  private final OperationCallable<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFoldersStub create(FoldersStubSettings settings) throws IOException {
    return new GrpcFoldersStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFoldersStub create(ClientContext clientContext) throws IOException {
    return new GrpcFoldersStub(FoldersStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFoldersStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFoldersStub(
        FoldersStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFoldersStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFoldersStub(FoldersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFoldersCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFoldersStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFoldersStub(
      FoldersStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetFolderRequest, Folder> getFolderTransportSettings =
        GrpcCallSettings.<GetFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(getFolderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListFoldersRequest, ListFoldersResponse> listFoldersTransportSettings =
        GrpcCallSettings.<ListFoldersRequest, ListFoldersResponse>newBuilder()
            .setMethodDescriptor(listFoldersMethodDescriptor)
            .build();
    GrpcCallSettings<SearchFoldersRequest, SearchFoldersResponse> searchFoldersTransportSettings =
        GrpcCallSettings.<SearchFoldersRequest, SearchFoldersResponse>newBuilder()
            .setMethodDescriptor(searchFoldersMethodDescriptor)
            .build();
    GrpcCallSettings<CreateFolderRequest, Operation> createFolderTransportSettings =
        GrpcCallSettings.<CreateFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(createFolderMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateFolderRequest, Operation> updateFolderTransportSettings =
        GrpcCallSettings.<UpdateFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFolderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("folder.name", String.valueOf(request.getFolder().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<MoveFolderRequest, Operation> moveFolderTransportSettings =
        GrpcCallSettings.<MoveFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(moveFolderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteFolderRequest, Operation> deleteFolderTransportSettings =
        GrpcCallSettings.<DeleteFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFolderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeleteFolderRequest, Operation> undeleteFolderTransportSettings =
        GrpcCallSettings.<UndeleteFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteFolderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();

    this.getFolderCallable =
        callableFactory.createUnaryCallable(
            getFolderTransportSettings, settings.getFolderSettings(), clientContext);
    this.listFoldersCallable =
        callableFactory.createUnaryCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.listFoldersPagedCallable =
        callableFactory.createPagedCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.searchFoldersCallable =
        callableFactory.createUnaryCallable(
            searchFoldersTransportSettings, settings.searchFoldersSettings(), clientContext);
    this.searchFoldersPagedCallable =
        callableFactory.createPagedCallable(
            searchFoldersTransportSettings, settings.searchFoldersSettings(), clientContext);
    this.createFolderCallable =
        callableFactory.createUnaryCallable(
            createFolderTransportSettings, settings.createFolderSettings(), clientContext);
    this.createFolderOperationCallable =
        callableFactory.createOperationCallable(
            createFolderTransportSettings,
            settings.createFolderOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFolderCallable =
        callableFactory.createUnaryCallable(
            updateFolderTransportSettings, settings.updateFolderSettings(), clientContext);
    this.updateFolderOperationCallable =
        callableFactory.createOperationCallable(
            updateFolderTransportSettings,
            settings.updateFolderOperationSettings(),
            clientContext,
            operationsStub);
    this.moveFolderCallable =
        callableFactory.createUnaryCallable(
            moveFolderTransportSettings, settings.moveFolderSettings(), clientContext);
    this.moveFolderOperationCallable =
        callableFactory.createOperationCallable(
            moveFolderTransportSettings,
            settings.moveFolderOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFolderCallable =
        callableFactory.createUnaryCallable(
            deleteFolderTransportSettings, settings.deleteFolderSettings(), clientContext);
    this.deleteFolderOperationCallable =
        callableFactory.createOperationCallable(
            deleteFolderTransportSettings,
            settings.deleteFolderOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteFolderCallable =
        callableFactory.createUnaryCallable(
            undeleteFolderTransportSettings, settings.undeleteFolderSettings(), clientContext);
    this.undeleteFolderOperationCallable =
        callableFactory.createOperationCallable(
            undeleteFolderTransportSettings,
            settings.undeleteFolderOperationSettings(),
            clientContext,
            operationsStub);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    return getFolderCallable;
  }

  @Override
  public UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    return listFoldersCallable;
  }

  @Override
  public UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse> listFoldersPagedCallable() {
    return listFoldersPagedCallable;
  }

  @Override
  public UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable() {
    return searchFoldersCallable;
  }

  @Override
  public UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable() {
    return searchFoldersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateFolderRequest, Operation> createFolderCallable() {
    return createFolderCallable;
  }

  @Override
  public OperationCallable<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationCallable() {
    return createFolderOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFolderRequest, Operation> updateFolderCallable() {
    return updateFolderCallable;
  }

  @Override
  public OperationCallable<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationCallable() {
    return updateFolderOperationCallable;
  }

  @Override
  public UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable() {
    return moveFolderCallable;
  }

  @Override
  public OperationCallable<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationCallable() {
    return moveFolderOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFolderRequest, Operation> deleteFolderCallable() {
    return deleteFolderCallable;
  }

  @Override
  public OperationCallable<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationCallable() {
    return deleteFolderOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteFolderRequest, Operation> undeleteFolderCallable() {
    return undeleteFolderCallable;
  }

  @Override
  public OperationCallable<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationCallable() {
    return undeleteFolderOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
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
