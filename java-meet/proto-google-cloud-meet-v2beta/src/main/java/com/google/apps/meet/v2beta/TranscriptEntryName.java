/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2beta;

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
public class TranscriptEntryName implements ResourceName {
  private static final PathTemplate CONFERENCE_RECORD_TRANSCRIPT_ENTRY =
      PathTemplate.createWithoutUrlEncoding(
          "conferenceRecords/{conference_record}/transcripts/{transcript}/entries/{entry}");
  private volatile Map<String, String> fieldValuesMap;
  private final String conferenceRecord;
  private final String transcript;
  private final String entry;

  @Deprecated
  protected TranscriptEntryName() {
    conferenceRecord = null;
    transcript = null;
    entry = null;
  }

  private TranscriptEntryName(Builder builder) {
    conferenceRecord = Preconditions.checkNotNull(builder.getConferenceRecord());
    transcript = Preconditions.checkNotNull(builder.getTranscript());
    entry = Preconditions.checkNotNull(builder.getEntry());
  }

  public String getConferenceRecord() {
    return conferenceRecord;
  }

  public String getTranscript() {
    return transcript;
  }

  public String getEntry() {
    return entry;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TranscriptEntryName of(String conferenceRecord, String transcript, String entry) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setTranscript(transcript)
        .setEntry(entry)
        .build();
  }

  public static String format(String conferenceRecord, String transcript, String entry) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setTranscript(transcript)
        .setEntry(entry)
        .build()
        .toString();
  }

  public static TranscriptEntryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CONFERENCE_RECORD_TRANSCRIPT_ENTRY.validatedMatch(
            formattedString, "TranscriptEntryName.parse: formattedString not in valid format");
    return of(matchMap.get("conference_record"), matchMap.get("transcript"), matchMap.get("entry"));
  }

  public static List<TranscriptEntryName> parseList(List<String> formattedStrings) {
    List<TranscriptEntryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TranscriptEntryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TranscriptEntryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CONFERENCE_RECORD_TRANSCRIPT_ENTRY.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (conferenceRecord != null) {
            fieldMapBuilder.put("conference_record", conferenceRecord);
          }
          if (transcript != null) {
            fieldMapBuilder.put("transcript", transcript);
          }
          if (entry != null) {
            fieldMapBuilder.put("entry", entry);
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
    return CONFERENCE_RECORD_TRANSCRIPT_ENTRY.instantiate(
        "conference_record", conferenceRecord, "transcript", transcript, "entry", entry);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TranscriptEntryName that = ((TranscriptEntryName) o);
      return Objects.equals(this.conferenceRecord, that.conferenceRecord)
          && Objects.equals(this.transcript, that.transcript)
          && Objects.equals(this.entry, that.entry);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(conferenceRecord);
    h *= 1000003;
    h ^= Objects.hashCode(transcript);
    h *= 1000003;
    h ^= Objects.hashCode(entry);
    return h;
  }

  /** Builder for conferenceRecords/{conference_record}/transcripts/{transcript}/entries/{entry}. */
  public static class Builder {
    private String conferenceRecord;
    private String transcript;
    private String entry;

    protected Builder() {}

    public String getConferenceRecord() {
      return conferenceRecord;
    }

    public String getTranscript() {
      return transcript;
    }

    public String getEntry() {
      return entry;
    }

    public Builder setConferenceRecord(String conferenceRecord) {
      this.conferenceRecord = conferenceRecord;
      return this;
    }

    public Builder setTranscript(String transcript) {
      this.transcript = transcript;
      return this;
    }

    public Builder setEntry(String entry) {
      this.entry = entry;
      return this;
    }

    private Builder(TranscriptEntryName transcriptEntryName) {
      this.conferenceRecord = transcriptEntryName.conferenceRecord;
      this.transcript = transcriptEntryName.transcript;
      this.entry = transcriptEntryName.entry;
    }

    public TranscriptEntryName build() {
      return new TranscriptEntryName(this);
    }
  }
}
