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

import static com.google.cloud.resourcemanager.v3.TagValuesClient.ListTagValuesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagValueRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagValueMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagValueRequest;
import com.google.cloud.resourcemanager.v3.GetTagValueRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesResponse;
import com.google.cloud.resourcemanager.v3.TagValue;
import com.google.cloud.resourcemanager.v3.UpdateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagValueRequest;
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
 * gRPC stub implementation for the TagValues service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTagValuesStub extends TagValuesStub {
  private static final MethodDescriptor<ListTagValuesRequest, ListTagValuesResponse>
      listTagValuesMethodDescriptor =
          MethodDescriptor.<ListTagValuesRequest, ListTagValuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/ListTagValues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTagValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTagValuesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTagValueRequest, TagValue> getTagValueMethodDescriptor =
      MethodDescriptor.<GetTagValueRequest, TagValue>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/GetTagValue")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTagValueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(TagValue.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTagValueRequest, Operation>
      createTagValueMethodDescriptor =
          MethodDescriptor.<CreateTagValueRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/CreateTagValue")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTagValueRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTagValueRequest, Operation>
      updateTagValueMethodDescriptor =
          MethodDescriptor.<UpdateTagValueRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/UpdateTagValue")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTagValueRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTagValueRequest, Operation>
      deleteTagValueMethodDescriptor =
          MethodDescriptor.<DeleteTagValueRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/DeleteTagValue")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTagValueRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagValues/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListTagValuesRequest, ListTagValuesResponse> listTagValuesCallable;
  private final UnaryCallable<ListTagValuesRequest, ListTagValuesPagedResponse>
      listTagValuesPagedCallable;
  private final UnaryCallable<GetTagValueRequest, TagValue> getTagValueCallable;
  private final UnaryCallable<CreateTagValueRequest, Operation> createTagValueCallable;
  private final OperationCallable<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationCallable;
  private final UnaryCallable<UpdateTagValueRequest, Operation> updateTagValueCallable;
  private final OperationCallable<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationCallable;
  private final UnaryCallable<DeleteTagValueRequest, Operation> deleteTagValueCallable;
  private final OperationCallable<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTagValuesStub create(TagValuesStubSettings settings) throws IOException {
    return new GrpcTagValuesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTagValuesStub create(ClientContext clientContext) throws IOException {
    return new GrpcTagValuesStub(TagValuesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTagValuesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTagValuesStub(
        TagValuesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTagValuesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTagValuesStub(TagValuesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTagValuesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTagValuesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTagValuesStub(
      TagValuesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListTagValuesRequest, ListTagValuesResponse> listTagValuesTransportSettings =
        GrpcCallSettings.<ListTagValuesRequest, ListTagValuesResponse>newBuilder()
            .setMethodDescriptor(listTagValuesMethodDescriptor)
            .build();
    GrpcCallSettings<GetTagValueRequest, TagValue> getTagValueTransportSettings =
        GrpcCallSettings.<GetTagValueRequest, TagValue>newBuilder()
            .setMethodDescriptor(getTagValueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateTagValueRequest, Operation> createTagValueTransportSettings =
        GrpcCallSettings.<CreateTagValueRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagValueMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateTagValueRequest, Operation> updateTagValueTransportSettings =
        GrpcCallSettings.<UpdateTagValueRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTagValueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("tag_value.name", String.valueOf(request.getTagValue().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteTagValueRequest, Operation> deleteTagValueTransportSettings =
        GrpcCallSettings.<DeleteTagValueRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagValueMethodDescriptor)
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

    this.listTagValuesCallable =
        callableFactory.createUnaryCallable(
            listTagValuesTransportSettings, settings.listTagValuesSettings(), clientContext);
    this.listTagValuesPagedCallable =
        callableFactory.createPagedCallable(
            listTagValuesTransportSettings, settings.listTagValuesSettings(), clientContext);
    this.getTagValueCallable =
        callableFactory.createUnaryCallable(
            getTagValueTransportSettings, settings.getTagValueSettings(), clientContext);
    this.createTagValueCallable =
        callableFactory.createUnaryCallable(
            createTagValueTransportSettings, settings.createTagValueSettings(), clientContext);
    this.createTagValueOperationCallable =
        callableFactory.createOperationCallable(
            createTagValueTransportSettings,
            settings.createTagValueOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTagValueCallable =
        callableFactory.createUnaryCallable(
            updateTagValueTransportSettings, settings.updateTagValueSettings(), clientContext);
    this.updateTagValueOperationCallable =
        callableFactory.createOperationCallable(
            updateTagValueTransportSettings,
            settings.updateTagValueOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTagValueCallable =
        callableFactory.createUnaryCallable(
            deleteTagValueTransportSettings, settings.deleteTagValueSettings(), clientContext);
    this.deleteTagValueOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagValueTransportSettings,
            settings.deleteTagValueOperationSettings(),
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
  public UnaryCallable<ListTagValuesRequest, ListTagValuesResponse> listTagValuesCallable() {
    return listTagValuesCallable;
  }

  @Override
  public UnaryCallable<ListTagValuesRequest, ListTagValuesPagedResponse>
      listTagValuesPagedCallable() {
    return listTagValuesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTagValueRequest, TagValue> getTagValueCallable() {
    return getTagValueCallable;
  }

  @Override
  public UnaryCallable<CreateTagValueRequest, Operation> createTagValueCallable() {
    return createTagValueCallable;
  }

  @Override
  public OperationCallable<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationCallable() {
    return createTagValueOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTagValueRequest, Operation> updateTagValueCallable() {
    return updateTagValueCallable;
  }

  @Override
  public OperationCallable<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationCallable() {
    return updateTagValueOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagValueRequest, Operation> deleteTagValueCallable() {
    return deleteTagValueCallable;
  }

  @Override
  public OperationCallable<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationCallable() {
    return deleteTagValueOperationCallable;
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
