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

import com.google.cloud.spanner.sample.entities.Singer;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SingerMapper {

  @Select("SELECT * FROM singers WHERE id = #{singerId}")
  Singer get(@Param("singerId") long singerId);

  @Select("SELECT * FROM singers TABLESAMPLE RESERVOIR (1 ROWS)")
  Singer getRandom();

  @Select("SELECT * FROM singers ORDER BY last_name, first_name, id")
  List<Singer> findAll();

  @Select("SELECT * FROM singers WHERE starts_with(last_name, #{lastName})")
  List<Singer> findSingersByLastNameStartingWith(@Param("lastName") String lastName);

  /**
   * Inserts a new singer record and returns both the generated primary key value and the generated
   * full name.
   */
  @Insert(
      "INSERT INTO singers (first_name, last_name, active) "
          + "VALUES (#{firstName}, #{lastName}, #{active})")
  @Options(useGeneratedKeys = true, keyProperty = "id,fullName")
  int insert(Singer singer);

  /**
   * Executes an insert-or-update statement for a Singer record. Note that the id must have been set
   * manually on the Singer entity before calling this method. The statement only returns the
   * 'fullName' property, because the 'id' is already known.
   */
  @Insert(
      "INSERT OR UPDATE singers (id, first_name, last_name, active) "
          + "VALUES (#{id}, #{firstName}, #{lastName}, #{active})")
  @Options(useGeneratedKeys = true, keyProperty = "fullName")
  int insertOrUpdate(Singer singer);

  /** Updates an existing singer and returns the generated full name. */
  @Update(
      "UPDATE singers SET "
          + "first_name=#{first_name}, "
          + "last_name=#{last_name}, "
          + "active=#{active} "
          + "WHERE id=#{id}")
  @Options(useGeneratedKeys = true, keyProperty = "fullName")
  int update(Singer singer);
}
