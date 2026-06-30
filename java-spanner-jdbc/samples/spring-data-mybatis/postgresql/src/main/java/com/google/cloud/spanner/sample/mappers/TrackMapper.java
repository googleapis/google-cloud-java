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

package com.google.cloud.spanner.sample.mappers;

import com.google.cloud.spanner.sample.entities.Track;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TrackMapper {

  @Select("SELECT * FROM tracks WHERE id = #{albumId} AND track_number = #{trackNumber}")
  Track get(@Param("albumId") long albumId, @Param("trackNumber") long trackNumber);

  @Insert(
      "INSERT INTO tracks (id, track_number, title, sample_rate) "
          + "VALUES (#{id}, #{trackNumber}, #{title}, #{sampleRate})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insert(Track track);
}
