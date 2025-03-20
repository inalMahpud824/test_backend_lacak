# Geoname Suggestion API

Geoname Suggestion API adalah layanan berbasis Spring Boot yang menyediakan saran nama tempat berdasarkan kesamaan nama dan kedekatan lokasi.

## Fitur
- Mencari tempat berdasarkan nama (dengan pencocokan fuzzy menggunakan **Jaro-Winkler Similarity**)
- Menghitung skor berdasarkan kemiripan nama dan kedekatan lokasi
- Mengembalikan hasil dalam format JSON dengan urutan berdasarkan skor tertinggi
- Menangani kasus ketika tidak ada hasil yang ditemukan

## Teknologi yang Digunakan
- **Spring Boot** - Framework utama backend
- **Spring Data JPA** - Untuk interaksi dengan database
- **mysql** (atau database lain) - Untuk menyimpan data geoname
- **Apache Commons Text** - Untuk perhitungan Jaro-Winkler Similarity

## Instalasi dan Menjalankan Proyek
### Prerequisites
- Java 17 atau lebih baru
- Maven

### Cara Menjalankan
1. **Clone repository**
   ```sh
   git clone <repo-url>
   cd <nama-folder>
   ```
2. **Build proyek**
   ```sh
   mvn clean install
   ```
3. **Jalankan aplikasi**
   ```sh
   mvn spring-boot:run
   ```

Aplikasi akan berjalan di `http://localhost:8080`.

## Endpoint API
### 1. Mendapatkan Saran Nama Tempat
**Endpoint:**
```
GET /api/suggestions?q={nama}&latitude={lat}&longitude={lon}
```

**Contoh Request:**
```
GET /api/suggestions?q=London&latitude=42.98&longitude=-81.23
```

**Contoh Response:**
```json
{
  "suggestions": [
    {
      "name": "London, ON, Canada",
      "latitude": "42.98339",
      "longitude": "-81.23304",
      "score": 0.9
    },
    {
      "name": "London, OH, USA",
      "latitude": "39.88645",
      "longitude": "-83.44825",
      "score": 0.5
    }
  ]
}
```

### 2. Jika Tidak Ada Hasil
Jika tidak ada tempat yang cocok, API akan mengembalikan response berikut:
```json
{
  "suggestions": []
}
```

## Struktur Proyek
```
/src/main/java/com/mahpud/inal/
├── controller/        # Mengelola request dari pengguna
├── dto/              # Data Transfer Object (GeonameDTO, GeonameResponse)
├── model/entity/     # Definisi model database
├── model/repositories/ # Repository untuk mengakses database
├── services/         # Logika bisnis utama (GeonameServices)
└── InalApplication.java  # Main class untuk menjalankan Spring Boot
```

## Kontributor
- **Inal Mahpud** - Backend Developer

## Lisensi
Proyek ini dirilis di bawah lisensi MIT.

