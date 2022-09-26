terraform {
  required_providers {
    google = { source = "hashicorp/google" }
  }
}
resource "google_project_service" "pubsub_api" {
  service            = "pubsub.googleapis.com"
  disable_on_destroy = false
}
resource "google_project_service" "asset_api" {
  service            = "cloudasset.googleapis.com"
  disable_on_destroy = false
}
resource "google_project_service" "cloudresourcemanager_api" {
  service            = "cloudresourcemanager.googleapis.com"
  disable_on_destroy = false
}
resource "time_sleep" "wait_90_seconds" {
  depends_on      = [google_project_service.pubsub_api]
  create_duration = "90s"
}
