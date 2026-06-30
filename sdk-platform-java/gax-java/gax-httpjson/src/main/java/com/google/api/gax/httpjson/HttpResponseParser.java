/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.protobuf.TypeRegistry;
import java.io.InputStream;
import java.io.Reader;

/** Interface for classes that parse parts of HTTP responses into the parameterized message type. */
@InternalExtensionOnly
public interface HttpResponseParser<MessageFormatT> {

  /**
   * Parse the http body content JSON stream into the MessageFormatT.
   *
   * @param httpContent the body of an HTTP response
   * @throws RestSerializationException if failed to parse the {@code httpContent} to a valid {@code
   *     MessageFormatT}
   */
  MessageFormatT parse(InputStream httpContent);

  /**
   * Parse the http body content JSON stream into the MessageFormatT.
   *
   * @param httpContent the body of an HTTP response, represented as an {@link InputStream}
   * @param registry type registry with Any fields descriptors
   * @throws RestSerializationException if failed to parse the {@code httpContent} to a valid {@code
   *     MessageFormatT}
   */
  MessageFormatT parse(InputStream httpContent, TypeRegistry registry);

  /**
   * Parse the http body content JSON reader into the MessageFormatT.
   *
   * @param httpContent the body of an HTTP response, represented as a {@link Reader}
   * @param registry type registry with Any fields descriptors
   * @throws RestSerializationException if failed to parse the {@code httpContent} to a valid {@code
   *     MessageFormatT}
   */
  MessageFormatT parse(Reader httpContent, TypeRegistry registry);

  /**
   * Serialize an object into an HTTP body, which is written out to output.
   *
   * @param response the object to serialize
   * @throws RestSerializationException if failed to serialize {@code response} to a valid {@code
   *     String} representation
   */
  @InternalApi
  String serialize(MessageFormatT response);
}
