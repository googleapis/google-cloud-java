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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

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

    // Ensure lastModified timestamp changes upon rotation
    Thread.sleep(1100);

    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.2");
    Files.write(certFile.toPath(), Files.readAllBytes(ssc2.certificate().toPath()));
    Files.write(keyFile.toPath(), Files.readAllBytes(ssc2.privateKey().toPath()));

    String alias2 = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
    assertNotNull(alias2);

    X509Certificate[] chain2 = keyManager.getCertificateChain(alias2);
    assertNotNull(chain2);
    assertEquals(ssc2.cert().getSubjectDN(), chain2[0].getSubjectDN());

    PrivateKey pk2 = keyManager.getPrivateKey(alias2);
    assertNotNull(pk2);
  }

  @Test
  public void testFileCheckThrottling() throws Exception {
    SelfSignedCertificate ssc1 = new SelfSignedCertificate("spanner.test.throttle1");
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
    SelfSignedCertificate ssc2 = new SelfSignedCertificate("spanner.test.throttle2");
    Files.write(certFile.toPath(), Files.readAllBytes(ssc2.certificate().toPath()));
    Files.write(keyFile.toPath(), Files.readAllBytes(ssc2.privateKey().toPath()));

    // Within the throttle interval, the manager should retain and return previous certificate
    assertEquals(
        ssc1.cert().getSubjectDN(), keyManager.getCertificateChain(alias1)[0].getSubjectDN());
  }

  @Test
  public void testCorruptRotationFallsBackToPrevious() throws Exception {
    SelfSignedCertificate ssc = new SelfSignedCertificate("spanner.test.fallback");
    File certFile = tempFolder.newFile("client-fallback.crt");
    File keyFile = tempFolder.newFile("client-fallback.key");

    Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
    Files.write(keyFile.toPath(), Files.readAllBytes(ssc.privateKey().toPath()));

    DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile, 0L);
    String aliasBefore = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
    assertNotNull(aliasBefore);

    Thread.sleep(1100);

    // Overwrite certFile with corrupt bytes
    Files.write(certFile.toPath(), "NOT A CERTIFICATE CONTENT".getBytes(StandardCharsets.UTF_8));

    // DynamicKeyManager should catch reload error and retain previous material
    String aliasAfter = keyManager.chooseClientAlias(new String[] {"RSA"}, null, null);
    assertEquals(aliasBefore, aliasAfter);
    assertNotNull(keyManager.getCertificateChain(aliasAfter));
    assertNotNull(keyManager.getPrivateKey(aliasAfter));
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
    File certFile = tempFolder.newFile("server-test.crt");
    File keyFile = tempFolder.newFile("server-test.key");

    Files.write(certFile.toPath(), Files.readAllBytes(ssc.certificate().toPath()));
    Files.write(keyFile.toPath(), Files.readAllBytes(ssc.privateKey().toPath()));

    DynamicKeyManager keyManager = new DynamicKeyManager(certFile, keyFile);
    assertNull(keyManager.getServerAliases("RSA", null));
    assertNull(keyManager.chooseServerAlias("RSA", null, null));
    assertNull(keyManager.chooseEngineServerAlias("RSA", null, null));
  }
}
