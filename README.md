# ShaadiDemoApp

A modern dating app that helps you discover and connect with potential matches through an intuitive swipe-based interface.

## 📱 What This App Does

ShaadiDemoApp is a dating application that simulates the experience of popular dating apps like Tinder or Bumble. Here's what you can do:

### 🎯 Core Features

**Browse Profiles**: Swipe through profiles of potential matches with photos and detailed information
- View profile pictures, names, ages, and locations
- See additional details like contact information and personal details
- Browse through a curated list of profiles

**Accept or Decline Matches**: The main feature of the app!
- **Accept**: Tap the accept button when you're interested in a profile
- **Decline**: Tap the decline button when you're not interested
- Your choices are saved locally, so you can track your decisions

**Profile Details**: Get comprehensive information about each person
- Personal details (name, age, location)
- Contact information (email, phone)
- Profile pictures in different sizes
- Location details (city, country, coordinates)

**Offline Support**: Continue browsing even without internet
- Profiles are cached on your device
- View previously loaded profiles offline
- Smooth experience regardless of connectivity

## 🎨 User Experience

### Modern Design
- Clean, intuitive interface following Material Design principles
- Smooth animations and transitions
- Responsive design that works on different screen sizes
- Edge-to-edge display for a modern look

### Easy Navigation
- Simple card-based interface
- Clear accept/decline buttons
- Profile information displayed in an organized manner
- Smooth scrolling through profiles

## 🔄 How It Works

1. **Launch the App**: Open ShaadiDemoApp on your device
2. **Browse Profiles**: Swipe through user profiles displayed as cards
3. **Make Decisions**: 
   - Tap "Accept" if you're interested in the person
   - Tap "Decline" if you're not interested
4. **Continue Browsing**: Keep swiping through more profiles

## 🌐 Data Source

The app uses the RandomUser.me API to fetch realistic user profiles for demonstration purposes. This means:
- All profiles are generated for demo purposes
- No real personal data is used
- Perfect for testing and learning the app's features

## 🛠️ Technical Overview (For Developers)

### Built With Modern Android Technologies
- **Kotlin**: Modern programming language for Android
- **Jetpack Compose**: Latest UI toolkit for smooth interfaces
- **Material Design 3**: Beautiful, accessible design system
- **Room Database**: Local storage for offline access
- **Retrofit**: Fast and reliable network communication

### Key Libraries
- **Glide**: Fast image loading and caching
- **Dagger Hilt**: Efficient dependency management
- **Coroutines**: Smooth, responsive user experience
- **LiveData**: Real-time UI updates

### Architecture
The app follows clean architecture principles for:
- Easy maintenance and updates
- Reliable performance
- Scalable codebase
- Separation of concerns

## 🚀 Getting Started

### For Users
1. Download and install the app
2. Grant internet permission when prompted
3. Start browsing profiles immediately
4. Use accept/decline buttons to interact with profiles

### For Developers
1. Clone the repository
2. Open in Android Studio
3. Sync project and build
4. Run on device or emulator

## 📱 System Requirements

- Android 7.0 (API level 24) or higher
- Internet connection for initial profile loading
- 50MB of free storage space

## 🎯 Use Cases

### Perfect For:
- **Demo Purposes**: Showcase modern Android development
- **Learning**: Understand dating app UI/UX patterns
- **Testing**: Evaluate swipe-based interfaces
- **Prototyping**: Base for building real dating applications

### Features Demonstrated:
- Profile browsing with rich data
- Interactive accept/decline functionality
- Offline data persistence
- Modern Android UI/UX patterns
- Clean architecture implementation

## 🔒 Privacy & Security

- No real user data is collected or stored
- All profiles are generated for demonstration
- Internet permission only used for API calls
- Local data storage for app functionality

## 🏃‍♂️ How to Run

### Prerequisites
- **Android Studio**: Latest version (Hedgehog or newer)
- **Java Development Kit (JDK)**: Version 11 or higher
- **Android SDK**: API level 24 or higher
- **Gradle**: Version 8.0 or higher
- **Device/Emulator**: Android device or emulator running Android 7.0+

### Step-by-Step Instructions

#### 1. **Clone the Repository**
```bash
git clone https://github.com/yourusername/ShaadiDemoApp.git
cd ShaadiDemoApp
```

#### 2. **Open in Android Studio**
- Launch Android Studio
- Select "Open an existing Android Studio project"
- Navigate to the cloned ShaadiDemoApp folder
- Click "OK"

#### 3. **Sync Project**
- Wait for Android Studio to sync the project
- If prompted, update Gradle version or SDK tools
- Ensure all dependencies are downloaded

#### 4. **Configure Device/Emulator**
- **Physical Device**: Enable Developer Options and USB Debugging
- **Emulator**: Create a new AVD with API level 24 or higher
- Connect your device or start the emulator

#### 5. **Build and Run**
- Click the green "Run" button (▶️) in Android Studio
- Select your target device/emulator
- Wait for the app to build and install
- The app will launch automatically

### Troubleshooting

#### Common Issues:

**Build Errors:**
- Clean and rebuild project: `Build → Clean Project` then `Build → Rebuild Project`
- Invalidate caches: `File → Invalidate Caches and Restart`
- Sync project with Gradle files: `File → Sync Project with Gradle Files`

**Device Not Detected:**
- Enable USB Debugging in Developer Options
- Install proper USB drivers for your device
- Try different USB cables or ports

**Emulator Issues:**
- Increase RAM allocation in AVD settings
- Enable hardware acceleration (HAXM)
- Use x86 system images for better performance

**Network Issues:**
- Ensure internet connection is available
- Check firewall settings
- Verify API endpoints are accessible

### Running from Command Line

#### Using Gradle:
```bash
# Debug build
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Run tests
./gradlew test
```

#### Using ADB:
```bash
# Install APK
adb install app/build/outputs/apk/debug/app-debug.apk

# Launch app
adb shell am start -n com.example.shaadidemoapp/.dashboard.MatchMateActivity
```

### Performance Tips

- **Use Release Build**: For better performance, use `./gradlew assembleRelease`
- **Enable R8**: For code shrinking and optimization
- **Use Physical Device**: Generally faster than emulator for testing
- **Close Other Apps**: Free up memory for better performance

---

**Note**: This is a demonstration app showcasing modern Android development practices. All user profiles are generated for demo purposes and do not represent real people.
