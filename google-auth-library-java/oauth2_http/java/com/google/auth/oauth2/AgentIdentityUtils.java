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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
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
import java.util.Objects;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Utility class for Agent Identity runtime certificate discovery and token binding. */
@InternalApi
public final class AgentIdentityUtils {

  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(AgentIdentityUtils.class);

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

  private static volatile String wellKnownDir = "/var/run/secrets/workload-spiffe-credentials/";

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

  private static volatile EnvironmentProvider environmentProvider =
      SystemEnvironmentProvider.getInstance();

  @VisibleForTesting
  @FunctionalInterface
  interface TimeService {
    /**
     * Causes the currently executing thread to sleep for the specified number of milliseconds.
     *
     * @param millis the length of time to sleep in milliseconds
     * @throws InterruptedException if interrupted while sleeping
     */
    void sleep(final long millis) throws InterruptedException;
  }

  private static volatile TimeService timeService = Thread::sleep;

  // Tracks whether initial container startup discovery has completed. The 30-second
  // polling loop (TOTAL_POLL_CYCLES) is strictly limited to initial startup so subsequent
  // token refreshes never block for 30 seconds.
  private static volatile boolean initialStartupCompleted = false;

  // Tracks whether the warning for explicitly disabled mTLS when certificates are present
  // has already been logged in this process to prevent log spam on repeated token refreshes.
  private static volatile boolean mtlsDisabledWarningLogged = false;

  // In-memory cache of verified credentials to avoid redundant disk reads, X.509/PKCS#8 parsing,
  // and cryptographic signature verification on every token refresh when files are unchanged.
  private static volatile CachedCredentials cachedCredentials;

  /**
   * Captures filesystem metadata (path, modification time, size, and OS file key/inode) for a
   * certificate or key file to detect credential rotation on disk without re-parsing unchanged
   * files.
   */
  private static final class FileMetadata {
    private final String path;
    private final FileTime lastModifiedTime;
    private final long size;
    private final Object fileKey;

    private FileMetadata(
        final String path, final FileTime lastModifiedTime, final long size, final Object fileKey) {
      this.path = path;
      this.lastModifiedTime = lastModifiedTime;
      this.size = size;
      this.fileKey = fileKey;
    }

    /** Reads the current filesystem attributes for the given file path. */
    static FileMetadata of(final String pathStr) throws IOException {
      if (Strings.isNullOrEmpty(pathStr)) {
        return null;
      }
      Path path = Paths.get(pathStr);
      BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
      return new FileMetadata(pathStr, attrs.lastModifiedTime(), attrs.size(), attrs.fileKey());
    }

    /** Returns true if the given metadata matches this file's path, mtime, size, and file key. */
    boolean matches(final FileMetadata other) {
      if (other == null) {
        return false;
      }
      return Objects.equals(this.path, other.path)
          && Objects.equals(this.lastModifiedTime, other.lastModifiedTime)
          && this.size == other.size
          && Objects.equals(this.fileKey, other.fileKey);
    }
  }

  /**
   * Stores an in-memory snapshot of verified Agent Identity credentials and their associated
   * filesystem metadata to avoid redundant disk I/O and cryptographic checks on subsequent token
   * refreshes.
   */
  private static final class CachedCredentials {
    private final FileMetadata certMetadata;
    private final FileMetadata keyMetadata;
    private final boolean shouldRequestBoundToken;
    private final CertInfo certInfo;

    CachedCredentials(
        final FileMetadata certMetadata,
        final FileMetadata keyMetadata,
        final boolean shouldRequestBoundToken,
        final CertInfo certInfo) {
      this.certMetadata = certMetadata;
      this.keyMetadata = keyMetadata;
      this.shouldRequestBoundToken = shouldRequestBoundToken;
      this.certInfo = certInfo;
    }
  }

  private AgentIdentityUtils() {}

  private static long getSleepIntervalMs(final int cycle) {
    return (cycle < FAST_POLL_CYCLES) ? FAST_POLL_INTERVAL_MS : SLOW_POLL_INTERVAL_MS;
  }

  private static String getTrimmedEnv(final String name) {
    String val = environmentProvider.getEnv(name);
    return val != null ? val.trim() : null;
  }

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
    X509Certificate getCertificate() {
      return certificate;
    }

    /** Returns the raw PEM certificate chain content. */
    String getCertContent() {
      return certContent;
    }
  }

  /** Holds the resolved filesystem paths for the certificate and private key. */
  static class ResolvedCertAndKeyPaths {
    private final String certPath;
    private final String keyPath;
    private final boolean hasWorkloadConfig;

    ResolvedCertAndKeyPaths(
        final String certPath, final String keyPath, final boolean hasWorkloadConfig) {
      this.certPath = certPath;
      this.keyPath = keyPath;
      this.hasWorkloadConfig = hasWorkloadConfig;
    }

    /** Returns the path to the certificate or bundle file. */
    String getCertPath() {
      return certPath;
    }

    /** Returns the path to the private key file, or bundle path if combined. */
    String getKeyPath() {
      return keyPath;
    }

    /** Returns whether a workload configuration was parsed from the certificate config file. */
    boolean hasWorkloadConfig() {
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
    CachedCredentials initialCached = cachedCredentials;
    String certConfigPath = getTrimmedEnv(GOOGLE_API_CERTIFICATE_CONFIG);
    ResolvedCertAndKeyPaths paths = resolveCertAndKeyPaths(certConfigPath, initialCached);
    boolean configExists = paths != null && paths.hasWorkloadConfig();
    CachedCredentials latestCached = cachedCredentials;
    boolean certsPresent =
        paths != null
            && !Strings.isNullOrEmpty(paths.getCertPath())
            && (Files.exists(Paths.get(paths.getCertPath()))
                || matchesCachedPath(paths.getCertPath(), initialCached)
                || matchesCachedPath(paths.getCertPath(), latestCached));

    if (!shouldEnableMtls(certsPresent, configExists)) {
      return null;
    }

    return loadAndVerifyCredentials(paths.getCertPath(), paths.getKeyPath(), initialCached);
  }

  private static boolean matchesCachedPath(final String certPath, final CachedCredentials cached) {
    return cached != null
        && cached.certMetadata != null
        && certPath.equals(cached.certMetadata.path);
  }

  private static CachedCredentials getLatestOrInitialCache(final CachedCredentials initialCached) {
    CachedCredentials latest = cachedCredentials;
    return latest != null ? latest : initialCached;
  }

  /**
   * Resolves the paths for the certificate and private key based on the config path or well-known
   * locations.
   */
  static ResolvedCertAndKeyPaths resolveCertAndKeyPaths(
      final String certConfigPath, final CachedCredentials cached) throws IOException {
    try {
      if (!Strings.isNullOrEmpty(certConfigPath)) {
        // Read cert and key paths from config file. We use retry with backoff to handle
        // startup delivery (when in well-known directory) and transient rotation race conditions.
        return getPathsFromConfigWithRetry(certConfigPath, cached);
      } else {
        if (!Files.exists(Paths.get(wellKnownDir))) {
          // Fail-fast if well-known dir doesn't exist (e.g. workstation)
          return new ResolvedCertAndKeyPaths(null, null, false);
        }
        // Fallback to well-known locations. We use retry with backoff here as well to handle
        // race conditions during file replacement by a rotation process.
        String certPath = getWellKnownCertificatePathWithRetry(cached);
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
    } finally {
      initialStartupCompleted = true;
    }
  }

  /**
   * Safely updates the in-memory credential cache only if file metadata remained stable across the
   * read/verify operation. Re-statting is intentionally performed outside the main retry exception
   * handler so a transient unlink after verification never discards an already-verified result.
   */
  private static void tryUpdateCache(
      final FileMetadata certMetaBefore,
      final FileMetadata keyMetaBefore,
      final String certPath,
      final String keyPath,
      final boolean shouldRequestBoundToken,
      final CertInfo certInfo) {
    try {
      if (certMetaBefore == null) {
        return;
      }
      FileMetadata certMetaAfter = FileMetadata.of(certPath);
      if (!certMetaBefore.matches(certMetaAfter)) {
        return;
      }
      if (!shouldRequestBoundToken) {
        cachedCredentials = new CachedCredentials(certMetaBefore, null, false, null);
        return;
      }
      if (keyMetaBefore != null && !Strings.isNullOrEmpty(keyPath)) {
        FileMetadata keyMetaAfter = FileMetadata.of(keyPath);
        if (keyMetaBefore.matches(keyMetaAfter)) {
          cachedCredentials = new CachedCredentials(certMetaBefore, keyMetaBefore, true, certInfo);
        }
      }
    } catch (IOException ignored) {
      // Ignore re-stat failures; return verified result without caching.
    }
  }

  /**
   * Loads the certificate and private key, and verifies that they form a valid cryptographic
   * key-pair, supporting both separate files and combined bundle files.
   *
   * <p>Checks {@link #shouldRequestBoundToken(X509Certificate)} right after parsing the certificate
   * content before reading the private key or running signature verification. Caches verified
   * results in memory so unchanged files are not re-read and re-verified on every token refresh.
   *
   * @param certPath The path to the certificate or bundle file.
   * @param keyPath The path to the private key or bundle file.
   * @return A {@link CertInfo} object containing the parsed {@link X509Certificate} and the raw PEM
   *     certificate chain (with private keys stripped), or {@code null} if the certificate does not
   *     match agent SPIFFE patterns.
   * @throws IOException If the files cannot be read or parsed, if the private key is missing for an
   *     agent certificate, or if key-pair verification fails after retries.
   */
  static CertInfo loadAndVerifyCredentials(final String certPath, final String keyPath)
      throws IOException {
    return loadAndVerifyCredentials(certPath, keyPath, cachedCredentials);
  }

  static CertInfo loadAndVerifyCredentials(
      final String certPath, final String keyPath, final CachedCredentials initialCached)
      throws IOException {
    if (Strings.isNullOrEmpty(certPath)) {
      return null;
    }

    // Check in-memory cache fast-path before reading files or verifying keys
    CachedCredentials cached = getLatestOrInitialCache(initialCached);
    if (cached != null) {
      try {
        FileMetadata currentCertMeta = FileMetadata.of(certPath);
        if (currentCertMeta != null && currentCertMeta.matches(cached.certMetadata)) {
          if (!cached.shouldRequestBoundToken) {
            return null;
          }
          if (!Strings.isNullOrEmpty(keyPath)) {
            FileMetadata currentKeyMeta = FileMetadata.of(keyPath);
            if (currentKeyMeta != null && currentKeyMeta.matches(cached.keyMetadata)) {
              return cached.certInfo;
            }
          }
        }
      } catch (IOException ignored) {
        // File might be mid-rotation or temporarily unreadable; fall through to retry loop
      }
    }

    Exception lastException = null;
    int retries = 0;
    while (retries < CERT_KEY_MATCH_RETRIES) {
      try {
        lastException = null;
        FileMetadata certMeta = FileMetadata.of(certPath);
        String certContent = readCertificateChain(certPath);
        X509Certificate cert = parseCertificateContent(certContent);

        if (!shouldRequestBoundToken(cert)) {
          tryUpdateCache(certMeta, null, certPath, null, false, null);
          return null;
        }

        if (Strings.isNullOrEmpty(keyPath)) {
          throw new IOException(
              "Private key is required for Agent Identity bound token request, but key path is"
                  + " missing.");
        }

        FileMetadata keyMeta = FileMetadata.of(keyPath);
        PrivateKey privateKey = readPrivateKey(keyPath, cert.getPublicKey().getAlgorithm());

        if (verifyKeyPair(cert, privateKey)) {
          CertInfo info = new CertInfo(cert, certContent);
          tryUpdateCache(certMeta, keyMeta, certPath, keyPath, true, info);
          return info;
        }
        LoggingUtils.log(
            LOGGER_PROVIDER,
            Level.WARNING,
            Collections.emptyMap(),
            "Cert and key mismatch, retrying...");
      } catch (AccessDeniedException e) {
        throw new IOException(
            "Permission denied reading certificate or key files for Agent Identity.", e);
      } catch (Exception e) {
        if (Strings.isNullOrEmpty(keyPath) && e instanceof IOException) {
          throw (IOException) e;
        }
        lastException = e;
        LoggingUtils.log(
            LOGGER_PROVIDER,
            Level.WARNING,
            Collections.emptyMap(),
            "Failed to read or verify cert/key, retrying: " + e.getMessage());
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

    // If files were transiently missing or unreadable during steady-state rotation (lastException != null)
    // and we already have a verified credential cached in memory, fall back to cached credentials
    // rather than failing or caching an unbound token. Re-read cachedCredentials in case another thread
    // completed rotation while this thread was sleeping.
    CachedCredentials latestCached = cachedCredentials;
    CachedCredentials fallbackCached =
        (latestCached != null
                && latestCached.shouldRequestBoundToken
                && latestCached.certInfo != null)
            ? latestCached
            : initialCached;
    if (lastException != null
        && fallbackCached != null
        && fallbackCached.shouldRequestBoundToken
        && fallbackCached.certInfo != null) {
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.WARNING,
          Collections.emptyMap(),
          "Agent Identity certificate/key files transiently unavailable during rotation; falling"
              + " back to cached credentials.");
      return fallbackCached.certInfo;
    }

    throw new IOException(
        String.format(
            "Agent Identity certificate and private key mismatch or read"
                + " failure after %d retries.",
            CERT_KEY_MATCH_RETRIES),
        lastException);
  }

  /** Checks if a file exists, throwing AccessDeniedException if permission is denied. */
  private static boolean checkExistsOrAccessDenied(final Path path) throws AccessDeniedException {
    try {
      Files.readAttributes(path, BasicFileAttributes.class);
      return true;
    } catch (AccessDeniedException e) {
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
    String enableRuntimeBoundToken = getTrimmedEnv(GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN);
    if (!Strings.isNullOrEmpty(enableRuntimeBoundToken)) {
      return !"false".equalsIgnoreCase(enableRuntimeBoundToken);
    }
    String legacyPreventSharing =
        getTrimmedEnv(GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES);
    if (!Strings.isNullOrEmpty(legacyPreventSharing)) {
      return !"false".equalsIgnoreCase(legacyPreventSharing);
    }
    return true;
  }

  /**
   * Reads the certificate path from the config file with retry logic to handle startup delivery and
   * rotation race conditions.
   */
  private static ResolvedCertAndKeyPaths getPathsFromConfigWithRetry(
      final String certConfigPath, final CachedCredentials initialCached) throws IOException {
    if ("false".equalsIgnoreCase(getTrimmedEnv(GOOGLE_API_USE_CLIENT_CERTIFICATE))) {
      try {
        if (checkExistsOrAccessDenied(Paths.get(certConfigPath))) {
          return extractPathsFromConfig(certConfigPath);
        }
      } catch (Exception ignored) {
        // Do not fail when mTLS is explicitly disabled
      }
      return new ResolvedCertAndKeyPaths(null, null, false);
    }

    boolean inWellKnownDir = isPathInWellKnownDir(certConfigPath);
    boolean shouldPoll = !initialStartupCompleted && inWellKnownDir;
    int maxCycles = shouldPoll ? TOTAL_POLL_CYCLES : 1;
    boolean warned = false;
    IOException lastParseException = null;

    for (int cycle = 0; cycle < maxCycles; cycle++) {
      try {
        if (checkExistsOrAccessDenied(Paths.get(certConfigPath))) {
          ResolvedCertAndKeyPaths paths = extractPathsFromConfig(certConfigPath);
          if (!paths.hasWorkloadConfig()) {
            // Valid non-workload config (e.g. enterprise certs) - exit early without polling!
            return paths;
          }
          if (!initialStartupCompleted
              && !shouldPoll
              && (isPathInWellKnownDir(paths.getCertPath())
                  || isPathInWellKnownDir(paths.getKeyPath()))) {
            shouldPoll = true;
            maxCycles = TOTAL_POLL_CYCLES;
          }
          boolean certReady =
              !Strings.isNullOrEmpty(paths.getCertPath())
                  && checkExistsOrAccessDenied(Paths.get(paths.getCertPath()));
          boolean keyReady =
              !Strings.isNullOrEmpty(paths.getKeyPath())
                  && checkExistsOrAccessDenied(Paths.get(paths.getKeyPath()));
          if (certReady && (keyReady || !shouldPoll || cycle + 1 >= maxCycles)) {
            return paths;
          }
        }
      } catch (AccessDeniedException e) {
        String failedFile = e.getFile() != null ? e.getFile() : certConfigPath;
        throw new IOException(
            "Permission denied reading certificate config file: " + failedFile, e);
      } catch (IOException e) {
        CachedCredentials latestCached = getLatestOrInitialCache(initialCached);
        if (!shouldPoll && cycle + 1 >= maxCycles && latestCached == null) {
          throw e; // Fail fast on malformed JSON syntax errors when not polling
        }
        lastParseException = e;
        // When polling is active, fall through to retry (handles partial/empty JSON during startup)
      }
      if (cycle + 1 < maxCycles) {
        if (shouldPoll && !warned) {
          LoggingUtils.log(
              LOGGER_PROVIDER,
              Level.WARNING,
              Collections.emptyMap(),
              String.format(
                  "Agent Identity certificate config or referenced credential files not yet ready"
                      + " at %s (from %s environment variable). Retrying for up to %d seconds.",
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
    }

    CachedCredentials fallbackCached = getLatestOrInitialCache(initialCached);
    if (fallbackCached != null
        && fallbackCached.certMetadata != null
        && fallbackCached.keyMetadata != null) {
      return new ResolvedCertAndKeyPaths(
          fallbackCached.certMetadata.path, fallbackCached.keyMetadata.path, true);
    }

    throw new IOException(
        "Unable to find Agent Identity certificate config or file for bound token request"
            + " after multiple retries. Token binding protection is failing. You can turn"
            + " off this protection by setting "
            + GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN
            + " to false to fall back to unbound tokens.",
        lastParseException);
  }

  /** Searches for certificates at well-known locations with retry logic. */
  private static String getWellKnownCertificatePathWithRetry(final CachedCredentials initialCached)
      throws IOException {
    String bundlePath = Paths.get(wellKnownDir, "credentialbundle.pem").toString();
    String certOnlyPath = Paths.get(wellKnownDir, "certificates.pem").toString();

    String useClientCert = getTrimmedEnv(GOOGLE_API_USE_CLIENT_CERTIFICATE);
    boolean explicitMtls = "true".equalsIgnoreCase(useClientCert);
    boolean shouldPoll = explicitMtls && !initialStartupCompleted;
    int maxCycles = shouldPoll ? TOTAL_POLL_CYCLES : 1;

    boolean warned = false;
    for (int cycle = 0; cycle < maxCycles; cycle++) {
      try {
        if (checkExistsOrAccessDenied(Paths.get(bundlePath))) {
          return bundlePath;
        }
        if (checkExistsOrAccessDenied(Paths.get(certOnlyPath))) {
          return certOnlyPath;
        }
      } catch (AccessDeniedException e) {
        if (explicitMtls) {
          throw new IOException(
              "Permission denied reading well-known certificate files at " + wellKnownDir, e);
        }
        LoggingUtils.log(
            LOGGER_PROVIDER,
            Level.WARNING,
            Collections.emptyMap(),
            "Permission denied reading well-known certificates. Falling back to unbound token.");
        return null;
      } catch (Exception e) {
        // Fall through to retry
      }

      if (cycle + 1 < maxCycles) {
        if (shouldPoll && !warned) {
          LoggingUtils.log(
              LOGGER_PROVIDER,
              Level.WARNING,
              Collections.emptyMap(),
              String.format(
                  "Well-known certificate file not found at %s. Retrying for up to %d seconds.",
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
    }

    CachedCredentials fallbackCached = getLatestOrInitialCache(initialCached);
    if (fallbackCached != null && fallbackCached.certMetadata != null) {
      return fallbackCached.certMetadata.path;
    }

    if (explicitMtls) {
      throw new IOException(
          String.format(
              "Unable to find well-known Agent Identity certificate file at %s for bound token"
                  + " request. Token binding protection is failing. You can turn off this"
                  + " protection by setting %s to false to fall back to unbound tokens.",
              wellKnownDir, GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN));
    }

    LoggingUtils.log(
        LOGGER_PROVIDER,
        Level.FINE,
        Collections.emptyMap(),
        String.format(
            "Well-known certificate file not found at %s (%s=%s, initialStartupCompleted=%s);"
                + " falling back to unbound token.",
            wellKnownDir,
            GOOGLE_API_USE_CLIENT_CERTIFICATE,
            useClientCert,
            initialStartupCompleted));
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
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.WARNING,
          Collections.emptyMap(),
          "Key pair verification failed: " + e.getMessage());
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
    String useClientCert = getTrimmedEnv(GOOGLE_API_USE_CLIENT_CERTIFICATE);

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
      if (certsPresent && !mtlsDisabledWarningLogged) {
        mtlsDisabledWarningLogged = true;
        // Warn that we are ignoring present certs because it was explicitly disabled
        LoggingUtils.log(
            LOGGER_PROVIDER,
            Level.WARNING,
            Collections.emptyMap(),
            "Token binding protection is disabled because mTLS was explicitly disabled"
                + " via GOOGLE_API_USE_CLIENT_CERTIFICATE.");
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
    return info != null ? info.getCertContent() : null;
  }

  /** Extracts the certificate and private key paths from the JSON configuration file. */
  private static ResolvedCertAndKeyPaths extractPathsFromConfig(final String certConfigPath)
      throws IOException {
    try (InputStream stream = Files.newInputStream(Paths.get(certConfigPath))) {
      JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
      GenericJson config = parser.parseAndClose(stream, StandardCharsets.UTF_8, GenericJson.class);
      Object certConfigsObj = config.get("cert_configs");
      if (certConfigsObj instanceof Map<?, ?>) {
        Map<?, ?> certConfigs = (Map<?, ?>) certConfigsObj;
        Object workloadObj = certConfigs.get("workload");
        if (workloadObj instanceof Map<?, ?>) {
          Map<?, ?> workload = (Map<?, ?>) workloadObj;
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
    } catch (AccessDeniedException e) {
      throw e;
    } catch (Exception e) {
      throw new IOException("Failed to parse Agent Identity config JSON", e);
    }
  }

  /** Parses the X509 certificate from the specified content string. */
  private static X509Certificate parseCertificateContent(final String certContent)
      throws IOException {
    try (InputStream stream =
        new ByteArrayInputStream(certContent.getBytes(StandardCharsets.UTF_8))) {
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
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.WARNING,
          Collections.emptyMap(),
          "Failed to parse Subject Alternative Names from certificate: " + e.getMessage());
    }
    return false;
  }

  /** Sets the well-known certificate directory path for testing. */
  @VisibleForTesting
  static void setWellKnownDir(final String dir) {
    wellKnownDir = dir;
    cachedCredentials = null;
    initialStartupCompleted = false;
    mtlsDisabledWarningLogged = false;
  }

  /** Sets the environment variable provider for testing. */
  @VisibleForTesting
  static void setEnvironmentProvider(final EnvironmentProvider provider) {
    environmentProvider = provider;
    cachedCredentials = null;
    initialStartupCompleted = false;
    mtlsDisabledWarningLogged = false;
  }

  /** Resets the environment variable provider back to default system implementation. */
  @VisibleForTesting
  static void resetEnvironmentProvider() {
    environmentProvider = SystemEnvironmentProvider.getInstance();
    cachedCredentials = null;
    initialStartupCompleted = false;
    mtlsDisabledWarningLogged = false;
  }

  /** Sets the time and sleep service for testing. */
  @VisibleForTesting
  static void setTimeService(final TimeService service) {
    timeService = service;
    cachedCredentials = null;
    initialStartupCompleted = false;
    mtlsDisabledWarningLogged = false;
  }

  /** Resets the time and sleep service back to default system implementation. */
  @VisibleForTesting
  static void resetTimeService() {
    timeService = Thread::sleep;
    cachedCredentials = null;
    initialStartupCompleted = false;
    mtlsDisabledWarningLogged = false;
  }

  /** Clears only the in-memory cached credentials for testing concurrent invalidation. */
  @VisibleForTesting
  static void clearCachedCredentials() {
    cachedCredentials = null;
  }

  /** Returns whether the warning for explicitly disabled mTLS has been logged. */
  @VisibleForTesting
  static boolean isMtlsDisabledWarningLogged() {
    return mtlsDisabledWarningLogged;
  }
}
