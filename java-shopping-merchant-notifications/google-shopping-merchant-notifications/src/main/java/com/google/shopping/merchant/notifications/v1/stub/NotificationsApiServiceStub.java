/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.notifications.v1.stub;

import static com.google.shopping.merchant.notifications.v1.NotificationsApiServiceClient.ListNotificationSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.notifications.v1.CreateNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1.DeleteNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1.GetNotificationSubscriptionHealthMetricsRequest;
import com.google.shopping.merchant.notifications.v1.GetNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1.ListNotificationSubscriptionsRequest;
import com.google.shopping.merchant.notifications.v1.ListNotificationSubscriptionsResponse;
import com.google.shopping.merchant.notifications.v1.NotificationSubscription;
import com.google.shopping.merchant.notifications.v1.NotificationSubscriptionHealthMetrics;
import com.google.shopping.merchant.notifications.v1.UpdateNotificationSubscriptionRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NotificationsApiService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NotificationsApiServiceStub implements BackgroundResource {

  public UnaryCallable<GetNotificationSubscriptionRequest, NotificationSubscription>
      getNotificationSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getNotificationSubscriptionCallable()");
  }

  public UnaryCallable<CreateNotificationSubscriptionRequest, NotificationSubscription>
      createNotificationSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createNotificationSubscriptionCallable()");
  }

  public UnaryCallable<UpdateNotificationSubscriptionRequest, NotificationSubscription>
      updateNotificationSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateNotificationSubscriptionCallable()");
  }

  public UnaryCallable<DeleteNotificationSubscriptionRequest, Empty>
      deleteNotificationSubscriptionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteNotificationSubscriptionCallable()");
  }

  public UnaryCallable<
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsPagedResponse>
      listNotificationSubscriptionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotificationSubscriptionsPagedCallable()");
  }

  public UnaryCallable<ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
      listNotificationSubscriptionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotificationSubscriptionsCallable()");
  }

  public UnaryCallable<
          GetNotificationSubscriptionHealthMetricsRequest, NotificationSubscriptionHealthMetrics>
      getNotificationSubscriptionHealthMetricsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getNotificationSubscriptionHealthMetricsCallable()");
  }

  @Override
  public abstract void close();
}
