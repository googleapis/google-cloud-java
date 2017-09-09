package com.google.cloud.storage;

import static org.junit.Assert.assertTrue;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.google.cloud.storage.SignatureInfo.Builder;

public class SignatureInfoTest {
  
  private static final String RESOURCE = "/bucketName/blobName";
  
  @Test(expected = IllegalArgumentException.class)
  public void requireHttpVerb() {
    
    new SignatureInfo.Builder(null, 0L, Paths.get(RESOURCE)).build();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void requireResource() {
    
    new SignatureInfo.Builder(HttpMethod.GET, 0L, null).build();
  }

  @Test
  public void constructUnsignedPayload() {
    
    Builder builder = new SignatureInfo.Builder(HttpMethod.PUT, 0L, Paths.get(RESOURCE));
    
    String unsignedPayload = builder.build().constructUnsignedPayload();
    
    assertTrue(("PUT\n\n\n0\n" + RESOURCE).equals(unsignedPayload));
  }
  
  @Test
  public void constructUnsignedPayloadWithExtensionHeaders() {
    
    Builder builder = new SignatureInfo.Builder(HttpMethod.PUT, 0L, Paths.get(RESOURCE));
    
    Map<String, String> extensionHeaders = new HashMap<>();
    extensionHeaders.put("x-goog-acl", "public-read");
    extensionHeaders.put("x-goog-meta-owner", "myself");
    
    builder.setCanonicalizedExtensionHeaders(extensionHeaders);
    
    String unsignedPayload = builder.build().constructUnsignedPayload();
    
    String rawPayload =
        "PUT\n\n\n0\nx-goog-acl:public-read\nx-goog-meta-owner:myself\n" + RESOURCE;

    assertTrue(rawPayload.equals(unsignedPayload));
  }
}
