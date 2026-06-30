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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.google.api.client.json.gson.GsonFactory;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.spi.v1.HttpStorageRpc;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Explicitly configure an alternative {@link com.google.api.client.json.JsonFactory} for use by an
 * instance of {@link com.google.cloud.storage.Storage}
 */
@RunWith(MockitoJUnitRunner.class)
public final class ITCustomJsonFactoryTest {

  @Spy GsonFactory gsonFactory = new GsonFactory();

  @Test
  public void customJsonFactoryConfigurableViaStorageOptions() {
    Storage s =
        StorageOptions.newBuilder()
            .setServiceRpcFactory(
                options -> {
                  if (options instanceof HttpStorageOptions) {
                    HttpStorageOptions httpStorageOptions = (HttpStorageOptions) options;
                    return new HttpStorageRpc(httpStorageOptions, gsonFactory);
                  } else {
                    throw new IllegalArgumentException("Only HttpStorageOptions supported");
                  }
                })
            .build()
            .getService();

    Page<Bucket> bucketPage = s.list(BucketListOption.pageSize(10));
    List<Bucket> buckets =
        StreamSupport.stream(bucketPage.iterateAll().spliterator(), false)
            .collect(Collectors.toList());
    // if we reach here, we're good the call didn't fail, and we parsed some json.

    verify(gsonFactory, atLeastOnce())
        .createJsonParser(any(InputStream.class), eq(StandardCharsets.UTF_8));
  }
}
