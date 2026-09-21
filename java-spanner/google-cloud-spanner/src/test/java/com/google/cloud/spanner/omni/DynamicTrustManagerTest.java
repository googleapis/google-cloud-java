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
    try (DynamicTrustManager trustManager = new DynamicTrustManager((File) null)) {
      X509Certificate[] issuers = trustManager.getAcceptedIssuers();
      assertNotNull(issuers);
      assertTrue(issuers.length > 0);
    }
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

      Thread.sleep(1100);

      // Rotate CA file on disk to ca2
      Files.write(caFile.toPath(), Files.readAllBytes(ca2.certificate().toPath()));
      trustManager.checkAndReload();

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
  public void testBackgroundReloadScheduled() throws Exception {
    SelfSignedCertificate ca1 = new SelfSignedCertificate("spanner.ca.bg1");
    SelfSignedCertificate ca2 = new SelfSignedCertificate("spanner.ca.bg2");
    try {
      File caFile = tempFolder.newFile("ca-bg.crt");
      Files.write(caFile.toPath(), Files.readAllBytes(ca1.certificate().toPath()));

      try (DynamicTrustManager trustManager = new DynamicTrustManager(caFile, 50L)) {
        X509Certificate[] issuers1 = trustManager.getAcceptedIssuers();
        assertNotNull(issuers1);
        assertEquals(1, issuers1.length);
        assertEquals(ca1.cert().getSubjectDN(), issuers1[0].getSubjectDN());

        Thread.sleep(1100);

        Files.write(caFile.toPath(), Files.readAllBytes(ca2.certificate().toPath()));

        // Background scheduler should reload CA material within ~1 second
        X509Certificate[] issuers2 = null;
        for (int i = 0; i < 40; i++) {
          issuers2 = trustManager.getAcceptedIssuers();
          if (issuers2 != null
              && issuers2.length > 0
              && issuers2[0].getSubjectDN().equals(ca2.cert().getSubjectDN())) {
            break;
          }
          Thread.sleep(50);
        }

        assertNotNull(issuers2);
        assertThat(issuers2.length).isEqualTo(1);
        assertEquals(ca2.cert().getSubjectDN(), issuers2[0].getSubjectDN());
        trustManager.checkServerTrusted(new X509Certificate[] {ca2.cert()}, "RSA");
      }
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
      try (DynamicTrustManager trustManager = new DynamicTrustManager(caFile, 60000L)) {
        X509Certificate[] issuers1 = trustManager.getAcceptedIssuers();
        assertEquals(1, issuers1.length);
        assertEquals(ca1.cert().getSubjectDN(), issuers1[0].getSubjectDN());

        // Rotate CA on disk immediately
        Files.write(caFile.toPath(), Files.readAllBytes(ca2.certificate().toPath()));

        // Without background poller firing, trust manager returns previous CA immediately
        assertEquals(
            ca1.cert().getSubjectDN(), trustManager.getAcceptedIssuers()[0].getSubjectDN());
        trustManager.checkServerTrusted(new X509Certificate[] {ca1.cert()}, "RSA");
      }
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

      try (DynamicTrustManager trustManager = new DynamicTrustManager(caFile)) {
        X509Certificate[] issuers = trustManager.getAcceptedIssuers();
        assertNotNull(issuers);
        assertEquals(2, issuers.length);

        trustManager.checkServerTrusted(new X509Certificate[] {ca1.cert()}, "RSA");
        trustManager.checkServerTrusted(new X509Certificate[] {ca2.cert()}, "RSA");
      }
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

      Thread.sleep(1100);

      // Corrupt the file
      Files.write(caFile.toPath(), "CORRUPT CERT DATA".getBytes(StandardCharsets.UTF_8));
      trustManager.checkAndReload();

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
}
