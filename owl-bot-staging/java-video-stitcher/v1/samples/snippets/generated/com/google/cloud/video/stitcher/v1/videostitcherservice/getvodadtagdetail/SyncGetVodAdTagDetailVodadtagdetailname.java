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

// [START videostitcher_v1_generated_VideoStitcherService_GetVodAdTagDetail_Vodadtagdetailname_sync]
import com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient;
import com.google.cloud.video.stitcher.v1.VodAdTagDetail;
import com.google.cloud.video.stitcher.v1.VodAdTagDetailName;

public class SyncGetVodAdTagDetailVodadtagdetailname {

  public static void main(String[] args) throws Exception {
    syncGetVodAdTagDetailVodadtagdetailname();
  }

  public static void syncGetVodAdTagDetailVodadtagdetailname() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VideoStitcherServiceClient videoStitcherServiceClient =
        VideoStitcherServiceClient.create()) {
      VodAdTagDetailName name =
          VodAdTagDetailName.of("[PROJECT]", "[LOCATION]", "[VOD_SESSION]", "[VOD_AD_TAG_DETAIL]");
      VodAdTagDetail response = videoStitcherServiceClient.getVodAdTagDetail(name);
    }
  }
}
// [END videostitcher_v1_generated_VideoStitcherService_GetVodAdTagDetail_Vodadtagdetailname_sync]
