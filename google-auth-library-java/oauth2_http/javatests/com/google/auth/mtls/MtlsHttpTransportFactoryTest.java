/*
 * Copyright 2026 Google LLC
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
 *    * Neither the name of Google LLC nor the names of its
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.SecurityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import org.junit.jupiter.api.Test;

class MtlsHttpTransportFactoryTest {

  private static final String TEST_CERT_PATH = "testresources/mtls/test_cert.pem";
  private static final String TEST_KEY_PATH = "testresources/mtls/test_key.pem";

  @Test
  void hasKeyStore_noArgConstructor_returnsFalse() {
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory();
    assertFalse(factory.hasKeyStore());
  }

  @Test
  void hasKeyStore_emptyKeyStore_returnsFalse() throws Exception {
    KeyStore emptyKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    emptyKeyStore.load(null, null);
    assertEquals(0, emptyKeyStore.size());

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(emptyKeyStore);
    assertFalse(factory.hasKeyStore());
  }

  @Test
  void hasKeyStore_keyStoreWithOnlyCaCertificates_returnsFalse() throws Exception {
    KeyStore caKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    caKeyStore.load(null, null);

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    try (FileInputStream fis = new FileInputStream(new File(TEST_CERT_PATH))) {
      Certificate cert = cf.generateCertificate(fis);
      caKeyStore.setCertificateEntry("ca-alias", cert);
    }
    assertEquals(1, caKeyStore.size());

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(caKeyStore);
    assertFalse(factory.hasKeyStore());
  }

  @Test
  void hasKeyStore_keyStoreWithPrivateKeyAndCertChain_returnsTrue() throws Exception {
    KeyStore keyStore;
    try (InputStream certStream = new FileInputStream(new File(TEST_CERT_PATH));
        InputStream keyStream = new FileInputStream(new File(TEST_KEY_PATH));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      keyStore = SecurityUtils.createMtlsKeyStore(combined);
    }

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(keyStore);
    assertTrue(factory.hasKeyStore());
  }

  @Test
  void hasKeyStore_uninitializedKeyStore_returnsFalse() throws Exception {
    KeyStore uninitializedKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    // KeyStore.size() on uninitialized KeyStore throws KeyStoreException
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(uninitializedKeyStore);
    assertFalse(factory.hasKeyStore());
  }

  @Test
  void constructor_nullKeyStore_throwsNullPointerException() {
    assertThrows(NullPointerException.class, () -> new MtlsHttpTransportFactory(null));
  }

  @Test
  void create_returnsNetHttpTransport() throws Exception {
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    keyStore.load(null, null);

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(keyStore);
    NetHttpTransport transport = factory.create();
    assertNotNull(transport);
  }
}
