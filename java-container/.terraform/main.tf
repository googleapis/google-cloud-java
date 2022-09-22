terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

provider "google" {
  project = var.project_id
  region  = var.region
  zone    = var.zone
}

resource "google_project_service" "container_api" {
  service            = "container.googleapis.com"
  disable_on_destroy = false
}
resource "google_project_service" "compute_api" {
  service            = "compute.googleapis.com"
  disable_on_destroy = false
}
resource "google_compute_network" "java_container_network" {
  name                    = "java-container-network"
  auto_create_subnetworks = true
  depends_on              = [
    google_project_service.compute_api,
    google_project_service.container_api
  ]
}
