# The Bookshelf Project

<div style="text-align: center;">

![The Bookshelf Project Logo](/assets/images/logo/logo.png)

</div>

## Overview

This is my first DevSecOps project, based on [Introduction To DevSecOps by TryHackMe](https://tryhackme.com/room/introductiontodevsecops)...

## Table of Contents

1. [Background](#1-Background)
2. [Architecture](#2-Architecture)
3. [Screenshots](#3-Screenshots)
4. [Testing](#4-Testing)
5. [Challenges & Solutions](#5-Challenges-and-Solutions)
6. [Credits](#6-Credits)
7. [How To Build](#7-How-To-Build)

## 1] Background

![The Bookshelf Project Background](/assets/images/background/background.png)

- The Bookshelf Project consumes [The Google Books API](https://developers.google.com/books/docs/v1/using#PerformingSearch) as presented in [this codelab](https://developer.android.com/codelabs/basic-android-kotlin-compose-bookshelf?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-2%3F_gl%3D1*1ow0vhr*_up*MQ..*_ga*MTUzODYyMTA1OC4xNzUwODM1MTg4*_ga_6HH9YJMN9M*czE3NTA4MzUxODckbzEkZzAkdDE3NTA4MzUxODckajYwJGwwJGgxODgxNTUxOTQz%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-bookshelf&_gl=1*1ecwfyx*_up*MQ..*_ga*ODIwMDY0MjY4LjE3NTEzNzg3ODY.*_ga_6HH9YJMN9M*czE3NTEzNzg3ODYkbzEkZzAkdDE3NTEzNzg3ODYkajYwJGwwJGgyMTEzNjMwMjAy)...
- It has been built as a Proof of Concept for my journey in DevSecOps, that is prioritising The Software Development Lifecycle...
- The idea was conceptualised as a means to practise the concepts learnt in the mentioned Room [TryHackme]...

## 2] Architecture

- The Bookshelf Project is a [Kotlin Multiplatform[KMP]](https://kotlinlang.org/docs/multiplatform.html) project that comprises of the following modules:

### a] :android

- This module contains the Android-specific functionalities and components, such as MainActivity...

### b] :commons

- This module contains the shared functionalities that are used across multiple Source Sets [:androidMain, :commonMain, :iosMain, and :nativeMain]...

### c] :ios

- This module contains the iOS-specific functionalities and components...

## 3] Screenshots

<div style="text-align: center;">

<table>
  <tr>
    <th>The Splash Screen</th>
    <th>The Bookshelf Screen</th>
    <th>The Bookshelf Details Screen</th>
  </tr>
  <tr>
    <td>
      <img src="assets/images/screenshots/splash_screen.png" alt="The Splash Screen" style="max-width:490px; height:490px;">
    </td>
    <td>
      <img src="assets/images/screenshots/bookshelf_screen.png" alt="The Bookshelf Screen" style="max-width:490px; height:490px;">
    </td>
    <td>
      <img src="assets/images/screenshots/bookshelf_details_screen.png" alt="The Bookshelf Details Screen" style="max-width:490px; height:490px;">
    </td>
  </tr>
</table>

</div>

## 4] Testing

- This project featured no Tests as it was a Proof of Concept...

## 5] Challenges and Solutions

- The Bookshelf Project was designed to offer a smooth experience across Architecture, Networking, and User Interaction Layers...
- However, like many modern Mobile Apps, it encountered several challenges during development:

### a] Glide URL Failure and Image Loading Issues

**Challenge:**
Glide failed to load Book Thumbnails due to malformed Image URLs (e.g. `httpss://...`) and Dimension Warnings such as `[536x-2147483648]`...

**Solution:**
The issue was traced back to a simple typo in the Image URL Scheme. The problem was fixed by ensuring the URLs used the correct `https://` scheme before passing them into the Image Loader. The library was then replaced with [Landscapist-Coil3](https://github.com/skydoves/landscapist) for Kotlin Multiplatform compatibility and better Lifecycle Handling...

---

### b] Implementing a Search Bar on Top of a Staggered Grid

**Challenge:**
Placing a `SearchBar` above a `LazyVerticalStaggeredGrid` while maintaining smooth scrolling and preserving state...

**Solution:**
A `Column` layout was introduced, placing the `SearchBar` at the top and the `LazyVerticalStaggeredGrid` beneath it. Proper Padding and Layout Constraints were applied to prevent Content Clipping and Scroll Overlap...

---

### c] Asynchronous Search with Query-Driven API and Room Sync

**Challenge:**
Search functionality needed to hit the REST API only when a user submitted a Book Query, and update the local Room DB accordingly—replacing old data...

**Solution:**
An architecture was designed where the `ViewModel` triggered the repository’s `searchBook(query)` method. This, in turn, called a Suspending Function that:
1. Deleted previous Room entries...
2. Made a fresh API call...
3. Inserted the new results into Room...
   The UI then updated through Flow collection using `collectAsStateWithLifecycle()`...

---

### d] Sequential Execution of Suspending Functions

**Challenge:**
Ensuring that Suspending Functions such as `searchBooks()` and `getBooks()` execute in a defined order, especially during a Search operation...

**Solution:**
`withContext(dispatcher)` ensured the code block's Suspend Functions were executed sequentially. The `searchBook()` call was always followed by `getBooks()` within the same coroutine in the `ViewModel`...

---

### e] ViewModel State Not Updating After Search

**Challenge:**
Initial attempts to call `searchBooks()` without subsequently updating the UI resulted in stale data being shown...

**Solution:**
The solution was to call `getBooks()` after `searchBooks()` in the `ViewModel`, ensuring the State Flow was refreshed after new data was written to Room...

---

## 6] Credits

- The Bookshelf Project has been built using the following Tools, Technologies, and Libraries:

a] [Jetpack Compose](https://developer.android.com/jetpack/compose)

- Google's modern UI toolkit [Jetpack Compose] has been used to design a declarative, reactive, and Kotlin-first User Interface [UI] for Mobile Applications...

b] [Material3](https://developer.android.com/jetpack/compose/designsystems/material3)

- The app adheres to modern Design principles by implementing [Material3], offering customisable components and smooth theming support...

c] [Voyager Navigation](https://github.com/adrielcafe/voyager)

- Voyager is a Navigation library for Kotlin Multiplatform that simplifies screen-based navigation while ensuring Lifecycle Safety and integration with Dependency Injection...

d] [Koin](https://insert-koin.io/)

- For Dependency Injection, the project uses [Koin]—a pragmatic Kotlin-native library that powers both ViewModels and Composables with Lifecycle-aware scoped Injection...

e] [KSP](https://kotlinlang.org/docs/ksp-overview.html)

- Kotlin Symbol Processing [KSP] is used in the project as a faster and lightweight alternative to Kotlin Annotation Processing Tool [KAPT] for generating code at compile time...

f] [Ktor](https://ktor.io/)

- Ktor Client is used to perform type-safe HTTP network calls including Serialisation and Content Negotiation using JSON...

g] [OkHttp3](https://square.github.io/okhttp/)

- Underlying the Ktor engine is [OkHttp3], which enhances the Networking Layer with Interceptors, Efficient Connection Pooling, and Logging Capabilities...

h] [Kotlinx Serialization](https://kotlinlang.org/docs/serialization.html)

- This plugin powers all Serialization and Deserialization operations within Ktor calls, transforming JSON responses into strongly typed Kotlin objects...

i] [Room](https://developer.android.com/jetpack/androidx/releases/room)

- For Local Data Persistence, Room has been implemented to store Book Data and manage Queries using DAO Interfaces...

j] [SQLite Bundled](https://developer.android.com/jetpack/androidx/releases/sqlite)

- The SQLite Bundled library provides the underlying Database Engine optimised for Room and enhances Cross-Platform compatibility...

k] [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)

- The project leverages Kotlin Coroutines to handle background tasks such as Network Calls, Room Queries, and Suspending Functions elegantly...

l] [Landscapist-Coil3](https://github.com/skydoves/landscapist)

- Landscapist-Coil3 has been adopted to asynchronously load and display Book Thumbnails using [Coil3](https://coil-kt.github.io/coil/upgrading_to_coil3/) under the hood...

m] [Android SplashScreen API](https://developer.android.com/develop/ui/views/launch/splash-screen)

- A modern SplashScreen API implementation is used to display a consistent launch experience that blends seamlessly into the app's theme...

n] [Google Fonts for Compose](https://developer.android.com/jetpack/compose/text/fonts)

- Google Fonts integration enables custom Typography using Jetpack Compose's Typography styles with support for scalable and legible fonts...

o] [Timber](https://github.com/JakeWharton/timber)

- Timber is utilised as a lightweight, extensible Logging library for Debugging and Diagnostic Logging across the codebase...

p] [Detekt](https://detekt.dev/)

- Detekt is configured to statically analyse Kotlin code and enforce clean code practices for Maintainability and Scalability...

q] [Ktlint](https://github.com/pinterest/ktlint)

- Ktlint enforces Kotlin code style based on official guidelines and integrates into the build process to maintain consistency...

r] [Spotless](https://github.com/diffplug/spotless)

- Spotless ensures source Code Formatting and Linting are applied before commits, further automating Code Quality...

s] [SonarQube for IDE](https://plugins.jetbrains.com/plugin/7973-sonarqube-for-ide)

- The SonarQube for IDE Plugin has been integrated to provide real-time Static Code Analysis, enabling early detection of Code Smells and Technical Debt...

t] [Snyk](https://plugins.jetbrains.com/plugin/10804-snyk-security)

- The Snyk Plugin has been added to identify and remediate Security Vulnerabilities in Third-Party dependencies during Development...

## 7] How To Build

1] To build the project, ensure you have the following requirements:

- [Android Studio](https://developer.android.com/studio)...
- Android Device or Emulator...
- The Libraries and Plugins listed above...

2] Next, clone this GitHub Repository into your local machine using Android Studio by navigating to "New > Project from Version Control"...

3] Copy and Paste the URL of this GitHub Repository and click "Clone"...

4] Let the project build using Gradle...

5] Once done, connect your Android Device to Android Studio by navigating to "Device Manager". You can also create an Emulator instead of using a physical Android Device...

6] Run the app by clicking "Run 'app'"...