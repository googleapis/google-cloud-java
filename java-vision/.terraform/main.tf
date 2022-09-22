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

resource "google_project_service" "vision_api" {
  service            = "vision.googleapis.com"
  disable_on_destroy = false
}
