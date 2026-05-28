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

package com.google.api.gax.rpc.mtls;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.internal.EnvironmentProvider;
import java.io.IOException;

/**
 * Utility class for handling certificate-based access configurations.
 *
 * <p>This class handles the processing of GOOGLE_API_USE_CLIENT_CERTIFICATE,
 * GOOGLE_API_CERTIFICATE_CONFIG, and GOOGLE_API_USE_MTLS_ENDPOINT configurations.
 */
@InternalApi
public class CertificateBasedAccess {

  private final EnvironmentProvider envProvider;
  private final FileExistenceProvider fileExistenceProvider;
  private final FileContentReader fileContentReader;

  @InternalApi
  public interface FileExistenceProvider {
    boolean exists(String path);
  }

  @InternalApi
  public interface FileContentReader {
    String read(String path) throws IOException;
  }

  public CertificateBasedAccess(EnvironmentProvider envProvider) {
    this(
        envProvider,
        path -> {
          java.io.File file = new java.io.File(path);
          return file.exists() && file.isFile();
        },
        path -> new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(path)), java.nio.charset.StandardCharsets.UTF_8)
    );
  }

  CertificateBasedAccess(
      EnvironmentProvider envProvider,
      FileExistenceProvider fileExistenceProvider,
      FileContentReader fileContentReader) {
    this.envProvider = envProvider;
    this.fileExistenceProvider = fileExistenceProvider;
    this.fileContentReader = fileContentReader;
  }

  public static CertificateBasedAccess createWithSystemEnv() {
    return new CertificateBasedAccess(System::getenv);
  }

  /**
   * The policy for mutual TLS endpoint usage. NEVER means always use regular endpoint; ALWAYS means
   * always use mTLS endpoint; AUTO means auto switch to mTLS endpoint if client certificate exists
   * and should be used.
   */
  public enum MtlsEndpointUsagePolicy {
    NEVER,
    AUTO,
    ALWAYS;
  }

  private static class CertificateConfig {
    final String certPath;
    final String keyPath;

    CertificateConfig(String certPath, String keyPath) {
      this.certPath = certPath;
      this.keyPath = keyPath;
    }
  }

  private CertificateConfig parseCertificateConfig(String configPath) throws IOException {
    String content = fileContentReader.read(configPath);
    
    String certPath = extractJsonValue(content, "cert_path");
    String keyPath = extractJsonValue(content, "key_path");

    if (certPath == null || keyPath == null) {
      throw new IllegalStateException("Malformed certificate config JSON. Must contain 'cert_path' and 'key_path'.");
    }

    return new CertificateConfig(certPath, keyPath);
  }

  private String extractJsonValue(String json, String key) {
    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(
        "\"" + java.util.regex.Pattern.quote(key) + "\"\\s*:\\s*\"([^\"]+)\""
    );
    java.util.regex.Matcher matcher = pattern.matcher(json);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return null;
  }

  /** Returns if mutual TLS client certificate should be used. */
  public boolean useMtlsClientCertificate() {
    // 1. Check the explicit user flag first (Primary override)
    String useClientCertificate = envProvider.getenv("GOOGLE_API_USE_CLIENT_CERTIFICATE");
    if (useClientCertificate != null && !useClientCertificate.isEmpty()) {
      if ("false".equalsIgnoreCase(useClientCertificate)) {
        return false;
      }
    }

    // 2. Check the certificate config file path if provided via env var
    String certConfigPath = envProvider.getenv("GOOGLE_API_CERTIFICATE_CONFIG");
    if (certConfigPath != null && !certConfigPath.isEmpty()) {
      return validateAndResolveConfig(certConfigPath);
    }

    // 3. Fallback to well-known spiffe path
    String wellKnownPath = "/var/run/secrets/workload-spiffe-credentials/";
    
    // Check for atomic bundle containing both cert and key
    if (fileExistenceProvider.exists(wellKnownPath + "credentialbundle.pem")) {
      return true; 
    }
    
    // Check for separate certificate and private key files
    if (fileExistenceProvider.exists(wellKnownPath + "certificates.pem") 
        && fileExistenceProvider.exists(wellKnownPath + "private_key.pem")) {
      return true;
    }

    // Default to false if no configuration is found
    return false;
  }

  private boolean validateAndResolveConfig(String configPath) {
    if (!fileExistenceProvider.exists(configPath)) {
      throw new IllegalStateException(
          "Certificate config is configured but the file does not exist: " + configPath
      );
    }
    try {
      CertificateConfig config = parseCertificateConfig(configPath);
      if (!fileExistenceProvider.exists(config.certPath) || !fileExistenceProvider.exists(config.keyPath)) {
        throw new IllegalStateException(
            "Certificate config points to certificate/key files that do not exist on disk: " +
            "cert_path=" + config.certPath + ", key_path=" + config.keyPath
        );
      }
      return true;
    } catch (Exception e) {
      throw new IllegalStateException(
          "Failed to parse or validate certificate config: " + configPath, e
      );
    }
  }

  /** Returns the current mutual TLS endpoint usage policy. */
  public MtlsEndpointUsagePolicy getMtlsEndpointUsagePolicy() {
    String mtlsEndpointUsagePolicy = envProvider.getenv("GOOGLE_API_USE_MTLS_ENDPOINT");
    if ("never".equals(mtlsEndpointUsagePolicy)) {
      return MtlsEndpointUsagePolicy.NEVER;
    } else if ("always".equals(mtlsEndpointUsagePolicy)) {
      return MtlsEndpointUsagePolicy.ALWAYS;
    }
    return MtlsEndpointUsagePolicy.AUTO;
  }
}
