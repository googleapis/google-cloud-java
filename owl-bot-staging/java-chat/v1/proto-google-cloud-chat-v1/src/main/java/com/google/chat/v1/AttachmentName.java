/*
 * Copyright 2024 Google LLC
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class AttachmentName implements ResourceName {
  private static final PathTemplate SPACE_MESSAGE_ATTACHMENT =
      PathTemplate.createWithoutUrlEncoding(
          "spaces/{space}/messages/{message}/attachments/{attachment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String space;
  private final String message;
  private final String attachment;

  @Deprecated
  protected AttachmentName() {
    space = null;
    message = null;
    attachment = null;
  }

  private AttachmentName(Builder builder) {
    space = Preconditions.checkNotNull(builder.getSpace());
    message = Preconditions.checkNotNull(builder.getMessage());
    attachment = Preconditions.checkNotNull(builder.getAttachment());
  }

  public String getSpace() {
    return space;
  }

  public String getMessage() {
    return message;
  }

  public String getAttachment() {
    return attachment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AttachmentName of(String space, String message, String attachment) {
    return newBuilder().setSpace(space).setMessage(message).setAttachment(attachment).build();
  }

  public static String format(String space, String message, String attachment) {
    return newBuilder()
        .setSpace(space)
        .setMessage(message)
        .setAttachment(attachment)
        .build()
        .toString();
  }

  public static AttachmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SPACE_MESSAGE_ATTACHMENT.validatedMatch(
            formattedString, "AttachmentName.parse: formattedString not in valid format");
    return of(matchMap.get("space"), matchMap.get("message"), matchMap.get("attachment"));
  }

  public static List<AttachmentName> parseList(List<String> formattedStrings) {
    List<AttachmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AttachmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AttachmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SPACE_MESSAGE_ATTACHMENT.matches(formattedString);
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
          if (message != null) {
            fieldMapBuilder.put("message", message);
          }
          if (attachment != null) {
            fieldMapBuilder.put("attachment", attachment);
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
    return SPACE_MESSAGE_ATTACHMENT.instantiate(
        "space", space, "message", message, "attachment", attachment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AttachmentName that = ((AttachmentName) o);
      return Objects.equals(this.space, that.space)
          && Objects.equals(this.message, that.message)
          && Objects.equals(this.attachment, that.attachment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(message);
    h *= 1000003;
    h ^= Objects.hashCode(attachment);
    return h;
  }

  /** Builder for spaces/{space}/messages/{message}/attachments/{attachment}. */
  public static class Builder {
    private String space;
    private String message;
    private String attachment;

    protected Builder() {}

    public String getSpace() {
      return space;
    }

    public String getMessage() {
      return message;
    }

    public String getAttachment() {
      return attachment;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Builder setAttachment(String attachment) {
      this.attachment = attachment;
      return this;
    }

    private Builder(AttachmentName attachmentName) {
      this.space = attachmentName.space;
      this.message = attachmentName.message;
      this.attachment = attachmentName.attachment;
    }

    public AttachmentName build() {
      return new AttachmentName(this);
    }
  }
}
