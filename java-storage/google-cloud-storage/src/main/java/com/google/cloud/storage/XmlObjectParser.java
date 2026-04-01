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

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.api.client.util.ObjectParser;
import com.google.cloud.StringEnumValue;
import com.google.cloud.storage.multipartupload.model.ObjectLockMode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.function.Function;

final class XmlObjectParser implements ObjectParser {
  private final XmlMapper xmlMapper;

  @VisibleForTesting
  public XmlObjectParser(XmlMapper xmlMapper) {
    this.xmlMapper = xmlMapper;
    this.xmlMapper.registerModule(new JavaTimeModule());
    // ensure parsing does not fail if any new field is ever added in the future
    this.xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    this.xmlMapper.registerModule(
        new Module() {
          @Override
          public String getModuleName() {
            return this.getClass().getPackage().getName();
          }

          @Override
          public Version version() {
            return Version.unknownVersion();
          }

          @Override
          public void setupModule(SetupContext context) {
            context.addSerializers(
                new SimpleSerializers(
                    ImmutableList.of(
                        new StringEnumValueSerializer<>(StorageClass.class),
                        new StringEnumValueSerializer<>(ObjectLockMode.class))));
            context.addDeserializers(
                new SimpleDeserializers(
                    ImmutableMap.of(
                        StorageClass.class,
                        new StringEnumValueDeserializer<>(
                            StorageClass.class, StorageClass::valueOf),
                        ObjectLockMode.class,
                        new StringEnumValueDeserializer<>(
                            ObjectLockMode.class, ObjectLockMode::valueOf))));
          }
        });
  }

  @Override
  public <T> T parseAndClose(InputStream in, Charset charset, Class<T> dataClass)
      throws IOException {
    return parseAndClose(new InputStreamReader(in, charset), dataClass);
  }

  @Override
  public Object parseAndClose(InputStream in, Charset charset, Type dataType) throws IOException {
    throw new UnsupportedOperationException(
        "XmlObjectParse#"
            + CrossTransportUtils.fmtMethodName(
                "parseAndClose", InputStream.class, Charset.class, Type.class));
  }

  @Override
  public <T> T parseAndClose(Reader reader, Class<T> dataClass) throws IOException {
    try (Reader r = reader) {
      return xmlMapper.readValue(r, dataClass);
    }
  }

  @Override
  public Object parseAndClose(Reader reader, Type dataType) throws IOException {
    throw new UnsupportedOperationException(
        "XmlObjectParse#"
            + CrossTransportUtils.fmtMethodName("parseAndClose", Reader.class, Type.class));
  }

  private static final class StringEnumValueDeserializer<E extends StringEnumValue>
      extends StdDeserializer<E> {

    private final Function<String, E> constructor;

    private StringEnumValueDeserializer(Class<E> cl, Function<String, E> constructor) {
      super(cl);
      this.constructor = constructor;
    }

    @Override
    public E deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JacksonException {
      String s = p.readValueAs(String.class);
      if (s == null || s.trim().isEmpty()) {
        return null;
      }
      return constructor.apply(s);
    }
  }

  private static final class StringEnumValueSerializer<E extends StringEnumValue>
      extends StdSerializer<E> {

    private StringEnumValueSerializer(Class<E> cl) {
      super(cl);
    }

    @Override
    public void serialize(E value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
      gen.writeString(value.name());
    }
  }
}
