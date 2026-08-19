// Copyright 2024 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package main

import (
	"os"
	"path/filepath"
	"strings"
	"testing"
)

const samplePom = `<?xml version="1.0" encoding="UTF-8"?>
<!-- Copyright 2024 Google LLC -->
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-sample</artifactId>
  <version>1.0.0-SNAPSHOT</version>

  <properties>
    <google-cloud-shared-dependencies.version>3.1.0</google-cloud-shared-dependencies.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-shared-config</artifactId>
      <version>0.10.0</version>
    </dependency>
    <dependency>
      <groupId>com.google.guava</groupId>
      <artifactId>guava</artifactId>
    </dependency>
  </dependencies>
</project>
`

func TestGetProjectVersion(t *testing.T) {
	tempDir := t.TempDir()
	pomPath := filepath.Join(tempDir, "pom.xml")
	if err := os.WriteFile(pomPath, []byte(samplePom), 0644); err != nil {
		t.Fatal(err)
	}

	ver, err := GetProjectVersion(pomPath)
	if err != nil {
		t.Fatalf("GetProjectVersion failed: %v", err)
	}
	if ver != "1.0.0-SNAPSHOT" {
		t.Errorf("GetProjectVersion got %q, want %q", ver, "1.0.0-SNAPSHOT")
	}
}

func TestSetProjectVersion(t *testing.T) {
	tempDir := t.TempDir()
	pomPath := filepath.Join(tempDir, "pom.xml")
	if err := os.WriteFile(pomPath, []byte(samplePom), 0644); err != nil {
		t.Fatal(err)
	}

	if err := SetProjectVersion(pomPath, "2.0.0"); err != nil {
		t.Fatalf("SetProjectVersion failed: %v", err)
	}

	ver, err := GetProjectVersion(pomPath)
	if err != nil {
		t.Fatalf("GetProjectVersion failed: %v", err)
	}
	if ver != "2.0.0" {
		t.Errorf("SetProjectVersion got %q, want %q", ver, "2.0.0")
	}

	// Verify comment is preserved
	content, _ := os.ReadFile(pomPath)
	if !strings.Contains(string(content), "<!-- Copyright 2024 Google LLC -->") {
		t.Errorf("Expected XML comment to be preserved, content was:\n%s", string(content))
	}
}

func TestSetDependencyVersion(t *testing.T) {
	tempDir := t.TempDir()
	pomPath := filepath.Join(tempDir, "pom.xml")
	if err := os.WriteFile(pomPath, []byte(samplePom), 0644); err != nil {
		t.Fatal(err)
	}

	if err := SetDependencyVersion(pomPath, "google-cloud-shared-config", "0.20.0"); err != nil {
		t.Fatalf("SetDependencyVersion failed: %v", err)
	}

	content, _ := os.ReadFile(pomPath)
	if !strings.Contains(string(content), "<version>0.20.0</version>") {
		t.Errorf("Expected updated version 0.20.0 in pom.xml, content:\n%s", string(content))
	}
}

func TestSetPropertyVersion(t *testing.T) {
	tempDir := t.TempDir()
	pomPath := filepath.Join(tempDir, "pom.xml")
	if err := os.WriteFile(pomPath, []byte(samplePom), 0644); err != nil {
		t.Fatal(err)
	}

	if err := SetPropertyVersion(pomPath, "google-cloud-shared-dependencies.version", "4.0.0"); err != nil {
		t.Fatalf("SetPropertyVersion failed: %v", err)
	}

	content, _ := os.ReadFile(pomPath)
	if !strings.Contains(string(content), "<google-cloud-shared-dependencies.version>4.0.0</google-cloud-shared-dependencies.version>") {
		t.Errorf("Expected updated property in pom.xml, content:\n%s", string(content))
	}
}

func TestHasVersionedDependency(t *testing.T) {
	tempDir := t.TempDir()
	pomPath := filepath.Join(tempDir, "pom.xml")
	if err := os.WriteFile(pomPath, []byte(samplePom), 0644); err != nil {
		t.Fatal(err)
	}

	if !HasVersionedDependency(pomPath, "google-cloud-shared-config") {
		t.Errorf("Expected HasVersionedDependency to return true for google-cloud-shared-config")
	}

	if HasVersionedDependency(pomPath, "guava") {
		t.Errorf("Expected HasVersionedDependency to return false for unversioned guava")
	}

	if HasVersionedDependency(pomPath, "non-existent") {
		t.Errorf("Expected HasVersionedDependency to return false for non-existent dependency")
	}
}
