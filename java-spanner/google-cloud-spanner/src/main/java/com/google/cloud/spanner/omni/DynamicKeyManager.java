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
  private static final String CLIENT_ALIAS = "client";
  private static final long DEFAULT_CHECK_INTERVAL_MS = 5000L;

  private final File certFile;
  private final File keyFile;
  private final long checkIntervalNs;
  private volatile long lastCheckedNs;

  private static class KeyMaterial {
    final long certLastModified;
    final long certLength;
    final long keyLastModified;
    final long keyLength;
    final X509Certificate[] certificateChain;
    final PrivateKey privateKey;

    KeyMaterial(
        long certLastModified,
        long certLength,
        long keyLastModified,
        long keyLength,
        X509Certificate[] certificateChain,
        PrivateKey privateKey) {
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

  private void checkAndReload() {
    long now = System.nanoTime();
    if (now - lastCheckedNs < checkIntervalNs) {
      return;
    }
    lastCheckedNs = now;
    KeyMaterial existing = this.currentMaterial;
    if (existing != null
        && certFile.lastModified() == existing.certLastModified
        && certFile.length() == existing.certLength
        && keyFile.lastModified() == existing.keyLastModified
        && keyFile.length() == existing.keyLength) {
      return;
    }
    synchronized (this) {
      existing = this.currentMaterial;
      if (existing != null
          && certFile.lastModified() == existing.certLastModified
          && certFile.length() == existing.certLength
          && keyFile.lastModified() == existing.keyLastModified
          && keyFile.length() == existing.keyLength) {
        return;
      }
      try {
        reloadMaterial();
      } catch (Exception e) {
        logger.log(
            Level.WARNING,
            "Failed to reload rotated client certificate/key from disk, retaining current material",
            e);
      }
    }
  }

  private void reloadMaterial() throws Exception {
    byte[] certBytes = Files.readAllBytes(certFile.toPath());
    byte[] keyBytes = Files.readAllBytes(keyFile.toPath());

    long certMod = certFile.lastModified();
    long certLen = certBytes.length;
    long keyMod = keyFile.lastModified();
    long keyLen = keyBytes.length;

    X509Certificate[] chain = parseCertificates(certBytes);
    PrivateKey key = parsePrivateKey(keyBytes);
    verifyKeyMatch(chain[0].getPublicKey(), key);

    this.currentMaterial = new KeyMaterial(certMod, certLen, keyMod, keyLen, chain, key);
  }

  private static void verifyKeyMatch(PublicKey publicKey, PrivateKey privateKey)
      throws GeneralSecurityException {
    String algorithm = privateKey.getAlgorithm();
    String sigAlg =
        "RSA".equalsIgnoreCase(algorithm)
            ? "SHA256withRSA"
            : "EC".equalsIgnoreCase(algorithm) ? "SHA256withECDSA" : null;
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
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    Collection<? extends Certificate> certs =
        cf.generateCertificates(new ByteArrayInputStream(certBytes));
    if (certs == null || certs.isEmpty()) {
      throw new CertificateException("No certificates found in certificate file");
    }
    return certs.toArray(new X509Certificate[0]);
  }

  private static PrivateKey parsePrivateKey(byte[] keyBytes) throws Exception {
    String keyStr = new String(keyBytes, StandardCharsets.UTF_8);
    if (keyStr.contains("-----BEGIN RSA PRIVATE KEY-----")
        || keyStr.contains("-----BEGIN EC PRIVATE KEY-----")) {
      throw new IllegalArgumentException(
          "PKCS#1 private keys are not supported. Please convert your key to PKCS#8 format using: "
              + "openssl pkcs8 -topk8 -nocrypt -in <key> -out <key_pkcs8>");
    }
    byte[] der;
    if (keyStr.contains("-----BEGIN PRIVATE KEY-----")) {
      der = extractPemContent(keyStr, "-----BEGIN PRIVATE KEY-----", "-----END PRIVATE KEY-----");
    } else {
      try {
        der = Base64.getMimeDecoder().decode(keyBytes);
      } catch (IllegalArgumentException e) {
        der = keyBytes;
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
    String base64 = pem.substring(start, end).replaceAll("\\s+", "");
    return Base64.getDecoder().decode(base64);
  }

  @Override
  public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
    checkAndReload();
    return CLIENT_ALIAS;
  }

  @Override
  public String chooseEngineClientAlias(String[] keyType, Principal[] issuers, SSLEngine engine) {
    checkAndReload();
    return CLIENT_ALIAS;
  }

  @Override
  public X509Certificate[] getCertificateChain(String alias) {
    checkAndReload();
    KeyMaterial mat = this.currentMaterial;
    return mat != null ? mat.certificateChain.clone() : null;
  }

  @Override
  public PrivateKey getPrivateKey(String alias) {
    checkAndReload();
    KeyMaterial mat = this.currentMaterial;
    return mat != null ? mat.privateKey : null;
  }

  @Override
  public String[] getClientAliases(String keyType, Principal[] issuers) {
    checkAndReload();
    return new String[] {CLIENT_ALIAS};
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
