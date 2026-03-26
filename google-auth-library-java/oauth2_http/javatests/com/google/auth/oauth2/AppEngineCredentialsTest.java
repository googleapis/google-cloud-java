/*
 * Copyright 2016, Google Inc. All rights reserved.
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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AppEngineCredentialsTest extends BaseSerializationTest {

  private static final String EXPECTED_ACCESS_TOKEN = "ExpectedAccessToken";
  private static final Date EXPECTED_EXPIRATION_DATE =
      new Date(System.currentTimeMillis() + 60L * 60L * 100L);
  private static final byte[] EXPECTED_SIGNATURE = {0xD, 0xE, 0xA, 0xD};
  private static final String EXPECTED_ACCOUNT = "serviceAccount";

  private static final Collection<String> SCOPES =
      Collections.unmodifiableCollection(Arrays.asList("scope1", "scope2"));
  private static final Collection<String> DEFAULT_SCOPES = Collections.singletonList("scope3");

  @Test
  void constructor_usesAppIdentityService() throws IOException {
    Collection<String> scopes = Collections.singleton("SomeScope");
    TestAppEngineCredentials credentials = new TestAppEngineCredentials(scopes);
    List<String> forNameArgs = credentials.getForNameArgs();
    assertEquals(4, forNameArgs.size());
    assertEquals(AppEngineCredentials.APP_IDENTITY_SERVICE_FACTORY_CLASS, forNameArgs.get(0));
    assertEquals(AppEngineCredentials.APP_IDENTITY_SERVICE_CLASS, forNameArgs.get(1));
    assertEquals(AppEngineCredentials.GET_ACCESS_TOKEN_RESULT_CLASS, forNameArgs.get(2));
    assertEquals(AppEngineCredentials.SIGNING_RESULT_CLASS, forNameArgs.get(3));
  }

  @Test
  void constructor_noAppEngineRuntime_throwsHelpfulLoadError() {
    try {
      new TestAppEngineCredentialsNoSdk();
      fail("Credential expected to fail to load if credential class not present.");
    } catch (IOException e) {
      String message = e.getMessage();
      assertTrue(message.contains("Check that the App Engine SDK is deployed."));
      assertInstanceOf(ClassNotFoundException.class, e.getCause());
      assertTrue(
          e.getCause()
              .getMessage()
              .contains(AppEngineCredentials.APP_IDENTITY_SERVICE_FACTORY_CLASS));
    }
  }

  @Test
  void refreshAccessToken_sameAs() throws IOException {
    TestAppEngineCredentials credentials = new TestAppEngineCredentials(SCOPES);
    AccessToken accessToken = credentials.refreshAccessToken();
    assertEquals(EXPECTED_ACCESS_TOKEN, accessToken.getTokenValue());
    assertEquals(EXPECTED_EXPIRATION_DATE, accessToken.getExpirationTime());
  }

  @Test
  void getAccount_sameAs() throws IOException {
    TestAppEngineCredentials credentials = new TestAppEngineCredentials(SCOPES);
    assertEquals(EXPECTED_ACCOUNT, credentials.getAccount());
  }

  @Test
  void sign_sameAs() throws IOException {
    TestAppEngineCredentials credentials = new TestAppEngineCredentials(SCOPES);
    assertArrayEquals(EXPECTED_SIGNATURE, credentials.sign("Bytes to sign".getBytes()));
  }

  @Test
  void createScoped_clonesWithScopes() throws IOException {
    TestAppEngineCredentials credentials = new TestAppEngineCredentials(null);
    assertTrue(credentials.createScopedRequired());
    try {
      credentials.refreshAccessToken();
      fail("Should not be able to use credential without scopes.");
    } catch (Exception expected) {
      // Expected
    }

    GoogleCredentials scopedCredentials = credentials.createScoped(SCOPES);
    assertNotSame(credentials, scopedCredentials);

    AccessToken accessToken = scopedCredentials.refreshAccessToken();
    assertEquals(EXPECTED_ACCESS_TOKEN, accessToken.getTokenValue());
    assertEquals(EXPECTED_EXPIRATION_DATE, accessToken.getExpirationTime());
  }

  @Test
  void createScoped_defaultScopes() throws IOException {
    TestAppEngineCredentials credentials = new TestAppEngineCredentials(null);
    assertTrue(credentials.createScopedRequired());

    GoogleCredentials newCredentials = credentials.createScoped(null, DEFAULT_SCOPES);
    assertFalse(newCredentials.createScopedRequired());

    newCredentials = credentials.createScoped(SCOPES, null);
    assertFalse(newCredentials.createScopedRequired());

    newCredentials = credentials.createScoped(SCOPES, DEFAULT_SCOPES);
    assertFalse(newCredentials.createScopedRequired());

    AccessToken accessToken = newCredentials.refreshAccessToken();
    assertEquals(EXPECTED_ACCESS_TOKEN, accessToken.getTokenValue());
    assertEquals(EXPECTED_EXPIRATION_DATE, accessToken.getExpirationTime());
  }

  @Test
  void equals_true() throws IOException {
    GoogleCredentials credentials = new TestAppEngineCredentials(SCOPES);
    GoogleCredentials otherCredentials = new TestAppEngineCredentials(SCOPES);
    assertEquals(credentials, otherCredentials);
    assertEquals(otherCredentials, credentials);
  }

  @Test
  void equals_false_scopes() throws IOException {
    final Collection<String> emptyScopes = Collections.emptyList();
    Collection<String> scopes = Collections.singleton("SomeScope");
    AppEngineCredentials credentials = new TestAppEngineCredentials(emptyScopes);
    AppEngineCredentials otherCredentials = new TestAppEngineCredentials(scopes);
    assertNotEquals(credentials, otherCredentials);
    assertNotEquals(otherCredentials, credentials);
  }

  @Test
  void toString_containsFields() throws IOException {
    String expectedToString =
        String.format(
            "TestAppEngineCredentials{scopes=[%s], scopesRequired=%b}", "SomeScope", false);
    Collection<String> scopes = Collections.singleton("SomeScope");
    AppEngineCredentials credentials = new TestAppEngineCredentials(scopes);
    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void hashCode_equals() throws IOException {
    AppEngineCredentials credentials = new TestAppEngineCredentials(SCOPES);
    assertEquals(credentials.hashCode(), credentials.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    Collection<String> scopes = Collections.singleton("SomeScope");
    AppEngineCredentials credentials = new TestAppEngineCredentials(scopes);
    GoogleCredentials deserializedCredentials = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
  }

  private static class TestSigningResult {

    private final byte[] signature;

    TestSigningResult(byte[] signature) {
      this.signature = signature;
    }

    public byte[] getSignature() {
      return this.signature;
    }
  }

  private static class TestAppIdentityServiceFactory {

    public static TestAppIdentityService getAppIdentityService() {
      return new TestAppIdentityService();
    }
  }

  private static class TestAppIdentityService {

    public TestGetAccessTokenResult getAccessToken(Iterable<String> scopes) {
      return new TestGetAccessTokenResult(EXPECTED_ACCESS_TOKEN, EXPECTED_EXPIRATION_DATE);
    }

    public String getServiceAccountName() {
      return EXPECTED_ACCOUNT;
    }

    public TestSigningResult signForApp(byte[] toSign) {
      return new TestSigningResult(EXPECTED_SIGNATURE);
    }
  }

  private static class TestGetAccessTokenResult {

    private final String accessToken;
    private final Date expirationTime;

    TestGetAccessTokenResult(String accessToken, Date expirationTime) {
      this.accessToken = accessToken;
      this.expirationTime = expirationTime;
    }

    public String getAccessToken() {
      return this.accessToken;
    }

    public Date getExpirationTime() {
      return this.expirationTime;
    }
  }

  private static class TestAppEngineCredentials extends AppEngineCredentials {

    private static final long serialVersionUID = -5191475572296306231L;

    private static final Map<String, Class<?>> TYPES =
        ImmutableMap.of(
            AppEngineCredentials.APP_IDENTITY_SERVICE_FACTORY_CLASS,
            TestAppIdentityServiceFactory.class,
            AppEngineCredentials.APP_IDENTITY_SERVICE_CLASS,
            TestAppIdentityService.class,
            AppEngineCredentials.GET_ACCESS_TOKEN_RESULT_CLASS,
            TestGetAccessTokenResult.class,
            AppEngineCredentials.SIGNING_RESULT_CLASS,
            TestSigningResult.class);
    private List<String> forNameArgs;

    TestAppEngineCredentials(Collection<String> scopes) throws IOException {
      super(scopes, null);
    }

    TestAppEngineCredentials(Collection<String> scopes, Collection<String> defaultScopes)
        throws IOException {
      super(scopes, defaultScopes);
    }

    @Override
    Class<?> forName(String className) throws ClassNotFoundException {
      if (forNameArgs == null) {
        forNameArgs = new ArrayList<>();
      }
      forNameArgs.add(className);
      Class<?> lookup = TYPES.get(className);
      if (lookup != null) {
        return lookup;
      }
      throw new ClassNotFoundException(className);
    }

    List<String> getForNameArgs() {
      return forNameArgs;
    }
  }

  private static class TestAppEngineCredentialsNoSdk extends AppEngineCredentials {

    private static final long serialVersionUID = -8987103249265111274L;

    TestAppEngineCredentialsNoSdk() throws IOException {
      super(null, null);
    }

    @Override
    Class<?> forName(String className) throws ClassNotFoundException {
      throw new ClassNotFoundException(className);
    }
  }
}
