/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.analytics.admin.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class DisplayVideo360AdvertiserLinkProposalName implements ResourceName {
  private static final PathTemplate PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSAL =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/displayVideo360AdvertiserLinkProposals/{display_video_360_advertiser_link_proposal}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String displayVideo360AdvertiserLinkProposal;

  @Deprecated
  protected DisplayVideo360AdvertiserLinkProposalName() {
    property = null;
    displayVideo360AdvertiserLinkProposal = null;
  }

  private DisplayVideo360AdvertiserLinkProposalName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    displayVideo360AdvertiserLinkProposal =
        Preconditions.checkNotNull(builder.getDisplayVideo360AdvertiserLinkProposal());
  }

  public String getProperty() {
    return property;
  }

  public String getDisplayVideo360AdvertiserLinkProposal() {
    return displayVideo360AdvertiserLinkProposal;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DisplayVideo360AdvertiserLinkProposalName of(
      String property, String displayVideo360AdvertiserLinkProposal) {
    return newBuilder()
        .setProperty(property)
        .setDisplayVideo360AdvertiserLinkProposal(displayVideo360AdvertiserLinkProposal)
        .build();
  }

  public static String format(String property, String displayVideo360AdvertiserLinkProposal) {
    return newBuilder()
        .setProperty(property)
        .setDisplayVideo360AdvertiserLinkProposal(displayVideo360AdvertiserLinkProposal)
        .build()
        .toString();
  }

  public static DisplayVideo360AdvertiserLinkProposalName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSAL.validatedMatch(
            formattedString,
            "DisplayVideo360AdvertiserLinkProposalName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("display_video_360_advertiser_link_proposal"));
  }

  public static List<DisplayVideo360AdvertiserLinkProposalName> parseList(
      List<String> formattedStrings) {
    List<DisplayVideo360AdvertiserLinkProposalName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DisplayVideo360AdvertiserLinkProposalName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DisplayVideo360AdvertiserLinkProposalName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSAL.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (property != null) {
            fieldMapBuilder.put("property", property);
          }
          if (displayVideo360AdvertiserLinkProposal != null) {
            fieldMapBuilder.put(
                "display_video_360_advertiser_link_proposal",
                displayVideo360AdvertiserLinkProposal);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PROPERTY_DISPLAY_VIDEO360_ADVERTISER_LINK_PROPOSAL.instantiate(
        "property",
        property,
        "display_video_360_advertiser_link_proposal",
        displayVideo360AdvertiserLinkProposal);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DisplayVideo360AdvertiserLinkProposalName that =
          ((DisplayVideo360AdvertiserLinkProposalName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(
              this.displayVideo360AdvertiserLinkProposal,
              that.displayVideo360AdvertiserLinkProposal);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(displayVideo360AdvertiserLinkProposal);
    return h;
  }

  /**
   * Builder for
   * properties/{property}/displayVideo360AdvertiserLinkProposals/{display_video_360_advertiser_link_proposal}.
   */
  public static class Builder {
    private String property;
    private String displayVideo360AdvertiserLinkProposal;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getDisplayVideo360AdvertiserLinkProposal() {
      return displayVideo360AdvertiserLinkProposal;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setDisplayVideo360AdvertiserLinkProposal(
        String displayVideo360AdvertiserLinkProposal) {
      this.displayVideo360AdvertiserLinkProposal = displayVideo360AdvertiserLinkProposal;
      return this;
    }

    private Builder(
        DisplayVideo360AdvertiserLinkProposalName displayVideo360AdvertiserLinkProposalName) {
      this.property = displayVideo360AdvertiserLinkProposalName.property;
      this.displayVideo360AdvertiserLinkProposal =
          displayVideo360AdvertiserLinkProposalName.displayVideo360AdvertiserLinkProposal;
    }

    public DisplayVideo360AdvertiserLinkProposalName build() {
      return new DisplayVideo360AdvertiserLinkProposalName(this);
    }
  }
}
