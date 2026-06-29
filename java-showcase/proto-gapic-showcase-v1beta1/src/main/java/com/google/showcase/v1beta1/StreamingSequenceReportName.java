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

package com.google.showcase.v1beta1;

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
public class StreamingSequenceReportName implements ResourceName {
  private static final PathTemplate STREAMING_SEQUENCE =
      PathTemplate.createWithoutUrlEncoding(
          "streamingSequences/{streaming_sequence}/streamingSequenceReport");
  private volatile Map<String, String> fieldValuesMap;
  private final String streamingSequence;

  @Deprecated
  protected StreamingSequenceReportName() {
    streamingSequence = null;
  }

  private StreamingSequenceReportName(Builder builder) {
    streamingSequence = Preconditions.checkNotNull(builder.getStreamingSequence());
  }

  public String getStreamingSequence() {
    return streamingSequence;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static StreamingSequenceReportName of(String streamingSequence) {
    return newBuilder().setStreamingSequence(streamingSequence).build();
  }

  public static String format(String streamingSequence) {
    return newBuilder().setStreamingSequence(streamingSequence).build().toString();
  }

  public static StreamingSequenceReportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        STREAMING_SEQUENCE.validatedMatch(
            formattedString,
            "StreamingSequenceReportName.parse: formattedString not in valid format");
    return of(matchMap.get("streaming_sequence"));
  }

  public static List<StreamingSequenceReportName> parseList(List<String> formattedStrings) {
    List<StreamingSequenceReportName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<StreamingSequenceReportName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (StreamingSequenceReportName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return STREAMING_SEQUENCE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (streamingSequence != null) {
            fieldMapBuilder.put("streaming_sequence", streamingSequence);
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
    return STREAMING_SEQUENCE.instantiate("streaming_sequence", streamingSequence);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      StreamingSequenceReportName that = ((StreamingSequenceReportName) o);
      return Objects.equals(this.streamingSequence, that.streamingSequence);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(streamingSequence);
    return h;
  }

  /** Builder for streamingSequences/{streaming_sequence}/streamingSequenceReport. */
  public static class Builder {
    private String streamingSequence;

    protected Builder() {}

    public String getStreamingSequence() {
      return streamingSequence;
    }

    public Builder setStreamingSequence(String streamingSequence) {
      this.streamingSequence = streamingSequence;
      return this;
    }

    private Builder(StreamingSequenceReportName streamingSequenceReportName) {
      this.streamingSequence = streamingSequenceReportName.streamingSequence;
    }

    public StreamingSequenceReportName build() {
      return new StreamingSequenceReportName(this);
    }
  }
}
