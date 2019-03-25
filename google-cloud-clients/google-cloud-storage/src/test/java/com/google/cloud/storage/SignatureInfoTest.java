/*
 * Copyright 2015 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.storage.SignatureInfo.Builder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class SignatureInfoTest {

  private static final String RESOURCE = "/bucketName/blobName";

  @Test(expected = IllegalArgumentException.class)
  public void requireHttpVerb() {

    new SignatureInfo.Builder(null, 0L, URI.create(RESOURCE)).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void requireResource() {

    new SignatureInfo.Builder(HttpMethod.GET, 0L, null).build();
  }

  @Test
  public void constructUnsignedPayload() {

    Builder builder = new SignatureInfo.Builder(HttpMethod.PUT, 0L, URI.create(RESOURCE));

    String unsignedPayload = builder.build().constructUnsignedPayload();

    assertEquals("PUT\n\n\n0\n" + RESOURCE, unsignedPayload);
  }

  @Test
  public void constructUnsignedPayloadWithExtensionHeaders() {

    Builder builder = new SignatureInfo.Builder(HttpMethod.PUT, 0L, URI.create(RESOURCE));

    Map<String, String> extensionHeaders = new HashMap<>();
    extensionHeaders.put("x-goog-acl", "public-read");
    extensionHeaders.put("x-goog-meta-owner", "myself");

    builder.setCanonicalizedExtensionHeaders(extensionHeaders);

    String unsignedPayload = builder.build().constructUnsignedPayload();

    String rawPayload = "PUT\n\n\n0\nx-goog-acl:public-read\nx-goog-meta-owner:myself\n" + RESOURCE;

    assertEquals(rawPayload, unsignedPayload);
  }

  @Test
  public void constructV4UnsignedPayload() {
    Builder builder = new SignatureInfo.Builder(HttpMethod.PUT, 10L, URI.create(RESOURCE));

    builder.setSignatureVersion(Storage.SignUrlOption.SignatureVersion.V4);
    builder.setAccountEmail("me@google.com");
    builder.setTimestamp(1000000000000L);

    String unsignedPayload = builder.build().constructUnsignedPayload();

    assertTrue(
        unsignedPayload.startsWith(
            "GOOG4-RSA-SHA256\n" + "20010909T014640Z\n" + "20010909/auto/storage/goog4_request\n"));
  }

  @Test
  public void constructV4QueryString() {
    Builder builder = new SignatureInfo.Builder(HttpMethod.PUT, 10L, URI.create(RESOURCE));

    builder.setSignatureVersion(Storage.SignUrlOption.SignatureVersion.V4);
    builder.setAccountEmail("me@google.com");
    builder.setTimestamp(1000000000000L);

    String queryString = builder.build().constructV4QueryString();
    assertEquals(
        "X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=me%40google.com%2F20010909%2F"
            + "auto%2Fstorage%2Fgoog4_request&X-Goog-Date=20010909T014640Z&X-Goog-Expires=10&X-Goog-SignedHeaders=host",
        queryString);
  }
}
