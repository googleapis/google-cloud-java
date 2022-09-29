terraform {
  required_providers {
    google = { source = "hashicorp/google" }
  }
}
resource "google_project_service" "oslogin_api" {
  service            = "oslogin.googleapis.com"
  disable_on_destroy = false
}
