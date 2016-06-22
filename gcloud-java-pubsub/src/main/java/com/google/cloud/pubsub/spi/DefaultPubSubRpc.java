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

import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.ApiException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.AuthCredentials;
import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.RetryParams;
import com.google.cloud.pubsub.PubSubException;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.spi.v1.PublisherApi;
import com.google.cloud.pubsub.spi.v1.PublisherSettings;
import com.google.cloud.pubsub.spi.v1.SubscriberApi;
import com.google.cloud.pubsub.spi.v1.SubscriberSettings;
import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
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

import org.joda.time.Duration;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class DefaultPubSubRpc implements PubSubRpc {

  private final PublisherApi publisherApi;
  private final SubscriberApi subscriberApi;
  private final ScheduledExecutorService executor;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;

  private boolean closed;

  private static final class InternalPubSubOptions extends PubSubOptions {

    private static final long serialVersionUID = -7997372049256706185L;

    private InternalPubSubOptions(PubSubOptions options) {
      super(options.toBuilder());
    }

    @Override
    protected ExecutorFactory<ScheduledExecutorService> executorFactory() {
      return super.executorFactory();
    }
  }

  private static final class PullFutureImpl
      extends ForwardingListenableFuture.SimpleForwardingListenableFuture<PullResponse>
      implements PullFuture {

    PullFutureImpl(ListenableFuture<PullResponse> delegate) {
      super(delegate);
    }

    @Override
    public void addCallback(final PullCallback callback) {
      Futures.addCallback(delegate(), new FutureCallback<PullResponse>() {
        @Override
        public void onSuccess(PullResponse result) {
          callback.success(result);
        }

        @Override
        public void onFailure(Throwable error) {
          callback.failure(error);
        }
      });
    }
  }

  public DefaultPubSubRpc(PubSubOptions options) throws IOException {
    executorFactory = new InternalPubSubOptions(options).executorFactory();
    executor = executorFactory.get();
    try {
      PublisherSettings.Builder pubBuilder =
          PublisherSettings.defaultBuilder().provideExecutorWith(executor, false);
      SubscriberSettings.Builder subBuilder =
          SubscriberSettings.defaultBuilder().provideExecutorWith(executor, false);
      // todo(mziccard): PublisherSettings should support null/absent credentials for testing
      if (options.host().contains("localhost")
          || options.authCredentials().equals(AuthCredentials.noAuth())) {
        ManagedChannel channel = NettyChannelBuilder.forTarget(options.host())
            .negotiationType(NegotiationType.PLAINTEXT)
            .build();
        pubBuilder.provideChannelWith(channel, true);
        subBuilder.provideChannelWith(channel, true);
      } else {
        GoogleCredentials credentials = options.authCredentials().credentials();
        pubBuilder.provideChannelWith(
            credentials.createScoped(PublisherSettings.DEFAULT_SERVICE_SCOPES));
        subBuilder.provideChannelWith(
            credentials.createScoped(SubscriberSettings.DEFAULT_SERVICE_SCOPES));
      }
      pubBuilder.applyToAllApiMethods(apiCallSettings(options));
      subBuilder.applyToAllApiMethods(apiCallSettings(options));
      publisherApi = PublisherApi.create(pubBuilder.build());
      subscriberApi = SubscriberApi.create(subBuilder.build());
    } catch (Exception ex) {
      throw new IOException(ex);
    }
  }

  private static ApiCallSettings.Builder apiCallSettings(PubSubOptions options) {
    // TODO: specify timeout these settings:
    // retryParams.retryMaxAttempts(), retryParams.retryMinAttempts()
    RetryParams retryParams = options.retryParams();
    final RetrySettings.Builder builder = RetrySettings.newBuilder()
        .setTotalTimeout(Duration.millis(retryParams.totalRetryPeriodMillis()))
        .setInitialRpcTimeout(Duration.millis(options.initialTimeout()))
        .setRpcTimeoutMultiplier(options.timeoutMultiplier())
        .setMaxRpcTimeout(Duration.millis(options.maxTimeout()))
        .setInitialRetryDelay(Duration.millis(retryParams.initialRetryDelayMillis()))
        .setRetryDelayMultiplier(retryParams.retryDelayBackoffFactor())
        .setMaxRetryDelay(Duration.millis(retryParams.maxRetryDelayMillis()));
    return ApiCallSettings.newBuilder().setRetrySettingsBuilder(builder);
  }

  private static <V> ListenableFuture<V> translate(ListenableFuture<V> from,
      final boolean idempotent, int... returnNullOn) {
    final Set<Integer> returnNullOnSet = Sets.newHashSetWithExpectedSize(returnNullOn.length);
    for (int value : returnNullOn) {
      returnNullOnSet.add(value);
    }
    return Futures.catching(from, ApiException.class, new Function<ApiException, V>() {
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
  public Future<Topic> create(Topic topic) {
    // TODO: it would be nice if we can get the idempotent information from the ApiCallSettings
    // or from the exception
    return translate(publisherApi.createTopicCallable().futureCall(topic), true);
  }

  @Override
  public Future<PublishResponse> publish(PublishRequest request) {
    return translate(publisherApi.publishCallable().futureCall(request), false);
  }

  @Override
  public Future<Topic> get(GetTopicRequest request) {
    return translate(publisherApi.getTopicCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public Future<ListTopicsResponse> list(ListTopicsRequest request) {
    // we should consider using gax PageAccessor once
    // https://github.com/googleapis/gax-java/issues/74 is fixed
    // Though it is a cleaner SPI without it, but PageAccessor is an interface
    // and if it saves code we should not easily dismiss it.
    return translate(publisherApi.listTopicsCallable().futureCall(request), true);
  }

  @Override
  public Future<ListTopicSubscriptionsResponse> list(ListTopicSubscriptionsRequest request) {
    return translate(publisherApi.listTopicSubscriptionsCallable().futureCall(request), true);
  }

  @Override
  public Future<Empty> delete(DeleteTopicRequest request) {
    return translate(publisherApi.deleteTopicCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public Future<Subscription> create(Subscription subscription) {
    return translate(subscriberApi.createSubscriptionCallable().futureCall(subscription), false);
  }

  @Override
  public Future<Subscription> get(GetSubscriptionRequest request) {
    return translate(subscriberApi.getSubscriptionCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public Future<ListSubscriptionsResponse> list(ListSubscriptionsRequest request) {
    return translate(subscriberApi.listSubscriptionsCallable().futureCall(request), true);
  }

  @Override
  public Future<Empty> delete(DeleteSubscriptionRequest request) {
    return translate(subscriberApi.deleteSubscriptionCallable().futureCall(request), true,
        Code.NOT_FOUND.value());
  }

  @Override
  public Future<Empty> modify(ModifyAckDeadlineRequest request) {
    return translate(subscriberApi.modifyAckDeadlineCallable().futureCall(request), false);
  }

  @Override
  public Future<Empty> acknowledge(AcknowledgeRequest request) {
    return translate(subscriberApi.acknowledgeCallable().futureCall(request), false);
  }

  @Override
  public PullFuture pull(PullRequest request) {
    return new PullFutureImpl(translate(subscriberApi.pullCallable().futureCall(request), false));
  }

  @Override
  public Future<Empty> modify(ModifyPushConfigRequest request) {
    return translate(subscriberApi.modifyPushConfigCallable().futureCall(request), false);
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    subscriberApi.close();
    publisherApi.close();
    executorFactory.release(executor);
  }
}
