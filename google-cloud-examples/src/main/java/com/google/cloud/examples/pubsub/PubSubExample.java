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

package com.google.cloud.examples.pubsub;

import com.google.cloud.pubsub.Message;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSub.MessageProcessor;
import com.google.cloud.pubsub.PubSubOptions;
import com.google.cloud.pubsub.PushConfig;
import com.google.cloud.pubsub.ReceivedMessage;
import com.google.cloud.pubsub.Subscription;
import com.google.cloud.pubsub.SubscriptionId;
import com.google.cloud.pubsub.SubscriptionInfo;
import com.google.cloud.pubsub.Topic;
import com.google.cloud.pubsub.TopicInfo;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An example of using Google BigQuery.
 *
 * <p>This example demonstrates a simple/typical Pub/Sub usage.
 *
 * <p>See the
 * <a href="https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 * <pre>{@code target/appassembler/bin/PubSubExample
 *  -Dexec.args="[<project_id>]
 *  pull async <subscription> <timeoutMillis>?
 *  pull sync <subscription> <maxMessages>
 *  publish <topic> <message>+
 *  replace-push-config <subscription> <endpoint>?
 *  ack <subscription> <ackId>+
 *  nack <subscription> <ackId>+
 *  create topic <topic>
 *  create subscription <topic> <subscription> <endpoint>?
 *  list subscriptions <topic>?
 *  list topics
 *  delete topic <topic>
 *  delete subscription <subscription>
 *  info topic <topic>
 *  info subscription <subscription>"}</pre>
 *
 * <p>The first parameter is an optional {@code project_id} (logged-in project will be used if not
 * supplied). Second parameter is a Pub/Sub operation and can be used to demonstrate its usage. For
 * operations that apply to more than one entity (`list`, `create`, `info` and `delete`) the third
 * parameter specifies the entity. `pull` operation also takes a third parameter to specify whether
 * pulling should be synchronous or asynchronous.
 */
public class PubSubExample {

  private static final Map<String, PubSubAction> CREATE_ACTIONS = new HashMap<>();
  private static final Map<String, PubSubAction> INFO_ACTIONS = new HashMap<>();
  private static final Map<String, PubSubAction> LIST_ACTIONS = new HashMap<>();
  private static final Map<String, PubSubAction> DELETE_ACTIONS = new HashMap<>();
  private static final Map<String, PubSubAction> PULL_ACTIONS = new HashMap<>();
  private static final Map<String, PubSubAction> ACTIONS = new HashMap<>();

  private abstract static class PubSubAction<T> {

    abstract void run(PubSub pubsub, T arg) throws Exception;

    abstract T parse(String... args) throws Exception;

    protected String params() {
      return "";
    }
  }

  private static class Tuple<X, Y> {

    private final X x;
    private final Y y;

    private Tuple(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    public static <X, Y> Tuple<X, Y> of(X x, Y y) {
      return new Tuple<>(x, y);
    }

    X x() {
      return x;
    }

    Y y() {
      return y;
    }
  }

  private static class ParentAction extends PubSubAction<Tuple<PubSubAction, Object>> {

    private final Map<String, PubSubAction> subActions;

    ParentAction(Map<String, PubSubAction> subActions) {
      this.subActions = ImmutableMap.copyOf(subActions);
    }

    @Override
    @SuppressWarnings("unchecked")
    void run(PubSub pubsub, Tuple<PubSubAction, Object> subaction) throws Exception {
      subaction.x().run(pubsub, subaction.y());
    }

    @Override
    Tuple<PubSubAction, Object> parse(String... args) throws Exception {
      if (args.length >= 1) {
        PubSubAction action = subActions.get(args[0]);
        if (action != null) {
          Object actionArguments = action.parse(Arrays.copyOfRange(args, 1, args.length));
          return Tuple.of(action, actionArguments);
        } else {
          throw new IllegalArgumentException("Unrecognized entity '" + args[0] + "'.");
        }
      }
      throw new IllegalArgumentException("Missing required entity.");
    }

    @Override
    public String params() {
      StringBuilder builder = new StringBuilder();
      for (Map.Entry<String, PubSubAction> entry : subActions.entrySet()) {
        builder.append('\n').append(entry.getKey());
        String param = entry.getValue().params();
        if (param != null && !param.isEmpty()) {
          builder.append(' ').append(param);
        }
      }
      return builder.toString();
    }
  }

  private abstract static class NoArgsAction extends PubSubAction<Void> {
    @Override
    Void parse(String... args) throws Exception {
      if (args.length == 0) {
        return null;
      }
      throw new IllegalArgumentException("This action takes no arguments.");
    }
  }

  /**
   * This class demonstrates how to list Pub/Sub topics.
   *
   * @see <a href="https://cloud.google.com/pubsub/publisher#list-topics-in-your-project">List
   *     topics in your project</a>
   */
  private static class ListTopicsAction extends NoArgsAction {
    @Override
    public void run(PubSub pubsub, Void arg) {
      Iterator<Topic> topicIterator = pubsub.listTopics().iterateAll();
      while (topicIterator.hasNext()) {
        System.out.println(topicIterator.next());
      }
    }
  }

  private abstract static class TopicAction extends PubSubAction<String> {
    @Override
    String parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return args[0];
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required topic name.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<topic>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Pub/Sub topic.
   */
  private static class TopicInfoAction extends TopicAction {
    @Override
    public void run(PubSub pubsub, String topic) {
      System.out.printf("Topic info: %s%n", pubsub.getTopic(topic));
    }
  }

  /**
   * This class demonstrates how to create a Pub/Sub topic.
   *
   * @see <a href="https://cloud.google.com/pubsub/publisher#create">Create a topic</a>
   */
  private static class CreateTopicAction extends TopicAction {
    @Override
    public void run(PubSub pubsub, String topic) {
      pubsub.create(TopicInfo.of(topic));
      System.out.printf("Created topic %s%n", topic);
    }
  }

  /**
   * This class demonstrates how to delete a Pub/Sub topic.
   *
   * @see <a href="https://cloud.google.com/pubsub/publisher#delete">Delete a topic</a>
   */
  private static class DeleteTopicAction extends TopicAction {
    @Override
    public void run(PubSub pubsub, String topic) {
      pubsub.deleteTopic(topic);
      System.out.printf("Deleted topic %s%n", topic);
    }
  }

  /**
   * This class demonstrates how to list Pub/Sub subscriptions.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#list">List subscriptions</a>
   */
  private static class ListSubscriptionsAction extends PubSubAction<String> {
    @Override
    public void run(PubSub pubsub, String topic) {
      if (topic == null) {
        Iterator<Subscription> subscriptionIterator = pubsub.listSubscriptions().iterateAll();
        while (subscriptionIterator.hasNext()) {
          System.out.println(subscriptionIterator.next());
        }
      } else {
        Iterator<SubscriptionId> subscriptionIdIterator =
            pubsub.listSubscriptions(topic).iterateAll();
        while (subscriptionIdIterator.hasNext()) {
          System.out.println(subscriptionIdIterator.next());
        }
      }
    }

    @Override
    String parse(String... args) throws Exception {
      if (args.length == 1) {
        return args[0];
      } else if (args.length == 0) {
        return null;
      } else {
        throw new IllegalArgumentException("Too many arguments.");
      }
    }

    @Override
    public String params() {
      return "<topic>?";
    }
  }

  /**
   * This class demonstrates how to publish messages to a Pub/Sub topic.
   *
   * @see <a href="https://cloud.google.com/pubsub/publisher#publish-messages-to-a-topic">Publish
   *     messages to a topic</a>
   */
  private static class PublishMessagesAction extends PubSubAction<Tuple<String, List<Message>>> {
    @Override
    public void run(PubSub pubsub, Tuple<String, List<Message>> params) {
      String topic = params.x();
      List<Message> messages = params.y();
      pubsub.publish(topic, messages);
      System.out.printf("Published %d messages to topic %s%n", messages.size(), topic);
    }

    @Override
    Tuple<String, List<Message>> parse(String... args) throws Exception {
      if (args.length < 2) {
        throw new IllegalArgumentException("Missing required topic and messages");
      }
      String topic = args[0];
      List<Message> messages = new ArrayList<>();
      for (String payload : Arrays.copyOfRange(args, 1, args.length)) {
        messages.add(Message.of(payload));
      }
      return Tuple.of(topic, messages);
    }

    @Override
    public String params() {
      return "<topic> <message>+";
    }
  }

  private abstract static class SubscriptionAction extends PubSubAction<String> {
    @Override
    String parse(String... args) throws Exception {
      String message;
      if (args.length == 1) {
        return args[0];
      } else if (args.length > 1) {
        message = "Too many arguments.";
      } else {
        message = "Missing required subscription name.";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<subscription>";
    }
  }

  /**
   * This class demonstrates how to retrieve information on a Pub/Sub subscription.
   */
  private static class SubscriptionInfoAction extends SubscriptionAction {
    @Override
    public void run(PubSub pubsub, String subscription) {
      System.out.printf("Subscription info: %s%n", pubsub.getSubscription(subscription));
    }
  }

  /**
   * This class demonstrates how to create a Pub/Sub subscription.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#create">Create a subscription</a>
   */
  private static class CreateSubscriptionAction extends PubSubAction<SubscriptionInfo> {
    @Override
    public void run(PubSub pubsub, SubscriptionInfo subscription) {
      pubsub.create(subscription);
      System.out.printf("Created subscription %s%n", subscription.name());
    }

    @Override
    SubscriptionInfo parse(String... args) throws Exception {
      String message;
      if (args.length > 3) {
        message = "Too many arguments.";
      } else if (args.length < 2) {
        message = "Missing required topic or subscription name";
      } else {
        SubscriptionInfo.Builder builder = SubscriptionInfo.builder(args[0], args[1]);
        if (args.length == 3) {
          builder.pushConfig(PushConfig.of(args[2]));
        }
        return builder.build();
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<topic> <subscription> <endpoint>?";
    }
  }

  /**
   * This class demonstrates how to delete a Pub/Sub subscription.
   */
  private static class DeleteSubscriptionAction extends SubscriptionAction {
    @Override
    public void run(PubSub pubsub, String subscription) {
      pubsub.deleteSubscription(subscription);
      System.out.printf("Deleted subscription %s%n", subscription);
    }
  }

  /**
   * This class demonstrates how to modify the push configuration for a Pub/Sub subscription.
   *
   * @see <a
   *     href="https://cloud.google.com/pubsub/subscriber#switching-between-push-and-pull-delivery">
   *     Switching between push and pull delivery</a>
   */
  private static class ReplacePushConfigAction extends PubSubAction<Tuple<String, PushConfig>> {
    @Override
    public void run(PubSub pubsub, Tuple<String, PushConfig> params) {
      String subscription = params.x();
      PushConfig pushConfig = params.y();
      pubsub.replacePushConfig(subscription, pushConfig);
      System.out.printf("Set push config %s for subscription %s%n", pushConfig, subscription);
    }

    @Override
    Tuple<String, PushConfig> parse(String... args) throws Exception {
      String message;
      if (args.length > 2) {
        message = "Too many arguments.";
      } else if (args.length < 1) {
        message = "Missing required subscription name";
      } else {
        String subscription = args[0];
        PushConfig pushConfig = null;
        if (args.length == 2) {
          pushConfig = PushConfig.of(args[1]);
        }
        return Tuple.of(subscription, pushConfig);
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<subscription> <endpoint>?";
    }
  }

  private abstract static class MessagesAction extends PubSubAction<Tuple<String, List<String>>> {
    @Override
    Tuple<String, List<String>> parse(String... args) throws Exception {
      if (args.length < 2) {
        throw new IllegalArgumentException("Missing required subscription and ack IDs");
      }
      String subscription = args[0];
      return Tuple.of(subscription, Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
    }

    @Override
    public String params() {
      return "<subscription> <ackId>+";
    }
  }

  /**
   * This class demonstrates how to acknowledge Pub/Sub messages for a subscription.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#receiving-pull-messages">Receiving
   *     pull messages</a>
   */
  private static class AckMessagesAction extends MessagesAction {
    @Override
    public void run(PubSub pubsub, Tuple<String, List<String>> params) {
      String subscription = params.x();
      List<String> ackIds = params.y();
      pubsub.ack(subscription, ackIds);
      System.out.printf("Acked %d messages for subscription %s%n", ackIds.size(), subscription);
    }
  }

  /**
   * This class demonstrates how to "nack" Pub/Sub messages for a subscription. This action
   * corresponds to setting the acknowledge deadline to 0.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#receiving-pull-messages">Message
   *     acknowledgement deadline</a>
   */
  private static class NackMessagesAction extends MessagesAction {
    @Override
    public void run(PubSub pubsub, Tuple<String, List<String>> params) {
      String subscription = params.x();
      List<String> ackIds = params.y();
      pubsub.nack(subscription, ackIds);
      System.out.printf("Nacked %d messages for subscription %s%n", ackIds.size(), subscription);
    }
  }

  /**
   * This class demonstrates how modify the acknowledge deadline for messages in a Pub/Sub
   * subscription.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#receiving-pull-messages">Message
   *     acknowledgement deadline</a>
   */
  private static class ModifyAckDeadlineAction
      extends PubSubAction<Tuple<ModifyAckDeadlineAction.SubscriptionAndDeadline, List<String>>> {

    static class SubscriptionAndDeadline {

      private final String subscription;
      private final int deadlineMillis;

      private SubscriptionAndDeadline(String subscription, int deadlineMillis) {
        this.subscription = subscription;
        this.deadlineMillis = deadlineMillis;
      }

      String subscription() {
        return subscription;
      }

      int deadlineMillis() {
        return deadlineMillis;
      }
    }

    @Override
    public void run(PubSub pubsub, Tuple<SubscriptionAndDeadline, List<String>> params)
        throws Exception {
      String subscription = params.x().subscription();
      int deadline = params.x().deadlineMillis();
      List<String> ackIds = params.y();
      pubsub.modifyAckDeadline(subscription, deadline, TimeUnit.MILLISECONDS, ackIds);
      System.out.printf("Ack deadline set to %d for %d messages in subscription %s%n", deadline,
          ackIds.size(), subscription);
    }

    @Override
    Tuple<SubscriptionAndDeadline, List<String>> parse(String... args) throws Exception {
      if (args.length < 3) {
        throw new IllegalArgumentException("Missing required subscription, deadline and ack IDs");
      }
      String subscription = args[0];
      int deadline = Integer.parseInt(args[1]);
      return Tuple.of(new SubscriptionAndDeadline(subscription, deadline),
          Arrays.asList(Arrays.copyOfRange(args, 2, args.length)));
    }

    @Override
    public String params() {
      return "<subscription> <deadlineMillis> <ackId>+";
    }
  }

  /**
   * This class demonstrates how to asynchronously pull messages from a Pub/Sub pull subscription.
   * Messages are pulled until a timeout is reached.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#receiving-pull-messages">Receiving
   *     pull messages</a>
   */
  private static class PullAsyncAction extends PubSubAction<Tuple<String, Long>> {
    @Override
    public void run(PubSub pubsub, Tuple<String, Long> params) throws Exception {
      String subscription = params.x();
      Long timeout = params.y();
      final AtomicInteger messageCount = new AtomicInteger();
      MessageProcessor messageProcessor = new MessageProcessor() {

        @Override
        public void process(Message message) throws Exception {
          System.out.printf("Received message \"%s\"%n", message);
          messageCount.incrementAndGet();
        }
      };
      try (PubSub.MessageConsumer consumer = pubsub.pullAsync(subscription, messageProcessor)) {
        Thread.sleep(timeout);
      }
      System.out.printf("Pulled %d messages from subscription %s%n", messageCount.get(),
          subscription);
    }

    @Override
    Tuple<String, Long> parse(String... args) throws Exception {
      String message;
      if (args.length > 2) {
        message = "Too many arguments.";
      } else if (args.length < 1) {
        message = "Missing required subscription name";
      } else {
        String subscription = args[0];
        long timeout = 60_000;
        if (args.length == 2) {
          timeout = Long.parseLong(args[1]);
        }
        return Tuple.of(subscription, timeout);
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<subscription> <timeoutMillis>?";
    }
  }

  /**
   * This class demonstrates how to synchronously pull messages from a Pub/Sub pull subscription.
   * No more than the requested number of messages are pulled. Possibly less messages are pulled.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#receiving-pull-messages">Receiving
   *     pull messages</a>
   */
  private static class PullSyncAction extends PubSubAction<Tuple<String, Integer>> {
    @Override
    public void run(PubSub pubsub, Tuple<String, Integer> params) throws Exception {
      String subscription = params.x();
      Integer maxMessages = params.y();
      Iterator<ReceivedMessage> messageIterator = pubsub.pull(subscription, maxMessages);
      int messageCount = 0;
      while (messageIterator.hasNext()) {
        ReceivedMessage message = messageIterator.next();
        System.out.printf("Received message \"%s\"%n", message);
        message.ack();
        messageCount++;
      }
      System.out.printf("Pulled %d messages from subscription %s%n", messageCount, subscription);
    }

    @Override
    Tuple<String, Integer> parse(String... args) throws Exception {
      String message;
      if (args.length == 2) {
        String subscription = args[0];
        int maxMessages = Integer.parseInt(args[1]);
        return Tuple.of(subscription, maxMessages);
      } else if (args.length > 2) {
        message = "Too many arguments.";
      } else {
        message = "Missing required subscription name";
      }
      throw new IllegalArgumentException(message);
    }

    @Override
    public String params() {
      return "<subscription> <maxMessages>";
    }
  }

  static {
    CREATE_ACTIONS.put("topic", new CreateTopicAction());
    CREATE_ACTIONS.put("subscription", new CreateSubscriptionAction());
    INFO_ACTIONS.put("topic", new TopicInfoAction());
    INFO_ACTIONS.put("subscription", new SubscriptionInfoAction());
    LIST_ACTIONS.put("topics", new ListTopicsAction());
    LIST_ACTIONS.put("subscriptions", new ListSubscriptionsAction());
    DELETE_ACTIONS.put("topic", new DeleteTopicAction());
    DELETE_ACTIONS.put("subscription", new DeleteSubscriptionAction());
    PULL_ACTIONS.put("async", new PullAsyncAction());
    PULL_ACTIONS.put("sync", new PullSyncAction());
    ACTIONS.put("create", new ParentAction(CREATE_ACTIONS));
    ACTIONS.put("info", new ParentAction(INFO_ACTIONS));
    ACTIONS.put("list", new ParentAction(LIST_ACTIONS));
    ACTIONS.put("delete", new ParentAction(DELETE_ACTIONS));
    ACTIONS.put("pull", new ParentAction(PULL_ACTIONS));
    ACTIONS.put("publish", new PublishMessagesAction());
    ACTIONS.put("replace-push-config", new ReplacePushConfigAction());
    ACTIONS.put("ack", new AckMessagesAction());
    ACTIONS.put("nack", new NackMessagesAction());
    ACTIONS.put("modify-ack-deadline", new ModifyAckDeadlineAction());
  }

  private static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, PubSubAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append("\n\t").append(entry.getKey());

      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param.replace("\n", "\n\t\t"));
      }
    }
    System.out.printf("Usage: %s [<project_id>] operation [entity] <args>*%s%n",
        PubSubExample.class.getSimpleName(), actionAndParams);
  }

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required project id and action");
      printUsage();
      return;
    }
    PubSubOptions.Builder optionsBuilder = PubSubOptions.builder();
    PubSubAction action;
    String actionName;
    if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
      actionName = args[1];
      optionsBuilder.projectId(args[0]);
      action = ACTIONS.get(args[1]);
      args = Arrays.copyOfRange(args, 2, args.length);
    } else {
      actionName = args[0];
      action = ACTIONS.get(args[0]);
      args = Arrays.copyOfRange(args, 1, args.length);
    }
    if (action == null) {
      System.out.println("Unrecognized action.");
      printUsage();
      return;
    }
    try (PubSub pubsub = optionsBuilder.build().service()) {
      Object arg;
      try {
        arg = action.parse(args);
      } catch (IllegalArgumentException ex) {
        System.out.printf("Invalid input for action '%s'. %s%n", actionName, ex.getMessage());
        System.out.printf("Expected: %s%n", action.params());
        return;
      } catch (Exception ex) {
        System.out.println("Failed to parse arguments.");
        ex.printStackTrace();
        return;
      }
      action.run(pubsub, arg);
    }
  }
}
