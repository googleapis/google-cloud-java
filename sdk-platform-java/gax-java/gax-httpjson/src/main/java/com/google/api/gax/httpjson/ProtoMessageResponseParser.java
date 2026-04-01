/*
 * Copyright 2020 Google LLC
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

import com.google.protobuf.Message;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/** The implementation of {@link HttpResponseParser} which works with protobuf messages. */
public class ProtoMessageResponseParser<ResponseT extends Message>
    implements HttpResponseParser<ResponseT> {

  private final ResponseT defaultInstance;
  private final TypeRegistry defaultRegistry;

  private ProtoMessageResponseParser(ResponseT defaultInstance, TypeRegistry defaultRegistry) {
    this.defaultInstance = defaultInstance;
    this.defaultRegistry = defaultRegistry;
  }

  public static <ResponseT extends Message>
      ProtoMessageResponseParser.Builder<ResponseT> newBuilder() {
    return new ProtoMessageResponseParser.Builder<ResponseT>()
        .setDefaultTypeRegistry(TypeRegistry.getEmptyTypeRegistry());
  }

  /* {@inheritDoc} */
  @Override
  public ResponseT parse(InputStream httpContent) {
    return parse(httpContent, defaultRegistry);
  }

  @Override
  public ResponseT parse(InputStream httpContent, TypeRegistry registry) {
    try (Reader json = new InputStreamReader(httpContent, StandardCharsets.UTF_8)) {
      return parse(json, registry);
    } catch (IOException e) {
      throw new RestSerializationException("Failed to parse response message", e);
    }
  }

  @Override
  public ResponseT parse(Reader httpContent, TypeRegistry registry) {
    return ProtoRestSerializer.<ResponseT>create(registry)
        .fromJson(httpContent, defaultInstance.newBuilderForType());
  }

  /* {@inheritDoc} */
  @Override
  public String serialize(ResponseT response) {
    return ProtoRestSerializer.create(defaultRegistry).toJson(response, false);
  }

  // Convert to @AutoValue if this class gets more complicated
  public static class Builder<ResponseT extends Message> {
    private ResponseT defaultInstance;
    private TypeRegistry defaultRegistry;

    public Builder<ResponseT> setDefaultInstance(ResponseT defaultInstance) {
      this.defaultInstance = defaultInstance;
      return this;
    }

    public Builder<ResponseT> setDefaultTypeRegistry(TypeRegistry defaultRegistry) {
      this.defaultRegistry = defaultRegistry;
      return this;
    }

    public ProtoMessageResponseParser<ResponseT> build() {
      return new ProtoMessageResponseParser<>(defaultInstance, defaultRegistry);
    }
  }
}
