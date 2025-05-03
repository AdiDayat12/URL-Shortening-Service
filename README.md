# 🔗 URL Shortening Service

A simple **Spring Boot** project for shortening long URLs, offering both:
- ✅ REST API for full CRUD functionality
- ✅ Web interface (form) using Thymeleaf for URL shortening

---

## ✅ Features

- Shorten long URLs
- Retrieve original URL via short code
- Update or delete shortened URLs
- Count URL clicks (visit tracking)
- Simple HTML form to shorten URLs

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Thymeleaf

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/AdiDayat12/URL-Shortening-Service.git
cd URL-Shortening-Service
```
---
## 📡 API Endpoints
| Method | Endpoint           | Description                |
| ------ | ------------------ | ------------------------ |
| POST   | `/shorten`             | Save & create short code |
| GET    | `/shorten/{shortCode}` | Retrieve original URL    |
| PUT    | `/shorten/{shortCode}` | Update URL               |
| DELETE | `/shorten/{shortCode}` | Delete URL               |
| Get    | `/shorten/stats/{shortCode}` | Get URL stat       |

---
## Project URL
https://roadmap.sh/projects/url-shortening-service
---
## ✨ Author
Built by [@AdiDayat12](https://github.com/AdiDayat12)
