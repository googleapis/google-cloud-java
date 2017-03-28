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

import com.google.api.gax.core.ApiFuture;
import com.google.api.gax.core.ApiFutureCallback;
import com.google.api.gax.core.ApiFutures;
import com.google.cloud.Identity;
import com.google.cloud.Role;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.spi.v1.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An example of using Google Pub/Sub.
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
 *  info subscription <subscription>
 *  get-policy topic <resourceName>
 *  get-policy subscription <resourceName>
 *  add-identity topic <resourceName> <role> <identity>
 *  add-identity subscription <resourceName> <role> <identity>
 *  test-permissions topic <resourceName> <permission>+
 *  test-permissions subscription <resourceName> <permission>+"}</pre>
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
    private static final Map<String, PubSubAction> GET_IAM_ACTIONS = new HashMap<>();
    private static final Map<String, PubSubAction> REPLACE_IAM_ACTIONS = new HashMap<>();
    private static final Map<String, PubSubAction> TEST_IAM_ACTIONS = new HashMap<>();
    private static final Map<String, PubSubAction> ACTIONS = new HashMap<>();

    private static String projectId;

    private abstract static class PubSubAction<T> {

        abstract void run(T arg) throws Exception;

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
        void run(Tuple<PubSubAction, Object> subaction) throws Exception {
            subaction.x().run(subaction.y());
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
     * topics in your project</a>
     */
    private static class ListTopicsAction extends NoArgsAction {
        @Override
        public void run(Void arg) throws Exception {
            try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                ListTopicsRequest listTopicsRequest =
                        ListTopicsRequest.newBuilder()
                                .setProjectWithProjectName(ProjectName.create(projectId))
                                .build();
                PagedResponseWrappers.ListTopicsPagedResponse response = topicAdminClient.listTopics(listTopicsRequest);
                Iterable<Topic> topics = response.iterateAllElements();
                for (Topic topic : topics) {
                    System.out.println(topic.getName());
                }
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
    private static class TopicRetrievalAction extends TopicAction {
        @Override
        public void run(String topicId) throws Exception {
            try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                Topic topic = topicAdminClient.getTopic(TopicName.create(projectId, topicId));
                System.out.printf("Topic : %s%n", topic);
            }
        }
    }

    /**
     * This class demonstrates how to create a Pub/Sub topic.
     *
     * @see <a href="https://cloud.google.com/pubsub/publisher#create">Create a topic</a>
     */
    private static class CreateTopicAction extends TopicAction {
        @Override
        public void run(String topicId) throws Exception {
            try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                TopicName topicName = TopicName.create(projectId, topicId);
                Topic topic = topicAdminClient.createTopic(topicName);
                System.out.printf("Created topic %s%n", topic.getName());
            }
        }
    }

    /**
     * This class demonstrates how to delete a Pub/Sub topic.
     *
     * @see <a href="https://cloud.google.com/pubsub/publisher#delete">Delete a topic</a>
     */
    private static class DeleteTopicAction extends TopicAction {
        @Override
        public void run(String topicId) throws Exception {
            try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                topicAdminClient.deleteTopic(TopicName.create(projectId, topicId));
                System.out.printf("Deleted topic %s%n", topicId);
            }
        }
    }

    /**
     * This class demonstrates how to list Pub/Sub subscriptions.
     *
     * @see <a href="https://cloud.google.com/pubsub/subscriber#list">List subscriptions</a>
     */
    private static class ListSubscriptionsAction extends PubSubAction<String> {
        @Override
        public void run(String topic) throws Exception {
            if (topic == null) {
                try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                    PagedResponseWrappers.ListSubscriptionsPagedResponse response =
                            subscriptionAdminClient.listSubscriptions(ProjectName.create(projectId));
                    Iterable<Subscription> subscriptions = response.iterateAllElements();
                    for (Subscription subscription : subscriptions) {
                        System.out.println(subscription.getName());
                    }
                }
            } else {
                try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                    PagedResponseWrappers.ListTopicSubscriptionsPagedResponse response =
                            topicAdminClient.listTopicSubscriptions(TopicName.create(projectId, topic));
                    Iterable<String> subscriptionNames = response.iterateAllElements();
                    for (String subscriptionName : subscriptionNames) {
                        System.out.println(subscriptionName);
                    }
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
     * messages to a topic</a>
     */
    private static class PublishMessagesAction extends PubSubAction<Tuple<String, List<PubsubMessage>>> {
        @Override
        public void run(Tuple<String, List<PubsubMessage>> params) throws Exception {
            String topic = params.x();
            TopicName topicName = TopicName.create(projectId, topic);
            Publisher publisher = Publisher.newBuilder(topicName).build();
            List<PubsubMessage> messages = params.y();
            for (PubsubMessage message : messages) {
                ApiFuture<String> messageIdFuture = publisher.publish(message);
                ApiFutures.addCallback(messageIdFuture, new ApiFutureCallback<String>() {
                    public void onSuccess(String messageId) {
                        System.out.println("published with message id: " + messageId);
                    }

                    public void onFailure(Throwable t) {
                        System.out.println("failed to publish: " + t);
                    }
                });
            }
            System.out.printf("Published %d messages to topic %s%n", messages.size(), topic);
        }

        @Override
        Tuple<String, List<PubsubMessage>> parse(String... args) throws Exception {
            if (args.length < 2) {
                throw new IllegalArgumentException("Missing required topic and messages");
            }
            String topic = args[0];
            List<PubsubMessage> messages = new ArrayList<>();
            for (String payload : Arrays.copyOfRange(args, 1, args.length)) {
                ByteString data = ByteString.copyFromUtf8(payload);
                PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();
                messages.add(pubsubMessage);
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
     * This class demonstrates how to retrieve a Pub/Sub subscription.
     */
    private static class SubscriptionInfoAction extends SubscriptionAction {
        @Override
        public void run(String subscriptionId) throws Exception {
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                Subscription subscription = subscriptionAdminClient.getSubscription(
                        SubscriptionName.create(projectId, subscriptionId));
                System.out.printf("Subscription info: %s%n", subscription.getName());
            }
        }
    }

    /**
     * This class demonstrates how to create a Pub/Sub subscription.
     *
     * @see <a href="https://cloud.google.com/pubsub/subscriber#create">Create a subscription</a>
     */
    private static class CreateSubscriptionAction extends
            PubSubAction<Tuple<Tuple<TopicName, SubscriptionName>, PushConfig>> {
        @Override
        public void run(Tuple<Tuple<TopicName, SubscriptionName>, PushConfig> subscriptionParams) throws Exception {
            Tuple<TopicName, SubscriptionName> nameTuple = subscriptionParams.x();
            TopicName topicName = nameTuple.x();
            SubscriptionName subscriptionName = nameTuple.y();
            PushConfig pushConfig = subscriptionParams.y();
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                Subscription subscription = subscriptionAdminClient.createSubscription(
                        subscriptionName, topicName, pushConfig, 60);
                System.out.printf("Created subscription %s%n", subscription.getName());
            }
        }

        @Override
        Tuple<Tuple<TopicName, SubscriptionName>, PushConfig> parse(String... args) throws Exception {
            String message;
            if (args.length > 3) {
                message = "Too many arguments.";
            } else if (args.length < 2) {
                message = "Missing required topic or subscription name";
            } else {
                TopicName topicName = TopicName.create(projectId, args[0]);
                SubscriptionName subscriptionName = SubscriptionName.create(projectId, args[1]);
                PushConfig pushConfig = PushConfig.getDefaultInstance();
                if (args.length == 3) {
                    pushConfig = PushConfig.newBuilder().setPushEndpoint(args[2]).build();
                }
                return new Tuple<>(new Tuple<>(topicName, subscriptionName), pushConfig);
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
        public void run(String subscriptionId) throws Exception {
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                subscriptionAdminClient.deleteSubscription(SubscriptionName.create(projectId, subscriptionId));
                System.out.printf("Deleted subscription %s%n", subscriptionId);
            }
        }
    }

    /**
     * This class demonstrates how to modify the push configuration for a Pub/Sub subscription.
     *
     * @see <a
     * href="https://cloud.google.com/pubsub/subscriber#switching-between-push-and-pull-delivery">
     * Switching between push and pull delivery</a>
     */
    private static class ReplacePushConfigAction extends
            PubSubAction<Tuple<SubscriptionName, PushConfig>> {
        @Override
        public void run(Tuple<SubscriptionName, PushConfig> params) throws Exception {
            SubscriptionName subscriptionName = params.x();
            PushConfig pushConfig = params.y();
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                subscriptionAdminClient.modifyPushConfig(subscriptionName, pushConfig);
            }
            System.out.printf("Set push config %s for subscription %s%n", pushConfig, subscriptionName);
        }

        @Override
        Tuple<SubscriptionName, PushConfig> parse(String... args) throws Exception {
            String message;
            if (args.length > 2) {
                message = "Too many arguments.";
            } else if (args.length < 1) {
                message = "Missing required subscription name";
            } else {
                SubscriptionName subscriptionName = SubscriptionName.create(projectId, args[0]);
                PushConfig pushConfig = null;
                if (args.length == 2) {
                    pushConfig = PushConfig.newBuilder().setPushEndpoint(args[1]).build();
                }
                return Tuple.of(subscriptionName, pushConfig);
            }
            throw new IllegalArgumentException(message);
        }

        @Override
        public String params() {
            return "<subscription> <endpoint>?";
        }
    }

    private abstract static class MessagesAction extends PubSubAction<Tuple<SubscriptionName, List<String>>> {
        @Override
        Tuple<SubscriptionName, List<String>> parse(String... args) throws Exception {
            if (args.length < 2) {
                throw new IllegalArgumentException("Missing required subscription and ack IDs");
            }
            SubscriptionName subscriptionName = SubscriptionName.create(projectId, args[0]);
            return Tuple.of(subscriptionName, Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
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
     * pull messages</a>
     */
    private static class AckMessagesAction extends MessagesAction {
        @Override
        public void run(Tuple<SubscriptionName, List<String>> params) throws Exception {
            SubscriptionName subscriptionName = params.x();
            List<String> ackIds = params.y();
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                subscriptionAdminClient.acknowledge(subscriptionName, ackIds);
            }
            System.out.printf("Acked %d messages for subscription %s%n", ackIds.size(), subscriptionName);
        }
    }

    /**
     * This class demonstrates how to "nack" Pub/Sub messages for a subscription. This action
     * corresponds to setting the acknowledge deadline to 0.
     *
     * @see <a href="https://cloud.google.com/pubsub/subscriber#receiving-pull-messages">Message
     * acknowledgement deadline</a>
     */
    private static class NackMessagesAction extends MessagesAction {
        @Override
        public void run(Tuple<SubscriptionName, List<String>> params) throws Exception {
            SubscriptionName subscriptionName = params.x();
            List<String> ackIds = params.y();
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                subscriptionAdminClient.modifyAckDeadline(subscriptionName, ackIds, 0);
            }
            System.out.printf("Nacked %d messages for subscription %s%n", ackIds.size(), subscriptionName);
        }
    }

    /**
     * This class demonstrates how modify the acknowledge deadline for messages in a Pub/Sub
     * subscription.
     *
     * @see <a href="https://cloud.google.com/pubsub/subscriber#receiving-pull-messages">Message
     * acknowledgement deadline</a>
     */
    private static class ModifyAckDeadlineAction
            extends PubSubAction<Tuple<ModifyAckDeadlineAction.SubscriptionAndDeadline, List<String>>> {

        static class SubscriptionAndDeadline {

            private final SubscriptionName subscription;
            private final int deadlineMillis;

            private SubscriptionAndDeadline(String subscription, int deadlineMillis) {
                this.subscription = SubscriptionName.create(projectId, subscription);
                this.deadlineMillis = deadlineMillis;
            }

            SubscriptionName subscriptionName() {
                return subscription;
            }

            int deadlineMillis() {
                return deadlineMillis;
            }
        }

        @Override
        public void run(Tuple<SubscriptionAndDeadline, List<String>> params)
                throws Exception {
            SubscriptionName subscriptionName = params.x().subscriptionName();
            int deadline = params.x().deadlineMillis();
            List<String> ackIds = params.y();
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                subscriptionAdminClient.modifyAckDeadline(subscriptionName, ackIds, deadline);
            }
            System.out.printf("Ack deadline set to %d seconds for %d messages in subscription %s%n", deadline,
                    ackIds.size(), subscriptionName);
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
     * pull messages</a>
     */
    private static class PullAsyncAction extends PubSubAction<Tuple<SubscriptionName, Long>> {
        @Override
        public void run(Tuple<SubscriptionName, Long> params) throws Exception {
            final AtomicInteger messageCount = new AtomicInteger();
            MessageReceiver receiver =
                    new MessageReceiver() {
                        @Override
                        public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
                            messageCount.incrementAndGet();
                            consumer.accept(AckReply.ACK);
                        }
                    };
            SubscriptionName subscriptionName = params.x();
            Subscriber subscriber = null;
            try {
                subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
                subscriber.addListener(
                        new Subscriber.SubscriberListener() {
                            @Override
                            public void failed(Subscriber.State from, Throwable failure) {
                                // Handle failure.
                                // This is called when the Subscriber encountered a fatal error and is shutting down.
                                System.err.println(failure);
                            }
                        },
                        MoreExecutors.directExecutor());
                subscriber.startAsync().awaitRunning();
                Thread.sleep(params.y());
            } finally {
                if (subscriber != null) {
                    subscriber.stopAsync();
                }
            }
            System.out.printf("Pulled %d messages from subscription %s%n", messageCount.get(), subscriptionName);
        }

        @Override
        Tuple<SubscriptionName, Long> parse(String... args) throws Exception {
            String message;
            if (args.length > 2) {
                message = "Too many arguments.";
            } else if (args.length < 1) {
                message = "Missing required subscription name";
            } else {
                String subscriptionId = args[0];
                long timeout = 60_000;
                if (args.length == 2) {
                    timeout = Long.parseLong(args[1]);
                }
                return Tuple.of(SubscriptionName.create(projectId, subscriptionId), timeout);
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
     * pull messages</a>
     */
    private static class PullSyncAction extends PubSubAction<Tuple<SubscriptionName, Integer>> {
        @Override
        public void run(Tuple<SubscriptionName, Integer> params) throws Exception {
            SubscriptionName subscriptionName = params.x();
            Integer maxMessages = params.y();
            AtomicInteger messageCount = new AtomicInteger();
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                PullResponse response = subscriptionAdminClient.pull(subscriptionName, true, maxMessages);
                for (ReceivedMessage message : response.getReceivedMessagesList()) {
                    // do something with message, then ack or nack
                    System.out.printf("Received message \"%s\"%n", message);
                    subscriptionAdminClient.acknowledge(
                            subscriptionName, Collections.singletonList(message.getAckId()));
                    messageCount.incrementAndGet();
                }
            }
            System.out.printf("Pulled %d messages from subscription %s%n", messageCount, subscriptionName);
        }

        @Override
        Tuple<SubscriptionName, Integer> parse(String... args) throws Exception {
            String message;
            if (args.length == 2) {
                SubscriptionName subscription = SubscriptionName.create(projectId, args[0]);
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

    private abstract static class GetPolicyAction extends PubSubAction<String> {
        @Override
        String parse(String... args) throws Exception {
            String message;
            if (args.length == 1) {
                return args[0];
            } else if (args.length > 1) {
                message = "Too many arguments.";
            } else {
                message = "Missing required resource name";
            }
            throw new IllegalArgumentException(message);
        }

        @Override
        public String params() {
            return "<resourceName>";
        }
    }

    /**
     * This class demonstrates how to get the IAM policy of a topic.
     *
     * @see <a href="https://cloud.google.com/pubsub/docs/access_control">Access Control</a>
     */
    private static class GetTopicPolicyAction extends GetPolicyAction {
        @Override
        public void run(String topicId) throws Exception {
            TopicName topicName = TopicName.create(projectId, topicId);
            try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                Policy policy = topicAdminClient.getIamPolicy(topicName.toString());
                System.out.printf("Policy for topic %s%n", topicId);
                System.out.println(policy);
            }
        }
    }

    /**
     * This class demonstrates how to get the IAM policy of a subscription.
     *
     * @see <a href="https://cloud.google.com/pubsub/docs/access_control">Access Control</a>
     */
    private static class GetSubscriptionPolicyAction extends GetPolicyAction {
        @Override
        public void run(String subscription) throws Exception {
            SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscription);
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                Policy policy = subscriptionAdminClient.getIamPolicy(subscriptionName.toString());
                System.out.printf("Policy for subscription %s%n", subscription);
                System.out.println(policy);
            }
        }
    }

    private abstract static class AddIdentityAction extends PubSubAction<Tuple<String, Tuple<Role, Identity>>> {
        @Override
        Tuple<String, Tuple<Role, Identity>> parse(String... args) throws Exception {
            String message;
            if (args.length == 3) {
                String resourceName = args[0];
                Role role = Role.of(args[1]);
                Identity identity = Identity.valueOf(args[2]);
                return Tuple.of(resourceName, Tuple.of(role, identity));
            } else if (args.length > 2) {
                message = "Too many arguments.";
            } else {
                message = "Missing required resource name, role and identity";
            }
            throw new IllegalArgumentException(message);
        }

        @Override
        public String params() {
            return "<resourceName> <role> <identity>";
        }
    }


    /**
     * This class demonstrates how to add an identity to a certain role in a topic's IAM policy.
     *
     * @see <a href="https://cloud.google.com/pubsub/docs/access_control">Access Control</a>
     */
    private static class AddIdentityTopicAction extends AddIdentityAction {
        @Override
        public void run(Tuple<String, Tuple<Role, Identity>> param) throws Exception {
            TopicName topicName = TopicName.create(projectId, param.x());
            Tuple<Role, Identity> roleAndIdentity = param.y();
            Role role = roleAndIdentity.x();
            Identity identity = roleAndIdentity.y();
            Binding binding =
                    Binding.newBuilder()
                            .setRole(role.toString())
                            .addMembers(identity.toString())
                            .build();
            //Update policy
            try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                Policy policy = topicAdminClient.getIamPolicy(topicName.toString());
                //Update policy
                Policy updatedPolicy = policy.toBuilder().addBindings(binding).build();
                updatedPolicy = topicAdminClient.setIamPolicy(topicName.toString(), updatedPolicy);
                System.out.printf("Added role %s to identity %s for topic %s%n", role, identity, topicName);
                System.out.println(updatedPolicy);
            }
        }
    }

    /**
     * This class demonstrates how to add an identity to a certain role in a subscription's IAM
     * policy.
     *
     * @see <a href="https://cloud.google.com/pubsub/docs/access_control">Access Control</a>
     */
    private static class AddIdentitySubscriptionAction extends AddIdentityAction {
        @Override
        public void run(Tuple<String, Tuple<Role, Identity>> param) throws Exception {
            SubscriptionName subscriptionName = SubscriptionName.create(projectId, param.x());
            // Create a role => identity binding
            Role role = param.y().x();
            Identity identity = param.y().y();
            Binding binding =
                    Binding.newBuilder()
                            .setRole(role.toString())
                            .addMembers(identity.toString())
                            .build();

            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                Policy policy = subscriptionAdminClient.getIamPolicy(subscriptionName.toString());
                //Update policy
                Policy updatedPolicy = policy.toBuilder().addBindings(binding).build();

                updatedPolicy = subscriptionAdminClient.setIamPolicy(subscriptionName.toString(), updatedPolicy);
                System.out.printf("Added role %s to identity %s for subscription %s%n", role, identity,
                        subscriptionName);
                System.out.println(updatedPolicy);
            }
        }
    }

    private abstract static class TestPermissionsAction extends PubSubAction<Tuple<String, List<String>>> {
        @Override
        Tuple<String, List<String>> parse(String... args) throws Exception {
            if (args.length >= 2) {
                String resourceName = args[0];
                return Tuple.of(resourceName, Arrays.asList(Arrays.copyOfRange(args, 1, args.length)));
            }
            throw new IllegalArgumentException("Missing required resource name and permissions");
        }

        @Override
        public String params() {
            return "<resourceName> <permission>+";
        }
    }

    /**
     * This class demonstrates how to test whether the caller has the provided permissions on a topic.
     *
     * @see <a href="https://cloud.google.com/pubsub/docs/access_control">Access Control</a>
     */
    private static class TestTopicPermissionsAction extends TestPermissionsAction {
        @Override
        public void run(Tuple<String, List<String>> param) throws Exception {
            TopicName topicName = TopicName.create(projectId, param.x());
            List<String> permissions = param.y();
            try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
                TestIamPermissionsResponse response =
                        topicAdminClient.testIamPermissions(topicName.toString(), permissions);
                System.out.println("Topic permissions test : ");
                Set<String> actualPermissions = new HashSet<>();
                actualPermissions.addAll(response.getPermissionsList());
                for (String permission : permissions) {
                    System.out.println(permission + " : " + actualPermissions.contains(permission));
                }
            }
        }
    }

    /**
     * This class demonstrates how to test whether the caller has the provided permissions on a
     * subscription.
     *
     * @see <a href="https://cloud.google.com/pubsub/docs/access_control">Access Control</a>
     */
    private static class TestSubscriptionPermissionsAction extends TestPermissionsAction {
        @Override
        public void run(Tuple<String, List<String>> param) throws Exception {
            SubscriptionName subscriptionName = SubscriptionName.create(projectId, param.x());
            List<String> permissions = param.y();
            try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
                TestIamPermissionsResponse response =
                        subscriptionAdminClient.testIamPermissions(subscriptionName.toString(),
                                permissions);
                System.out.println("Subscription permissions test : ");
                Set<String> actualPermissions = new HashSet<>();
                actualPermissions.addAll(response.getPermissionsList());
                for (String permission : permissions) {
                    System.out.println(permission + " : " + actualPermissions.contains(permission));
                }
            }
        }
    }

    static {
        CREATE_ACTIONS.put("topic", new CreateTopicAction());
        CREATE_ACTIONS.put("subscription", new CreateSubscriptionAction());
        INFO_ACTIONS.put("topic", new TopicRetrievalAction());
        INFO_ACTIONS.put("subscription", new SubscriptionInfoAction());
        LIST_ACTIONS.put("topics", new ListTopicsAction());
        LIST_ACTIONS.put("subscriptions", new ListSubscriptionsAction());
        DELETE_ACTIONS.put("topic", new DeleteTopicAction());
        DELETE_ACTIONS.put("subscription", new DeleteSubscriptionAction());
        PULL_ACTIONS.put("async", new PullAsyncAction());
        PULL_ACTIONS.put("sync", new PullSyncAction());
        GET_IAM_ACTIONS.put("topic", new GetTopicPolicyAction());
        GET_IAM_ACTIONS.put("subscription", new GetSubscriptionPolicyAction());
        REPLACE_IAM_ACTIONS.put("topic", new AddIdentityTopicAction());
        REPLACE_IAM_ACTIONS.put("subscription", new AddIdentitySubscriptionAction());
        TEST_IAM_ACTIONS.put("topic", new TestTopicPermissionsAction());
        TEST_IAM_ACTIONS.put("subscription", new TestSubscriptionPermissionsAction());
        ACTIONS.put("create", new ParentAction(CREATE_ACTIONS));
        ACTIONS.put("info", new ParentAction(INFO_ACTIONS));
        ACTIONS.put("list", new ParentAction(LIST_ACTIONS));
        ACTIONS.put("delete", new ParentAction(DELETE_ACTIONS));
        ACTIONS.put("pull", new ParentAction(PULL_ACTIONS));
        ACTIONS.put("get-policy", new ParentAction(GET_IAM_ACTIONS));
        ACTIONS.put("add-identity", new ParentAction(REPLACE_IAM_ACTIONS));
        ACTIONS.put("test-permissions", new ParentAction(TEST_IAM_ACTIONS));
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
        PubSubAction action;
        String actionName;
        if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
            actionName = args[1];
            projectId = args[0];
            action = ACTIONS.get(args[1]);
            args = Arrays.copyOfRange(args, 2, args.length);
        } else {
            actionName = args[0];
            projectId = ServiceOptions.getDefaultProjectId();
            action = ACTIONS.get(args[0]);
            args = Arrays.copyOfRange(args, 1, args.length);
        }
        if (action == null) {
            System.out.println("Unrecognized action.");
            printUsage();
            return;
        }
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
        action.run(arg);
    }
}
