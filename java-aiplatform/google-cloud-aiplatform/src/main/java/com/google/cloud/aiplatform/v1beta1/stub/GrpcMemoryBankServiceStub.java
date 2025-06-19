/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListMemoriesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.GetMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.Memory;
import com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MemoryBankService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMemoryBankServiceStub extends MemoryBankServiceStub {
  private static final MethodDescriptor<CreateMemoryRequest, Operation>
      createMemoryMethodDescriptor =
          MethodDescriptor.<CreateMemoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MemoryBankService/CreateMemory")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateMemoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMemoryRequest, Memory> getMemoryMethodDescriptor =
      MethodDescriptor.<GetMemoryRequest, Memory>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.MemoryBankService/GetMemory")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMemoryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Memory.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateMemoryRequest, Operation>
      updateMemoryMethodDescriptor =
          MethodDescriptor.<UpdateMemoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MemoryBankService/UpdateMemory")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateMemoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMemoriesRequest, ListMemoriesResponse>
      listMemoriesMethodDescriptor =
          MethodDescriptor.<ListMemoriesRequest, ListMemoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MemoryBankService/ListMemories")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMemoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMemoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMemoryRequest, Operation>
      deleteMemoryMethodDescriptor =
          MethodDescriptor.<DeleteMemoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.MemoryBankService/DeleteMemory")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteMemoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateMemoriesRequest, Operation>
      generateMemoriesMethodDescriptor =
          MethodDescriptor.<GenerateMemoriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MemoryBankService/GenerateMemories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateMemoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesMethodDescriptor =
          MethodDescriptor.<RetrieveMemoriesRequest, RetrieveMemoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.MemoryBankService/RetrieveMemories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveMemoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetrieveMemoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateMemoryRequest, Operation> createMemoryCallable;
  private final OperationCallable<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
      createMemoryOperationCallable;
  private final UnaryCallable<GetMemoryRequest, Memory> getMemoryCallable;
  private final UnaryCallable<UpdateMemoryRequest, Operation> updateMemoryCallable;
  private final OperationCallable<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
      updateMemoryOperationCallable;
  private final UnaryCallable<ListMemoriesRequest, ListMemoriesResponse> listMemoriesCallable;
  private final UnaryCallable<ListMemoriesRequest, ListMemoriesPagedResponse>
      listMemoriesPagedCallable;
  private final UnaryCallable<DeleteMemoryRequest, Operation> deleteMemoryCallable;
  private final OperationCallable<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
      deleteMemoryOperationCallable;
  private final UnaryCallable<GenerateMemoriesRequest, Operation> generateMemoriesCallable;
  private final OperationCallable<
          GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesOperationCallable;
  private final UnaryCallable<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMemoryBankServiceStub create(MemoryBankServiceStubSettings settings)
      throws IOException {
    return new GrpcMemoryBankServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMemoryBankServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMemoryBankServiceStub(
        MemoryBankServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMemoryBankServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMemoryBankServiceStub(
        MemoryBankServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMemoryBankServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMemoryBankServiceStub(
      MemoryBankServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMemoryBankServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMemoryBankServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMemoryBankServiceStub(
      MemoryBankServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateMemoryRequest, Operation> createMemoryTransportSettings =
        GrpcCallSettings.<CreateMemoryRequest, Operation>newBuilder()
            .setMethodDescriptor(createMemoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetMemoryRequest, Memory> getMemoryTransportSettings =
        GrpcCallSettings.<GetMemoryRequest, Memory>newBuilder()
            .setMethodDescriptor(getMemoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMemoryRequest, Operation> updateMemoryTransportSettings =
        GrpcCallSettings.<UpdateMemoryRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMemoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("memory.name", String.valueOf(request.getMemory().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMemoriesRequest, ListMemoriesResponse> listMemoriesTransportSettings =
        GrpcCallSettings.<ListMemoriesRequest, ListMemoriesResponse>newBuilder()
            .setMethodDescriptor(listMemoriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMemoryRequest, Operation> deleteMemoryTransportSettings =
        GrpcCallSettings.<DeleteMemoryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMemoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateMemoriesRequest, Operation> generateMemoriesTransportSettings =
        GrpcCallSettings.<GenerateMemoriesRequest, Operation>newBuilder()
            .setMethodDescriptor(generateMemoriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
        retrieveMemoriesTransportSettings =
            GrpcCallSettings.<RetrieveMemoriesRequest, RetrieveMemoriesResponse>newBuilder()
                .setMethodDescriptor(retrieveMemoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createMemoryCallable =
        callableFactory.createUnaryCallable(
            createMemoryTransportSettings, settings.createMemorySettings(), clientContext);
    this.createMemoryOperationCallable =
        callableFactory.createOperationCallable(
            createMemoryTransportSettings,
            settings.createMemoryOperationSettings(),
            clientContext,
            operationsStub);
    this.getMemoryCallable =
        callableFactory.createUnaryCallable(
            getMemoryTransportSettings, settings.getMemorySettings(), clientContext);
    this.updateMemoryCallable =
        callableFactory.createUnaryCallable(
            updateMemoryTransportSettings, settings.updateMemorySettings(), clientContext);
    this.updateMemoryOperationCallable =
        callableFactory.createOperationCallable(
            updateMemoryTransportSettings,
            settings.updateMemoryOperationSettings(),
            clientContext,
            operationsStub);
    this.listMemoriesCallable =
        callableFactory.createUnaryCallable(
            listMemoriesTransportSettings, settings.listMemoriesSettings(), clientContext);
    this.listMemoriesPagedCallable =
        callableFactory.createPagedCallable(
            listMemoriesTransportSettings, settings.listMemoriesSettings(), clientContext);
    this.deleteMemoryCallable =
        callableFactory.createUnaryCallable(
            deleteMemoryTransportSettings, settings.deleteMemorySettings(), clientContext);
    this.deleteMemoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteMemoryTransportSettings,
            settings.deleteMemoryOperationSettings(),
            clientContext,
            operationsStub);
    this.generateMemoriesCallable =
        callableFactory.createUnaryCallable(
            generateMemoriesTransportSettings, settings.generateMemoriesSettings(), clientContext);
    this.generateMemoriesOperationCallable =
        callableFactory.createOperationCallable(
            generateMemoriesTransportSettings,
            settings.generateMemoriesOperationSettings(),
            clientContext,
            operationsStub);
    this.retrieveMemoriesCallable =
        callableFactory.createUnaryCallable(
            retrieveMemoriesTransportSettings, settings.retrieveMemoriesSettings(), clientContext);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateMemoryRequest, Operation> createMemoryCallable() {
    return createMemoryCallable;
  }

  @Override
  public OperationCallable<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
      createMemoryOperationCallable() {
    return createMemoryOperationCallable;
  }

  @Override
  public UnaryCallable<GetMemoryRequest, Memory> getMemoryCallable() {
    return getMemoryCallable;
  }

  @Override
  public UnaryCallable<UpdateMemoryRequest, Operation> updateMemoryCallable() {
    return updateMemoryCallable;
  }

  @Override
  public OperationCallable<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
      updateMemoryOperationCallable() {
    return updateMemoryOperationCallable;
  }

  @Override
  public UnaryCallable<ListMemoriesRequest, ListMemoriesResponse> listMemoriesCallable() {
    return listMemoriesCallable;
  }

  @Override
  public UnaryCallable<ListMemoriesRequest, ListMemoriesPagedResponse> listMemoriesPagedCallable() {
    return listMemoriesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteMemoryRequest, Operation> deleteMemoryCallable() {
    return deleteMemoryCallable;
  }

  @Override
  public OperationCallable<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
      deleteMemoryOperationCallable() {
    return deleteMemoryOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateMemoriesRequest, Operation> generateMemoriesCallable() {
    return generateMemoriesCallable;
  }

  @Override
  public OperationCallable<
          GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesOperationCallable() {
    return generateMemoriesOperationCallable;
  }

  @Override
  public UnaryCallable<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesCallable() {
    return retrieveMemoriesCallable;
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
