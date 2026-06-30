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
package com.google.api.gax.httpjson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.util.Iterator;

/** This class is not thread-safe and is expected to be used under external synchronization. */
class ProtoMessageJsonStreamIterator implements Closeable, Iterator<Reader> {
  private volatile boolean arrayStarted;
  private final JsonReader jsonReader;
  private final PipedReader reader;
  private final PipedWriter writer;

  ProtoMessageJsonStreamIterator(Reader rawReader) throws IOException {
    this.arrayStarted = false;
    this.jsonReader = new JsonReader(rawReader);
    this.reader = new PipedReader(0x40000); // 256K
    this.writer = new PipedWriter();
    writer.connect(reader);
  }

  @Override
  public void close() throws IOException {
    reader.close();
    writer.close();
    jsonReader.close();
  }

  public boolean hasNext() {
    try {
      if (!arrayStarted) {
        jsonReader.beginArray();
        arrayStarted = true;
      }
      return jsonReader.hasNext();
    } catch (IOException e) {
      throw new RestSerializationException(e);
    }
  }

  @Override
  public Reader next() {
    try {
      int nestedObjectCount = 0;
      JsonWriter jsonWriter = new JsonWriter(writer);
      do {
        JsonToken token = jsonReader.peek();
        switch (token) {
          case BEGIN_ARRAY:
            jsonReader.beginArray();
            jsonWriter.beginArray();
            break;
          case END_ARRAY:
            jsonReader.endArray();
            jsonWriter.endArray();
            break;
          case BEGIN_OBJECT:
            nestedObjectCount++;
            jsonReader.beginObject();
            jsonWriter.beginObject();
            break;
          case END_OBJECT:
            jsonReader.endObject();
            jsonWriter.endObject();
            nestedObjectCount--;
            break;
          case NAME:
            String name = jsonReader.nextName();
            jsonWriter.name(name);
            break;
          case STRING:
            String s = jsonReader.nextString();
            jsonWriter.value(s);
            break;
          case NUMBER:
            String n = jsonReader.nextString();
            jsonWriter.value(n);
            break;
          case BOOLEAN:
            boolean b = jsonReader.nextBoolean();
            jsonWriter.value(b);
            break;
          case NULL:
            jsonReader.nextNull();
            jsonWriter.nullValue();
            break;
          case END_DOCUMENT:
            nestedObjectCount--;
        }
      } while (nestedObjectCount > 0);

      jsonWriter.flush();

      return reader;
    } catch (IOException e) {
      throw new RestSerializationException(e);
    }
  }
}
