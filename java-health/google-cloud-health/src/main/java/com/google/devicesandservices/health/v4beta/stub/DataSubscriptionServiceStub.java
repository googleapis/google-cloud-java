/*
 * Copyright 2026 Google LLC
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

package com.google.devicesandservices.health.v4beta.stub;

import static com.google.devicesandservices.health.v4beta.DataSubscriptionServiceClient.ListSubscribersPagedResponse;
import static com.google.devicesandservices.health.v4beta.DataSubscriptionServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4beta.CreateSubscriberMetadata;
import com.google.devicesandservices.health.v4beta.CreateSubscriberRequest;
import com.google.devicesandservices.health.v4beta.CreateSubscriptionRequest;
import com.google.devicesandservices.health.v4beta.DeleteSubscriberMetadata;
import com.google.devicesandservices.health.v4beta.DeleteSubscriberRequest;
import com.google.devicesandservices.health.v4beta.DeleteSubscriptionRequest;
import com.google.devicesandservices.health.v4beta.ListSubscribersRequest;
import com.google.devicesandservices.health.v4beta.ListSubscribersResponse;
import com.google.devicesandservices.health.v4beta.ListSubscriptionsRequest;
import com.google.devicesandservices.health.v4beta.ListSubscriptionsResponse;
import com.google.devicesandservices.health.v4beta.Subscriber;
import com.google.devicesandservices.health.v4beta.Subscription;
import com.google.devicesandservices.health.v4beta.UpdateSubscriberMetadata;
import com.google.devicesandservices.health.v4beta.UpdateSubscriberRequest;
import com.google.devicesandservices.health.v4beta.UpdateSubscriptionRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataSubscriptionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataSubscriptionServiceStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateSubscriberRequest, Subscriber, CreateSubscriberMetadata>
      createSubscriberOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubscriberOperationCallable()");
  }

  public UnaryCallable<CreateSubscriberRequest, Operation> createSubscriberCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubscriberCallable()");
  }

  public UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscribersPagedCallable()");
  }

  public UnaryCallable<ListSubscribersRequest, ListSubscribersResponse> listSubscribersCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscribersCallable()");
  }

  public OperationCallable<UpdateSubscriberRequest, Subscriber, UpdateSubscriberMetadata>
      updateSubscriberOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubscriberOperationCallable()");
  }

  public UnaryCallable<UpdateSubscriberRequest, Operation> updateSubscriberCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubscriberCallable()");
  }

  public OperationCallable<DeleteSubscriberRequest, Empty, DeleteSubscriberMetadata>
      deleteSubscriberOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubscriberOperationCallable()");
  }

  public UnaryCallable<DeleteSubscriberRequest, Operation> deleteSubscriberCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubscriberCallable()");
  }

  public UnaryCallable<CreateSubscriptionRequest, Subscription> createSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSubscriptionCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsPagedCallable()");
  }

  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubscriptionsCallable()");
  }

  public UnaryCallable<UpdateSubscriptionRequest, Subscription> updateSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSubscriptionCallable()");
  }

  public UnaryCallable<DeleteSubscriptionRequest, Empty> deleteSubscriptionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSubscriptionCallable()");
  }

  @Override
  public abstract void close();
}
