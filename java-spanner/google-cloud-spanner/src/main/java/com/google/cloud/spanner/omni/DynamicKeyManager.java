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

import com.google.api.core.InternalApi;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

/**
 * An {@link X509ExtendedKeyManager} that dynamically reloads client certificates and private keys
 * from disk whenever the underlying files are modified or rotated.
 */
@InternalApi
public class DynamicKeyManager extends X509ExtendedKeyManager {
  private static final Logger logger = Logger.getLogger(DynamicKeyManager.class.getName());
  private static final long DEFAULT_CHECK_INTERVAL_MS = 5000L;

  private final File certFile;
  private final File keyFile;
  private final long checkIntervalNs;
  private final ConcurrentHashMap<String, KeyMaterial> materials = new ConcurrentHashMap<>();
  private final AtomicLong versionCounter = new AtomicLong();
  private final ReentrantLock lock = new ReentrantLock();
  private volatile long lastCheckedNs;

  private static class CertificateFactoryHolder {
    static final CertificateFactory INSTANCE;

    static {
      try {
        INSTANCE = CertificateFactory.getInstance("X.509");
      } catch (CertificateException e) {
        throw new ExceptionInInitializerError(e);
      }
    }
  }

  private static class KeyMaterial {
    final String alias;
    final long certLastModified;
    final long certLength;
    final long keyLastModified;
    final long keyLength;
    final X509Certificate[] certificateChain;
    final PrivateKey privateKey;

    KeyMaterial(
        String alias,
        long certLastModified,
        long certLength,
        long keyLastModified,
        long keyLength,
        X509Certificate[] certificateChain,
        PrivateKey privateKey) {
      this.alias = alias;
      this.certLastModified = certLastModified;
      this.certLength = certLength;
      this.keyLastModified = keyLastModified;
      this.keyLength = keyLength;
      this.certificateChain = certificateChain;
      this.privateKey = privateKey;
    }
  }

  private volatile KeyMaterial currentMaterial;

  /**
   * Creates a {@link DynamicKeyManager} that dynamically reloads the given certificate and key
   * files when modified on disk.
   *
   * @param certFile File containing the X.509 client certificate chain.
   * @param keyFile File containing the PKCS#8 private key.
   */
  public DynamicKeyManager(File certFile, File keyFile) {
    this(certFile, keyFile, DEFAULT_CHECK_INTERVAL_MS);
  }

  DynamicKeyManager(File certFile, File keyFile, long checkIntervalMs) {
    this.certFile = Preconditions.checkNotNull(certFile, "certFile cannot be null");
    this.keyFile = Preconditions.checkNotNull(keyFile, "keyFile cannot be null");
    this.checkIntervalNs = checkIntervalMs * 1_000_000L;
    try {
      reloadMaterial();
    } catch (IllegalArgumentException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Failed to initialize client certificate/key", e);
    }
    this.lastCheckedNs = System.nanoTime();
  }

  void checkAndReload() {
    long now = System.nanoTime();
    if (checkIntervalNs > 0 && now - lastCheckedNs < checkIntervalNs) {
      return;
    }
    lock.lock();
    try {
      long nowInLock = System.nanoTime();
      if (checkIntervalNs > 0 && nowInLock - lastCheckedNs < checkIntervalNs) {
        return;
      }
      KeyMaterial existing = this.currentMaterial;
      if (existing != null
          && certFile.lastModified() == existing.certLastModified
          && certFile.length() == existing.certLength
          && keyFile.lastModified() == existing.keyLastModified
          && keyFile.length() == existing.keyLength) {
        lastCheckedNs = nowInLock;
        return;
      }
      try {
        reloadMaterial();
      } catch (Exception e) {
        logger.log(
            Level.WARNING,
            "Failed to reload rotated client certificate/key from disk, retaining current material",
            e);
      } finally {
        lastCheckedNs = System.nanoTime();
      }
    } finally {
      lock.unlock();
    }
  }

  private void reloadMaterial() throws Exception {
    long certMod = certFile.lastModified();
    long certLen = certFile.length();
    long keyMod = keyFile.lastModified();
    long keyLen = keyFile.length();

    byte[] certBytes = Files.readAllBytes(certFile.toPath());
    byte[] keyBytes = Files.readAllBytes(keyFile.toPath());

    X509Certificate[] chain = parseCertificates(certBytes);
    PrivateKey key = parsePrivateKey(keyBytes);
    verifyKeyMatch(chain[0].getPublicKey(), key);

    long currentVersion = versionCounter.incrementAndGet();
    String alias = "client-" + currentVersion;
    KeyMaterial newMaterial = new KeyMaterial(alias, certMod, certLen, keyMod, keyLen, chain, key);
    materials.put(alias, newMaterial);
    this.currentMaterial = newMaterial;

    long oldestToKeep = currentVersion - 10;
    materials
        .keySet()
        .removeIf(
            keyStr -> {
              if (!keyStr.startsWith("client-")) {
                return false;
              }
              try {
                long ver = Long.parseLong(keyStr.substring("client-".length()));
                return ver < oldestToKeep;
              } catch (NumberFormatException e) {
                return false;
              }
            });
  }

  private static void verifyKeyMatch(PublicKey publicKey, PrivateKey privateKey)
      throws GeneralSecurityException {
    String algorithm = privateKey.getAlgorithm();
    String sigAlg =
        "RSA".equalsIgnoreCase(algorithm)
            ? "SHA256withRSA"
            : ("EC".equalsIgnoreCase(algorithm) || "ECDSA".equalsIgnoreCase(algorithm))
                ? "SHA256withECDSA"
                : null;
    if (sigAlg != null) {
      Signature sig = Signature.getInstance(sigAlg);
      sig.initSign(privateKey);
      sig.update(new byte[0]);
      byte[] signature = sig.sign();
      sig.initVerify(publicKey);
      sig.update(new byte[0]);
      if (!sig.verify(signature)) {
        throw new GeneralSecurityException("Private key does not match the certificate public key");
      }
    }
  }

  private static X509Certificate[] parseCertificates(byte[] certBytes) throws CertificateException {
    CertificateFactory cf = CertificateFactoryHolder.INSTANCE;
    Collection<? extends Certificate> certs =
        cf.generateCertificates(new ByteArrayInputStream(certBytes));
    if (certs == null || certs.isEmpty()) {
      throw new CertificateException("No certificates found in certificate file");
    }
    return certs.toArray(new X509Certificate[0]);
  }

  private static PrivateKey parsePrivateKey(byte[] keyBytes) throws Exception {
    byte[] der;
    if (keyBytes.length > 2 && keyBytes[0] == 0x30 && (keyBytes[1] & 0x80) != 0) {
      der = keyBytes;
    } else {
      String keyStr = new String(keyBytes, StandardCharsets.UTF_8);
      if (keyStr.contains("-----BEGIN RSA PRIVATE KEY-----")
          || keyStr.contains("-----BEGIN EC PRIVATE KEY-----")) {
        throw new IllegalArgumentException(
            "PKCS#1 private keys are not supported. Please convert your key to PKCS#8 format using:"
                + " openssl pkcs8 -topk8 -nocrypt -in <key> -out <key_pkcs8>");
      }
      if (keyStr.contains("-----BEGIN PRIVATE KEY-----")) {
        der = extractPemContent(keyStr, "-----BEGIN PRIVATE KEY-----", "-----END PRIVATE KEY-----");
      } else {
        try {
          der = Base64.getMimeDecoder().decode(keyBytes);
        } catch (IllegalArgumentException e) {
          der = keyBytes;
        }
      }
    }

    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(der);
    try {
      return KeyFactory.getInstance("RSA").generatePrivate(spec);
    } catch (Exception rsaException) {
      try {
        return KeyFactory.getInstance("EC").generatePrivate(spec);
      } catch (Exception ecException) {
        GeneralSecurityException ex =
            new GeneralSecurityException("Failed to parse private key as RSA or EC");
        ex.addSuppressed(rsaException);
        ex.addSuppressed(ecException);
        throw ex;
      }
    }
  }

  private static byte[] extractPemContent(String pem, String beginMarker, String endMarker) {
    int start = pem.indexOf(beginMarker);
    if (start < 0) {
      throw new IllegalArgumentException("PEM does not contain marker: " + beginMarker);
    }
    start += beginMarker.length();
    int end = pem.indexOf(endMarker, start);
    if (end < 0) {
      throw new IllegalArgumentException("PEM does not contain marker: " + endMarker);
    }
    String base64 = pem.substring(start, end);
    return Base64.getMimeDecoder().decode(base64);
  }

  @Override
  public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
    checkAndReload();
    KeyMaterial mat = this.currentMaterial;
    return mat != null ? mat.alias : null;
  }

  @Override
  public String chooseEngineClientAlias(String[] keyType, Principal[] issuers, SSLEngine engine) {
    checkAndReload();
    KeyMaterial mat = this.currentMaterial;
    return mat != null ? mat.alias : null;
  }

  @Override
  public X509Certificate[] getCertificateChain(String alias) {
    KeyMaterial mat = (alias != null) ? materials.get(alias) : this.currentMaterial;
    return (mat != null && mat.certificateChain != null && mat.certificateChain.length > 0)
        ? mat.certificateChain.clone()
        : null;
  }

  @Override
  public PrivateKey getPrivateKey(String alias) {
    KeyMaterial mat = (alias != null) ? materials.get(alias) : this.currentMaterial;
    return mat != null ? mat.privateKey : null;
  }

  @Override
  public String[] getClientAliases(String keyType, Principal[] issuers) {
    checkAndReload();
    KeyMaterial mat = this.currentMaterial;
    return mat != null ? new String[] {mat.alias} : null;
  }

  @Override
  public String[] getServerAliases(String keyType, Principal[] issuers) {
    return null;
  }

  @Override
  public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
    return null;
  }

  @Override
  public String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine) {
    return null;
  }
}
