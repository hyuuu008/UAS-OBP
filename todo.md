# Perubahan Kode Terbaru

## Masalah yang Ditemukan
Aplikasi Spring Boot tidak menampilkan tampilan ketika diakses di URL root (localhost:8096/). Hal ini terjadi karena tidak ada mapping untuk path "/" di controller mana pun.

## Kode yang Diubah
File: `src/main/java/com/example/demospringboot/controller/LoginController.java`

Perubahan:
- Menambahkan method baru `homePage()` dengan annotation `@GetMapping("/")`
- Method ini mengembalikan `redirect:/login` untuk mengarahkan pengguna ke halaman login saat mengakses URL root.

## Penjelasan
Sebelum perubahan, ketika pengguna mengakses `http://localhost:8096/`, aplikasi tidak memiliki handler untuk path tersebut, sehingga tidak ada tampilan yang muncul. Dengan menambahkan mapping root yang mengarahkan ke `/login`, sekarang aplikasi akan otomatis mengarahkan pengguna ke halaman login saat pertama kali mengakses aplikasi.

## Cara Menggunakan
1. Jalankan aplikasi Spring Boot
2. Akses `http://localhost:8096/` di browser
3. Akan otomatis diarahkan ke halaman login
4. Masukkan kredensial untuk masuk ke aplikasi

## Jawaban untuk Pertanyaan: Kenapa demospringboot aku ga muncul?
Berdasarkan investigasi kode dan konfigurasi aplikasi, berikut adalah kemungkinan alasan mengapa aplikasi Spring Boot "demospringboot" tidak muncul atau tidak dapat diakses:

### 1. **Aplikasi Tidak Berjalan**
   - Pastikan aplikasi Spring Boot sedang berjalan. Jalankan dengan perintah `mvn spring-boot:run` di terminal, atau dari IDE (misalnya IntelliJ IDEA atau Eclipse) dengan menjalankan class `DemospringbootApplication.java`.
   - Jika aplikasi gagal start, periksa log konsol untuk error (misalnya koneksi database gagal).

### 2. **Masalah Koneksi Database**
   - Aplikasi menggunakan MySQL database dengan konfigurasi di `application.properties`:
     - URL: `jdbc:mysql://localhost:3306/restoran`
     - Username: `root`
     - Password: (kosong)
   - Pastikan MySQL server berjalan di localhost port 3306.
   - Pastikan database `restoran` sudah dibuat. Jika belum, buat dengan query SQL: `CREATE DATABASE restoran;`
   - Jika password MySQL root tidak kosong, update `application.properties`.

### 3. **Port Sudah Digunakan**
   - Aplikasi dikonfigurasi untuk berjalan di port 8096 (`server.port=8096`).
   - Pastikan port 8096 tidak digunakan oleh aplikasi lain. Jika konflik, ubah port di `application.properties` atau hentikan aplikasi lain yang menggunakan port tersebut.

### 4. **Template atau Static Files Tidak Ditemukan**
   - Aplikasi menggunakan Thymeleaf untuk template HTML.
   - Pastikan file template seperti `Login.html` ada di `src/main/resources/templates/`.
   - Jika mengakses `http://localhost:8096/`, seharusnya redirect ke `http://localhost:8096/login` dan menampilkan halaman login.

### 5. **Browser Cache atau URL Salah**
   - Bersihkan cache browser.
   - Pastikan mengakses URL yang benar: `http://localhost:8096/` (dengan slash di akhir).
   - Jika masih tidak muncul, coba akses langsung `http://localhost:8096/login`.

### 6. **Error Saat Runtime**
   - Jika aplikasi start tapi halaman tidak muncul, periksa browser developer tools (F12) untuk error JavaScript atau network issues.
   - Pastikan semua dependencies di `pom.xml` terinstall (jalankan `mvn clean install`).

### Langkah Troubleshooting:
1. Jalankan aplikasi dan periksa log startup.
2. Pastikan MySQL running dan database tersedia.
3. Akses `http://localhost:8096/login` langsung untuk test.
4. Jika masih bermasalah, berikan detail error dari log aplikasi atau browser.
