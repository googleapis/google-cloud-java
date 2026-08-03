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

package com.google.auth.mtls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.HttpTransport;
import java.io.IOException;
import java.security.KeyStore;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class MtlsHttpTransportFactoryTest {

  @Test
  void constructor_nullKeyStore_throwsNullPointerException() {
    assertThrows(
        NullPointerException.class,
        () -> new MtlsHttpTransportFactory((KeyStore) null));
  }

  @Test
  void constructor_nullMtlsProvider_throwsNullPointerException() {
    assertThrows(
        NullPointerException.class,
        () -> new MtlsHttpTransportFactory((MtlsProvider) null));
  }

  @Test
  void constructor_withKeyStore_createsTransport() throws Exception {
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(ks);
    assertEquals(ks, factory.getKeyStore());

    HttpTransport transport = factory.create();
    assertNotNull(transport);
  }

  @Test
  void constructor_withMtlsProvider_createsTransportAndRebuildsContext()
      throws Exception {
    AtomicInteger callCount = new AtomicInteger(0);
    KeyStore ks1 = KeyStore.getInstance(KeyStore.getDefaultType());
    ks1.load(null, null);
    KeyStore ks2 = KeyStore.getInstance(KeyStore.getDefaultType());
    ks2.load(null, null);

    MtlsProvider provider =
        new MtlsProvider() {
          @Override
          public KeyStore getKeyStore()
              throws CertificateSourceUnavailableException, IOException {
            int count = callCount.incrementAndGet();
            return count == 1 ? ks1 : ks2;
          }

          @Override
          public boolean isAvailable() throws IOException {
            return true;
          }
        };

    MtlsHttpTransportFactory factory = new MtlsHttpTransportFactory(provider);
    assertEquals(1, callCount.get());
    assertEquals(ks1, factory.getKeyStore());

    HttpTransport transport1 = factory.create();
    assertNotNull(transport1);

    factory.rebuildContext();
    assertEquals(2, callCount.get());
    assertEquals(ks2, factory.getKeyStore());

    HttpTransport transport2 = factory.create();
    assertNotNull(transport2);
  }
}
