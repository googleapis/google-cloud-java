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

import com.google.common.io.CharStreams;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import org.jspecify.annotations.NullMarked;

/**
 * An {@link HttpResponseParser} that reads the HTTP response body as a UTF-8 String for resumable
 * upload operations.
 */
@NullMarked
class ResumableUploadResponseParser implements HttpResponseParser<String> {

  private static final ResumableUploadResponseParser INSTANCE = new ResumableUploadResponseParser();

  static ResumableUploadResponseParser create() {
    return INSTANCE;
  }

  private ResumableUploadResponseParser() {}

  @Override
  public String parse(InputStream httpContent) {
    try (Reader reader = new InputStreamReader(httpContent, StandardCharsets.UTF_8)) {
      return CharStreams.toString(reader);
    } catch (IOException e) {
      throw new RestSerializationException("Failed to read response body as string", e);
    }
  }

  @Override
  public String parse(InputStream httpContent, TypeRegistry registry) {
    return parse(httpContent);
  }

  @Override
  public String parse(Reader httpContent, TypeRegistry registry) {
    try {
      return CharStreams.toString(httpContent);
    } catch (IOException e) {
      throw new RestSerializationException("Failed to read response body as string", e);
    }
  }

  @Override
  public String serialize(String response) {
    return response;
  }
}
