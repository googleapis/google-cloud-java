/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.v3.CreateNotificationChannelRequest;
import com.google.monitoring.v3.DeleteNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelDescriptorRequest;
import com.google.monitoring.v3.GetNotificationChannelRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsRequest;
import com.google.monitoring.v3.ListNotificationChannelDescriptorsResponse;
import com.google.monitoring.v3.ListNotificationChannelsRequest;
import com.google.monitoring.v3.ListNotificationChannelsResponse;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.NotificationChannelDescriptor;
import com.google.monitoring.v3.SendNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.UpdateNotificationChannelRequest;
import com.google.monitoring.v3.VerifyNotificationChannelRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NotificationChannelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NotificationChannelServiceStub implements BackgroundResource {

  public UnaryCallable<
          ListNotificationChannelDescriptorsRequest,
          ListNotificationChannelDescriptorsPagedResponse>
      listNotificationChannelDescriptorsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotificationChannelDescriptorsPagedCallable()");
  }

  public UnaryCallable<
          ListNotificationChannelDescriptorsRequest, ListNotificationChannelDescriptorsResponse>
      listNotificationChannelDescriptorsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotificationChannelDescriptorsCallable()");
  }

  public UnaryCallable<GetNotificationChannelDescriptorRequest, NotificationChannelDescriptor>
      getNotificationChannelDescriptorCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getNotificationChannelDescriptorCallable()");
  }

  public UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsPagedResponse>
      listNotificationChannelsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listNotificationChannelsPagedCallable()");
  }

  public UnaryCallable<ListNotificationChannelsRequest, ListNotificationChannelsResponse>
      listNotificationChannelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listNotificationChannelsCallable()");
  }

  public UnaryCallable<GetNotificationChannelRequest, NotificationChannel>
      getNotificationChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: getNotificationChannelCallable()");
  }

  public UnaryCallable<CreateNotificationChannelRequest, NotificationChannel>
      createNotificationChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: createNotificationChannelCallable()");
  }

  public UnaryCallable<UpdateNotificationChannelRequest, NotificationChannel>
      updateNotificationChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNotificationChannelCallable()");
  }

  public UnaryCallable<DeleteNotificationChannelRequest, Empty>
      deleteNotificationChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteNotificationChannelCallable()");
  }

  public UnaryCallable<SendNotificationChannelVerificationCodeRequest, Empty>
      sendNotificationChannelVerificationCodeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: sendNotificationChannelVerificationCodeCallable()");
  }

  public UnaryCallable<
          GetNotificationChannelVerificationCodeRequest,
          GetNotificationChannelVerificationCodeResponse>
      getNotificationChannelVerificationCodeCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getNotificationChannelVerificationCodeCallable()");
  }

  public UnaryCallable<VerifyNotificationChannelRequest, NotificationChannel>
      verifyNotificationChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: verifyNotificationChannelCallable()");
  }

  @Override
  public abstract void close();
}
