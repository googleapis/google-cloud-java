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

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.SecurityUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class implements {@link MtlsProvider} for the Google Auth library transport layer via {@link
 * ContextAwareMetadataJson}. This is only meant to be used internally by Google Cloud libraries,
 * and the public facing methods may be changed without notice, and have no guarantee of backwards
 * compatibility.
 *
 * <p>Note: This implementation is derived from the existing "MtlsProvider" found in the Gax
 * library, with two notable differences: 1) All logic associated with parsing environment variables
 * related to "mTLS usage" are omitted - a separate helper class will be introduced in the Gax
 * library to serve this purpose. 2) getKeyStore throws {@link
 * com.google.auth.mtls.CertificateSourceUnavailableException} instead of returning "null" if this
 * cert source is not available on the device.
 *
 * <p>Additionally, this implementation will replace the existing "MtlsProvider" in the Gax library.
 * The Gax library version of MtlsProvider will be marked as deprecated.
 */
public class SecureConnectProvider implements MtlsProvider {
  interface ProcessProvider {
    public Process createProcess(InputStream metadata) throws IOException;
  }

  static class DefaultProcessProvider implements ProcessProvider {
    @Override
    public Process createProcess(InputStream metadata) throws IOException {
      if (metadata == null) {
        throw new IOException("Error creating Process: metadata is null");
      }
      List<String> command = extractCertificateProviderCommand(metadata);
      return new ProcessBuilder(command).start();
    }
  }

  private static final String DEFAULT_CONTEXT_AWARE_METADATA_PATH =
      System.getProperty("user.home") + "/.secureConnect/context_aware_metadata.json";

  private String metadataPath;
  private ProcessProvider processProvider;

  @VisibleForTesting
  SecureConnectProvider(ProcessProvider processProvider, String metadataPath) {
    this.processProvider = processProvider;
    this.metadataPath = metadataPath;
  }

  public SecureConnectProvider() {
    this(new DefaultProcessProvider(), DEFAULT_CONTEXT_AWARE_METADATA_PATH);
  }

  /**
   * Returns a mutual TLS key store backed by the certificate provided by the SecureConnect tool.
   *
   * @return a KeyStore containing the certificate provided by the SecureConnect tool.
   * @throws CertificateSourceUnavailableException if the certificate source is unavailable (ex.
   *     missing configuration file).
   * @throws IOException if a general I/O error occurs while creating the KeyStore.
   */
  @Override
  public KeyStore getKeyStore() throws CertificateSourceUnavailableException, IOException {
    try (InputStream stream = new FileInputStream(metadataPath)) {
      return getKeyStore(stream, processProvider);
    } catch (InterruptedException e) {
      throw new IOException("SecureConnect: Interrupted executing certificate provider command", e);
    } catch (GeneralSecurityException e) {
      throw new CertificateSourceUnavailableException(
          "SecureConnect encountered GeneralSecurityException:", e);
    } catch (FileNotFoundException exception) {
      // If the metadata file doesn't exist, then there is no key store, so we will throw sentinel
      // error
      throw new CertificateSourceUnavailableException("SecureConnect metadata does not exist.");
    }
  }

  /**
   * Returns true if the SecureConnect mTLS provider is available.
   *
   * @throws IOException if a general I/O error occurs while determining availability.
   */
  @Override
  public boolean isAvailable() throws IOException {
    try {
      this.getKeyStore();
    } catch (CertificateSourceUnavailableException e) {
      return false;
    }
    return true;
  }

  @VisibleForTesting
  static KeyStore getKeyStore(InputStream metadata, ProcessProvider processProvider)
      throws IOException, InterruptedException, GeneralSecurityException {
    Process process = processProvider.createProcess(metadata);

    // Run the command and timeout after 1000 milliseconds.
    // The cert provider command usually finishes instantly (if it doesn't hang),
    // so 1000 milliseconds is plenty of time.
    int exitCode = runCertificateProviderCommand(process, 1000);
    if (exitCode != 0) {
      throw new IOException(
          "SecureConnect: Cert provider command failed with exit code: " + exitCode);
    }

    // Create mTLS key store with the input certificates from shell command.
    return SecurityUtils.createMtlsKeyStore(process.getInputStream());
  }

  @VisibleForTesting
  static ImmutableList<String> extractCertificateProviderCommand(InputStream contextAwareMetadata)
      throws IOException {
    JsonParser parser = new GsonFactory().createJsonParser(contextAwareMetadata);
    ContextAwareMetadataJson json = parser.parse(ContextAwareMetadataJson.class);
    return json.getCommands();
  }

  @VisibleForTesting
  static int runCertificateProviderCommand(Process commandProcess, long timeoutMilliseconds)
      throws IOException, InterruptedException {
    boolean terminated = commandProcess.waitFor(timeoutMilliseconds, TimeUnit.MILLISECONDS);
    if (!terminated) {
      commandProcess.destroy();
      throw new IOException("SecureConnect: Cert provider command timed out");
    }
    return commandProcess.exitValue();
  }
}
