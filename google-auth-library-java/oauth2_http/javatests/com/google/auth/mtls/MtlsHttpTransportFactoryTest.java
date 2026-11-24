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
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.SecurityUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.SequenceInputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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

  @Test
  void serialization_roundTrip_hasKeyStoreReturnsFalse() throws Exception {
    KeyStore keyStore;
    try (InputStream certStream = new FileInputStream(new File(TEST_CERT_PATH));
        InputStream keyStream = new FileInputStream(new File(TEST_KEY_PATH));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      keyStore = SecurityUtils.createMtlsKeyStore(combined);
    }

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(keyStore);
    assertTrue(factory.hasKeyStore());

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(factory);
    }

    MtlsHttpTransportFactory deserialized;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserialized = (MtlsHttpTransportFactory) ois.readObject();
    }

    assertNotNull(deserialized);
    assertFalse(deserialized.hasKeyStore());
  }

  @Test
  void hasKeyStore_cachesStateAtConstructionTime() throws Exception {
    KeyStore keyStore;
    try (InputStream certStream = new FileInputStream(new File(TEST_CERT_PATH));
        InputStream keyStream = new FileInputStream(new File(TEST_KEY_PATH));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      keyStore = SecurityUtils.createMtlsKeyStore(combined);
    }

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(keyStore);
    assertTrue(factory.hasKeyStore());

    // Mutate the KeyStore after construction by deleting all entries
    Enumeration<String> aliases = keyStore.aliases();
    while (aliases.hasMoreElements()) {
      keyStore.deleteEntry(aliases.nextElement());
    }
    assertEquals(0, keyStore.size());

    // hasKeyStore() should still return the cached true value evaluated at construction
    assertTrue(factory.hasKeyStore());
  }

  private static KeyStore loadTestMtlsKeyStore() throws Exception {
    try (InputStream certStream = new FileInputStream(new File(TEST_CERT_PATH));
        InputStream keyStream = new FileInputStream(new File(TEST_KEY_PATH));
        InputStream combined = new SequenceInputStream(certStream, keyStream)) {
      return SecurityUtils.createMtlsKeyStore(combined);
    }
  }

  @Test
  void create_reusesSameNetHttpTransportInstance() throws Exception {
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(loadTestMtlsKeyStore());

    NetHttpTransport first = factory.create();
    NetHttpTransport second = factory.create();

    assertNotNull(first);
    assertSame(first, second);
  }

  @Test
  void create_concurrentCalls_returnSameNetHttpTransportInstance() throws Exception {
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(loadTestMtlsKeyStore());
    int threadCount = 8;
    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    CountDownLatch readyLatch = new CountDownLatch(threadCount);
    CountDownLatch startLatch = new CountDownLatch(1);
    try {
      List<Future<NetHttpTransport>> futures = new ArrayList<>();
      for (int i = 0; i < threadCount; i++) {
        futures.add(
            executor.submit(
                () -> {
                  readyLatch.countDown();
                  assertTrue(startLatch.await(10, TimeUnit.SECONDS));
                  return factory.create();
                }));
      }
      assertTrue(readyLatch.await(10, TimeUnit.SECONDS));
      startLatch.countDown();

      NetHttpTransport first = futures.get(0).get(30, TimeUnit.SECONDS);
      assertNotNull(first);
      for (Future<NetHttpTransport> future : futures) {
        assertSame(first, future.get(30, TimeUnit.SECONDS));
      }
    } finally {
      executor.shutdownNow();
      executor.awaitTermination(5, TimeUnit.SECONDS);
    }
  }

  @Test
  void create_uninitializedKeyStore_throwsAndDoesNotCacheFailure() throws Exception {
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(keyStore);

    RuntimeException exception = assertThrows(RuntimeException.class, factory::create);
    assertTrue(exception.getCause() instanceof GeneralSecurityException);

    keyStore.load(null, null);
    NetHttpTransport first = factory.create();
    NetHttpTransport second = factory.create();
    assertNotNull(first);
    assertSame(first, second);
  }

  @Test
  void serialization_roundTripAfterCreate_succeedsAndCachesNewTransport() throws Exception {
    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(loadTestMtlsKeyStore());
    NetHttpTransport beforeSerialization = factory.create();
    assertNotNull(beforeSerialization);
    assertTrue(beforeSerialization.isMtls());

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(factory);
    }

    MtlsHttpTransportFactory deserialized;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserialized = (MtlsHttpTransportFactory) ois.readObject();
    }

    assertNotNull(deserialized);
    assertFalse(deserialized.hasKeyStore());
    assertNull(deserialized.getKeyStore());
    NetHttpTransport afterDeserialization = deserialized.create();
    assertNotNull(afterDeserialization);
    assertFalse(afterDeserialization.isMtls());
    assertNotSame(beforeSerialization, afterDeserialization);
    assertSame(afterDeserialization, deserialized.create());
  }
}
