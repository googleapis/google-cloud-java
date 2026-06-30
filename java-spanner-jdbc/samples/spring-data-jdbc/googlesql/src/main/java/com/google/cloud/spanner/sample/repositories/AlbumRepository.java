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

package com.google.cloud.spanner.sample.repositories;

import com.google.cloud.spanner.sample.entities.Album;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

  /**
   * The implementation for this method is automatically generated and will fetch all albums of the
   * given singer.
   */
  List<Album> findAlbumsBySingerId(Long singerId);

  long countAlbumsBySingerId(Long singerId);

  /** Returns the first album in the database. */
  @Query("select * from albums limit 1")
  Optional<Album> getFirst();
}
