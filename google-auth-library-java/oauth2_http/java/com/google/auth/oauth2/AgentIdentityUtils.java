/*
 * Copyright 2026, Google Inc. All rights reserved.
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
package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Utility class for Agent Identity token binding in Cloud Run. */
@InternalApi
public final class AgentIdentityUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(AgentIdentityUtils.class);

  // Environment variables
  static final String GOOGLE_API_CERTIFICATE_CONFIG = "GOOGLE_API_CERTIFICATE_CONFIG";
  static final String GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES =
      "GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES";

  private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS =
      ImmutableList.of(
          Pattern.compile("^agents\\.global\\.org-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents\\.global\\.proj-\\d+\\.system\\.id\\.goog$"));

  private static final int SAN_URI_TYPE = 6;
  private static final String SPIFFE_SCHEME_PREFIX = "spiffe://";

  private static String wellKnownDir = "/var/run/secrets/workload-spiffe-credentials/";

  @VisibleForTesting
  static void setWellKnownDir(String dir) {
    wellKnownDir = dir;
  }

  // Polling configuration
  private static final int FAST_POLL_CYCLES = 50;
  private static final long FAST_POLL_INTERVAL_MS = 100; // 0.1 seconds
  private static final long SLOW_POLL_INTERVAL_MS = 500; // 0.5 seconds
  private static final long TOTAL_TIMEOUT_MS = 30000; // 30 seconds
  private static final List<Long> POLLING_INTERVALS;

  static {
    List<Long> intervals = new ArrayList<>();
    for (int i = 0; i < FAST_POLL_CYCLES; i++) {
      intervals.add(FAST_POLL_INTERVAL_MS);
    }
    long remainingTime = TOTAL_TIMEOUT_MS - (FAST_POLL_CYCLES * FAST_POLL_INTERVAL_MS);
    int slowPollCycles = (int) (remainingTime / SLOW_POLL_INTERVAL_MS);
    for (int i = 0; i < slowPollCycles; i++) {
      intervals.add(SLOW_POLL_INTERVAL_MS);
    }
    POLLING_INTERVALS = Collections.unmodifiableList(intervals);
  }

  public interface EnvReader {
    String getEnv(String name);
  }

  private static EnvReader envReader = System::getenv;

  @VisibleForTesting
  interface TimeService {
    long currentTimeMillis();

    void sleep(long millis) throws InterruptedException;
  }

  private static TimeService timeService =
      new TimeService() {
        @Override
        public long currentTimeMillis() {
          return System.currentTimeMillis();
        }

        @Override
        public void sleep(long millis) throws InterruptedException {
          Thread.sleep(millis);
        }
      };

  private AgentIdentityUtils() {}

  static class CertInfo {
    final X509Certificate certificate;
    final String certContent;

    CertInfo(X509Certificate certificate, String certContent) {
      this.certificate = certificate;
      this.certContent = certContent;
    }
  }

  static class ResolvedCertAndKeyPaths {
    final String certPath;
    final String keyPath;

    ResolvedCertAndKeyPaths(String certPath, String keyPath) {
      this.certPath = certPath;
      this.keyPath = keyPath;
    }
  }

  /**
   * Retrieves the certificate and path for the Agent Identity.
   *
   * <p>This method attempts to load the certificate and private key for the agent identity. It
   * first checks the location specified by the {@code GOOGLE_API_CERTIFICATE_CONFIG} environment
   * variable. If not set, it falls back to well-known default locations.
   *
   * <p>To handle transient race conditions during certificate rotation on disk, this method employs
   * a retry mechanism with backoff when reading the configuration and certificate files.
   *
   * @return A {@link CertInfo} object containing the loaded certificate and its path, or {@code
   *     null} if the agent identity features are disabled, opted out, or if no valid credentials
   *     could be loaded.
   * @throws IOException If an I/O error occurs while reading the files, or if the key-pair
   *     verification fails after retries.
   */
  static CertInfo getAgentIdentityCertInfo() throws IOException {
    if (!isTokenBindingEnabled()) {
      return null;
    }
    String certConfigPath = envReader.getEnv(GOOGLE_API_CERTIFICATE_CONFIG);
    boolean configExists =
        !Strings.isNullOrEmpty(certConfigPath) && Files.exists(Paths.get(certConfigPath));

    ResolvedCertAndKeyPaths paths = resolveCertAndKeyPaths(certConfigPath);
    boolean certsPresent = !Strings.isNullOrEmpty(paths.certPath);

    if (!shouldEnableMtls(certsPresent, configExists)) {
      return null;
    }

    return loadAndVerifyCredentials(paths.certPath, paths.keyPath);
  }

  /**
   * Resolves the paths for the certificate and private key based on the config path or well-known
   * locations.
   */
  static ResolvedCertAndKeyPaths resolveCertAndKeyPaths(String certConfigPath) throws IOException {
    String certPath = null;
    String keyPath = null;

    if (!Strings.isNullOrEmpty(certConfigPath)) {
      java.nio.file.Path configPath = Paths.get(certConfigPath);
      if (!Files.exists(configPath) && !Files.exists(Paths.get(wellKnownDir))) {
        // Fail-fast if config doesn't exist and we are not in a workload environment
        return new ResolvedCertAndKeyPaths(null, null);
      }
      // Read cert and key paths from config file. We use retry with backoff to handle transient
      // race conditions where the config file might be being updated by a rotation process.
      ResolvedCertAndKeyPaths paths = getPathsFromConfigWithRetry(certConfigPath);
      if (paths != null) {
        certPath = paths.certPath;
        keyPath = paths.keyPath;
      }
    } else {
      if (!Files.exists(Paths.get(wellKnownDir))) {
        // Fail-fast if well-known dir doesn't exist (e.g. workstation)
        return new ResolvedCertAndKeyPaths(null, null);
      }
      // Fallback to well-known locations. We use retry with backoff here as well to handle
      // race conditions during file replacement by a rotation process.
      certPath = getWellKnownCertificatePathWithRetry();
      if (certPath != null) {
        if (certPath.endsWith("credentialbundle.pem")) {
          keyPath = certPath; // Bundle contains both
        } else if (certPath.endsWith("certificates.pem")) {
          keyPath = Paths.get(wellKnownDir, "private_key.pem").toString();
        }
      }
    }
    return new ResolvedCertAndKeyPaths(certPath, keyPath);
  }

  /**
   * Loads the certificate and private key, and verifies that they match if they are separate files.
   */
  static CertInfo loadAndVerifyCredentials(String certPath, String keyPath) throws IOException {
    X509Certificate cert = null;
    PrivateKey privateKey = null;
    String certContent = null;

    if (!Strings.isNullOrEmpty(certPath)
        && !Strings.isNullOrEmpty(keyPath)
        && !certPath.equals(keyPath)
        && Files.exists(Paths.get(keyPath))) {
      // Separate files, verify match with retry
      int retries = 0;
      boolean matched = false;
      while (retries < 3) {
        try {
          certContent = readCertificateChain(certPath);
          cert = parseCertificateContent(certContent);
          privateKey = readPrivateKey(keyPath, cert.getPublicKey().getAlgorithm());

          if (verifyKeyPair(cert, privateKey)) {
            matched = true;
            break;
          }
          LOGGER.warn("Cert and key mismatch, retrying...");
        } catch (java.nio.file.AccessDeniedException e) {
          Slf4jUtils.log(
              LOGGER,
              org.slf4j.event.Level.WARN,
              Collections.emptyMap(),
              "Permission denied reading certificate or key files. Falling back to unbound token.");
          return null;
        } catch (Exception e) {
          LOGGER.warn("Failed to read or verify cert/key, retrying...", e);
        }

        retries++;
        if (retries < 3) {
          try {
            timeService.sleep(100); // 0.1 seconds backoff
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while waiting for cert/key match.", e);
          }
        }
      }

      if (!matched) {
        throw new IOException(
            "Agent Identity certificate and private key mismatch or read failure after 3 retries.");
      }
    } else if (!Strings.isNullOrEmpty(certPath)) {
      // Bundle or only cert available
      try {
        certContent = readCertificateChain(certPath);
        cert = parseCertificateContent(certContent);
      } catch (java.nio.file.AccessDeniedException e) {
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            "Permission denied reading certificate files. Falling back to unbound token.");
        return null;
      }
    }

    return new CertInfo(cert, certContent);
  }

  /**
   * Checks if a file exists, throwing AccessDeniedException if permission is denied.
   */
  private static boolean checkExistsOrAccessDenied(java.nio.file.Path path)
      throws java.nio.file.AccessDeniedException {
    try {
      Files.readAttributes(path, java.nio.file.attribute.BasicFileAttributes.class);
      return true;
    } catch (java.nio.file.AccessDeniedException e) {
      throw e;
    } catch (IOException e) {
      return false;
    }
  }

  /**
   * Checks if the user has disabled token binding by setting the environment variable to false.
   */
  private static boolean isTokenBindingEnabled() {
    String preventSharing = envReader.getEnv(GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES);
    return !("false".equalsIgnoreCase(preventSharing));
  }

  /**
   * Reads the certificate path from the config file with retry logic to handle rotation race
   * conditions.
   */
  private static ResolvedCertAndKeyPaths getPathsFromConfigWithRetry(String certConfigPath) throws IOException {
    boolean warned = false;
    for (long sleepInterval : POLLING_INTERVALS) {
      try {
        if (checkExistsOrAccessDenied(Paths.get(certConfigPath))) {
          ResolvedCertAndKeyPaths paths = extractPathsFromConfig(certConfigPath);
          if (paths != null
              && !Strings.isNullOrEmpty(paths.certPath)
              && checkExistsOrAccessDenied(Paths.get(paths.certPath))) {
            return paths;
          }
        }
      } catch (java.nio.file.AccessDeniedException e) {
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            "Permission denied reading certificate config file. Falling back to unbound token.");
        return null;
      } catch (IOException e) {
        // Fall through to retry
      }
      if (!warned) {
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            String.format(
                "Certificate config file not found or invalid at %s (from %s environment variable). Retrying for up to %d seconds.",
                certConfigPath, GOOGLE_API_CERTIFICATE_CONFIG, TOTAL_TIMEOUT_MS / 1000));
        warned = true;
      }
      try {
        timeService.sleep(sleepInterval);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException(
            "Interrupted while waiting for Agent Identity certificate files for bound token request.",
            e);
      }
    }
    throw new IOException(
        "Unable to find Agent Identity certificate config or file for bound token request after multiple retries. Token binding protection is failing. You can turn off this protection by setting "
            + GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES
            + " to false to fall back to unbound tokens.");
  }

  /** Searches for certificates at well-known locations with retry logic. */
  private static String getWellKnownCertificatePathWithRetry() throws IOException {
    String bundlePath = Paths.get(wellKnownDir, "credentialbundle.pem").toString();
    String certOnlyPath = Paths.get(wellKnownDir, "certificates.pem").toString();

    boolean warned = false;
    for (long sleepInterval : POLLING_INTERVALS) {
      try {
        if (checkExistsOrAccessDenied(Paths.get(bundlePath))) {
          return bundlePath;
        }
        if (checkExistsOrAccessDenied(Paths.get(certOnlyPath))) {
          return certOnlyPath;
        }
      } catch (java.nio.file.AccessDeniedException e) {
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            "Permission denied reading well-known certificates. Falling back to unbound token.");
        return null;
      } catch (Exception e) {
        // Fall through to retry
      }
      if (!warned) {
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            String.format(
                "Well-known certificate file not found at %s. Retrying for up to %d seconds.",
                wellKnownDir, TOTAL_TIMEOUT_MS / 1000));
        warned = true;
      }
      try {
        timeService.sleep(sleepInterval);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException("Interrupted while waiting for well-known certificate files.", e);
      }
    }
    throw new IOException(
        "Unable to find well-known certificate file for bound token request after multiple retries.");
  }

  /** Reads the full certificate chain from the specified path as a string. */
  static String readCertificateChain(String certPath) throws IOException {
    return new String(Files.readAllBytes(Paths.get(certPath)), StandardCharsets.UTF_8);
  }

  /**
   * Verifies that the private key corresponds to the public key in the certificate by performing a
   * test signature and verification.
   */
  static boolean verifyKeyPair(X509Certificate cert, PrivateKey privateKey) {
    try {
      byte[] data = "verification-data".getBytes(StandardCharsets.UTF_8);

      String keyAlgorithm = cert.getPublicKey().getAlgorithm();
      String sigAlg;
      if ("RSA".equals(keyAlgorithm)) {
        sigAlg = "SHA256withRSA";
      } else if ("EC".equals(keyAlgorithm)) {
        sigAlg = "SHA256withECDSA";
      } else {
        throw new IllegalArgumentException("Unsupported key algorithm: " + keyAlgorithm);
      }

      Signature signer = Signature.getInstance(sigAlg);
      signer.initSign(privateKey);
      signer.update(data);
      byte[] signature = signer.sign();

      Signature verifier = Signature.getInstance(sigAlg);
      verifier.initVerify(cert.getPublicKey());
      verifier.update(data);

      return verifier.verify(signature);
    } catch (Exception e) {
      LOGGER.warn("Key pair verification failed", e);
      return false;
    }
  }

  /** Reads the private key from the specified path using PKCS8 format. */
  static PrivateKey readPrivateKey(String keyPath, String algorithm) throws IOException {
    String keyPem = new String(Files.readAllBytes(Paths.get(keyPath)), StandardCharsets.UTF_8);
    OAuth2Utils.Pkcs8Algorithm pkcs8Alg =
        "EC".equals(algorithm) ? OAuth2Utils.Pkcs8Algorithm.EC : OAuth2Utils.Pkcs8Algorithm.RSA;
    return OAuth2Utils.privateKeyFromPkcs8(keyPem, pkcs8Alg);
  }

  /**
   * Determines if mTLS should be enabled based on environment variables and certificate presence.
   */
  static boolean shouldEnableMtls(boolean certsPresent, boolean configExists) throws IOException {
    String useClientCert = envReader.getEnv("GOOGLE_API_USE_CLIENT_CERTIFICATE");

    // Case 1: Explicitly enabled via environment variable
    if ("true".equalsIgnoreCase(useClientCert)) {
      if (certsPresent) {
        // Certs are available, enable mTLS
        return true;
      }
      if (configExists) {
        // Config exists but files are missing - fail fast
        throw new IOException(
            "Certificate intent established via config, but cert files are missing.");
      }
      // Neither exist, do not enable
      return false;
    }
    // Case 2: Explicitly disabled via environment variable
    else if ("false".equalsIgnoreCase(useClientCert)) {
      if (certsPresent) {
        // Warn that we are ignoring present certs because it was explicitly disabled
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            "Token binding protection is disabled because mTLS was explicitly disabled via GOOGLE_API_USE_CLIENT_CERTIFICATE.");
        return false;
      }
      return false;
    }
    // Case 3: Environment variable is unset
    else {
      if (certsPresent) {
        // Infer mTLS is enabled because certs are present
        return true;
      }
      if (configExists) {
        // Config exists but files are missing - fail fast
        throw new IOException(
            "Certificate intent inferred via config, but cert files are missing.");
      }
      // Neither cert-config nor certs exist, do not enable
      return false;
    }
  }

  /** Retrieves the bound token payload (certificate chain) if applicable. */
  static String getBoundTokenPayload() throws IOException {
    CertInfo info = getAgentIdentityCertInfo();
    if (info != null && shouldRequestBoundToken(info.certificate)) {
      return info.certContent;
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  /** Extracts the certificate and private key paths from the JSON configuration file. */
  private static ResolvedCertAndKeyPaths extractPathsFromConfig(String certConfigPath) throws IOException {
    try (InputStream stream = Files.newInputStream(Paths.get(certConfigPath))) {
      JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
      GenericJson config = parser.parseAndClose(stream, StandardCharsets.UTF_8, GenericJson.class);
      Object certConfigsObj = config.get("cert_configs");
      if (certConfigsObj instanceof Map) {
        Map certConfigs = (Map) certConfigsObj;
        Object workloadObj = certConfigs.get("workload");
        if (workloadObj instanceof Map) {
          Map workload = (Map) workloadObj;
          String certPath = null;
          String keyPath = null;
          if (workload.get("cert_path") instanceof String) {
            certPath = (String) workload.get("cert_path");
          }
          if (workload.get("key_path") instanceof String) {
            keyPath = (String) workload.get("key_path");
          }
          return new ResolvedCertAndKeyPaths(certPath, keyPath);
        }
      }
    } catch (java.nio.file.AccessDeniedException e) {
      throw e;
    } catch (Exception e) {
      throw new IOException("Failed to parse Agent Identity config JSON", e);
    }
    return null;
  }

  /** Parses the X509 certificate from the specified content string. */
  private static X509Certificate parseCertificateContent(String certContent) throws IOException {
    try (InputStream stream = new java.io.ByteArrayInputStream(certContent.getBytes(StandardCharsets.UTF_8))) {
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      return (X509Certificate) cf.generateCertificate(stream);
    } catch (GeneralSecurityException e) {
      throw new IOException(
          "Failed to parse Agent Identity certificate for bound token request.", e);
    }
  }

  /**
   * Determines if a bound token should be requested by checking if any of the certificate's Subject
   * Alternative Names (SANs) match allowed SPIFFE patterns.
   */
  static boolean shouldRequestBoundToken(X509Certificate cert) {
    try {
      Collection<List<?>> sans = cert.getSubjectAlternativeNames();
      if (sans == null) {
        return false;
      }
      // Iterate through all Subject Alternative Names
      for (List<?> san : sans) {
        // Check if the SAN entry is a URI (type 6)
        if (san.size() >= 2
            && san.get(0) instanceof Integer
            && (Integer) san.get(0) == SAN_URI_TYPE) {
          Object value = san.get(1);
          if (value instanceof String) {
            String uri = (String) value;
            // Check if the URI starts with "spiffe://"
            if (uri.startsWith(SPIFFE_SCHEME_PREFIX)) {
              String withoutScheme = uri.substring(SPIFFE_SCHEME_PREFIX.length());
              int slashIndex = withoutScheme.indexOf('/');
              // Extract the trust domain (part before the first slash)
              String trustDomain =
                  (slashIndex == -1) ? withoutScheme : withoutScheme.substring(0, slashIndex);
              // Match the trust domain against allowed agent patterns
              for (Pattern pattern : AGENT_IDENTITY_SPIFFE_PATTERNS) {
                if (pattern.matcher(trustDomain).matches()) {
                  return true;
                }
              }
            }
          }
        }
      }
    } catch (CertificateParsingException e) {
      LOGGER.warn("Failed to parse Subject Alternative Names from certificate", e);
    }
    return false;
  }

  @VisibleForTesting
  public static void setEnvReader(EnvReader reader) {
    envReader = reader;
  }

  @VisibleForTesting
  static void setTimeService(TimeService service) {
    timeService = service;
  }

  @VisibleForTesting
  static void resetTimeService() {
    timeService =
        new TimeService() {
          @Override
          public long currentTimeMillis() {
            return System.currentTimeMillis();
          }

          @Override
          public void sleep(long millis) throws InterruptedException {
            Thread.sleep(millis);
          }
        };
  }
}
