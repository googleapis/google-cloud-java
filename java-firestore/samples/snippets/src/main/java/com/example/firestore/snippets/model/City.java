/*
 * Copyright 2017 Google Inc.
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

package com.example.firestore.snippets.model;

import java.util.List;
import java.util.Objects;

/** Represents a city : name, weather, population, country, capital, geo coordinates. */
public class City {

  private String name;
  private String state;
  private String country;
  private Boolean capital;
  private Long population;
  private List<String> regions;

  // [START firestore_data_custom_type_definition]
  public City() {
    // Must have a public no-argument constructor
  }

  // Initialize all fields of a city
  public City(
      String name,
      String state,
      String country,
      Boolean capital,
      Long population,
      List<String> regions) {
    this.name = name;
    this.state = state;
    this.country = country;
    this.capital = capital;
    this.population = population;
    this.regions = regions;
  }

  // [END firestore_data_custom_type_definition]

  public City(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Boolean getCapital() {
    return capital;
  }

  public void setCapital(Boolean capital) {
    this.capital = capital;
  }

  public Long getPopulation() {
    return population;
  }

  public void setPopulation(Long population) {
    this.population = population;
  }

  public List<String> getRegions() {
    return regions;
  }

  public void setRegions(List<String> regions) {
    this.regions = regions;
  }

  private String getDefinedValue(String s) {
    if (s != null) {
      return s;
    } else {
      return "";
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (name != null) {
      sb.append(name);
    }
    if (state != null) {
      sb.append(" state : ");
      sb.append(state);
      sb.append(",");
    }
    if (country != null) {
      sb.append(", ");
      sb.append(country);
    }
    sb.append(" : [");
    if (population != null) {
      sb.append(" population : ");
      sb.append(population);
      sb.append(",");
    }
    if (capital != null) {
      sb.append(" capital : ");
      sb.append(capital);
      sb.append(",");
    }
    if (regions != null) {
      sb.append(" regions : [");
      for (String r : regions) {
        sb.append(r);
        sb.append(", ");
      }
      sb.append("],");
    }
    // remove trailing comma
    if (sb.lastIndexOf(",") >= sb.length() - 1) {
      sb.deleteCharAt(sb.length() - 1);
    }
    sb.append(" ]");
    return sb.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof City)) {
      return false;
    }
    City city = (City) obj;
    return Objects.equals(name, city.name)
        && Objects.equals(state, city.state)
        && Objects.equals(country, city.country)
        && Objects.equals(population, city.population)
        && Objects.equals(capital, city.capital)
        && Objects.equals(regions, city.regions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, state, country, capital, population, regions);
  }
}
