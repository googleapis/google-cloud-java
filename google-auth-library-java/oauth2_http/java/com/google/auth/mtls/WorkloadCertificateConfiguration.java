/*
 * Copyright 2025 Google LLC
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

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

class WorkloadCertificateConfiguration {

  private String certPath;
  private String privateKeyPath;

  private static JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
  private static JsonObjectParser parser = new JsonObjectParser(jsonFactory);

  WorkloadCertificateConfiguration(String certPath, String privateKeyPath) {
    this.certPath = certPath;
    this.privateKeyPath = privateKeyPath;
  }

  String getCertPath() {
    return certPath;
  }

  String getPrivateKeyPath() {
    return privateKeyPath;
  }

  static WorkloadCertificateConfiguration fromCertificateConfigurationStream(
      InputStream certConfigStream) throws IOException {
    Preconditions.checkNotNull(certConfigStream);

    GenericJson fileContents =
        parser.parseAndClose(certConfigStream, StandardCharsets.UTF_8, GenericJson.class);

    Map<String, Object> certConfigs = (Map<String, Object>) fileContents.get("cert_configs");
    if (certConfigs == null) {
      throw new IllegalArgumentException(
          "The cert_configs object must be provided in the certificate configuration file.");
    }

    Map<String, Object> workloadConfig = (Map<String, Object>) certConfigs.get("workload");
    if (workloadConfig == null) {
      // Throw a CertificateSourceUnavailableException because there is no workload cert source.
      // This tells the transport layer that it should check for another certificate source type.
      throw new CertificateSourceUnavailableException(
          "A workload certificate configuration must be provided in the cert_configs object.");
    }

    String certPath = (String) workloadConfig.get("cert_path");
    if (Strings.isNullOrEmpty(certPath)) {
      throw new IllegalArgumentException(
          "The cert_path field must be provided in the workload certificate configuration.");
    }

    String privateKeyPath = (String) workloadConfig.get("key_path");
    if (Strings.isNullOrEmpty(privateKeyPath)) {
      throw new IllegalArgumentException(
          "The key_path field must be provided in the workload certificate configuration.");
    }

    return new WorkloadCertificateConfiguration(certPath, privateKeyPath);
  }
}
