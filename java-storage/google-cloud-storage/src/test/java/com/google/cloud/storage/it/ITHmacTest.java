/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.StreamSupport;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP},
    backends = {Backend.TEST_BENCH})
public class ITHmacTest {

  @Inject public Storage storage;

  // when modifying this test or {@link #cleanUpHmacKeys} be sure to remember multiple simultaneous
  // runs of the integration suite can run with the same service account. Be sure to not clobber
  // any possible run state for the other run.
  @Test
  public void testHmacKey() {
    String serviceAccountEmail = System.getenv("IT_SERVICE_ACCOUNT_EMAIL");
    assertNotNull("Unable to determine service account email", serviceAccountEmail);
    ServiceAccount serviceAccount = ServiceAccount.of(serviceAccountEmail);
    cleanUpHmacKeys(serviceAccount);

    HmacKey hmacKey = storage.createHmacKey(serviceAccount);
    String secretKey = hmacKey.getSecretKey();
    assertNotNull(secretKey);
    HmacKey.HmacKeyMetadata metadata = hmacKey.getMetadata();
    String accessId = metadata.getAccessId();

    assertNotNull(accessId);
    assertNotNull(metadata.getEtag());
    assertNotNull(metadata.getId());
    assertEquals(storage.getOptions().getProjectId(), metadata.getProjectId());
    assertEquals(serviceAccount.getEmail(), metadata.getServiceAccount().getEmail());
    assertEquals(HmacKey.HmacKeyState.ACTIVE, metadata.getState());
    assertNotNull(metadata.getCreateTime());
    assertNotNull(metadata.getUpdateTime());

    Page<HmacKeyMetadata> metadatas =
        storage.listHmacKeys(Storage.ListHmacKeysOption.serviceAccount(serviceAccount));
    boolean createdInList =
        StreamSupport.stream(metadatas.iterateAll().spliterator(), false)
            .map(HmacKey.HmacKeyMetadata::getAccessId)
            .anyMatch(accessId::equals);

    assertWithMessage("Created an HMAC key but it didn't show up in list()")
        .that(createdInList)
        .isTrue();

    HmacKey.HmacKeyMetadata getResult = storage.getHmacKey(accessId);
    assertEquals(metadata, getResult);

    storage.updateHmacKeyState(metadata, HmacKey.HmacKeyState.INACTIVE);

    storage.deleteHmacKey(metadata);

    metadatas = storage.listHmacKeys(Storage.ListHmacKeysOption.serviceAccount(serviceAccount));
    boolean deletedInList =
        StreamSupport.stream(metadatas.iterateAll().spliterator(), false)
            .map(HmacKey.HmacKeyMetadata::getAccessId)
            .anyMatch(accessId::equals);

    assertWithMessage("Deleted an HMAC key but it showed up in list()")
        .that(deletedInList)
        .isFalse();
  }

  private void cleanUpHmacKeys(ServiceAccount serviceAccount) {
    Instant now = Instant.now();
    Instant yesterday = now.minus(Duration.ofDays(1L));

    Page<HmacKey.HmacKeyMetadata> metadatas =
        storage.listHmacKeys(Storage.ListHmacKeysOption.serviceAccount(serviceAccount));
    for (HmacKey.HmacKeyMetadata hmacKeyMetadata : metadatas.iterateAll()) {
      Instant updated = Instant.ofEpochMilli(hmacKeyMetadata.getUpdateTime());
      if (updated.isBefore(yesterday)) {

        if (hmacKeyMetadata.getState() == HmacKeyState.ACTIVE) {
          hmacKeyMetadata = storage.updateHmacKeyState(hmacKeyMetadata, HmacKeyState.INACTIVE);
        }

        if (hmacKeyMetadata.getState() == HmacKeyState.INACTIVE) {
          try {
            storage.deleteHmacKey(hmacKeyMetadata);
          } catch (StorageException e) {
            // attempted to delete concurrently, if the other succeeded swallow the error
            if (!(e.getReason().equals("invalid") && e.getMessage().contains("deleted"))) {
              throw e;
            }
          }
        }
      }
    }
  }
}
