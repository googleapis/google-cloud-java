/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.example.storage.hmac.ActivateHmacKey;
import com.example.storage.hmac.CreateHmacKey;
import com.example.storage.hmac.DeactivateHmacKey;
import com.example.storage.hmac.DeleteHmacKey;
import com.example.storage.hmac.GetHmacKey;
import com.example.storage.hmac.ListHmacKeys;
import com.google.api.gax.paging.Page;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITHmacSnippets extends TestBase {
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String HMAC_KEY_TEST_SERVICE_ACCOUNT =
      PROJECT_ID + "@" + PROJECT_ID + ".iam.gserviceaccount.com";

  @Before
  public void before() {
    // Skip running Hmac snippet tests in CI
    // All of our samples CI uses a single service account. Each service account can only have 5
    // HMAC keys.
    // We have 6 test scenarios defined.
    // If more than one build is running at the same time they will fight with each other's limit
    // These samples have not materially changed since 2022-03 (as of 2025-05).
    // Additionally, we have more robust integration tests for HMAC operations in the library
    // itself.
    assumeFalse(
        "skipping hmac snippet tests in CI due to racy interactions",
        "samples".equals(Env.JOB_TYPE));
    cleanUpHmacKeys(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
  }

  private void cleanUpHmacKeys(ServiceAccount serviceAccount) {
    Page<HmacKey.HmacKeyMetadata> metadatas =
        storage.listHmacKeys(Storage.ListHmacKeysOption.serviceAccount(serviceAccount));
    for (HmacKey.HmacKeyMetadata hmacKeyMetadata : metadatas.iterateAll()) {
      if (hmacKeyMetadata.getState() == HmacKeyState.ACTIVE) {
        hmacKeyMetadata = storage.updateHmacKeyState(hmacKeyMetadata, HmacKeyState.INACTIVE);
      }
      if (hmacKeyMetadata.getState() == HmacKeyState.INACTIVE) {
        storage.deleteHmacKey(hmacKeyMetadata);
      }
    }
  }

  @Test
  public void testCreateHmacKey() throws Exception {
    CreateHmacKey.createHmacKey(HMAC_KEY_TEST_SERVICE_ACCOUNT, PROJECT_ID);
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    String accessId = snippetOutput.split("Access ID: ")[1].split("\n")[0];
    Thread.sleep(5000);
    assertNotNull(storage.getHmacKey(accessId));
  }

  @Test
  public void testGetHmacKey() throws Exception {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
    Thread.sleep(5000);
    GetHmacKey.getHmacKey(hmacKey.getMetadata().getAccessId(), PROJECT_ID);
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    Assert.assertTrue(snippetOutput.contains(HMAC_KEY_TEST_SERVICE_ACCOUNT));
  }

  @Test
  public void testActivateHmacKey() throws Exception {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
    HmacKeyMetadata metadata =
        storage.updateHmacKeyState(hmacKey.getMetadata(), HmacKeyState.INACTIVE);

    ActivateHmacKey.activateHmacKey(metadata.getAccessId(), PROJECT_ID);
    Thread.sleep(5000);
    assertEquals(HmacKeyState.ACTIVE, storage.getHmacKey(metadata.getAccessId()).getState());
  }

  @Test
  public void testDeactivateHmacKey() throws Exception {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
    Thread.sleep(5000);
    DeactivateHmacKey.deactivateHmacKey(hmacKey.getMetadata().getAccessId(), PROJECT_ID);
    assertEquals(
        HmacKeyState.INACTIVE, storage.getHmacKey(hmacKey.getMetadata().getAccessId()).getState());
  }

  @Test
  public void testDeleteHmacKey() {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
    HmacKeyMetadata metadata =
        storage.updateHmacKeyState(hmacKey.getMetadata(), HmacKeyState.INACTIVE);

    DeleteHmacKey.deleteHmacKey(metadata.getAccessId(), PROJECT_ID);
    assertEquals(HmacKeyState.DELETED, storage.getHmacKey(metadata.getAccessId()).getState());
  }

  @Test
  public void testListHmacKeys() {
    // Create 2 HMAC keys
    final HmacKey one =
        storage.createHmacKey(
            ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT),
            Storage.CreateHmacKeyOption.projectId(PROJECT_ID));
    final HmacKey two =
        storage.createHmacKey(
            ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT),
            Storage.CreateHmacKeyOption.projectId(PROJECT_ID));

    ListHmacKeys.listHmacKeys(PROJECT_ID);
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    assertTrue(snippetOutput.contains(one.getMetadata().getAccessId()));
    assertTrue(snippetOutput.contains(two.getMetadata().getAccessId()));
  }
}
