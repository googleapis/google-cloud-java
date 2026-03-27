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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.json.GenericJson;
import com.google.auth.TestUtils;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class WorkloadCertificateConfigurationTest {

  @Test
  void workloadCertificateConfig_fromStream_Succeeds() throws IOException {
    String certPath = "cert.crt";
    String privateKeyPath = "key.crt";
    InputStream configStream = writeWorkloadCertificateConfigStream(certPath, privateKeyPath);

    WorkloadCertificateConfiguration config =
        WorkloadCertificateConfiguration.fromCertificateConfigurationStream(configStream);
    assertNotNull(config);
  }

  @Test
  void workloadCertificateConfig_fromStreamMissingCertPath_Fails() throws IOException {
    String certPath = "";
    String privateKeyPath = "key.crt";
    InputStream configStream = writeWorkloadCertificateConfigStream(certPath, privateKeyPath);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                WorkloadCertificateConfiguration.fromCertificateConfigurationStream(configStream));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "The cert_path field must be provided in the workload certificate configuration."));
  }

  @Test
  void workloadCertificateConfig_fromStreamMissingPrivateKeyPath_Fails() throws IOException {
    String certPath = "cert.crt";
    String privateKeyPath = "";
    InputStream configStream = writeWorkloadCertificateConfigStream(certPath, privateKeyPath);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                WorkloadCertificateConfiguration.fromCertificateConfigurationStream(configStream));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "The key_path field must be provided in the workload certificate configuration."));
  }

  @Test
  void workloadCertificateConfig_fromStreamMissingWorkload_Fails() throws IOException {
    GenericJson json = new GenericJson();
    json.put("cert_configs", new GenericJson());
    InputStream configStream = TestUtils.jsonToInputStream(json);

    CertificateSourceUnavailableException exception =
        assertThrows(
            CertificateSourceUnavailableException.class,
            () ->
                WorkloadCertificateConfiguration.fromCertificateConfigurationStream(configStream));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "A workload certificate configuration must be provided in the cert_configs object."));
  }

  @Test
  void workloadCertificateConfig_fromStreamMissingCertConfig_Fails() throws IOException {
    GenericJson json = new GenericJson();
    InputStream configStream = TestUtils.jsonToInputStream(json);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                WorkloadCertificateConfiguration.fromCertificateConfigurationStream(configStream));
    assertTrue(
        exception
            .getMessage()
            .contains(
                "The cert_configs object must be provided in the certificate configuration file."));
  }

  static InputStream writeWorkloadCertificateConfigStream(String certPath, String privateKeyPath)
      throws IOException {
    GenericJson json = writeWorkloadCertificateConfigJson(certPath, privateKeyPath);
    return TestUtils.jsonToInputStream(json);
  }

  private static GenericJson writeWorkloadCertificateConfigJson(
      String certPath, String privateKeyPath) {
    GenericJson json = new GenericJson();
    json.put("version", 1);
    GenericJson certConfigs = new GenericJson();
    GenericJson workloadConfig = new GenericJson();
    if (certPath != null) {
      workloadConfig.put("cert_path", certPath);
    }
    if (privateKeyPath != null) {
      workloadConfig.put("key_path", privateKeyPath);
    }
    certConfigs.put("workload", workloadConfig);
    json.put("cert_configs", certConfigs);
    return json;
  }
}
