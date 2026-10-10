/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.chat.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class MessagePinName implements ResourceName {
  private static final PathTemplate SPACE_MESSAGE_PIN =
      PathTemplate.createWithoutUrlEncoding("spaces/{space}/messagePins/{message_pin}");
  private volatile Map<String, String> fieldValuesMap;
  private final String space;
  private final String messagePin;

  @Deprecated
  protected MessagePinName() {
    space = null;
    messagePin = null;
  }

  private MessagePinName(Builder builder) {
    space = Preconditions.checkNotNull(builder.getSpace());
    messagePin = Preconditions.checkNotNull(builder.getMessagePin());
  }

  public String getSpace() {
    return space;
  }

  public String getMessagePin() {
    return messagePin;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MessagePinName of(String space, String messagePin) {
    return newBuilder().setSpace(space).setMessagePin(messagePin).build();
  }

  public static String format(String space, String messagePin) {
    return newBuilder().setSpace(space).setMessagePin(messagePin).build().toString();
  }

  public static @Nullable MessagePinName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SPACE_MESSAGE_PIN.validatedMatch(
            formattedString, "MessagePinName.parse: formattedString not in valid format");
    return of(matchMap.get("space"), matchMap.get("message_pin"));
  }

  public static List<MessagePinName> parseList(List<String> formattedStrings) {
    List<MessagePinName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable MessagePinName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MessagePinName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SPACE_MESSAGE_PIN.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (space != null) {
            fieldMapBuilder.put("space", space);
          }
          if (messagePin != null) {
            fieldMapBuilder.put("message_pin", messagePin);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return SPACE_MESSAGE_PIN.instantiate("space", space, "message_pin", messagePin);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MessagePinName that = ((MessagePinName) o);
      return Objects.equals(this.space, that.space)
          && Objects.equals(this.messagePin, that.messagePin);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(messagePin);
    return h;
  }

  /** Builder for spaces/{space}/messagePins/{message_pin}. */
  public static class Builder {
    private String space;
    private String messagePin;

    protected Builder() {}

    public String getSpace() {
      return space;
    }

    public String getMessagePin() {
      return messagePin;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setMessagePin(String messagePin) {
      this.messagePin = messagePin;
      return this;
    }

    private Builder(MessagePinName messagePinName) {
      this.space = messagePinName.space;
      this.messagePin = messagePinName.messagePin;
    }

    public MessagePinName build() {
      return new MessagePinName(this);
    }
  }
}
