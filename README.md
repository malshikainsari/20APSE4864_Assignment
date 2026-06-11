# Assignment - User Authentication App

A simple Android application developed using **Jetpack Compose**, **Room Database**, and **Navigation Compose**.

## Features

- User Registration
- User Login
- Room Database Integration
- Home Screen with Welcome Message
- Logout Functionality
- Navigation Between Screens

## Technologies Used

- Kotlin
- Jetpack Compose
- Room Database
- Navigation Compose
- Android Studio

## Project Structure

```text
data/
├── AppDatabase.kt
├── User.kt
└── UserDao.kt

navigation/
└── Navigation.kt

screens/
├── LoginScreen.kt
├── RegisterScreen.kt
└── HomeScreen.kt
```

## Application Screens

<p align="center">
  <img src="screenshots/login.png" width="250"/>
  <img src="screenshots/register.png" width="250"/>
  <img src="screenshots/home.png" width="250"/>
</p>

## Database Structure

### User Entity

| Field | Type |
|---------|---------|
| id | Int |
| username | String |
| email | String |
| password | String |

## Functional Requirements

### User Registration

- Enter Username
- Enter Email
- Enter Password
- Validate Input Fields
- Save User Data to Room Database
- Navigate to Login Screen

### User Login

- Enter Username
- Enter Password
- Verify Credentials Using Room Database
- Navigate to Home Screen

### Home Screen

- Display Welcome Message
- Display Logged-in Username
- Logout Functionality

## Code Snippets

### User Entity

```kotlin
@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val username:String,
    val email:String,
    val password:String
)
```

### UserDao

```kotlin
@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query(
        "SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1"
    )
    suspend fun login(
        username:String,
        password:String
    ): User?
}
```

### Navigation

```kotlin
NavHost(
    navController = navController,
    startDestination = "login"
)
```

