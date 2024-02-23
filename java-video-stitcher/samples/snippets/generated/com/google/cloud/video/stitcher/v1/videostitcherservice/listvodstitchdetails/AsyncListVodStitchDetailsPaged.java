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

package com.google.cloud.video.stitcher.v1.samples;

// [START videostitcher_v1_generated_VideoStitcherService_ListVodStitchDetails_Paged_async]
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse;
import com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient;
import com.google.cloud.video.stitcher.v1.VodSessionName;
import com.google.cloud.video.stitcher.v1.VodStitchDetail;
import com.google.common.base.Strings;

public class AsyncListVodStitchDetailsPaged {

  public static void main(String[] args) throws Exception {
    asyncListVodStitchDetailsPaged();
  }

  public static void asyncListVodStitchDetailsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VideoStitcherServiceClient videoStitcherServiceClient =
        VideoStitcherServiceClient.create()) {
      ListVodStitchDetailsRequest request =
          ListVodStitchDetailsRequest.newBuilder()
              .setParent(VodSessionName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListVodStitchDetailsResponse response =
            videoStitcherServiceClient.listVodStitchDetailsCallable().call(request);
        for (VodStitchDetail element : response.getVodStitchDetailsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END videostitcher_v1_generated_VideoStitcherService_ListVodStitchDetails_Paged_async]
