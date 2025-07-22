Smart City App -


Dashboard Screen.

<img width="320" height="520" alt="Screen1" src="https://github.com/user-attachments/assets/3565ca05-11c3-4924-810a-b253f7d53afc" />

      
      
City Alert Detail Screen
                               
<img width="320" height="520" alt="Screen2" src="https://github.com/user-attachments/assets/e207519e-5053-4550-9235-7fc238cb401b" />



Project Architecture & Approach (with Explanations)

1. Clean Architecture (Modularized)
Explanation:
Clean Architecture means your code is separated into distinct layers, each with a clear responsibility:
Presentation: UI and ViewModel logic only
Domain: Business logic (UseCases, Repository Interfaces, Domain Models)
Data: Data fetching/storage (API, RepositoryImpl, DTO, Mapper)
DI: Dependency Injection (Hilt/Dagger modules)
Utils: Common helpers/constants
Benefits:
Code is maintainable, testable, scalable, and loosely coupled.


2. Architecture Diagram (Textual)  -


[UI Layer: Jetpack Compose]
        |
        v
[Presentation Layer: ViewModel]
        |
        v
[Domain Layer: UseCases]
        |
        v
[Domain Layer: Repository Interface]
        |
        v
[Data Layer: RepositoryImpl]
        |
        v
[Data Layer: Retrofit API, DTO, Mapper]
        |
        v
[External APIs: Weather, AQI, Traffic, Alerts]

Explanation:
Data flows top-down (from UI to API) and responses flow bottom-up (from API to UI).
Each layer only knows about the layer directly below it, never above.


3. Approach & Flow
UI Layer (Jetpack Compose)
Modern, declarative UI toolkit
Uses StateFlow for reactive UI updates
Handles only UI rendering and user interaction
Presentation Layer (ViewModel)
No business logic, only UI state management
Observes StateFlow/LiveData for UI updates
Triggers all API calls in parallel (coroutineScope + async)
Handles Error, Loading, and Success states
Domain Layer (UseCases, Repository Interface, Models)
UseCases: One class per business operation (Single Responsibility Principle)
Repository Interface: Abstracts data access (enables testability)
Domain Models: Pure Kotlin data classes (no Android dependencies)
Data Layer (RepositoryImpl, API, DTO, Mapper)
RepositoryImpl: Implements Repository interface, handles data fetch/store logic
Retrofit API: Interfaces for external APIs
DTOs: Data classes for API response mapping
Mapper: Converts DTOs <-> Domain models
Dependency Injection (Hilt/Dagger)
Injects all dependencies (Repository, UseCase, API, etc.)
Uses Qualifiers for multiple Retrofit instances
API Keys
Defined in local.properties (never committed to VCS)
Injected into BuildConfig via build.gradle(.kts)
Accessed in code via BuildConfig

4. Best Practices Followed (with Explanation)
Clean Architecture
Each layer has a single responsibility, no tight coupling
Increases testability and maintainability
Dependency Injection (Hilt/Dagger)
No need for manual object creation
Easy to inject mock/fake dependencies in tests
Kotlin Coroutines
Asynchronous, parallel API calls (faster UI)
Structured concurrency, easier error handling
Jetpack Compose
Modern, declarative UI
State-driven rendering, less boilerplate



5. Example: API Call Flow (with Explanation)
UI triggers ViewModel function
User action (button click, screen load) triggers a ViewModel function
ViewModel calls UseCase
ViewModel contains no business logic, only calls usecases
UseCase calls Repository
UseCase contains business logic, abstracts data access
RepositoryImpl calls Retrofit API
RepositoryImpl contains actual API/network/database logic
API key fetched from BuildConfig
API key is never hardcoded, always accessed from BuildConfig
Response mapped via Mapper to Domain Model
DTOs are converted to domain models, so UI/Domain never depend on API details
Result flows back to UI via StateFlow
ViewModel updates state, UI reacts and renders accordingly

6. Diagram (Mermaid Text) -

graph TD
    UI[UI Layer (Compose)] --> VM[ViewModel]
    VM --> UC[UseCase]
    UC --> REPO[Repository Interface]
    REPO --> REPOIMPL[RepositoryImpl]
    REPOIMPL --> API[Retrofit API/DTO/Mapper]
    API --> EXT[External APIs]
    REPOIMPL --> DI[Hilt/Dagger]
    VM --> DI

Explanation:
Each arrow shows a dependency or data flow.
DI (Hilt/Dagger) injects dependencies at every layer.

7. Why This Approach?
Scalability: Easy to add new features in the future
Testability: Each layer can be tested/mocked independently
Security: API keys are never in the codebase, reducing misuse risk
Maintainability: Clean codebase, easy for any developer to understand
