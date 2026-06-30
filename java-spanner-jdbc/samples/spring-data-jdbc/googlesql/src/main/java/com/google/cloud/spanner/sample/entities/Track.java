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

import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * The "tracks" table is interleaved in "albums". That means that the first part of the primary key
 * (the "id" column) references the Album that this Track belongs to. That again means that we do
 * not auto-generate the id for this entity. We can achieve this by adding an extra property,
 * albumId, that is mapped to the "id" column. We can then manually set an albumId value before
 * inserting the record in the database.
 */
@Table("tracks")
public class Track extends AbstractEntity {

  /**
   * We need to map this to the "id" column to be able to explicitly set it, instead of letting
   * Spring Data generate it. This is necessary, because Track is interleaved in Album. That again
   * means that we must use the ID value of the Album for a Track.
   */
  @Column("id")
  private Long albumId;

  /** This is the second part of the primary key of a Track. */
  private int trackNumber;

  private String title;

  private Double sampleRate;

  @PersistenceCreator
  public Track() {}

  public Track(Album album, int trackNumber, String title) {
    setAlbumId(album.getId());
    this.trackNumber = trackNumber;
    this.title = title;
  }

  public Long getAlbumId() {
    return albumId;
  }

  private void setAlbumId(Long albumId) {
    this.albumId = albumId;
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
