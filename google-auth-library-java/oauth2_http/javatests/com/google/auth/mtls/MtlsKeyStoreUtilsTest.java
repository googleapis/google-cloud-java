/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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

package com.google.auth.mtls;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class MtlsKeyStoreUtilsTest {

  // Leaf (CN=Test Leaf) followed by the intermediate that signed it (CN=Test Intermediate CA).
  static final String CHAIN_CERT_PATH = "testresources/mtls/test_chain_cert.pem";
  // PKCS#8 private key for the leaf in CHAIN_CERT_PATH.
  static final String CHAIN_KEY_PATH = "testresources/mtls/test_chain_key.pem";
  private static final String SINGLE_CERT_PATH = "testresources/mtls/test_cert.pem";
  private static final String SINGLE_KEY_PATH = "testresources/mtls/test_key.pem";

  @Test
  void createMtlsKeyStore_certificatesFirst_keepsFullChainInOrder() throws Exception {
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(stream(read(CHAIN_CERT_PATH), read(CHAIN_KEY_PATH)));

    Certificate[] chain = keyStore.getCertificateChain(onlyAlias(keyStore));
    assertEquals(2, chain.length);
    assertEquals("CN=Test Leaf", subject(chain[0]));
    assertEquals("CN=Test Intermediate CA", subject(chain[1]));
  }

  @Test
  void createMtlsKeyStore_keyFirst_keepsFullChainInOrder() throws Exception {
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(stream(read(CHAIN_KEY_PATH), read(CHAIN_CERT_PATH)));

    Certificate[] chain = keyStore.getCertificateChain(onlyAlias(keyStore));
    assertEquals(2, chain.length);
    assertEquals("CN=Test Leaf", subject(chain[0]));
    assertEquals("CN=Test Intermediate CA", subject(chain[1]));
  }

  @Test
  void createMtlsKeyStore_privateKeyMatchesLeaf() throws Exception {
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(stream(read(CHAIN_CERT_PATH), read(CHAIN_KEY_PATH)));
    String alias = onlyAlias(keyStore);
    PrivateKey key = (PrivateKey) keyStore.getKey(alias, new char[] {});
    Certificate leaf = keyStore.getCertificateChain(alias)[0];

    byte[] data = "chain".getBytes(UTF_8);
    Signature signer = Signature.getInstance("SHA256withECDSA");
    signer.initSign(key);
    signer.update(data);
    byte[] signature = signer.sign();
    Signature verifier = Signature.getInstance("SHA256withECDSA");
    verifier.initVerify(leaf.getPublicKey());
    verifier.update(data);
    assertTrue(verifier.verify(signature));
  }

  @Test
  void createMtlsKeyStore_singleCertificate_sameAsBefore() throws Exception {
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(stream(read(SINGLE_CERT_PATH), read(SINGLE_KEY_PATH)));
    KeyStore expected =
        com.google.api.client.util.SecurityUtils.createMtlsKeyStore(
            stream(read(SINGLE_CERT_PATH), read(SINGLE_KEY_PATH)));

    String alias = onlyAlias(keyStore);
    assertEquals(Collections.list(expected.aliases()), Collections.list(keyStore.aliases()));
    assertEquals(expected.getType(), keyStore.getType());
    Certificate[] chain = keyStore.getCertificateChain(alias);
    assertEquals(1, chain.length);
    assertArrayEquals(expected.getCertificate(alias).getEncoded(), chain[0].getEncoded());
    assertArrayEquals(
        expected.getKey(alias, new char[] {}).getEncoded(),
        keyStore.getKey(alias, new char[] {}).getEncoded());
  }

  @Test
  void createMtlsKeyStore_ignoresOtherSections() throws Exception {
    String other = "-----BEGIN EC PARAMETERS-----\nBggqhkjOPQMBBw==\n-----END EC PARAMETERS-----\n";
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(
            stream(other, read(CHAIN_CERT_PATH), other, read(CHAIN_KEY_PATH)));

    assertEquals(2, keyStore.getCertificateChain(onlyAlias(keyStore)).length);
  }

  @Test
  void createMtlsKeyStore_severalPrivateKeys_usesFirst() throws Exception {
    // The leaf key is EC; the second key (RSA) must not be used.
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(
            stream(read(CHAIN_CERT_PATH), read(CHAIN_KEY_PATH), read(SINGLE_KEY_PATH)));

    assertEquals("EC", keyStore.getKey(onlyAlias(keyStore), new char[] {}).getAlgorithm());
  }

  @Test
  void createMtlsKeyStore_malformedTrailingSection_ignored() throws Exception {
    // A section with no end tag after a usable certificate and key. The upstream method stopped
    // reading before reaching it, so it must not cause a failure now.
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(
            stream(
                read(CHAIN_CERT_PATH), read(CHAIN_KEY_PATH), "-----BEGIN CERTIFICATE-----\nAAAA"));

    assertEquals(2, keyStore.getCertificateChain(onlyAlias(keyStore)).length);
  }

  @Test
  void createMtlsKeyStore_unparsableExtraCertificate_leftOut() throws Exception {
    String[] leafAndIntermediate = read(CHAIN_CERT_PATH).split("(?<=-----END CERTIFICATE-----)\n");
    String bad = "-----BEGIN CERTIFICATE-----\nAAAA\n-----END CERTIFICATE-----";
    KeyStore keyStore =
        MtlsKeyStoreUtils.createMtlsKeyStore(
            stream(leafAndIntermediate[0], bad, leafAndIntermediate[1], read(CHAIN_KEY_PATH)));

    Certificate[] chain = keyStore.getCertificateChain(onlyAlias(keyStore));
    assertEquals(2, chain.length);
    assertEquals("CN=Test Leaf", subject(chain[0]));
    assertEquals("CN=Test Intermediate CA", subject(chain[1]));
  }

  @Test
  void createMtlsKeyStore_unparsableLeaf_throws() throws Exception {
    String bad = "-----BEGIN CERTIFICATE-----\nAAAA\n-----END CERTIFICATE-----";
    assertThrows(
        CertificateException.class,
        () ->
            MtlsKeyStoreUtils.createMtlsKeyStore(
                stream(bad, read(CHAIN_CERT_PATH), read(CHAIN_KEY_PATH))));
  }

  @Test
  void createMtlsKeyStore_missingCertificate_throws() throws Exception {
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> MtlsKeyStoreUtils.createMtlsKeyStore(stream(read(CHAIN_KEY_PATH))));
    assertEquals("certificate is missing from certAndKey string", e.getMessage());
  }

  @Test
  void createMtlsKeyStore_missingPrivateKey_throws() throws Exception {
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () -> MtlsKeyStoreUtils.createMtlsKeyStore(stream(read(CHAIN_CERT_PATH))));
    assertEquals("private key is missing from certAndKey string", e.getMessage());
  }

  static String read(String path) throws IOException {
    return new String(Files.readAllBytes(new File(path).toPath()), UTF_8);
  }

  /** Asserts the key store's single entry holds the test leaf followed by its intermediate. */
  static void assertLeafThenIntermediate(KeyStore keyStore) throws Exception {
    Certificate[] chain = keyStore.getCertificateChain(onlyAlias(keyStore));
    assertEquals(2, chain.length);
    assertEquals("CN=Test Leaf", subject(chain[0]));
    assertEquals("CN=Test Intermediate CA", subject(chain[1]));
  }

  private static ByteArrayInputStream stream(String... parts) {
    return new ByteArrayInputStream(String.join("\n", parts).getBytes(UTF_8));
  }

  private static String onlyAlias(KeyStore keyStore) throws Exception {
    assertEquals(1, keyStore.size());
    String alias = keyStore.aliases().nextElement();
    assertNotNull(keyStore.getCertificateChain(alias));
    return alias;
  }

  private static String subject(Certificate certificate) {
    return ((X509Certificate) certificate).getSubjectX500Principal().getName();
  }
}
