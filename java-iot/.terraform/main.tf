terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "iot_api" {
  service            = "cloudiot.googleapis.com"
  disable_on_destroy = false
}
