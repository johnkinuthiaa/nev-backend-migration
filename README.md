# Migrating my realEstate project from node to springboot
***
# 

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [API Endpoints](#api-endpoints)
- [Request and Response Formats](#request-and-response-formats)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The project was initially developed using Node.js and has been migrated to Spring Boot with Java. This API serves as the backend for a real estate marketplace, facilitating interactions between property owners and potential buyers or renters.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Maven
- JPA/Hibernate (for database interactions)
- Lombok (for reducing boilerplate code)

## API Endpoints

### Get All Listings
- **Endpoint:** `GET /api/v1/listings/all`
- **Description:** Retrieves all property listings.
- **Response:** Returns a list of all listings.

### Get Listing by Location
- **Endpoint:** `GET /api/v1/listings/get/location`
- **Parameters:** `location` (String)
- **Description:** Retrieves listings filtered by location.

### Get Listing by ID
- **Endpoint:** `GET /api/v1/listings/get/id`
- **Parameters:** `id` (Long)
- **Description:** Retrieves a specific listing by its ID.

### Get Listings by Parking Availability
- **Endpoint:** `GET /api/v1/listings/get/parking`
- **Parameters:** `hasParking` (Boolean)
- **Description:** Retrieves listings based on parking availability.

### Get Listings by Number of Bedrooms
- **Endpoint:** `GET /api/v1/listings/get/bedrooms`
- **Parameters:** `bedrooms` (Long)
- **Description:** Retrieves listings filtered by the number of bedrooms.

### Get Listings by Number of Bathrooms
- **Endpoint:** `GET /api/v1/listings/get/bathrooms`
- **Parameters:** `bathrooms` (Long)
- **Description:** Retrieves listings filtered by the number of bathrooms.

### Get Listings by Type
- **Endpoint:** `GET /api/v1/listings/get/type`
- **Parameters:** `type` (String)
- **Description:** Retrieves listings filtered by property type.

### Get Listings by Furnished Status
- **Endpoint:** `GET /api/v1/listings/get/furnished`
- **Parameters:** `isFurnished` (Boolean)
- **Description:** Retrieves listings based on whether they are furnished.

### Get Listings by Price
- **Endpoint:** `GET /api/v1/listings/get/price`
- **Parameters:** `price` (Double)
- **Description:** Retrieves listings filtered by price.

### Update Listing
- **Endpoint:** `PUT /api/v1/listings/update/listing`
- **Parameters:** `id` (Long), `listingInfo` (ReqRes)
- **Description:** Updates an existing listing based on the provided ID and information.

### Create New Listing
- **Endpoint:** `POST /api/v1/listings/create/new-listing`
- **Parameters:** `listingInfo` (ReqRes)
- **Description:** Creates a new property listing.

### Delete Listing by ID
- **Endpoint:** `DELETE /api/v1/listings/delete/id`
- **Parameters:** `id` (Long)
- **Description:** Deletes a specific listing by its ID.

### Delete All Listings
- **Endpoint:** `DELETE /api/v1/listings/delete/all`
- **Parameters:** `id` (Long)
- **Description:** Deletes all listings (this endpoint seems to be misnamed; consider adjusting its functionality).

## Request and Response Formats

### Request Body
The request body for creating or updating a listing should be in the format defined by the `ReqRes` DTO. Ensure you provide all necessary fields as required by your application logic.

### Response
All responses will be wrapped in a `ReqRes` object, which contains the data and any relevant metadata about the operation performed.

