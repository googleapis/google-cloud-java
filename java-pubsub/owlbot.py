# Copyright 2021 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import synthtool as s
from synthtool.languages import java


service = 'pubsub'
version = 'v1'

GET_IAM_POLICY_TOPIC = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy response = topicAdminClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #getIamPolicy(GetIamPolicyRequest)} instead.
   */
  @Deprecated
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();   
    return getIamPolicy(request);
  }
"""
GET_IAM_POLICY_SUBSCRIPTION = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy response = subscriptionAdminClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #getIamPolicy(GetIamPolicyRequest)} instead.
   */
  @Deprecated
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();   
    return getIamPolicy(request);
  }
"""

GET_IAM_POLICY_PREVIOUS = r'(\s+public final Policy getIamPolicy\(GetIamPolicyRequest request\) {\n\s+return .*\n\s+})'

SET_IAM_POLICY_TOPIC = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = topicAdminClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #setIamPolicy(SetIamPolicyRequest)} instead.
   */
  @Deprecated
  public final Policy setIamPolicy(String resource, Policy policy) {    
    SetIamPolicyRequest request =   
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();   
    return setIamPolicy(request);   
  }
"""
SET_IAM_POLICY_SUBSCRIPTION = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = subscriptionAdminClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #setIamPolicy(SetIamPolicyRequest)} instead.
   */
  @Deprecated
  public final Policy setIamPolicy(String resource, Policy policy) {    
    SetIamPolicyRequest request =   
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();   
    return setIamPolicy(request);   
  }
"""
SET_IAM_POLICY_PREVIOUS = r'(\s+public final Policy setIamPolicy\(SetIamPolicyRequest request\) {\n\s+return .*\n\s+})'

TEST_IAM_PERMISSIONS_TOPIC = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = topicAdminClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #testIamPermissions(TestIamPermissionsRequest)} instead.
   */
  @Deprecated
  public final TestIamPermissionsResponse testIamPermissions(   
      String resource, List<String> permissions) {  
    TestIamPermissionsRequest request = 
        TestIamPermissionsRequest.newBuilder()  
            .setResource(resource)  
            .addAllPermissions(permissions) 
            .build();   
    return testIamPermissions(request); 
  }
"""
TEST_IAM_PERMISSIONS_SUBSCRIPTION = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String formattedResource = ProjectTopicName.format("[PROJECT]", "[TOPIC]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = subscriptionAdminClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #testIamPermissions(TestIamPermissionsRequest)} instead.
   */
  @Deprecated
  public final TestIamPermissionsResponse testIamPermissions(   
      String resource, List<String> permissions) {  
    TestIamPermissionsRequest request = 
        TestIamPermissionsRequest.newBuilder()  
            .setResource(resource)  
            .addAllPermissions(permissions) 
            .build();   
    return testIamPermissions(request); 
  }
"""
TEST_IAM_PERMISSIONS_PREVIOUS = r'(\s+public final TestIamPermissionsResponse testIamPermissions\(TestIamPermissionsRequest request\) {\n\s+return .*\n\s+})'

CREATE_TOPIC = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates the given topic with the given name. See the &lt;a
   * href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   * rules&lt;/a&gt;.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName name = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.createTopic(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the topic. It must have the format
   *     `"projects/{project}/topics/{topic}"`. `{topic}` must start with a letter, and contain only
   *     letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores (`_`), periods (`.`),
   *     tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3 and 255 characters in
   *     length, and it must not start with `"goog"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #createTopic(TopicName)} instead.
   */
  @Deprecated
  public final Topic createTopic(ProjectTopicName name) {
    Topic request = Topic.newBuilder().setName(name == null ? null : name.toString()).build();
    return createTopic(request);
  }
"""

CREATE_TOPIC_PREVIOUS = r'(\s+public final Topic createTopic\(String name\) {\n\s+.*\n\s+return.*\n\s+})'

DELETE_TOPIC = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a
   * topic is deleted, a new topic may be created with the same name; this is an entirely new topic
   * with none of the old configuration or subscriptions. Existing subscriptions to this topic are
   * not deleted, but their `topic` field is set to `_deleted-topic_`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   topicAdminClient.deleteTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic Required. Name of the topic to delete. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #deleteTopic(TopicName)} instead.
   */
  @Deprecated
  public final void deleteTopic(ProjectTopicName topic) {
    DeleteTopicRequest request =
        DeleteTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
    deleteTopic(request);
  }
"""

GET_TOPIC_PREVIOUS = r'(\s+public final Topic getTopic\(String topic\) {\n\s+.*\n\s+return.*\n\s+})'

GET_TOPIC = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the configuration of a topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   Topic response = topicAdminClient.getTopic(topic);
   * }
   * </code></pre>
   *
   * @param topic Required. The name of the topic to get. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #getTopic(TopicName)} instead.
   */
  @Deprecated
  public final Topic getTopic(ProjectTopicName topic) {
    GetTopicRequest request =
        GetTopicRequest.newBuilder().setTopic(topic == null ? null : topic.toString()).build();
    return getTopic(request);
  }
"""

DELETE_TOPIC_PREVIOUS = r'(\s+public final void deleteTopic\(String topic\) {\n\s+.*\n\s+deleteTopic.*\n\s+})'

LIST_TOPIC_SUBSCRIPTIONS = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the names of the subscriptions on this topic.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   for (ProjectSubscriptionName element : topicAdminClient.listTopicSubscriptions(topic).iterateAllAsProjectSubscriptionName()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param topic Required. The name of the topic that subscriptions are attached to. Format is
   *     `projects/{project}/topics/{topic}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #listTopicSubscriptions(TopicName)} instead.
   */
  @Deprecated
  public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions(ProjectTopicName topic) {
    ListTopicSubscriptionsRequest request =
        ListTopicSubscriptionsRequest.newBuilder()
            .setTopic(topic == null ? null : topic.toString())
            .build();
    return listTopicSubscriptions(request);
  }
"""

LIST_TOPIC_SUBSCRIPTIONS_PREVIOUS = r'(\s+public final ListTopicSubscriptionsPagedResponse listTopicSubscriptions\(String topic\) {\n\s+.*\n\s+.*\n\s+return.*\n\s+})'

CREATE_SUBSCRIPTION_PREVIOUS = r'(\s+public final Subscription createSubscription\(Subscription request\) {\n\s+return.*\n\s+})'

CREATE_SUBSCRIPTION = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a subscription to a given topic. See the &lt;a
   * href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   * rules&lt;/a&gt;. If the subscription already exists, returns `ALREADY_EXISTS`. If the
   * corresponding topic doesn't exist, returns `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name
   * format](https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is
   * populated in the returned Subscription object. Note that for REST API requests, you must
   * specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName name = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   ProjectTopicName topic = ProjectTopicName.of("[PROJECT]", "[TOPIC]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 0;
   *   Subscription response = subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is used to
   *     configure it. An empty `pushConfig` signifies that the subscriber will pull and ack
   *     messages using API methods.
   * @param ackDeadlineSeconds The approximate amount of time (on a best-effort basis) Pub/Sub waits
   *     for the subscriber to acknowledge receipt before resending the message. In the interval
   *     after the message is delivered and before it is acknowledged, it is considered to be
   *     &lt;i&gt;outstanding&lt;/i&gt;. During that time period, the message will not be
   *     redelivered (on a best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #createSubscription(SubscriptionName, TopicName, PushConfig, int)} instead.
   */
  @Deprecated
  public final Subscription createSubscription(
      ProjectSubscriptionName name,
      ProjectTopicName topic,
      PushConfig pushConfig,
      int ackDeadlineSeconds) {
    Subscription request =
    Subscription.newBuilder()
        .setName(name == null ? null : name.toString())
        .setTopic(topic == null ? null : topic.toString())
        .setPushConfig(pushConfig)
        .setAckDeadlineSeconds(ackDeadlineSeconds)
        .build();
    return createSubscription(request);
  }
  
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). If the subscription already
   * exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is populated in
   * the returned Subscription object. Note that for REST API requests, you must specify a name in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName name = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   String topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]").toString();
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is used to
   *     configure it. An empty `pushConfig` signifies that the subscriber will pull and ack
   *     messages using API methods.
   * @param ackDeadlineSeconds The approximate amount of time (on a best-effort basis) Pub/Sub waits
   *     for the subscriber to acknowledge receipt before resending the message. In the interval
   *     after the message is delivered and before it is acknowledged, it is considered to be
   *     &lt;i&gt;outstanding&lt;/i&gt;. During that time period, the message will not be
   *     redelivered (on a best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @deprecated Use {@link #createSubscription(SubscriptionName, String, PushConfig, int)} instead.
   */
  @Deprecated
  public final Subscription createSubscription(
      ProjectSubscriptionName name, String topic, PushConfig pushConfig, int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTopic(topic)
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }
  
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a subscription to a given topic. See the [resource name rules]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). If the subscription already
   * exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns
   * `NOT_FOUND`.
   *
   * <p>If the name is not provided in the request, the server will assign a random name for this
   * subscription on the same project as the topic, conforming to the [resource name format]
   * (https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is populated in
   * the returned Subscription object. Note that for REST API requests, you must specify a name in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName name = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   TopicName topic = TopicName.ofProjectTopicName("[PROJECT]", "[TOPIC]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   int ackDeadlineSeconds = 2135351438;
   *   Subscription response =
   *       subscriptionAdminClient.createSubscription(name, topic, pushConfig, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param name Required. The name of the subscription. It must have the format
   *     `"projects/{project}/subscriptions/{subscription}"`. `{subscription}` must start with a
   *     letter, and contain only letters (`[A-Za-z]`), numbers (`[0-9]`), dashes (`-`), underscores
   *     (`_`), periods (`.`), tildes (`~`), plus (`+`) or percent signs (`%`). It must be between 3
   *     and 255 characters in length, and it must not start with `"goog"`.
   * @param topic Required. The name of the topic from which this subscription is receiving
   *     messages. Format is `projects/{project}/topics/{topic}`. The value of this field will be
   *     `_deleted-topic_` if the topic has been deleted.
   * @param pushConfig If push delivery is used with this subscription, this field is used to
   *     configure it. An empty `pushConfig` signifies that the subscriber will pull and ack
   *     messages using API methods.
   * @param ackDeadlineSeconds The approximate amount of time (on a best-effort basis) Pub/Sub waits
   *     for the subscriber to acknowledge receipt before resending the message. In the interval
   *     after the message is delivered and before it is acknowledged, it is considered to be
   *     &lt;i&gt;outstanding&lt;/i&gt;. During that time period, the message will not be
   *     redelivered (on a best-effort basis).
   *     <p>For pull subscriptions, this value is used as the initial value for the ack deadline. To
   *     override this value for a given message, call `ModifyAckDeadline` with the corresponding
   *     `ack_id` if using non-streaming pull or send the `ack_id` in a
   *     `StreamingModifyAckDeadlineRequest` if using streaming pull. The minimum custom deadline
   *     you can specify is 10 seconds. The maximum custom deadline you can specify is 600 seconds
   *     (10 minutes). If this parameter is 0, a default value of 10 seconds is used.
   *     <p>For push delivery, this value is also used to set the request timeout for the call to
   *     the push endpoint.
   *     <p>If the subscriber never acknowledges the message, the Pub/Sub system will eventually
   *     redeliver the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #createSubscription(SubscriptionName, TopicName, PushConfig, int)} instead.
   */
  @Deprecated
  public final Subscription createSubscription(
      ProjectSubscriptionName name,
      TopicName topic,
      PushConfig pushConfig,
      int ackDeadlineSeconds) {
    Subscription request =
        Subscription.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTopic(topic == null ? null : topic.toString())
            .setPushConfig(pushConfig)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    return createSubscription(request);
  }
"""

GET_SUBSCRIPTION_PREVIOUS = r'(\s+public final Subscription getSubscription\(GetSubscriptionRequest request\) {\n\s+return.*\n\s+})'

GET_SUBSCRIPTION = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Subscription response = subscriptionAdminClient.getSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription to get. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #getSubscription(SubscriptionName)} instead. 
   */
  @Deprecated
  public final Subscription getSubscription(ProjectSubscriptionName subscription) {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return getSubscription(request);
  }
"""

DELETE_SUBSCRIPTION_PREVIOUS = r'(\s+public final void deleteSubscription\(DeleteSubscriptionRequest request\) {\n\s+deleteSubscription.*\n\s+})'

DELETE_SUBSCRIPTION = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing subscription. All messages retained in the subscription are immediately
   * dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is
   * deleted, a new one may be created with the same name, but the new one has no association with
   * the old subscription or its topic unless the same topic is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   subscriptionAdminClient.deleteSubscription(subscription);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription to delete. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #deleteSubscription(SubscriptionName)} instead.
   */
  @Deprecated
  public final void deleteSubscription(ProjectSubscriptionName subscription) {
    DeleteSubscriptionRequest request =
        DeleteSubscriptionRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    deleteSubscription(request);
  }
"""

MODIFY_ACK_DEADLINE_PREVIOUS = r'(\s+public final void modifyAckDeadline\(ModifyAckDeadlineRequest request\) {\n\s+modifyAckDeadline.*\n\s+})'

MODIFY_ACK_DEADLINE = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the ack deadline for a specific message. This method is useful to indicate that more
   * time is needed to process a message by the subscriber, or to make the message available for
   * redelivery if the processing was interrupted. Note that this does not modify the
   * subscription-level `ackDeadlineSeconds` used for subsequent messages.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   List<String> ackIds = new ArrayList<>();
   *   int ackDeadlineSeconds = 2135351438;
   *   subscriptionAdminClient.modifyAckDeadline(subscription, ackIds, ackDeadlineSeconds);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. List of acknowledgment IDs.
   * @param ackDeadlineSeconds Required. The new ack deadline with respect to the time this request
   *     was sent to the Pub/Sub system. For example, if the value is 10, the new ack deadline will
   *     expire 10 seconds after the `ModifyAckDeadline` call was made. Specifying zero might
   *     immediately make the message available for delivery to another subscriber client. This
   *     typically results in an increase in the rate of message redeliveries (that is, duplicates).
   *     The minimum deadline you can specify is 0 seconds. The maximum deadline you can specify is
   *     600 seconds (10 minutes).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #modifyAckDeadline(SubscriptionName, List<String>, int)} instead.
   */
  @Deprecated
  final void modifyAckDeadline(
      ProjectSubscriptionName subscription, List<String> ackIds, int ackDeadlineSeconds) {
    ModifyAckDeadlineRequest request =
        ModifyAckDeadlineRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .addAllAckIds(ackIds)
            .setAckDeadlineSeconds(ackDeadlineSeconds)
            .build();
    modifyAckDeadline(request);
  }
"""

ACKNOWLEDGE_PREVIOUS = r'(\s+public final void acknowledge\(AcknowledgeRequest request\) {\n\s+acknowledge.*\n\s+})'

ACKNOWLEDGE = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The
   * Pub/Sub system can remove the relevant messages from the subscription.
   *
   * <p>Acknowledging a message whose ack deadline has expired may succeed, but such a message may
   * be redelivered later. Acknowledging a message more than once will not result in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   List<String> ackIds = new ArrayList<>();
   *   subscriptionAdminClient.acknowledge(subscription, ackIds);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription whose message is being acknowledged. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param ackIds Required. The acknowledgment ID for the messages being acknowledged that was
   *     returned by the Pub/Sub system in the `Pull` response. Must not be empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #acknowledge(SubscriptionName, List<String>)} instead.
   */
  @Deprecated
  public final void acknowledge(ProjectSubscriptionName subscription, List<String> ackIds) {
    AcknowledgeRequest request =
        AcknowledgeRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .addAllAckIds(ackIds)
            .build();
    acknowledge(request);
  }
"""

PULL_PREVIOUS = r'(\s+public final PullResponse pull\(PullRequest request\) {\n\s+return.*\n\s+})'

PULL = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server. The server may return `UNAVAILABLE` if there are too many
   * concurrent pull requests pending for the given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   int maxMessages = 496131527;
   *   PullResponse response = subscriptionAdminClient.pull(subscription, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #pull(SubscriptionName, int)} instead.
   */
  @Deprecated
  public final PullResponse pull(ProjectSubscriptionName subscription, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }
  
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pulls messages from the server. The server may return `UNAVAILABLE` if there are too many
   * concurrent pull requests pending for the given subscription.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   boolean returnImmediately = true;
   *   int maxMessages = 496131527;
   *   PullResponse response =
   *       subscriptionAdminClient.pull(subscription, returnImmediately, maxMessages);
   * }
   * }</pre>
   *
   * @param subscription Required. The subscription from which messages should be pulled. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param returnImmediately Optional. If this field set to true, the system will respond
   *     immediately even if it there are no messages available to return in the `Pull` response.
   *     Otherwise, the system may wait (for a bounded amount of time) until at least one message is
   *     available, rather than returning no messages. Warning: setting this field to `true` is
   *     discouraged because it adversely impacts the performance of `Pull` operations. We recommend
   *     that users do not set this field.
   * @param maxMessages Required. The maximum number of messages to return for this request. Must be
   *     a positive integer. The Pub/Sub system may return fewer than the number specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #pull(SubscriptionName, boolean, int)} instead.
   */
  @Deprecated
  final PullResponse pull(
      ProjectSubscriptionName subscription, boolean returnImmediately, int maxMessages) {
    PullRequest request =
        PullRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setReturnImmediately(returnImmediately)
            .setMaxMessages(maxMessages)
            .build();
    return pull(request);
  }
"""

MODIFY_PUSH_CONFIG_PREVIOUS = r'(\s+public final void modifyPushConfig\(ModifyPushConfigRequest request\) {\n\s+modifyPushConfig.*\n\s+})'

MODIFY_PUSH_CONFIG = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies the `PushConfig` for a specified subscription.
   *
   * <p>This may be used to change a push subscription to a pull one (signified by an empty
   * `PushConfig`) or vice versa, or change the endpoint URL and other attributes of a push
   * subscription. Messages will accumulate for delivery continuously through the call regardless of
   * changes to the `PushConfig`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   PushConfig pushConfig = PushConfig.newBuilder().build();
   *   subscriptionAdminClient.modifyPushConfig(subscription, pushConfig);
   * }
   * }</pre>
   *
   * @param subscription Required. The name of the subscription. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @param pushConfig Required. The push configuration for future deliveries.
   *     <p>An empty `pushConfig` indicates that the Pub/Sub system should stop pushing messages
   *     from the given subscription and allow messages to be pulled and acknowledged - effectively
   *     pausing the subscription if `Pull` or `StreamingPull` is not called.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use {@link #modifyPushConfig(SubscriptionName, PushConfig)} instead.
   */
  @Deprecated
  public final void modifyPushConfig(ProjectSubscriptionName subscription, PushConfig pushConfig) {
    ModifyPushConfigRequest request =
        ModifyPushConfigRequest.newBuilder()
            .setSubscription(subscription == null ? null : subscription.toString())
            .setPushConfig(pushConfig)
            .build();
    modifyPushConfig(request);
  }
"""

CREATE_SNAPSHOT_PREVIOUS = r'(\s+public final Snapshot createSnapshot\(CreateSnapshotRequest request\) {\n\s+return.*\n\s+})'

CREATE_SNAPSHOT = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The
   * generated name is populated in the returned Snapshot object. Note that for REST API requests,
   * you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName name = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the &lt;a
   *     href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   *     rules&lt;/a&gt;. Format is `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #createSnapshot(SnapshotName, SubscriptionName)} instead.
   */
  @Deprecated
  public final Snapshot createSnapshot(
      ProjectSnapshotName name, ProjectSubscriptionName subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return createSnapshot(request);
  }
  
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The
   * generated name is populated in the returned Snapshot object. Note that for REST API requests,
   * you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   String name = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]").toString();
   *   ProjectSubscriptionName subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]");
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the &lt;a
   *     href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   *     rules&lt;/a&gt;. Format is `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #createSnapshot(String, SubscriptionName)} instead.
   */
  @Deprecated
  public final Snapshot createSnapshot(String name, ProjectSubscriptionName subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name)
            .setSubscription(subscription == null ? null : subscription.toString())
            .build();
    return createSnapshot(request);
  }
  
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a snapshot from the requested subscription. Snapshots are used in
   * [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to
   * manage message acknowledgments in bulk. That is, you can set the acknowledgment state of
   * messages in an existing subscription to the state captured by a snapshot. If the snapshot
   * already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns
   * `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would
   * expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the
   * `Snapshot.expire_time` field. If the name is not provided in the request, the server will
   * assign a random name for this snapshot on the same project as the subscription, conforming to
   * the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The
   * generated name is populated in the returned Snapshot object. Note that for REST API requests,
   * you must specify a name in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName name = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   String subscription = ProjectSubscriptionName.of("[PROJECT]", "[SUBSCRIPTION]").toString();
   *   Snapshot response = subscriptionAdminClient.createSnapshot(name, subscription);
   * }
   * }</pre>
   *
   * @param name Required. User-provided name for this snapshot. If the name is not provided in the
   *     request, the server will assign a random name for this snapshot on the same project as the
   *     subscription. Note that for REST API requests, you must specify a name. See the &lt;a
   *     href="https://cloud.google.com/pubsub/docs/admin#resource_names"&gt; resource name
   *     rules&lt;/a&gt;. Format is `projects/{project}/snapshots/{snap}`.
   * @param subscription Required. The subscription whose backlog the snapshot retains.
   *     Specifically, the created snapshot is guaranteed to retain: (a) The existing backlog on the
   *     subscription. More precisely, this is defined as the messages in the subscription's backlog
   *     that are unacknowledged upon the successful completion of the `CreateSnapshot` request; as
   *     well as: (b) Any messages published to the subscription's topic following the successful
   *     completion of the CreateSnapshot request. Format is
   *     `projects/{project}/subscriptions/{sub}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #createSnapshot(SnapshotName, String)} instead.
   */
  @Deprecated
  public final Snapshot createSnapshot(ProjectSnapshotName name, String subscription) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSubscription(subscription)
            .build();
    return createSnapshot(request);
  }
"""

DELETE_SNAPSHOT_PREVIOUS = r'(\s+public final void deleteSnapshot\(DeleteSnapshotRequest request\) {\n\s+deleteSnapshot.*\n\s+})'

DELETE_SNAPSHOT = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an existing snapshot. Snapshots are used in [Seek]
   * (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage
   * message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in
   * an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all
   * messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new
   * one may be created with the same name, but the new one has no association with the old snapshot
   * or its subscription, unless the same subscription is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName snapshot = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   subscriptionAdminClient.deleteSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to delete. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #deleteSnapshot(SnapshotName)} instead.
   */
  @Deprecated
  public final void deleteSnapshot(ProjectSnapshotName snapshot) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder()
            .setSnapshot(snapshot == null ? null : snapshot.toString())
            .build();
    deleteSnapshot(request);
  }
"""

GET_SNAPSHOT_PREVIOUS = r'(\s+public final Snapshot getSnapshot\(GetSnapshotRequest request\) {\n\s+return.*\n\s+})'

GET_SNAPSHOT = """
  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the configuration details of a snapshot. Snapshots are used in &lt;a
   * href="https://cloud.google.com/pubsub/docs/replay-overview"&gt;Seek&lt;/a&gt; operations, which
   * allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment
   * state of messages in an existing subscription to the state captured by a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
   *   ProjectSnapshotName snapshot = ProjectSnapshotName.of("[PROJECT]", "[SNAPSHOT]");
   *   Snapshot response = subscriptionAdminClient.getSnapshot(snapshot);
   * }
   * }</pre>
   *
   * @param snapshot Required. The name of the snapshot to get. Format is
   *     `projects/{project}/snapshots/{snap}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated Use Use {@link #getSnapshot(SnapshotName)} instead.
   */
  @Deprecated
  public final Snapshot getSnapshot(ProjectSnapshotName snapshot) {
    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder()
            .setSnapshot(snapshot == null ? null : snapshot.toString())
            .build();
    return getSnapshot(request);
  }  
"""

PACKAGE = 'package com.google.cloud.pubsub.v1;'

IMPORT_PROJECT_TOPIC_NAME = 'import com.google.pubsub.v1.ProjectTopicName;'
IMPORT_PROJECT_SUBSCRIPTION_NAME = 'import com.google.pubsub.v1.ProjectSubscriptionName;'
IMPORT_PROJECT_SNAPSHOT_NAME = 'import com.google.pubsub.v1.ProjectSnapshotName;'

for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.replace(
        '**/stub/SubscriberStubSettings.java',
        r'setMaxInboundMessageSize\(Integer.MAX_VALUE\)',
        'setMaxInboundMessageSize(20 << 20)'
    )
    s.replace(
        f"proto-google-cloud-{service}-{version}/src/**/*.java",
        java.BAD_LICENSE,
        java.GOOD_LICENSE,
    )

    s.replace(
        '**/TopicAdminClient.java',
        GET_IAM_POLICY_PREVIOUS,
        "\g<1>\n\n" + GET_IAM_POLICY_TOPIC
    )

    s.replace(
        '**/TopicAdminClient.java',
        SET_IAM_POLICY_PREVIOUS,
        "\g<1>\n\n" + SET_IAM_POLICY_TOPIC
    )

    s.replace(
        '**/TopicAdminClient.java',
        TEST_IAM_PERMISSIONS_PREVIOUS,
        "\g<1>\n\n" + TEST_IAM_PERMISSIONS_TOPIC
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        GET_IAM_POLICY_PREVIOUS,
        "\g<1>\n\n" + GET_IAM_POLICY_SUBSCRIPTION
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        SET_IAM_POLICY_PREVIOUS,
        "\g<1>\n\n" + SET_IAM_POLICY_SUBSCRIPTION
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        TEST_IAM_PERMISSIONS_PREVIOUS,
        "\g<1>\n\n" + TEST_IAM_PERMISSIONS_SUBSCRIPTION
    )

    s.replace(
        '**/TopicAdminClient.java',
        CREATE_TOPIC_PREVIOUS,
        "\g<1>\n\n" + CREATE_TOPIC
    )

    s.replace(
        '**/TopicAdminClient.java',
        DELETE_TOPIC_PREVIOUS,
        "\g<1>\n\n" + DELETE_TOPIC
    )

    s.replace(
        '**/TopicAdminClient.java',
        LIST_TOPIC_SUBSCRIPTIONS_PREVIOUS,
        "\g<1>\n\n" + LIST_TOPIC_SUBSCRIPTIONS
    )

    s.replace(
        '**/TopicAdminClient.java',
        GET_TOPIC_PREVIOUS,
        "\g<1>\n\n" + GET_TOPIC
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        CREATE_SUBSCRIPTION_PREVIOUS,
        "\g<1>\n\n" + CREATE_SUBSCRIPTION
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        DELETE_SUBSCRIPTION_PREVIOUS,
        "\g<1>\n\n" + DELETE_SUBSCRIPTION
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        GET_SUBSCRIPTION_PREVIOUS,
        "\g<1>\n\n" + GET_SUBSCRIPTION
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        MODIFY_ACK_DEADLINE_PREVIOUS,
        "\g<1>\n\n" + MODIFY_ACK_DEADLINE
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        ACKNOWLEDGE_PREVIOUS,
        "\g<1>\n\n" + ACKNOWLEDGE
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        PULL_PREVIOUS,
        "\g<1>\n\n" + PULL
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        MODIFY_PUSH_CONFIG_PREVIOUS,
        "\g<1>\n\n" + MODIFY_PUSH_CONFIG
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        CREATE_SNAPSHOT_PREVIOUS,
        "\g<1>\n\n" + CREATE_SNAPSHOT
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        GET_SNAPSHOT_PREVIOUS,
        "\g<1>\n\n" + GET_SNAPSHOT
    )

    s.replace(
        '**/SubscriptionAdminClient.java',
        DELETE_SNAPSHOT_PREVIOUS,
        "\g<1>\n\n" + DELETE_SNAPSHOT
    )

    s.replace(
        '**/*AdminClient.java',
        PACKAGE,
        PACKAGE + '\n\n' + IMPORT_PROJECT_TOPIC_NAME + '\n' + IMPORT_PROJECT_SUBSCRIPTION_NAME + '\n' + IMPORT_PROJECT_SNAPSHOT_NAME + '\n'
    )

    s.move(library)

s.remove_staging_dirs()
java.common_templates(
    excludes=[
        ".github/workflows/samples.yaml",
        ".kokoro/build.sh",
        ".github/sync-repo-settings.yaml",
        ".github/blunderbuss.yml",
        '.kokoro/requirements.in',
        '.kokoro/requirements.txt'
    ]
)
