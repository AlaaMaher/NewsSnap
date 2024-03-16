# NewsSnap App

## NewsSnap is a modern Android application built with Jetpack Compose.
Displays a list of news articles fetched from the [News API](https://newsapi.org/docs/endpoints/top-headlines) using Retrofit.

It features Biometric Authentication for secure login, Paging 3 for efficient data loading, 
Coil for image loading, Retrofit for network requests, Dagger Hilt for dependency injection, 
and Compose Navigation for seamless navigation within the app.
The app supports both light and dark modes to enhance the user experience in different lighting conditions.

## Architecture

The app follows the Clean Architecture pattern, separating the app into three layers: Presentation, Domain, and Data.
Presentation Layer (MVVM): Contains the UI components and ViewModels using Jetpack Compose.
Domain Layer: Contains the business logic and use cases.
Data Layer: Manages data operations, such as fetching data from a remote server or local database.

## Preview

<p align="start">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/81f103e6-57fc-459d-be56-b1dfb994ea2a" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/31ac90f3-7db3-456e-8be1-a8e27e63d440" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/cf88c098-c629-42e3-99a3-b4b36b6f5651" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/bfaef88a-94a3-4f7f-a871-244a0694035f" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/269af790-6559-42b6-b5a2-a6090bd16aca" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/7301f98a-e6e5-442a-a010-3ea8eb65220e" width="350" alt="2">
  </p>

<p align="start">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/2e111513-d0db-4cbe-88ad-2cc1045f7b7f" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/a0f24670-e2a5-4588-aa5d-0727d6b514d2" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/3eb28b02-7eec-46db-90f9-5c6cffcc83cd" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/5110dbd9-4c9b-440e-afb1-353c14c22544" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/26d5d899-eb67-435c-98f6-e45d04f5c157" width="350" alt="2">
  <img src="https://github.com/AlaaMaher/NewsSnap/assets/16047640/7301f98a-e6e5-442a-a010-3ea8eb65220e" width="350" alt="2">
  </p>

## Installation

Clone the repository and open the project in Android Studio. Build and run the app on an Android device or emulator.
Go to [News API](https://newsapi.org/docs/endpoints/top-headlines) and generate an API key
Put the API key at the bottom of the gradle.properties newsAPIKey = "YOUR_API_KEY"
Run the app
