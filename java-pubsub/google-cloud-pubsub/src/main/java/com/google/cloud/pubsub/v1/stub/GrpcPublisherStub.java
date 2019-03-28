/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicSubscriptionsPagedResponse;
import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.UpdateTopicRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Pub/Sub API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcPublisherStub extends PublisherStub {

  private static final MethodDescriptor<Topic, Topic> createTopicMethodDescriptor =
      MethodDescriptor.<Topic, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/CreateTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UpdateTopicRequest, Topic> updateTopicMethodDescriptor =
      MethodDescriptor.<UpdateTopicRequest, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/UpdateTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<PublishRequest, PublishResponse> publishMethodDescriptor =
      MethodDescriptor.<PublishRequest, PublishResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/Publish")
          .setRequestMarshaller(ProtoUtils.marshaller(PublishRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(PublishResponse.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetTopicRequest, Topic> getTopicMethodDescriptor =
      MethodDescriptor.<GetTopicRequest, Topic>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/GetTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTopicRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Topic.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListTopicsRequest, ListTopicsResponse>
      listTopicsMethodDescriptor =
          MethodDescriptor.<ListTopicsRequest, ListTopicsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Publisher/ListTopics")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTopicsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTopicsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsMethodDescriptor =
          MethodDescriptor
              .<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.Publisher/ListTopicSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTopicSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTopicSubscriptionsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteTopicRequest, Empty> deleteTopicMethodDescriptor =
      MethodDescriptor.<DeleteTopicRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.Publisher/DeleteTopic")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTopicRequest.getDefaultInstance()))
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

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<Topic, Topic> createTopicCallable;
  private final UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable;
  private final UnaryCallable<PublishRequest, PublishResponse> publishCallable;
  private final UnaryCallable<GetTopicRequest, Topic> getTopicCallable;
  private final UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable;
  private final UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable;
  private final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable;
  private final UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable;
  private final UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPublisherStub create(PublisherStubSettings settings) throws IOException {
    return new GrpcPublisherStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPublisherStub create(ClientContext clientContext) throws IOException {
    return new GrpcPublisherStub(PublisherStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPublisherStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPublisherStub(
        PublisherStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPublisherStub(PublisherStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPublisherCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPublisherStub(
      PublisherStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<Topic, Topic> createTopicTransportSettings =
        GrpcCallSettings.<Topic, Topic>newBuilder()
            .setMethodDescriptor(createTopicMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<Topic>() {
                  @Override
                  public Map<String, String> extract(Topic request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateTopicRequest, Topic> updateTopicTransportSettings =
        GrpcCallSettings.<UpdateTopicRequest, Topic>newBuilder()
            .setMethodDescriptor(updateTopicMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateTopicRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateTopicRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("topic.name", String.valueOf(request.getTopic().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<PublishRequest, PublishResponse> publishTransportSettings =
        GrpcCallSettings.<PublishRequest, PublishResponse>newBuilder()
            .setMethodDescriptor(publishMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<PublishRequest>() {
                  @Override
                  public Map<String, String> extract(PublishRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("topic", String.valueOf(request.getTopic()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetTopicRequest, Topic> getTopicTransportSettings =
        GrpcCallSettings.<GetTopicRequest, Topic>newBuilder()
            .setMethodDescriptor(getTopicMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTopicRequest>() {
                  @Override
                  public Map<String, String> extract(GetTopicRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("topic", String.valueOf(request.getTopic()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTopicsRequest, ListTopicsResponse> listTopicsTransportSettings =
        GrpcCallSettings.<ListTopicsRequest, ListTopicsResponse>newBuilder()
            .setMethodDescriptor(listTopicsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListTopicsRequest>() {
                  @Override
                  public Map<String, String> extract(ListTopicsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project", String.valueOf(request.getProject()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
        listTopicSubscriptionsTransportSettings =
            GrpcCallSettings
                .<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listTopicSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListTopicSubscriptionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListTopicSubscriptionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("topic", String.valueOf(request.getTopic()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteTopicRequest, Empty> deleteTopicTransportSettings =
        GrpcCallSettings.<DeleteTopicRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTopicMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTopicRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTopicRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("topic", String.valueOf(request.getTopic()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
                .build();

    this.createTopicCallable =
        callableFactory.createUnaryCallable(
            createTopicTransportSettings, settings.createTopicSettings(), clientContext);
    this.updateTopicCallable =
        callableFactory.createUnaryCallable(
            updateTopicTransportSettings, settings.updateTopicSettings(), clientContext);
    this.publishCallable =
        callableFactory.createBatchingCallable(
            publishTransportSettings, settings.publishSettings(), clientContext);
    this.getTopicCallable =
        callableFactory.createUnaryCallable(
            getTopicTransportSettings, settings.getTopicSettings(), clientContext);
    this.listTopicsCallable =
        callableFactory.createUnaryCallable(
            listTopicsTransportSettings, settings.listTopicsSettings(), clientContext);
    this.listTopicsPagedCallable =
        callableFactory.createPagedCallable(
            listTopicsTransportSettings, settings.listTopicsSettings(), clientContext);
    this.listTopicSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listTopicSubscriptionsTransportSettings,
            settings.listTopicSubscriptionsSettings(),
            clientContext);
    this.listTopicSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listTopicSubscriptionsTransportSettings,
            settings.listTopicSubscriptionsSettings(),
            clientContext);
    this.deleteTopicCallable =
        callableFactory.createUnaryCallable(
            deleteTopicTransportSettings, settings.deleteTopicSettings(), clientContext);
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<Topic, Topic> createTopicCallable() {
    return createTopicCallable;
  }

  public UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    return updateTopicCallable;
  }

  public UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    return publishCallable;
  }

  public UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    return getTopicCallable;
  }

  public UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    return listTopicsPagedCallable;
  }

  public UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    return listTopicsCallable;
  }

  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable() {
    return listTopicSubscriptionsPagedCallable;
  }

  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    return listTopicSubscriptionsCallable;
  }

  public UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    return deleteTopicCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
