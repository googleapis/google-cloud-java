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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.SessionTemplateControllerClient.ListSessionTemplatesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.CreateSessionTemplateRequest;
import com.google.cloud.dataproc.v1.DeleteSessionTemplateRequest;
import com.google.cloud.dataproc.v1.GetSessionTemplateRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesRequest;
import com.google.cloud.dataproc.v1.ListSessionTemplatesResponse;
import com.google.cloud.dataproc.v1.SessionTemplate;
import com.google.cloud.dataproc.v1.UpdateSessionTemplateRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SessionTemplateController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSessionTemplateControllerStub extends SessionTemplateControllerStub {
  private static final MethodDescriptor<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateMethodDescriptor =
          MethodDescriptor.<CreateSessionTemplateRequest, SessionTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/CreateSessionTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSessionTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SessionTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateMethodDescriptor =
          MethodDescriptor.<UpdateSessionTemplateRequest, SessionTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/UpdateSessionTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSessionTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SessionTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSessionTemplateRequest, SessionTemplate>
      getSessionTemplateMethodDescriptor =
          MethodDescriptor.<GetSessionTemplateRequest, SessionTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/GetSessionTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSessionTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SessionTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesMethodDescriptor =
          MethodDescriptor.<ListSessionTemplatesRequest, ListSessionTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/ListSessionTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSessionTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSessionTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSessionTemplateRequest, Empty>
      deleteSessionTemplateMethodDescriptor =
          MethodDescriptor.<DeleteSessionTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataproc.v1.SessionTemplateController/DeleteSessionTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSessionTemplateRequest.getDefaultInstance()))
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

  private final UnaryCallable<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateCallable;
  private final UnaryCallable<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateCallable;
  private final UnaryCallable<GetSessionTemplateRequest, SessionTemplate>
      getSessionTemplateCallable;
  private final UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesCallable;
  private final UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesPagedResponse>
      listSessionTemplatesPagedCallable;
  private final UnaryCallable<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSessionTemplateControllerStub create(
      SessionTemplateControllerStubSettings settings) throws IOException {
    return new GrpcSessionTemplateControllerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSessionTemplateControllerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSessionTemplateControllerStub(
        SessionTemplateControllerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSessionTemplateControllerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSessionTemplateControllerStub(
        SessionTemplateControllerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSessionTemplateControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSessionTemplateControllerStub(
      SessionTemplateControllerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSessionTemplateControllerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSessionTemplateControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSessionTemplateControllerStub(
      SessionTemplateControllerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSessionTemplateRequest, SessionTemplate>
        createSessionTemplateTransportSettings =
            GrpcCallSettings.<CreateSessionTemplateRequest, SessionTemplate>newBuilder()
                .setMethodDescriptor(createSessionTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateSessionTemplateRequest, SessionTemplate>
        updateSessionTemplateTransportSettings =
            GrpcCallSettings.<UpdateSessionTemplateRequest, SessionTemplate>newBuilder()
                .setMethodDescriptor(updateSessionTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "session_template.name",
                          String.valueOf(request.getSessionTemplate().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSessionTemplateRequest, SessionTemplate>
        getSessionTemplateTransportSettings =
            GrpcCallSettings.<GetSessionTemplateRequest, SessionTemplate>newBuilder()
                .setMethodDescriptor(getSessionTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
        listSessionTemplatesTransportSettings =
            GrpcCallSettings.<ListSessionTemplatesRequest, ListSessionTemplatesResponse>newBuilder()
                .setMethodDescriptor(listSessionTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateTransportSettings =
        GrpcCallSettings.<DeleteSessionTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSessionTemplateMethodDescriptor)
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

    this.createSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            createSessionTemplateTransportSettings,
            settings.createSessionTemplateSettings(),
            clientContext);
    this.updateSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            updateSessionTemplateTransportSettings,
            settings.updateSessionTemplateSettings(),
            clientContext);
    this.getSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            getSessionTemplateTransportSettings,
            settings.getSessionTemplateSettings(),
            clientContext);
    this.listSessionTemplatesCallable =
        callableFactory.createUnaryCallable(
            listSessionTemplatesTransportSettings,
            settings.listSessionTemplatesSettings(),
            clientContext);
    this.listSessionTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listSessionTemplatesTransportSettings,
            settings.listSessionTemplatesSettings(),
            clientContext);
    this.deleteSessionTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteSessionTemplateTransportSettings,
            settings.deleteSessionTemplateSettings(),
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
  public UnaryCallable<CreateSessionTemplateRequest, SessionTemplate>
      createSessionTemplateCallable() {
    return createSessionTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateSessionTemplateRequest, SessionTemplate>
      updateSessionTemplateCallable() {
    return updateSessionTemplateCallable;
  }

  @Override
  public UnaryCallable<GetSessionTemplateRequest, SessionTemplate> getSessionTemplateCallable() {
    return getSessionTemplateCallable;
  }

  @Override
  public UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesResponse>
      listSessionTemplatesCallable() {
    return listSessionTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListSessionTemplatesRequest, ListSessionTemplatesPagedResponse>
      listSessionTemplatesPagedCallable() {
    return listSessionTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionTemplateRequest, Empty> deleteSessionTemplateCallable() {
    return deleteSessionTemplateCallable;
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
