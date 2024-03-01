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

package com.google.cloud.advisorynotifications.v1.stub;

import static com.google.cloud.advisorynotifications.v1.AdvisoryNotificationsServiceClient.ListNotificationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.advisorynotifications.v1.GetNotificationRequest;
import com.google.cloud.advisorynotifications.v1.GetSettingsRequest;
import com.google.cloud.advisorynotifications.v1.ListNotificationsRequest;
import com.google.cloud.advisorynotifications.v1.ListNotificationsResponse;
import com.google.cloud.advisorynotifications.v1.Notification;
import com.google.cloud.advisorynotifications.v1.Settings;
import com.google.cloud.advisorynotifications.v1.UpdateSettingsRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AdvisoryNotificationsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AdvisoryNotificationsServiceStub implements BackgroundResource {

  public UnaryCallable<ListNotificationsRequest, ListNotificationsPagedResponse>
      listNotificationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotificationsPagedCallable()");
  }

  public UnaryCallable<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotificationsCallable()");
  }

  public UnaryCallable<GetNotificationRequest, Notification> getNotificationCallable() {
    throw new UnsupportedOperationException("Not implemented: getNotificationCallable()");
  }

  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingsCallable()");
  }

  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsCallable()");
  }

  @Override
  public abstract void close();
}
