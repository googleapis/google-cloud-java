/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.omni;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import com.google.crypto.tink.util.SecretBytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpannerOmniCredentialsTest {

  @Test
  public void testConvertToSecretBytesClearsPassword() {
    char[] password = new char[] {'h', 'e', 'l', 'l', 'o'};
    SecretBytes secretBytes = SpannerOmniCredentials.convertToSecretBytes(password);

    assertNotNull(secretBytes);
    // Password array should be cleared to null characters
    assertArrayEquals(new char[] {'\0', '\0', '\0', '\0', '\0'}, password);
  }

  @Test
  public void testConstructorParsesTarget() {
    char[] password = new char[] {'p', 'a', 's', 's'};
    SecretBytes secretBytes = SpannerOmniCredentials.convertToSecretBytes(password);

    SpannerOmniCredentials creds1 =
        new SpannerOmniCredentials("user1", secretBytes, "http://localhost:15000");
    // Verify target parsed (we can't easily verify private fields but this validates it doesn't
    // crash)
    assertNotNull(creds1);

    SpannerOmniCredentials creds2 =
        new SpannerOmniCredentials("user1", secretBytes, "https://localhost:15000");
    assertNotNull(creds2);

    SpannerOmniCredentials creds3 =
        new SpannerOmniCredentials("user1", secretBytes, "localhost:15000");
    assertNotNull(creds3);
  }
}
