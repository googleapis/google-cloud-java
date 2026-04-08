/*
 * Copyright 2025, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class X509ProviderTest {

  private static final String TEST_CERT =
      "-----BEGIN CERTIFICATE-----\n"
          + "MIICGzCCAYSgAwIBAgIIWrt6xtmHPs4wDQYJKoZIhvcNAQEFBQAwMzExMC8GA1UE\n"
          + "AxMoMTAwOTEyMDcyNjg3OC5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbTAeFw0x\n"
          + "MjEyMDExNjEwNDRaFw0yMjExMjkxNjEwNDRaMDMxMTAvBgNVBAMTKDEwMDkxMjA3\n"
          + "MjY4NzguYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20wgZ8wDQYJKoZIhvcNAQEB\n"
          + "BQADgY0AMIGJAoGBAL1SdY8jTUVU7O4/XrZLYTw0ON1lV6MQRGajFDFCqD2Fd9tQ\n"
          + "GLW8Iftx9wfXe1zuaehJSgLcyCxazfyJoN3RiONBihBqWY6d3lQKqkgsRTNZkdFJ\n"
          + "Wdzl/6CxhK9sojh2p0r3tydtv9iwq5fuuWIvtODtT98EgphhncQAqkKoF3zVAgMB\n"
          + "AAGjODA2MAwGA1UdEwEB/wQCMAAwDgYDVR0PAQH/BAQDAgeAMBYGA1UdJQEB/wQM\n"
          + "MAoGCCsGAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4GBAD8XQEqzGePa9VrvtEGpf+R4\n"
          + "fkxKbcYAzqYq202nKu0kfjhIYkYSBj6gi348YaxE64yu60TVl42l5HThmswUheW4\n"
          + "uQIaq36JvwvsDP5Zoj5BgiNSnDAFQp+jJFBRUA5vooJKgKgMDf/r/DCOsbO6VJF1\n"
          + "kWwa9n19NFiV0z3m6isj\n"
          + "-----END CERTIFICATE-----\n";

  private static final String TEST_PRIVATE_KEY =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAL1SdY8jTUVU7O4/\n"
          + "XrZLYTw0ON1lV6MQRGajFDFCqD2Fd9tQGLW8Iftx9wfXe1zuaehJSgLcyCxazfyJ\n"
          + "oN3RiONBihBqWY6d3lQKqkgsRTNZkdFJWdzl/6CxhK9sojh2p0r3tydtv9iwq5fu\n"
          + "uWIvtODtT98EgphhncQAqkKoF3zVAgMBAAECgYB51B9cXe4yiGTzJ4pOKpHGySAy\n"
          + "sC1F/IjXt2eeD3PuKv4m/hL4l7kScpLx0+NJuQ4j8U2UK/kQOdrGANapB1ZbMZAK\n"
          + "/q0xmIUzdNIDiGSoTXGN2mEfdsEpQ/Xiv0lyhYBBPC/K4sYIpHccnhSRQUZlWLLY\n"
          + "lE5cFNKC9b7226mNvQJBAPt0hfCNIN0kUYOA9jdLtx7CE4ySGMPf5KPBuzPd8ty1\n"
          + "fxaFm9PB7B76VZQYmHcWy8rT5XjoLJHrmGW1ZvP+iDsCQQDAvnKoarPOGb5iJfkq\n"
          + "RrA4flf1TOlf+1+uqIOJ94959jkkJeb0gv/TshDnm6/bWn+1kJylQaKygCizwPwB\n"
          + "Z84vAkA0Duur4YvsPJijoQ9YY1SGCagCcjyuUKwFOxaGpmyhRPIKt56LOJqpzyno\n"
          + "fy8ReKa4VyYq4eZYT249oFCwMwIBAkAROPNF2UL3x5UbcAkznd1hLujtIlI4IV4L\n"
          + "XUNjsJtBap7we/KHJq11XRPlniO4lf2TW7iji5neGVWJulTKS1xBAkAerktk4Hsw\n"
          + "ErUaUG1s/d+Sgc8e/KMeBElV+NxGhcWEeZtfHMn/6VOlbzY82JyvC9OKC80A5CAE\n"
          + "VUV6b25kqrcu\n"
          + "-----END PRIVATE KEY-----";

  @Test
  void x509Provider_fileDoesntExist_throws() {
    String certConfigPath = "badfile.txt";
    X509Provider testProvider = new TestX509Provider(certConfigPath);
    String expectedErrorMessage = "File does not exist.";

    CertificateSourceUnavailableException exception =
        assertThrows(CertificateSourceUnavailableException.class, testProvider::getKeyStore);
    assertTrue(exception.getMessage().contains(expectedErrorMessage));
  }

  @Test
  void x509Provider_emptyFile_throws() {
    String certConfigPath = "certConfig.txt";
    InputStream certConfigStream = new ByteArrayInputStream("".getBytes());
    TestX509Provider testProvider = new TestX509Provider(certConfigPath);
    testProvider.addFile(certConfigPath, certConfigStream);
    String expectedErrorMessage = "no JSON input found";

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, testProvider::getKeyStore);
    assertTrue(exception.getMessage().contains(expectedErrorMessage));
  }

  @Test
  void x509Provider_succeeds() throws IOException, KeyStoreException, CertificateException {
    String certConfigPath = "certConfig.txt";
    String certPath = "cert.crt";
    String keyPath = "key.crt";
    InputStream certConfigStream =
        WorkloadCertificateConfigurationTest.writeWorkloadCertificateConfigStream(
            certPath, keyPath);

    TestX509Provider testProvider = new TestX509Provider(certConfigPath);
    testProvider.addFile(certConfigPath, certConfigStream);
    testProvider.addFile(certPath, new ByteArrayInputStream(TEST_CERT.getBytes()));
    testProvider.addFile(keyPath, new ByteArrayInputStream(TEST_PRIVATE_KEY.getBytes()));

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Certificate expectedCert =
        cf.generateCertificate(new ByteArrayInputStream(TEST_CERT.getBytes()));

    // Assert that the store has the expected certificate and only the expected certificate.
    KeyStore store = testProvider.getKeyStore();
    assertEquals(1, store.size());
    assertNotNull(store.getCertificateAlias(expectedCert));
  }

  @Test
  void x509Provider_succeeds_withEnvVariable()
      throws IOException, KeyStoreException, CertificateException {
    String certConfigPath = "certConfig.txt";
    String certPath = "cert.crt";
    String keyPath = "key.crt";
    try (InputStream certConfigStream =
        WorkloadCertificateConfigurationTest.writeWorkloadCertificateConfigStream(
            certPath, keyPath)) {
      TestX509Provider testProvider = new TestX509Provider();
      testProvider.setEnv(certConfigPath);
      testProvider.addFile(certConfigPath, certConfigStream);
      testProvider.addFile(certPath, new ByteArrayInputStream(TEST_CERT.getBytes()));
      testProvider.addFile(keyPath, new ByteArrayInputStream(TEST_PRIVATE_KEY.getBytes()));

      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      Certificate expectedCert =
          cf.generateCertificate(new ByteArrayInputStream(TEST_CERT.getBytes()));

      // Assert that the store has the expected certificate and only the expected certificate.
      KeyStore store = testProvider.getKeyStore();
      assertEquals(1, store.size());
      assertNotNull(store.getCertificateAlias(expectedCert));
    }
  }

  @Test
  void x509Provider_succeeds_withWellKnownPath()
      throws IOException, KeyStoreException, CertificateException {
    String certConfigPath = "certConfig.txt";
    String certPath = "cert.crt";
    String keyPath = "key.crt";
    try (InputStream certConfigStream =
        WorkloadCertificateConfigurationTest.writeWorkloadCertificateConfigStream(
            certPath, keyPath)) {
      TestX509Provider testProvider = new TestX509Provider();
      testProvider.setEnv(certConfigPath);
      testProvider.addFile(certConfigPath, certConfigStream);
      testProvider.addFile(certPath, new ByteArrayInputStream(TEST_CERT.getBytes()));
      testProvider.addFile(keyPath, new ByteArrayInputStream(TEST_PRIVATE_KEY.getBytes()));

      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      Certificate expectedCert =
          cf.generateCertificate(new ByteArrayInputStream(TEST_CERT.getBytes()));

      // Assert that the store has the expected certificate and only the expected certificate.
      KeyStore store = testProvider.getKeyStore();
      assertEquals(1, store.size());
      assertNotNull(store.getCertificateAlias(expectedCert));
    }
  }

  static class TestX509Provider extends X509Provider {
    private final Map<String, InputStream> files;
    private final Map<String, String> variables;
    private final Map<String, String> properties;

    TestX509Provider() {
      this(null);
    }

    TestX509Provider(String filePathOverride) {
      super(filePathOverride);
      this.files = new HashMap<>();
      this.variables = new HashMap<>();
      this.properties = new HashMap<>();
    }

    void addFile(String file, InputStream stream) {
      files.put(file, stream);
    }

    @Override
    String getEnv(String name) {
      return variables.get(name);
    }

    void setEnv(String value) {
      variables.put("GOOGLE_API_CERTIFICATE_CONFIG", value);
    }

    @Override
    String getProperty(String property, String def) {
      String value = properties.get(property);
      return value == null ? def : value;
    }

    @Override
    boolean isFile(File file) {
      return files.containsKey(file.getPath());
    }

    @Override
    InputStream createInputStream(File file) throws FileNotFoundException {
      InputStream stream = files.get(file.getPath());
      if (stream == null) {
        throw new FileNotFoundException(file.getPath());
      }
      return stream;
    }
  }
}
