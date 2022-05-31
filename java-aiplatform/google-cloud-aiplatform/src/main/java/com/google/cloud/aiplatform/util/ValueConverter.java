/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.aiplatform.util;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;

/**
 * Exposes utility methods for converting AI Platform messages to and from
 * {@com.google.protobuf.Value} objects.
 */
public class ValueConverter {

  /** An empty {@com.google.protobuf.Value} message. */
  public static final Value EMPTY_VALUE = Value.newBuilder().build();

  /**
   * Converts a message type to a {@com.google.protobuf.Value}.
   *
   * @param message the message to convert
   * @return the message as a {@com.google.protobuf.Value}
   * @throws InvalidProtocolBufferException
   */
  public static Value toValue(Message message) throws InvalidProtocolBufferException {
    String jsonString = JsonFormat.printer().print(message);
    Value.Builder value = Value.newBuilder();
    JsonFormat.parser().merge(jsonString, value);
    return value.build();
  }

  /**
   * Converts a {@com.google.protobuf.Value} to a {@com.google.protobuf.Message} of the provided
   * {@com.google.protobuf.Message.Builder}.
   *
   * @param messageBuilder a builder for the message type
   * @param value the Value to convert to a message
   * @return the value as a message
   * @throws InvalidProtocolBufferException
   */
  public static Message fromValue(Message.Builder messageBuilder, Value value)
      throws InvalidProtocolBufferException {
    String valueString = JsonFormat.printer().print(value);
    JsonFormat.parser().merge(valueString, messageBuilder);
    return messageBuilder.build();
  }
}
