terraform {
  required_providers {
    google = { source = "hashicorp/google" }
  }
}
resource "google_project_service" "accessapproval_api" {
  service            = "accessapproval.googleapis.com"
  disable_on_destroy = false
}
