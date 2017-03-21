/*
 * Copyright (c) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Integration (system) tests for {@link Snippets}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SnippetsIT {

  static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  static final String KEY_RING_ID = "test-snippets-key-ring";
  static final String CRYPTO_KEY_ID = "test-snippets-crypto-key";
  static final String TEST_USER = "serviceAccount:"
      + "131304031188-compute@developer.gserviceaccount.com";
  static final String TEST_ROLE = "roles/viewer";
  static final String ENCRYPT_STRING = "Everyone shall sit under their own vine and fig tree";

  private static PrintStream realOut;

  private ByteArrayOutputStream bout;
  private PrintStream out;

  @BeforeClass
  public static void setUpClass() throws Exception {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    realOut = System.out;
    System.setOut(out);

    // Since you can't delete keyrings & cryptokeys atm, these tests assume they already exist.
    // Use the snippets functions to create them.
    try {
      Snippets.createKeyRing(PROJECT_ID, KEY_RING_ID);

      // Since there's no way to delete keyrings atm, have two branches - one for the first time the
      // test is run, one for after the key already exists
      assertThat(bout.toString()).contains("keyRings/" + KEY_RING_ID);

    } catch (GoogleJsonResponseException e) {
      GoogleJsonError error = e.getDetails();
      assertThat(error.getCode()).isEqualTo(409);
      assertThat(error.getMessage()).contains("keyRings/" + KEY_RING_ID);
    }

    try {
      Snippets.createCryptoKey(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);

      // Since there's no way to delete keyrings atm, have two branches - one for the first time the
      // test is run, one for after the key already exists
      assertThat(bout.toString()).contains(String.format(
          "keyRings/%s/cryptoKeys/%s", KEY_RING_ID, CRYPTO_KEY_ID));

    } catch (GoogleJsonResponseException e) {
      GoogleJsonError error = e.getDetails();
      assertThat(error.getCode()).isEqualTo(409);
      assertThat(error.getMessage()).contains(String.format(
          "keyRings/%s/cryptoKeys/%s", KEY_RING_ID, CRYPTO_KEY_ID));
    }
  }

  /**
   * Destroys all the keys created during this test run.
   */
  @AfterClass
  public static void tearDownClass() throws Exception {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);

    String stdout;
    try {
      Snippets.listCryptoKeyVersions(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);
      stdout = bout.toString();
    } finally {
      System.setOut(realOut);
    }

    String[] lines = stdout.split("\n");
    Pattern keyVersion = Pattern.compile(
        ".*cryptoKeyVersions/(\\d+)\",\"state\":\"(EN|DIS)ABLED\".*",
        Pattern.DOTALL | Pattern.MULTILINE);

    for (String line : lines) {
      Matcher matcher = keyVersion.matcher(line);
      if (!matcher.matches()) {
        continue;
      }

      String version = matcher.group(1);
      Snippets.destroyCryptoKeyVersion(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID, version);
    }
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    Snippets.createCryptoKeyVersion(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);
  }

  @After
  public void tearDown() {
    System.setOut(realOut);
  }

  @Test
  public void listKeyRings_printsKeyRing() throws Exception {
    Snippets.listKeyRings(PROJECT_ID);

    assertThat(bout.toString()).contains(String.format("keyRings/%s", KEY_RING_ID));
  }

  @Test
  public void listCryptoKeys_printsCryptoKeys() throws Exception {
    Snippets.listCryptoKeys(PROJECT_ID, KEY_RING_ID);

    assertThat(bout.toString()).contains(
        String.format("keyRings/%s/cryptoKeys/%s", KEY_RING_ID, CRYPTO_KEY_ID));
  }

  @Test
  public void listCryptoKeyVersions_printsVersions() throws Exception {
    Snippets.listCryptoKeyVersions(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    assertThat(bout.toString()).containsMatch(String.format(
        "keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/\\d+\",\"state\":\"ENABLED\"",
        KEY_RING_ID, CRYPTO_KEY_ID));
  }

  @Test
  public void disableCryptoKeyVersion_disables() throws Exception {
    Snippets.listCryptoKeyVersions(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    Matcher matcher = Pattern.compile(".*cryptoKeyVersions/(\\d+)\",\"state\":\"ENABLED\".*",
        Pattern.DOTALL | Pattern.MULTILINE).matcher(bout.toString().trim());
    assertTrue(matcher.matches());
    String version = matcher.group(1);

    Snippets.disableCryptoKeyVersion(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID, version);
    assertThat(bout.toString()).containsMatch(String.format(
        "keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s\",\"state\":\"DISABLED\"",
        KEY_RING_ID, CRYPTO_KEY_ID, version));
  }

  @Test
  public void destroyCryptoKeyVersion_destroys() throws Exception {
    Snippets.listCryptoKeyVersions(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    Matcher matcher = Pattern.compile(".*cryptoKeyVersions/(\\d+)\",\"state\":\"ENABLED\".*",
        Pattern.DOTALL | Pattern.MULTILINE).matcher(bout.toString().trim());
    assertTrue(matcher.matches());

    String version = matcher.group(1);

    Snippets.destroyCryptoKeyVersion(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID, version);

    assertThat(bout.toString()).containsMatch(String.format(
        "keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s\",\"state\":\"DESTROY_SCHEDULED\"",
        KEY_RING_ID, CRYPTO_KEY_ID, version));
  }

  @Test
  public void addAndRemoveMemberToCryptoKeyPolicy_addsDisplaysAndRemoves() throws Exception {
    // Make sure the policy doesn't already have our test user
    Snippets.getCryptoKeyPolicy(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    assertThat(bout.toString()).doesNotContainMatch(TEST_USER);

    try {
      // Add the test user, and make sure the policy has it
      Snippets.addMemberToCryptoKeyPolicy(
          PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID, TEST_USER, TEST_ROLE);

      Snippets.getCryptoKeyPolicy(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);

      assertThat(bout.toString()).containsMatch(TEST_USER);

      // Now remove the test user, and make sure the policy no longer has it
      bout.reset();
    } finally {
      Snippets.removeMemberFromCryptoKeyPolicy(
          PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID, TEST_USER, TEST_ROLE);
    }

    assertThat(bout.toString()).doesNotContainMatch("Response:.*" + TEST_USER);

    bout.reset();
    Snippets.getCryptoKeyPolicy(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    assertThat(bout.toString()).doesNotContainMatch(TEST_USER);
  }

  @Test
  public void addAndRemoveMemberToKeyRingPolicy_addsDisplaysAndRemoves() throws Exception {
    // Make sure the policy doesn't already have our test user
    Snippets.getKeyRingPolicy(PROJECT_ID, KEY_RING_ID);

    assertThat(bout.toString()).doesNotContainMatch(TEST_USER);

    try {
      // Add the test user, and make sure the policy has it
      Snippets.addMemberToKeyRingPolicy(
          PROJECT_ID, KEY_RING_ID, TEST_USER, TEST_ROLE);

      Snippets.getKeyRingPolicy(PROJECT_ID, KEY_RING_ID);

      assertThat(bout.toString()).containsMatch(TEST_USER);

      // Now remove the test user, and make sure the policy no longer has it
      bout.reset();
    } finally {
      Snippets.removeMemberFromKeyRingPolicy(
          PROJECT_ID, KEY_RING_ID, TEST_USER, TEST_ROLE);
    }

    assertThat(bout.toString()).doesNotContainMatch("Response:.*" + TEST_USER);

    bout.reset();
    Snippets.getKeyRingPolicy(PROJECT_ID, KEY_RING_ID);

    assertThat(bout.toString()).doesNotContainMatch(TEST_USER);
  }

  @Test
  public void encryptDecrypt_encryptsAndDecrypts() throws Exception {
    // Get an enabled crypto key version, since the primary version is likely disabled
    Snippets.listCryptoKeyVersions(PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID);
    Matcher matcher = Pattern.compile(".*cryptoKeyVersions/(\\d+)\",\"state\":\"ENABLED\".*",
        Pattern.DOTALL | Pattern.MULTILINE).matcher(bout.toString().trim());
    assertTrue(matcher.matches());
    String version = matcher.group(1);

    byte[] encrypted = CryptFile.encrypt(
        PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID, version, ENCRYPT_STRING.getBytes());

    assertThat(new String(encrypted)).isNotEqualTo(ENCRYPT_STRING);

    byte[] decrypted = CryptFile.decrypt(
        PROJECT_ID, KEY_RING_ID, CRYPTO_KEY_ID, encrypted);

    assertThat(new String(decrypted)).isEqualTo(ENCRYPT_STRING);
  }
}
