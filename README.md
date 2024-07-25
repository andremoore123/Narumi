# Narumi App

An Travel App that will give you suggestion about a trip and you can order it directly from application. This application is for Assignment Submission 3 in Phincon Academy.

<img src="https://drive.google.com/uc?id=19QFeE-4CgIIzc8Eu9bigfAYeM_fezqWh" width="600" height="350" />

## Features

**Popular Trips:** Add notes to apps.\
**Checkout:** Order what you want in one click.\
**Chekcout History:** Don't worry to lose track your order.
## Tech Stack

- **Database:** Room Database for efficient local data storage.
- **Architecture:** MVVM (Model-View-ViewModel) for clear separation of concerns.
- **Dependency Injection:** Koin for managing dependencies.
- **UI:** XML for designing user interfaces.

## New Tech Used!!
- **Firebase Analytics:** A Google-provided analytics tool that tracks user behavior in your application.
- **Firebase Authentication:** A serverless authentication solution from Google that simplifies the process of adding user authentication to your application.
- **Firebase Crashlytics:** A tool from Google that reports crash issues from users, helping you identify and fix stability problems in your application.



**Following Packages**

- **Base**: Contains abstract classes for base implementations.
- **Data**: Contains all classes responsible for handling data operations.
- **DI**: Contains classes for providing and injecting dependencies using **Koin**.
- **Domain**: Contains contracts to bridge the Data layer to the UI layer.
- **UI**: Contains classes for user interface components.
- **Utils**: Contains utility classes.

**MVVM Structure**

<img src="https://drive.google.com/uc?id=13qj5Od12kNH7pF_LT8bKDk2JLTfNp3h2" width="600" height="350" />



## Testing

### LoginViewModelTest

- **Setup:** Initializes LoginViewModel with mocked IAuthRepository and IAnalyticRepository.
- **Test 1: Login with valid credentials updates message with success data**
  - **Description:** Verifies that logging in with valid credentials updates the message with success data.
  - **Assertion:** Checks that the message is "Login successful".
- **Test 2: Login with empty email and password**
  - **Description:** Verifies that logging in with empty email and password handles errors gracefully.
  - **Assertion:** Checks that the message is "Email and password cannot be empty".

### RegisterViewModelTest

- **Setup:** Initializes RegisterViewModel with mocked IAuthRepository and IAnalyticRepository.
- **Test 1: Register with valid credentials posts success message**
  - **Description:** Verifies that registering with valid credentials posts a success message.
  - **Assertion:** Checks that the message is "Registration successful".
- **Test 2: Register with empty fields handles gracefully**
  - **Description:** Verifies that registering with empty fields handles errors gracefully.
  - **Assertion:** Checks that the message is "Fields cannot be empty".

### CheckoutViewModelTest

- **Setup:** Initializes CheckoutViewModel with mocked ITripRepository and ITransactionRepository.
- **Test 1: Fetch trip by ID updates LiveData**
  - **Description:** Verifies that fetching a trip by ID updates LiveData correctly.
  - **Assertion:** Checks that the trip data matches the expected TripModel.
- **Test 2: Fetch trip by ID when trip does not exist**
  - **Description:** Verifies that fetching a trip by a nonexistent ID handles null gracefully.
  - **Assertion:** Checks that the trip data is null.

### DetailTripViewModelTest

- **Setup:** Initializes DetailTripViewModel with mocked ITripRepository.
- **Test 1: Fetch trip by ID successfully retrieves a trip and updates tripData**
  - **Description:** Verifies that fetching a trip by ID updates tripData correctly.
  - **Assertion:** Checks that the trip data matches the expected TripModel.
- **Test 2: Fetch trip by ID with an invalid or non-existent ID**
  - **Description:** Verifies that fetching a trip by an invalid or nonexistent ID handles null gracefully.
  - **Assertion:** Checks that the trip data is null.

### ProfileViewModelTest

- **Setup:** Initializes ProfileViewModel with mocked IAuthRepository.
- **Test 1: Fetching profile data updates userData LiveData with current user information**
  - **Description:** Verifies that fetching profile data updates userData correctly.
  - **Assertion:** Checks that the user data matches the expected UserModel.
- **Test 2: Fetch profile data handles null or invalid user data gracefully**
  - **Description:** Verifies that fetching profile data with null or invalid user data handles null gracefully.
  - **Assertion:** Checks that the user data is null.

### HomeViewModelTest

- **Setup:** Initializes HomeViewModel with mocked ITripRepository and IAuthRepository.
- **Test 1: Fetching all data populates popular, recommended, all trips, and user data lists**
  - **Description:** Verifies that fetching all data populates popular, recommended, all trips, and user data lists correctly.
  - **Assertion:** Checks that the lists and user data match the expected values.
- **Test 2: Fetching data when repositories return empty lists**
  - **Description:** Verifies that fetching data when repositories return empty lists handles empty lists gracefully.
  - **Assertion:** Checks that the lists are empty and the user data matches the expected UserModel.

## Installation

**Install the V 1.0.0 Release**\
[Download Here](https://github.com/andremoore123/Narumi/releases/tag/debug)
    
## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/andre-eka-putra-simanjuntak/)

