/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.compute.v1.Commitment;
import com.google.cloud.compute.v1.RegionCommitmentClient;
import com.google.cloud.compute.v1.RegionCommitmentSettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITRegionCommitmentTest extends BaseTest {

  private static RegionCommitmentClient regionCommitmentClient;

  @BeforeClass
  public static void setUp() throws IOException {
    RegionCommitmentSettings regionCommitmentSettings =
        RegionCommitmentSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionCommitmentClient = RegionCommitmentClient.create(regionCommitmentSettings);
  }

  @AfterClass
  public static void tearDown() {
    regionCommitmentClient.close();
  }

  @Test
  public void listRegionCommitmentsTest() {
    List<Commitment> commitments =
        Lists.newArrayList(
            regionCommitmentClient.listRegionCommitments(PROJECT_REGION_NAME).iterateAll());
    assertThat(commitments).isNotNull();
    assertThat(commitments.size()).isEqualTo(0);
    assertThat(commitments.contains(null)).isFalse();
  }
}
