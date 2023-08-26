#!/usr/bin/python3

import subprocess
import os

def main():
    try:
        # İlgili Paketler Kuruluyor
        print("İlgili Paketler Kuruluyor")
        subprocess.run(["sudo", "apt", "--fix-broken", "install"], check=True)
        subprocess.run(["sudo", "apt-get", "install", "python3-pip", "python3-opencv", "python3-pyqt5", "tesseract-ocr", "libtesseract-dev", "libleptonica-dev", "pkg-config", "-y"], check=True)

        # İlgili Kütüphaneler Kuruluyor
        print("\nİlgili Kütüphaneler Kuruluyor")
        subprocess.run(["pip3", "install", "--upgrade", "pip", "pillow", "pytesseract"], check=True)

        # yolov7/requirements.txt dosyasındaki bağımlılıklar kuruluyor
        print("\nyolov7/requirements.txt dosyasındaki bağımlılıklar kuruluyor")
        subprocess.run(["pip", "install", "-r", "yolov7_kaynak/requirements.txt"], check=True)

        # yolov7/veri_tabani/ dizinindeki script çalıştırılıyor
        print("\nyolov7/veri_tabani/ dizinindeki script çalıştırılıyor")
        os.chdir("yolov7_kaynak/veri_tabani/")
        subprocess.run(["python3", "tablo_olustur.py"], check=True)

    except subprocess.CalledProcessError as e:
        print("Hata oluştu:", e)
        print("Program durduruluyor.")

if __name__ == "__main__":
    main()

