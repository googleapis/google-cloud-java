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

package com.google.cloud.dataproc.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.CreateNodeGroupRequest;
import com.google.cloud.dataproc.v1.GetNodeGroupRequest;
import com.google.cloud.dataproc.v1.NodeGroup;
import com.google.cloud.dataproc.v1.NodeGroupOperationMetadata;
import com.google.cloud.dataproc.v1.ResizeNodeGroupRequest;
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NodeGroupController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNodeGroupControllerStub extends NodeGroupControllerStub {
  private static final MethodDescriptor<CreateNodeGroupRequest, Operation>
      createNodeGroupMethodDescriptor =
          MethodDescriptor.<CreateNodeGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1.NodeGroupController/CreateNodeGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNodeGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ResizeNodeGroupRequest, Operation>
      resizeNodeGroupMethodDescriptor =
          MethodDescriptor.<ResizeNodeGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1.NodeGroupController/ResizeNodeGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResizeNodeGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetNodeGroupRequest, NodeGroup>
      getNodeGroupMethodDescriptor =
          MethodDescriptor.<GetNodeGroupRequest, NodeGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1.NodeGroupController/GetNodeGroup")
              .setRequestMarshaller(ProtoUtils.marshaller(GetNodeGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NodeGroup.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateNodeGroupRequest, Operation> createNodeGroupCallable;
  private final OperationCallable<CreateNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      createNodeGroupOperationCallable;
  private final UnaryCallable<ResizeNodeGroupRequest, Operation> resizeNodeGroupCallable;
  private final OperationCallable<ResizeNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      resizeNodeGroupOperationCallable;
  private final UnaryCallable<GetNodeGroupRequest, NodeGroup> getNodeGroupCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNodeGroupControllerStub create(NodeGroupControllerStubSettings settings)
      throws IOException {
    return new GrpcNodeGroupControllerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNodeGroupControllerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNodeGroupControllerStub(
        NodeGroupControllerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNodeGroupControllerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNodeGroupControllerStub(
        NodeGroupControllerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNodeGroupControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNodeGroupControllerStub(
      NodeGroupControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNodeGroupControllerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNodeGroupControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNodeGroupControllerStub(
      NodeGroupControllerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateNodeGroupRequest, Operation> createNodeGroupTransportSettings =
        GrpcCallSettings.<CreateNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodeGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResizeNodeGroupRequest, Operation> resizeNodeGroupTransportSettings =
        GrpcCallSettings.<ResizeNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeNodeGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNodeGroupRequest, NodeGroup> getNodeGroupTransportSettings =
        GrpcCallSettings.<GetNodeGroupRequest, NodeGroup>newBuilder()
            .setMethodDescriptor(getNodeGroupMethodDescriptor)
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

    this.createNodeGroupCallable =
        callableFactory.createUnaryCallable(
            createNodeGroupTransportSettings, settings.createNodeGroupSettings(), clientContext);
    this.createNodeGroupOperationCallable =
        callableFactory.createOperationCallable(
            createNodeGroupTransportSettings,
            settings.createNodeGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.resizeNodeGroupCallable =
        callableFactory.createUnaryCallable(
            resizeNodeGroupTransportSettings, settings.resizeNodeGroupSettings(), clientContext);
    this.resizeNodeGroupOperationCallable =
        callableFactory.createOperationCallable(
            resizeNodeGroupTransportSettings,
            settings.resizeNodeGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.getNodeGroupCallable =
        callableFactory.createUnaryCallable(
            getNodeGroupTransportSettings, settings.getNodeGroupSettings(), clientContext);
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
  public UnaryCallable<CreateNodeGroupRequest, Operation> createNodeGroupCallable() {
    return createNodeGroupCallable;
  }

  @Override
  public OperationCallable<CreateNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      createNodeGroupOperationCallable() {
    return createNodeGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ResizeNodeGroupRequest, Operation> resizeNodeGroupCallable() {
    return resizeNodeGroupCallable;
  }

  @Override
  public OperationCallable<ResizeNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      resizeNodeGroupOperationCallable() {
    return resizeNodeGroupOperationCallable;
  }

  @Override
  public UnaryCallable<GetNodeGroupRequest, NodeGroup> getNodeGroupCallable() {
    return getNodeGroupCallable;
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
