apk - https://drive.google.com/file/d/1_uubE8kYaYrJ5nhpryw5VWzfl022qcLA/view?usp=sharing

# Kotlin Multiplatform (KMP) Assignment

This project is a **Kotlin Multiplatform (KMP) mobile app** that fetches **data breaches** from the **Have I Been Pwned API** and displays them in a **LazyColumn list** using Ktor for networking and Jetpack Compose for UI.

---

## 📌 Features
✅ Fetches **data breach information** from a REST API using **Ktor**.  
✅ Uses **Kotlin Multiplatform (KMP)** to support both **Android & iOS**.  
✅ Implements **MVVM architecture** with **Koin Dependency Injection**.  
✅ Displays data in a **Jetpack Compose LazyColumn**.  
✅ Handles **network errors gracefully** (e.g., no internet, API failures).  
✅ Extracts **text from HTML links** in the breach descriptions.  

---

## 🏗️ **Project Structure**

### **1️⃣ Networking (Fetching API Data)**
📌 **File:** `BreachRepository.kt`  
- Uses **Ktor** to fetch data from the API.  
- Parses the response into `BreachDto`, which is mapped to `Breach`.  
- Handles **serialization errors** and **network failures** gracefully.  

📌 **Code Example:**
```kotlin
suspend fun getBreaches(): Result<List<Breach>, NetworkError> {
    return try {
        val response = client.get(apiUrl)
        val dtos = response.body<List<BreachDto>>() // Deserialize API response
        val breaches = dtos.map { it.toBreach() } // Convert DTOs to app models
        Result.Success(breaches)
    } catch (e: UnresolvedAddressException) {
        Result.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        Result.Error(NetworkError.SERIALIZATION)
    }
}
```

2️⃣ ViewModel (Business Logic)
📌 File: BreachViewModel.kt

- Manages data fetching and stores the results in a StateFlow.
- Uses viewModelScope.launch {} to fetch data asynchronously.

3️⃣ Dependency Injection (Koin)
📌 File: AppModule.kt

- Sets up Ktor’s HttpClient.
- Provides Repository and ViewModel instances for dependency injection.

4️⃣ UI (Jetpack Compose)
📌 File: BreachListScreen.kt

- Observes ViewModel data and updates the UI.
- Uses LazyColumn to display breaches dynamically.
- Handles Loading & Error states
