/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.monitoring.v3.samples;

// [START monitoring_v3_generated_NotificationChannelService_GetNotificationChannelVerificationCode_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.monitoring.v3.NotificationChannelServiceClient;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeRequest;
import com.google.monitoring.v3.GetNotificationChannelVerificationCodeResponse;
import com.google.monitoring.v3.NotificationChannelName;
import com.google.protobuf.Timestamp;

public class AsyncGetNotificationChannelVerificationCode {

  public static void main(String[] args) throws Exception {
    asyncGetNotificationChannelVerificationCode();
  }

  public static void asyncGetNotificationChannelVerificationCode() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NotificationChannelServiceClient notificationChannelServiceClient =
        NotificationChannelServiceClient.create()) {
      GetNotificationChannelVerificationCodeRequest request =
          GetNotificationChannelVerificationCodeRequest.newBuilder()
              .setName(
                  NotificationChannelName.ofProjectNotificationChannelName(
                          "[PROJECT]", "[NOTIFICATION_CHANNEL]")
                      .toString())
              .setExpireTime(Timestamp.newBuilder().build())
              .build();
      ApiFuture<GetNotificationChannelVerificationCodeResponse> future =
          notificationChannelServiceClient
              .getNotificationChannelVerificationCodeCallable()
              .futureCall(request);
      // Do something.
      GetNotificationChannelVerificationCodeResponse response = future.get();
    }
  }
}
// [END monitoring_v3_generated_NotificationChannelService_GetNotificationChannelVerificationCode_async]
