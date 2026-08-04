/*
 * Copyright 2026 Google LLC
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
 *    * Neither the name of Google LLC nor the names of its
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileIdentityPoolTokenSupplierTest {

  @Test
  void getToken_textFormat(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.txt");
    Files.write(credentialFile, "plain_token".getBytes());

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolTokenSupplier supplier =
        new FileIdentityPoolTokenSupplier(source); // TEXT doesn't need targetFieldName

    assertEquals("plain_token", supplier.getSubjectToken(null));

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> supplier.getActorToken(null));
    assertEquals(
        "Actor tokens are only supported for JSON-formatted credential files with distinct field names.",
        exception.getMessage());
  }

  @Test
  void getToken_jsonFormat_cachingLogic(@TempDir Path tempDir)
      throws IOException, InterruptedException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile,
        "{\"sub_token\": \"my_sub_token\", \"act_token\": \"my_act_token\"}".getBytes());

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolTokenSupplier subSupplier = new FileIdentityPoolTokenSupplier(source);
    FileIdentityPoolTokenSupplier actSupplier = new FileIdentityPoolTokenSupplier(source);

    // Initial read
    assertEquals("my_sub_token", subSupplier.getSubjectToken(null));
    assertEquals("my_act_token", actSupplier.getActorToken(null));

    // Wait 10ms for mtime to definitely advance for the reload logic
    Thread.sleep(10);

    // Modify file
    Files.write(
        credentialFile, "{\"sub_token\": \"new_sub\", \"act_token\": \"new_act\"}".getBytes());

    // Validate we read the new token after file modification
    assertEquals("new_sub", subSupplier.getSubjectToken(null));
    assertEquals("new_act", actSupplier.getActorToken(null));
  }

  @Test
  void getToken_jsonFormat_cachingLogic_multithreaded(@TempDir Path tempDir)
      throws IOException, InterruptedException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile,
        "{\"sub_token\": \"my_sub_token\", \"act_token\": \"my_act_token\"}".getBytes());

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolTokenSupplier supplier = new FileIdentityPoolTokenSupplier(source);

    int numThreads = 10;
    java.util.concurrent.ExecutorService executor =
        java.util.concurrent.Executors.newFixedThreadPool(numThreads);
    java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(numThreads);
    java.util.List<java.util.concurrent.Future<Void>> futures = new java.util.ArrayList<>();

    for (int i = 0; i < numThreads; i++) {
      futures.add(
          executor.submit(
              () -> {
                latch.countDown();
                latch.await();
                assertEquals("my_sub_token", supplier.getSubjectToken(null));
                assertEquals("my_act_token", supplier.getActorToken(null));
                return null;
              }));
    }

    // Wait for all threads to complete and verify no exceptions were thrown
    for (java.util.concurrent.Future<Void> future : futures) {
      try {
        future.get();
      } catch (Exception e) {
        throw new RuntimeException("Thread execution failed", e);
      }
    }
    executor.shutdown();
  }

  @Test
  void getToken_jsonFormat_invalidField(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(credentialFile, "{\"sub_token\": \"my_sub_token\"}".getBytes());

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolTokenSupplier actSupplier = new FileIdentityPoolTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> actSupplier.getActorToken(null));
    assertEquals(
        "Invalid token field name. No token was found for field: act_token",
        exception.getMessage());
  }

  @Test
  void getToken_missingFile_throws(@TempDir Path tempDir) {
    Path credentialFile = tempDir.resolve("missing_file.txt");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolTokenSupplier supplier = new FileIdentityPoolTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> supplier.getSubjectToken(null));
    assertEquals(
        String.format(
            "Invalid credential location. The file at %s does not exist.", credentialFile),
        exception.getMessage());
  }
}
