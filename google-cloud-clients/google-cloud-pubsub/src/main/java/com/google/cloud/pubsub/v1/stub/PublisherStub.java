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
import com.google.api.gax.rpc.UnaryCallable;
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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Cloud Pub/Sub API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class PublisherStub implements BackgroundResource {

  public UnaryCallable<Topic, Topic> createTopicCallable() {
    throw new UnsupportedOperationException("Not implemented: createTopicCallable()");
  }

  public UnaryCallable<UpdateTopicRequest, Topic> updateTopicCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTopicCallable()");
  }

  public UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    throw new UnsupportedOperationException("Not implemented: publishCallable()");
  }

  public UnaryCallable<GetTopicRequest, Topic> getTopicCallable() {
    throw new UnsupportedOperationException("Not implemented: getTopicCallable()");
  }

  public UnaryCallable<ListTopicsRequest, ListTopicsPagedResponse> listTopicsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTopicsPagedCallable()");
  }

  public UnaryCallable<ListTopicsRequest, ListTopicsResponse> listTopicsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTopicsCallable()");
  }

  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTopicSubscriptionsPagedCallable()");
  }

  public UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
      listTopicSubscriptionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTopicSubscriptionsCallable()");
  }

  public UnaryCallable<DeleteTopicRequest, Empty> deleteTopicCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTopicCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
