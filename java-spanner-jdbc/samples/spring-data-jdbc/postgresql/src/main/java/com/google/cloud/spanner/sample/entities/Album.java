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

package com.google.cloud.spanner.sample.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("albums")
public class Album extends AbstractEntity {

  private String title;

  private BigDecimal marketingBudget;

  private LocalDate releaseDate;

  private byte[] coverPicture;

  private Long singerId;

  @PersistenceCreator
  public Album() {}

  public Album(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return getTitle();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BigDecimal getMarketingBudget() {
    return marketingBudget;
  }

  public void setMarketingBudget(BigDecimal marketingBudget) {
    this.marketingBudget = marketingBudget;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public byte[] getCoverPicture() {
    return coverPicture;
  }

  public void setCoverPicture(byte[] coverPicture) {
    this.coverPicture = coverPicture;
  }

  public Long getSingerId() {
    return singerId;
  }

  public void setSingerId(Long singerId) {
    this.singerId = singerId;
  }
}
