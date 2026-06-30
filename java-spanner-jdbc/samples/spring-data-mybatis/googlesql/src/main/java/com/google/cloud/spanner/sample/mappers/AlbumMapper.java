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

package com.google.cloud.spanner.sample.mappers;

import com.google.cloud.spanner.sample.entities.Album;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AlbumMapper {

  @Select("SELECT * FROM albums WHERE id = #{albumId}")
  Album get(@Param("albumId") long albumId);

  @Select("SELECT * FROM albums LIMIT 1")
  Optional<Album> getFirst();

  @Select("SELECT COUNT(1) FROM albums WHERE singer_id = #{singerId}")
  long countAlbumsBySingerId(@Param("singerId") long singerId);

  @Select("SELECT * FROM albums WHERE singer_id = #{singerId}")
  List<Album> findAlbumsBySingerId(@Param("singerId") long singerId);

  @Insert(
      "INSERT INTO albums (title, marketing_budget, release_date, cover_picture, singer_id) "
          + "VALUES (#{title}, #{marketingBudget}, #{releaseDate}, #{coverPicture}, #{singerId})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insert(Album album);
}
