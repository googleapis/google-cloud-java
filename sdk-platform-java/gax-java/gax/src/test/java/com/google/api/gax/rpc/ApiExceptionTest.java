/*
 * Copyright 2022 Google LLC
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
package com.google.api.gax.rpc;

import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ApiExceptionTest {

  private static final ErrorDetails ERROR_DETAILS_WITH_NO_ERROR_INFO =
      ErrorDetails.builder().setRawErrorMessages(Collections.emptyList()).build();
  private static final String DOMAIN = "googleapis.com";
  private static final String REASON = "SERVICE_DISABLED";
  private static final String METADATA_KEY = "service";
  private static final String METADATA_VALUE = "language.googleapis.com";
  private static final ErrorDetails ERROR_DETAILS_WITH_ERROR_INFO =
      ErrorDetails.builder()
          .setRawErrorMessages(
              ImmutableList.of(
                  Any.pack(
                      ErrorInfo.newBuilder()
                          .setDomain(DOMAIN)
                          .setReason(REASON)
                          .putMetadata(METADATA_KEY, METADATA_VALUE)
                          .build())))
          .build();
  private static final FakeStatusCode STATUS_CODE = FakeStatusCode.of(Code.UNAVAILABLE);

  private ApiException apiException;

  @Test
  void getReason_shouldReturnNullIfErrorDetailsIsNull() {
    apiException = new ApiException(null, STATUS_CODE, false, null);

    Truth.assertThat(apiException.getReason()).isNull();
  }

  @Test
  void getReason_shouldReturnNullIfErrorInfoIsNull() {
    apiException = new ApiException(null, STATUS_CODE, false, ERROR_DETAILS_WITH_NO_ERROR_INFO);

    Truth.assertThat(apiException.getReason()).isNull();
  }

  @Test
  void getReason_shouldReturnReasonIfAvailable() {
    apiException = new ApiException(null, STATUS_CODE, false, ERROR_DETAILS_WITH_ERROR_INFO);

    Truth.assertThat(apiException.getReason()).isEqualTo(REASON);
  }

  @Test
  void getDomain_shouldReturnNullIfErrorInfoIsNull() {
    apiException = new ApiException(null, STATUS_CODE, false, ERROR_DETAILS_WITH_NO_ERROR_INFO);

    Truth.assertThat(apiException.getDomain()).isNull();
  }

  @Test
  void getDomain_shouldReturnDomainIfAvailable() {
    apiException = new ApiException(null, STATUS_CODE, false, ERROR_DETAILS_WITH_ERROR_INFO);

    Truth.assertThat(apiException.getDomain()).isEqualTo(DOMAIN);
  }

  @Test
  void getMetadata_shouldReturnNullIfErrorInfoIsNull() {
    apiException = new ApiException(null, STATUS_CODE, false, ERROR_DETAILS_WITH_NO_ERROR_INFO);

    Truth.assertThat(apiException.getMetadata()).isNull();
  }

  @Test
  void getMetadata_shouldReturnMetadataIfAvailable() {
    apiException = new ApiException(null, STATUS_CODE, false, ERROR_DETAILS_WITH_ERROR_INFO);

    Truth.assertThat(apiException.getMetadata()).containsExactly(METADATA_KEY, METADATA_VALUE);
  }
}
