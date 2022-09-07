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

import static com.google.cloud.resourcemanager.v3.TagKeysClient.ListTagKeysPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagKeyRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest;
import com.google.cloud.resourcemanager.v3.GetTagKeyRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysResponse;
import com.google.cloud.resourcemanager.v3.TagKey;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest;
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
 * gRPC stub implementation for the TagKeys service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTagKeysStub extends TagKeysStub {
  private static final MethodDescriptor<ListTagKeysRequest, ListTagKeysResponse>
      listTagKeysMethodDescriptor =
          MethodDescriptor.<ListTagKeysRequest, ListTagKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/ListTagKeys")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTagKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTagKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTagKeyRequest, TagKey> getTagKeyMethodDescriptor =
      MethodDescriptor.<GetTagKeyRequest, TagKey>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/GetTagKey")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTagKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(TagKey.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTagKeyRequest, Operation>
      createTagKeyMethodDescriptor =
          MethodDescriptor.<CreateTagKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/CreateTagKey")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateTagKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTagKeyRequest, Operation>
      updateTagKeyMethodDescriptor =
          MethodDescriptor.<UpdateTagKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/UpdateTagKey")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateTagKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTagKeyRequest, Operation>
      deleteTagKeyMethodDescriptor =
          MethodDescriptor.<DeleteTagKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/DeleteTagKey")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteTagKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagKeys/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListTagKeysRequest, ListTagKeysResponse> listTagKeysCallable;
  private final UnaryCallable<ListTagKeysRequest, ListTagKeysPagedResponse>
      listTagKeysPagedCallable;
  private final UnaryCallable<GetTagKeyRequest, TagKey> getTagKeyCallable;
  private final UnaryCallable<CreateTagKeyRequest, Operation> createTagKeyCallable;
  private final OperationCallable<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationCallable;
  private final UnaryCallable<UpdateTagKeyRequest, Operation> updateTagKeyCallable;
  private final OperationCallable<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationCallable;
  private final UnaryCallable<DeleteTagKeyRequest, Operation> deleteTagKeyCallable;
  private final OperationCallable<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTagKeysStub create(TagKeysStubSettings settings) throws IOException {
    return new GrpcTagKeysStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTagKeysStub create(ClientContext clientContext) throws IOException {
    return new GrpcTagKeysStub(TagKeysStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTagKeysStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTagKeysStub(
        TagKeysStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTagKeysStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTagKeysStub(TagKeysStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTagKeysCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTagKeysStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTagKeysStub(
      TagKeysStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListTagKeysRequest, ListTagKeysResponse> listTagKeysTransportSettings =
        GrpcCallSettings.<ListTagKeysRequest, ListTagKeysResponse>newBuilder()
            .setMethodDescriptor(listTagKeysMethodDescriptor)
            .build();
    GrpcCallSettings<GetTagKeyRequest, TagKey> getTagKeyTransportSettings =
        GrpcCallSettings.<GetTagKeyRequest, TagKey>newBuilder()
            .setMethodDescriptor(getTagKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateTagKeyRequest, Operation> createTagKeyTransportSettings =
        GrpcCallSettings.<CreateTagKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagKeyMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateTagKeyRequest, Operation> updateTagKeyTransportSettings =
        GrpcCallSettings.<UpdateTagKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTagKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("tag_key.name", String.valueOf(request.getTagKey().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteTagKeyRequest, Operation> deleteTagKeyTransportSettings =
        GrpcCallSettings.<DeleteTagKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagKeyMethodDescriptor)
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

    this.listTagKeysCallable =
        callableFactory.createUnaryCallable(
            listTagKeysTransportSettings, settings.listTagKeysSettings(), clientContext);
    this.listTagKeysPagedCallable =
        callableFactory.createPagedCallable(
            listTagKeysTransportSettings, settings.listTagKeysSettings(), clientContext);
    this.getTagKeyCallable =
        callableFactory.createUnaryCallable(
            getTagKeyTransportSettings, settings.getTagKeySettings(), clientContext);
    this.createTagKeyCallable =
        callableFactory.createUnaryCallable(
            createTagKeyTransportSettings, settings.createTagKeySettings(), clientContext);
    this.createTagKeyOperationCallable =
        callableFactory.createOperationCallable(
            createTagKeyTransportSettings,
            settings.createTagKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTagKeyCallable =
        callableFactory.createUnaryCallable(
            updateTagKeyTransportSettings, settings.updateTagKeySettings(), clientContext);
    this.updateTagKeyOperationCallable =
        callableFactory.createOperationCallable(
            updateTagKeyTransportSettings,
            settings.updateTagKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTagKeyCallable =
        callableFactory.createUnaryCallable(
            deleteTagKeyTransportSettings, settings.deleteTagKeySettings(), clientContext);
    this.deleteTagKeyOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagKeyTransportSettings,
            settings.deleteTagKeyOperationSettings(),
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
  public UnaryCallable<ListTagKeysRequest, ListTagKeysResponse> listTagKeysCallable() {
    return listTagKeysCallable;
  }

  @Override
  public UnaryCallable<ListTagKeysRequest, ListTagKeysPagedResponse> listTagKeysPagedCallable() {
    return listTagKeysPagedCallable;
  }

  @Override
  public UnaryCallable<GetTagKeyRequest, TagKey> getTagKeyCallable() {
    return getTagKeyCallable;
  }

  @Override
  public UnaryCallable<CreateTagKeyRequest, Operation> createTagKeyCallable() {
    return createTagKeyCallable;
  }

  @Override
  public OperationCallable<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationCallable() {
    return createTagKeyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTagKeyRequest, Operation> updateTagKeyCallable() {
    return updateTagKeyCallable;
  }

  @Override
  public OperationCallable<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationCallable() {
    return updateTagKeyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagKeyRequest, Operation> deleteTagKeyCallable() {
    return deleteTagKeyCallable;
  }

  @Override
  public OperationCallable<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationCallable() {
    return deleteTagKeyOperationCallable;
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
