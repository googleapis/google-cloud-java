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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.AutoscalingPolicy;
import com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest;
import com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse;
import com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AutoscalingPolicyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAutoscalingPolicyServiceStub extends AutoscalingPolicyServiceStub {
  private static final MethodDescriptor<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyMethodDescriptor =
          MethodDescriptor.<CreateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/CreateAutoscalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AutoscalingPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/UpdateAutoscalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AutoscalingPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyMethodDescriptor =
          MethodDescriptor.<GetAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/GetAutoscalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AutoscalingPolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/ListAutoscalingPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAutoscalingPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAutoscalingPoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAutoscalingPolicyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.AutoscalingPolicyService/DeleteAutoscalingPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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

  private final UnaryCallable<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyCallable;
  private final UnaryCallable<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyCallable;
  private final UnaryCallable<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyCallable;
  private final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesCallable;
  private final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesPagedCallable;
  private final UnaryCallable<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAutoscalingPolicyServiceStub create(
      AutoscalingPolicyServiceStubSettings settings) throws IOException {
    return new GrpcAutoscalingPolicyServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAutoscalingPolicyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAutoscalingPolicyServiceStub(
        AutoscalingPolicyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAutoscalingPolicyServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAutoscalingPolicyServiceStub(
        AutoscalingPolicyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAutoscalingPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAutoscalingPolicyServiceStub(
      AutoscalingPolicyServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAutoscalingPolicyServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAutoscalingPolicyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAutoscalingPolicyServiceStub(
      AutoscalingPolicyServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
        createAutoscalingPolicyTransportSettings =
            GrpcCallSettings.<CreateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
                .setMethodDescriptor(createAutoscalingPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
        updateAutoscalingPolicyTransportSettings =
            GrpcCallSettings.<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
                .setMethodDescriptor(updateAutoscalingPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("policy.name", String.valueOf(request.getPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAutoscalingPolicyRequest, AutoscalingPolicy>
        getAutoscalingPolicyTransportSettings =
            GrpcCallSettings.<GetAutoscalingPolicyRequest, AutoscalingPolicy>newBuilder()
                .setMethodDescriptor(getAutoscalingPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
        listAutoscalingPoliciesTransportSettings =
            GrpcCallSettings
                .<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAutoscalingPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAutoscalingPolicyRequest, Empty>
        deleteAutoscalingPolicyTransportSettings =
            GrpcCallSettings.<DeleteAutoscalingPolicyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAutoscalingPolicyMethodDescriptor)
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

    this.createAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            createAutoscalingPolicyTransportSettings,
            settings.createAutoscalingPolicySettings(),
            clientContext);
    this.updateAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAutoscalingPolicyTransportSettings,
            settings.updateAutoscalingPolicySettings(),
            clientContext);
    this.getAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            getAutoscalingPolicyTransportSettings,
            settings.getAutoscalingPolicySettings(),
            clientContext);
    this.listAutoscalingPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAutoscalingPoliciesTransportSettings,
            settings.listAutoscalingPoliciesSettings(),
            clientContext);
    this.listAutoscalingPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAutoscalingPoliciesTransportSettings,
            settings.listAutoscalingPoliciesSettings(),
            clientContext);
    this.deleteAutoscalingPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAutoscalingPolicyTransportSettings,
            settings.deleteAutoscalingPolicySettings(),
            clientContext);
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
  public UnaryCallable<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyCallable() {
    return createAutoscalingPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyCallable() {
    return updateAutoscalingPolicyCallable;
  }

  @Override
  public UnaryCallable<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyCallable() {
    return getAutoscalingPolicyCallable;
  }

  @Override
  public UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesCallable() {
    return listAutoscalingPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesPagedCallable() {
    return listAutoscalingPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAutoscalingPolicyRequest, Empty> deleteAutoscalingPolicyCallable() {
    return deleteAutoscalingPolicyCallable;
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
