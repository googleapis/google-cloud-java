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

package com.google.cloud.pubsub.spi;

import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.cloud.RetryParams;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.spi.v1.PublisherApi;
import com.google.cloud.pubsub.spi.v1.PublisherSettings;
import com.google.cloud.pubsub.spi.v1.SubscriberApi;
import com.google.cloud.pubsub.spi.v1.SubscriberSettings;
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

import org.joda.time.Duration;

import java.io.IOException;
import java.util.concurrent.Future;

public class DefaultPubSubRpc implements PubSubRpc {

  private final PubSubOptions options;
  private final PublisherApi publisherApi;
  private final SubscriberApi subscriberApi;

  public DefaultPubSubRpc(PubSubOptions options) throws IOException {
    this.options = options;
    try {
      PublisherSettings.Builder pbuilder = PublisherSettings.defaultInstance().toBuilder();
      pbuilder.provideChannelWith(ConnectionSettings.builder()
          .provideCredentialsWith(options.authCredentials().credentials()).build());
      pbuilder.applyToAllApiMethods(apiCallSettings(options));
      publisherApi = PublisherApi.create(pbuilder.build());
      SubscriberSettings.Builder sBuilder = SubscriberSettings.defaultInstance().toBuilder();
      sBuilder.provideChannelWith(ConnectionSettings.builder()
          .provideCredentialsWith(options.authCredentials().credentials()).build());
      sBuilder.applyToAllApiMethods(apiCallSettings(options));
      subscriberApi = SubscriberApi.create(sBuilder.build());
    } catch (Exception ex) {
      throw new IOException(ex);
    }
  }

  private static ApiCallSettings.Builder apiCallSettings(PubSubOptions options) {
    // TODO: figure out how to specify timeout these settings
    // retryParams.retryMaxAttempts(), retryParams.retryMinAttempts()
    RetryParams retryParams = options.retryParams();
    final RetrySettings.Builder builder = RetrySettings.newBuilder()
        .setTotalTimeout(Duration.millis(retryParams.totalRetryPeriodMillis()))
        .setInitialRpcTimeout(Duration.millis(options.connectTimeout()))
        .setRpcTimeoutMultiplier(1.5)
        .setMaxRpcTimeout((Duration.millis(options.connectTimeout() + options.readTimeout())))
        .setInitialRetryDelay(Duration.millis(retryParams.initialRetryDelayMillis()))
        .setRetryDelayMultiplier(retryParams.retryDelayBackoffFactor())
        .setMaxRetryDelay(Duration.millis(retryParams.maxRetryDelayMillis()));
    // TODO: this needs to be replaced with something like ApiCallSettings.of(null, retrySettings)
    // once the gax supports it
    return new ApiCallSettings.Builder() {

      @Override
      public RetrySettings.Builder getRetrySettingsBuilder() {
        return builder;
      }

      @Override
      public ApiCallSettings build() {
        return null;
      }
    };
  }

  @Override
  public Future<Topic> create(Topic topic) {
    // TODO: understand what the exception that could be thrown
    // and how to get either retriable and/or the service error codes
    return publisherApi.createTopicCallable().futureCall(topic);
  }

  @Override
  public Future<PublishResponse> publish(PublishRequest request) {
    return publisherApi.publishCallable().futureCall(request);
  }

  @Override
  public Future<Topic> get(GetTopicRequest request) {
    return publisherApi.getTopicCallable().futureCall(request);
  }

  @Override
  public Future<ListTopicsResponse> list(ListTopicsRequest request) {
    return publisherApi.listTopicsCallable().futureCall(request);
  }

  @Override
  public Future<ListTopicSubscriptionsResponse> list(ListTopicSubscriptionsRequest request) {
    return publisherApi.listTopicSubscriptionsCallable().futureCall(request);
  }

  @Override
  public Future<Empty> delete(DeleteTopicRequest request) {
    return publisherApi.deleteTopicCallable().futureCall(request);
  }

  @Override
  public Future<Subscription> create(Subscription subscription) {
    return subscriberApi.createSubscriptionCallable().futureCall(subscription);
  }

  @Override
  public Future<Subscription> get(GetSubscriptionRequest request) {
    return subscriberApi.getSubscriptionCallable().futureCall(request);
  }

  @Override
  public Future<ListSubscriptionsResponse> list(ListSubscriptionsRequest request) {
    return subscriberApi.listSubscriptionsCallable().futureCall(request);
  }

  @Override
  public Future<Empty> delete(DeleteSubscriptionRequest request) {
    return subscriberApi.deleteSubscriptionCallable().futureCall(request);
  }

  @Override
  public Future<Empty> modify(ModifyAckDeadlineRequest request) {
    return subscriberApi.modifyAckDeadlineCallable().futureCall(request);
  }

  @Override
  public Future<Empty> acknowledge(AcknowledgeRequest request) {
    return subscriberApi.acknowledgeCallable().futureCall(request);
  }

  @Override
  public Future<PullResponse> pull(PullRequest request) {
    return subscriberApi.pullCallable().futureCall(request);
  }

  @Override
  public Future<Empty> modify(ModifyPushConfigRequest request) {
    return subscriberApi.modifyPushConfigCallable().futureCall(request);
  }
}
