/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.net.URL;
import java.util.function.Supplier;
import org.junit.Assert;
import org.junit.Test;

public final class ResumableMediaTest {
  private static final String SIGNED_URL_INVALID =
      "http://localhost/test-bucket/test1.txt?GoogAccessId=testClient-test@test.com&Expires=1553839761&Signature=MJUBXAZ7";
  private static final String SIGNED_URL_VALID =
      "http://localhost/test-bucket/test1.txt?GoogleAccessId=testClient-test@test.com&Expires=1553839761&Signature=MJUBXAZ7";

  @Test
  public void startUploadForSignedUrl_expectStorageException_whenUrlInvalid() throws Exception {
    try {
      ResumableMedia.startUploadForSignedUrl(
              HttpStorageOptions.newBuilder().build(),
              new URL(SIGNED_URL_INVALID),
              RetrierWithAlg.attemptOnce())
          .get();
      Assert.fail();
    } catch (StorageException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void startUploadForSignedUrl_whenUrlValid() throws Exception {
    StorageRpc rpc = mock(StorageRpc.class);
    HttpStorageOptions options =
        HttpStorageOptions.newBuilder().setServiceRpcFactory(opts -> rpc).build();

    URL url = new URL(SIGNED_URL_VALID);
    when(rpc.open(url.toString())).thenReturn("upload-id");

    Supplier<String> uploadIdSupplier =
        ResumableMedia.startUploadForSignedUrl(options, url, RetrierWithAlg.attemptOnce());
    assertThat(uploadIdSupplier.get()).isEqualTo("upload-id");
  }
}
