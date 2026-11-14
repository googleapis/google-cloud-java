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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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

    SpannerOmniCredentials credentials1 =
        new SpannerOmniCredentials("user1", secretBytes, "http://localhost:15000");
    assertNotNull(credentials1);

    SpannerOmniCredentials credentials2 =
        new SpannerOmniCredentials("user1", secretBytes, "https://localhost:15000");
    assertNotNull(credentials2);

    SpannerOmniCredentials credentials3 =
        new SpannerOmniCredentials("user1", secretBytes, "localhost:15000");
    assertNotNull(credentials3);
  }

  @Test
  public void testEqualsAndHashCode() {
    SecretBytes secretBytes1 =
        SpannerOmniCredentials.convertToSecretBytes(
            new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
    SecretBytes secretBytes1Duplicate =
        SpannerOmniCredentials.convertToSecretBytes(
            new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
    SecretBytes secretBytes2 =
        SpannerOmniCredentials.convertToSecretBytes(
            new char[] {'d', 'i', 'f', 'f', 'e', 'r', 'e', 'n', 't'});

    SpannerOmniCredentials credentials1 =
        new SpannerOmniCredentials("alice", secretBytes1, "http://localhost:15000");
    SpannerOmniCredentials credentials1Duplicate =
        new SpannerOmniCredentials("alice", secretBytes1Duplicate, "http://localhost:15000");
    SpannerOmniCredentials credentialsWithDifferentPassword =
        new SpannerOmniCredentials("alice", secretBytes2, "http://localhost:15000");
    SpannerOmniCredentials credentialsWithDifferentUser =
        new SpannerOmniCredentials("bob", secretBytes1, "http://localhost:15000");
    SpannerOmniCredentials credentialsWithDifferentTarget =
        new SpannerOmniCredentials("alice", secretBytes1, "http://otherhost:15000");
    SpannerOmniCredentials credentialsWithDifferentPlainText =
        new SpannerOmniCredentials("alice", secretBytes1, "https://localhost:15000");

    // Reflexive
    assertEquals(credentials1, credentials1);
    assertEquals(credentials1.hashCode(), credentials1.hashCode());

    // Symmetric / Equal instances
    assertEquals(credentials1, credentials1Duplicate);
    assertEquals(credentials1Duplicate, credentials1);
    assertEquals(credentials1.hashCode(), credentials1Duplicate.hashCode());

    // Different password: not equal, but hash codes match because password is not in hashCode
    assertNotEquals(credentials1, credentialsWithDifferentPassword);
    assertNotEquals(credentialsWithDifferentPassword, credentials1);
    assertEquals(credentials1.hashCode(), credentialsWithDifferentPassword.hashCode());

    // Different user
    assertNotEquals(credentials1, credentialsWithDifferentUser);
    assertNotEquals(credentialsWithDifferentUser, credentials1);
    assertNotEquals(credentials1.hashCode(), credentialsWithDifferentUser.hashCode());

    // Different target
    assertNotEquals(credentials1, credentialsWithDifferentTarget);
    assertNotEquals(credentialsWithDifferentTarget, credentials1);
    assertNotEquals(credentials1.hashCode(), credentialsWithDifferentTarget.hashCode());

    // Different usePlainText (http vs https) represent the same credential identity
    assertEquals(credentials1, credentialsWithDifferentPlainText);
    assertEquals(credentialsWithDifferentPlainText, credentials1);
    assertEquals(credentials1.hashCode(), credentialsWithDifferentPlainText.hashCode());

    // Null and other types
    assertFalse(credentials1.equals(null));
    assertFalse(credentials1.equals("alice"));
  }

  @Test
  public void testTargetNormalization() {
    SecretBytes secretBytes1 =
        SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's'});
    SecretBytes secretBytes2 =
        SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's'});
    SecretBytes secretBytes3 =
        SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's'});
    SecretBytes secretBytes4 =
        SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's'});

    SpannerOmniCredentials credentialsHttps =
        new SpannerOmniCredentials("user1", secretBytes1, "https://localhost:15000");
    SpannerOmniCredentials credentialsSlash =
        new SpannerOmniCredentials("user1", secretBytes2, "//localhost:15000");
    SpannerOmniCredentials credentialsBare =
        new SpannerOmniCredentials("user1", secretBytes3, "localhost:15000");
    SpannerOmniCredentials credentialsWithTrailingSlash =
        new SpannerOmniCredentials("user1", secretBytes4, "localhost:15000/");

    assertEquals(credentialsHttps, credentialsSlash);
    assertEquals(credentialsSlash, credentialsBare);
    assertEquals(credentialsBare, credentialsWithTrailingSlash);
    assertEquals(credentialsHttps.hashCode(), credentialsSlash.hashCode());
    assertEquals(credentialsSlash.hashCode(), credentialsBare.hashCode());
    assertEquals(credentialsBare.hashCode(), credentialsWithTrailingSlash.hashCode());
  }

  @Test
  public void testInitChannelDoesNotMutateEqualsOrHashCode() {
    SecretBytes secretBytes1 =
        SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's'});
    SecretBytes secretBytes2 =
        SpannerOmniCredentials.convertToSecretBytes(new char[] {'p', 'a', 's', 's'});

    SpannerOmniCredentials httpsCredentials =
        new SpannerOmniCredentials("user1", secretBytes1, "https://localhost:15000");
    SpannerOmniCredentials httpCredentials =
        new SpannerOmniCredentials("user1", secretBytes2, "http://localhost:15000");

    assertEquals(httpsCredentials, httpCredentials);
    assertEquals(httpsCredentials.hashCode(), httpCredentials.hashCode());

    // Switch httpsCredentials to use plaintext: equals and hashCode remain stable
    httpsCredentials.initChannel(/* usePlainText= */ true, /* sslContext= */ null);
    assertEquals(httpsCredentials, httpCredentials);
    assertEquals(httpsCredentials.hashCode(), httpCredentials.hashCode());

    // Switch httpsCredentials back to TLS: equals and hashCode remain stable
    httpsCredentials.initChannel(/* usePlainText= */ false, /* sslContext= */ null);
    assertEquals(httpsCredentials, httpCredentials);
    assertEquals(httpsCredentials.hashCode(), httpCredentials.hashCode());
  }
}
