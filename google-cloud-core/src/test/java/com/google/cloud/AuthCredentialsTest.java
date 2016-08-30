/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import static com.google.common.base.Charsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.AuthCredentials.OAuth2AuthCredentials;
import com.google.cloud.AuthCredentials.ServiceAccountAuthCredentials;
import com.google.common.io.BaseEncoding;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;

public class AuthCredentialsTest {

  private static final String ACCESS_TOKEN = "accessToken";
  private static final Date EXPIRATION_DATE = new Date();
  private static final String SERVICE_ACCOUNT = "someclientid@developer.gserviceaccount.com";
  private static final String PRIVATE_KEY_STRING = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoG"
      + "BAL2xolH1zrISQ8+GzOV29BNjjzq4/HIP8Psd1+cZb81vDklSF+95wB250MSE0BDc81pvIMwj5OmIfLg1NY6uB1xav"
      + "OPpVdx1z664AGc/BEJ1zInXGXaQ6s+SxGenVq40Yws57gikQGMZjttpf1Qbz4DjkxsbRoeaRHn06n9pH1ejAgMBAAE"
      + "CgYEAkWcm0AJF5LMhbWKbjkxm/LG06UNApkHX6vTOOOODkonM/qDBnhvKCj8Tan+PaU2j7679Cd19qxCm4SBQJET7e"
      + "BhqLD9L2j9y0h2YUQnLbISaqUS1/EXcr2C1Lf9VCEn1y/GYuDYqs85rGoQ4ZYfM9ClROSq86fH+cbIIssqJqukCQQD"
      + "18LjfJz/ichFeli5/l1jaFid2XoCH3T6TVuuysszVx68fh60gSIxEF/0X2xB+wuPxTP4IQ+t8tD/ktd232oWXAkEAx"
      + "XPych2QBHePk9/lek4tOkKBgfnDzex7S/pI0G1vpB3VmzBbCsokn9lpOv7JV8071GDlW/7R6jlLfpQy3hN31QJAE10"
      + "osSk99m5Uv8XDU3hvHnywDrnSFOBulNs7I47AYfSe7TSZhPkxUgsxejddTR27JLyTI8N1PxRSE4feNSOXcQJAMMKJR"
      + "JT4U6IS2rmXubREhvaVdLtxFxEnAYQ1JwNfZm/XqBMw6GEy2iaeTetNXVlZRQEIoscyn1y2v/No/F5iYQJBAKBOGAS"
      + "oQcBjGTOg/H/SfcE8QVNsKEpthRrs6CkpT80aZ/AV+ksfoIf2zw2M3mAHfrO+TBLdz4sicuFQvlN9SEc=";
  private static final String JSON_KEY = "{\n"
      + "  \"private_key_id\": \"somekeyid\",\n"
      + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\n" + PRIVATE_KEY_STRING
      + "\\n-----END PRIVATE KEY-----\\n\",\n"
      + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
      + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
      + "  \"type\": \"service_account\"\n"
      + "}";
  private static final AuthCredentials NO_AUTH_CREDENTIALS = AuthCredentials.noAuth();
  private static final OAuth2AuthCredentials OAUTH2_AUTH_CREDENTIALS =
      AuthCredentials.createFor(ACCESS_TOKEN, EXPIRATION_DATE);
  private static final byte[] BYTES_TO_SIGN = PRIVATE_KEY_STRING.getBytes(UTF_8);

  private static PrivateKey privateKey;
  private static byte[] signedBytes;

  @BeforeClass
  public static void beforeClass() throws NoSuchAlgorithmException, InvalidKeySpecException,
      InvalidKeyException, SignatureException {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    privateKey = keyFactory.generatePrivate(
        new PKCS8EncodedKeySpec(BaseEncoding.base64().decode(PRIVATE_KEY_STRING)));
    Signature signature = Signature.getInstance("SHA256withRSA");
    signature.initSign(privateKey);
    signature.update(BYTES_TO_SIGN);
    signedBytes = signature.sign();
  }

  @Test
  public void testNoAuthCredentials() {
    assertSame(NO_AUTH_CREDENTIALS, AuthCredentials.noAuth());
    assertNull(NO_AUTH_CREDENTIALS.credentials());
  }

  @Test
  public void testOAuth2AuthCredentials() {
    AccessToken accessToken = OAUTH2_AUTH_CREDENTIALS.credentials().getAccessToken();
    assertEquals(ACCESS_TOKEN, accessToken.getTokenValue());
    assertEquals(EXPIRATION_DATE, accessToken.getExpirationTime());
    OAuth2AuthCredentials oAuth2AuthCredentials =
        AuthCredentials.createFor(ACCESS_TOKEN);
    accessToken = oAuth2AuthCredentials.credentials().getAccessToken();
    assertEquals(ACCESS_TOKEN, accessToken.getTokenValue());
    assertNull(accessToken.getExpirationTime());
  }

  @Test
  public void testServiceAccountFromJson() throws IOException, SignatureException {
    ServiceAccountAuthCredentials serviceAccountAuthCredentials =
        AuthCredentials.createForJson(new ByteArrayInputStream(JSON_KEY.getBytes()));
    ServiceAccountCredentials credentials = serviceAccountAuthCredentials.credentials();
    assertEquals(SERVICE_ACCOUNT, serviceAccountAuthCredentials.account());
    assertEquals(SERVICE_ACCOUNT, credentials.getClientEmail());
    assertEquals(privateKey, credentials.getPrivateKey());
    assertArrayEquals(signedBytes, serviceAccountAuthCredentials.sign(BYTES_TO_SIGN));
  }

  @Test
  public void testServiceAccountFromKey() throws IOException, SignatureException {
    ServiceAccountAuthCredentials serviceAccountAuthCredentials =
        AuthCredentials.createFor(SERVICE_ACCOUNT, privateKey);
    ServiceAccountCredentials credentials = serviceAccountAuthCredentials.credentials();
    assertEquals(SERVICE_ACCOUNT, serviceAccountAuthCredentials.account());
    assertEquals(SERVICE_ACCOUNT, credentials.getClientEmail());
    assertEquals(privateKey, credentials.getPrivateKey());
    assertArrayEquals(signedBytes, serviceAccountAuthCredentials.sign(BYTES_TO_SIGN));
  }
}
