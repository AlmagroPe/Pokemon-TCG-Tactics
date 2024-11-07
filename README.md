# Pokémon TCG Tactics

## Application Description

Pokémon TCG Tactics is an Android application that allows users to explore cards from the Pokémon Trading Card Game (Pokémon TCG). The app displays a list of cards with details such as name, type, hit points (HP), and other characteristics, and lets users view more information on a detailed screen. The card information is retrieved from the public [Pokémon TCG API](https://pokemontcg.io/).

### API Used

We use the [Pokémon TCG API](https://pokemontcg.io/), which provides data about all Pokémon trading cards, including details like name, type, abilities, and other attributes.

### Screen Structure

1. **Card List Screen**: A grid view that displays cards retrieved from the API, showing the image and basic details.
2. **Card Detail Screen**: Displays detailed information about a specific card selected from the list, such as abilities, HP, energy type, and attacks.

## Architecture

### Layered Architecture Based on Clean Architecture

Instead of using a feature-based modular architecture, we have chosen a layered architecture based on Clean Architecture. This architecture organizes code into modules that separate responsibilities, which makes the project easier to maintain and scale. This approach is particularly useful for small to medium-sized projects like this, where a feature-based organization could lead to redundant or loosely cohesive modules due to the limited number of features.

#### Layers in Clean Architecture

1. **Presentation Layer**: Manages the UI. It uses Jetpack Compose to define views and ViewModels to handle presentation logic.
2. **Domain Layer**: Contains use cases that represent the application's business logic. This layer is independent of frameworks, making it easy to test.
3. **Data Layer**: Contains repository implementations and communicates with the API to fetch card information.

This design decouples business logic from the UI, making it easier to unit test, maintain, and potentially change the data source.

## Technology Stack

- **Kotlin**: Main programming language used across all layers of the application.
- **Jetpack Compose**: Declarative UI toolkit for Android, used to create modern, reactive user interfaces.
- [**Hilt**](https://dagger.dev/hilt/): Dependency injection framework based on Dagger, which simplifies dependency management across layers.
- **Coroutines**: Kotlin library that simplifies asynchronous operations, enabling easy handling of network calls without blocking the main thread.
- [**Coil**](https://coil-kt.github.io/coil/): Lightweight image-loading library used to load card images from API URLs.
- [**MockK**](https://mockk.io/): Mocking framework for Kotlin used in unit tests to verify repository and ViewModel behavior.
- **Kotlinx Serialization**: Library for JSON serialization, used to convert API data to Kotlin objects.

## Project Structure

```plaintext
PokemonTCGTactics/
├── app/                   # Application configuration and entry point
├── data/                  # Data layer and API
│   ├── di/                # Dependency injection modules
│   ├── model/             # Data models and mappers
│   ├── sources/           # Sources data implementations
│   └── repository/        # Repository implementations
├── domain/                # Domain layer
│   ├── model/             # Domain models
│   ├── repository/        # Repository interfaces
│   └── useCase/           # Use cases
└── presentation/          # Presentation layer (UI)
    ├── ui/                # Screens and UI components
    ├── viewModel/         # Screen ViewModels
    └── state/             # UI states
```

## Future Improvements
- Use TOML for Dependencies: Migrate dependencies to a libs.versions.toml file for clearer dependency management.
- Local Database: Implement a local database (Room) to store card data and reduce network dependency, especially on the detail screen.
- Offline State Handling: Add offline support so users can access previously viewed cards even without a network connection.
- Integration Testing: Implement integration tests to verify the complete flow from API to UI.
- UI Enhancements: Improve the UI, which currently uses a basic design. Future improvements will involve using more attributes and styles to make the app visually appealing and enhance user experience.