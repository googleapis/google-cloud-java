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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import io.grpc.netty.shaded.io.netty.handler.ssl.util.SelfSignedCertificate;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DynamicTrustManagerTest {

  @Rule public TemporaryFolder tempFolder = new TemporaryFolder();

  @Test
  public void testDefaultTrustManagerWithNull() throws Exception {
    DynamicTrustManager trustManager = new DynamicTrustManager((File) null);
    X509Certificate[] issuers = trustManager.getAcceptedIssuers();
    assertNotNull(issuers);
    assertTrue(issuers.length > 0);
  }

  @Test
  public void testCustomTrustManagerAndDynamicRotation() throws Exception {
    SelfSignedCertificate ca1 = new SelfSignedCertificate("spanner.ca.1");
    SelfSignedCertificate ca2 = new SelfSignedCertificate("spanner.ca.2");
    try {
      File caFile = tempFolder.newFile("ca.crt");
      Files.write(caFile.toPath(), Files.readAllBytes(ca1.certificate().toPath()));

      DynamicTrustManager trustManager = new DynamicTrustManager(caFile, 0L);

      X509Certificate[] issuers1 = trustManager.getAcceptedIssuers();
      assertNotNull(issuers1);
      assertEquals(1, issuers1.length);
      assertEquals(ca1.cert().getSubjectDN(), issuers1[0].getSubjectDN());

      // Validating ca1 cert should succeed
      trustManager.checkServerTrusted(new X509Certificate[] {ca1.cert()}, "RSA");

      // Validating ca2 cert with ca1 trusted should fail
      assertThrows(
          CertificateException.class,
          () -> trustManager.checkServerTrusted(new X509Certificate[] {ca2.cert()}, "RSA"));

      // Rotate CA file on disk to ca2
      Files.write(caFile.toPath(), Files.readAllBytes(ca2.certificate().toPath()));
      caFile.setLastModified(System.currentTimeMillis() + 2000L);

      // Now ca2 should be accepted and ca1 should be rejected
      X509Certificate[] issuers2 = trustManager.getAcceptedIssuers();
      assertNotNull(issuers2);
      assertEquals(1, issuers2.length);
      assertEquals(ca2.cert().getSubjectDN(), issuers2[0].getSubjectDN());

      trustManager.checkServerTrusted(new X509Certificate[] {ca2.cert()}, "RSA");

      assertThrows(
          CertificateException.class,
          () -> trustManager.checkServerTrusted(new X509Certificate[] {ca1.cert()}, "RSA"));
    } finally {
      ca1.delete();
      ca2.delete();
    }
  }

  @Test
  public void testFileCheckThrottling() throws Exception {
    SelfSignedCertificate ca1 = new SelfSignedCertificate("spanner.ca.throttle1");
    SelfSignedCertificate ca2 = new SelfSignedCertificate("spanner.ca.throttle2");
    try {
      File caFile = tempFolder.newFile("ca-throttle.crt");
      Files.write(caFile.toPath(), Files.readAllBytes(ca1.certificate().toPath()));

      // 60-second check interval
      DynamicTrustManager trustManager = new DynamicTrustManager(caFile, 60000L);
      X509Certificate[] issuers1 = trustManager.getAcceptedIssuers();
      assertEquals(1, issuers1.length);
      assertEquals(ca1.cert().getSubjectDN(), issuers1[0].getSubjectDN());

      // Rotate CA on disk immediately
      Files.write(caFile.toPath(), Files.readAllBytes(ca2.certificate().toPath()));

      // Within throttle interval, trust manager should retain previous CA
      assertEquals(ca1.cert().getSubjectDN(), trustManager.getAcceptedIssuers()[0].getSubjectDN());
      trustManager.checkServerTrusted(new X509Certificate[] {ca1.cert()}, "RSA");
    } finally {
      ca1.delete();
      ca2.delete();
    }
  }

  @Test
  public void testRotationWithNonZeroCheckInterval() throws Exception {
    SelfSignedCertificate ca1 = new SelfSignedCertificate("spanner.ca.nonzero1");
    SelfSignedCertificate ca2 = new SelfSignedCertificate("spanner.ca.nonzero2");
    try {
      File caFile = tempFolder.newFile("ca-nonzero.crt");
      Files.write(caFile.toPath(), Files.readAllBytes(ca1.certificate().toPath()));

      // 50ms check interval
      DynamicTrustManager trustManager = new DynamicTrustManager(caFile, 50L);
      X509Certificate[] issuers1 = trustManager.getAcceptedIssuers();
      assertEquals(1, issuers1.length);
      assertEquals(ca1.cert().getSubjectDN(), issuers1[0].getSubjectDN());

      // Rotate CA on disk
      Files.write(caFile.toPath(), Files.readAllBytes(ca2.certificate().toPath()));
      caFile.setLastModified(System.currentTimeMillis() + 2000L);

      // Wait for check interval to elapse
      Thread.sleep(100);

      X509Certificate[] issuers2 = trustManager.getAcceptedIssuers();
      assertEquals(1, issuers2.length);
      assertEquals(ca2.cert().getSubjectDN(), issuers2[0].getSubjectDN());
      trustManager.checkServerTrusted(new X509Certificate[] {ca2.cert()}, "RSA");
    } finally {
      ca1.delete();
      ca2.delete();
    }
  }

  @Test
  public void testMultipleCAsInFile() throws Exception {
    SelfSignedCertificate ca1 = new SelfSignedCertificate("spanner.multi.ca.1");
    SelfSignedCertificate ca2 = new SelfSignedCertificate("spanner.multi.ca.2");
    try {
      File caFile = tempFolder.newFile("multi-ca.crt");
      byte[] bundle =
          (new String(Files.readAllBytes(ca1.certificate().toPath()), StandardCharsets.UTF_8)
                  + "\n"
                  + new String(
                      Files.readAllBytes(ca2.certificate().toPath()), StandardCharsets.UTF_8))
              .getBytes(StandardCharsets.UTF_8);
      Files.write(caFile.toPath(), bundle);

      DynamicTrustManager trustManager = new DynamicTrustManager(caFile);
      X509Certificate[] issuers = trustManager.getAcceptedIssuers();
      assertNotNull(issuers);
      assertEquals(2, issuers.length);

      trustManager.checkServerTrusted(new X509Certificate[] {ca1.cert()}, "RSA");
      trustManager.checkServerTrusted(new X509Certificate[] {ca2.cert()}, "RSA");
    } finally {
      ca1.delete();
      ca2.delete();
    }
  }

  @Test
  public void testCorruptRotationFallsBackToPrevious() throws Exception {
    SelfSignedCertificate ca = new SelfSignedCertificate("spanner.ca.fallback");
    try {
      File caFile = tempFolder.newFile("ca-fallback.crt");
      Files.write(caFile.toPath(), Files.readAllBytes(ca.certificate().toPath()));

      DynamicTrustManager trustManager = new DynamicTrustManager(caFile, 0L);
      trustManager.checkServerTrusted(new X509Certificate[] {ca.cert()}, "RSA");

      // Corrupt the file
      Files.write(caFile.toPath(), "CORRUPT CERT DATA".getBytes(StandardCharsets.UTF_8));
      caFile.setLastModified(System.currentTimeMillis() + 2000L);

      // Trust manager should retain previous CA
      trustManager.checkServerTrusted(new X509Certificate[] {ca.cert()}, "RSA");
      assertEquals(1, trustManager.getAcceptedIssuers().length);
    } finally {
      ca.delete();
    }
  }

  @Test
  public void testNonExistentFileFailsInitialization() {
    File nonExistent = new File(tempFolder.getRoot(), "missing-ca.crt");
    assertThrows(RuntimeException.class, () -> new DynamicTrustManager(nonExistent));
  }

  @Test
  public void testConcurrentValidationDuringRotation() throws Exception {
    SelfSignedCertificate ca1 = new SelfSignedCertificate("spanner.ca.concurrent1");
    SelfSignedCertificate ca2 = new SelfSignedCertificate("spanner.ca.concurrent2");
    try {
      File caFile = tempFolder.newFile("ca-concurrent.crt");
      Files.write(caFile.toPath(), Files.readAllBytes(ca1.certificate().toPath()));

      DynamicTrustManager trustManager = new DynamicTrustManager(caFile, 0L);

      int threadCount = 16;
      java.util.concurrent.ExecutorService executor =
          java.util.concurrent.Executors.newFixedThreadPool(threadCount);
      java.util.concurrent.CountDownLatch startLatch = new java.util.concurrent.CountDownLatch(1);
      java.util.concurrent.CountDownLatch doneLatch =
          new java.util.concurrent.CountDownLatch(threadCount);
      java.util.concurrent.atomic.AtomicInteger errors =
          new java.util.concurrent.atomic.AtomicInteger(0);

      // Rotate file on disk to ca2
      Files.write(caFile.toPath(), Files.readAllBytes(ca2.certificate().toPath()));
      caFile.setLastModified(System.currentTimeMillis() + 2000L);

      for (int i = 0; i < threadCount; i++) {
        executor.submit(
            () -> {
              try {
                startLatch.await();
                X509Certificate[] issuers = trustManager.getAcceptedIssuers();
                if (issuers == null || issuers.length == 0) {
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
      ca1.delete();
      ca2.delete();
    }
  }
}
