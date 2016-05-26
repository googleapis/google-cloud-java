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

package com.google.cloud.pubsub;

import static com.google.cloud.pubsub.PubSub.ListOption.OptionType.PAGE_SIZE;
import static com.google.cloud.pubsub.PubSub.ListOption.OptionType.PAGE_TOKEN;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.util.concurrent.Futures.lazyTransform;

import com.google.cloud.AsyncPage;
import com.google.cloud.AsyncPageImpl;
import com.google.cloud.BaseService;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.pubsub.spi.PubSubRpc;
import com.google.cloud.pubsub.spi.v1.PublisherApi;
import com.google.cloud.pubsub.spi.v1.SubscriberApi;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Uninterruptibles;
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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PubSubImpl extends BaseService<PubSubOptions> implements PubSub {

  private final PubSubRpc rpc;

  private static final Function<Empty, Void> EMPTY_TO_VOID_FUNCTION = new Function<Empty, Void>() {
    @Override
    public Void apply(Empty empty) {
      return null;
    }
  };
  private static final Function<Empty, Boolean> EMPTY_TO_BOOLEAN_FUNCTION =
      new Function<Empty, Boolean>() {
        @Override
        public Boolean apply(Empty input) {
          return input != null;
        }
      };

  PubSubImpl(PubSubOptions options) {
    super(options);
    rpc = options.rpc();
  }

  private abstract static class BasePageFetcher<T> implements AsyncPageImpl.NextPageFetcher<T> {

    private static final long serialVersionUID = -2122989557125999209L;

    private final PubSubOptions serviceOptions;
    private final Map<Option.OptionType, ?> requestOptions;

    private BasePageFetcher(PubSubOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      this.serviceOptions = serviceOptions;
      this.requestOptions =
          PageImpl.nextRequestOptions(PAGE_TOKEN, cursor, requestOptions);
    }

    PubSubOptions serviceOptions() {
      return serviceOptions;
    }

    Map<Option.OptionType, ?> requestOptions() {
      return requestOptions;
    }
  }

  private static class TopicPageFetcher extends BasePageFetcher<Topic> {

    private static final long serialVersionUID = -7153536453427361814L;

    TopicPageFetcher(PubSubOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public Future<AsyncPage<Topic>> nextPage() {
      return listTopicsAsync(serviceOptions(), requestOptions());
    }
  }

  private static class SubscriptionPageFetcher extends BasePageFetcher<Subscription> {

    private static final long serialVersionUID = -5634446170301177992L;

    SubscriptionPageFetcher(PubSubOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
    }

    @Override
    public Future<AsyncPage<Subscription>> nextPage() {
      return listSubscriptionsAsync(serviceOptions(), requestOptions());
    }
  }

  private static class SubscriptionNamePageFetcher extends BasePageFetcher<SubscriptionId> {

    private static final long serialVersionUID = 7250525437694464444L;

    private final String topic;

    SubscriptionNamePageFetcher(String topic, PubSubOptions serviceOptions, String cursor,
        Map<Option.OptionType, ?> requestOptions) {
      super(serviceOptions, cursor, requestOptions);
      this.topic = topic;
    }

    @Override
    public Future<AsyncPage<SubscriptionId>> nextPage() {
      return listSubscriptionsAsync(topic, serviceOptions(), requestOptions());
    }
  }

  private static <V> V get(Future<V> future) {
    try {
      return Uninterruptibles.getUninterruptibly(future);
    } catch (ExecutionException ex) {
      throw Throwables.propagate(ex.getCause());
    }
  }

  @Override
  public Topic create(TopicInfo topic) {
    return get(createAsync(topic));
  }

  @Override
  public Future<Topic> createAsync(TopicInfo topic) {
    return lazyTransform(rpc.create(topic.toPb(options().projectId())), Topic.fromPbFunction(this));
  }

  @Override
  public Topic getTopic(String topic) {
    return get(getTopicAsync(topic));
  }

  @Override
  public Future<Topic> getTopicAsync(String topic) {
    GetTopicRequest request = GetTopicRequest.newBuilder()
        .setTopic(PublisherApi.formatTopicName(options().projectId(), topic))
        .build();
    return lazyTransform(rpc.get(request), Topic.fromPbFunction(this));
  }

  @Override
  public boolean deleteTopic(String topic) {
    return get(deleteTopicAsync(topic));
  }

  @Override
  public Future<Boolean> deleteTopicAsync(String topic) {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
        .setTopic(PublisherApi.formatTopicName(options().projectId(), topic))
        .build();
    return lazyTransform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
  }

  private static ListTopicsRequest listTopicsRequest(PubSubOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListTopicsRequest.Builder builder = ListTopicsRequest.newBuilder();
    builder.setProject(SubscriberApi.formatProjectName(serviceOptions.projectId()));
    Integer pageSize = PAGE_SIZE.get(options);
    String pageToken = PAGE_TOKEN.get(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static Future<AsyncPage<Topic>> listTopicsAsync(final PubSubOptions serviceOptions,
      final Map<Option.OptionType, ?> options) {
    final ListTopicsRequest request = listTopicsRequest(serviceOptions, options);
    Future<ListTopicsResponse> list = serviceOptions.rpc().list(request);
    return lazyTransform(list,  new Function<ListTopicsResponse, AsyncPage<Topic>>() {
      @Override
      public AsyncPage<Topic> apply(ListTopicsResponse listTopicsResponse) {
        List<Topic> topics = listTopicsResponse.getTopicsList() == null ? ImmutableList.<Topic>of()
            : Lists.transform(listTopicsResponse.getTopicsList(),
                Topic.fromPbFunction(serviceOptions.service()));
        String cursor = listTopicsResponse.getNextPageToken().equals("") ? null
            : listTopicsResponse.getNextPageToken();
        return new AsyncPageImpl<>(
            new TopicPageFetcher(serviceOptions, cursor, options), cursor, topics);
      }
    });
  }

  @Override
  public Page<Topic> listTopics(ListOption... options) {
    return get(listTopicsAsync(options));
  }

  @Override
  public Future<AsyncPage<Topic>> listTopicsAsync(ListOption... options) {
    return listTopicsAsync(options(), optionMap(options));
  }

  @Override
  public String publish(String topic, Message message) {
    return get(publishAsync(topic, message));
  }

  private static PublishRequest publishRequest(PubSubOptions serviceOptions, String topic,
      Iterable<Message> messages) {
    PublishRequest.Builder builder = PublishRequest.newBuilder();
    builder.setTopic(PublisherApi.formatTopicName(serviceOptions.projectId(), topic));
    builder.addAllMessages(Iterables.transform(messages, Message.TO_PB_FUNCTION));
    return builder.build();
  }

  @Override
  public Future<String> publishAsync(String topic, Message message) {
    return lazyTransform(
        rpc.publish(publishRequest(options(), topic, Collections.singletonList(message))),
        new Function<PublishResponse, String>() {
          @Override
          public String apply(PublishResponse publishResponse) {
            return publishResponse.getMessageIdsList().get(0);
          }
        });
  }

  @Override
  public List<String> publish(String topic, Message message, Message... messages) {
    return publish(topic, Lists.asList(message, messages));
  }

  @Override
  public Future<List<String>> publishAsync(String topic, Message message, Message... messages) {
    return publishAsync(topic, Lists.asList(message, messages));
  }

  @Override
  public List<String> publish(String topic, Iterable<Message> messages) {
    return get(publishAsync(topic, messages));
  }

  @Override
  public Future<List<String>> publishAsync(String topic, Iterable<Message> messages) {
    return lazyTransform(rpc.publish(publishRequest(options(), topic, messages)),
        new Function<PublishResponse, List<String>>() {
          @Override
          public List<String> apply(PublishResponse publishResponse) {
            return publishResponse.getMessageIdsList();
          }
        });
  }

  @Override
  public Subscription create(SubscriptionInfo subscription) {
    return get(createAsync(subscription));
  }

  @Override
  public Future<Subscription> createAsync(SubscriptionInfo subscription) {
    return lazyTransform(rpc.create(subscription.toPb(options().projectId())),
        Subscription.fromPbFunction(this));
  }

  @Override
  public Subscription getSubscription(String subscription) {
    return get(getSubscriptionAsync(subscription));
  }

  @Override
  public Future<Subscription> getSubscriptionAsync(String subscription) {
    GetSubscriptionRequest request = GetSubscriptionRequest.newBuilder()
        .setSubscription(SubscriberApi.formatSubscriptionName(options().projectId(), subscription))
        .build();
    return lazyTransform(rpc.get(request), Subscription.fromPbFunction(this));
  }

  @Override
  public void replacePushConfig(String subscription, PushConfig pushConfig) {
    get(replacePushConfigAsync(subscription, pushConfig));
  }

  @Override
  public Future<Void> replacePushConfigAsync(String subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
        .setSubscription(SubscriberApi.formatSubscriptionName(options().projectId(), subscription))
        .setPushConfig(pushConfig != null ? pushConfig.toPb()
            : com.google.pubsub.v1.PushConfig.getDefaultInstance())
        .build();
    return lazyTransform(rpc.modify(request), EMPTY_TO_VOID_FUNCTION);
  }

  @Override
  public boolean deleteSubscription(String subscription) {
    return get(deleteSubscriptionAsync(subscription));
  }

  @Override
  public Future<Boolean> deleteSubscriptionAsync(String subscription) {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SubscriberApi.formatSubscriptionName(options().projectId(), subscription))
        .build();
    return lazyTransform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
  }

  private static ListSubscriptionsRequest listSubscriptionsRequest(PubSubOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListSubscriptionsRequest.Builder builder = ListSubscriptionsRequest.newBuilder();
    builder.setProject(SubscriberApi.formatProjectName(serviceOptions.projectId()));
    Integer pageSize = PAGE_SIZE.getInteger(options);
    String pageToken = PAGE_TOKEN.getString(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static Future<AsyncPage<Subscription>> listSubscriptionsAsync(
      final PubSubOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListSubscriptionsRequest request = listSubscriptionsRequest(serviceOptions, options);
    Future<ListSubscriptionsResponse> list = serviceOptions.rpc().list(request);
    return lazyTransform(list, new Function<ListSubscriptionsResponse, AsyncPage<Subscription>>() {
      @Override
      public AsyncPage<Subscription> apply(ListSubscriptionsResponse listSubscriptionsResponse) {
        List<Subscription> subscriptions = listSubscriptionsResponse.getSubscriptionsList() == null
            ? ImmutableList.<Subscription>of()
            : Lists.transform(listSubscriptionsResponse.getSubscriptionsList(),
            Subscription.fromPbFunction(serviceOptions.service()));
        String cursor = listSubscriptionsResponse.getNextPageToken().equals("") ? null
            : listSubscriptionsResponse.getNextPageToken();
        return new AsyncPageImpl<>(new SubscriptionPageFetcher(serviceOptions, cursor, options),
            cursor, subscriptions);
      }
    });
  }

  @Override
  public Page<Subscription> listSubscriptions(ListOption... options) {
    return get(listSubscriptionsAsync(options));
  }

  public Future<AsyncPage<Subscription>> listSubscriptionsAsync(ListOption... options) {
    return listSubscriptionsAsync(options(), optionMap(options));
  }

  private static ListTopicSubscriptionsRequest listSubscriptionsRequest(String topic,
      PubSubOptions serviceOptions, Map<Option.OptionType, ?> options) {
    ListTopicSubscriptionsRequest.Builder builder = ListTopicSubscriptionsRequest.newBuilder();
    builder.setTopic(PublisherApi.formatTopicName(serviceOptions.projectId(), topic));
    Integer pageSize = PAGE_SIZE.getInteger(options);
    String pageToken = PAGE_TOKEN.getString(options);
    if (pageSize != null) {
      builder.setPageSize(pageSize);
    }
    if (pageToken != null) {
      builder.setPageToken(pageToken);
    }
    return builder.build();
  }

  private static Future<AsyncPage<SubscriptionId>> listSubscriptionsAsync(final String topic,
      final PubSubOptions serviceOptions, final Map<Option.OptionType, ?> options) {
    final ListTopicSubscriptionsRequest request =
        listSubscriptionsRequest(topic, serviceOptions, options);
    Future<ListTopicSubscriptionsResponse> list = serviceOptions.rpc().list(request);
    return lazyTransform(list,
        new Function<ListTopicSubscriptionsResponse, AsyncPage<SubscriptionId>>() {
          @Override
          public AsyncPage<SubscriptionId> apply(
              ListTopicSubscriptionsResponse listSubscriptionsResponse) {
            List<SubscriptionId> subscriptions =
                listSubscriptionsResponse.getSubscriptionsList() == null
                    ? ImmutableList.<SubscriptionId>of()
                    : Lists.transform(listSubscriptionsResponse.getSubscriptionsList(),
                        new Function<String, SubscriptionId>() {
                          @Override
                          public SubscriptionId apply(String compositeSubscription) {
                            return SubscriptionId.fromPb(compositeSubscription);
                          }
                        });
            String cursor = listSubscriptionsResponse.getNextPageToken().equals("") ? null
                : listSubscriptionsResponse.getNextPageToken();
            return new AsyncPageImpl<>(
                new SubscriptionNamePageFetcher(topic, serviceOptions, cursor, options), cursor,
                subscriptions);
          }
        });
  }

  @Override
  public Page<SubscriptionId> listSubscriptions(String topic, ListOption... options) {
    return get(listSubscriptionsAsync(topic, options));
  }

  @Override
  public Future<AsyncPage<SubscriptionId>> listSubscriptionsAsync(String topic,
      ListOption... options) {
    return listSubscriptionsAsync(topic, options(), optionMap(options));
  }

  @Override
  public Iterator<ReceivedMessage> pull(String subscription, int maxMessages) {
    // this should set return_immediately to true
    return null;
  }

  @Override
  public Future<Iterator<ReceivedMessage>> pullAsync(String subscription, int maxMessages) {
    // though this method can set return_immediately to false (as future can be canceled) I
    // suggest to keep it false so sync could delegate to asyc and use the same options
    // this method also should use the VTKIT thread-pool to renew ack deadline for non consumed
    // messages
    return null;
  }

  @Override
  public MessageConsumer pullAsync(String subscription, MessageProcessor callback,
      PullOption... options) {
    // this method should use the VTKIT thread-pool (maybe getting it should be part of the spi)
    return null;
  }

  @Override
  public void ack(String subscription, String ackId, String... ackIds) {
    ack(subscription, Lists.asList(ackId, ackIds));
  }

  @Override
  public Future<Void> ackAsync(String subscription, String ackId, String... ackIds) {
    return ackAsync(subscription, Lists.asList(ackId, ackIds));
  }

  @Override
  public void ack(String subscription, Iterable<String> ackIds) {
    get(ackAsync(subscription, ackIds));
  }

  @Override
  public Future<Void> ackAsync(String subscription, Iterable<String> ackIds) {
    AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
        .setSubscription(SubscriberApi.formatSubscriptionName(options().projectId(), subscription))
        .addAllAckIds(ackIds)
        .build();
    return lazyTransform(rpc.acknowledge(request), EMPTY_TO_VOID_FUNCTION);
  }

  @Override
  public void nack(String subscription, String ackId, String... ackIds) {
    nack(subscription, Lists.asList(ackId, ackIds));
  }

  @Override
  public Future<Void> nackAsync(String subscription, String ackId, String... ackIds) {
    return nackAsync(subscription, Lists.asList(ackId, ackIds));
  }

  @Override
  public void nack(String subscription, Iterable<String> ackIds) {
    get(nackAsync(subscription, ackIds));
  }

  @Override
  public Future<Void> nackAsync(String subscription, Iterable<String> ackIds) {
    return modifyAckDeadlineAsync(subscription, 0, TimeUnit.SECONDS, ackIds);
  }

  @Override
  public void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, String ackId,
      String... ackIds) {
    get(modifyAckDeadlineAsync(subscription, deadline, unit, Lists.asList(ackId, ackIds)));
  }

  @Override
  public Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      String ackId, String... ackIds) {
    return modifyAckDeadlineAsync(subscription, deadline, unit, Lists.asList(ackId, ackIds));
  }

  @Override
  public void modifyAckDeadline(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds) {
    get(modifyAckDeadlineAsync(subscription, deadline, unit, ackIds));
  }

  @Override
  public Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds) {
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setSubscription(SubscriberApi.formatSubscriptionName(options().projectId(), subscription))
        .setAckDeadlineSeconds((int) TimeUnit.SECONDS.convert(deadline, unit))
        .addAllAckIds(ackIds)
        .build();
    return lazyTransform(rpc.modify(request), EMPTY_TO_VOID_FUNCTION);
  }

  static <T extends Option.OptionType> Map<Option.OptionType, ?> optionMap(Option... options) {
    Map<Option.OptionType, Object> optionMap = Maps.newHashMap();
    for (Option option : options) {
      Object prev = optionMap.put(option.optionType(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }

  @Override
  public void close() throws Exception {
    rpc.close();
  }
}
