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
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.oauth2.IdentityPoolCredentialSource.CredentialFormatType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileIdentityPoolSubjectTokenSupplierTest {

  @Test
  void parseToken_textFormat_closesStream() throws IOException {
    String token = "my-subject-token";
    byte[] bytes = token.getBytes(StandardCharsets.UTF_8);
    TrackingInputStream stream = new TrackingInputStream(bytes);

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "/path/to/file");
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    // Default credential format type is TEXT.
    assertEquals(CredentialFormatType.TEXT, credentialSource.credentialFormatType);

    String parsedToken = FileIdentityPoolSubjectTokenSupplier.parseToken(stream, credentialSource);

    assertEquals(token, parsedToken);
    assertTrue(stream.closed, "InputStream should be closed after parsing TEXT format");
  }

  @Test
  void parseToken_jsonFormat_closesStream() throws IOException {
    String json = "{\"subjectToken\":\"my-json-token\"}";
    byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
    TrackingInputStream stream = new TrackingInputStream(bytes);

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "/path/to/file");
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    assertEquals(CredentialFormatType.JSON, credentialSource.credentialFormatType);

    String parsedToken = FileIdentityPoolSubjectTokenSupplier.parseToken(stream, credentialSource);

    assertEquals("my-json-token", parsedToken);
    assertTrue(stream.closed, "InputStream should be closed after parsing JSON format");
  }

  @Test
  void parseToken_jsonFormat_missingField_closesStream() throws IOException {
    String json = "{\"otherField\":\"my-json-token\"}";
    byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
    TrackingInputStream stream = new TrackingInputStream(bytes);

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "/path/to/file");
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    assertThrows(
        IOException.class,
        () -> FileIdentityPoolSubjectTokenSupplier.parseToken(stream, credentialSource));

    assertTrue(stream.closed, "InputStream should be closed even if parsing throws an exception");
  }

  @Test
  void parseToken_jsonFormat_malformedJson_closesStream() {
    String malformedJson = "{invalid-json";
    byte[] bytes = malformedJson.getBytes(StandardCharsets.UTF_8);
    TrackingInputStream stream = new TrackingInputStream(bytes);

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "/path/to/file");
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    assertThrows(
        IOException.class,
        () -> FileIdentityPoolSubjectTokenSupplier.parseToken(stream, credentialSource));

    assertTrue(
        stream.closed, "InputStream should be closed even if parsing throws a parsing exception");
  }

  @Test
  void getSubjectToken_fileDoesNotExist_throwsException() {
    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", "/nonexistent/path/to/file");
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(credentialSource);

    IOException exception = assertThrows(IOException.class, () -> supplier.getSubjectToken(null));
    assertTrue(exception.getMessage().contains("Invalid credential location"));
  }

  @Test
  void getSubjectToken_textFormat_returnsToken(@TempDir Path tempDir) throws IOException {
    Path file = tempDir.resolve("token.txt");
    String expectedToken = "text-token-from-file";
    Files.write(file, expectedToken.getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", file.toAbsolutePath().toString());
    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(credentialSource);

    String parsedToken = supplier.getSubjectToken(null);
    assertEquals(expectedToken, parsedToken);
  }

  @Test
  void getSubjectToken_jsonFormat_returnsToken(@TempDir Path tempDir) throws IOException {
    Path file = tempDir.resolve("token.json");
    String json = "{\"subjectToken\":\"json-token-from-file\"}";
    Files.write(file, json.getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", file.toAbsolutePath().toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(credentialSource);

    String parsedToken = supplier.getSubjectToken(null);
    assertEquals("json-token-from-file", parsedToken);
  }

  @Test
  void getSubjectToken_jsonFormat_missingField_throwsException(@TempDir Path tempDir)
      throws IOException {
    Path file = tempDir.resolve("token.json");
    String json = "{\"otherField\":\"json-token-from-file\"}";
    Files.write(file, json.getBytes(StandardCharsets.UTF_8));

    Map<String, Object> credentialSourceMap = new HashMap<>();
    credentialSourceMap.put("file", file.toAbsolutePath().toString());
    Map<String, String> formatMap = new HashMap<>();
    formatMap.put("type", "json");
    formatMap.put("subject_token_field_name", "subjectToken");
    credentialSourceMap.put("format", formatMap);

    IdentityPoolCredentialSource credentialSource =
        new IdentityPoolCredentialSource(credentialSourceMap);

    FileIdentityPoolSubjectTokenSupplier supplier =
        new FileIdentityPoolSubjectTokenSupplier(credentialSource);

    IOException exception = assertThrows(IOException.class, () -> supplier.getSubjectToken(null));
    assertTrue(
        exception
            .getMessage()
            .contains("Error when attempting to read the subject token from the credential file."));
  }

  private static class TrackingInputStream extends ByteArrayInputStream {
    boolean closed = false;

    TrackingInputStream(byte[] buf) {
      super(buf);
    }

    @Override
    public void close() throws IOException {
      closed = true;
      super.close();
    }
  }
}
