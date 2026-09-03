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
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Utility class for Agent Identity runtime certificate discovery and token binding. */
@InternalApi
public final class AgentIdentityUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(AgentIdentityUtils.class);

  // Environment variables
  /**
   * Environment variable pointing to the client certificate configuration file.
   *
   * <p>If set, certificate and key paths are resolved from the configuration file specified by this
   * variable.
   */
  public static final String GOOGLE_API_CERTIFICATE_CONFIG = "GOOGLE_API_CERTIFICATE_CONFIG";

  /**
   * Environment variable to explicitly enable or disable runtime token binding. Defaults to true if
   * unset.
   */
  public static final String GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN =
      "GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN";

  /**
   * Legacy Cloud Run environment variable to prevent agent token sharing for GCP services. Used as
   * a fallback if {@link #GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN} is unset.
   */
  public static final String GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES =
      "GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES";

  /**
   * Environment variable to explicitly enable or disable client certificate authentication (mTLS).
   *
   * <p>When set to {@code "true"}, mTLS is enforced. When set to {@code "false"}, mTLS and token
   * binding are disabled.
   */
  public static final String GOOGLE_API_USE_CLIENT_CERTIFICATE =
      "GOOGLE_API_USE_CLIENT_CERTIFICATE";

  // Allowed SPIFFE trust domain patterns for agentic identities.
  private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS =
      ImmutableList.of(
          Pattern.compile("^agents\\.global\\.org-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents\\.global\\.proj-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents-nonprod\\.global\\.org-\\d+\\.system\\.id\\.goog$"),
          Pattern.compile("^agents-nonprod\\.global\\.proj-\\d+\\.system\\.id\\.goog$"));

  // Subject Alternative Name (SAN) type for URI as defined in RFC 5280 Section 4.2.1.6.
  private static final int SAN_URI_TYPE = 6;

  private static final String SPIFFE_SCHEME_PREFIX = "spiffe://";

  private static String wellKnownDir = "/var/run/secrets/workload-spiffe-credentials/";

  @VisibleForTesting
  static void setWellKnownDir(final String dir) {
    wellKnownDir = dir;
  }

  // Retries for verifying certificate and private key matching during atomic key rotation.
  private static final int CERT_KEY_MATCH_RETRIES = 3;

  private static final long CERT_KEY_MATCH_RETRY_INTERVAL_MS = 100;

  // Polling configuration for initial container startup credential file readiness.
  // Matches Python google-auth implementation (_agent_identity_utils.py) for initial
  // asynchronous credential delivery (50 * 100ms + 50 * 500ms = 30 seconds total).
  private static final int FAST_POLL_CYCLES = 50;

  private static final long FAST_POLL_INTERVAL_MS = 100; // 0.1 seconds

  private static final long SLOW_POLL_INTERVAL_MS = 500; // 0.5 seconds

  private static final long TOTAL_TIMEOUT_MS = 30000; // 30 seconds

  private static final int TOTAL_POLL_CYCLES =
      FAST_POLL_CYCLES
          + (int)
              ((TOTAL_TIMEOUT_MS - (FAST_POLL_CYCLES * FAST_POLL_INTERVAL_MS))
                  / SLOW_POLL_INTERVAL_MS);

  private static long getSleepIntervalMs(final int cycle) {
    return (cycle < FAST_POLL_CYCLES) ? FAST_POLL_INTERVAL_MS : SLOW_POLL_INTERVAL_MS;
  }

  /** Functional interface for reading environment variables to facilitate testing. */
  public interface EnvReader {
    /**
     * Returns the value of the specified environment variable.
     *
     * @param name the environment variable name
     * @return the value of the variable, or {@code null} if unset
     */
    String getEnv(final String name);
  }

  private static EnvReader envReader = System::getenv;

  @VisibleForTesting
  interface TimeService {
    long currentTimeMillis();

    /**
     * Causes the currently executing thread to sleep for the specified number of milliseconds.
     *
     * @param millis the length of time to sleep in milliseconds
     * @throws InterruptedException if interrupted while sleeping
     */
    void sleep(final long millis) throws InterruptedException;
  }

  private static TimeService timeService =
      new TimeService() {
        @Override
        public long currentTimeMillis() {
          return System.currentTimeMillis();
        }

        @Override
        public void sleep(final long millis) throws InterruptedException {
          Thread.sleep(millis);
        }
      };

  private AgentIdentityUtils() {}

  /**
   * Holds the parsed {@link X509Certificate} and cached PEM certificate chain content for token
   * binding.
   *
   * <p>This class intentionally stores in-memory certificate content rather than file paths to
   * prevent redundant filesystem reads and race conditions when binding tokens to requests.
   */
  static class CertInfo {
    private final X509Certificate certificate;
    private final String certContent;

    CertInfo(final X509Certificate certificate, final String certContent) {
      this.certificate = certificate;
      this.certContent = certContent;
    }

    /** Returns the parsed {@link X509Certificate}. */
    public X509Certificate getCertificate() {
      return certificate;
    }

    /** Returns the raw PEM certificate chain content. */
    public String getCertContent() {
      return certContent;
    }
  }

  /** Holds the resolved filesystem paths for the certificate and private key. */
  static class ResolvedCertAndKeyPaths {
    private final String certPath;
    private final String keyPath;
    private final boolean hasWorkloadConfig;

    ResolvedCertAndKeyPaths(final String certPath, final String keyPath) {
      this(certPath, keyPath, !Strings.isNullOrEmpty(certPath));
    }

    ResolvedCertAndKeyPaths(
        final String certPath, final String keyPath, final boolean hasWorkloadConfig) {
      this.certPath = certPath;
      this.keyPath = keyPath;
      this.hasWorkloadConfig = hasWorkloadConfig;
    }

    /** Returns the path to the certificate or bundle file. */
    public String getCertPath() {
      return certPath;
    }

    /** Returns the path to the private key file, or bundle path if combined. */
    public String getKeyPath() {
      return keyPath;
    }

    /** Returns whether a workload configuration was parsed from the certificate config file. */
    public boolean hasWorkloadConfig() {
      return hasWorkloadConfig;
    }
  }

  /** Checks whether the given path resides within the well-known certificate directory. */
  static boolean isPathInWellKnownDir(final String pathStr) {
    if (Strings.isNullOrEmpty(pathStr) || Strings.isNullOrEmpty(wellKnownDir)) {
      return false;
    }
    try {
      Path path = Paths.get(pathStr).toAbsolutePath().normalize();
      Path wellKnown = Paths.get(wellKnownDir).toAbsolutePath().normalize();
      return path.startsWith(wellKnown);
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Retrieves the certificate and raw PEM content for the Agent Identity.
   *
   * <p>This method attempts to load the certificate and private key for the agent identity. It
   * first checks the location specified by the {@code GOOGLE_API_CERTIFICATE_CONFIG} environment
   * variable. If not set, it falls back to well-known default locations.
   *
   * <p>To handle transient race conditions during certificate rotation on disk, this method employs
   * a retry mechanism with backoff when reading the configuration and certificate files.
   *
   * @return A {@link CertInfo} object containing the parsed {@link X509Certificate} and its raw PEM
   *     chain content, or {@code null} if the agent identity features are disabled, opted out, or
   *     if no valid credentials could be loaded.
   * @throws IOException If an I/O error occurs while reading the files, or if the key-pair
   *     verification fails after retries.
   */
  static CertInfo getAgentIdentityCertInfo() throws IOException {
    if (!isTokenBindingEnabled()) {
      return null;
    }
    String useClientCert = envReader.getEnv(GOOGLE_API_USE_CLIENT_CERTIFICATE);
    if ("false".equalsIgnoreCase(useClientCert)) {
      Slf4jUtils.log(
          LOGGER,
          org.slf4j.event.Level.WARN,
          Collections.emptyMap(),
          "Token binding protection is disabled because mTLS was explicitly disabled"
              + " via GOOGLE_API_USE_CLIENT_CERTIFICATE.");
      return null;
    }
    String certConfigPath = envReader.getEnv(GOOGLE_API_CERTIFICATE_CONFIG);
    ResolvedCertAndKeyPaths paths = resolveCertAndKeyPaths(certConfigPath);
    boolean configExists = paths != null && paths.hasWorkloadConfig();
    boolean certsPresent =
        paths != null
            && !Strings.isNullOrEmpty(paths.getCertPath())
            && Files.exists(Paths.get(paths.getCertPath()));

    if (!shouldEnableMtls(certsPresent, configExists)) {
      return null;
    }

    return loadAndVerifyCredentials(paths.getCertPath(), paths.getKeyPath());
  }

  /**
   * Resolves the paths for the certificate and private key based on the config path or well-known
   * locations.
   */
  static ResolvedCertAndKeyPaths resolveCertAndKeyPaths(final String certConfigPath)
      throws IOException {
    if (!Strings.isNullOrEmpty(certConfigPath)) {
      java.nio.file.Path configPath = Paths.get(certConfigPath);
      try {
        if (!checkExistsOrAccessDenied(configPath) && !isPathInWellKnownDir(certConfigPath)) {
          // Fail-fast if config doesn't exist and is not in well-known directory
          return new ResolvedCertAndKeyPaths(null, null, false);
        }
      } catch (java.nio.file.AccessDeniedException e) {
        throw new IOException(
            "Permission denied reading certificate config file: " + certConfigPath, e);
      }
      // Read cert and key paths from config file. We use retry with backoff to handle
      // transient race conditions where the config file might be being updated by a rotation
      // process.
      ResolvedCertAndKeyPaths paths = getPathsFromConfigWithRetry(certConfigPath);
      if (paths != null) {
        return paths;
      }
      return new ResolvedCertAndKeyPaths(null, null, false);
    } else {
      if (!Files.exists(Paths.get(wellKnownDir))) {
        // Fail-fast if well-known dir doesn't exist (e.g. workstation)
        return new ResolvedCertAndKeyPaths(null, null, false);
      }
      // Fallback to well-known locations. We use retry with backoff here as well to handle
      // race conditions during file replacement by a rotation process.
      String certPath = getWellKnownCertificatePathWithRetry();
      String keyPath = null;
      if (certPath != null) {
        if (certPath.endsWith("credentialbundle.pem")) {
          keyPath = certPath; // Bundle contains both
        } else if (certPath.endsWith("certificates.pem")) {
          keyPath = Paths.get(wellKnownDir, "private_key.pem").toString();
        }
        return new ResolvedCertAndKeyPaths(certPath, keyPath, false);
      }
      return new ResolvedCertAndKeyPaths(null, null, false);
    }
  }

  /**
   * Loads the certificate and private key, and verifies that they form a valid cryptographic
   * key-pair, supporting both separate files and combined bundle files.
   *
   * @param certPath The path to the certificate or bundle file.
   * @param keyPath The path to the private key or bundle file.
   * @return A {@link CertInfo} object containing the parsed {@link X509Certificate} and the raw PEM
   *     certificate chain (with private keys stripped).
   * @throws IOException If the files cannot be read or parsed, or if key-pair verification fails.
   */
  static CertInfo loadAndVerifyCredentials(final String certPath, final String keyPath)
      throws IOException {
    X509Certificate cert = null;
    PrivateKey privateKey = null;
    String certContent = null;

    if (!Strings.isNullOrEmpty(certPath)
        && !Strings.isNullOrEmpty(keyPath)
        && Files.exists(Paths.get(keyPath))) {
      // Verify match with retry (handles both separate files and combined bundle files)
      int retries = 0;
      boolean matched = false;
      while (retries < CERT_KEY_MATCH_RETRIES) {
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
          if (!Strings.isNullOrEmpty(envReader.getEnv(GOOGLE_API_CERTIFICATE_CONFIG))) {
            throw new IOException(
                "Permission denied reading certificate or key files for Agent Identity.", e);
          }
          Slf4jUtils.log(
              LOGGER,
              org.slf4j.event.Level.WARN,
              Collections.emptyMap(),
              "Permission denied reading certificate or key files. Falling back to"
                  + " unbound token.");
          return null;
        } catch (Exception e) {
          LOGGER.warn("Failed to read or verify cert/key, retrying...", e);
        }

        retries++;
        if (retries < CERT_KEY_MATCH_RETRIES) {
          try {
            timeService.sleep(CERT_KEY_MATCH_RETRY_INTERVAL_MS); // 0.1 seconds backoff
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while waiting for cert/key match.", e);
          }
        }
      }

      if (!matched) {
        throw new IOException(
            String.format(
                "Agent Identity certificate and private key mismatch or read"
                    + " failure after %d retries.",
                CERT_KEY_MATCH_RETRIES));
      }
    } else if (!Strings.isNullOrEmpty(certPath)) {
      // Only certificate available (no private key specified or found)
      try {
        certContent = readCertificateChain(certPath);
        cert = parseCertificateContent(certContent);
      } catch (java.nio.file.AccessDeniedException e) {
        if (!Strings.isNullOrEmpty(envReader.getEnv(GOOGLE_API_CERTIFICATE_CONFIG))) {
          throw new IOException(
              "Permission denied reading certificate files for Agent Identity.", e);
        }
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            "Permission denied reading certificate files. Falling back to unbound" + " token.");
        return null;
      }
    }

    return new CertInfo(cert, certContent);
  }

  /** Checks if a file exists, throwing AccessDeniedException if permission is denied. */
  private static boolean checkExistsOrAccessDenied(final java.nio.file.Path path)
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
   * Checks if runtime token binding is enabled.
   *
   * <p>Checks {@link #GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN} first; if unset, falls back to the
   * legacy {@link #GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES}. Defaults to {@code
   * true} if neither is set.
   */
  private static boolean isTokenBindingEnabled() {
    String enableRuntimeBoundToken = envReader.getEnv(GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN);
    if (!Strings.isNullOrEmpty(enableRuntimeBoundToken)) {
      return !"false".equalsIgnoreCase(enableRuntimeBoundToken.trim());
    }
    String legacyPreventSharing =
        envReader.getEnv(GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES);
    if (!Strings.isNullOrEmpty(legacyPreventSharing)) {
      return !"false".equalsIgnoreCase(legacyPreventSharing.trim());
    }
    return true;
  }

  /**
   * Reads the certificate path from the config file with retry logic to handle rotation race
   * conditions.
   */
  private static ResolvedCertAndKeyPaths getPathsFromConfigWithRetry(final String certConfigPath)
      throws IOException {
    boolean shouldPoll = isPathInWellKnownDir(certConfigPath);
    int maxCycles = shouldPoll ? TOTAL_POLL_CYCLES : 1;
    boolean warned = false;

    for (int cycle = 0; cycle < maxCycles; cycle++) {
      try {
        if (checkExistsOrAccessDenied(Paths.get(certConfigPath))) {
          ResolvedCertAndKeyPaths paths = extractPathsFromConfig(certConfigPath);
          if (paths != null) {
            if (!paths.hasWorkloadConfig()) {
              // Valid non-workload config (e.g. enterprise certs) - exit early without polling!
              return paths;
            }
            if (!Strings.isNullOrEmpty(paths.getCertPath())
                && checkExistsOrAccessDenied(Paths.get(paths.getCertPath()))) {
              return paths;
            }
            if (!shouldPoll) {
              // Cert file not ready and not in well-known dir - exit early
              return paths;
            }
          }
        } else if (!shouldPoll) {
          // Config file doesn't exist and not in well-known dir - exit early
          return new ResolvedCertAndKeyPaths(null, null, false);
        }
      } catch (java.nio.file.AccessDeniedException e) {
        throw new IOException(
            "Permission denied reading certificate config file: " + certConfigPath, e);
      } catch (IOException e) {
        if (e.getMessage() != null
            && e.getMessage().contains("Failed to parse Agent Identity config JSON")) {
          throw e; // Fail fast on malformed JSON syntax errors
        }
        if (!shouldPoll) {
          return new ResolvedCertAndKeyPaths(null, null, false);
        }
        // Fall through to retry
      }
      if (!warned) {
        Slf4jUtils.log(
            LOGGER,
            org.slf4j.event.Level.WARN,
            Collections.emptyMap(),
            String.format(
                "Certificate config file not found or invalid at %s (from %s"
                    + " environment variable). Retrying for up to %d seconds.",
                certConfigPath, GOOGLE_API_CERTIFICATE_CONFIG, TOTAL_TIMEOUT_MS / 1000));
        warned = true;
      }
      try {
        timeService.sleep(getSleepIntervalMs(cycle));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException(
            "Interrupted while waiting for Agent Identity certificate files for bound"
                + " token request.",
            e);
      }
    }
    throw new IOException(
        "Unable to find Agent Identity certificate config or file for bound token request"
            + " after multiple retries. Token binding protection is failing. You can turn"
            + " off this protection by setting "
            + GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN
            + " to false to fall back to unbound tokens.");
  }

  /** Searches for certificates at well-known locations with retry logic. */
  private static String getWellKnownCertificatePathWithRetry() throws IOException {
    String bundlePath = Paths.get(wellKnownDir, "credentialbundle.pem").toString();
    String certOnlyPath = Paths.get(wellKnownDir, "certificates.pem").toString();

    // 1) First check immediately without sleeping:
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
          "Permission denied reading well-known certificates. Falling back to unbound" + " token.");
      return null;
    } catch (Exception e) {
      // Fall through
    }

    // 2) If not found immediately, only enter retry loop if mTLS was explicitly enabled:
    String useClientCert = envReader.getEnv(GOOGLE_API_USE_CLIENT_CERTIFICATE);
    if (!"true".equalsIgnoreCase(useClientCert)) {
      Slf4jUtils.log(
          LOGGER,
          org.slf4j.event.Level.DEBUG,
          Collections.emptyMap(),
          String.format(
              "Well-known certificate file not found at %s and %s is not"
                  + " explicitly enabled; falling back to unbound token without"
                  + " retrying.",
              wellKnownDir, GOOGLE_API_USE_CLIENT_CERTIFICATE));
      return null;
    }

    // 3) Retry loop for rotation/transient absence when explicitly enabled:
    boolean warned = false;
    for (int cycle = 0; cycle < TOTAL_POLL_CYCLES; cycle++) {
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
            "Permission denied reading well-known certificates. Falling back to unbound"
                + " token.");
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
                "Well-known certificate file not found at %s. Retrying for up to" + " %d seconds.",
                wellKnownDir, TOTAL_TIMEOUT_MS / 1000));
        warned = true;
      }
      try {
        timeService.sleep(getSleepIntervalMs(cycle));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException("Interrupted while waiting for well-known certificate files.", e);
      }
    }
    Slf4jUtils.log(
        LOGGER,
        org.slf4j.event.Level.WARN,
        Collections.emptyMap(),
        String.format(
            "Unable to find well-known certificate file at %s after retrying;"
                + " falling back to unbound token.",
            wellKnownDir));
    return null;
  }

  /**
   * Reads the full certificate chain from the specified path as a PEM string.
   *
   * <p>Extracts only the {@code -----BEGIN CERTIFICATE-----} blocks using {@link
   * CertificateIdentityPoolSubjectTokenSupplier#PEM_CERT_PATTERN}, stripping any private keys or
   * non-certificate data that may be present in a combined bundle file.
   */
  static String readCertificateChain(final String certPath) throws IOException {
    byte[] certData = Files.readAllBytes(Paths.get(certPath));
    String content = new String(certData, StandardCharsets.UTF_8);
    Matcher matcher = CertificateIdentityPoolSubjectTokenSupplier.PEM_CERT_PATTERN.matcher(content);
    StringBuilder certChain = new StringBuilder();
    while (matcher.find()) {
      certChain.append(matcher.group(0)).append("\n");
    }
    if (certChain.length() == 0) {
      throw new IOException("No PEM certificates found in certificate file: " + certPath);
    }
    return certChain.toString();
  }

  /**
   * Verifies that the private key corresponds to the public key in the certificate by performing a
   * test signature and verification.
   */
  static boolean verifyKeyPair(final X509Certificate cert, final PrivateKey privateKey) {
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
  static PrivateKey readPrivateKey(final String keyPath, final String algorithm)
      throws IOException {
    String keyPem = new String(Files.readAllBytes(Paths.get(keyPath)), StandardCharsets.UTF_8);
    OAuth2Utils.Pkcs8Algorithm pkcs8Alg =
        "EC".equals(algorithm) ? OAuth2Utils.Pkcs8Algorithm.EC : OAuth2Utils.Pkcs8Algorithm.RSA;
    return OAuth2Utils.privateKeyFromPkcs8(keyPem, pkcs8Alg);
  }

  /**
   * Determines if mTLS should be enabled based on environment variables and certificate presence.
   */
  static boolean shouldEnableMtls(final boolean certsPresent, final boolean configExists)
      throws IOException {
    String useClientCert = envReader.getEnv(GOOGLE_API_USE_CLIENT_CERTIFICATE);

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
            "Token binding protection is disabled because mTLS was explicitly disabled"
                + " via GOOGLE_API_USE_CLIENT_CERTIFICATE.");
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
    if (info != null && shouldRequestBoundToken(info.getCertificate())) {
      return info.getCertContent();
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  /** Extracts the certificate and private key paths from the JSON configuration file. */
  private static ResolvedCertAndKeyPaths extractPathsFromConfig(final String certConfigPath)
      throws IOException {
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
          return new ResolvedCertAndKeyPaths(certPath, keyPath, true);
        }
        // Valid cert_configs object but not a workload config (e.g. enterprise certificates)
        return new ResolvedCertAndKeyPaths(null, null, false);
      }
      return new ResolvedCertAndKeyPaths(null, null, false);
    } catch (java.nio.file.AccessDeniedException e) {
      throw e;
    } catch (Exception e) {
      throw new IOException("Failed to parse Agent Identity config JSON", e);
    }
  }

  /** Parses the X509 certificate from the specified content string. */
  private static X509Certificate parseCertificateContent(final String certContent)
      throws IOException {
    try (InputStream stream =
        new java.io.ByteArrayInputStream(certContent.getBytes(StandardCharsets.UTF_8))) {
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
  static boolean shouldRequestBoundToken(final X509Certificate cert) {
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

  /** Sets the environment variable reader for testing. */
  @VisibleForTesting
  public static void setEnvReader(EnvReader reader) {
    envReader = reader;
  }

  /** Sets the time and sleep service for testing. */
  @VisibleForTesting
  static void setTimeService(TimeService service) {
    timeService = service;
  }

  /** Resets the time and sleep service back to default system implementation. */
  @VisibleForTesting
  static void resetTimeService() {
    timeService =
        new TimeService() {
          @Override
          public long currentTimeMillis() {
            return System.currentTimeMillis();
          }

          @Override
          public void sleep(final long millis) throws InterruptedException {
            Thread.sleep(millis);
          }
        };
  }
}
