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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileIdentityPoolSubjectTokenSupplierTest {

  @Test
  void getToken_textFormat(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.txt");
    Files.write(credentialFile, "plain_token".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source); // TEXT doesn't need targetFieldName

    assertEquals("plain_token", supplier.getSubjectToken(null));

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> supplier.getActorToken(null));
    assertEquals(
        "Actor tokens are only supported for JSON-formatted credential files with distinct field"
            + " names.",
        exception.getMessage());
  }

  @Test
  void getToken_jsonFormat_reReadsFileOnEachCall(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile,
        "{\"sub_token\": \"my_sub_token\", \"act_token\": \"my_act_token\"}"
            .getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    // Initial read
    assertEquals("my_sub_token", supplier.getSubjectToken(null));
    assertEquals("my_act_token", supplier.getActorToken(null));

    // Modify file contents
    Files.write(
        credentialFile,
        "{\"sub_token\": \"new_sub\", \"act_token\": \"new_act\"}"
            .getBytes(StandardCharsets.UTF_8));

    // Validate we read the new token after file modification
    assertEquals("new_sub", supplier.getSubjectToken(null));
    assertEquals("new_act", supplier.getActorToken(null));
  }

  @Test
  void getToken_jsonFormat_concurrentReads(@TempDir Path tempDir)
      throws IOException, InterruptedException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile,
        "{\"sub_token\": \"my_sub_token\", \"act_token\": \"my_act_token\"}"
            .getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

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
    Files.write(
        credentialFile, "{\"sub_token\": \"my_sub_token\"}".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier actSupplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> actSupplier.getActorToken(null));
    assertEquals(
        "Invalid token field name. No token was found for field: act_token",
        exception.getMessage());
  }

  @Test
  void parseToken_jsonFormat_nullField_throws(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(credentialFile, "{\"sub_token\": null}".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> supplier.getSubjectToken(null));
    assertTrue(exception.getMessage().contains("No token was found for field: sub_token"));
  }

  @Test
  void parseToken_jsonFormat_nonStringField_throwsIOException(@TempDir Path tempDir)
      throws IOException {
    // Numeric value
    Path credentialFile = tempDir.resolve("credential_numeric.json");
    Files.write(credentialFile, "{\"sub_token\": 12345}".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    IOException numException =
        assertThrows(IOException.class, () -> supplier.getSubjectToken(null));
    assertTrue(
        numException
            .getMessage()
            .contains("Token field value for sub_token must be a String but was:"));

    // Nested object value
    Path objCredentialFile = tempDir.resolve("credential_object.json");
    Files.write(
        objCredentialFile,
        "{\"sub_token\": {\"nested\": \"val\"}}".getBytes(StandardCharsets.UTF_8));
    credentialSourceMap.put("file", objCredentialFile.toString());
    IdentityPoolCredentialSource objSource = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier objSupplier =
        new FileIdentityPoolSubjectTokenSupplier(objSource);

    IOException objException =
        assertThrows(IOException.class, () -> objSupplier.getSubjectToken(null));
    assertTrue(
        objException
            .getMessage()
            .contains("Token field value for sub_token must be a String but was:"));

    // Boolean value
    Path boolCredentialFile = tempDir.resolve("credential_bool.json");
    Files.write(boolCredentialFile, "{\"sub_token\": true}".getBytes(StandardCharsets.UTF_8));
    credentialSourceMap.put("file", boolCredentialFile.toString());
    IdentityPoolCredentialSource boolSource = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier boolSupplier =
        new FileIdentityPoolSubjectTokenSupplier(boolSource);

    IOException boolException =
        assertThrows(IOException.class, () -> boolSupplier.getSubjectToken(null));
    assertTrue(
        boolException
            .getMessage()
            .contains("Token field value for sub_token must be a String but was:"));

    // Static parseToken with numeric and object inputs
    ByteArrayInputStream numStream =
        new ByteArrayInputStream("{\"sub_token\": 12345}".getBytes(StandardCharsets.UTF_8));
    IOException parseNumException =
        assertThrows(
            IOException.class,
            () -> FileIdentityPoolSubjectTokenSupplier.parseToken(numStream, source, "sub_token"));
    assertTrue(
        parseNumException
            .getMessage()
            .contains("Token field value for sub_token must be a String but was:"));

    ByteArrayInputStream objStream =
        new ByteArrayInputStream(
            "{\"sub_token\": {\"nested\": 42}}".getBytes(StandardCharsets.UTF_8));
    IOException parseObjException =
        assertThrows(
            IOException.class,
            () -> FileIdentityPoolSubjectTokenSupplier.parseToken(objStream, source, "sub_token"));
    assertTrue(
        parseObjException
            .getMessage()
            .contains("Token field value for sub_token must be a String but was:"));
  }

  @Test
  void serialization_roundTrip_succeeds(@TempDir Path tempDir) throws Exception {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile,
        "{\"sub_token\": \"my_sub_token\", \"act_token\": \"my_act_token\"}"
            .getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    // Populate cache
    assertEquals("my_sub_token", supplier.getSubjectToken(null));

    // Serialize and deserialize
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(supplier);
    }
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      FileIdentityPoolSubjectTokenSupplier deserialized =
          (FileIdentityPoolSubjectTokenSupplier) ois.readObject();
      assertNotNull(deserialized);
      assertEquals("my_sub_token", deserialized.getSubjectToken(null));
    }
  }

  @Test
  void serialVersionUID_matchesPrePrSyntheticSuid() {
    assertEquals(
        7152208690659890358L,
        java.io.ObjectStreamClass.lookup(FileIdentityPoolSubjectTokenSupplier.class)
            .getSerialVersionUID());
  }

  @Test
  void getToken_missingFile_throws(@TempDir Path tempDir) {
    Path credentialFile = tempDir.resolve("missing_file.txt");

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> supplier.getSubjectToken(null));
    assertEquals(
        String.format(
            "Invalid credential location. The file at %s does not exist.", credentialFile),
        exception.getMessage());
  }

  @Test
  void parseToken_textFormat_succeeds() throws IOException {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "dummy.txt");
    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);

    ByteArrayInputStream stream =
        new ByteArrayInputStream("plain_text_token".getBytes(StandardCharsets.UTF_8));
    String parsed = FileIdentityPoolSubjectTokenSupplier.parseToken(stream, source, null);
    assertEquals("plain_text_token", parsed);
  }

  @Test
  void parseToken_jsonFormat_missingFieldName_throws() {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "dummy.json");
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    credentialSourceMap.put("format", formatMap);
    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);

    ByteArrayInputStream stream =
        new ByteArrayInputStream("{\"sub_token\": \"my_token\"}".getBytes(StandardCharsets.UTF_8));
    IOException exception =
        assertThrows(
            IOException.class,
            () -> FileIdentityPoolSubjectTokenSupplier.parseToken(stream, source, null));
    assertEquals(
        "Target field name must be specified for JSON credentials.", exception.getMessage());
  }

  @Test
  void readTokens_extractsBothFields(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile,
        "{\"sub_token\": \"my_sub_token\", \"act_token\": \"my_act_token\"}"
            .getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    FileIdentityPoolSubjectTokenSupplier.TokenPair tokens = supplier.readTokens(null);
    assertEquals("my_sub_token", tokens.subject);
    assertEquals("my_act_token", tokens.actor);
  }

  @Test
  void readTokens_missingActorField_throwsIOException(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile, "{\"sub_token\": \"my_sub_token\"}".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> supplier.readTokens(null));
    assertTrue(exception.getMessage().contains("No token was found for field: act_token"));
  }

  @Test
  void readTokens_missingSubjectField_throwsIOException(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile, "{\"act_token\": \"my_act_token\"}".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    formatMap.put("actor_token_field_name", "act_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> supplier.readTokens(null));
    assertTrue(exception.getMessage().contains("No token was found for field: sub_token"));
  }

  @Test
  void readTokens_noActorFieldConfigured_returnsNullActor(@TempDir Path tempDir)
      throws IOException {
    Path credentialFile = tempDir.resolve("credential.json");
    Files.write(
        credentialFile, "{\"sub_token\": \"my_sub_token\"}".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "sub_token");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    FileIdentityPoolSubjectTokenSupplier.TokenPair tokens = supplier.readTokens(null);
    assertEquals("my_sub_token", tokens.subject);
    assertNull(tokens.actor);
  }

  @Test
  void readTokens_textFormat_throwsIOException(@TempDir Path tempDir) throws IOException {
    Path credentialFile = tempDir.resolve("credential.txt");
    Files.write(credentialFile, "plain_token".getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", credentialFile.toString());

    IdentityPoolCredentialSource source = new IdentityPoolCredentialSource(credentialSourceMap);
    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(source);

    IOException exception = assertThrows(IOException.class, () -> supplier.readTokens(null));
    assertTrue(exception.getMessage().contains("only supported for JSON-formatted"));
  }
}
