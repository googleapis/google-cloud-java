/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.SubscriptionAdminClient.ListSubscriptionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.CreateSnapshotRequest;
import com.google.pubsub.v1.DeleteSnapshotRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSnapshotsRequest;
import com.google.pubsub.v1.ListSnapshotsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SeekRequest;
import com.google.pubsub.v1.SeekResponse;
import com.google.pubsub.v1.Snapshot;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.UpdateSnapshotRequest;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Cloud Pub/Sub API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class SubscriberStub implements BackgroundResource {

  public UnaryCallable<Subscription, Subscription> createSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubscriptionCallable()");
  }

  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSubscriptionCallable()");
  }

  public UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubscriptionCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsPagedCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsCallable()");
  }

  public UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubscriptionCallable()");
  }

  public UnaryCallable<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineCallable() {
    throw new UnsupportedOperationException("Not implemented: modifyAckDeadlineCallable()");
  }

  public UnaryCallable<AcknowledgeRequest, Empty> acknowledgeCallable() {
    throw new UnsupportedOperationException("Not implemented: acknowledgeCallable()");
  }

  public UnaryCallable<PullRequest, PullResponse> pullCallable() {
    throw new UnsupportedOperationException("Not implemented: pullCallable()");
  }

  public BidiStreamingCallable<StreamingPullRequest, StreamingPullResponse>
      streamingPullCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingPullCallable()");
  }

  public UnaryCallable<ModifyPushConfigRequest, Empty> modifyPushConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: modifyPushConfigCallable()");
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsPagedCallable()");
  }

  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnapshotsCallable()");
  }

  public UnaryCallable<CreateSnapshotRequest, Snapshot> createSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnapshotCallable()");
  }

  public UnaryCallable<UpdateSnapshotRequest, Snapshot> updateSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSnapshotCallable()");
  }

  public UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSnapshotCallable()");
  }

  public UnaryCallable<SeekRequest, SeekResponse> seekCallable() {
    throw new UnsupportedOperationException("Not implemented: seekCallable()");
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
}
