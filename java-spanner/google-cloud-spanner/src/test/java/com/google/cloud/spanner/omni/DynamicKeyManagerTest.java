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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import io.grpc.netty.shaded.io.netty.handler.ssl.util.SelfSignedCertificate;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DynamicKeyManagerTest {

  @Rule public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test
  public void testInitialLoadAndDynamicRotation() throws Exception {
    SelfSignedCertificate ssc1 = new SelfSignedCertificate("spanner.test.1");
    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.2");
    try {
      File certFile = tempFolder.newFile("client.crt");
      File keyFile = tempFolder.newFile("client.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc1.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc1.privateKey().toPath()));

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 0L);

      String alias1 = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertNotNull(alias1);
      assertEquals(alias1, keyManager.chooseEngineClientAlias(new String[] {"RSA"}, null, null));

      X509Certificate[] chain1 = keyManager.getCertificateChain(alias1);
      assertNotNull(chain1);
      assertEquals(1, chain1.length);
      assertEquals(ssc1.cert().getSubjectDN(), chain1[0].getSubjectDN());

      PrivateKey pk1 = keyManager.getPrivateKey(alias1);
      assertNotNull(pk1);
      assertEquals(ssc1.key().getAlgorithm(), pk1.getAlgorithm());

      String[] aliases1 = keyManager.getClientAliases("RSA", null);
      assertNotNull(aliases1);
      assertEquals(1, aliases1.length);
      assertEquals(alias1, aliases1[0]);

      Files.write(certFile.toPath(), Files.readAllBytes(ssc2.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc2.privateKey().toPath()));
      certFile.setLastModified(System.currentTimeMillis() + 2000L);
      keyFile.setLastModified(System.currentTimeMillis() + 2000L);

      String alias2 = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertNotNull(alias2);

      X509Certificate[] chain2 = keyManager.getCertificateChain(alias2);
      assertNotNull(chain2);
      assertEquals(ssc2.cert().getSubjectDN(), chain2[0].getSubjectDN());

      PrivateKey pk2 = keyManager.getPrivateKey(alias2);
      assertNotNull(pk2);
    } finally {
      ssc1.delete();
      ssc2.delete();
    }
  }

  @Test
  public void testDeterministicAliasEviction() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.eviction");
    try {
      File certFile = tempFolder.newFile("client-eviction.crt");
      File keyFile = tempFolder.newFile("client-eviction.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc.privateKey().toPath()));

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 0L);
      String firstAlias = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals("client-1", firstAlias);
      assertNotNull(keyManager.getCertificateChain(firstAlias));

      // Trigger 15 rotations
      for (int i = 2; i <= 15; i++) {
        Thread.sleep(10);
        certFile.setLastModified(System.currentTimeMillis() + i * 1000L);
        keyFile.setLastModified(System.currentTimeMillis() + i * 1000L);
        keyManager.checkAndReload();
      }

      String latestAlias = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals("client-15", latestAlias);
      assertNotNull(keyManager.getCertificateChain(latestAlias));

      // Oldest alias "client-1" should have been evicted (oldest kept is 15 - 10 = 5)
      assertNull(keyManager.getCertificateChain("client-1"));
      assertNull(keyManager.getPrivateKey("client-1"));
      assertNull(keyManager.getCertificateChain("client-4"));
      assertNull(keyManager.getPrivateKey("client-4"));
      assertNotNull(keyManager.getCertificateChain("client-5"));
      assertTrue(keyManager.getCertificateChain("client-5").length > 0);
      assertNotNull(keyManager.getPrivateKey("client-5"));
      assertNotNull(keyManager.getCertificateChain("client-15"));
      assertTrue(keyManager.getCertificateChain("client-15").length > 0);
      assertNotNull(keyManager.getPrivateKey("client-15"));
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testRotationWithNonZeroCheckInterval() throws Exception {
    SelfSignedCertificate ssc1 = new SelfSignedCertificate("spanner.test.nonzero1");
    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.nonzero2");
    try {
      File certFile = tempFolder.newFile("client-nonzero.crt");
      File keyFile = tempFolder.newFile("client-nonzero.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc1.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc1.privateKey().toPath()));

      // 50ms check interval
      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 50L);
      String alias1 = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals(
          ssc1.cert().getSubjectDN(), keyManager.getCertificateChain(alias1)[0].getSubjectDN());

      Files.write(certFile.toPath(), Files.readAllBytes(ssc2.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc2.privateKey().toPath()));
      certFile.setLastModified(System.currentTimeMillis() + 2000L);
      keyFile.setLastModified(System.currentTimeMillis() + 2000L);

      // Wait for check interval to elapse
      Thread.sleep(100);

      String alias2 = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals(
          ssc2.cert().getSubjectDN(), keyManager.getCertificateChain(alias2)[0].getSubjectDN());
    } finally {
      ssc1.delete();
      ssc2.delete();
    }
  }

  @Test
  public void testFileCheckThrottling() throws Exception {
    SelfSignedCertificate ssc1 = new SelfSignedCertificate("spanner.test.throttle1");
    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.throttle2");
    try {
      File certFile = tempFolder.newFile("client-throttle.crt");
      File keyFile = tempFolder.newFile("client-throttle.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc1.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc1.privateKey().toPath()));

      // 60-second check interval
      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 60000L);
      String alias1 = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals(
          ssc1.cert().getSubjectDN(), keyManager.getCertificateChain(alias1)[0].getSubjectDN());

      // Rotate files immediately on disk
      Files.write(certFile.toPath(), Files.readAllBytes(ssc2.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc2.privateKey().toPath()));

      // Within the throttle interval, the manager should retain and return previous certificate
      String aliasThrottled = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals(alias1, aliasThrottled);
      assertEquals(
          ssc1.cert().getSubjectDN(), keyManager.getCertificateChain(alias1)[0].getSubjectDN());
    } finally {
      ssc1.delete();
      ssc2.delete();
    }
  }

  @Test
  public void testCorruptRotationFallsBackToPrevious() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.fallback");
    try {
      File certFile = tempFolder.newFile("client-fallback.crt");
      File keyFile = tempFolder.newFile("client-fallback.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc.privateKey().toPath()));

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 0L);
      String aliasBefore = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertNotNull(aliasBefore);

      // Overwrite certFile with corrupt bytes
      Files.write(certFile.toPath(), "NOT A CERTIFICATE CONTENT".getBytes(StandardCharsets.UTF_8));
      certFile.setLastModified(System.currentTimeMillis() + 2000L);

      // DynamicKeyManager should catch reload error and retain previous material
      String aliasAfter = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals(aliasBefore, aliasAfter);
      assertNotNull(keyManager.getCertificateChain(aliasAfter));
      assertNotNull(keyManager.getPrivateKey(aliasAfter));
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testPkcs1KeyThrowsIllegalArgumentException() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.pkcs1");
    try {
      File certFile = tempFolder.newFile("client-pkcs1.crt");
      File keyFile = tempFolder.newFile("client-pkcs1.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
      Files.write(
          keyFile.toPath(),
          ("-----BEGIN RSA PRIVATE KEY-----\n"
                  + "MIIEowIBAAKCAQEA0Y3...\n"
                  + "-----END RSA PRIVATE KEY-----\n")
              .getBytes(StandardCharsets.UTF_8));

      IllegalArgumentException exception =
          assertThrows(
              IllegalArgumentException.class, () -> new DynamicKeyManager(certFile, keyFile));
      assertThat(exception.getMessage()).contains("PKCS#1 private keys are not supported");
      assertThat(exception.getMessage()).contains("openssl pkcs8");
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testNonExistentFileFailsInitialization() {
    File nonExistentCert = new File(tempFolder.getRoot(), "missing.crt");
    File nonExistentKey = new File(tempFolder.getRoot(), "missing.key");

    assertThrows(
        RuntimeException.class, () -> new DynamicKeyManager(nonExistentCert, nonExistentKey));
  }

  @Test
  public void testServerAliasesReturnNull() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.server");
    try {
      File certFile = tempFolder.newFile("server-test.crt");
      File keyFile = tempFolder.newFile("server-test.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc.privateKey().toPath()));

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile);
      assertNull(keyManager.getServerAliases("RSA", null));
      assertNull(keyManager.chooseServerAlias("RSA", null, null));
      assertNull(keyManager.chooseEngineServerAlias("RSA", null, null));
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testMismatchedCertificateAndKeyFailsInitialization() throws Exception {
    SelfSignedCertificate ssc1 = new SelfSignedCertificate("spanner.test.cert1");
    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.cert2");
    try {
      File certFile = tempFolder.newFile("mismatched-init.crt");
      File keyFile = tempFolder.newFile("mismatched-init.key");

      // Pair cert from ssc1 with key from ssc2
      Files.write(certFile.toPath(), Files.readAllBytes(ssc1.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc2.privateKey().toPath()));

      RuntimeException exception =
          assertThrows(RuntimeException.class, () -> new DynamicKeyManager(certFile, keyFile));
      assertThat(exception.getCause().getMessage())
          .contains("Private key does not match the certificate public key");
    } finally {
      ssc1.delete();
      ssc2.delete();
    }
  }

  @Test
  public void testMismatchedRotationFallsBackToPrevious() throws Exception {
    SelfSignedCertificate ssc1 = new SelfSignedCertificate("spanner.test.match1");
    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.match2");
    try {
      File certFile = tempFolder.newFile("mismatched-rotate.crt");
      File keyFile = tempFolder.newFile("mismatched-rotate.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc1.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc1.privateKey().toPath()));

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 0L);
      String alias1 = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals(
          ssc1.cert().getSubjectDN(), keyManager.getCertificateChain(alias1)[0].getSubjectDN());

      // Rotate only cert file (e.g., intermediate state during rotation)
      Files.write(certFile.toPath(), Files.readAllBytes(ssc2.certificate().toPath()));
      certFile.setLastModified(System.currentTimeMillis() + 2000L);

      // Key manager should detect mismatch and retain ssc1 credentials
      String aliasAfter = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertEquals(
          ssc1.cert().getSubjectDN(), keyManager.getCertificateChain(aliasAfter)[0].getSubjectDN());
    } finally {
      ssc1.delete();
      ssc2.delete();
    }
  }

  @Test
  public void testBinaryDerKeySupported() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.der");
    try {
      File certFile = tempFolder.newFile("client-der.crt");
      File keyFile = tempFolder.newFile("client-der.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
      Files.write(keyFile.toPath(), ssc.key().getEncoded());

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile);
      String alias = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertNotNull(alias);
      assertNotNull(keyManager.getCertificateChain(alias));
      assertNotNull(keyManager.getPrivateKey(alias));
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testHeaderlessBase64KeySupported() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.base64");
    try {
      File certFile = tempFolder.newFile("client-b64.crt");
      File keyFile = tempFolder.newFile("client-b64.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
      String base64Key = java.util.Base64.getEncoder().encodeToString(ssc.key().getEncoded());
      Files.write(keyFile.toPath(), base64Key.getBytes(StandardCharsets.UTF_8));

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile);
      String alias = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
      assertNotNull(alias);
      assertNotNull(keyManager.getCertificateChain(alias));
      assertNotNull(keyManager.getPrivateKey(alias));
    } finally {
      ssc.delete();
    }
  }

  @Test
  public void testConcurrentHandshakesDuringRotation() throws Exception {
    SelfSignedCertificate ssc1 = new SelfSignedCertificate("spanner.test.concurrent1");
    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.concurrent2");
    try {
      File certFile = tempFolder.newFile("client-concurrent.crt");
      File keyFile = tempFolder.newFile("client-concurrent.key");

      Files.write(certFile.toPath(), Files.readAllBytes(ssc1.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc1.privateKey().toPath()));

      DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 0L);

      int threadCount = 16;
      java.util.concurrent.ExecutorService executor =
          java.util.concurrent.Executors.newFixedThreadPool(threadCount);
      java.util.concurrent.CountDownLatch startLatch = new java.util.concurrent.CountDownLatch(1);
      java.util.concurrent.CountDownLatch doneLatch =
          new java.util.concurrent.CountDownLatch(threadCount);
      java.util.concurrent.atomic.AtomicInteger errors =
          new java.util.concurrent.atomic.AtomicInteger(0);

      // Rotate file on disk
      Files.write(certFile.toPath(), Files.readAllBytes(ssc2.certificate().toPath()));
      Files.write(keyFile.toPath(), Files.readAllBytes(ssc2.privateKey().toPath()));
      certFile.setLastModified(System.currentTimeMillis() + 2000L);
      keyFile.setLastModified(System.currentTimeMillis() + 2000L);

      for (int i = 0; i < threadCount; i++) {
        executor.submit(
            () -> {
              try {
                startLatch.await();
                String alias = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
                if (alias == null) {
                  errors.incrementAndGet();
                  return;
                }
                X509Certificate[] chain = keyManager.getCertificateChain(alias);
                PrivateKey key = keyManager.getPrivateKey(alias);
                if (chain == null || chain.length == 0 || key == null) {
                  errors.incrementAndGet();
                }
              } catch (Exception e) {
                errors.incrementAndGet();
              } finally {
                doneLatch.countDown();
              }
            });
      }

      startLatch.countDown();
      assertTrue(doneLatch.await(10, java.util.concurrent.TimeUnit.SECONDS));
      assertEquals(0, errors.get());
      executor.shutdown();
    } finally {
      ssc1.delete();
      ssc2.delete();
    }
  }
}
