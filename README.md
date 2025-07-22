# Smart City App -

# Dashboard Screen.
<img width="200" height="400" alt="Screen1" src="https://github.com/user-attachments/assets/3565ca05-11c3-4924-810a-b253f7d53afc" />
      
# City Alert Detail Screen                               
<img width="200" height="400" alt="Screen2" src="https://github.com/user-attachments/assets/e207519e-5053-4550-9235-7fc238cb401b" />


# Sachin Android Smart City App

A modern Android Smart City Application developed using Clean Architecture, Jetpack Compose, and Material Design 3. This app provides citizens with real-time information about various city services including weather, air quality, traffic, and urban alerts.

## Features

### Weather Information
- **Current Weather**: Real-time temperature, humidity, wind speed
- **Daily Forecast**: 7-day weather forecast
- **Hourly Forecast**: Hour-by-hour weather predictions
- **Weather Alerts**: Weather-related warnings and notifications

### Air Quality Index
- **Real-time AQI**: Live air quality index monitoring
- **AQI Categories**: Good, Moderate, Poor, Very Poor classifications
- **Health Recommendations**: Health-related suggestions based on air quality

### Traffic Information
- **Traffic Flow**: Real-time traffic flow status
- **Traffic Alerts**: Traffic-related notifications
- **Route Optimization**: Route optimization suggestions

### City Alerts
- **Emergency Alerts**: Emergency notifications and warnings
- **Public Notices**: Public announcements and updates
- **Event Updates**: City event information and updates

## Architecture

### Clean Architecture Implementation
This project follows **Clean Architecture** principles with the following layers:

```
┌─────────────────────────────────────┐
│           Presentation Layer        │
│     (UI + ViewModels + Navigation)  │
├─────────────────────────────────────┤
│            Domain Layer             │
│    (UseCases + Repository Interfaces│
│         + Domain Models)            │
├─────────────────────────────────────┤
│             Data Layer              │
│  (RepositoryImpl + API + DTO +      │
│           Mappers)                  │
├─────────────────────────────────────┤
│         Dependency Injection        │
│        (Hilt Modules)               │
└─────────────────────────────────────┘
```

### Module Structure

```
📁 app/                    # Main Application Module
📁 presentation/           # UI Layer (Jetpack Compose)
📁 domain/                # Business Logic Layer
📁 data/                  # Data Access Layer
📁 di/                    # Dependency Injection
📁 utils/                 # Common Utilities
```

## Technology Stack

### Core Technologies
- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern UI toolkit
- **Material Design 3**: Design system
- **Clean Architecture**: Architectural pattern

### Android Jetpack Components
- **ViewModel**: UI state management
- **StateFlow**: Reactive data streams
- **Navigation Compose**: Screen navigation
- **Hilt**: Dependency injection
- **Coroutines**: Asynchronous programming

### Networking & Data
- **Retrofit**: HTTP API client
- **Gson**: JSON serialization
- **OkHttp**: HTTP client
- **Coil**: Image loading

### Testing
- **JUnit**: Unit testing
- **MockK**: Mocking library
- **Turbine**: StateFlow testing
- **Espresso**: UI testing

## Getting Started

### Prerequisites
- Android Studio Hedgehog | 2023.1.1 or higher
- JDK 11 or higher
- Android SDK API Level 24+ (Android 7.0+)
- Kotlin 2.1.10+

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/SachinAndroidSmartCityApp.git
   cd SachinAndroidSmartCityApp
   ```

2. **Setup API Keys**
   ```bash
   # Add the following API keys to local.properties file:
   WEATHER_API_KEY=your_weather_api_key_here
   AIR_QUALITY_API_KEY=your_air_quality_api_key_here
   TRAFFIC_API_KEY=your_traffic_api_key_here
   ```

3. **Sync Dependencies**
   ```bash
   ./gradlew build
   ```

4. **Run the App**
   ```bash
   ./gradlew installDebug
   ```

## 📁 Project Structure

### Presentation Layer (`presentation/`)
```
📁 presentation/
├── 📁 main/                    # MainActivity
├── 📁 dashboard/              # Dashboard Screen
│   ├── 📁 screen/             # UI Components
│   │   ├── 📁 apptitlebar/    # App Title Bar
│   │   ├── 📁 cityalerts/     # City Alerts UI
│   │   ├── 📁 quickstats/     # Quick Stats Layout
│   │   └── 📁 miscellaneousservice/ # Other Services
├── 📁 commonui/               # Reusable UI Components
├── 📁 theme/                  # App Theme & Colors
└── 📁 base/                   # Base Classes & Navigation
```

### Domain Layer (`domain/`)
```
📁 domain/
├── 📁 model/                  # Domain Models
│   └── 📁 wheather/          # Weather-related Models
├── 📁 repository/             # Repository Interfaces
│   └── 📁 wheather/          # Weather Repository
├── 📁 usecase/               # Business Logic UseCases
│   └── 📁 wheather/          # Weather UseCases
└── 📁 di/                    # Domain DI Modules
```

### Data Layer (`data/`)
```
📁 data/
├── 📁 remote/                # API & Network
│   ├── 📁 api/              # Retrofit API Interfaces
│   └── 📁 wheatherdto/      # Data Transfer Objects
├── 📁 repository/           # Repository Implementations
├── 📁 mapper/              # DTO to Domain Mappers
│   └── 📁 wheather/        # Weather Mappers
└── 📁 di/                  # Data DI Modules
```

### Dependency Injection (`di/`)
```
📁 di/
├── AppModule.kt             # Application-level Dependencies
├── NetworkModule.kt         # Network-related Dependencies
└── RepositoryModule.kt      # Repository Dependencies
```

## Configuration

### API Configuration
The project uses multiple API endpoints:

- **Weather API**: OpenWeatherMap or similar service
- **Air Quality API**: AirVisual or similar service
- **Traffic API**: Google Maps or similar service
- **Alerts API**: Government or municipal API

### Build Configuration
```kotlin
// app/build.gradle.kts
android {
    compileSdk = 36
    minSdk = 24
    targetSdk = 36
    
    buildFeatures {
        buildConfig = true
        compose = true
    }
}
```

## Testing

### Unit Tests
```bash
# Run all unit tests
./gradlew test
```

### Instrumented Tests
```bash
# Run all instrumented tests
./gradlew connectedAndroidTest
```

### Test Coverage
```bash
# Generate test coverage report
./gradlew jacocoTestReport
```

## Screenshots

### Dashboard Screen
- Current weather conditions
- Air quality index
- Traffic status
- City alerts

### Weather Details
- Detailed weather information
- Forecast graphs
- Weather warnings

### City Services
- Various city services
- Emergency contacts
- Public notifications

## Security

### API Key Management
- API keys are securely stored in `local.properties`
- Accessed at runtime through `BuildConfig`
- Excluded from version control

### Data Privacy
- No user data stored locally
- All API calls use secure HTTPS
- Minimal permissions usage

## Performance

### Optimization Techniques
- **Parallel API Calls**: Multiple API calls executed in parallel
- **StateFlow**: Efficient UI updates
- **Image Caching**: Image caching with Coil
- **Code Obfuscation**: ProGuard/R8 usage

### Memory Management
- **ViewModel Lifecycle**: Data preservation during screen rotation
- **Coroutine Scopes**: Structured concurrency
- **Resource Cleanup**: Automatic resource deallocation

## Contributing

### Development Guidelines
1. Follow **Clean Architecture** principles
2. Adhere to **Kotlin Coding Conventions**
3. Write **Unit Tests** for new features
4. Follow **Code Review** process

### Code Style
```kotlin
// Function naming
fun getWeatherData(): Flow<WeatherData>

// Variable naming
val currentTemperature: Double

// Class naming
class WeatherRepositoryImpl
```
