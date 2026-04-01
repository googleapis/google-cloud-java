/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static com.google.auth.Credentials.GOOGLE_DEFAULT_UNIVERSE;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.util.Clock;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.TestClock;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

/** Test case for {@link ServiceAccountCredentials}. */
class ServiceAccountJwtAccessCredentialsTest extends BaseSerializationTest {

  private static final String SA_CLIENT_EMAIL =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr@developer.gserviceaccount.com";
  private static final String SA_CLIENT_ID =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr.apps.googleusercontent.com";
  private static final String SA_PRIVATE_KEY_ID = "d84a4fefcf50791d4a90f2d7af17469d6282df9d";
  private static final String SA_PRIVATE_KEY_PKCS8 =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALX0PQoe1igW12i"
          + "kv1bN/r9lN749y2ijmbc/mFHPyS3hNTyOCjDvBbXYbDhQJzWVUikh4mvGBA07qTj79Xc3yBDfKP2IeyYQIFe0t0"
          + "zkd7R9Zdn98Y2rIQC47aAbDfubtkU1U72t4zL11kHvoa0/RuFZjncvlr42X7be7lYh4p3NAgMBAAECgYASk5wDw"
          + "4Az2ZkmeuN6Fk/y9H+Lcb2pskJIXjrL533vrDWGOC48LrsThMQPv8cxBky8HFSEklPpkfTF95tpD43iVwJRB/Gr"
          + "CtGTw65IfJ4/tI09h6zGc4yqvIo1cHX/LQ+SxKLGyir/dQM925rGt/VojxY5ryJR7GLbCzxPnJm/oQJBANwOCO6"
          + "D2hy1LQYJhXh7O+RLtA/tSnT1xyMQsGT+uUCMiKS2bSKx2wxo9k7h3OegNJIu1q6nZ6AbxDK8H3+d0dUCQQDTrP"
          + "SXagBxzp8PecbaCHjzNRSQE2in81qYnrAFNB4o3DpHyMMY6s5ALLeHKscEWnqP8Ur6X4PvzZecCWU9BKAZAkAut"
          + "LPknAuxSCsUOvUfS1i87ex77Ot+w6POp34pEX+UWb+u5iFn2cQacDTHLV1LtE80L8jVLSbrbrlH43H0DjU5AkEA"
          + "gidhycxS86dxpEljnOMCw8CKoUBd5I880IUahEiUltk7OLJYS/Ts1wbn3kPOVX3wyJs8WBDtBkFrDHW2ezth2QJ"
          + "ADj3e1YhMVdjJW5jqwlD/VNddGjgzyunmiZg0uOXsHXbytYmsA545S8KRQFaJKFXYYFo2kOjqOiC1T2cAzMDjCQ"
          + "==\n-----END PRIVATE KEY-----\n";
  private static final String JWT_ACCESS_PREFIX =
      ServiceAccountJwtAccessCredentials.JWT_ACCESS_PREFIX;
  private static final URI CALL_URI = URI.create("http://googleapis.com/testapi/v1/foo");
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  private static final String QUOTA_PROJECT = "sample-quota-project-id";

  @Test
  void constructor_allParameters_constructs() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    assertEquals(SA_CLIENT_ID, credentials.getClientId());
    assertEquals(SA_CLIENT_EMAIL, credentials.getClientEmail());
    assertEquals(privateKey, credentials.getPrivateKey());
    assertEquals(SA_PRIVATE_KEY_ID, credentials.getPrivateKeyId());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void constructor_noClientId_constructs() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials.newBuilder()
        .setClientEmail(SA_CLIENT_EMAIL)
        .setPrivateKey(privateKey)
        .setPrivateKeyId(SA_PRIVATE_KEY_ID)
        .build();
  }

  @Test
  void constructor_noPrivateKeyId_constructs() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials.newBuilder()
        .setClientId(SA_CLIENT_ID)
        .setClientEmail(SA_CLIENT_EMAIL)
        .setPrivateKey(privateKey)
        .build();
  }

  @Test
  void constructor_noEmail_throws() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    try {
      ServiceAccountJwtAccessCredentials.newBuilder()
          .setClientId(SA_CLIENT_ID)
          .setPrivateKey(privateKey)
          .setPrivateKeyId(SA_PRIVATE_KEY_ID)
          .build();
      fail("exception expected");
    } catch (NullPointerException e) {
      // Expected
    }
  }

  @Test
  void constructor_noPrivateKey_throws() {
    try {
      ServiceAccountJwtAccessCredentials.newBuilder()
          .setClientId(SA_CLIENT_ID)
          .setClientEmail(SA_CLIENT_EMAIL)
          .setPrivateKeyId(SA_PRIVATE_KEY_ID)
          .build();
      fail("exception expected");
    } catch (NullPointerException e) {
      // Expected
    }
  }

  @Test
  void getAuthenticationType_returnsJwtAccess() throws IOException {
    Credentials credentials =
        ServiceAccountJwtAccessCredentials.fromPkcs8(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);
    assertEquals(credentials.getAuthenticationType(), "JWTAccess");
  }

  @Test
  void hasRequestMetadata_returnsTrue() throws IOException {
    Credentials credentials =
        ServiceAccountJwtAccessCredentials.fromPkcs8(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);
    assertTrue(credentials.hasRequestMetadata());
  }

  @Test
  void hasRequestMetadataOnly_returnsTrue() throws IOException {
    Credentials credentials =
        ServiceAccountJwtAccessCredentials.fromPkcs8(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);
    assertTrue(credentials.hasRequestMetadataOnly());
  }

  @Test
  void getRequestMetadata_blocking_hasJwtAccess() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    verifyJwtAccess(metadata, SA_CLIENT_EMAIL, CALL_URI, SA_PRIVATE_KEY_ID);
  }

  @Test
  void getRequestMetadata_blocking_defaultURI_hasJwtAccess() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    Credentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata();

    verifyJwtAccess(metadata, SA_CLIENT_EMAIL, CALL_URI, SA_PRIVATE_KEY_ID);
  }

  @Test
  void getRequestMetadata_blocking_noURI_throws() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();

    try {
      credentials.getRequestMetadata();
      fail("exception expected");
    } catch (IOException e) {
      // Expected
    }
  }

  @Test
  void getRequestMetadata_blocking_cached() throws IOException {
    TestClock testClock = new TestClock();

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    credentials.clock = testClock;

    Map<String, List<String>> metadata1 = credentials.getRequestMetadata(CALL_URI);

    // Fast forward time a little
    long lifeSpanMs = TimeUnit.SECONDS.toMillis(10);
    testClock.setCurrentTime(lifeSpanMs);

    Map<String, List<String>> metadata2 = credentials.getRequestMetadata(CALL_URI);

    assertEquals(metadata1, metadata2);
  }

  @Test
  void getRequestMetadata_blocking_cache_expired() throws IOException {
    TestClock testClock = new TestClock();

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    credentials.clock = testClock;

    Map<String, List<String>> metadata1 = credentials.getRequestMetadata(CALL_URI);

    // Fast forward time past the expiration
    long lifeSpanMs = TimeUnit.SECONDS.toMillis(ServiceAccountJwtAccessCredentials.LIFE_SPAN_SECS);
    testClock.setCurrentTime(lifeSpanMs);

    Map<String, List<String>> metadata2 = credentials.getRequestMetadata(CALL_URI);

    assertNotEquals(metadata1, metadata2);
  }

  @Test
  void getRequestMetadata_async_hasJwtAccess() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    MockExecutor executor = new MockExecutor();
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();

    credentials.getRequestMetadata(CALL_URI, executor, callback);
    assertEquals(0, executor.numTasks());
    assertNotNull(callback.metadata);
    verifyJwtAccess(callback.metadata, SA_CLIENT_EMAIL, CALL_URI, SA_PRIVATE_KEY_ID);
  }

  @Test
  void getRequestMetadata_async_defaultURI_hasJwtAccess() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    Credentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    MockExecutor executor = new MockExecutor();
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();

    credentials.getRequestMetadata(null, executor, callback);
    assertEquals(0, executor.numTasks());
    assertNotNull(callback.metadata);
    verifyJwtAccess(callback.metadata, SA_CLIENT_EMAIL, CALL_URI, SA_PRIVATE_KEY_ID);
  }

  @Test
  void getRequestMetadata_async_noURI_exception() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    MockExecutor executor = new MockExecutor();
    MockRequestMetadataCallback callback = new MockRequestMetadataCallback();

    credentials.getRequestMetadata(null, executor, callback);
    assertEquals(0, executor.numTasks());
    assertNotNull(callback.exception);
  }

  @Test
  void getRequestMetadata_async_cache_expired() throws IOException {
    TestClock testClock = new TestClock();

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    credentials.clock = testClock;
    MockExecutor executor = new MockExecutor();

    MockRequestMetadataCallback callback1 = new MockRequestMetadataCallback();
    credentials.getRequestMetadata(CALL_URI, executor, callback1);

    // Fast forward time past the expiration
    long lifeSpanMs = TimeUnit.SECONDS.toMillis(ServiceAccountJwtAccessCredentials.LIFE_SPAN_SECS);
    testClock.setCurrentTime(lifeSpanMs);

    MockRequestMetadataCallback callback2 = new MockRequestMetadataCallback();
    credentials.getRequestMetadata(CALL_URI, executor, callback2);

    assertNotEquals(callback1.metadata, callback2.metadata);
  }

  @Test
  void getRequestMetadata_async_cached() throws IOException {
    TestClock testClock = new TestClock();

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    credentials.clock = testClock;
    MockExecutor executor = new MockExecutor();

    MockRequestMetadataCallback callback1 = new MockRequestMetadataCallback();
    credentials.getRequestMetadata(CALL_URI, executor, callback1);

    // Fast forward time a little
    long lifeSpanMs = TimeUnit.SECONDS.toMillis(10);
    testClock.setCurrentTime(lifeSpanMs);

    MockRequestMetadataCallback callback2 = new MockRequestMetadataCallback();
    credentials.getRequestMetadata(CALL_URI, executor, callback2);

    assertEquals(callback1.metadata, callback2.metadata);
  }

  @Test
  void getRequestMetadata_contains_quotaProjectId() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    Credentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    assertTrue(metadata.containsKey(GoogleCredentials.QUOTA_PROJECT_ID_HEADER_KEY));
    assertEquals(
        metadata.get(GoogleCredentials.QUOTA_PROJECT_ID_HEADER_KEY),
        Collections.singletonList(QUOTA_PROJECT));
  }

  @Test
  void getAccount_sameAs() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    assertEquals(SA_CLIENT_EMAIL, credentials.getAccount());
  }

  @Test
  void sign_sameAs()
      throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    byte[] toSign = {0xD, 0xE, 0xA, 0xD};
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    byte[] signedBytes = credentials.sign(toSign);
    Signature signature = Signature.getInstance(OAuth2Utils.SIGNATURE_ALGORITHM);
    signature.initSign(credentials.getPrivateKey());
    signature.update(toSign);
    assertArrayEquals(signature.sign(), signedBytes);
  }

  @Test
  void equals_true() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    ServiceAccountJwtAccessCredentials otherCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    assertTrue(credentials.equals(otherCredentials));
    assertTrue(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_clientId() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    ServiceAccountJwtAccessCredentials otherCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId("otherClientId")
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_email() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    ServiceAccountJwtAccessCredentials otherCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail("otherClientEmail")
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_keyId() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    ServiceAccountJwtAccessCredentials otherCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId("otherKeyId")
            .setDefaultAudience(CALL_URI)
            .build();
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_callUri() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    final URI otherCallUri = URI.create("https://foo.com/bar");
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    ServiceAccountJwtAccessCredentials otherCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(otherCallUri)
            .build();
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void toString_containsFields() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();
    String expectedToString =
        String.format(
            "ServiceAccountJwtAccessCredentials{clientId=%s, clientEmail=%s, privateKeyId=%s, "
                + "defaultAudience=%s, quotaProjectId=%s}",
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_ID, CALL_URI, QUOTA_PROJECT);
    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void hashCode_equals() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    ServiceAccountJwtAccessCredentials otherCredentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    assertEquals(credentials.hashCode(), otherCredentials.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(CALL_URI)
            .build();
    ServiceAccountJwtAccessCredentials deserializedCredentials =
        serializeAndDeserialize(credentials);
    verifyJwtAccess(
        deserializedCredentials.getRequestMetadata(), SA_CLIENT_EMAIL, CALL_URI, SA_PRIVATE_KEY_ID);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
    assertSame(deserializedCredentials.clock, Clock.SYSTEM);
  }

  @Test
  void fromStream_nullStream_throws() throws IOException {
    MockHttpTransportFactory transportFactory = new MockHttpTransportFactory();
    try {
      ServiceAccountCredentials.fromStream(null, transportFactory);
      fail("Should throw if InputStream is null");
    } catch (NullPointerException expected) {
      // Expected
    }
  }

  @Test
  void fromStream_hasJwtAccess() throws IOException {
    InputStream serviceAccountStream =
        ServiceAccountCredentialsTest.writeServiceAccountStream(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);

    Credentials credentials = ServiceAccountJwtAccessCredentials.fromStream(serviceAccountStream);

    assertNotNull(credentials);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    verifyJwtAccess(metadata, SA_CLIENT_EMAIL, CALL_URI, SA_PRIVATE_KEY_ID);
  }

  @Test
  void fromStream_defaultURI_hasJwtAccess() throws IOException {
    InputStream serviceAccountStream =
        ServiceAccountCredentialsTest.writeServiceAccountStream(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);

    Credentials credentials =
        ServiceAccountJwtAccessCredentials.fromStream(serviceAccountStream, CALL_URI);

    assertNotNull(credentials);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(null);
    verifyJwtAccess(metadata, SA_CLIENT_EMAIL, CALL_URI, SA_PRIVATE_KEY_ID);
  }

  @Test
  void fromStream_noClientId_throws() throws IOException {
    InputStream serviceAccountStream =
        ServiceAccountCredentialsTest.writeServiceAccountStream(
            null, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);

    testFromStreamException(serviceAccountStream, "client_id");
  }

  @Test
  void fromStream_noClientEmail_throws() throws IOException {
    InputStream serviceAccountStream =
        ServiceAccountCredentialsTest.writeServiceAccountStream(
            SA_CLIENT_ID, null, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);

    testFromStreamException(serviceAccountStream, "client_email");
  }

  @Test
  void fromStream_noPrivateKey_throws() throws IOException {
    InputStream serviceAccountStream =
        ServiceAccountCredentialsTest.writeServiceAccountStream(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, null, SA_PRIVATE_KEY_ID);

    testFromStreamException(serviceAccountStream, "private_key");
  }

  @Test
  void fromStream_noPrivateKeyId_throws() throws IOException {
    InputStream serviceAccountStream =
        ServiceAccountCredentialsTest.writeServiceAccountStream(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, null);

    testFromStreamException(serviceAccountStream, "private_key_id");
  }

  @Test
  void jwtWithClaims_overrideAudience() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    Credentials withAudience =
        credentials.jwtWithClaims(JwtClaims.newBuilder().setAudience("new-audience").build());

    Map<String, List<String>> metadata = withAudience.getRequestMetadata(CALL_URI);

    verifyJwtAccess(metadata, SA_CLIENT_EMAIL, URI.create("new-audience"), SA_PRIVATE_KEY_ID);
  }

  @Test
  void jwtWithClaims_noAudience() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .build();
    try {
      credentials.jwtWithClaims(JwtClaims.newBuilder().build());
      fail("Expected to throw exception for missing audience");
    } catch (IllegalStateException ex) {
      // expected exception
    }
  }

  @Test
  void jwtWithClaims_defaultAudience() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(URI.create("default-audience"))
            .build();
    Credentials withAudience = credentials.jwtWithClaims(JwtClaims.newBuilder().build());

    Map<String, List<String>> metadata = withAudience.getRequestMetadata(CALL_URI);
    verifyJwtAccess(metadata, SA_CLIENT_EMAIL, URI.create("default-audience"), SA_PRIVATE_KEY_ID);
  }

  @Test
  void getRequestMetadataSetsQuotaProjectId() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setQuotaProjectId("my-quota-project-id")
            .setDefaultAudience(URI.create("default-audience"))
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata();
    assertTrue(metadata.containsKey("x-goog-user-project"));
    List<String> headerValues = metadata.get("x-goog-user-project");
    assertEquals(1, headerValues.size());
    assertEquals("my-quota-project-id", headerValues.get(0));
  }

  @Test
  void getRequestMetadataNoQuotaProjectId() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(URI.create("default-audience"))
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata();
    assertFalse(metadata.containsKey("x-goog-user-project"));
  }

  @Test
  void getRequestMetadataWithCallback() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setQuotaProjectId("my-quota-project-id")
            .setDefaultAudience(URI.create("default-audience"))
            .build();

    final Map<String, List<String>> plainMetadata = credentials.getRequestMetadata();
    final AtomicBoolean success = new AtomicBoolean(false);
    credentials.getRequestMetadata(
        null,
        null,
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            assertEquals(plainMetadata, metadata);
            success.set(true);
          }

          @Override
          public void onFailure(Throwable exception) {
            fail("Should not throw a failure.");
          }
        });

    assertTrue(success.get(), "Should have run onSuccess() callback");
  }

  @Test
  void fromJSON_noUniverseDomain() throws IOException {
    GenericJson json =
        writeServiceAccountJson(
            SA_CLIENT_ID,
            SA_CLIENT_EMAIL,
            SA_PRIVATE_KEY_PKCS8,
            "test-project-id",
            SA_PRIVATE_KEY_ID,
            QUOTA_PROJECT,
            null);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.fromJson(json, URI.create("default-aud"));
    assertEquals(SA_CLIENT_ID, credentials.getClientId());
    assertEquals(SA_CLIENT_EMAIL, credentials.getClientEmail());
    assertEquals(
        OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8), credentials.getPrivateKey());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void fromJSON_UniverseDomainSet() throws IOException {
    GenericJson json =
        writeServiceAccountJson(
            SA_CLIENT_ID,
            SA_CLIENT_EMAIL,
            SA_PRIVATE_KEY_PKCS8,
            "test-project-id",
            SA_PRIVATE_KEY_ID,
            QUOTA_PROJECT,
            "example.com");
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.fromJson(json, URI.create("default-aud"));
    assertEquals(SA_CLIENT_ID, credentials.getClientId());
    assertEquals(SA_CLIENT_EMAIL, credentials.getClientEmail());
    assertEquals(
        OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8), credentials.getPrivateKey());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals("example.com", credentials.getUniverseDomain());
  }

  @Test
  void fromPkcs8_NoUniverseDomain() throws IOException {
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.fromPkcs8(
            SA_CLIENT_ID, SA_CLIENT_EMAIL, SA_PRIVATE_KEY_PKCS8, SA_PRIVATE_KEY_ID);
    assertEquals(SA_CLIENT_ID, credentials.getClientId());
    assertEquals(SA_CLIENT_EMAIL, credentials.getClientEmail());
    assertEquals(
        OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8), credentials.getPrivateKey());
    assertNull(credentials.getQuotaProjectId());
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void fromPkcs8_CustomUniverseDomain() throws IOException {
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.fromPkcs8(
            SA_CLIENT_ID,
            SA_CLIENT_EMAIL,
            SA_PRIVATE_KEY_PKCS8,
            SA_PRIVATE_KEY_ID,
            URI.create("default-aud"),
            QUOTA_PROJECT,
            "example.com");
    assertEquals(SA_CLIENT_ID, credentials.getClientId());
    assertEquals(SA_CLIENT_EMAIL, credentials.getClientEmail());
    assertEquals(
        OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8), credentials.getPrivateKey());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals("example.com", credentials.getUniverseDomain());
  }

  @Test
  void builder_defaultUniverseDomain() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(URI.create("default-audience"))
            .build();
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void builder_customUniverseDomain() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(SA_PRIVATE_KEY_PKCS8);
    ServiceAccountJwtAccessCredentials credentials =
        ServiceAccountJwtAccessCredentials.newBuilder()
            .setClientId(SA_CLIENT_ID)
            .setClientEmail(SA_CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(SA_PRIVATE_KEY_ID)
            .setDefaultAudience(URI.create("default-audience"))
            .setUniverseDomain("example.com")
            .build();
    assertEquals("example.com", credentials.getUniverseDomain());
  }

  private void verifyJwtAccess(
      Map<String, List<String>> metadata,
      String expectedEmail,
      URI expectedAudience,
      String expectedKeyId)
      throws IOException {
    assertNotNull(metadata);
    List<String> authorizations = metadata.get(AuthHttpConstants.AUTHORIZATION);
    assertNotNull(authorizations, "Authorization headers not found");
    String assertion = null;
    for (String authorization : authorizations) {
      if (authorization.startsWith(JWT_ACCESS_PREFIX)) {
        assertNull(assertion, "Multiple bearer assertions found");
        assertion = authorization.substring(JWT_ACCESS_PREFIX.length());
      }
    }
    assertNotNull(assertion, "Bearer assertion not found");
    JsonWebSignature signature = JsonWebSignature.parse(JSON_FACTORY, assertion);
    assertEquals(expectedEmail, signature.getPayload().getIssuer());
    assertEquals(expectedEmail, signature.getPayload().getSubject());
    assertEquals(expectedAudience.toString(), signature.getPayload().getAudience());
    assertEquals(expectedKeyId, signature.getHeader().getKeyId());
  }

  private static void testFromStreamException(InputStream stream, String expectedMessageContent) {
    try {
      ServiceAccountJwtAccessCredentials.fromStream(stream, CALL_URI);
      fail(
          String.format(
              "Should throw exception with message containing '%s'", expectedMessageContent));
    } catch (IOException expected) {
      assertTrue(expected.getMessage().contains(expectedMessageContent));
    }
  }

  private GenericJson writeServiceAccountJson(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      String projectId,
      String quotaProjectId,
      String universeDomain) {
    GenericJson json = new GenericJson();
    if (clientId != null) {
      json.put("client_id", clientId);
    }
    if (clientEmail != null) {
      json.put("client_email", clientEmail);
    }
    if (privateKeyPkcs8 != null) {
      json.put("private_key", privateKeyPkcs8);
    }
    if (privateKeyId != null) {
      json.put("private_key_id", privateKeyId);
    }
    if (projectId != null) {
      json.put("project_id", projectId);
    }
    if (quotaProjectId != null) {
      json.put("quota_project_id", quotaProjectId);
    }
    if (universeDomain != null) {
      json.put("universe_domain", universeDomain);
    }
    json.put("type", GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType());
    return json;
  }
}
