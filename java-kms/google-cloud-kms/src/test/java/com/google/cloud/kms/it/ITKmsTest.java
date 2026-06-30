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

package com.google.cloud.kms.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.kms.v1.CreateKeyRingRequest;
import com.google.cloud.kms.v1.GetKeyRingRequest;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.KeyRingName;
import com.google.cloud.kms.v1.LocationName;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ITKmsTest {

  private KeyManagementServiceClient kmsClient;
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String KMS_KEY_RING_LOCATION = "us";
  private static final String KMS_KEY_RING_ID = "gcs_test_kms_key_ring";
  private static final String KMS_KEY_RING_NAME =
      KeyRingName.of(PROJECT_ID, KMS_KEY_RING_LOCATION, KMS_KEY_RING_ID).toString();

  @Before
  public void setUp() throws IOException {
    kmsClient = KeyManagementServiceClient.create();

    String parent = LocationName.of(PROJECT_ID, KMS_KEY_RING_LOCATION).toString();
    KeyManagementServiceClient.ListKeyRingsPagedResponse listKeyRingsPagedResponse =
        kmsClient.listKeyRings(parent);
    boolean foundTestKeyRing = false;
    for (KeyRing keyRing : listKeyRingsPagedResponse.iterateAll()) {
      // keyRing.getName() returns the fully qualified name and not the ID
      if (KMS_KEY_RING_NAME.equals(keyRing.getName())) {
        foundTestKeyRing = true;
      }
    }
    // Only create the test key ring if it doesn't exist
    if (!foundTestKeyRing) {
      kmsClient.createKeyRing(
          CreateKeyRingRequest.newBuilder()
              .setParent(parent)
              .setKeyRingId(KMS_KEY_RING_ID)
              .setKeyRing(KeyRing.newBuilder().build())
              .build());
    }
  }

  @After
  public void cleanUp() throws InterruptedException {
    kmsClient.close();
    kmsClient.awaitTermination(10, TimeUnit.SECONDS);
  }

  @Test
  public void getKeyRing() {
    GetKeyRingRequest getKeyRingRequest =
        GetKeyRingRequest.newBuilder().setName(KMS_KEY_RING_NAME).build();
    KeyRing keyRing = kmsClient.getKeyRing(getKeyRingRequest);
    assertEquals(KMS_KEY_RING_NAME, keyRing.getName());
  }
}
