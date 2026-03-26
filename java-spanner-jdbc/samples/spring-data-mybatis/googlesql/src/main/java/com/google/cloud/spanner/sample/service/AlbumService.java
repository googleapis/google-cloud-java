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

package com.google.cloud.spanner.sample.service;

import com.google.cloud.spanner.sample.entities.Album;
import com.google.cloud.spanner.sample.entities.Track;
import com.google.cloud.spanner.sample.mappers.AlbumMapper;
import com.google.cloud.spanner.sample.mappers.TrackMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumService {
  private final AlbumMapper albumMapper;

  private final TrackMapper trackMapper;

  public AlbumService(AlbumMapper albumMapper, TrackMapper trackMapper) {
    this.albumMapper = albumMapper;
    this.trackMapper = trackMapper;
  }

  /** Creates an album and a set of tracks in a read/write transaction. */
  @Transactional
  public Album createAlbumAndTracks(Album album, Track... tracks) {
    // Saving an album will update the album entity with the generated primary key.
    albumMapper.insert(album);
    for (Track track : tracks) {
      // Set the id that was generated on the Album before saving it.
      track.setId(album.getId());
      trackMapper.insert(track);
    }
    return album;
  }
}
