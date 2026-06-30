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

package com.google.cloud.spanner.sample.entities;

/**
 * The "tracks" table is interleaved in "albums". That means that the first part of the primary key
 * (the "id" column) references the Album that this Track belongs to. That again means that we do
 * not auto-generate the id for this entity.
 */
public class Track extends AbstractEntity {

  /**
   * This is the second part of the primary key of a Track. The first part, the 'id' column is
   * defined in the {@link AbstractEntity} super class.
   */
  private int trackNumber;

  private String title;

  private Double sampleRate;

  public Track(Album album, int trackNumber, String title, Double sampleRate) {
    setId(album.getId());
    this.trackNumber = trackNumber;
    this.title = title;
    this.sampleRate = sampleRate;
  }

  public int getTrackNumber() {
    return trackNumber;
  }

  public void setTrackNumber(int trackNumber) {
    this.trackNumber = trackNumber;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getSampleRate() {
    return sampleRate;
  }

  public void setSampleRate(Double sampleRate) {
    this.sampleRate = sampleRate;
  }
}
