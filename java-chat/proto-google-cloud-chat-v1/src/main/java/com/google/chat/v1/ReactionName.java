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
public class ReactionName implements ResourceName {
  private static final PathTemplate SPACE_MESSAGE_REACTION =
      PathTemplate.createWithoutUrlEncoding(
          "spaces/{space}/messages/{message}/reactions/{reaction}");
  private volatile Map<String, String> fieldValuesMap;
  private final String space;
  private final String message;
  private final String reaction;

  @Deprecated
  protected ReactionName() {
    space = null;
    message = null;
    reaction = null;
  }

  private ReactionName(Builder builder) {
    space = Preconditions.checkNotNull(builder.getSpace());
    message = Preconditions.checkNotNull(builder.getMessage());
    reaction = Preconditions.checkNotNull(builder.getReaction());
  }

  public String getSpace() {
    return space;
  }

  public String getMessage() {
    return message;
  }

  public String getReaction() {
    return reaction;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReactionName of(String space, String message, String reaction) {
    return newBuilder().setSpace(space).setMessage(message).setReaction(reaction).build();
  }

  public static String format(String space, String message, String reaction) {
    return newBuilder()
        .setSpace(space)
        .setMessage(message)
        .setReaction(reaction)
        .build()
        .toString();
  }

  public static ReactionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SPACE_MESSAGE_REACTION.validatedMatch(
            formattedString, "ReactionName.parse: formattedString not in valid format");
    return of(matchMap.get("space"), matchMap.get("message"), matchMap.get("reaction"));
  }

  public static List<ReactionName> parseList(List<String> formattedStrings) {
    List<ReactionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReactionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReactionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SPACE_MESSAGE_REACTION.matches(formattedString);
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
          if (reaction != null) {
            fieldMapBuilder.put("reaction", reaction);
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
    return SPACE_MESSAGE_REACTION.instantiate(
        "space", space, "message", message, "reaction", reaction);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReactionName that = ((ReactionName) o);
      return Objects.equals(this.space, that.space)
          && Objects.equals(this.message, that.message)
          && Objects.equals(this.reaction, that.reaction);
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
    h ^= Objects.hashCode(reaction);
    return h;
  }

  /** Builder for spaces/{space}/messages/{message}/reactions/{reaction}. */
  public static class Builder {
    private String space;
    private String message;
    private String reaction;

    protected Builder() {}

    public String getSpace() {
      return space;
    }

    public String getMessage() {
      return message;
    }

    public String getReaction() {
      return reaction;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Builder setReaction(String reaction) {
      this.reaction = reaction;
      return this;
    }

    private Builder(ReactionName reactionName) {
      this.space = reactionName.space;
      this.message = reactionName.message;
      this.reaction = reactionName.reaction;
    }

    public ReactionName build() {
      return new ReactionName(this);
    }
  }
}
