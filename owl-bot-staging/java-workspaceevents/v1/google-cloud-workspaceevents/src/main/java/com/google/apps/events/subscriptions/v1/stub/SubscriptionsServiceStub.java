/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.apps.events.subscriptions.v1.stub;

import static com.google.apps.events.subscriptions.v1.SubscriptionsServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.events.subscriptions.v1.CreateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.CreateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.DeleteSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.GetSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsRequest;
import com.google.apps.events.subscriptions.v1.ListSubscriptionsResponse;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.ReactivateSubscriptionRequest;
import com.google.apps.events.subscriptions.v1.Subscription;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionMetadata;
import com.google.apps.events.subscriptions.v1.UpdateSubscriptionRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SubscriptionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SubscriptionsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateSubscriptionRequest, Subscription, CreateSubscriptionMetadata>
      createSubscriptionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSubscriptionOperationCallable()");
  }

  public UnaryCallable<CreateSubscriptionRequest, Operation> createSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubscriptionCallable()");
  }

  public OperationCallable<DeleteSubscriptionRequest, Empty, DeleteSubscriptionMetadata>
      deleteSubscriptionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSubscriptionOperationCallable()");
  }

  public UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubscriptionCallable()");
  }

  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSubscriptionCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsPagedCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsCallable()");
  }

  public OperationCallable<UpdateSubscriptionRequest, Subscription, UpdateSubscriptionMetadata>
      updateSubscriptionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSubscriptionOperationCallable()");
  }

  public UnaryCallable<UpdateSubscriptionRequest, Operation> updateSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubscriptionCallable()");
  }

  public OperationCallable<
          ReactivateSubscriptionRequest, Subscription, ReactivateSubscriptionMetadata>
      reactivateSubscriptionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: reactivateSubscriptionOperationCallable()");
  }

  public UnaryCallable<ReactivateSubscriptionRequest, Operation> reactivateSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: reactivateSubscriptionCallable()");
  }

  @Override
  public abstract void close();
}
