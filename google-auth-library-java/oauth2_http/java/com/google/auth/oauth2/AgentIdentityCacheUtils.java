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

import com.google.auth.oauth2.AgentIdentityUtils.CertInfo;
import com.google.common.base.Strings;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Utility class for in-memory caching and filesystem metadata validation of Agent Identity
 * certificates and configuration files.
 */
@NullMarked
final class AgentIdentityCacheUtils {

  // In-memory cache of verified Agent Identity info to avoid redundant disk reads, X.509/PKCS#8
  // parsing, and cryptographic signature verification on every token refresh when files are
  // unchanged.
  private static volatile @Nullable CachedAgentIdentityInfo cachedAgentIdentityInfo;

  private AgentIdentityCacheUtils() {}

  /**
   * Captures filesystem metadata (path, modification time, size, and OS file key/inode) for a
   * certificate, key, or configuration file to detect rotation on disk without re-parsing unchanged
   * files.
   */
  static final class FileMetadata {
    private final String path;
    private final FileTime lastModifiedTime;
    private final long size;
    private final @Nullable Object fileKey;

    private FileMetadata(
        final String path,
        final FileTime lastModifiedTime,
        final long size,
        final @Nullable Object fileKey) {
      this.path = path;
      this.lastModifiedTime = lastModifiedTime;
      this.size = size;
      this.fileKey = fileKey;
    }

    /** Returns the filesystem path captured by this metadata snapshot. */
    String getPath() {
      return path;
    }

    /** Reads the current filesystem attributes for the given file path. */
    static @Nullable FileMetadata of(final @Nullable String pathStr) throws IOException {
      if (Strings.isNullOrEmpty(pathStr)) {
        return null;
      }
      Path path = Paths.get(pathStr);
      BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
      return new FileMetadata(pathStr, attrs.lastModifiedTime(), attrs.size(), attrs.fileKey());
    }

    /** Returns true if the given metadata matches this file's path, mtime, size, and file key. */
    boolean matches(final @Nullable FileMetadata other) {
      if (other == null) {
        return false;
      }
      return Objects.equals(this.path, other.path)
          && Objects.equals(this.lastModifiedTime, other.lastModifiedTime)
          && this.size == other.size
          && Objects.equals(this.fileKey, other.fileKey);
    }

    /**
     * Re-reads the file's current attributes from disk and returns {@code true} if the file still
     * exists on disk with the exact same modification time, size, and OS file key/inode as when
     * this snapshot was captured.
     */
    boolean isUnchangedOnDisk() {
      try {
        return matches(FileMetadata.of(this.path));
      } catch (IOException e) {
        return false;
      }
    }

    /**
     * Returns {@code true} if {@code expectedPath} equals this snapshot's path and the file on disk
     * is unchanged since this snapshot was captured.
     */
    boolean isUnchangedAtPath(final @Nullable String expectedPath) {
      return Objects.equals(this.path, expectedPath) && isUnchangedOnDisk();
    }
  }

  /**
   * Stores an in-memory snapshot of verified Agent Identity certificate information and its
   * associated filesystem metadata to avoid redundant disk I/O and cryptographic checks on
   * subsequent token refreshes.
   */
  static final class CachedAgentIdentityInfo {
    /**
     * Filesystem metadata of the JSON certificate configuration file ({@code
     * GOOGLE_API_CERTIFICATE_CONFIG}) when it was parsed, or {@code null} if the certificate was
     * discovered from the well-known directory.
     */
    final @Nullable FileMetadata configMetadata;

    /**
     * Filesystem metadata of the X.509 certificate or combined credential bundle file when it was
     * read.
     */
    final @Nullable FileMetadata certMetadata;

    /**
     * Filesystem metadata of the private key or combined credential bundle file when it was read,
     * or {@code null} when {@link #shouldRequestBoundToken} is {@code false} (for non-agent
     * certificates where the private key is not read).
     */
    final @Nullable FileMetadata keyMetadata;

    /**
     * Whether the parsed certificate's Subject Alternative Names matched an allowed Agent Identity
     * SPIFFE trust domain pattern and therefore requires requesting a bound token.
     */
    final boolean shouldRequestBoundToken;

    /**
     * The verified {@link AgentIdentityUtils.CertInfo} (parsed {@code X509Certificate} and PEM
     * certificate chain) when {@link #shouldRequestBoundToken} is {@code true}, or {@code null}
     * when {@link #shouldRequestBoundToken} is {@code false}.
     */
    final @Nullable CertInfo certInfo;

    /**
     * Constructs a cached snapshot of Agent Identity evaluation state and file metadata.
     *
     * @param configMetadata filesystem metadata of the certificate config file, or {@code null}
     *     when discovered from the well-known directory
     * @param certMetadata filesystem metadata of the certificate or bundle file
     * @param keyMetadata filesystem metadata of the private key or bundle file, or {@code null}
     *     when {@code shouldRequestBoundToken} is {@code false}
     * @param shouldRequestBoundToken {@code true} if the certificate matched an Agent Identity
     *     SPIFFE pattern and requires a bound token; {@code false} otherwise
     * @param certInfo the verified {@link AgentIdentityUtils.CertInfo} when {@code
     *     shouldRequestBoundToken} is {@code true}, or {@code null} otherwise
     */
    CachedAgentIdentityInfo(
        final @Nullable FileMetadata configMetadata,
        final @Nullable FileMetadata certMetadata,
        final @Nullable FileMetadata keyMetadata,
        final boolean shouldRequestBoundToken,
        final @Nullable CertInfo certInfo) {
      this.configMetadata = configMetadata;
      this.certMetadata = certMetadata;
      this.keyMetadata = keyMetadata;
      this.shouldRequestBoundToken = shouldRequestBoundToken;
      this.certInfo = certInfo;
    }
  }

  /** Returns the current in-memory cached Agent Identity info, or {@code null} if none. */
  static @Nullable CachedAgentIdentityInfo getCachedAgentIdentityInfo() {
    return cachedAgentIdentityInfo;
  }

  /** Clears the in-memory cached Agent Identity info. */
  static void clearCachedAgentIdentityInfo() {
    cachedAgentIdentityInfo = null;
  }

  /**
   * Returns {@code true} if the cached snapshot is non-null and its config, certificate, and key
   * file metadata still match the current files on disk.
   */
  static boolean isCachedInfoValid(
      final @Nullable CachedAgentIdentityInfo cached, final @Nullable String certConfigPath) {
    if (cached == null || cached.certMetadata == null) {
      return false;
    }
    boolean hasConfigEnv = !Strings.isNullOrEmpty(certConfigPath);
    if (hasConfigEnv) {
      // When GOOGLE_API_CERTIFICATE_CONFIG is set, the cache must have been populated from that
      // config file (configMetadata != null) and the config file on disk must be unchanged.
      if (cached.configMetadata == null
          || !cached.configMetadata.isUnchangedAtPath(certConfigPath)) {
        return false;
      }
    } else {
      // When GOOGLE_API_CERTIFICATE_CONFIG is unset, the cache must have been populated from the
      // well-known directory (where configMetadata is null).
      if (cached.configMetadata != null) {
        return false;
      }
      if (cached.certMetadata.path.endsWith("certificates.pem")
          && Files.exists(
              Paths.get(AgentIdentityUtils.getWellKnownDir(), "credentialbundle.pem"))) {
        // credentialbundle.pem takes precedence if added after certificates.pem was cached
        return false;
      }
    }
    if (!cached.certMetadata.isUnchangedOnDisk()) {
      return false;
    }
    if (!cached.shouldRequestBoundToken) {
      return true;
    }
    return cached.keyMetadata != null && cached.keyMetadata.isUnchangedOnDisk();
  }

  /**
   * Checks whether the resolved {@code certPath}, {@code keyPath}, and {@code configMetaBefore}
   * match the given cached snapshot.
   *
   * <p>Even after {@link #isCachedInfoValid} returns {@code false} at the start of {@code
   * AgentIdentityUtils.getAgentIdentityCertInfo()}, this check can still hit in three cases:
   *
   * <ol>
   *   <li>The config file was deleted after caching while the cert and key files on disk remain
   *       unchanged ({@code getPathsFromConfigWithRetry} fell back to the cached paths and {@code
   *       configMetadata}, where {@code tryUpdateCache} will not overwrite the cache while the
   *       config file is missing).
   *   <li>Another thread completed rotation and updated {@code cachedAgentIdentityInfo} while the
   *       current thread was resolving paths.
   *   <li>Package-private {@code AgentIdentityUtils.loadAndVerifyCredentials(certPath, keyPath)}
   *       was invoked directly without going through {@code getAgentIdentityCertInfo()}.
   * </ol>
   */
  static boolean isPostResolutionCacheHit(
      final @Nullable CachedAgentIdentityInfo cached,
      final @Nullable String certPath,
      final @Nullable String keyPath,
      final @Nullable FileMetadata configMetaBefore) {
    if (cached == null || cached.certMetadata == null) {
      return false;
    }
    boolean configMatches =
        configMetaBefore == null
            ? cached.configMetadata == null
            : configMetaBefore.matches(cached.configMetadata);
    if (!configMatches || !cached.certMetadata.isUnchangedAtPath(certPath)) {
      return false;
    }
    if (!cached.shouldRequestBoundToken) {
      return true;
    }
    return !Strings.isNullOrEmpty(keyPath)
        && cached.keyMetadata != null
        && cached.keyMetadata.isUnchangedAtPath(keyPath);
  }

  /**
   * Returns the latest {@link CachedAgentIdentityInfo} if it contains a verified bound-token {@link
   * AgentIdentityUtils.CertInfo}, or falls back to {@code initialCached}.
   *
   * <p>{@code initialCached} is captured at the start of {@code getAgentIdentityCertInfo()} so that
   * if the cache is cleared or overwritten with a non-agent certificate during retry backoff, the
   * caller still retains the last-known-good bound certificate snapshot, while preferring a fresher
   * bound certificate if another thread completed rotation in the meantime.
   */
  static @Nullable CachedAgentIdentityInfo getLatestOrInitialCache(
      final @Nullable CachedAgentIdentityInfo initialCached) {
    CachedAgentIdentityInfo latest = cachedAgentIdentityInfo;
    return (latest != null && latest.shouldRequestBoundToken && latest.certInfo != null)
        ? latest
        : initialCached;
  }

  /**
   * Safely updates the in-memory cache only if file metadata remained stable across the read/verify
   * operation. Returns {@code true} if the post-read cert/key metadata matched the pre-read
   * metadata, or {@code false} if the cert or key changed or disappeared mid-read. If only the
   * config file changed, returns {@code true} without updating the cache, so the next refresh
   * re-resolves paths from the new config.
   */
  static boolean tryUpdateCache(
      final @Nullable FileMetadata configMetaBefore,
      final @Nullable FileMetadata certMetaBefore,
      final @Nullable FileMetadata keyMetaBefore,
      final boolean shouldRequestBoundToken,
      final @Nullable CertInfo certInfo) {
    if (certMetaBefore == null || !certMetaBefore.isUnchangedOnDisk()) {
      return false;
    }
    boolean configStable = configMetaBefore == null || configMetaBefore.isUnchangedOnDisk();
    if (!shouldRequestBoundToken) {
      if (configStable) {
        cachedAgentIdentityInfo =
            new CachedAgentIdentityInfo(configMetaBefore, certMetaBefore, null, false, null);
      }
      return true;
    }
    if (keyMetaBefore != null && keyMetaBefore.isUnchangedOnDisk()) {
      if (configStable) {
        cachedAgentIdentityInfo =
            new CachedAgentIdentityInfo(
                configMetaBefore, certMetaBefore, keyMetaBefore, true, certInfo);
      }
      return true;
    }
    return false;
  }

  /**
   * Checks if a file exists and is readable, throwing {@link AccessDeniedException} if permission
   * is denied.
   */
  static boolean checkExistsOrAccessDenied(final Path path) throws AccessDeniedException {
    try {
      Files.readAttributes(path, BasicFileAttributes.class);
      if (!Files.isReadable(path)) {
        if (!Files.exists(path)) {
          return false; // Deleted mid-rotation; let the caller retry.
        }
        throw new AccessDeniedException(path.toString());
      }
      return true;
    } catch (AccessDeniedException e) {
      throw e;
    } catch (IOException e) {
      return false;
    }
  }
}
