/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
    
    String rawPayload =
        "PUT\n\n\n0\nx-goog-acl:public-read\nx-goog-meta-owner:myself\n" + RESOURCE;

    assertEquals(rawPayload, unsignedPayload);
  }
}
