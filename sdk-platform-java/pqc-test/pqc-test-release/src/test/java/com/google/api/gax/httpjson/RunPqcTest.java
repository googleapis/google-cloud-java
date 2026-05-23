/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.httpjson;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.NoCredentials;
import com.google.cloud.bigquery.*;
import com.google.cloud.translate.v3.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RunPqcTest extends PqcConnectivityTest {

  @Override
  protected boolean clientSupportsPqc() {
    return false;
  }

  @Test
  @Override
  public void testGrpcPqc() throws Exception {
    TranslationServiceSettings settings =
        TranslationServiceSettings.newBuilder()
            .setEndpoint("localhost:" + grpcPort)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();

    try (TranslationServiceClient client = TranslationServiceClient.create(settings)) {
      List<String> contents = new ArrayList<>();
      contents.add("house");
      TranslateTextRequest request =
          TranslateTextRequest.newBuilder()
              .setParent("projects/test-project")
              .addAllContents(contents)
              .build();

      try {
        TranslateTextResponse response = client.translateText(request);
        assertNotNull(response);
      } catch (ApiException e) {
        fail(
            "Expected gRPC call to succeed in Release (native MLKEM), but failed: "
                + e.getMessage());
      }
    }
  }

  @Test
  @Override
  public void testHttpPqc() throws Exception {
    TranslationServiceSettings settings =
        TranslationServiceSettings.newHttpJsonBuilder()
            .setEndpoint("localhost:" + httpPort)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();

    try (TranslationServiceClient client = TranslationServiceClient.create(settings)) {
      List<String> contents = new ArrayList<>();
      contents.add("house");
      TranslateTextRequest request =
          TranslateTextRequest.newBuilder()
              .setParent("projects/test-project")
              .addAllContents(contents)
              .build();

      try {
        client.translateText(request);
        fail("Expected HTTP call to fail in Release due to PQC enforcement");
      } catch (ApiException e) {
        StatusCode.Code code = e.getStatusCode().getCode();
        if (code != StatusCode.Code.UNAVAILABLE && code != StatusCode.Code.UNKNOWN) {
          fail(
              "Expected HTTP call to fail with UNAVAILABLE or UNKNOWN, but failed with: " + code,
              e);
        }
      }
    }
  }

  @Test
  @Override
  public void testBigQueryPqc() throws Exception {

    // 100% Vanilla BigQuery Client instantiation with NO transport factory or custom option
    // mutations!
    BigQueryOptions bigqueryOptions =
        BigQueryOptions.newBuilder()
            .setProjectId("test-project")
            .setHost("https://localhost:" + httpPort)
            .setCredentials(NoCredentials.getInstance())
            .build();

    BigQuery bigquery = bigqueryOptions.getService();

    // This will trigger a request to
    // https://localhost:httpPort/bigquery/v2/projects/test-project/datasets
    // Under-the-hood, the default factory wraps NetHttpTransport with our programmatic
    // PqcTlsSocketFactory,
    // and negotiates hybrid ML-KEM-768 successfully!
    try {
      bigquery.listDatasets();
      fail("Expected BigQuery client call to fail!");
    } catch (Exception e) {
      System.out.println(
          "Verified: BigQuery client call successfully rejected as expected: " + e.getMessage());
    }
  }
}
