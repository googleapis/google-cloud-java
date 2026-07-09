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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.SupportEventSubscriptionServiceClient.ListSupportEventSubscriptionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest;
import com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse;
import com.google.cloud.support.v2beta.SupportEventSubscription;
import com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SupportEventSubscriptionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SupportEventSubscriptionServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSupportEventSubscriptionCallable()");
  }

  public UnaryCallable<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getSupportEventSubscriptionCallable()");
  }

  public UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSupportEventSubscriptionsPagedCallable()");
  }

  public UnaryCallable<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSupportEventSubscriptionsCallable()");
  }

  public UnaryCallable<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSupportEventSubscriptionCallable()");
  }

  public UnaryCallable<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSupportEventSubscriptionCallable()");
  }

  public UnaryCallable<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteSupportEventSubscriptionCallable()");
  }

  @Override
  public abstract void close();
}
