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

import com.google.cloud.compute.v1.InterconnectAttachment;
import com.google.cloud.compute.v1.InterconnectAttachmentClient;
import com.google.cloud.compute.v1.InterconnectAttachmentSettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITInterconnectAttachmentTest extends BaseTest {

  private static InterconnectAttachmentClient interconnectAttachmentClient;

  @BeforeClass
  public static void setUp() throws IOException {
    InterconnectAttachmentSettings interconnectAttachmentSettings =
        InterconnectAttachmentSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    interconnectAttachmentClient =
        InterconnectAttachmentClient.create(interconnectAttachmentSettings);
  }

  @AfterClass
  public static void tearDown() {
    interconnectAttachmentClient.close();
  }

  @Test
  public void listInterconnectAttachmentsTest() {
    List<InterconnectAttachment> attachments =
        Lists.newArrayList(
            interconnectAttachmentClient
                .listInterconnectAttachments(PROJECT_REGION_NAME)
                .iterateAll());
    assertThat(attachments).isNotNull();
    assertThat(attachments.size()).isEqualTo(0);
    assertThat(attachments.contains(null)).isFalse();
  }
}
