/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.KeyRing;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link Snippets}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SnippetsIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION_ID = "global";
  private static final String KEY_RING_ID = "test-key-ring-" + UUID.randomUUID().toString();
  private static final String CRYPTO_KEY_ID = UUID.randomUUID().toString();
  private static final String TEST_USER = "serviceAccount:"
      + "131304031188-compute@developer.gserviceaccount.com";
  private static final String TEST_ROLE = "roles/viewer";

  /**
   * Creates a CryptoKey for use during this test run.
   */
  @BeforeClass
  public static void setUpClass() throws Exception {
    KeyRing keyRing = Snippets.createKeyRing(PROJECT_ID, LOCATION_ID, KEY_RING_ID);
    assertThat(keyRing.getName()).contains("keyRings/" + KEY_RING_ID);

    CryptoKey cryptoKey = 
        Snippets.createCryptoKey(PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);
    assertThat(cryptoKey.getName()).contains(String.format(
        "keyRings/%s/cryptoKeys/%s", KEY_RING_ID, CRYPTO_KEY_ID));
  }

  /**
   * Destroys all the key versions created during this test run.
   */
  @AfterClass
  public static void tearDownClass() throws Exception {
    List<CryptoKeyVersion> versions = 
        Snippets.listCryptoKeyVersions(PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    for (CryptoKeyVersion version : versions) {
      if (!version.getState().equals(CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED)) {
        Snippets.destroyCryptoKeyVersion(
            PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, parseVersionId(version.getName()));
      }
    }
  }

  @Test
  public void listKeyRings_retrievesKeyRing() throws Exception {
    List<KeyRing> keyRings = Snippets.listKeyRings(PROJECT_ID, LOCATION_ID);
    assertThat(keyRings).isNotEmpty();
    assertThat(keyRings.get(0).getName()).contains(String.format("projects/%s", PROJECT_ID));
  }

  @Test
  public void listCryptoKeys_retrievesCryptoKeys() throws Exception {
    List<CryptoKey> keys = Snippets.listCryptoKeys(PROJECT_ID, LOCATION_ID, KEY_RING_ID);
    assertThat(keys).isNotEmpty();
    assertThat(keys.get(0).getName()).contains(
        String.format("keyRings/%s/cryptoKeys/%s", KEY_RING_ID, CRYPTO_KEY_ID));
  }

  @Test
  public void listCryptoKeyVersions_retrievesVersions() throws Exception {
    List<CryptoKeyVersion> versions = 
        Snippets.listCryptoKeyVersions(PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    for (CryptoKeyVersion version : versions) {
      assertThat(version.getName()).contains(String.format(
          "keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/", KEY_RING_ID, CRYPTO_KEY_ID));

      if (version.getState().equals(CryptoKeyVersion.CryptoKeyVersionState.ENABLED)) {
        return;
      }
    }

    // at least one version should be enabled, so we should never make it here
    assertTrue("no versions are enabled", false);
  }

  @Test
  public void disableCryptoKeyVersion_disables() throws Exception {
    CryptoKeyVersion version = Snippets.createCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);
    
    String versionId = parseVersionId(version.getName());

    CryptoKeyVersion disabled = Snippets.disableCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, versionId);
    assertThat(disabled.getState()).isEqualTo(CryptoKeyVersion.CryptoKeyVersionState.DISABLED);
  }

  @Test
  public void enableCryptoKeyVersion_enables() throws Exception {
    CryptoKeyVersion version = Snippets.createCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);
    
    String versionId = parseVersionId(version.getName());

    // Disable the new key version
    CryptoKeyVersion disabled = Snippets.disableCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, versionId);
    assertThat(disabled.getState()).isEqualTo(CryptoKeyVersion.CryptoKeyVersionState.DISABLED);

    // Enable the now-disabled key version
    CryptoKeyVersion enabled = Snippets.enableCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, versionId);
    assertThat(enabled.getState()).isEqualTo(CryptoKeyVersion.CryptoKeyVersionState.ENABLED);
  }

  @Test
  public void destroyCryptoKeyVersion_destroys() throws Exception {
    CryptoKeyVersion version = Snippets.createCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    String versionId = parseVersionId(version.getName());

    // Destroy the new key version
    CryptoKeyVersion destroyScheduled = Snippets.destroyCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, versionId);
    assertThat(destroyScheduled.getState()).isEqualTo(
        CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED);
  }


  @Test
  public void restoreCryptoKeyVersion_restores() throws Exception {
    CryptoKeyVersion version = Snippets.createCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    String versionId = parseVersionId(version.getName());

    // Only key versions scheduled for destruction are restorable, so schedule this key
    // version for destruction.
    CryptoKeyVersion destroyScheduled = Snippets.destroyCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, versionId);
    assertThat(destroyScheduled.getState()).isEqualTo(
        CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED);

    // Now restore the key version.
    CryptoKeyVersion restored = Snippets.restoreCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, versionId);
    assertThat(restored.getState()).isEqualTo(
        CryptoKeyVersion.CryptoKeyVersionState.DISABLED);
  }

  @Test
  public void setPrimaryVersion_createKeyAndSetPrimaryVersion() throws Exception {
    // We can't test that setPrimaryVersion actually took effect via a list call because of
    // caching. So we test that the call was successful.
    CryptoKeyVersion version = Snippets.createCryptoKeyVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);
    assertThat(version.getState()).isEqualTo(CryptoKeyVersion.CryptoKeyVersionState.ENABLED);

    String versionId = parseVersionId(version.getName());

    CryptoKey key = Snippets.setPrimaryVersion(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, versionId);
    assertThat(key.getPrimary().getName()).isEqualTo(version.getName());
  }

  @Test
  public void addAndRemoveMemberToCryptoKeyPolicy_addsDisplaysAndRemoves() throws Exception {
    // Retrieve the current policy
    Policy policy = Snippets.getCryptoKeyPolicy(
        PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID);

    // Make sure the policy doesn't already have our test user
    for (Binding binding : policy.getBindingsList()) {
      for (String m : binding.getMembersList()) {
        assertThat(TEST_USER).isNotEqualTo(m);
      }
    }

    try {
      // Add the test user, and make sure the policy has it
      Policy added = Snippets.addMemberToCryptoKeyPolicy(
          PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, TEST_USER, TEST_ROLE);

      for (Binding binding : added.getBindingsList()) {
        for (String m : binding.getMembersList()) {
          if (TEST_USER.equals(m)) {
            return;
          }
        }
      }

      // We should've returned in the previous loop; fail if we didn't.
      assertTrue("No policy binding containing TEST_USER exists", false);
    } finally {
      // Now remove the test user, and make sure the policy no longer has it
      Policy removed = Snippets.removeMemberFromCryptoKeyPolicy(
          PROJECT_ID, LOCATION_ID, KEY_RING_ID, CRYPTO_KEY_ID, TEST_USER, TEST_ROLE);
      for (Binding binding : removed.getBindingsList()) {
        for (String m : binding.getMembersList()) {
          assertThat(TEST_USER).isNotEqualTo(m);
        }
      }
    }
  }

  @Test
  public void addAndRemoveMemberToKeyRingPolicy_addsDisplaysAndRemoves() throws Exception {
    // Retrieve the current policy
    Policy policy = Snippets.getKeyRingPolicy(PROJECT_ID, LOCATION_ID, KEY_RING_ID);

    // Make sure the policy doesn't already have our test user
    for (Binding binding : policy.getBindingsList()) {
      for (String m : binding.getMembersList()) {
        assertThat(TEST_USER).isNotEqualTo(m);
      }
    }

    try {
      // Add the test user, and make sure the policy has it
      Policy added = Snippets.addMemberToKeyRingPolicy(
          PROJECT_ID, LOCATION_ID, KEY_RING_ID, TEST_USER, TEST_ROLE);

      for (Binding binding : added.getBindingsList()) {
        for (String m : binding.getMembersList()) {
          if (TEST_USER.equals(m)) {
            return;
          }
        }
      }

      // We should've returned in the previous loop; fail if we didn't.
      assertTrue("No policy binding containing TEST_USER exists", false);
    } finally {
      // Now remove the test user, and make sure the policy no longer has it
      Policy removed = Snippets.removeMemberFromKeyRingPolicy(
          PROJECT_ID, LOCATION_ID, KEY_RING_ID, TEST_USER, TEST_ROLE);
      for (Binding binding : removed.getBindingsList()) {
        for (String m : binding.getMembersList()) {
          assertThat(TEST_USER).isNotEqualTo(m);
        }
      }
    }
  }

  public static String parseVersionId(String versionName) {
    Pattern versionIdPattern = Pattern.compile(".*/cryptoKeyVersions/(\\d+)");
    Matcher matcher = versionIdPattern.matcher(versionName);
    assertThat(matcher.find()).isTrue();
    return matcher.group(1);
  }
}
