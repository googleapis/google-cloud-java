/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.deprecated.spi;

import com.google.api.gax.core.ApiFuture;
import com.google.api.gax.core.ApiFutures;
import com.google.api.gax.core.Function;
import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.api.gax.grpc.FixedExecutorProvider;
import com.google.api.gax.grpc.ProviderManager;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.cloud.GrpcTransportOptions;
import com.google.cloud.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.NoCredentials;
import com.google.cloud.pubsub.deprecated.PubSubException;
import com.google.cloud.pubsub.deprecated.PubSubOptions;
import com.google.cloud.pubsub.spi.v1.PublisherClient;
import com.google.cloud.pubsub.spi.v1.PublisherSettings;
import com.google.cloud.pubsub.spi.v1.SubscriberClient;
import com.google.cloud.pubsub.spi.v1.SubscriberSettings;
import com.google.common.collect.Sets;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.Topic;
import io.grpc.ManagedChannel;
import io.grpc.Status.Code;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

public class DefaultPubSubRpc implements PubSubRpc {

  private final PublisherClient publisherClient;
  private final SubscriberClient subscriberClient;
  private final SubscriberClient noTimeoutSubscriberClient;
  private final ScheduledExecutorService executor;
  private final ProviderManager providerManager;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;

  private boolean closed;

  public DefaultPubSubRpc(PubSubOptions options) throws IOException {
    GrpcTransportOptions transportOptions = (GrpcTransportOptions) options.getTransportOptions();
    executorFactory = transportOptions.getExecutorFactory();
    executor = executorFactory.get();
    try {
      ExecutorProvider executorProvider = FixedExecutorProvider.create(executor);
      ChannelProvider channelProvider;
      // todo(mziccard): ChannelProvider should support null/absent credentials for testing
      if (options.getHost().contains("localhost")
          || options.getCredentials().equals(NoCredentials.getInstance())) {
        ManagedChannel managedChannel = NettyChannelBuilder.forTarget(options.getHost())
            .negotiationType(NegotiationType.PLAINTEXT)
            .executor(executor)
            .build();
        channelProvider = FixedChannelProvider.create(managedChannel);
      } else {
        channelProvider = transportOptions.getChannelProvider(options);
      }
      providerManager = ProviderManager.newBuilder()
          .setChannelProvider(channelProvider)
          .setExecutorProvider(executorProvider)
          .build();
      UnaryCallSettings.Builder callSettingsBuilder = transportOptions
          .getApiCallSettings(options.getRetryParams());
      PublisherSettings.Builder pubBuilder = PublisherSettings.defaultBuilder()
          .setExecutorProvider(providerManager)
          .setChannelProvider(providerManager)
          .applyToAllUnaryMethods(callSettingsBuilder);
      SubscriberSettings.Builder subBuilder = SubscriberSettings.defaultBuilder()
          .setExecutorProvider(providerManager)
          .setChannelProvider(providerManager)
          .applyToAllUnaryMethods(callSettingsBuilder);
      publisherClient = PublisherClient.create(pubBuilder.build());
      subscriberClient = SubscriberClient.create(subBuilder.build());
      callSettingsBuilder.setRetrySettingsBuilder(callSettingsBuilder.getRetrySettingsBuilder()
          .setTotalTimeout(Duration.millis(Long.MAX_VALUE))
          .setInitialRpcTimeout(Duration.millis(Long.MAX_VALUE))
          .setMaxRpcTimeout(Duration.millis(Long.MAX_VALUE)));
      subBuilder.applyToAllUnaryMethods(callSettingsBuilder);
      noTimeoutSubscriberClient = SubscriberClient.create(subBuilder.build());
    } catch (Exception ex) {
      throw new IOException(ex);
    }
  }

  private static <V> ApiFuture<V> translate(
      ApiFuture<V> from, final boolean idempotent, int... returnNullOn) {
    final Set<Integer> returnNullOnSet = Sets.newHashSetWithExpectedSize(returnNullOn.length);
    for (int value : returnNullOn) {
      returnNullOnSet.add(value);
    }
    return ApiFutures.<V, ApiException>catching(
        from,
        ApiException.class,
        new Function<ApiException, V>() {
          @Override
          public V apply(ApiException exception) {
            if (returnNullOnSet.contains(exception.getStatusCode().value())) {
              return null;
            }
            throw new PubSubException(exception, idempotent);
          }
        });
  }

  @Override
  public ApiFuture<Topic> create(Topic topic) {
    // TODO: it would be nice if we can get the idempotent information from the UnaryCallSettings
    // or from the exception
    return translate(publisherClient.createTopicCallable().futureCall(topic), true);
  }

  @Override
  public ApiFuture<PublishResponse> publish(PublishRequest request) {
    return translate(publisherClient.publishCallable().futureCall(request), false);
  }

  @Override
  public ApiFuture<Topic> get(GetTopicRequest request) {
    return translate(publisherClient.getTopicCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public ApiFuture<ListTopicsResponse> list(ListTopicsRequest request) {
    // we should consider using gax PageAccessor once
    // https://github.com/googleapis/gax-java/issues/74 is fixed
    // Though it is a cleaner SPI without it, but PageAccessor is an interface
    // and if it saves code we should not easily dismiss it.
    return translate(publisherClient.listTopicsCallable().futureCall(request), true);
  }

  @Override
  public ApiFuture<ListTopicSubscriptionsResponse> list(ListTopicSubscriptionsRequest request) {
    return translate(publisherClient.listTopicSubscriptionsCallable().futureCall(request), true);
  }

  @Override
  public ApiFuture<Empty> delete(DeleteTopicRequest request) {
    return translate(publisherClient.deleteTopicCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public ApiFuture<Subscription> create(Subscription subscription) {
    return translate(subscriberClient.createSubscriptionCallable().futureCall(subscription), false);
  }

  @Override
  public ApiFuture<Subscription> get(GetSubscriptionRequest request) {
    return translate(subscriberClient.getSubscriptionCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public ApiFuture<ListSubscriptionsResponse> list(ListSubscriptionsRequest request) {
    return translate(subscriberClient.listSubscriptionsCallable().futureCall(request), true);
  }

  @Override
  public ApiFuture<Empty> delete(DeleteSubscriptionRequest request) {
    return translate(subscriberClient.deleteSubscriptionCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public ApiFuture<Empty> modify(ModifyAckDeadlineRequest request) {
    return translate(subscriberClient.modifyAckDeadlineCallable().futureCall(request), false);
  }

  @Override
  public ApiFuture<Empty> acknowledge(AcknowledgeRequest request) {
    return translate(subscriberClient.acknowledgeCallable().futureCall(request), false);
  }

  private static ApiFuture<PullResponse> pull(SubscriberClient subscriberClient, PullRequest request) {
    return translate(subscriberClient.pullCallable().futureCall(request), false);
  }

  @Override
  public ApiFuture<PullResponse> pull(PullRequest request) {
    return request.getReturnImmediately()
        ? pull(subscriberClient, request) : pull(noTimeoutSubscriberClient, request);
  }

  @Override
  public ApiFuture<Empty> modify(ModifyPushConfigRequest request) {
    return translate(subscriberClient.modifyPushConfigCallable().futureCall(request), false);
  }

  @Override
  public ApiFuture<Policy> getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return translate(subscriberClient.getIamPolicyCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public ApiFuture<Policy> setIamPolicy(SetIamPolicyRequest request) {
    return translate(subscriberClient.setIamPolicyCallable().futureCall(request), false);
  }

  @Override
  public ApiFuture<TestIamPermissionsResponse> testIamPermissions(TestIamPermissionsRequest request) {
    return translate(subscriberClient.testIamPermissionsCallable().futureCall(request), true);
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    subscriberClient.close();
    noTimeoutSubscriberClient.close();
    publisherClient.close();
    providerManager.getChannel().shutdown();
    executorFactory.release(executor);
  }
}
