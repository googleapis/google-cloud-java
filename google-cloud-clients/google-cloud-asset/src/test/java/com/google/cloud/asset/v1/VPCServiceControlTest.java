/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.asset.v1;

import com.google.api.*;
import com.google.protobuf.*;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by Google")
public class VPCServiceControlTest {
  private static void doTest(boolean rejectedInside, boolean rejectedOutside) {
    if ((IS_INSIDE_VPCSC != null) && (IS_INSIDE_VPCSC.equalsIgnoreCase("true"))) {
      Assert.assertTrue(!rejectedInside);
      Assert.assertTrue(rejectedOutside);
    } else {
      Assert.assertTrue(rejectedInside);
      Assert.assertTrue(!rejectedOutside);
    }
  }

  static final String PROJECT_OUTSIDE =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
  static final String PROJECT_INSIDE = System.getenv("PROJECT_ID");
  static final String IS_INSIDE_VPCSC = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");

  @BeforeClass
  public static void setUpClass() {
    Assume.assumeTrue(
        "GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT environment variable needs to be set to a GCP project that is outside the VPC perimeter",
        PROJECT_OUTSIDE != null && !PROJECT_OUTSIDE.isEmpty());
    Assume.assumeTrue(
        "PROJECT_ID environment variable needs to be set to a GCP project that is inside the VPC perimeter",
        PROJECT_INSIDE != null && !PROJECT_INSIDE.isEmpty());
  }

  @Test
  @SuppressWarnings("all")
  public void exportAssetsTest() throws Exception {
    final AssetServiceClient client = AssetServiceClient.create();
    final OutputConfig outputConfig = OutputConfig.newBuilder().build();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final ExportAssetsRequest requestInside =
        ExportAssetsRequest.newBuilder()
            .setParent(nameInside.toString())
            .setOutputConfig(outputConfig)
            .build();
    boolean rejectedInside = false;
    try {
      ExportAssetsResponse response = client.exportAssetsAsync(requestInside).get();
    } catch (Exception e) {
      rejectedInside = e.getMessage().contains("Request is prohibited by organization's policy");
    }
    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final ExportAssetsRequest requestOutside =
        ExportAssetsRequest.newBuilder()
            .setParent(nameOutside.toString())
            .setOutputConfig(outputConfig)
            .build();
    boolean rejectedOutside = false;
    try {
      ExportAssetsResponse response = client.exportAssetsAsync(requestOutside).get();
    } catch (Exception e) {
      rejectedOutside = e.getMessage().contains("Request is prohibited by organization's policy");
    }
    doTest(rejectedInside, rejectedOutside);
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetAssetsHistoryTest() throws Exception {
    final AssetServiceClient client = AssetServiceClient.create();
    final TimeWindow readTimeWindow = TimeWindow.newBuilder().build();
    final ProjectName nameInside = ProjectName.of(PROJECT_INSIDE);
    final BatchGetAssetsHistoryRequest requestInside =
        BatchGetAssetsHistoryRequest.newBuilder()
            .setParent(nameInside.toString())
            .setReadTimeWindow(readTimeWindow)
            .build();
    boolean rejectedInside = false;
    try {
      BatchGetAssetsHistoryResponse response = client.batchGetAssetsHistory(requestInside);
    } catch (Exception e) {
      rejectedInside = e.getMessage().contains("Request is prohibited by organization's policy");
    }

    final ProjectName nameOutside = ProjectName.of(PROJECT_OUTSIDE);
    final BatchGetAssetsHistoryRequest requestOutside =
        BatchGetAssetsHistoryRequest.newBuilder()
            .setParent(nameOutside.toString())
            .setReadTimeWindow(readTimeWindow)
            .build();
    boolean rejectedOutside = false;
    try {
      BatchGetAssetsHistoryResponse response = client.batchGetAssetsHistory(requestOutside);
    } catch (Exception e) {
      rejectedOutside = e.getMessage().contains("Request is prohibited by organization's policy");
    }
    doTest(rejectedInside, rejectedOutside);
    client.close();
  }
}
