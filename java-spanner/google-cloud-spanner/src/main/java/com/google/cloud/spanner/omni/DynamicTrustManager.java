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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.Socket;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * An {@link X509ExtendedTrustManager} that dynamically reloads root CA certificates from disk
 * whenever the certificate file is modified or rotated.
 */
@InternalApi
public class DynamicTrustManager extends X509ExtendedTrustManager {
  private static final Logger logger = Logger.getLogger(DynamicTrustManager.class.getName());
  private static final long DEFAULT_CHECK_INTERVAL_MS = 5000L;

  private final File caCertFile;
  private final long checkIntervalNs;
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

  private static class TrustMaterial {
    final long lastModified;
    final long length;
    final X509ExtendedTrustManager delegate;

    TrustMaterial(long lastModified, long length, X509ExtendedTrustManager delegate) {
      this.lastModified = lastModified;
      this.length = length;
      this.delegate = delegate;
    }
  }

  private volatile TrustMaterial currentMaterial;

  /**
   * Creates a {@link DynamicTrustManager} that dynamically reloads the given root CA certificate
   * file when modified on disk, or delegates to the default JVM trust store if {@code caCertFile}
   * is null.
   *
   * @param caCertFile File containing the X.509 CA certificate(s), or null for the default JVM
   *     trust store.
   */
  public DynamicTrustManager(@Nullable File caCertFile) {
    this(caCertFile, DEFAULT_CHECK_INTERVAL_MS);
  }

  DynamicTrustManager(@Nullable File caCertFile, long checkIntervalMs) {
    this.caCertFile = caCertFile;
    this.checkIntervalNs = checkIntervalMs * 1_000_000L;
    try {
      reloadMaterial();
    } catch (Exception e) {
      throw new RuntimeException("Failed to initialize CA certificate", e);
    }
    this.lastCheckedNs = System.nanoTime();
  }

  void checkAndReload() {
    if (this.caCertFile == null) {
      return;
    }
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
      TrustMaterial existing = this.currentMaterial;
      if (existing != null
          && caCertFile.lastModified() == existing.lastModified
          && caCertFile.length() == existing.length) {
        lastCheckedNs = nowInLock;
        return;
      }
      try {
        reloadMaterial();
      } catch (Exception e) {
        logger.log(
            Level.WARNING,
            "Failed to reload rotated CA certificate from disk, retaining previous material",
            e);
      } finally {
        lastCheckedNs = System.nanoTime();
      }
    } finally {
      lock.unlock();
    }
  }

  private void reloadMaterial() throws Exception {
    if (this.caCertFile == null) {
      TrustManagerFactory tmf =
          TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      tmf.init((KeyStore) null);
      this.currentMaterial = new TrustMaterial(0, 0, findExtendedTrustManager(tmf));
      return;
    }

    long mod = caCertFile.lastModified();
    long len = caCertFile.length();
    byte[] certBytes = Files.readAllBytes(caCertFile.toPath());

    CertificateFactory cf = CertificateFactoryHolder.INSTANCE;
    Collection<? extends Certificate> certs =
        cf.generateCertificates(new ByteArrayInputStream(certBytes));
    if (certs == null || certs.isEmpty()) {
      throw new CertificateException("No certificates found in CA certificate file");
    }

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
    int index = 0;
    for (Certificate cert : certs) {
      ks.setCertificateEntry("spanner-ca-" + (++index), cert);
    }

    TrustManagerFactory tmf =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(ks);

    this.currentMaterial = new TrustMaterial(mod, len, findExtendedTrustManager(tmf));
  }

  private static X509ExtendedTrustManager findExtendedTrustManager(TrustManagerFactory tmf)
      throws GeneralSecurityException {
    for (TrustManager tm : tmf.getTrustManagers()) {
      if (tm instanceof X509ExtendedTrustManager) {
        return (X509ExtendedTrustManager) tm;
      } else if (tm instanceof X509TrustManager) {
        return wrapTrustManager((X509TrustManager) tm);
      }
    }
    throw new GeneralSecurityException("No X509TrustManager found in TrustManagerFactory");
  }

  private static X509ExtendedTrustManager wrapTrustManager(final X509TrustManager tm) {
    return new X509ExtendedTrustManager() {
      @Override
      public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket)
          throws CertificateException {
        tm.checkClientTrusted(chain, authType);
      }

      @Override
      public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket)
          throws CertificateException {
        tm.checkServerTrusted(chain, authType);
      }

      @Override
      public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
          throws CertificateException {
        tm.checkClientTrusted(chain, authType);
      }

      @Override
      public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
          throws CertificateException {
        tm.checkServerTrusted(chain, authType);
      }

      @Override
      public void checkClientTrusted(X509Certificate[] chain, String authType)
          throws CertificateException {
        tm.checkClientTrusted(chain, authType);
      }

      @Override
      public void checkServerTrusted(X509Certificate[] chain, String authType)
          throws CertificateException {
        tm.checkServerTrusted(chain, authType);
      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
        return tm.getAcceptedIssuers();
      }
    };
  }

  @Override
  public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket)
      throws CertificateException {
    checkAndReload();
    TrustMaterial mat = this.currentMaterial;
    if (mat == null) {
      throw new CertificateException("Trust manager is not initialized");
    }
    mat.delegate.checkClientTrusted(chain, authType, socket);
  }

  @Override
  public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket)
      throws CertificateException {
    checkAndReload();
    TrustMaterial mat = this.currentMaterial;
    if (mat == null) {
      throw new CertificateException("Trust manager is not initialized");
    }
    mat.delegate.checkServerTrusted(chain, authType, socket);
  }

  @Override
  public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
      throws CertificateException {
    checkAndReload();
    TrustMaterial mat = this.currentMaterial;
    if (mat == null) {
      throw new CertificateException("Trust manager is not initialized");
    }
    mat.delegate.checkClientTrusted(chain, authType, engine);
  }

  @Override
  public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
      throws CertificateException {
    checkAndReload();
    TrustMaterial mat = this.currentMaterial;
    if (mat == null) {
      throw new CertificateException("Trust manager is not initialized");
    }
    mat.delegate.checkServerTrusted(chain, authType, engine);
  }

  @Override
  public void checkClientTrusted(X509Certificate[] chain, String authType)
      throws CertificateException {
    checkAndReload();
    TrustMaterial mat = this.currentMaterial;
    if (mat == null) {
      throw new CertificateException("Trust manager is not initialized");
    }
    mat.delegate.checkClientTrusted(chain, authType);
  }

  @Override
  public void checkServerTrusted(X509Certificate[] chain, String authType)
      throws CertificateException {
    checkAndReload();
    TrustMaterial mat = this.currentMaterial;
    if (mat == null) {
      throw new CertificateException("Trust manager is not initialized");
    }
    mat.delegate.checkServerTrusted(chain, authType);
  }

  @Override
  public X509Certificate[] getAcceptedIssuers() {
    checkAndReload();
    TrustMaterial mat = this.currentMaterial;
    if (mat == null) {
      return new X509Certificate[0];
    }
    X509Certificate[] issuers = mat.delegate.getAcceptedIssuers();
    return issuers != null ? issuers.clone() : new X509Certificate[0];
  }
}
