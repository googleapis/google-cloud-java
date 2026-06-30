/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.spanner.sample.entities.Singer;
import com.google.cloud.spanner.sample.mappers.AlbumMapper;
import com.google.cloud.spanner.sample.mappers.SingerMapper;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SingerService {
  private final SingerMapper singerRepository;

  private final AlbumMapper albumRepository;

  public SingerService(SingerMapper singerRepository, AlbumMapper albumRepository) {
    this.singerRepository = singerRepository;
    this.albumRepository = albumRepository;
  }

  /** Creates a singer and a list of albums in a read/write transaction. */
  @Transactional
  public Singer createSingerAndAlbums(Singer singer, Album... albums) {
    // Saving a singer will update the singer entity with the generated primary key.
    singerRepository.insert(singer);
    for (Album album : albums) {
      // Set the singerId that was generated on the Album before saving it.
      album.setSingerId(singer.getId());
      albumRepository.insert(album);
    }
    return singer;
  }

  /**
   * Searches for all singers that have a last name starting with any of the given prefixes. This
   * method uses a read-only transaction. Read-only transactions should be preferred to read/write
   * transactions whenever possible, as read-only transactions do not take locks.
   */
  @Transactional(readOnly = true)
  public List<Singer> listSingersWithLastNameStartingWith(String... prefixes) {
    ImmutableList.Builder<Singer> result = ImmutableList.builder();
    // This is not the most efficient way to search for this, but the main purpose of this method is
    // to show how to use read-only transactions.
    for (String prefix : prefixes) {
      result.addAll(singerRepository.findSingersByLastNameStartingWith(prefix));
    }
    return result.build();
  }
}
