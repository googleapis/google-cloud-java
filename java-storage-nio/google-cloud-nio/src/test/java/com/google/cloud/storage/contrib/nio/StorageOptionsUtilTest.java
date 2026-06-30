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

package com.google.cloud.storage.contrib.nio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.StorageOptions;
import java.util.Map;
import org.junit.Test;

public final class StorageOptionsUtilTest {

  @Test
  public void ensureDefaultInstanceCarriedThrough() {
    StorageOptions defaultInstance = StorageOptionsUtil.getDefaultInstance();
    StorageOptions merged = StorageOptionsUtil.mergeOptionsWithUserAgent(defaultInstance);

    assertSame(defaultInstance, merged);
  }

  @Test
  public void ensureUserAgentEntryAddedIfUserAgentSpecified() {
    StorageOptions defaultInstance =
        defaults().toBuilder()
            .setHeaderProvider(FixedHeaderProvider.create("user-agent", "asdf/ gcloud-java-nio/"))
            .build();
    StorageOptions merged = StorageOptionsUtil.mergeOptionsWithUserAgent(defaultInstance);

    String mergedUserAgent = merged.getUserAgent();
    assertNotNull(mergedUserAgent);
    assertTrue(mergedUserAgent.contains("gcloud-java-nio/"));
  }

  @Test
  public void ensureUserAgentEntryLeftInTactIfAlreadySpecifiesOurEntry() {
    StorageOptions defaultInstance = defaults();
    StorageOptions merged = StorageOptionsUtil.mergeOptionsWithUserAgent(defaultInstance);

    String mergedUserAgent = merged.getUserAgent();
    assertNotNull(mergedUserAgent);
    assertTrue(mergedUserAgent.contains("gcloud-java-nio/"));
  }

  @Test
  public void ensureAddingUserAgentEntryDoesNotClobberAnyProvidedHeaders() {
    StorageOptions base =
        defaults().toBuilder()
            .setHeaderProvider(
                FixedHeaderProvider.create(
                    "user-agent", "custom/",
                    "x-custom-header", "value"))
            .build();
    StorageOptions merged = StorageOptionsUtil.mergeOptionsWithUserAgent(base);

    String mergedUserAgent = merged.getUserAgent();

    HeaderProvider mergedHeaderProvider = StorageOptionsUtil.getHeaderProvider(merged);
    Map<String, String> headers = mergedHeaderProvider.getHeaders();
    String customHeader = headers.get("x-custom-header");

    assertNotNull(mergedUserAgent);
    assertNotNull(customHeader);
    assertEquals("value", customHeader);
    assertTrue(mergedUserAgent.contains("custom/ gcloud-java-nio/"));
  }

  private StorageOptions defaults() {
    return StorageOptions.newBuilder()
        .setCredentials(NoCredentials.getInstance())
        .setProjectId("proj")
        .build();
  }
}
