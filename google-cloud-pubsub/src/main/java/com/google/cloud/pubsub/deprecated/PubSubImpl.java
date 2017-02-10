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

package com.google.cloud.pubsub.deprecated;

import static com.google.cloud.pubsub.deprecated.PubSub.ListOption.OptionType.PAGE_SIZE;
import static com.google.cloud.pubsub.deprecated.PubSub.ListOption.OptionType.PAGE_TOKEN;
import static com.google.cloud.pubsub.deprecated.PubSub.PullOption.OptionType.EXECUTOR_FACTORY;
import static com.google.cloud.pubsub.deprecated.PubSub.PullOption.OptionType.MAX_QUEUED_CALLBACKS;
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.AsyncPage;
import com.google.cloud.AsyncPageImpl;
import com.google.cloud.BaseService;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.Policy;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc.PullFuture;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.Uninterruptibles;
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
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PubSubImpl extends BaseService<PubSubOptions> implements PubSub {

  private final PubSubRpc rpc;
  private final AckDeadlineRenewer ackDeadlineRenewer;
  private boolean closed;

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
  private static final Function<com.google.pubsub.v1.ReceivedMessage, String>
      MESSAGE_TO_ACK_ID_FUNCTION = new Function<com.google.pubsub.v1.ReceivedMessage, String>() {
        @Override
        public String apply(com.google.pubsub.v1.ReceivedMessage message) {
          return message.getAckId();
        }
      };
  private static final Function<com.google.iam.v1.Policy, Policy> POLICY_TO_PB_FUNCTION =
      new Function<com.google.iam.v1.Policy, Policy>() {
        @Override
        public Policy apply(com.google.iam.v1.Policy policyPb) {
          return policyPb == null ? null : PolicyMarshaller.INSTANCE.fromPb(policyPb);
        }
      };

  PubSubImpl(PubSubOptions options) {
    super(options);
    rpc = options.getRpc();
    ackDeadlineRenewer = new AckDeadlineRenewer(this);
  }

  @VisibleForTesting
  PubSubImpl(PubSubOptions options, AckDeadlineRenewer ackDeadlineRenewer) {
    super(options);
    rpc = options.getRpc();
    this.ackDeadlineRenewer = ackDeadlineRenewer;
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
    @Deprecated
    public Future<AsyncPage<Topic>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<Topic>> getNextPage() {
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
    @Deprecated
    public Future<AsyncPage<Subscription>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<Subscription>> getNextPage() {
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
    @Deprecated
    public Future<AsyncPage<SubscriptionId>> nextPage() {
      return getNextPage();
    }

    @Override
    public Future<AsyncPage<SubscriptionId>> getNextPage() {
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

  private static <I, O> Future<O> transform(Future<I> future,
      Function<? super I, ? extends O> function) {
    return Futures.lazyTransform(future, function);
  }

  @Override
  public Topic create(TopicInfo topic) {
    return get(createAsync(topic));
  }

  @Override
  public Future<Topic> createAsync(TopicInfo topic) {
    return transform(rpc.create(topic.toPb(getOptions().getProjectId())),
        Topic.fromPbFunction(this));
  }

  @Override
  public Topic getTopic(String topic) {
    return get(getTopicAsync(topic));
  }

  @Override
  public Future<Topic> getTopicAsync(String topic) {
    GetTopicRequest request = GetTopicRequest.newBuilder()
        .setTopicWithTopicName(TopicName.create(getOptions().getProjectId(), topic))
        .build();
    return transform(rpc.get(request), Topic.fromPbFunction(this));
  }

  @Override
  public boolean deleteTopic(String topic) {
    return get(deleteTopicAsync(topic));
  }

  @Override
  public Future<Boolean> deleteTopicAsync(String topic) {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder()
        .setTopicWithTopicName(TopicName.create(getOptions().getProjectId(), topic))
        .build();
    return transform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
  }

  private static ListTopicsRequest listTopicsRequest(PubSubOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListTopicsRequest.Builder builder = ListTopicsRequest.newBuilder();
    builder.setProjectWithProjectName(ProjectName.create(serviceOptions.getProjectId()));
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
    Future<ListTopicsResponse> list = serviceOptions.getRpc().list(request);
    return transform(list,  new Function<ListTopicsResponse, AsyncPage<Topic>>() {
      @Override
      public AsyncPage<Topic> apply(ListTopicsResponse listTopicsResponse) {
        List<Topic> topics = listTopicsResponse.getTopicsList() == null ? ImmutableList.<Topic>of()
            : Lists.transform(listTopicsResponse.getTopicsList(),
                Topic.fromPbFunction(serviceOptions.getService()));
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
    return listTopicsAsync(getOptions(), optionMap(options));
  }

  @Override
  public String publish(String topic, Message message) {
    return get(publishAsync(topic, message));
  }

  private static PublishRequest publishRequest(PubSubOptions serviceOptions, String topic,
      Iterable<Message> messages) {
    PublishRequest.Builder builder = PublishRequest.newBuilder();
    builder.setTopicWithTopicName(TopicName.create(serviceOptions.getProjectId(), topic));
    builder.addAllMessages(Iterables.transform(messages, Message.TO_PB_FUNCTION));
    return builder.build();
  }

  @Override
  public Future<String> publishAsync(String topic, Message message) {
    return transform(
        rpc.publish(publishRequest(getOptions(), topic, Collections.singletonList(message))),
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
    return transform(rpc.publish(publishRequest(getOptions(), topic, messages)),
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
    return transform(rpc.create(subscription.toPb(getOptions().getProjectId())),
        Subscription.fromPbFunction(this));
  }

  @Override
  public Subscription getSubscription(String subscription) {
    return get(getSubscriptionAsync(subscription));
  }

  @Override
  public Future<Subscription> getSubscriptionAsync(String subscription) {
    GetSubscriptionRequest request = GetSubscriptionRequest.newBuilder()
        .setSubscriptionWithSubscriptionName(
            SubscriptionName.create(getOptions().getProjectId(), subscription))
        .build();
    return transform(rpc.get(request), Subscription.fromPbFunction(this));
  }

  @Override
  public void replacePushConfig(String subscription, PushConfig pushConfig) {
    get(replacePushConfigAsync(subscription, pushConfig));
  }

  @Override
  public Future<Void> replacePushConfigAsync(String subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
        .setSubscriptionWithSubscriptionName(
            SubscriptionName.create(getOptions().getProjectId(), subscription))
        .setPushConfig(pushConfig != null ? pushConfig.toPb()
            : com.google.pubsub.v1.PushConfig.getDefaultInstance())
        .build();
    return transform(rpc.modify(request), EMPTY_TO_VOID_FUNCTION);
  }

  @Override
  public boolean deleteSubscription(String subscription) {
    return get(deleteSubscriptionAsync(subscription));
  }

  @Override
  public Future<Boolean> deleteSubscriptionAsync(String subscription) {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscriptionWithSubscriptionName(
            SubscriptionName.create(getOptions().getProjectId(), subscription))
        .build();
    return transform(rpc.delete(request), EMPTY_TO_BOOLEAN_FUNCTION);
  }

  private static ListSubscriptionsRequest listSubscriptionsRequest(PubSubOptions serviceOptions,
      Map<Option.OptionType, ?> options) {
    ListSubscriptionsRequest.Builder builder = ListSubscriptionsRequest.newBuilder();
    builder.setProjectWithProjectName(ProjectName.create(serviceOptions.getProjectId()));
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
    Future<ListSubscriptionsResponse> list = serviceOptions.getRpc().list(request);
    return transform(list, new Function<ListSubscriptionsResponse, AsyncPage<Subscription>>() {
      @Override
      public AsyncPage<Subscription> apply(ListSubscriptionsResponse listSubscriptionsResponse) {
        List<Subscription> subscriptions = listSubscriptionsResponse.getSubscriptionsList() == null
            ? ImmutableList.<Subscription>of()
            : Lists.transform(listSubscriptionsResponse.getSubscriptionsList(),
            Subscription.fromPbFunction(serviceOptions.getService()));
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
    return listSubscriptionsAsync(getOptions(), optionMap(options));
  }

  private static ListTopicSubscriptionsRequest listSubscriptionsRequest(String topic,
      PubSubOptions serviceOptions, Map<Option.OptionType, ?> options) {
    ListTopicSubscriptionsRequest.Builder builder = ListTopicSubscriptionsRequest.newBuilder();
    builder.setTopicWithTopicName(TopicName.create(serviceOptions.getProjectId(), topic));
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
    Future<ListTopicSubscriptionsResponse> list = serviceOptions.getRpc().list(request);
    return transform(list,
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
    return listSubscriptionsAsync(topic, getOptions(), optionMap(options));
  }

  private Future<Iterator<ReceivedMessage>> pullAsync(final String subscription,
      int maxMessages, boolean returnImmediately) {
    PullRequest request = PullRequest.newBuilder()
        .setSubscriptionWithSubscriptionName(
            SubscriptionName.create(getOptions().getProjectId(), subscription))
        .setMaxMessages(maxMessages)
        .setReturnImmediately(returnImmediately)
        .build();
    PullFuture future = rpc.pull(request);
    future.addCallback(new PubSubRpc.PullCallback() {
      @Override
      public void success(PullResponse response) {
        List<String> ackIds = Lists.transform(response.getReceivedMessagesList(),
            MESSAGE_TO_ACK_ID_FUNCTION);
        ackDeadlineRenewer.add(subscription, ackIds);
      }

      @Override
      public void failure(Throwable error) {
        // ignore
      }
    });
    return transform(future, new Function<PullResponse, Iterator<ReceivedMessage>>() {
      @Override
      public Iterator<ReceivedMessage> apply(PullResponse response) {
        return Iterators.transform(response.getReceivedMessagesList().iterator(),
            new Function<com.google.pubsub.v1.ReceivedMessage, ReceivedMessage>() {
              @Override
              public ReceivedMessage apply(com.google.pubsub.v1.ReceivedMessage receivedMessage) {
                // Remove consumed message from automatic ack deadline renewer
                ackDeadlineRenewer.remove(subscription, receivedMessage.getAckId());
                return ReceivedMessage.fromPb(PubSubImpl.this, subscription, receivedMessage);
              }
            });
      }
    });
  }

  @Override
  public Iterator<ReceivedMessage> pull(String subscription, int maxMessages) {
    return get(pullAsync(subscription, maxMessages, true));
  }

  @Override
  public Future<Iterator<ReceivedMessage>> pullAsync(String subscription, int maxMessages) {
    return pullAsync(subscription, maxMessages, false);
  }

  @Override
  public MessageConsumer pullAsync(String subscription, MessageProcessor callback,
      PullOption... options) {
    Map<Option.OptionType, ?> optionMap = optionMap(options);
    return MessageConsumerImpl.builder(getOptions(), subscription, ackDeadlineRenewer, callback)
        .maxQueuedCallbacks(MAX_QUEUED_CALLBACKS.getInteger(optionMap))
        .executorFactory(EXECUTOR_FACTORY.getExecutorFactory(optionMap))
        .build();
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
        .setSubscriptionWithSubscriptionName(
            SubscriptionName.create(getOptions().getProjectId(), subscription))
        .addAllAckIds(ackIds)
        .build();
    return transform(rpc.acknowledge(request), EMPTY_TO_VOID_FUNCTION);
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
        .setSubscriptionWithSubscriptionName(
            SubscriptionName.create(getOptions().getProjectId(), subscription))
        .setAckDeadlineSeconds((int) TimeUnit.SECONDS.convert(deadline, unit))
        .addAllAckIds(ackIds)
        .build();
    return transform(rpc.modify(request), EMPTY_TO_VOID_FUNCTION);
  }

  @Override
  public Policy getTopicPolicy(String topic) {
    return get(getTopicPolicyAsync(topic));
  }

  @Override
  public Future<Policy> getTopicPolicyAsync(String topic) {
    return transform(
        rpc.getIamPolicy(TopicName.create(getOptions().getProjectId(), topic).toString()),
        POLICY_TO_PB_FUNCTION);
  }

  @Override
  public Policy replaceTopicPolicy(String topic, Policy newPolicy) {
    return get(replaceTopicPolicyAsync(topic, newPolicy));
  }

  @Override
  public Future<Policy> replaceTopicPolicyAsync(String topic, Policy newPolicy) {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
        .setPolicy(PolicyMarshaller.INSTANCE.toPb(newPolicy))
        .setResource(TopicName.create(getOptions().getProjectId(), topic).toString())
        .build();
    return transform(rpc.setIamPolicy(request), POLICY_TO_PB_FUNCTION);
  }

  @Override
  public List<Boolean> testTopicPermissions(String topic, final List<String> permissions) {
    return get(testTopicPermissionsAsync(topic, permissions));
  }

  @Override
  public Future<List<Boolean>> testTopicPermissionsAsync(String topic, List<String> permissions) {
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(TopicName.create(getOptions().getProjectId(), topic).toString())
        .addAllPermissions(permissions)
        .build();
    return transform(rpc.testIamPermissions(request), permissionsFromPbFunction(permissions));
  }

  @Override
  public Policy getSubscriptionPolicy(String subscription) {
    return get(getSubscriptionPolicyAsync(subscription));
  }

  @Override
  public Future<Policy> getSubscriptionPolicyAsync(String subscription) {
    return transform(
        rpc.getIamPolicy(
            SubscriptionName.create(getOptions().getProjectId(), subscription).toString()),
        POLICY_TO_PB_FUNCTION);
  }

  @Override
  public Policy replaceSubscriptionPolicy(String subscription, Policy newPolicy) {
    return get(replaceSubscriptionPolicyAsync(subscription, newPolicy));
  }

  @Override
  public Future<Policy> replaceSubscriptionPolicyAsync(String subscription, Policy newPolicy) {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
        .setPolicy(PolicyMarshaller.INSTANCE.toPb(newPolicy))
        .setResource(
            SubscriptionName.create(getOptions().getProjectId(), subscription).toString())
        .build();
    return transform(rpc.setIamPolicy(request), POLICY_TO_PB_FUNCTION);
  }

  @Override
  public List<Boolean> testSubscriptionPermissions(String subscription, List<String> permissions) {
    return get(testSubscriptionPermissionsAsync(subscription, permissions));
  }

  @Override
  public Future<List<Boolean>> testSubscriptionPermissionsAsync(String subscription,
      List<String> permissions) {
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(
            SubscriptionName.create(getOptions().getProjectId(), subscription).toString())
        .addAllPermissions(permissions)
        .build();
    return transform(rpc.testIamPermissions(request), permissionsFromPbFunction(permissions));
  }

  private static Function<TestIamPermissionsResponse, List<Boolean>> permissionsFromPbFunction(
      final List<String> permissions) {
    return new Function<TestIamPermissionsResponse, List<Boolean>>() {
      @Override
      public List<Boolean> apply(TestIamPermissionsResponse response) {
        Set<String> permissionsOwned = ImmutableSet.copyOf(
            firstNonNull(response.getPermissionsList(), ImmutableList.<String>of()));
        ImmutableList.Builder<Boolean> answer = ImmutableList.builder();
        for (String permission : permissions) {
          answer.add(permissionsOwned.contains(permission));
        }
        return answer.build();
      }
    };
  }

  static <T extends Option.OptionType> Map<Option.OptionType, ?> optionMap(Option... options) {
    Map<Option.OptionType, Object> optionMap = Maps.newHashMap();
    for (Option option : options) {
      Object prev = optionMap.put(option.getOptionType(), option.getValue());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }

  @Override
  public void close() throws Exception {
    if (closed) {
      return;
    }
    closed = true;
    rpc.close();
    if (ackDeadlineRenewer != null) {
      ackDeadlineRenewer.close();
    }
  }
}
