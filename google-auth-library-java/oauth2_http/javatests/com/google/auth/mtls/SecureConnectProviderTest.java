/*
 * Copyright 2025, Google Inc. All rights reserved.
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

package com.google.auth.mtls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class SecureConnectProviderTest {

  private static class TestCertProviderCommandProcess extends Process {

    private final boolean runForever;
    private final int exitValue;

    public TestCertProviderCommandProcess(int exitValue, boolean runForever) {
      this.runForever = runForever;
      this.exitValue = exitValue;
    }

    @Override
    public OutputStream getOutputStream() {
      return null;
    }

    @Override
    public InputStream getInputStream() {
      return null;
    }

    @Override
    public InputStream getErrorStream() {
      return null;
    }

    @Override
    public int waitFor() {
      return 0;
    }

    @Override
    public int exitValue() {
      if (runForever) {
        throw new IllegalThreadStateException();
      }
      return exitValue;
    }

    @Override
    public void destroy() {
      // Nothing was initialized and nothing needs to be destroyed
    }
  }

  static class TestProcessProvider implements SecureConnectProvider.ProcessProvider {

    private final int exitCode;

    public TestProcessProvider(int exitCode) {
      this.exitCode = exitCode;
    }

    @Override
    public Process createProcess(InputStream metadata) throws IOException {
      return new TestCertProviderCommandProcess(exitCode, false);
    }
  }

  @Test
  void testGetKeyStoreNonZeroExitCode() {
    try (InputStream metadata =
        this.getClass()
            .getClassLoader()
            .getResourceAsStream("com/google/api/gax/rpc/mtls/mtlsCertAndKey.pem")) {
      IOException actual =
          assertThrows(
              IOException.class,
              () -> SecureConnectProvider.getKeyStore(metadata, new TestProcessProvider(1)));
      assertTrue(
          actual
              .getMessage()
              .contains("SecureConnect: Cert provider command failed with exit code: 1"),
          "expected to fail with nonzero exit code");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testExtractCertificateProviderCommand() throws IOException {
    InputStream inputStream =
        this.getClass().getClassLoader().getResourceAsStream("mtls_context_aware_metadata.json");
    List<String> command = SecureConnectProvider.extractCertificateProviderCommand(inputStream);
    assertEquals(2, command.size());
    assertEquals("some_binary", command.get(0));
    assertEquals("some_argument", command.get(1));
  }

  @Test
  void testRunCertificateProviderCommandSuccess() throws IOException, InterruptedException {
    Process certCommandProcess = new TestCertProviderCommandProcess(0, false);
    int exitValue = SecureConnectProvider.runCertificateProviderCommand(certCommandProcess, 100);
    assertEquals(0, exitValue);
  }

  @Test
  void testRunCertificateProviderCommandTimeout() {
    Process certCommandProcess = new TestCertProviderCommandProcess(0, true);
    IOException actual =
        assertThrows(
            IOException.class,
            () -> SecureConnectProvider.runCertificateProviderCommand(certCommandProcess, 100));
    assertTrue(
        actual.getMessage().contains("SecureConnect: Cert provider command timed out"),
        "expected to fail with timeout");
  }

  @Test
  void testGetKeyStore_FileNotFoundException() {
    SecureConnectProvider provider =
        new SecureConnectProvider(new TestProcessProvider(0), "/invalid/metadata/path.json");

    CertificateSourceUnavailableException exception =
        assertThrows(CertificateSourceUnavailableException.class, provider::getKeyStore);

    assertEquals("SecureConnect metadata does not exist.", exception.getMessage());
  }
}
