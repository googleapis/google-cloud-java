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

package com.google.cloud.examples.storage.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.api.gax.paging.Page;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITStorageHmacKeySnippets {
  private static final Logger log = Logger.getLogger(ITStorageSnippets.class.getName());
  private static final String HMAC_KEY_TEST_SERVICE_ACCOUNT =
      System.getenv("HMAC_KEY_SAMPLES_SERVICE_ACCOUNT");
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();

  private static Storage storage;
  private static StorageSnippets storageSnippets;

  @BeforeClass
  public static void beforeClass() {
    RemoteStorageHelper helper = RemoteStorageHelper.create();
    storage = helper.getOptions().getService();
    storageSnippets = new StorageSnippets(storage);
  }

  @Before
  public void before() {
    cleanUpHmacKeys(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
  }

  private static void cleanUpHmacKeys(ServiceAccount serviceAccount) {
    Page<HmacKeyMetadata> page =
        storage.listHmacKeys(Storage.ListHmacKeysOption.serviceAccount(serviceAccount));
    for (HmacKeyMetadata metadata : page.iterateAll()) {
      if (metadata.getState() == HmacKeyState.ACTIVE) {
        storage.updateHmacKeyState(metadata, HmacKeyState.INACTIVE);
      }
      storage.deleteHmacKey(metadata);
    }
  }

  @Test
  public void testCreateHmacKey() {
    HmacKey hmacKey = storageSnippets.createHmacKey(HMAC_KEY_TEST_SERVICE_ACCOUNT, PROJECT_ID);
    assertNotNull(hmacKey);
  }

  @Test
  public void testGetHmacKey() {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));

    HmacKeyMetadata metadata =
        storageSnippets.getHmacKey(hmacKey.getMetadata().getAccessId(), PROJECT_ID);
    assertNotNull(metadata);
  }

  @Test
  public void testActivateHmacKey() {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
    HmacKeyMetadata metadata =
        storage.updateHmacKeyState(hmacKey.getMetadata(), HmacKeyState.INACTIVE);

    HmacKeyMetadata newMetadata =
        storageSnippets.activateHmacKey(metadata.getAccessId(), PROJECT_ID);
    assertEquals(HmacKeyState.ACTIVE, newMetadata.getState());
  }

  @Test
  public void testDeactivateHmacKey() {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));

    HmacKeyMetadata metadata =
        storageSnippets.deactivateHmacKey(hmacKey.getMetadata().getAccessId(), PROJECT_ID);
    assertEquals(HmacKeyState.INACTIVE, metadata.getState());
  }

  @Test
  public void testDeleteHmacKey() {
    HmacKey hmacKey = storage.createHmacKey(ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT));
    HmacKeyMetadata metadata =
        storage.updateHmacKeyState(hmacKey.getMetadata(), HmacKeyState.INACTIVE);

    storageSnippets.deleteHmacKey(metadata.getAccessId(), PROJECT_ID);
  }

  @Test
  public void testListHmacKeys() {
    // Create 2 HMAC keys
    storage.createHmacKey(
        ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT),
        Storage.CreateHmacKeyOption.projectId(PROJECT_ID));
    storage.createHmacKey(
        ServiceAccount.of(HMAC_KEY_TEST_SERVICE_ACCOUNT),
        Storage.CreateHmacKeyOption.projectId(PROJECT_ID));

    Page<HmacKeyMetadata> page = storageSnippets.listHmacKeys(PROJECT_ID);

    int count = 0;
    for (HmacKeyMetadata metadata : page.iterateAll()) {
      if (metadata.getServiceAccount().getEmail().equals(HMAC_KEY_TEST_SERVICE_ACCOUNT)) {
        count++;
      }
    }

    assertEquals(2, count);
  }
}
