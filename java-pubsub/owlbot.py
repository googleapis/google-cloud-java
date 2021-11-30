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
   * @deprecated Use {@link #createSubscription(ProjectSubscriptionName, TopicName, PushConfig, int)} instead.
   */
  @Deprecated
  public final Subscription createSubscription(
      com.google.pubsub.v1.ProjectSubscriptionName name,
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
"""

PACKAGE = 'package com.google.cloud.pubsub.v1;'

IMPORT_PROJECT_TOPIC_NAME = 'import com.google.pubsub.v1.ProjectTopicName;'

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
        '**/*AdminClient.java',
        PACKAGE,
        PACKAGE + '\n\n' + IMPORT_PROJECT_TOPIC_NAME + '\n'
    )

    s.move(library)

s.remove_staging_dirs()
java.common_templates(
    excludes=[
        ".github/workflows/samples.yaml",
        ".kokoro/build.sh",
        ".github/sync-repo-settings.yaml",
    ]
)
