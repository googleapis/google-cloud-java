<!DOCTYPE html>
<html lang="en-US">
<#include "macros.ftl">
<head>
  <meta charset="utf-8"/>
  <title>Google Cloud Platform Java Open Source Dependency Dashboard</title>
  <link rel="stylesheet" href="dashboard.css"/>
</head>
<body>
<h1 style="text-align:center">Google-Cloud-BOM ${staticVersion}</h1>
<hr/>
<#assign totalArtifacts = table?size>

<div class="dropdown">
  <button class="dropdown-button">Google-Cloud-Bom Version</button>
  <div class="dropdown-content">
      <#list bomVersions as version>
        <a href="../${version?contains('-SNAPSHOT')?then('snapshot', version)}/index.html">${version}</a>
      </#list>
  </div>
</div>

<#if coordinates != "all-versions">
  <section class="statistics">
    <div class="container">
      <div class="statistic-item statistic-item-green">
        <h2>${table?size}</h2>
        <span class="desc">Total Artifacts Checked</span>
      </div>

      <div class="statistic-item statistic-item-orange">
          <#assign localUpperBoundsErrorCount = dashboardMain.countFailures(table, "Upper Bounds")>
        <h2>${dashboardMain.countFailures(table, "Upper Bounds")}</h2>
        <span class="desc">${(localUpperBoundsErrorCount == 1)?then("Has", "Have")} Upper Bounds Errors</span>
      </div>

      <div class="statistic-item statistic-item-blue">
          <#assign convergenceErrorCount = dashboardMain.countFailures(table, "Dependency Convergence")>
        <h2>${dashboardMain.countFailures(table, "Dependency Convergence")}</h2>
        <span class="desc">${(convergenceErrorCount == 1)?then("Fails", "Fail")} to Converge</span>
      </div>
    </div>
  </section>
</#if>

<p>Search for artifacts and the versions of associated google-cloud-shared-dependencies each uses,
  within its correspondence of Google-Cloud-BOM.</p>
<p>Search by specifying "columnName:data". <br/>
  Multi-column search is supported. For example, column1:value1, column2:value2, column3:value3...
  <br/>
  Column name shorthand is supported. For example, gcb:0.132.0, gcsd:0.8.3 <br/>
  Search for google-cloud-accesssapproval with version 1.4.0
  by using either 'artifact:approval artifact-version:1.4.0' or 'approval 1.4.0' or 'approval,
  1.4.0') </p>
<input type="text" id="filterBar" onkeyup="filterFunction()" placeholder="Search...">
<table id="libraryVersions">
  <tr class="header">
    <th>google-cloud-bom</th>
    <th>artifact</th>
    <th>artifact-version</th>
      <#if coordinates != "all-versions">
        <th>latest-released-version</th>
        <th>latest-released-date</th>
        <th>google-cloud-shared-dependencies</th>
      <#else>
        <th>google-cloud-shared-dependencies</th>
      </#if>
  </tr>
    <#list artifacts as artifact>
        <#list versions as version>
          <tr>
              <#assign key = artifact + ":" + version>
            <td>${version}</td>
            <td>${artifact}</td>
              <#if sharedDependenciesPosition[key]??>
                <td><a target="_blank"
                       href=${sharedDependenciesPosition[key]}>${currentVersion[key]}</a></td>
              <#else>
                <td><a target="_blank">N/A</a></td>
              </#if>
              <#if coordinates != "all-versions">
                <td><a target="_blank" href=${newestPomUrl[key]}>${newestVersion[key]}</a></td>
                <td><a target="_blank" href=${metadataUrl[key]}>${updatedTime[key]}</a></td>
              </#if>
              <#if sharedDependenciesVersion[key]??>
                <td>${sharedDependenciesVersion[key]}</td>
              <#else>
                <td>N/A</td>
              </#if>
          </tr>
        </#list>
    </#list>
</table>

<hr/>

<p id='updated'>Last generated at ${lastUpdated}</p>
<script src="dashboard.js"></script>
</body>
</html>
