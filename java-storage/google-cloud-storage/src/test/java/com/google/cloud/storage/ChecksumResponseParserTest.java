/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import java.io.IOException;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class ChecksumResponseParserTest {

  @Test
  public void testParse() throws IOException {
    HttpResponse response =
        createHttpResponse("\"test-etag\"", "crc32c=AAAAAA==,md5=rL0Y20zC+Fzt72VPzMSk2A==");

    UploadPartResponse uploadPartResponse = ChecksumResponseParser.parseUploadResponse(response);

    assertThat(uploadPartResponse.eTag()).isEqualTo("\"test-etag\"");
    assertThat(uploadPartResponse.md5()).isEqualTo("rL0Y20zC+Fzt72VPzMSk2A==");
    assertThat(uploadPartResponse.crc32c()).isEqualTo("AAAAAA==");
  }

  @Test
  public void testExtractHashesFromHeader() throws IOException {
    HttpResponse response =
        createHttpResponse(null, "crc32c=AAAAAA==,md5=rL0Y20zC+Fzt72VPzMSk2A==");
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    assertThat(hashes).containsEntry("crc32c", "AAAAAA==");
    assertThat(hashes).containsEntry("md5", "rL0Y20zC+Fzt72VPzMSk2A==");
  }

  @Test
  public void testExtractHashesFromHeader_singleHash() throws IOException {
    HttpResponse response = createHttpResponse(null, "crc32c=AAAAAA==");
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    assertThat(hashes).containsEntry("crc32c", "AAAAAA==");
    assertThat(hashes).doesNotContainKey("md5");
  }

  @Test
  public void testExtractHashesFromHeader_unknownHash() throws IOException {
    HttpResponse response =
        createHttpResponse(null, "crc32c=AAAAAA==,sha256=rL0Y20zC+Fzt72VPzMSk2A==");
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    assertThat(hashes).containsEntry("crc32c", "AAAAAA==");
    assertThat(hashes).doesNotContainKey("sha256");
  }

  @Test
  public void testExtractHashesFromHeader_nullHeader() throws IOException {
    HttpResponse response = createHttpResponse(null, null);
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    assertThat(hashes).isEmpty();
  }

  @Test
  public void testExtractHashesFromHeader_emptyHeader() throws IOException {
    HttpResponse response = createHttpResponse(null, "");
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    assertThat(hashes).isEmpty();
  }

  @Test
  public void testExtractHashesFromHeader_multipleHeaders() throws IOException {
    HttpResponse response =
        createHttpResponse(null, "crc32c=AAAAAA==", "md5=rL0Y20zC+Fzt72VPzMSk2A==");
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    assertThat(hashes).containsEntry("crc32c", "AAAAAA==");
    assertThat(hashes).containsEntry("md5", "rL0Y20zC+Fzt72VPzMSk2A==");
  }

  @Test
  public void testExtractHashesFromHeader_multipleHeadersAndCsv() throws IOException {
    HttpResponse response =
        createHttpResponse(null, "crc32c=AAAAAA==", "md5=rL0Y20zC+Fzt72VPzMSk2A==,extra=value");
    Map<String, String> hashes = ChecksumResponseParser.extractHashesFromHeader(response);
    assertThat(hashes).containsEntry("crc32c", "AAAAAA==");
    assertThat(hashes).containsEntry("md5", "rL0Y20zC+Fzt72VPzMSk2A==");
    assertThat(hashes).hasSize(2);
  }

  private HttpResponse createHttpResponse(String etag, String... googHash) throws IOException {
    MockLowLevelHttpResponse lowLevelResponse = new MockLowLevelHttpResponse();
    if (etag != null) {
      lowLevelResponse.addHeader("ETag", etag);
    }
    if (googHash != null) {
      for (String hash : googHash) {
        lowLevelResponse.addHeader("x-goog-hash", hash);
      }
    }
    HttpTransport transport =
        new MockHttpTransport.Builder().setLowLevelHttpResponse(lowLevelResponse).build();
    HttpRequest request =
        transport.createRequestFactory().buildGetRequest(new GenericUrl("http://example.com"));
    return request.execute();
  }
}
