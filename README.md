# SpringAIDemo

![Build Status](https://img.shields.io/github/actions/workflow/status/ElishebaW/SpringAIDemo/ci.yml?branch=main)
![License](https://img.shields.io/github/license/ElishebaW/SpringAIDemo)
![Java Version](https://img.shields.io/badge/java-21%2B-blue)

A demonstration project for building AI-powered applications using Spring Boot and local Large Language Models (LLMs) via Spring AI and Ollama. Includes REST APIs for chat and recipe generation, and a React-based frontend for interactive use.

---

## 🚀 Key Features

- **Chatbot API**: Conversational endpoint powered by local LLMs
- **Recipe Generation**: Generate recipes using AI
- **Spring AI Integration**: Uses Spring AI Starter and Ollama for local LLM inference
- **RESTful Backend**: Built with Spring Boot, easy to extend
- **React Frontend**: (in `recipe-creator-frontend/`) for user interaction
- **Easy Local Development**: Simple Maven and npm setup

---

## 🛠️ Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+
- Node.js 18+ (for frontend)
- npm 9+

### 1. Clone the Repository
```sh
git clone https://github.com/ElishebaW/SpringAIDemo.git
cd SpringAIDemo
```

### 2. Start the Spring Boot Backend
```sh
mvn clean install
mvn spring-boot:run
```
- Backend runs on `http://localhost:8080`

### 3. Start the React Frontend
```sh
cd recipe-creator-frontend
npm install
npm start
```
- Frontend runs on `http://localhost:3000`

---

## 💬 Example Usage

- **Chatbot:**
  - Send a POST request to `/api/chat` with a prompt to get an AI-generated response.
- **Recipe Generation:**
  - Use the frontend or POST to `/api/recipe` to generate a recipe from ingredients.

---

## 🧪 Running Tests

### Backend (Spring Boot)
```sh
mvn test
```

### Frontend (React)
```sh
cd recipe-creator-frontend
npm test
```

---

## 📁 Project Structure

```
SpringAIDemo/
├── recipe-creator-frontend/   # React frontend for recipe creation and chat
├── src/
│   ├── main/
│   │   ├── java/com/ai/SpringAIDemo/  # Backend Java code
│   │   ├── resources/                 # application.properties, templates, static
│   └── test/                          # Test code
├── pom.xml              # Maven config for backend
├── README.md            # This file
└── ...
```

---

## 📝 Notes
- Uses [Spring AI](https://github.com/spring-projects/spring-ai) and [Ollama](https://ollama.com/) for local LLM support.
- All sensitive files and build artifacts are excluded via `.gitignore`.
- See `HELP.md` for additional Spring Boot help and documentation.

---

## 🤝 Contributing
Pull requests and issues are welcome!

---

## 📜 License
MIT
