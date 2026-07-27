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
package com.google.api.gax.rpc.mtls;

import com.google.api.core.InternalApi;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Internal utility class for managing dynamic workload certificates. */
@InternalApi
public class WorkloadCertificateUtils {

  private static final Logger LOG = Logger.getLogger(WorkloadCertificateUtils.class.getName());

  // Statically evaluated on startup to avoid checking disk locations or environment repeatedly
  // if they don't exist.
  private static final String WORKLOAD_CERT_PATH = evaluateWorkloadCertPath();

  private static String evaluateWorkloadCertPath() {
    String configPath = System.getenv("GOOGLE_API_CERTIFICATE_CONFIG");
    if (configPath != null && !configPath.isEmpty()) {
      java.io.File configFile = new java.io.File(configPath);
      if (configFile.exists() && !configFile.isDirectory()) {
        return configFile.getAbsolutePath();
      }
    }
    java.io.File bundleFile =
        new java.io.File("/var/run/secrets/workload-spiffe-credentials/credentialbundle.pem");
    if (bundleFile.exists()) {
      return bundleFile.getAbsolutePath();
    }
    java.io.File certsFile =
        new java.io.File("/var/run/secrets/workload-spiffe-credentials/certificates.pem");
    if (certsFile.exists()) {
      return certsFile.getAbsolutePath();
    }
    return null;
  }

  public static String getWorkloadCertPath() {
    return WORKLOAD_CERT_PATH;
  }

  public static String getCertificateFingerprint(String certPath) {
    if (certPath == null) {
      return "";
    }
    try (FileInputStream fis = new FileInputStream(certPath)) {
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] der = cert.getEncoded();
      byte[] digest = md.digest(der);
      StringBuilder sb = new StringBuilder();
      for (byte b : digest) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();
    } catch (Exception e) {
      LOG.log(Level.FINE, "Could not read or parse workload certificate at path " + certPath, e);
      return "";
    }
  }
}
