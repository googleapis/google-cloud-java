/*
 * Copyright 2025 Google LLC
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

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import com.google.genai.types.Content;
import java.time.Instant;
import java.util.Optional;

/** Represents a single message turn in a conversation. */
@AutoValue
@JsonDeserialize(builder = Message.Builder.class)
public abstract class Message extends JsonSerializable {
  /** Unique identifier for the message turn. */
  @JsonProperty("turnId")
  public abstract Optional<String> turnId();

  /** Content of the message, including function call. */
  @JsonProperty("content")
  public abstract Optional<Content> content();

  /** Timestamp indicating when the message was created. */
  @JsonProperty("creationTimestamp")
  public abstract Optional<Instant> creationTimestamp();

  /** Name of the entity that produced the message. */
  @JsonProperty("author")
  public abstract Optional<String> author();

  /** Instantiates a builder for Message. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_Message.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for Message. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `Message.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_Message.Builder();
    }

    /**
     * Setter for turnId.
     *
     * <p>turnId: Unique identifier for the message turn.
     */
    @JsonProperty("turnId")
    public abstract Builder turnId(String turnId);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder turnId(Optional<String> turnId);

    /** Clears the value of turnId field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearTurnId() {
      return turnId(Optional.empty());
    }

    /**
     * Setter for content.
     *
     * <p>content: Content of the message, including function call.
     */
    @JsonProperty("content")
    public abstract Builder content(Content content);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder content(Optional<Content> content);

    /** Clears the value of content field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContent() {
      return content(Optional.empty());
    }

    /**
     * Setter for creationTimestamp.
     *
     * <p>creationTimestamp: Timestamp indicating when the message was created.
     */
    @JsonProperty("creationTimestamp")
    public abstract Builder creationTimestamp(Instant creationTimestamp);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder creationTimestamp(Optional<Instant> creationTimestamp);

    /** Clears the value of creationTimestamp field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCreationTimestamp() {
      return creationTimestamp(Optional.empty());
    }

    /**
     * Setter for author.
     *
     * <p>author: Name of the entity that produced the message.
     */
    @JsonProperty("author")
    public abstract Builder author(String author);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder author(Optional<String> author);

    /** Clears the value of author field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAuthor() {
      return author(Optional.empty());
    }

    public abstract Message build();
  }

  /** Deserializes a JSON string to a Message object. */
  @ExcludeFromGeneratedCoverageReport
  public static Message fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, Message.class);
  }
}
